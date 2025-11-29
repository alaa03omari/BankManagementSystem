package bank;

import java.time.LocalDateTime;

public class Transaction {
    private final String type; // Deposit or Withdraw
    private final double amount;
    private final LocalDateTime dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return dateTime + " | " + type + " | Amount: " + amount + "$";
    }
}
