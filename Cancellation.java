package travelagency;

public class Cancellation {
	private Booking booking; private double cancellationFee; private double refundAmount;
	public Cancellation(Booking booking) {
	 
	this.booking = booking;
	}
	public void processCancellation() {
	int travelerCount = booking.getTravelerCount();
	double price = booking.getTourPackage().getPricePerPerson(); cancellationFee = price * 0.1 * travelerCount;
	refundAmount = (price * travelerCount) - cancellationFee; booking.cancelBooking(); System.out.println("Cancellation Fee: $" + cancellationFee
	+ ", Refund Amount: $" + refundAmount);
	}
	}



