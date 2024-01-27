package ooex1;

public class Author extends Person{

	private String publisher;
	

	Author(String name,String publisher,
			int birthDate){
		super(name,birthDate);
		this.setPublisher(publisher);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String toString() {
		return"Author is " + getName();
	}
	
	
}
