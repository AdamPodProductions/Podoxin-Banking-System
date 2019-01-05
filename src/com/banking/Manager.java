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

		if (inputs[0].equals("create")) {
			try {
				accounts.add(new Account(inputs[1], inputs[2]));
				System.out.println("Created account " + inputs[1] + " " + inputs[2] + ".");
			} catch (Exception e) {
				System.out.println("Account could not be created. Please try again.");
			}
		} else if (inputs[0].equals("balance")) {
			try {
				System.out.println("The balance of account " + inputs[1] + " " + inputs[2] + " is $" + FindAccountByName(inputs[1], inputs[2]).GetBalance());
			} catch (Exception e) {
				System.out.println("Account does not exist.");
			}
		} else if (inputs[0].equals("deposit")) {
			try {
				float amount = Float.parseFloat(inputs[1]);
				FindAccountByName(inputs[2], inputs[3]).Deposit(amount);
			} catch (Exception e) {
				System.out.println("Deposit failed. Please try again.");
			}
		} else if (inputs[0].equals("withdraw")) {
			float amount = Float.parseFloat(inputs[1]);
			FindAccountByName(inputs[2], inputs[3]).Withdraw(amount);
		} else if (inputs[0].equals("transfer")) {
			float amount = Float.parseFloat(inputs[1]);
			if(FindAccountByName(inputs[2], inputs[3]).Withdraw(amount)) {
				FindAccountByName(inputs[4], inputs[5]).Deposit(amount);
			}
		} 

		scanner.close();
		Scan();
	}

	public Account FindAccountByName(String firstName, String lastName) {
		for (Account account : accounts) {
			if (account.GetFirstName().equals(firstName) && account.GetLastName().equals(lastName)) {
				return account;
			}
		}

		return null;
	}
}
