package ooex2;

import java.util.Arrays;

public class Factory {
	
	private String name;
	private Employee[] employees;
	private Storage storage;
	private Payroll[] payrolls;
	private double itemPrice;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Payroll[] getPayrolls() {
		return payrolls;
	}
	public void setPayrolls(Payroll[] payrolls) {
		this.payrolls = payrolls;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	Factory(String name, int capacity, double itemPrice){
		this.name = name;
		this.storage = new Storage(capacity);
		this.itemPrice = itemPrice;
	}
	
	
	public double getRevenue() {
		return Item.numberOfItems * itemPrice;
	}
	
	
	public double getPaidSalaries() {
		int  total= 0;
		for ( int i = 0; i < payrolls.length; i++) {
			total += payrolls[i].calculateSalary();
		}
		return total;
	}
	
	
	
	
	public void addEmployee(Employee employee) {
		
		if ( employees == null) {
			employees = new Employee[1];
			employees[0] = employee;
			storage.addItem(employee.startShift()[0]);
			
		}
		else {
			
			employees = Arrays.copyOf(employees,employees.length+1);
		    employees[employees.length-1]=employee;
		    storage.addItem(employee.startShift()[employees.length-1]);
		    
		}
		
	}
	
	public void removeEmployee(int id ) {
		
		if ( employees == null) {
			System.out.println("There are no employees!");
		}
		else {
			boolean isIdOk = false;
			int empIndex = 0;
			for ( int i = 0; i < employees.length;i++) {
				
				if ( employees[i].getId() == id) {
					isIdOk = true;
					empIndex = i;
					break;
				}
			}
			if (!isIdOk) {
				System.out.println("Employee does not exist");
			}
			else {
				Employee rOne = employees[empIndex];
				
				for ( int i = empIndex; i < employees.length - 1; i++) {
					 
					 employees[i] = employees[i+1];
				}
				employees = Arrays.copyOf(employees,employees.length-1);
				
				
				addPayroll(rOne.endShift());
			    
			}
			
		}
	}
	
	private void addPayroll(Payroll payroll) {
		
		if ( payrolls == null) {
			payrolls = new Payroll[1];
			payrolls[0] = payroll;
		}
		else {
			payrolls = Arrays.copyOf(payrolls,payrolls.length+1);
			payrolls[payrolls.length-1]=payroll;
		}
	}
	
	
	
	

}
