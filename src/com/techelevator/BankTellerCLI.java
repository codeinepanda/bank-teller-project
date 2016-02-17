package com.techelevator;

import java.util.List;

import com.techelevator.util.Terminal;

// import com.techelevator.util.Terminal;

public class BankTellerCLI {

	private Bank theBank;
	
	

	public BankTellerCLI() {
		theBank = new Bank();
	}

	public static void main(String[] args) {
		// BankTellerCLI class - application that is actually invoked

		BankTellerCLI application = new BankTellerCLI(); 	// creating instance of BankTellerCLI named "application", will have method called "run" - BankTellerCLI will have state, can store data in instance variables
		application.run();
	}

	public void run() {
		while (true) {

			String choice = getChoiceFromMainMenu();

			if ( choice.equals("1") ) {
				addCustomer();
			}
			
			else if ( choice.equals("2") ) {
				addAccount();
			}
			
			else if ( choice.equals("3") ) {
				deposit();
			}	
			
			else if ( choice.equals("4") ) {
				//withdraw();
			}
			
			else if ( choice.equals("5") ) {
				//transfer();
			}

			else if ( choice.equals("6") ) {
				/*
				System.out.println("\n**** Exiting... Have a nice day ****");
				System.exit(0);						// to exit a program from any point, takes an integer as a parameter... 0 = normal exit
				*/
				exitMainMenu();
				
			}
		}
		
	}
	
	private String getChoiceFromMainMenu() {
		printBanner("MAIN MENU");

		System.out.println("Please choose from the following option:");

		System.out.println("1) Add Customer");
		System.out.println("2) Add Account");
		System.out.println("3) Deposit");
		System.out.println("4) Withdraw");
		System.out.println("5) Transfer");
		System.out.println("6) Exit");
		System.out.println();

		return getUserInput("Enter number");
		//System.out.println("Enter number >>> ");
		//return Terminal.readLine(); // reads whatever the user types into the terminal
	}
	
	
	//makes banner//
	private void printBanner(String bannerText) {
		System.out.println("\n###### "+bannerText+" ######\n");
	}
	
	//prompts user//
	private String getUserInput(String prompt) {
		System.out.println(prompt+" >>> ");
		return Terminal.readLine();
	}

	
	//returns list of customers (starts at 0)//
	private void getCustomerList() {
		List<BankCustomer> customerList = theBank.getCustomers();
		int i = 0;
		for (BankCustomer customer : customerList ){
			System.out.println((i)+") "+customer.getName()+"     "+customer.getAddress());
			i= i+1;
		}
	}
	
	//returns list of accounts for a customer//
	private void getCustomerAccountList(BankCustomer currentCustomer){
		List<BankAccount> accountList = currentCustomer.getAccounts();
		int i = 0;
		for (BankAccount account : accountList) {
			System.out.println(i+") "+account.toString());
			i = i+1;
		}
	}
	
	
	
	/*** 1 ***/
	private void addCustomer() {
		printBanner("ADD CUSTOMER");
		
		String name = getUserInput("Enter name");
		String address = getUserInput("Enter address");
		String phoneNumber = getUserInput("Enter phone number");
		BankCustomer newCustomer = new BankCustomer(name, address, phoneNumber);
		theBank.addCustomer(newCustomer);
		System.out.println("\n*** " + newCustomer.getName() + " added as a customer ***");
	}
	
	/*** 2 ***/
	private void addAccount() {
		printBanner("ADD ACCOUNT");
		System.out.println("\nChoose a customer:\n");
		
		getCustomerList();
		
		System.out.println();
		String number = getUserInput("Enter number");
		System.out.println();
		BankCustomer newCustAcct = theBank.getCustomer(Integer.parseInt(number));
		
		System.out.println("\nChoose an account type:\n");
		System.out.println("1) Checking");
		System.out.println("2) Savings");
		
		String acctChoice = getUserInput("Enter number");
		String acctNum	= getUserInput("Enter account number");
		
		if (acctChoice.equals("1")) {
			CheckingAccount newCheckAcct = new CheckingAccount (newCustAcct, acctNum);
			newCustAcct.addAccount(newCheckAcct);
			System.out.println("Checking Account "+acctNum+" has been created for "+newCustAcct.getName());
		}
		else if (acctChoice.equals("2")) {
			SavingsAccount newSavAcct = new SavingsAccount (newCustAcct, acctNum);
			newCustAcct.addAccount(newSavAcct);
			System.out.println("Savings Account "+acctNum+" has been created for "+newCustAcct.getName());
		}

	}
	
	/***  3 ***/
	private void deposit() {
		printBanner("DEPOSIT");
		System.out.println("\nChoose a customer:\n");
		
		getCustomerList();
		
		System.out.println();
		String number = getUserInput("Enter number");
		System.out.println();
		BankCustomer currentCustomer = theBank.getCustomer(Integer.parseInt(number));
		BankAccount currentAccount;
		
		System.out.println("\nChoose an account:\n");
		getCustomerAccountList(currentCustomer);
		System.out.println();
		
		String acctChoice = getUserInput("Enter number");
		String depositAmt = getUserInput("Enter deposit amount");
		
		DollarAmount depositAmount = new DollarAmount(Integer.valueOf(depositAmt)*100);
		currentAccount = currentCustomer.getAccounts().get(Integer.valueOf(acctChoice));
		currentAccount.deposit(depositAmount);
		System.out.println(currentAccount.getBalance());
		
	}
	
	
	/*** 6 ***/
	private void exitMainMenu() {
		System.out.println("\n**** Exiting... Have a nice day ****");
		System.exit(0);						// to exit a program from any point, takes an integer as a parameter... 0 = normal exit
	}

	
}
