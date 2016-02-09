package com.techelevator;

public class BankAccountTest {

	public static void main(String[] args) {
		
	DollarAmount twenty = new DollarAmount(2000);

	DollarAmount guy1Start = new DollarAmount(1000);
	BankAccount guy1 = new BankAccount("That guy" , "12345", guy1Start);
		// System.out.println(guy1.getBalance());
		DollarAmount depositGuy1 = new DollarAmount(1000);
		guy1.deposit(depositGuy1);
		if (guy1.getBalance().isEqualTo(twenty)) {
			System.out.println("YES");
		} else {
			System.out.println("NOPE");
		}
		
	DollarAmount thirty = new DollarAmount(3000);
	
	DollarAmount guy2Start = new DollarAmount(2000);
	BankAccount guy2 = new BankAccount("This guy" , "67890" , guy2Start);
		DollarAmount depositGuy2 = new DollarAmount(1000);
		guy2.deposit(depositGuy2);
		if (guy2.getBalance().isEqualTo(thirty)) {
			System.out.println("YES");
		} else {
			System.out.println("NOPE");
		}
	
		guy2.withdraw(guy1Start);
		if (guy2.getBalance().isEqualTo(twenty)) {
			System.out.println("YES");
		} else {
			System.out.println("NOPE");
		}
	
		
	}

}
