package com.semanticsquare.thrillo.controllers;

import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.User;
import com.semanticsquare.thrillo.managers.BookmarkManager;

public class BookmarkController {
	
	private static BookmarkController instance = new BookmarkController();// variable to hold the instance
	
	
	private BookmarkController() {}
	
	public static BookmarkController getInstance() {
		return instance; 
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark); 
		
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
		
	}
	
	
}
