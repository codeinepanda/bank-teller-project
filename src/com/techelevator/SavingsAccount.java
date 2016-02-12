package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	final DollarAmount serviceCharge = new DollarAmount(200);
	final DollarAmount serviceChargeStart = new DollarAmount(15000);
	final DollarAmount zero = new DollarAmount(-01);

	public SavingsAccount(String accountHolderName, String accountNumber, DollarAmount balance) {		// need to update to align with BankCustomer?
		super(accountHolderName, accountNumber, balance);
		
	}

	// Savings Account if current bal is below $150.00, $2.00 charge for a transfer or withdraw
	
	public void transfer (SavingsAccount destinationAccount, DollarAmount transferAmount) {				// destination BankAccount instead?
		DollarAmount balance = this.getBalance();
		
		if (balance.isGreaterThan(serviceChargeStart) && balance.isGreaterThan(transferAmount)) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount.plus(serviceCharge)).isGreaterThan(zero)) {
			this.withdraw(transferAmount.plus(serviceCharge));
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		DollarAmount balance = this.getBalance();
		
		if (balance.isGreaterThan(serviceChargeStart) && balance.isGreaterThan(amountToWithdraw)) {
			super.withdraw(amountToWithdraw);
			return super.getBalance();	
			
		} else if (balance.minus(amountToWithdraw.plus(serviceCharge)).isGreaterThan(zero)) {
			super.withdraw(amountToWithdraw.plus(serviceCharge));
			return super.getBalance();
			
		} else {
			return super.getBalance();
		}
				
	}

	@Override
	public int compareTo(DollarAmount o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
