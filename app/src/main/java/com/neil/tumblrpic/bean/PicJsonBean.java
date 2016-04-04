package com.neil.tumblrpic.bean;

/**
 * Created by Neil on 2016/3/28.
 */
public class PicJsonBean {
    /**
     * low_res : https://41.media.tumblr.com/4d4b9b8c9eab00d8160644ead078ad1f/tumblr_o4pz5clnU01v793apo1_500.jpg
     * high_res : https://41.media.tumblr.com/4d4b9b8c9eab00d8160644ead078ad1f/tumblr_o4pz5clnU01v793apo1_500.jpg
     * height : 750
     * width : 500
     */

    private String low_res;
    private String high_res;
    private int height;
    private int width;

    public String getLow_res() {
        return low_res;
    }

    public void setLow_res(String low_res) {
        this.low_res = low_res;
    }

    public String getHigh_res() {
        return high_res;
    }

    public void setHigh_res(String high_res) {
        this.high_res = high_res;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
