package com.techelevator;

public class DollarAmount {

	private long totalAmountInCents;

	//constructor1
	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;			// need to use "this"?
	}
	
	//constructor2
	public DollarAmount(long dollars, int cents) {				// translates dollars and cents into internal representation of the class (totalAmountInCents)
		this.totalAmountInCents = (dollars * 100) + cents;		// need to use "this"?
	}

	public int getCents() {
		return (int) (totalAmountInCents % 100);				// how to do this without casting?
	}

	public long getDollars() {
		return (totalAmountInCents) / 100;
	}

	public boolean isEqualTo(DollarAmount amountToCompare) {
		return ((totalAmountInCents) == amountToCompare.totalAmountInCents);
	}

	public boolean isLessThan(DollarAmount amountToCompare) {
		return totalAmountInCents < amountToCompare.totalAmountInCents;
	}

	public boolean isGreaterThan(DollarAmount amountToCompare) {
		return totalAmountInCents > amountToCompare.totalAmountInCents;
	}

	public boolean isNegative() {
		return totalAmountInCents < 0;
	}

	public DollarAmount plus(DollarAmount amountToAdd) {		
		DollarAmount sum = new DollarAmount(amountToAdd.totalAmountInCents + totalAmountInCents);
		return sum;	
	}

	public DollarAmount minus(DollarAmount amountToSubtract) {
		DollarAmount diff = new DollarAmount(totalAmountInCents - amountToSubtract.totalAmountInCents);
		return diff;
	}

}
