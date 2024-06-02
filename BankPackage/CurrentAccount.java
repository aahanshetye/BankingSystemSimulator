package bank;

import java.text.DecimalFormat;
import java.util.*;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
            Transaction transaction = new Transaction(new Date(), "Withdrawal (Overdraft)", -amount);
            getTransactionHistory().add(transaction);
            System.out.println("Withdrawal (Overdraft) successful.");
            return true;
        } else {
            System.out.println("Error: Exceeds overdraft limit.");
            return false;
        }
    }
}