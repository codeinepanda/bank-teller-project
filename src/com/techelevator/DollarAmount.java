package com.techelevator;

public class DollarAmount {

	private long totalAmountInCents;
	
	public  DollarAmount ( long totalAmountInCents ) {
		this.totalAmountInCents = totalAmountInCents;
	}
	
	public DollarAmount ( long dollars , int cents) {
		this.totalAmountInCents = (dollars * 100) + cents;
	}
	
	public int getCents () {
		return (int) ( totalAmountInCents % 100 );
	}
	
	public long getDollars () {
		return (totalAmountInCents) / 100;
	}
	
	public boolean isEqualTo (DollarAmount amountToCompare){
		return ( (totalAmountInCents) == amountToCompare.totalAmountInCents );					
	}
	
	public boolean isLessThan (DollarAmount amountToCompare) {
		return totalAmountInCents < amountToCompare.totalAmountInCents;
	}
	
	public boolean isGreaterThan (DollarAmount amountToCompare) {
		return totalAmountInCents > amountToCompare.totalAmountInCents;
	}
	
	public boolean isNegative () {
		return totalAmountInCents < 0;
	}
	
	public void plus (DollarAmount amountToAdd) {
		totalAmountInCents = totalAmountInCents + amountToAdd.totalAmountInCents;
	}
	
	public void minus (DollarAmount amountToSubtract) {
		totalAmountInCents = totalAmountInCents - amountToSubtract.totalAmountInCents;
	}


	
	
}
	
