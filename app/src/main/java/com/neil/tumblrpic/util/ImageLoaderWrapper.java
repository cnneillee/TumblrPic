package com.neil.tumblrpic.util;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Neil on 2016/4/4.
 */
public interface ImageLoaderWrapper {
    /**
     * 显示 图片
     *
     * @param imageView 显示图片的ImageView
     * @param imageFile 图片文件
     * @param option    显示参数设置
     */
    void displayImage(ImageView imageView, File imageFile, DisplayOption option);

    /**
     * 显示图片
     *
     * @param imageView 显示图片的ImageView
     * @param imageUrl  图片资源的URL
     * @param option    显示参数设置
     */
    void displayImage(ImageView imageView, String imageUrl, DisplayOption option);

    /**
     * 图片加载参数
     */
    static class DisplayOption {
        /**
         * 加载中的资源id
         */
        public int loadingResId;
        /**
         * 加载失败的资源id
         */
        public int loadErrorResId;
    }

}
