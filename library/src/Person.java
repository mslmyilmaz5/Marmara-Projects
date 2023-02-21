package ooex1;

public class Person {
      
	private String name;
	private int birthDate;
	private String birthPlace;
	
	
	Person(){
		
	}

	Person(String name, int birthDate,
			String birthPlace){
		this.name=name;
		this.birthDate=birthDate;
		this.birthPlace=birthPlace;
	}
	
	Person(String name, int birthDate){
		this.name=name;
		this.birthDate=birthDate;
	}
	
	Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public String toString() {
		String strBirth = String.valueOf(birthDate);
		if (birthPlace == null) {
			birthPlace= "-";  
		}
		if ( birthDate == 0 ) {
			strBirth = "-";
		}
		
		return "Name: " + name + ", Birth Date: " + strBirth+
				", Birth Place: " + birthPlace;
	}
	
	
}
