package com.semanticsquare.thrillo.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.semanticsquare.thrillo.partner.Sharable;

public class Book extends Bookmark implements Sharable {
	private long id;
	private int publicationYear;
	private String publisher;
	private String[] author;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", author="
				+ Arrays.toString(author) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return super.getTitle();
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public String getProfileURL() {
		// TODO Auto-generated method stub
		return super.getProfileURL();
	}

	@Override
	public void setProfileURL(String profileURL) {
		// TODO Auto-generated method stub
		super.setProfileURL(profileURL);
	}

	@Override
	public boolean isKidFriendlyEligable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getItemData() {
		// returns information about a book in XML format xtensible markup language
		StringBuilder builder = new StringBuilder();
		builder.append("<Item>");
		builder.append("<Type>book</Type>");
		builder.append("<Title>").append(getTitle()).append("</Title>");
		builder.append("<Authors>").append(StringUtils.join(author, ",")).append("</Authors>");
		builder.append("<Publisher>").append(publisher).append("</Publisher>");
		builder.append("<PublicationYear>").append(publicationYear).append("</PublicationYear>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");

		builder.append("</Item>");

		return builder.toString();

	}

}
