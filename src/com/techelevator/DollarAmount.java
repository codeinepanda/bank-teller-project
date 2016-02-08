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
	
	//public DollarAmount plus (DollarAmount amountToAdd) {
		//DollarAmount sum = new DollarAmount(totalAmountInCents);
		//sum =  sum.getDollars()*100 + sum.getCents() + amountToAdd.getDollars()*100 + amountToAdd.getCents();
	//}
	
	public void minus (DollarAmount amountToSubtract) {
		totalAmountInCents = totalAmountInCents - amountToSubtract.totalAmountInCents;
	}


	
	
}
	
