package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;



public class SavingsAccountTest {
	
	private SavingsAccount theAccount;
	
	@Before		// this annotation tells JUnit to run this method before every test (setup method will run before every test	
	public void setup(){
		BankCustomer  aCustomer = new BankCustomer("John Doe", "123 Main St", "123-456-7890");
		theAccount = new SavingsAccount(aCustomer, "123456789");
		// every test will start with this new SavingsAccount with a balance of 0
	}

	@Test
	public void new_accounts_start_with_a_zero_balance() {

		DollarAmount currentBalance = theAccount.getBalance();
		DollarAmount zeroDollars = new DollarAmount(0);
		Assert.assertEquals(zeroDollars, currentBalance);
	}
	
	@Test
	public void deposit_increases_the_account_balance_by_the_amount_deposited(){

		DollarAmount amountDeposited = new DollarAmount(12345);
		DollarAmount newBalance = theAccount.deposit(amountDeposited);
		
		Assert.assertEquals(amountDeposited, newBalance);
		Assert.assertEquals(amountDeposited, theAccount.getBalance());
	}
	
	

}
