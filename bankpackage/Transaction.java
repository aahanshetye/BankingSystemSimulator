package bankpackage;

import java.text.DecimalFormat;
import java.util.*;

public class Transaction {
    private Date date;
    private String description;
    private double amount;

    public Transaction(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public void displayTransaction() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
        System.out.println("Amount: ₹" + df.format(amount));
    }
}
