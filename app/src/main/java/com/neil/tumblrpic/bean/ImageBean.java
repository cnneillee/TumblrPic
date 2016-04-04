package com.neil.tumblrpic.bean;

public class ImageBean {

	private String id;
	private String src;
	private ExtraInfo extra;

	public ImageBean() {

	}

	public ImageBean(String id, String src, ExtraInfo extra) {
		this.id = id;
		this.src = src;
		this.extra = extra;
	}

	public String getId() {
		return id;
	}

	public String getSrc() {
		return src;
	}

	public ExtraInfo getExtra() {
		return extra;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setExtra(ExtraInfo extra) {
		this.extra = extra;
	}
}
