import java.util.Scanner;
public class ATMInterface {
    private double accountBalance;
    public ATMInterface(double initialBalance) {
        this.accountBalance = initialBalance;
    }
    public double checkBalance() {
        return accountBalance;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            return true; // Deposit successful
        }
        return false; // Invalid deposit amount
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Invalid withdrawal amount or insufficient balance
    }
    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface(10000.0); // Initialize ATM with an initial balance
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            double amount;
            // Input validation loop
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");

                    // Input validation loop for deposit amount
                    while (true) {
                        if (scanner.hasNextDouble()) 
                        {
                            amount = scanner.nextDouble();
                            break;
                        } 
                        else
                         {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    if (atm.deposit(amount)) 
                    {
                        System.out.println("Deposit successful.");
                    } else
                    {
                        System.out.println("Invalid deposit amount. Please enter a positive amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");

                    // Input validation loop for withdrawal amount
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    if (atm.withdraw(amount)) {
                        System.out.println("Withdrawal successful.");
                    } else
                    {
                        System.out.println("Invalid withdrawal amount or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
