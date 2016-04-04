package com.neil.tumblrpic.bean;

/**
 * Created by Neil on 2016/3/28.
 */
public class ArticleItemDataJson {

    private String id;

    private String type;

    private String root_id;

    private String tumblelog;

    private String tumblelog_key;

    private TumblelogData tumblelog_data;

    private Share_popover_data share_popover_data;

    private String post_id;

    private String tumblelog_name;

    private String reblog_key;

    private String direct_video;

    private String serve_id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoot_id() {
        return root_id;
    }

    public void setRoot_id(String root_id) {
        this.root_id = root_id;
    }

    public String getTumblelog() {
        return tumblelog;
    }

    public void setTumblelog(String tumblelog) {
        this.tumblelog = tumblelog;
    }

    public String getTumblelog_key() {
        return tumblelog_key;
    }

    public void setTumblelog_key(String tumblelog_key) {
        this.tumblelog_key = tumblelog_key;
    }

    public TumblelogData getTumblelog_data() {
        return tumblelog_data;
    }

    public void setTumblelog_data(TumblelogData tumblelog_data) {
        this.tumblelog_data = tumblelog_data;
    }

    public Share_popover_data getShare_popover_data() {
        return share_popover_data;
    }

    public void setShare_popover_data(Share_popover_data share_popover_data) {
        this.share_popover_data = share_popover_data;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getTumblelog_name() {
        return tumblelog_name;
    }

    public void setTumblelog_name(String tumblelog_name) {
        this.tumblelog_name = tumblelog_name;
    }

    public String getReblog_key() {
        return reblog_key;
    }

    public void setReblog_key(String reblog_key) {
        this.reblog_key = reblog_key;
    }

    public String getDirect_video() {
        return direct_video;
    }

    public void setDirect_video(String direct_video) {
        this.direct_video = direct_video;
    }

    public String getServe_id() {
        return serve_id;
    }

    public void setServe_id(String serve_id) {
        this.serve_id = serve_id;
    }


    class PinterestShareWindow {
        private String url;

        private String name;

        private String dimensions;

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

        public String getDimensions() {
            return dimensions;
        }

        public void setDimensions(String dimensions) {
            this.dimensions = dimensions;
        }
    }

    class Share_popover_data {
        private String tumblelog_name;

        private String embed_key;

        private String embed_did;

        private String post_id;

        private String root_id;

        private String post_url;

        private String post_tiny_url;

        private int is_private;

        private String twitter_username;

        private String permalink_label;

        private boolean show_reporting_links;

        private String abuse_url;

        private boolean show_pinterest;

        private PinterestShareWindow pinterest_share_window;

        private boolean show_reddit;

        private boolean show_flagging;

        public String getTumblelog_name() {
            return tumblelog_name;
        }

        public void setTumblelog_name(String tumblelog_name) {
            this.tumblelog_name = tumblelog_name;
        }

        public String getEmbed_key() {
            return embed_key;
        }

        public void setEmbed_key(String embed_key) {
            this.embed_key = embed_key;
        }

        public String getEmbed_did() {
            return embed_did;
        }

        public void setEmbed_did(String embed_did) {
            this.embed_did = embed_did;
        }

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getRoot_id() {
            return root_id;
        }

        public void setRoot_id(String root_id) {
            this.root_id = root_id;
        }

        public String getPost_url() {
            return post_url;
        }

        public void setPost_url(String post_url) {
            this.post_url = post_url;
        }

        public String getPost_tiny_url() {
            return post_tiny_url;
        }

        public void setPost_tiny_url(String post_tiny_url) {
            this.post_tiny_url = post_tiny_url;
        }

        public int getIs_private() {
            return is_private;
        }

        public void setIs_private(int is_private) {
            this.is_private = is_private;
        }

        public String getTwitter_username() {
            return twitter_username;
        }

        public void setTwitter_username(String twitter_username) {
            this.twitter_username = twitter_username;
        }

        public String getPermalink_label() {
            return permalink_label;
        }

        public void setPermalink_label(String permalink_label) {
            this.permalink_label = permalink_label;
        }

        public boolean isShow_reporting_links() {
            return show_reporting_links;
        }

        public void setShow_reporting_links(boolean show_reporting_links) {
            this.show_reporting_links = show_reporting_links;
        }

        public String getAbuse_url() {
            return abuse_url;
        }

        public void setAbuse_url(String abuse_url) {
            this.abuse_url = abuse_url;
        }

        public boolean isShow_pinterest() {
            return show_pinterest;
        }

        public void setShow_pinterest(boolean show_pinterest) {
            this.show_pinterest = show_pinterest;
        }

        public PinterestShareWindow getPinterest_share_window() {
            return pinterest_share_window;
        }

        public void setPinterest_share_window(PinterestShareWindow pinterest_share_window) {
            this.pinterest_share_window = pinterest_share_window;
        }

        public boolean isShow_reddit() {
            return show_reddit;
        }

        public void setShow_reddit(boolean show_reddit) {
            this.show_reddit = show_reddit;
        }

        public boolean isShow_flagging() {
            return show_flagging;
        }

        public void setShow_flagging(boolean show_flagging) {
            this.show_flagging = show_flagging;
        }
    }


}
