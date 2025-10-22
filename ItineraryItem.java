package travelagency;

public class ItineraryItem {
	private int day; private String activity;
	private String location;
	public ItineraryItem(int day, String activity, String location) {
	 
	this.day = day; this.activity = activity; this.location = location;
	}
	public void displayItem() {
	System.out.println("Day " + this.day + ": " + this.activity + " at " + this.location);
	}
	}



