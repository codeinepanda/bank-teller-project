package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;



public class SavingsAccountTest {
	
	private SavingsAccount theAccount;
	private SavingsAccount janeAccount;
	
	@Before		// this annotation tells JUnit to run this method before every test (setup method will run before every test	
	public void setup(){
		BankCustomer  aCustomer = new BankCustomer("John Doe", "123 Main St", "123-456-7890");
		theAccount = new SavingsAccount(aCustomer, "123456789");
		BankCustomer  bCustomer = new BankCustomer("Jane Doe", "321 Main St", "456-123-7890");
		janeAccount = new SavingsAccount(bCustomer, "987654321");
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
	
	@Test
	public void get_account_holder_gives_account_holder_name(){
		Assert.assertEquals("John Doe", theAccount.getAccountHolder().getName());
	}
	
	@Test
	public void get_account_holder_address_gives_account_holder_address(){
		Assert.assertEquals("123 Main St", theAccount.getAccountHolder().getAddress());
	}
	
	@Test
	public void get_account_number_gives_account_number(){
		Assert.assertEquals("123456789", theAccount.getAccountNumber());
	}
	
	@Test
	public void withdrawal_should_fail_if_balance_will_go_below_0(){
		DollarAmount amountWithdraw = new DollarAmount (1000);
		DollarAmount currentBalance = theAccount.getBalance();
		theAccount.withdrawal(amountWithdraw);
		
		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, currentBalance);
	}
	
	@Test
	public void withdrawal_should_take_amount_to_withdraw_out_of_account(){
		DollarAmount amountDeposited = new DollarAmount (25000);
		DollarAmount amountWithdraw = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (24000);
		
		theAccount.deposit(amountDeposited);
		theAccount.withdrawal(amountWithdraw);
		DollarAmount currentBalance = theAccount.getBalance();
		
		Assert.assertEquals(amountEnding, currentBalance);
	}
	
	@Test
	public void withdrawal_from_account_with_balance_under_150_takes_service_charge(){
		DollarAmount amountDeposited = new DollarAmount (10000);
		DollarAmount amountWithdraw = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (8800);
		
		theAccount.deposit(amountDeposited);
		theAccount.withdrawal(amountWithdraw);
		DollarAmount currentBalance = theAccount.getBalance();
		
		Assert.assertEquals(amountEnding, currentBalance);
	}
	
	@Test
	public void withdrawal_should_not_work_if_withdraw_amount_is_greater_than_balance(){
		DollarAmount amountDeposited = new DollarAmount (15100);
		DollarAmount amountWithdraw = new DollarAmount (15200);
		DollarAmount amountEnding = new DollarAmount (15100);
		
		theAccount.deposit(amountDeposited);
		theAccount.withdrawal(amountWithdraw);
		
		
		Assert.assertEquals(amountEnding, theAccount.getBalance());
	}
	
	@Test
	public void transfer_should_fail_if_balance_will_go_below_0(){
		DollarAmount amountTransfer = new DollarAmount (1000);
		
		theAccount.transfer(janeAccount, amountTransfer);
		
		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, theAccount.getBalance());
		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, janeAccount.getBalance());
	}
	
	@Test
	public void transfer_should_transfer_amount_to_transfer_out_of_account(){
		DollarAmount amountDeposited = new DollarAmount (25000);
		DollarAmount amountTransfer = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (24000);
		DollarAmount janeEnding = new DollarAmount (1000);
		
		theAccount.deposit(amountDeposited);
		theAccount.transfer(janeAccount, amountTransfer);
		
		Assert.assertEquals(amountEnding, theAccount.getBalance());
		Assert.assertEquals(janeEnding, janeAccount.getBalance());
	}
	
	@Test
	public void transfer_from_account_with_balance_under_150_takes_service_charge(){
		DollarAmount amountDeposited = new DollarAmount (10000);
		DollarAmount amountTransfer = new DollarAmount (1000);
		DollarAmount amountEnding = new DollarAmount (8800);
		DollarAmount janeEnding = new DollarAmount (1000);
		
		theAccount.deposit(amountDeposited);
		theAccount.transfer(janeAccount, amountTransfer);
		
		Assert.assertEquals(amountEnding, theAccount.getBalance());
		Assert.assertEquals(janeEnding, janeAccount.getBalance());
	}
	
	@Test
	public void transfer_should_not_work_if_transfer_amount_is_greater_than_balance(){
		DollarAmount amountDeposited = new DollarAmount (15100);
		DollarAmount amountTransfer = new DollarAmount (15200);
		DollarAmount amountEnding = new DollarAmount (15100);
		
		theAccount.deposit(amountDeposited);
		theAccount.transfer(janeAccount, amountTransfer);
		
		
		Assert.assertEquals(amountEnding, theAccount.getBalance());
		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, janeAccount.getBalance());
	}
	
	@Test
	public void to_string_should_return_account_type_and_account_number(){
		Assert.assertEquals("Savings Account 123456789", theAccount.toString());
	}

}
