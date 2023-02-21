package ooex2;

public class Payroll {

	 private int workHour;
	 private int itemCount;
	 
	 Payroll(int workHour, int itemCount){
		 this.workHour = workHour;
		 this.itemCount = itemCount;
	 }

	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	 
	public int calculateSalary() {
		
		return getWorkHour() * 3 + getItemCount() * 2;
		
	}
	
	public String toString() {
		return " The work hour is " + getWorkHour() + " and the produced item count is " + getItemCount();
	}
	 
	 
}
