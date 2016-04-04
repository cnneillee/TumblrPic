package com.neil.tumblrpic.util;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImageLoaderThread extends Thread {
    private String urlStr;
    private URL url;

    ImageLoaderThread(String urlStr) {
        this.urlStr = urlStr;
    }

    @Override
    public void run() {
        super.run();
        try {
            url = new URL(urlStr);
            int code = -1;
            /*if (urlStr.contains("http://")) {
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                code = conn.getResponseCode();
            }else if (urlStr.contains("https://")){*/
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            code = conn.getResponseCode();


            if (code == 200) {
                String[] res = urlStr.split("/");
                String pathname = res[res.length - 1];
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File directory = Environment.getExternalStorageDirectory();
                    File dir = new File(directory.getAbsolutePath() + "//myV2ex//");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    File file = new File(dir.getAbsolutePath(), pathname);
                    FileOutputStream fos = new FileOutputStream(file);
                    InputStream is = conn.getInputStream();
                    byte[] b = new byte[1024];
                    while (is.read(b) >= 0) {
                        fos.write(b);
                    }
                    is.close();
                    fos.flush();
                    fos.close();
                    System.out.println(pathname + " 已完成");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}