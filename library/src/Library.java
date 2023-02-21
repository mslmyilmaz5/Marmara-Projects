package ooex1;

import java.util.ArrayList;
import java.util.Collections;


public class Library {
	
	private String adress;
	
    
	private ArrayList <Book> books = new ArrayList<>();
    private ArrayList <Customer> customers = new ArrayList<>();
    private ArrayList <Book> booksCpy = new ArrayList<>();
    
    
  
    
    public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
    public Library(String adress) {
    	this.adress = adress;
    }
    
    public static void printOpeningHours() {
    	System.out.println("Libraries are open daily"
    			+ "from 9 am to 5 pm");
    }
    
    public void printAddress() {
    	System.out.println(adress);
    }
    
    public boolean  addBook(Book book) {
    	
    	books.add(book);
    	booksCpy.add(book);
    	return true;
    }
    
    public void addCustomer(Customer customer) {
    	 customers.add(customer);
    }
    
    public void printList() {
    	System.out.println(books);
    }
    
    public ArrayList<Book> getBooks(){
    	return books;
    }
    
    public ArrayList<Book> getBooksCpy(){
    	return booksCpy;
    }
    
    public ArrayList<Customer> getCustomers(){
    	return customers;
    }
  
    
    public void borrowBook(String bookName,String personName) {
       
    	
    	
    	int bookIndex = -1;
    	int costumerIndex = -1;
    	boolean isBookOk = false;
    	boolean isCustOk = false;
    	boolean isInTheList = false;
    	
    	for ( int i = 0; i < books.size(); i++ ) {
    		if (getBooks().get(i).getTitle() == bookName) {
    			  isBookOk = true;
    			  bookIndex = i;
    	          break;
    		}
    	}
    	
    	for ( int i = 0; i < customers.size(); i++ ) {
    		if (getCustomers().get(i).getName() == personName) {
    			  isCustOk = true;
    			  costumerIndex = i;
    	          break;
    		}
    	}
    	
    	for ( int i = 0; i < books.size(); i++ ) {
    		if (getBooksCpy().get(i).getTitle() == bookName) {
    			  isInTheList = true;
    	          break;
    		}
    	}
    	
    	if (isBookOk == true && isCustOk == true && getBooks().get(bookIndex).isBorrowed()== false
    			&& getCustomers().get(costumerIndex).isBorrowABook() == false) {
    		
    			 System.out.println(getCustomers().get(costumerIndex).getName()
    			 +" is successfully borrowed " + getBooks().get(bookIndex).getTitle());
    			 getBooks().get(bookIndex).setBorrowed(true);
    			 books.remove(bookIndex);
    			 getCustomers().get(costumerIndex).setBorrowABook(true);
    			 getCustomers().get(costumerIndex).setBorrowedBook(books.get(bookIndex));
    	}
    	else if (!isCustOk) {
    		System.out.println("Sorry, " +  personName + " is not a customer.");
    	}
    	else if (getCustomers().get(costumerIndex).isBorrowABook() == true) {
			 System.out.println("Sorry " + getCustomers().get(costumerIndex).getName() + " is already borrowed a book");
		}
    	else if (!isBookOk && isInTheList){
    		 System.out.println("Soory this book is already borrowed");
    	}
    	
    	else if (!isBookOk) {
    		System.out.println("Sorry, this book is not in our catalog");
    	}
    	else {
    		System.out.println(getCustomers().get(costumerIndex).getName()
       			 +" is successfully borrowed " + getBooks().get(bookIndex).getTitle());
    		 getBooks().get(bookIndex).setBorrowed(true);
			 books.remove(bookIndex);
			 
    	}
  
 	
    }
    public void printAvailableBooks() {
    	
    	ArrayList<Book> list = getBooks();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i).toString());
		} else {
			System.out.println("No book in catalog");
		}
		System.out.println();
    	
    }
    public void returnBook(String personName) {
    	
    	boolean isCustOk = false;
    	int custIndx = 0;
    	for ( int i = 0; i < customers.size(); i++ ) {
    		if (getCustomers().get(i).getName() == personName) {
    			custIndx = i;
    			isCustOk = true;
    			break;
    		}
    	}
    	
    	if (isCustOk && getCustomers().get(custIndx).isBorrowABook()) {
    		System.out.println(personName + " successfully returned"  
    	+ getCustomers().get(custIndx).getBorrowedBook().getTitle());
    		
    		books.add(getCustomers().get(custIndx).getBorrowedBook());
    		getCustomers().get(custIndx).setBorrowABook(false);
            
    		
    	}
    	
    	else if (!isCustOk) {
        	System.out.println("Sorry " + personName + " is not a customer" );
    	
        }
    	else if (!getCustomers().get(custIndx).isBorrowABook()) {
    		System.out.println("Sorry " + personName + " did not barrow a book");
    	}
    	
    }
    
    
    
}
