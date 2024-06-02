package bank;

import java.text.DecimalFormat;
import java.util.*;

public class Account {
    private int accountNumber;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(new Date(), "Deposit", amount);
        transactionHistory.add(transaction);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) { // Check for positive amount and sufficient balance
            balance -= amount;
            Transaction transaction = new Transaction(new Date(), "Withdrawal", -amount);
            transactionHistory.add(transaction);
            return true;
        } else {
            System.out.println("Error: Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    public void transferFunds(Account targetAccount, double amount) {
        if (this.withdraw(amount)) {
            targetAccount.deposit(amount);
            System.out.println("Funds transferred successfully.");
        } else {
            System.out.println("Funds transfer failed.");
        }
    }

    public void displayAccountInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + df.format(balance));
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            transaction.displayTransaction();
        }
    }
}