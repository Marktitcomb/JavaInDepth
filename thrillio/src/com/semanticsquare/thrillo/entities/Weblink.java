package com.semanticsquare.thrillo.entities;

import org.apache.commons.lang3.StringUtils;

import com.semanticsquare.thrillo.partner.Sharable;

public class Weblink extends Bookmark implements Sharable{
	private long id;
	private String title;
	public String url;
	private String host;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "Weblink [id=" + id + ", title=" + title + ", url=" + url + ", host=" + host + "]";
	}

	@Override
	//and we created this function user test driven development
	public boolean isKidFriendlyEligable() {
		if (url.contains("porn") || getTitle().contains("porn")|| getHost().contains("adult")) {
			return false; 
		}
		
		return true;
		
	}

	@Override
	public String getItemData() {

		StringBuilder builder = new StringBuilder();
		builder.append("<Item>");
		builder.append("<Type>WebLink</Type>");
		builder.append("<Title>").append(getTitle()).append("</Title>");
		builder.append("<url>").append(url).append("</Authors>");
		builder.append("<host>").append(getHost()).append("</Publisher>");
	

		builder.append("</Item>");

		return builder.toString();
 
	}

}
