package travelagency;
import java.util.ArrayList;
import java.util.List; 

public class Booking {
	private int bookingId; private Customer customer;
	private TourPackage tourPackage; private List<Traveler> travelers; private boolean isConfirmed;
	public Booking(int bookingId, Customer customer, TourPackage tourPackage) { this.bookingId = bookingId;
	this.customer = customer; this.tourPackage = tourPackage; this.travelers = new ArrayList<>(); this.isConfirmed = false;
	}
	public boolean addTravelers(List<Traveler> travelerList) { if (tourPackage.bookSeats(travelerList.size())) {
	travelers.addAll(travelerList); return true;
	}
	return false;
	}


	public void confirmBooking() { if (!travelers.isEmpty()) {
	isConfirmed = true;
	 
	System.out.println("Booking confirmed! ID: " + bookingId);
	} else {
	System.out.println("Cannot confirm booking. No travelers added or seats unavailable.");
	}
	}
	public void cancelBooking() { tourPackage.cancelSeats(travelers.size()); System.out.println("Booking cancelled. Seats restored.");
	}
	public int getTravelerCount() { return travelers.size();
	}
	public int getBookingId() { return bookingId;
	}
	public TourPackage getTourPackage() { return tourPackage;
	}
	public boolean isConfirmed() { return isConfirmed;
	}
	public void displayBooking() {
	System.out.println("Booking ID: " + bookingId + ", Confirmed: " + isConfirmed); customer.displayCustomer();
	for (Traveler t : travelers) t.displayTraveler();
	}
	}



