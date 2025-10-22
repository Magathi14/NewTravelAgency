package travelagency;
import java.util.ArrayList; 
import java.util.List; 

public class TourPackage {
	private int packageId; private String packagename; private int totseats;
	private int availseats;
	private double priceperperson; private List<ItineraryItem> itinerary;
	public TourPackage(int packageId, String packagename, int totseats, double priceperperson) {
	this.packageId = packageId; this.packagename = packagename; this.totseats = totseats; this.availseats = totseats;
	this.priceperperson = priceperperson; this.itinerary = new ArrayList<>();
	}
	public void addItineraryItem(ItineraryItem item) { itinerary.add(item);
	}
	public boolean bookSeats(int count) { if (availseats >= count) {
	availseats -= count; return true;
	}
	return false;}
	 
	public void cancelSeats(int count) { availseats += count;
	if (availseats > totseats) availseats = totseats;
	}
	public int getAvailableSeats() { return availseats;
	}
	public double getPricePerPerson() { return priceperperson;
	}
	public int getPackageId() { return packageId;
	}
	public void displayInfo() {
	System.out.println("packageID:" + packageId + ",\npackageName:" + packagename
	+
	",\nAvailable Seats:" + availseats + ",\nPrice:" + priceperperson);
	System.out.println("Itinerary:"); 
	for (ItineraryItem item : itinerary) {
	item.displayItem();
	}
	}
	}


