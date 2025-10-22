package travelagency;

public class Customer {
	private int customerId; private String customername; private String email;
	private String phone;
	public Customer(int customerId, String customername, String email, String phone) { this.customerId = customerId;
	this.customername = customername; this.email = email;
	this.phone = phone;
	}
	public int getCustomerId() { return customerId;
	}
	public String getcustomerName() { return customername;
	}
	public void displayCustomer() {
	System.out.println("Customer ID: " + customerId + ",\n Name: " + customername + ", \nEmail: " + email + ",\n Phone: " + phone);
	 
	}
	}


