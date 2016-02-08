package com.techelevator;

public class DollarAmountTest {

	public static void main(String[] args) {

		DollarAmount myDollars = new DollarAmount(575);

		System.out.println(myDollars.getCents());
		System.out.println(myDollars.getDollars());

		System.out.println();

		DollarAmount otherDollars = new DollarAmount(785);

		System.out.println(myDollars.isEqualTo(otherDollars));

		System.out.println();

		System.out.println(myDollars.isLessThan(otherDollars));

		System.out.println();

		System.out.println(myDollars.isGreaterThan(otherDollars));

		System.out.println();

		System.out.println(myDollars.isNegative());


		myDollars.plus(otherDollars);
		System.out.println((myDollars.getDollars() * 100) + myDollars.getCents() + " Should be 13.60");
		System.out.println(myDollars.plus(otherDollars));
		
		
		//myDollars.minus(otherDollars);
		//System.out.println((myDollars.getDollars() * 100) + myDollars.getCents());
		//myDollars.minus(otherDollars);
		//System.out.println((myDollars.getDollars() * 100) + myDollars.getCents());

		//DollarAmount newDollars = new DollarAmount(250);
		
		//newDollars.plus(myDollars);


		
	}

}
