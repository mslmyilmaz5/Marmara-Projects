package ooex1;

public class Book {
   
	private int id;
	private String title;
	private Author author;
	private boolean borrowed;
	
	Book(){
		borrowed = false;
	}
	
	Book(int id,String title,Author author){
		this.id = id;
		this.title= title;
		this.author = author;
	}
	
	Book(int id, String title){
		this.id = id;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}                   // borrowed false demek kitap suan var demek.

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public boolean isBorrowed() {
		if (borrowed == true) {
			return true; // eğer alındıysa avaliable değil.
		}
		else {
			return false;
		}
	}
	
	public boolean borrowed() {
		if (isBorrowed() == true ) return true;
		else return false;
	}
	
	public boolean returned() {
		
		if ( borrowed() == true) {
			setBorrowed(false);
			return true;
		}
		else {
			return false;
		}
		 
	}
	
	public String toString() {
		return "Book name is " + title +
				" Author is " + author.getName();
	}
}
