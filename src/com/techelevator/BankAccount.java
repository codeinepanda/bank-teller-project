package com.techelevator;

public class BankAccount {

	private String accountHolderName;
	private String accountNumber;
	private DollarAmount balance;
	
	public BankAccount  (String accountHolderName , String accountNumber , DollarAmount balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public DollarAmount getBalance() {
		return this.balance;
	}
	
	public DollarAmount deposit (DollarAmount amountToDeposit){
		balance = this.balance.plus(amountToDeposit);
		return balance;
		
	}
	
	public void transfer (BankAccount destinationAccount, DollarAmount transferAmount) {
		this.balance = balance.minus(transferAmount);
		destinationAccount.balance = destinationAccount.balance.plus(transferAmount);
		
	}

	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		balance = this.balance.minus(amountToWithdraw);
		return balance;
	}
	
}