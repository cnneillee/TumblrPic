package com.neil.tumblrpic.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neil on 2016/4/4.
 */
public class MainImgBean {
    private String id;
    private String src;
    private String desc;
    private String blogUrl;
    private List<Tag> tags = new ArrayList<Tag>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


}
