package ooex1;

public class Dictionary extends Book {
     
	private int definitions;
	
	Dictionary(int id,String title,Author author
			,int definitions){
		 super(id,title,author);
		 this.definitions = definitions;
		 
	}
	
	Dictionary(int id,String title, int definitions){
		super(id,title);
		this.definitions = definitions;
		
	}

	public int getDefinitions() {
		return definitions;
	}

	public void setDefinitions(int definitions) {
		this.definitions = definitions;
	}
	
	public String toString() {
		return "Dictionary Name is " + getTitle()+", "
				+ "definitions: " + definitions;
	}
	
	
}
