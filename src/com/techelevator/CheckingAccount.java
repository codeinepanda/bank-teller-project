package com.techelevator;

public class CheckingAccount extends BankAccount {

	private static final DollarAmount OVERDRAFT_FEE = new DollarAmount(1000);
	private static final DollarAmount OVERDRAFT_LIMIT = new DollarAmount(-10001);
	private static final DollarAmount ZERO = new DollarAmount(-01);
	
	public CheckingAccount(BankCustomer accountHolder , String accountNumber /*, DollarAmount balance*/) {  // need to update to align with BankCustomer?
		super(accountHolder , accountNumber /*, balance*/);
	}

	
	public void transfer (BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount balance = this.getBalance();
		
		if ((balance.minus(transferAmount).isGreaterThan(ZERO))) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount.plus(OVERDRAFT_FEE)).isGreaterThan(OVERDRAFT_LIMIT)) {
			this.withdraw(transferAmount.plus(OVERDRAFT_FEE));
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw (DollarAmount amountToWithdraw) {  
		DollarAmount balance = this.getBalance();
		
		if (balance.minus(amountToWithdraw).isGreaterThan(ZERO)) {
			super.withdraw(amountToWithdraw);
			return super.getBalance();
			
		} else if (balance.minus(amountToWithdraw.plus(OVERDRAFT_FEE)).isGreaterThan(OVERDRAFT_LIMIT)) {
			super.withdraw(amountToWithdraw.plus(OVERDRAFT_FEE));
			return super.getBalance();
			
		} else {
			return super.getBalance();
		}
				
	}
	
	public String toString() {
		return "Checking Account "+getAccountNumber();
	}

	/*
	public int compareTo(DollarAmount o) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/

	
}
	


