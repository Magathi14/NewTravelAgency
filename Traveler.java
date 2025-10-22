package travelagency;

public class Traveler {
	private String name; private int age;
	private String passportNo;
	public Traveler(String name, int age, String passportNo) { this.name = name;
	this.age = age; this.passportNo = passportNo;
	}
	public void displayTraveler() {
	System.out.println("Traveler: " + name + ",n Age: " + age + ",\n Passport: " + passportNo);
	}
	}


