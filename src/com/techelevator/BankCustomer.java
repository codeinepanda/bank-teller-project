package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
	private static final DollarAmount VIP_BALANCE_THRESHOLD = new DollarAmount(2499999);
	
	private String name;
	private String address;
	private String phoneNumber;
	private List<BankAccount> accounts;
	
	public BankCustomer ( String name , String address , String phoneNumber ) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accounts = new ArrayList<>();
	}
	
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void addAccount (BankAccount newAccount) {
		if (newAccount != null) {
			accounts.add(newAccount);
		}
	}
	
	public List<BankAccount> getAccounts() {
		return new ArrayList<>(accounts);
	}
	
	public boolean isVIP() {
		DollarAmount sumOfAllAccounts = DollarAmount.ZERO_DOLLARS;
		for (BankAccount account : accounts) {
			sumOfAllAccounts = sumOfAllAccounts.plus(account.getBalance());
		}
		return sumOfAllAccounts.isGreaterThan(VIP_BALANCE_THRESHOLD);
		
	}

}
