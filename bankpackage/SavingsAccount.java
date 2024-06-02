package bankpackage;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(long accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        if (interestRate >= 0) {
            double interest = getBalance() * interestRate;
            deposit(interest);
            System.out.println("Interest applied successfully.");
        } else {
            System.out.println("Error: Invalid interest rate.");
        }
    }
}
