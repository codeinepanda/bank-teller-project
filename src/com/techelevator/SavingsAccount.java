package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	private static final DollarAmount SERVICE_CHARGE = new DollarAmount(200);
	private static final DollarAmount SERVICE_CHARGE_START = new DollarAmount(15000);
	private static final DollarAmount ZERO = new DollarAmount(-01);

	public SavingsAccount(BankCustomer accountHolder, String accountNumber /*, DollarAmount balance*/) {		// need to update to align with BankCustomer?
		super(accountHolder, accountNumber /*, balance*/);
		
	}

	// Savings Account if current bal is below $150.00, $2.00 charge for a transfer or withdraw
	
	public void transfer (SavingsAccount destinationAccount, DollarAmount transferAmount) {				// destination BankAccount instead?
		DollarAmount balance = this.getBalance();
		
		if (balance.isGreaterThanOrEqualTo(SERVICE_CHARGE_START) && balance.isGreaterThanOrEqualTo(transferAmount)) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount.plus(SERVICE_CHARGE)).isGreaterThan(ZERO)) {
			this.withdraw(transferAmount/*.plus(SERVICE_CHARGE)*/);
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw){
		DollarAmount balance = this.getBalance();
		
		if (balance.isGreaterThan(SERVICE_CHARGE_START) && balance.isGreaterThan(amountToWithdraw)) {
			return super.withdraw(amountToWithdraw);
			//return super.getBalance();	
			
		} else if (balance.minus(amountToWithdraw.plus(SERVICE_CHARGE)).isGreaterThan(ZERO)) {
			return super.withdraw(amountToWithdraw.plus(SERVICE_CHARGE));
			//return super.getBalance();
			
		} else {
			return super.getBalance();
		}
				
	}
	
	public String toString() {
		return "Savings Account "+getAccountNumber();
	}

	/*
	@Override
	public int compareTo(DollarAmount o) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/



}
