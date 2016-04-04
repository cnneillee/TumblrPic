package com.neil.tumblrpic;

import android.app.Application;

import com.neil.tumblrpic.util.UniversalAndroidImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Neil on 2016/4/4.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        //Initialize ImageLoader with configuration.
        UniversalAndroidImageLoader.init(getApplicationContext());
        ImageLoader.getInstance().init(configuration);
    }
}
