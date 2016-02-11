package com.techelevator;

public class BankAccountTest {

	public static void main(String[] args) {
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		DollarAmount thirty = new DollarAmount(3000);
		DollarAmount oneHundred = new DollarAmount (10000);
		DollarAmount oneHundredTen = new DollarAmount (11000);
		DollarAmount oneHundredThirty = new DollarAmount (13000);
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
		CheckingAccount guy30to130 = new CheckingAccount ("That guy" , "4576", thirty);
		CheckingAccount dude110to10 = new CheckingAccount ("That dude", "14568",oneHundredTen);
		dude110to10.transfer(guy30to130, oneHundred);
		if (guy30to130.getBalance().equals(oneHundredThirty) && dude110to10.getBalance().equals(ten) ){
				
			System.out.println("YES dude gave guy $100. Guy now has $130.");
		} else {
			System.out.println("NOPE");
		}
		
		if (dude.getBalance().equals(ten)){
			System.out.println("YES dude gave guy 1 $100. Dude now has -$100.");
		} else {
			System.out.println("WE dont know.");
		}
		
		System.out.println(dude.getBalance().toString());
		

	}

}
