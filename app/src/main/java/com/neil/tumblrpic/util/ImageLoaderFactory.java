package com.neil.tumblrpic.util;

/**
 * Created by Neil on 2016/4/4.
 */
public class ImageLoaderFactory {
    private static ImageLoaderWrapper sInstance;

    private ImageLoaderFactory() {

    }

    /**
     * 获取图片加载器
     *
     * @return
     */
    public static ImageLoaderWrapper getLoader() {
        if (sInstance == null) {
            synchronized (ImageLoaderFactory.class) {
                if (sInstance == null) {
                    sInstance = new UniversalAndroidImageLoader();
                }
            }
        }
        return sInstance;
    }
}
