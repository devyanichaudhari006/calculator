import java.util.Scanner;

public class BankingSystem {

    static Scanner sc = new Scanner(System.in);

    static String accountHolder = "";
    static String accountNumber = "";
    static double balance = 0.0;
    static boolean accountCreated = false;

    // Create Account
    static void createAccount() {
        if (accountCreated) {
            System.out.println("\nAccount already exists.");
            return;
        }

        System.out.print("\nEnter account holder name: ");
        accountHolder = sc.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = sc.nextDouble();

        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative.");
            return;
        }

        balance = initialDeposit;
        accountCreated = true;

        System.out.println("\nAccount created successfully!");
    }

    // Deposit Money
    static void deposit() {
        if (!accountCreated) {
            System.out.println("\nPlease create an account first.");
            return;
        }

        System.out.print("\nEnter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.printf("Current balance: %.2f%n", balance);
        }
    }

    // Withdraw Money
    static void withdraw() {
        if (!accountCreated) {
            System.out.println("\nPlease create an account first.");
            return;
        }

        System.out.print("\nEnter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
            System.out.printf("Remaining balance: %.2f%n", balance);
        }
    }

    // Check Balance
    static void checkBalance() {
        if (!accountCreated) {
            System.out.println("\nPlease create an account first.");
            return;
        }

        System.out.printf("\nCurrent balance: %.2f%n", balance);
    }

    // Display Account Details
    static void accountDetails() {
        if (!accountCreated) {
            System.out.println("\nPlease create an account first.");
            return;
        }

        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: %.2f%n", balance);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n============================");
            System.out.println("       BANKING SYSTEM");
            System.out.println("============================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.println("============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear input buffer

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    accountDetails();
                    break;

                case 6:
                    System.out.println("\nThank you for using the Banking System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
