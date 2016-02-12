package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<BankCustomer> customers;
	
	public Bank(){
		customers = new ArrayList<>();
	}
	
	public void addCustomer(BankCustomer newCustomer) {
		customers.add(newCustomer);
	}
	
	public List<BankCustomer> getCustomers() {
		return customers;
	}
	
	/*
	public List<BankCustomer> getSingleCustomer(Integer i){
		return this.customers.getCustomers().get(i-1).getName();
	}
	*/
	
	public BankCustomer getCustomer(int i) {
		return customers.get(i);
	}
	
	
}
