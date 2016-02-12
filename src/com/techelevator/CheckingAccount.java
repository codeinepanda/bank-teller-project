package com.techelevator;

public class CheckingAccount extends BankAccount {

	final DollarAmount overdraftFee = new DollarAmount(1000);
	final DollarAmount overdraftCutoff = new DollarAmount(-10001);
	final DollarAmount zero = new DollarAmount(-01);
	
	public CheckingAccount(String accountHolderName, String accountNumber, DollarAmount balance) {
		super(accountHolderName, accountNumber, balance);
	}

	
	public void transfer (BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount balance = this.getBalance();
		
		if ((balance.minus(transferAmount).isGreaterThan(zero))) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
			
		} else if (balance.minus(transferAmount.plus(overdraftFee)).isGreaterThan(overdraftCutoff)) {
			this.withdraw(transferAmount.plus(overdraftFee));
			destinationAccount.deposit(transferAmount);	
		} 
		
	}
	
	
	public DollarAmount withdraw (DollarAmount amountToWithdraw) {  
		DollarAmount balance = this.getBalance();
		
		if (balance.minus(amountToWithdraw).isGreaterThan(zero)) {
			super.withdraw(amountToWithdraw);
			return super.getBalance();
			
		} else if (balance.minus(amountToWithdraw.plus(overdraftFee)).isGreaterThan(overdraftCutoff)) {
			super.withdraw(amountToWithdraw.plus(overdraftFee));
			return super.getBalance();
			
		} else {
			return super.getBalance();
		}
				
	}

	
	public int compareTo(DollarAmount o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
	


