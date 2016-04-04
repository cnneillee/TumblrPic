package com.neil.tumblrpic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
<<<<<<< HEAD
import android.util.LruCache;
=======
>>>>>>> f7c65e9... Initial commit
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

/**
 * Created by Neil on 2016/3/18.
 */
public class ImageLoader {

<<<<<<< HEAD
    public static void loadImage(final ImageView iv, final String imgUrl,
                                 final LruCache<String, Bitmap> mMemoryCache) {
        new AsyncTask<Void, Void, Void>() {
            Bitmap bm = null;

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    //计算大小
                    bm = BitmapFactory.decodeStream(new URL(imgUrl).openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                iv.setImageBitmap(bm);
                if (bm != null) {
                    mMemoryCache.put(imgUrl, bm);
                }
            }
        }.execute();
    }


=======
>>>>>>> f7c65e9... Initial commit
    public static void loadImage(final ImageView iv, final String imgUrl) {
        new AsyncTask<Void, Void, Void>() {
            Bitmap bm = null;

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    //计算大小
                    bm = BitmapFactory.decodeStream(new URL(imgUrl).openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                iv.setImageBitmap(bm);
            }
        }.execute();
    }

    public static String getDateStr(long created) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(created);
        return cal.get(Calendar.YEAR) + "-" +
                (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " +
                cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);
    }
}
