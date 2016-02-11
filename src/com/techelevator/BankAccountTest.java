package com.techelevator;

public class BankAccountTest {

	public static void main(String[] args) {
		DollarAmount ten = new DollarAmount(1000);
		DollarAmount twenty = new DollarAmount(2000);
		DollarAmount thirty = new DollarAmount(3000);
		DollarAmount oneHundred = new DollarAmount (10000);
		DollarAmount oneHundredTen = new DollarAmount (11000);

		
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
		
		
		CheckingAccount dude = new CheckingAccount ("That dude", "14568",ten);
		dude.transfer(guy2, oneHundred);
		if (dude.getBalance().equals(ten)) {
			System.out.println("YES dude cannot transfer over $100.");
		} else {
			System.out.println("NOPE");
		}
		
		

	}

}
