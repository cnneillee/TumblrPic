package com.neil.tumblrpic.bean;

/**
 * Created by Neil on 2016/4/4.
 */
public class Tag {
    private String url;
    private String title;

    @Override
    public String toString() {
        return url+"----"+title;
    }

    public Tag( ) {

    }
    public Tag(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
