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
		
		if ((balance.minus(transferAmount).minus(overdraftFee).isGreaterThan(overdraftStart))) {
			
			super.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			//= destinationAccount.getBalance().plus(transferAmount);
			
		} else if (balance.minus(transferAmount).minus(overdraftFee).isGreaterThan(overdraftCutoff)) {
			super.withdraw(transferAmount);
			super.withdraw(overdraftFee);
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		DollarAmount balance = this.getBalance();
		
		if (!(balance.minus(amountToWithdraw).minus(overdraftFee).isLessThan(overdraftStart))) {
			super.withdraw(amountToWithdraw);
			
			
		} else if (balance.minus(amountToWithdraw).minus(overdraftFee).isGreaterThan(overdraftCutoff)) {
			super.withdraw(amountToWithdraw).minus(overdraftFee);
			
		} 
		return balance;
		
		
	}

	
	
	
	
	
	
		
	}
	


