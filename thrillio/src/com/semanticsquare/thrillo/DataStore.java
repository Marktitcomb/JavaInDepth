package com.semanticsquare.thrillo;

import com.semanticsquare.thrillo.entities.*;
import com.semanticsquare.thrillo.managers.*;
import com.semanticsquare.thrillo.constants.*;

public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPE_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;

	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPE_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[] userbookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;
	
	
	public static User[] getUsers() {
		return users;
	}
	
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	
	public static void loadData() {

		loadUsers();
		loadWeblinks();
		loadMovies();
		loadBooks();

	}

	public static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
				Gender.MALE, UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001, "user0@semanticsquare.com", "test", "Sam", "M",
				Gender.MALE, UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002, "user0@semanticsquare.com", "test", "Anita", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003, "user0@semanticsquare.com", "test", "Sarah", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1004, "user0@semanticsquare.com", "test", "Dheeru", "M",
				Gender.MALE, UserType.CHIEF_EDITOR);
	}

	public static void loadWeblinks() {

		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2000, "Taming lion , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2000, "weblink3",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2000, "weblink4",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2000, "weblink5",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");	
	}
	

	
	public static void loadMovies() {
		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(
				3000, "Citizen Kane","", 1941, new String[]{"Orson Welles","Joseph Cotten"},new String[] { "Orson Welles"},MovieGenre.CLASSICS, 8.5);
		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(
				3001, "The Grapes of Wrath","", 1941, new String[]{"Henry Fonda","Jane Darwell"},new String[] { "John Ford"},MovieGenre.CLASSICS, 8.2);
		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(
				3002, "TA Touch of Greatness","", 1955, new String[]{"xyz","dfggdf"},new String[] { "John Ford"},MovieGenre.DRAMA, 8.2);
		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(
				3003, "The Big Bang Theory","", 1955, new String[]{"xyz","dfggdf"},new String[] { "John Ford"},MovieGenre.DRAMA, 8.5);
		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(
				3004, "Ikiru","", 1955, new String[]{"xydfgz","dfgdfgggdf"},new String[] { "John Ford"},MovieGenre.COMEDIES, 8.9);
		
	} 
	

	public static void loadBooks() {
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, new String[] {"WilderPublications"}, 
				"Philosophy", 4.3);
		bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Walden", 1864, new String[] {"book2"}, 
				"Drama", 5.1);
		bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Walden", 1884, new String[] {"book3"}, 
				"Thriller", 4.6);
		bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Walden", 1824, new String[] {"book4"}, 
				"Thriller", 6.3);
		bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Walden", 1804, new String[] {"book5"}, 
				"Drama", 5.0);
		
	}

	public static void add(UserBookmark userBookmark) {
		
	userbookmarks[bookmarkIndex] = userBookmark; 
	bookmarkIndex ++;
	
	}

	

}

