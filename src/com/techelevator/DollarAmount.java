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
	
	public long getDollars () {
		return totalAmountInCents - getCents();
	}
	public boolean isEqualTo (long amountToCompare){
		return amountToCompare == totalAmountInCents;
	}
	public boolean isLessThan (long amountToCompare) {
		return amountToCompare >= totalAmountInCents;
	}
	public boolean isGreaterThan ( long amountToCompare) {
		return amountToCompare <= totalAmountInCents;
	}
	public boolean isNegative () {
		return totalAmountInCents < 0;
	}
	
	}
	
