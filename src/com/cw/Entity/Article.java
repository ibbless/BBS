package com.cw.Entity;

import java.util.Date;

public class Article {
	private int id;
	private User author;
	private Date postTime;
	private String content;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postDate) {
		this.postTime = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", postTime="
				+ postTime + ", content=" + content + "]";
	}

}
