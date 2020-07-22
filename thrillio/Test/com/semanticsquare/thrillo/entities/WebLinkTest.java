package com.semanticsquare.thrillo.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*; 

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillo.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligable() {
		//test1: porn in URL-- false
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendlyEligable =  weblink.isKidFriendlyEligable();
		
		assertFalse("For porn in URL isKidFriendlyEligable must return false", isKidFriendlyEligable);
		
		//test2: porn in title-- false 
		 
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligable=  weblink.isKidFriendlyEligable();
		
		assertFalse("For porn in Title isKidFriendlyEligable must return false", isKidFriendlyEligable);
		
		
		//test3: adult in host -- false
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adultjavaworld.com");
		
		isKidFriendlyEligable=  weblink.isKidFriendlyEligable();
		
		assertFalse("For adult in host isKidFriendlyEligable must return false", isKidFriendlyEligable);
		
		
		
		//test4: adult in URL but not in host -- true
		
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger , Part 2",
				"http://www.adultjavaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligable =  weblink.isKidFriendlyEligable();
		
		assertTrue("For adult in URL isKidFriendlyEligable must return true", isKidFriendlyEligable);
		
		//test5: adult in Title only -- true
		
		weblink = BookmarkManager.getInstance().createWeblink(2000, "Taming adult Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligable=  weblink.isKidFriendlyEligable();
		
		assertTrue("For adult in title isKidFriendlyEligable must return true", isKidFriendlyEligable);
		
	}

}
