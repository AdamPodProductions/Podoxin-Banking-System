package com.banking;

public class Account {
	private String firstName = "";
	private String lastName = "";
	private String password = "";
	
	private float balance = 0.0f;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
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
	
	public String GetPassword() {
		return password;
	}
	
	public void SetPassword(String password) {
		this.password = password;
	}
	
	public float GetBalance() {
		return balance;
	}
	
	public void Deposit(float amount) {
		balance += amount;
		System.out.println("Deposited $" + amount + " to account of " + firstName + " " + lastName + ".");
	}
	
	public void Withdraw(float amount) {
		if(amount >= balance) {
			balance -= amount;
			System.out.println("Withdrew $" + amount + " from account of " + firstName + " " + lastName + ".");
		} else {
			System.out.println("Not enough funds avaliable.");
		}
	}
}
