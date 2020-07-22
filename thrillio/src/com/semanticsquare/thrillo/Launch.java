package com.semanticsquare.thrillo;

import com.semanticsquare.thrillo.managers.*;
import com.semanticsquare.thrillo.dao.*; 
import com.semanticsquare.thrillo.entities.*;


public class Launch {
	private static User[] users; 
	private static Bookmark[][] bookmarks; 
	
	private static void loadData() {
		// TODO Auto-generated method stub
		System.out.println("1. Loading Data...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing Data...");
		//printUserData();
		//printBookmarkData(); 
	
	}

	
	private static void printBookmarkData() {
		for(Bookmark[] bookmarkList: bookmarks) {
			for(Bookmark bookmark: bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}


	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
		
	}
	
	
	private static void start() {
		//System.out.println("\nBookmarking...");
		for(User user: users) {
			View.browse(user, bookmarks); 
		}
		
	}

	public static void main(String [] args) {
		
		loadData(); 
		start();
	}


	


}
