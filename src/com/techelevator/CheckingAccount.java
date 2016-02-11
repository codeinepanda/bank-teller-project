package com.techelevator;

public class CheckingAccount extends BankAccount {

	final DollarAmount overdraftFee = new DollarAmount(1000);
	final DollarAmount overdraftCutoff = new DollarAmount(-10000);
	final static DollarAmount overdraftStart = new DollarAmount(0);
	
	public CheckingAccount(String accountHolderName, String accountNumber, DollarAmount balance) {
		super(accountHolderName, accountNumber, balance);
	}

	public void transfer (CheckingAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount balance = this.getBalance();
		
		if (!(balance.minus(transferAmount).minus(overdraftFee).isLessThan(overdraftStart))) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount).minus(overdraftFee).isGreaterThan(overdraftCutoff)) {
			this.withdraw(transferAmount).minus(overdraftFee);
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		DollarAmount balance = this.getBalance();
		
		if (!(balance.minus(amountToWithdraw).minus(overdraftFee).isLessThan(overdraftStart))) {
			this.withdraw(amountToWithdraw);
			
			
		} else if (balance.minus(amountToWithdraw).minus(overdraftFee).isGreaterThan(overdraftCutoff)) {
			this.withdraw(amountToWithdraw).minus(overdraftFee);
			
		} 
		return balance;
		
		
	}
	
	
	
	
		
	}
	


