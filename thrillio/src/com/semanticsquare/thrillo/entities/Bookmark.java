package com.semanticsquare.thrillo.entities;

import com.semanticsquare.thrillo.constants.KidFriendlyStatus;

public abstract class Bookmark {

	private long id;
	private String title;
	private String profileURL;
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User shareedBy; 

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

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileURL=" + profileURL + "]";
	}
	 
	public abstract boolean isKidFriendlyEligable();

	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getShareedBy() {
		return shareedBy;
	}

	public void setShareedBy(User shareedBy) {
		this.shareedBy = shareedBy;
	}

	
	

}
