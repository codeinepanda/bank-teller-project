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
		
			System.out.println();
		
		DollarAmount newMoney = new DollarAmount(0);
		newMoney = myDollars.plus(otherDollars);
		System.out.println(newMoney.getDollars()*100+newMoney.getCents()+" : should be 1360");

		
	}

}
