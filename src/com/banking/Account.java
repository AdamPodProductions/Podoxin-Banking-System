package com.banking;

public class Account {
	private String firstName = "";
	private String lastName = "";
	
	private float balance = 0.0f;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String GetFirstName() {
		return firstName;
	}
	
	public void SetFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String GetLastName() {
		return lastName;
	}
	
	public void SetLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public float GetBalance() {
		return balance;
	}
	
	public void Deposit(float amount) {
		balance += amount;
		
		String amountString = String.format("%.2f", amount);
		System.out.println("Deposited $" + amountString + " to account of " + firstName + " " + lastName + ".");
	}
	
	public boolean Withdraw(float amount) {
		if(amount <= balance) {
			balance -= amount;

			String amountString = String.format("%.2f", amount);
			System.out.println("Withdrew $" + amountString + " from account of " + firstName + " " + lastName + ".");
			
			return true;
		} else {
			System.out.println("Insufficient funds avaliable.");
			return false;
		}
	}
}
