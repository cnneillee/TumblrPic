package com.neil.tumblrpic.bean;

import java.util.ArrayList;
import java.util.List;

public class ExtraInfo {
	private String date;
	private String notes;
	private List<String> tags = new ArrayList<String>();
	private String caption;

	public ExtraInfo() {
	}

	public ExtraInfo(String date, String notes, List<String> tags,
					 String caption) {
		super();
		this.date = date;
		this.notes = notes;
		this.tags = tags;
		this.caption = caption;
	}

	@Override
	public String toString() {
		return date + "--" + notes + "--" + tags + "--" + caption;
	}

	public String getDate() {
		return date;
	}

	public String getNotes() {
		return notes;
	}

	public List<String> getTags() {
		return tags;
	}

	public String getCaption() {
		return caption;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setNotes(String nodes) {
		this.notes = nodes;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
