package ooex2;

import java.util.Arrays;

public class Storage {
	
	private int capacity;
	private Item[] items;
	
	Storage(int capacity){
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	public void addItem( Item item) {
		 items = new Item[1];
		 items = Arrays.copyOf(items,items.length+1);
	     items[items.length-1]=item;
	}
	
	

}
