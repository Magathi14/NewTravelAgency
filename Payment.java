package travelagency;

public class Payment {
	private int paymentId; private Booking booking; private double amount; private String paymentStatus;
	public Payment(int paymentId, Booking booking) { this.paymentId = paymentId;
	this.booking = booking;
	double pricePerPerson = booking.getTourPackage().getPricePerPerson(); int travelerCount = booking.getTravelerCount();
	this.amount = pricePerPerson * travelerCount; this.paymentStatus = "Pending";
	}
	 
	public void makePayment() { paymentStatus = "Completed";
	System.out.println("Payment of $" + amount + " completed. Payment ID: " + paymentId);
	}
	public int getPaymentId() { return paymentId;
	}
	public Booking getBooking() { return booking;
	}
	public void setBooking(Booking booking) { this.booking = booking;
	}
	public double getAmount() { return amount;
	}
	public String getPaymentStatus() { return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus;
	}
	}



