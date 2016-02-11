package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	final DollarAmount serviceCharge = new DollarAmount(200);
	final DollarAmount serviceChargeStart = new DollarAmount(15000);
	final static DollarAmount overdraftStart = new DollarAmount(0);

	public SavingsAccount(String accountHolderName, String accountNumber, DollarAmount balance) {
		super(accountHolderName, accountNumber, balance);
		
	}

	// Savings Account if current bal is below $150.00, $2.00 charge
	
	public void transfer (SavingsAccount destinationAccount, DollarAmount transferAmount) {				// destination BankAccount instead?
		DollarAmount balance = this.getBalance();
		
		if (!(balance.minus(transferAmount).minus(serviceCharge).isLessThan(serviceChargeStart))) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount).minus(serviceChargeStart).isGreaterThan(overdraftStart)) {
			this.withdraw(transferAmount).minus(serviceCharge);
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		DollarAmount balance = this.getBalance();
		
		if (!(balance.minus(amountToWithdraw).minus(serviceCharge).isLessThan(serviceChargeStart))) {
			this.withdraw(amountToWithdraw);
			
			
		} else if (balance.minus(amountToWithdraw).minus(serviceCharge).isGreaterThan(overdraftStart)) {
			this.withdraw(amountToWithdraw).minus(serviceCharge);
			
		} 
		return balance;
		
		
	}
	
	
	
	

}
