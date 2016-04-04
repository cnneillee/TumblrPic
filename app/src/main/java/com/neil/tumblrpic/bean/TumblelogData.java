package com.neil.tumblrpic.bean;

/**
 * Created by Neil on 2016/4/4.
 */
public class TumblelogData {
    private String avatar_url;

    private String dashboard_url;

    private String url;

    private String name;

    private String cname;

    private String description;

    private String description_sanitized;

    private String title;

    private String uuid;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getDashboard_url() {
        return dashboard_url;
    }

    public void setDashboard_url(String dashboard_url) {
        this.dashboard_url = dashboard_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_sanitized() {
        return description_sanitized;
    }

    public void setDescription_sanitized(String description_sanitized) {
        this.description_sanitized = description_sanitized;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

