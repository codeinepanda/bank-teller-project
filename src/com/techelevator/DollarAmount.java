package com.techelevator;

public class DollarAmount{

	private long totalAmountInCents;

	// constructor1
	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}

	// constructor2
	public DollarAmount(long dollars, int cents) { 			// translates dollars and cents into internal representation of the class (totalAmountInCents)
		this.totalAmountInCents = (dollars * 100) + cents; 	
	}

	public int getCents() {
		return (int) (totalAmountInCents % 100); 			// how to do this without casting?
	}

	public long getDollars() {
		return (totalAmountInCents) / 100;
	}

	// public boolean isEqualTo(DollarAmount amountToCompare) {
	// return ((totalAmountInCents) == amountToCompare.totalAmountInCents);
	// }

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

	public int compareTo(DollarAmount otherDollarAmount) {
		if (this.totalAmountInCents == otherDollarAmount.totalAmountInCents) {
			return 0;
		} else if (this.totalAmountInCents > otherDollarAmount.totalAmountInCents) {
			return 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		if (this.getCents() < 10) {
			return ("$" + this.getDollars() + ".0" + this.getCents());
		} else if (this.getCents() % 10 == 0) {
			return ("$" + this.getDollars() + "." + this.getCents()+"0");
		} else {
			return ("$" + this.getDollars() + "." + this.getCents());
		}
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof DollarAmount) {
			DollarAmount amountToCompare = (DollarAmount) obj;
			return this.totalAmountInCents == amountToCompare.totalAmountInCents;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return (int) this.totalAmountInCents;
	}

}
