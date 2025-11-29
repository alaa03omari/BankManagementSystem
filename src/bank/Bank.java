package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        if (findAccount(account.getAccountNumber()) != null) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.add(account);
        System.out.println("Account added successfully.");
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
