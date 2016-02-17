package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;



public class CheckingAccountTest {
	
	private CheckingAccount theCheckAccount;
	private CheckingAccount jane2Account;
	
	@Before		// this annotation tells JUnit to run this method before every test (setup method will run before every test	
	public void setup(){
		BankCustomer  aCustomer = new BankCustomer("John Doe", "123 Main St", "123-456-7890");
		theCheckAccount = new CheckingAccount(aCustomer, "2345678");
		BankCustomer  bCustomer = new BankCustomer("Jane Doe", "321 Main St", "456-123-7890");
		jane2Account = new CheckingAccount(bCustomer, "8765432");
		// every test will start with this new CheckingAccount with a balance of 0
	}

	@Test
	public void new_checking_account_has_starting_balance_of_0() {

		DollarAmount zeroDollars = new DollarAmount(0);
		Assert.assertEquals(zeroDollars, theCheckAccount.getBalance());
	}

	
	@Test
	public void deposit_increases_the_checking_balance_by_the_amount_deposited(){

		DollarAmount amountDeposited = new DollarAmount(12345);
		DollarAmount newBalance = theCheckAccount.deposit(amountDeposited);
		
		Assert.assertEquals(amountDeposited, newBalance);
		Assert.assertEquals(amountDeposited, theCheckAccount.getBalance());
	}
	
	
	@Test
	public void get_checking_holder_gives_account_holder_name(){
		Assert.assertEquals("John Doe", theCheckAccount.getAccountHolder().getName());
	}
	
	@Test
	public void get_checking_holder_address_gives_account_holder_address(){
		Assert.assertEquals("123 Main St", theCheckAccount.getAccountHolder().getAddress());
	}
	
	@Test
	public void get_checking_number_gives_account_number() {
		Assert.assertEquals("2345678", theCheckAccount.getAccountNumber());
	}
	
	@Test
	public void withdrawal_from_account_with_balance_under_150_takes_service_charge(){
		DollarAmount amountWithdraw = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (-2000);
		
		theCheckAccount.withdraw(amountWithdraw);
		
		Assert.assertEquals(amountEnding, theCheckAccount.getBalance());
	}
	@Test
	public void withdrawal_from_account_should_fail() {
		DollarAmount amountWithdraw = new DollarAmount (9001);
		theCheckAccount.withdraw(amountWithdraw);

		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, theCheckAccount.getBalance());
	}
	@Test
	public void withdrawal_from_account_should_withdraw() {
		DollarAmount amountWithdraw = new DollarAmount (100);
		theCheckAccount.deposit(amountWithdraw);
		theCheckAccount.withdraw(amountWithdraw);

		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, theCheckAccount.getBalance());
	}
	//#######Transfer######//
	
	@Test
	public void transfer_should_transfer_amount_to_transfer_out_of_account(){
		DollarAmount amountDeposited = new DollarAmount (25000);
		DollarAmount amountTransfer = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (24000);
		DollarAmount janeEnding = new DollarAmount (1000);
		
		theCheckAccount.deposit(amountDeposited);
		theCheckAccount.transfer(jane2Account, amountTransfer);
		
		Assert.assertEquals(amountEnding, theCheckAccount.getBalance());
		Assert.assertEquals(janeEnding, jane2Account.getBalance());
	}
	
	@Test
	public void transfer_from_account_with_just_service_fee(){
		DollarAmount amountDeposited = new DollarAmount (10000);
		DollarAmount amountTransfer = new DollarAmount (11000);
		DollarAmount amountEnding = new DollarAmount (-2000);
		DollarAmount janeEnding = new DollarAmount (11000);
		
		theCheckAccount.deposit(amountDeposited);
		theCheckAccount.transfer(jane2Account, amountTransfer);
		
		Assert.assertEquals(amountEnding, theCheckAccount.getBalance());
		Assert.assertEquals(janeEnding, jane2Account.getBalance());
	}
	
	@Test
	public void transfer_should_not_work_if_transfer_amount_is_greater_than_negative_$100(){
		DollarAmount amountTransfer = new DollarAmount (10000);
		
		theCheckAccount.transfer(jane2Account, amountTransfer);
		
		
		Assert.assertEquals(jane2Account.getBalance(), theCheckAccount.getBalance());
	}
	//###########//
	
	@Test
	public void to_string_should_return_account_type_and_account_number(){
		Assert.assertEquals("Checking Account 2345678", theCheckAccount.toString());
	}

	
	
}