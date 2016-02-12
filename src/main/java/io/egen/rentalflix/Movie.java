package io.egen.rentalflix;

/**
 * Entity representing a movie. Fields: id, title, year, language
 */

public class Movie {

	String id;
	String title;
	int year;
	String language;
	boolean isRented=false;
	
	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public Movie(String title, int year, String language) {
		super();
		this.title = title;
		this.year = year;
		this.language = language;
		this.isRented=false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
