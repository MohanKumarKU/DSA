package com.mo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMOperation {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Balance balance;

	static {
		balance = initializeATMBalance();
	}

	public static void main(String args[]) throws IOException {
		getBalance();

		while (true) {

			System.out.println("A) DEPOSIT: \nB) WITHDRAW \nC) BALANCE\n");
			System.out.println("Enter the trnsaction you would like to do:");

			String transactionType = br.readLine();
			Operation operation = null;
			try {
				operation = Operation.valueOf(transactionType);
			} catch (Exception ex) {
				System.out.println("[ERROR] Enter the correct transaction name");
				System.out.println("--------------------------------------------------");
				continue;
			}
			switch (operation) {
			case BALANCE:
				getBalance();
				break;

			case DEPOSIT:
				System.out.println("Enter the deposit amount:");
				String depositAmount = br.readLine();
				System.out.println("Enter the 100s count:");
				String n100 = br.readLine();
				System.out.println("Enter the 500s count:");
				String n500 = br.readLine();
				try {
					deposit(Integer.valueOf(depositAmount), Integer.valueOf(n100), Integer.valueOf(n500));
				} catch (Exception ex) {
					System.out.println("[ERROR] Enter the numbers");
					System.out.println("--------------------------------------------------");
					continue;
				}
				break;

			case WITHDRAW:
				System.out.println("Enter the withdrawal amount:");
				String withdrawAmount = br.readLine();
				try {
					if (Integer.valueOf(withdrawAmount) <= 0) {
						throw new Exception();
					}
					withdraw(Integer.valueOf(withdrawAmount));
				} catch (Exception ex) {
					System.out.println("[ERROR] Entered amount is invalid");
					System.out.println("--------------------------------------------------");
					continue;
				}
				break;
			}
		}
	}

	private static void withdraw(int withdrawAmount) {
		int balanceAmount = balance.getAmount();
		int hundreds = balance.getNumberOf100s();
		int fiveHundreds = balance.getNumberOf500s();

		if (withdrawAmount > balanceAmount) {
			System.out.println("[ERROR] Insufficient balance to withdraw");
			return;
		} else {
			int amountFrom500 = balance.getNumberOf500s() * 500;
			if (amountFrom500 <= withdrawAmount) {
				int n100 = (withdrawAmount - amountFrom500) / 100;
				balance.setNumberOf500s(0);
				balance.setNumberOf100s(hundreds - n100);
				balance.setAmount(balanceAmount - withdrawAmount);
			} else {
				int n500 = withdrawAmount / 500;
				int n100 = (withdrawAmount % 500) / 100;
				if (n500 <= fiveHundreds && n100 <= hundreds) {
					balance.setAmount(balanceAmount - withdrawAmount);
					balance.setNumberOf100s(hundreds - n100);
					balance.setNumberOf500s(fiveHundreds - n500);
				} else {
					System.out.println("[ERROR] Insufficient balance to withdraw");
					return;
				}
			}
		}
		getBalance();
	}

	private static void deposit(int depositAmount, int n100, int n500) {

		if ((n100 * 100) + (n500 * 500) != depositAmount) {
			System.out.println("[ERROR] Entered values are mismatched");
			return;
		}
		balance.setAmount(balance.getAmount() + depositAmount);
		balance.setNumberOf100s(balance.getNumberOf100s() + n100);
		balance.setNumberOf500s(balance.getNumberOf500s() + n500);
		getBalance();

	}

	private static void getBalance() {
		System.out.println("--------------------------------------------------");

		System.out.println("Current balance amount is : " + balance.getAmount());
		System.out.println("Number of 100s are : " + balance.getNumberOf100s());
		System.out.println("Number of 500s are : " + balance.getNumberOf500s());

		System.out.println("--------------------------------------------------");
	}

	private static Balance initializeATMBalance() {
		Balance balance = new Balance();
		balance.setAmount(900);
		balance.setNumberOf100s(4);
		balance.setNumberOf500s(1);
		return balance;
	}

}

enum Operation {
	DEPOSIT, WITHDRAW, BALANCE
}

class Balance {

	private int amount;

	private int numberOf500s;

	private int numberOf100s;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNumberOf500s() {
		return numberOf500s;
	}

	public void setNumberOf500s(int numberOf500s) {
		this.numberOf500s = numberOf500s;
	}

	public int getNumberOf100s() {
		return numberOf100s;
	}

	public void setNumberOf100s(int numberOf100s) {
		this.numberOf100s = numberOf100s;
	}
}
