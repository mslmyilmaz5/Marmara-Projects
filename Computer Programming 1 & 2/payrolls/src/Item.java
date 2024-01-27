package ooex2;

public class Item {

	  private int id;
	  public static int numberOfItems;
      
	  Item(int id){
		  this.id = id;
		  numberOfItems++;
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
