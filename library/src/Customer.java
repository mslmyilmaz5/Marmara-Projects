package ooex1;

public class Customer extends Person {
   
	private String address;
	private Book borrowedBook;
	private boolean borrowABook;
	
	
	Customer(String name,String birthPlace
			,int birthDate,String address){
		
		super(name,birthDate,birthPlace);
		this.address = address;	
	}
	
	Customer(String name, int birthDate,String address){
		super(name,birthDate);
		this.address = address;
	}
	
	Customer(String name, String address){
		super(name);
		this.address = address;
	}
    
	Customer(String name, int birthDate){
		super(name,birthDate);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	public boolean isBorrowABook() {
		return borrowABook;
	}

	public void setBorrowABook(boolean borrowABook) {
		this.borrowABook = borrowABook;
	}
	
	public String toString() {
		if ( address == null ) address="-";
		return super.toString() + ", Address: " + address;
	}
	
}
