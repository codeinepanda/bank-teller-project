package com.techelevator;

public abstract class BankAccount {

	//private String accountHolderName;
	private BankCustomer accountHolder;
	private String accountNumber;
	private DollarAmount balance;
	
	public BankAccount  (/*String accountHolderName ,*/ BankCustomer accountHolder , String accountNumber /*, DollarAmount balance*/) {
		//this.accountHolderName = accountHolderName;
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = DollarAmount.ZERO_DOLLARS;
	}
	
	public DollarAmount getBalance() {
		//return this.balance;
		return balance;
	}
	
	public BankCustomer getAccountHolder() {
		return accountHolder;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public DollarAmount deposit (DollarAmount amountToDeposit){
		// balance = this.balance.plus(amountToDeposit);
		// return balance;
		balance = balance.plus(amountToDeposit);
		return balance;
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		//balance = this.balance.minus(amountToWithdraw);
		//return balance;
		balance = balance.minus(amountToWithdraw);
		return balance;
	}
	
	public void transfer (BankAccount destinationAccount, DollarAmount transferAmount) {
		//this.balance = balance.minus(transferAmount);
		//destinationAccount.balance = destinationAccount.balance.plus(transferAmount);
		this.withdraw(transferAmount);
		destinationAccount.deposit(transferAmount);
	}

		
}