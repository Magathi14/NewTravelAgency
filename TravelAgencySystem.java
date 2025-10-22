package travelagency;
import java.util.*;

public class TravelAgencySystem {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<TourPackage> packages = new ArrayList<>(); static ArrayList<Customer> customers = new ArrayList<>(); static ArrayList<Booking> bookings = new ArrayList<>(); static int packageCounter = 1;
	static int customerCounter = 1; static int bookingCounter = 1; static int paymentCounter = 1;
	public static void main(String[] args) { while (true) {
	System.out.println("\n===== Travel Agency Menu ====="); System.out.println("1. Add Tour Package");
	System.out.println("2. Add Itinerary Item"); System.out.println("3. Add Customer");
	 
	System.out.println("4. Create Booking"); System.out.println("5. Record Payment"); System.out.println("6. Cancel Booking");
	System.out.println("7. Display Packages & Availability"); System.out.println("8. Exit");
	System.out.print("Enter your choice: "); int choice = scanner.nextInt();
	scanner.nextLine(); switch (choice) {
	case 1 -> addTourPackage(); case 2 -> addItineraryItem(); case 3 -> addCustomer(); case 4 -> createBooking(); case 5 -> recordPayment(); case 6 -> cancelBooking(); case 7 -> displayPackages(); case 8 -> {
	System.out.println("Exiting... Thank you!"); System.exit(0);
	}
	default -> System.out.println("Invalid choice! Try again.");
	}
	}
	}
	static void addTourPackage() {
	System.out.print("Enter package name: "); String name = scanner.nextLine();
	System.out.print("Enter total seats: "); int seats = scanner.nextInt();
	System.out.print("Enter price per person: ");
	 
	double price = scanner.nextDouble(); scanner.nextLine();
	TourPackage tp = new TourPackage(packageCounter++, name, seats, price);
	packages.add(tp);
	System.out.println("Tour Package added successfully!");
	}
	static void addItineraryItem() { if (packages.isEmpty()) {
	System.out.println("No packages found! Add one first."); return;
	}
	System.out.print("Enter package ID: "); int id = scanner.nextInt();
	scanner.nextLine();
	TourPackage tp = findPackageById(id); if (tp == null) {
	System.out.println("Package not found!"); return;
	}
	System.out.print("Enter day number: "); int day = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter activity: "); String activity = scanner.nextLine(); System.out.print("Enter location: "); String location = scanner.nextLine();
	tp.addItineraryItem(new ItineraryItem(day, activity, location)); System.out.println("Itinerary item added successfully!");
	}
	static void addCustomer() {
	 
	System.out.print("Enter customer name: "); String name = scanner.nextLine();
	System.out.print("Enter email: "); String email = scanner.nextLine();
	System.out.print("Enter phone number: "); String phone = scanner.nextLine();
	Customer c = new Customer(customerCounter++, name, email, phone);
	customers.add(c);
	System.out.println("Customer added successfully!");
	}
	static void createBooking() {
	if (customers.isEmpty() || packages.isEmpty()) {
	System.out.println("Customers or Packages are missing!"); return;
	}
	System.out.print("Enter customer ID: "); int cid = scanner.nextInt();
	Customer customer = findCustomerById(cid); if (customer == null) {
	System.out.println("Customer not found!"); return;
	}
	System.out.print("Enter package ID: "); int pid = scanner.nextInt();
	scanner.nextLine();
	TourPackage tp = findPackageById(pid); if (tp == null) {
	System.out.println("Package not found!"); return;
	}
	 
	Booking b = new Booking(bookingCounter++, customer, tp); System.out.print("Enter number of travelers: ");
	int n = scanner.nextInt(); scanner.nextLine();
	ArrayList<Traveler> travelers = new ArrayList<>(); for (int i = 0; i < n; i++) {
	System.out.print("Enter traveler name: "); String tname = scanner.nextLine();
	System.out.print("Enter age: "); int age = scanner.nextInt();
	scanner.nextLine();
	System.out.print("Enter passport number: "); String pass = scanner.nextLine();
	travelers.add(new Traveler(tname, age, pass));
	}
	boolean success = b.addTravelers(travelers); if (success) {
	b.confirmBooking();
	bookings.add(b);
	} else {
	System.out.println("Not enough seats available!");
	}
	}
	static void recordPayment() { if (bookings.isEmpty()) {
	System.out.println("No bookings available!"); return;
	}
	System.out.print("Enter booking ID: ");
	 
	int bid = scanner.nextInt();
	Booking book = findBookingById(bid); if (book == null) {
	System.out.println("Booking not found!"); return;
	}
	Payment p = new Payment(paymentCounter++, book); p.makePayment();
	}
	static void cancelBooking() { if (bookings.isEmpty()) {
	System.out.println("No bookings to cancel!"); return;
	}
	System.out.print("Enter booking ID: "); int bid = scanner.nextInt();
	Booking book = findBookingById(bid); 
	if (book == null) {
	System.out.println("Booking not found!"); return;
	}
	Cancellation c = new Cancellation(book); c.processCancellation();
	bookings.remove(book);
	}
	static void displayPackages() { if (packages.isEmpty()) {
	System.out.println("No packages available!"); return;
	}
	 
	for (TourPackage tp : packages) tp.displayInfo();
	}
	static Customer findCustomerById(int id) {
	for (Customer c: customers) if (c.getCustomerId() == id) return c; return null;
	}
	static TourPackage findPackageById(int id) {
	for (TourPackage p : packages) if (p.getPackageId() == id) return p; return null;
	}
	static Booking findBookingById(int id) {
	for (Booking b : bookings) if (b.getBookingId() == id) return b; return null;
	}
	}

	


