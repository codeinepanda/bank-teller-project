package com.techelevator;

public class BankAccount {
	/* *********Variables**********
	 * 
	 * String accountHolderName
	 * String accountNumber
	 * DollarAmount balance
	 * 
	 * ********Methods*************
	 * 
	 * getBalance() : DollarAmount								
	 * deposit(amountToDeposit : DollarAmount) : DollarAmount   // adds amountToDeposit to the current balance and returns the new balance
	 * transfer(destinationAccount : BankAccount , transferAmount : DollarAmount) : void	//withdraws transferAmount from this account and deposits the same amount in destinationAccount
	 * withdraw (amountToWithdraw : DollarAmount) : DollarAmount							// subtracts amountToWithdraw from the current balance and returns the new balance
	 *
	 ******************************/
	
	public String accountHolderName;  	// private?
	public String accountNumber;  		// private?
	public DollarAmount balance;  		// private?
	
	public BankAccount () {
		
	}
	
	
}
