package com.semanticsquare.thrillo;

import com.semanticsquare.thrillo.constants.KidFriendlyStatus;
import com.semanticsquare.thrillo.partner.Sharable;
import com.semanticsquare.thrillo.constants.UserType;
import com.semanticsquare.thrillo.controllers.BookmarkController;
import com.semanticsquare.thrillo.entities.Bookmark;
import com.semanticsquare.thrillo.entities.User;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getUserType() + " is browsing items");
		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					bookmarkCount++;

					BookmarkController.getInstance().saveUserBookmark(user, bookmark);
					System.out.println("New Item Bookmarked..." + bookmark);

				}

				// mark as Kid friendly
				//to share or to mark as kid friendly you need to be editor or chie editor
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligable()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}
					}

					// sharing!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Sharable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}

				}

			}
		}
	}
    //TODO; Below method simulate user input after IO we take input via console
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}
}
