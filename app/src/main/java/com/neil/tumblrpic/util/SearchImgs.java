package com.neil.tumblrpic.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.neil.tumblrpic.Constant;
import com.neil.tumblrpic.adapter.AdvTumblrImgAdapter;
import com.neil.tumblrpic.bean.MainImgBean;

import java.util.List;

/**
 * Created by Neil on 2016/4/4.
 */
public class SearchImgs {



    private static int pagecount = 1;

    public static void searchImgs(String keyword, Context context, AdvTumblrImgAdapter adapter) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("提示");
        pd.setMessage("正在加载...");
        pd.show();
        doSearchImgs(pd, adapter, keyword);
        pagecount = 1;
    }

    public static void searchOnImgs(String keyword, Context context, AdvTumblrImgAdapter adapter) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("提示");
        pd.setMessage("正在加载下一页...");
        pd.show();
        pagecount++;
        doSearchImgs(pd, adapter, keyword + Constant.URL_PAGE_ON + pagecount);
    }

    private static void doSearchImgs(final ProgressDialog pd,
                                     final AdvTumblrImgAdapter adapter, final String keyword) {
        new AsyncTask<Void, Void, List<MainImgBean>>() {
            private String url;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                url = getURL(keyword);
            }

            @Override
            protected List<MainImgBean> doInBackground(Void... params) {
                List<MainImgBean> list = UsingJsoup.searchImgsJsoup(url);
                return list;
            }

            @Override
            protected void onPostExecute(List<MainImgBean> list) {
                super.onPostExecute(list);
                for (MainImgBean imageBean : list) {
                    adapter.getmDatas().add(imageBean);
                }
                adapter.notifyDataSetChanged();
                Log.e("SEARCH", adapter.getCount() + "个item");
                pd.dismiss();
            }
        }.execute();
    }

    private static String getURL(String keyword) {
        return Constant.URL_SEARCH + keyword;
    }

}
