import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private String transactionHistory;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = "Initial deposit: " + initialBalance + "\n";
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: " + amount + "\n";
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrew: " + amount + "\n";
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get transaction history
    public String getTransactionHistory() {
        return transactionHistory;
    }

    // Account details
    public String getAccountDetails() {
        return "Account Holder: " + accountHolder + "\nAccount Number: " + accountNumber;
    }
}

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount account;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Banking System!");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccountDetails();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    viewTransactionHistory();
                    break;
                case 7:
                    System.out.println("Thank you for using our Banking System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new account
    public static void createAccount() {
        scanner.nextLine(); // Consume the newline left by nextInt()
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        account = new BankAccount(name, accountNumber, initialDeposit);
        System.out.println("Account created successfully!");
    }

    // Method to view account details
    public static void viewAccountDetails() {
        if (account != null) {
            System.out.println(account.getAccountDetails());
        } else {
            System.out.println("No account found. Please create an account first.");
        }
    }

    // Method to deposit money
    public static void depositMoney() {
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("No account found. Please create an account first.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney() {
        if (account != null) {
            System.out.print("Enter withdraw amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("No account found. Please create an account first.");
        }
    }

    // Method to check balance
    public static void checkBalance() {
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("No account found. Please create an account first.");
        }
    }

    // Method to view transaction history
    public static void viewTransactionHistory() {
        if (account != null) {
            System.out.println("Transaction History: ");
            System.out.println(account.getTransactionHistory());
        } else {
            System.out.println("No account found. Please create an account first.");
        }
    }
}
