package com.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	public ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static void main(String[] args) {
		System.out.println("Welcome to Podoxin Banking System.");
		
		Manager manager = new Manager();
		manager.Scan();
	}

	public void Scan() {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = scanner.nextLine().split("\\s+");

		if(inputs[0].equals("create")) {
			try {
				accounts.add(new Account(inputs[1], inputs[2], inputs[3]));
				System.out.println("Created account " + inputs[1] + " " + inputs[2] + ".");
			} catch(Exception e) {
				System.out.println("Account could not be created. Please try again.");
			}
		}

		Scan();
	}
	
	public Account FindAccountByName(String firstName, String lastName) {
		for(Account account : accounts) 
		{
			if(account.GetFirstName().equals(firstName) && account.GetLastName().equals(lastName)) {
				return account;
			}
		}
		
		return null;
	}
}
