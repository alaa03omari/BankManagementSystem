package bank;

public class Main {
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("==== Welcome to Bank Management System ====");

        while (true) {
            printMenu();
            int choice = (int) InputHelper.readDouble("Enter choice: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> viewAllAccounts();
                case 5 -> exitProgram();
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n-----------------------------");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View All Accounts");
        System.out.println("5. Exit");
    }

    private static void createAccount() {
        String accNum = InputHelper.readString("Enter account number: ");
        String owner = InputHelper.readString("Enter owner name: ");
        double balance = InputHelper.readDouble("Enter initial balance: ");
        bank.addAccount(new BankAccount(accNum, owner, balance));
    }

    private static void deposit() {
        String accNum = InputHelper.readString("Enter account number: ");
        BankAccount acc = bank.findAccount(accNum);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        double amount = InputHelper.readDouble("Enter amount: ");
        acc.deposit(amount);
    }

    private static void withdraw() {
        String accNum = InputHelper.readString("Enter account number: ");
        BankAccount acc = bank.findAccount(accNum);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        double amount = InputHelper.readDouble("Enter amount: ");
        if (acc.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        }
    }

    private static void viewAllAccounts() {
        if (bank.getAccounts().isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\n=== Accounts List ===");
        bank.getAccounts().forEach(System.out::println);
    }

    private static void exitProgram() {
        System.out.println("\nThank you for using the system. Goodbye!");
        System.exit(0);
    }
}
