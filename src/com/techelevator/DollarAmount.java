package com.techelevator;

public class DollarAmount {

	public long totalAmountInCents;
	
	public DollarAmount ( long totalAmountInCents ) {
		totalAmountInCents = this.totalAmountInCents;
	}
	
	public DollarAmount ( long dollars , int cents) {
		totalAmountInCents = (dollars * 100) + cents;
	}
	
	public int getCents () {
		return (int) ( totalAmountInCents % 100 );
	}
	
	public long getDollar () {
		return totalAmountInCents - getCents();
	}
	
	
}
