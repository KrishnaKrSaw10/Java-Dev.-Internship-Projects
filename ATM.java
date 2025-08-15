import java.util.Scanner;

/**
 * Represents a user's bank account with a balance.
 */
class BankAccount {
    private double balance;

    /**
     * Initializes a new BankAccount with a starting balance.
     * @param initialBalance The initial amount in the account.
     */
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Returns the current balance of the account.
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit successful. New balance: $%.2f%n", balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }

    /**
     * Withdraws a specified amount from the account.
     * @param amount The amount to withdraw.
     * @return true if the withdrawal was successful, false otherwise.
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive number.");
            return false;
        }
    }
}

/**
 * Represents the ATM machine, handling user interaction and transactions.
 */
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    /**
     * Initializes the ATM with a BankAccount and a Scanner for user input.
     * @param account The bank account to be used by the ATM.
     */
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    public void displayMenu() {
        System.out.println("\n--- ATM Main Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    /**
     * Runs the main ATM loop, handling user choices.
     */
    public void run() {
        int choice;
        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next(); // Clear the invalid input from the scanner
                choice = 0; // Reset choice to loop again
            }
        } while (choice != 4);
        scanner.close();
    }

    /**
     * Displays the current account balance.
     */
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    /**
     * Prompts the user for a deposit amount and performs the transaction.
     */
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    /**
     * Prompts the user for a withdrawal amount and performs the transaction.
     */
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    /**
     * Main method to start the ATM application.
     */
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00); // Create a user's bank account with an initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
