package com.techelevator;

public class BankAccountTest {

	public static void main(String[] args) {
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		DollarAmount thirty = new DollarAmount(3000);
		DollarAmount fourty = new DollarAmount(4000);
		DollarAmount sixty = new DollarAmount(6000);
		DollarAmount oneHundred = new DollarAmount (10000);
		DollarAmount oneHundredTen = new DollarAmount (11000);
		DollarAmount oneHundredThirty = new DollarAmount (13000);
		DollarAmount oneHundredFourty = new DollarAmount (14000);
		DollarAmount twoHundred = new DollarAmount(20000);
		DollarAmount overdraftCutoff = new DollarAmount(-10000);

		/*
		BankAccount guy1 = new BankAccount("That guy", "12345", ten);
		guy1.deposit(ten);
		if (guy1.getBalance().equals(twenty)) {				//
			System.out.println("YES guy 1 has 20");
		} else {
			System.out.println("NOPE");
		}

		BankAccount guy2 = new BankAccount("This guy", "67890", twenty);
		guy2.deposit(ten);
		if (guy2.getBalance().equals(thirty)) {			
			System.out.println("YES guy 2 has 30");
		} else {
			System.out.println("NOPE");
		}

		guy2.withdraw(ten);
		if (guy2.getBalance().equals(twenty)) {			
			System.out.println("YES guy 2 has 20");
		} else {
			System.out.println("NOPE");
		}
		
		guy2.transfer(guy1, ten);
		if (guy1.getBalance().equals(thirty)) {		
			System.out.println("YES guy 1 has 30");
		} else {
			System.out.println("NOPE");
		}
		//guy 1 has 30
		
		*/
		 
		
		/*
	///CheckingAccount transfer
		CheckingAccount guy30to130 = new CheckingAccount ("This Guy" , "45768", thirty);
		//System.out.println(guy30to130.getBalance().toString()+" should equal 30");
		CheckingAccount guy110to10 = new CheckingAccount ("That Guy", "14568",oneHundredTen);
		guy110to10.transfer(guy30to130, oneHundred);
		if (guy30to130.getBalance().equals(oneHundredThirty) && guy110to10.getBalance().equals(ten) ){	
			System.out.println("YES dude gave guy $100. Guy now has $130.");
		} else {
			System.out.println("NOPE");
		}
		System.out.println("guy110to10 has "+guy110to10.getBalance().toString());
		
		System.out.println();
		
	///CheckingAccount withdraw
		CheckingAccount tomAcct = new CheckingAccount ("Tom", "284", ten);
		tomAcct.withdraw(thirty);
		System.out.println("tomAcct has "+tomAcct.getBalance().toString());
		tomAcct.withdraw(oneHundred);
		System.out.println("tomAcct should still have -30 : "+tomAcct.getBalance().toString());
		
		System.out.println();
		
	///SavingsAccount transfer
		SavingsAccount danAcct = new SavingsAccount("Dan", "2345", twoHundred);
		SavingsAccount haydenAcct = new SavingsAccount("Hayden", "4567", fourty);
		danAcct.transfer(haydenAcct, sixty);
		System.out.println("danAcct should have 140 : "+danAcct.getBalance().toString());
		System.out.println("haydenAcct should have 100 : "+haydenAcct.getBalance().toString());
		
		System.out.println();
		
	///CheckingAccount withdraw
		SavingsAccount tomSavAcct = new SavingsAccount ("Tom", "284", twoHundred);
		tomSavAcct.withdraw(sixty);
		System.out.println("tomSavAcct should have 140 : "+tomSavAcct.getBalance().toString());
		tomSavAcct.withdraw(oneHundred);
		System.out.println("tomSavAcct should have 38 : "+tomSavAcct.getBalance().toString());
		tomSavAcct.withdraw(fourty);
		System.out.println("tomSavAcct should still have 38 : "+tomSavAcct.getBalance().toString());
		
		*/

	}

}
