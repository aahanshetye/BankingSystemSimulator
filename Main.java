import bankpackage.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Banking System Simulator!");
        System.out.println("This program was made with the help of OOP concepts in Java.");
        System.out.println("\n===== Banking System Menu =====");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer Funds");
        System.out.println("6. Apply Interest (Savings Account)");
        System.out.println("7. Display Customer Accounts");
        System.out.println("8. Find Customer by ID");
        System.out.println("9. Delete Bank Account");
        System.out.println("0. Exit");
        System.out.println("===============================");

        while (true) {
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Customer
                    Customer customer = Customer.createCustomer();
                    bank.addCustomer(customer);
                    System.out.println("Customer added successfully.");
                    break;

                case 2:
                    // Add Account
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer foundCustomer = bank.findCustomerById(customerId);
                    if (foundCustomer != null) {
                        System.out.print("Enter Account Type (Savings/Current): ");
                        String accountType = scanner.next();
                        if (accountType.equalsIgnoreCase("Savings")) {
                            System.out.print("Enter Account Number: ");
                            long accountNumber = scanner.nextLong();
                            System.out.print("Enter Interest Rate: ");
                            double interestRate = scanner.nextDouble();
                            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, interestRate);
                            foundCustomer.addAccount(savingsAccount);
                            System.out.println("Savings Account added successfully.");
                        } else if (accountType.equalsIgnoreCase("Current")) {
                            System.out.print("Enter Account Number: ");
                            long accountNumber = scanner.nextLong();
                            System.out.print("Enter Overdraft Limit: ");
                            double overdraftLimit = scanner.nextDouble();
                            CurrentAccount currentAccount = new CurrentAccount(accountNumber, overdraftLimit);
                            foundCustomer.addAccount(currentAccount);
                            System.out.println("Current Account added successfully.");
                        } else {
                            System.out.println("Invalid account type.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    // Deposit
                    System.out.print("Enter Customer ID: ");
                    int depositCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer depositCustomer = bank.findCustomerById(depositCustomerId);
                    if (depositCustomer != null) {
                        System.out.print("Enter Account Number: ");
                        long depositAccountNumber = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        Account depositAccount = null;

                        for (Account account : depositCustomer.getAccounts()) {
                            if (account.getAccountNumber() == depositAccountNumber) {
                                depositAccount = account;
                                break;
                            }
                        }

                        if (depositAccount != null) {
                            System.out.print("Enter Deposit Amount: ₹");
                            double depositAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            depositAccount.deposit(depositAmount);
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    // Withdraw
                    System.out.print("Enter Customer ID: ");
                    int withdrawCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer withdrawCustomer = bank.findCustomerById(withdrawCustomerId);
                    if (withdrawCustomer != null) {
                        System.out.print("Enter Account Number: ");
                        long withdrawAccountNumber = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        Account withdrawAccount = null;

                        for (Account account : withdrawCustomer.getAccounts()) {
                            if (account.getAccountNumber() == withdrawAccountNumber) {
                                withdrawAccount = account;
                                break;
                            }
                        }

                        if (withdrawAccount != null) {
                            System.out.print("Enter Withdrawal Amount: ₹");
                            double withdrawAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            withdrawAccount.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    // Transfer Funds
                    System.out.print("Enter Customer ID (Source): ");
                    int sourceCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer sourceCustomer = bank.findCustomerById(sourceCustomerId);
                    if (sourceCustomer != null) {
                        System.out.print("Enter Account Number (Source): ");
                        long sourceAccountNumber = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        Account sourceAccount = null;

                        for (Account account : sourceCustomer.getAccounts()) {
                            if (account.getAccountNumber() == sourceAccountNumber) {
                                sourceAccount = account;
                                break;
                            }
                        }

                        if (sourceAccount != null) {
                            System.out.print("Enter Customer ID (Target): ");
                            int targetCustomerId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            Customer targetCustomer = bank.findCustomerById(targetCustomerId);

                            if (targetCustomer != null) {
                                System.out.print("Enter Account Number (Target): ");
                                long targetAccountNumber = scanner.nextLong();
                                scanner.nextLine(); // Consume newline
                                Account targetAccount = null;

                                for (Account account : targetCustomer.getAccounts()) {
                                    if (account.getAccountNumber() == targetAccountNumber) {
                                        targetAccount = account;
                                        break;
                                    }
                                }

                                if (targetAccount != null) {
                                    System.out.print("Enter Transfer Amount: ₹");
                                    double transferAmount = scanner.nextDouble();
                                    scanner.nextLine(); // Consume newline
                                    sourceAccount.transferFunds(targetAccount, transferAmount);
                                } else {
                                    System.out.println("Target Account not found.");
                                }
                            } else {
                                System.out.println("Target Customer not found.");
                            }
                        } else {
                            System.out.println("Source Account not found.");
                        }
                    } else {
                        System.out.println("Source Customer not found.");
                    }
                    break;

                case 6:
                    // Apply Interest (Savings Account)
                    System.out.print("Enter Customer ID: ");
                    int interestCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer interestCustomer = bank.findCustomerById(interestCustomerId);
                    if (interestCustomer != null) {
                        System.out.print("Enter Account Number: ");
                        long interestAccountNumber = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        SavingsAccount interestAccount = null;

                        for (Account account : interestCustomer.getAccounts()) {
                            if (account.getAccountNumber() == interestAccountNumber && account instanceof SavingsAccount) {
                                interestAccount = (SavingsAccount) account;
                                break;
                            }
                        }

                        if (interestAccount != null) {
                            interestAccount.applyInterest();
                        } else {
                            System.out.println("Savings Account not found.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    // Display All Customer Accounts
                    for (Customer cust : bank.getCustomers()) {
                        System.out.println("Customer ID: " + cust.getCustomerId());
                        System.out.println("Customer Name: " + cust.getCustomerName());
                        System.out.println("Accounts:");
                        for (Account account : cust.getAccounts()) {
                            System.out.println("Account Number: " + account.getAccountNumber());
                            System.out.println("Balance: ₹" + account.getBalance());
                        }
                        System.out.println(); // Separate each customer's accounts
                    }
                    break;


                case 8:
                    // Find Customer by ID
                    System.out.print("Enter Customer ID to find: ");
                    int findCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer foundCustomerById = bank.findCustomerById(findCustomerId);
                    if (foundCustomerById != null) {
                        System.out.println("Customer found:");
                        foundCustomerById.displayAccounts();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 9:
                    // Delete Bank Account
                    System.out.print("Enter Customer ID: ");
                    int deleteCustomerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer deleteCustomer = bank.findCustomerById(deleteCustomerId);
                    if (deleteCustomer != null) {
                        System.out.print("Enter Account Number to delete: ");
                        long deleteAccountNumber = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                        deleteCustomer.deleteAccount(deleteAccountNumber);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 0:
                    // Exit the program
                    System.out.println("\nExiting the Banking System.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}