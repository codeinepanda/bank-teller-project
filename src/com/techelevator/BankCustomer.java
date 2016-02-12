package com.techelevator;

public class BankCustomer {
	
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerPhone;
	
	public BankCustomer(String customerFirstName , String customerLastName , String customerAddress , String customerPhone) {
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	
	
	
	

}
