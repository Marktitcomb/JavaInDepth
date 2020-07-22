package com.semanticsquare.thrillo.dao;

import com.semanticsquare.thrillo.DataStore;
import com.semanticsquare.thrillo.entities.*;

public class BookmarkDao {
	public Bookmark [][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		//typically you'd have SQL here but instead we use Datastore
		
		DataStore.add(userBookmark);
		
		
	}
}
