package com.semanticsquare.thrillo.entities;

import java.util.Arrays;

public class Movie extends Bookmark {
	private long id;
	private int releaseYear;
	private String title;
	private String profileUrl;
	private String[] cast;
	private String[] directors;
	private String genre;
	private double imdbRating;

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", releaseYear=" + releaseYear + ", title=" + title + ", profileUrl=" + profileUrl
				+ ", cast=" + Arrays.toString(cast) + ", directors=" + Arrays.toString(directors) + ", genre=" + genre
				+ ", imdbRating=" + imdbRating + "]";
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
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
