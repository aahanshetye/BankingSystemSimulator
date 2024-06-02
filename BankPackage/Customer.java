package bank;

import java.text.DecimalFormat;
import java.util.*;

public class Customer {
    private int customerId;
    private String customerName;
    private ArrayList<Account> accounts;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
    }

    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        return new Customer(customerId, customerName);
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void displayAccounts() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Accounts:");
        for (Account account : accounts) {
            account.displayAccountInfo();
        }
    }

    public void deleteAccount(int accountNumber) {
        Account accountToDelete = null;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accountToDelete = account;
                break;
            }
        }
        if (accountToDelete != null) {
            accounts.remove(accountToDelete);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}