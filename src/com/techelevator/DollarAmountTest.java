package com.techelevator;

public class DollarAmountTest {

	public static void main(String[] args) {

		DollarAmount myDollars = new DollarAmount(575);

		System.out.println(myDollars.getCents());
		System.out.println(myDollars.getDollars());

			System.out.println();

		DollarAmount otherDollars = new DollarAmount(785);
		
		//isEqualToTest
		System.out.println(myDollars.isEqualTo(otherDollars));

			System.out.println();
		
		//isLessThan test
		System.out.println(myDollars.isLessThan(otherDollars));

			System.out.println();
		
		//isGreaterThan test
		System.out.println(myDollars.isGreaterThan(otherDollars));

			System.out.println();
		
		//isNegative test
		System.out.println(myDollars.isNegative());
		
			System.out.println();
		
		//test for PLUS
		DollarAmount newMoney = new DollarAmount(0);
		newMoney = myDollars.plus(otherDollars);
		System.out.println(newMoney.getDollars()*100+newMoney.getCents()+" : should be 1360");
		
			System.out.println();

		//ANOTHER test for PLUS
		DollarAmount a = new DollarAmount(123);
		DollarAmount b = new DollarAmount(456);
		DollarAmount sum = a.plus(b);
		DollarAmount expected = new DollarAmount(579);
		if (!(expected.isEqualTo(sum))) {
			System.out.println("FAIL - plus method failed");
		} else {
			System.out.println("PASS - plus method passed");
		}
		
			System.out.println();
		
		//ANOTHER test for PLUS
		// if (!sum.isEqualTo(newDollarAmount(579))) {
		//	System.out.println("FAIL - plus method failed");
		//}
		
		
	}

}
