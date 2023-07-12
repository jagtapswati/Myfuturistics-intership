import java.util.Scanner;

public class ATM {
    private String pin;
    private double balance;

    public ATM(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }



    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }



    public void resetPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new 4-digit PIN: ");
        String newPin = scanner.nextLine();
        pin = newPin;
        System.out.println("PIN successfully reset.");
    }


    
    public void transferMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            scanner.nextLine(); // Clear the input buffer
            System.out.print("Enter the destination account number: ");
            String destinationAccount = scanner.nextLine();
            balance -= amount;
            System.out.println("Successfully transferred $" + amount + " to account " + destinationAccount + ".");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();
        if (enteredPin.equals(pin)) {
            System.out.println("PIN accepted.");
            while (true) {
                System.out.println("1. Check Balance");

                System.out.println("2. Reset PIN");

                System.out.println("3. Transfer Money");

                System.out.println("4. Exit");

                System.out.print("Select an option (1-4): ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        resetPin();
                        break;
                    case 3:
                        transferMoney();
                        break;
                    case 4:
                        System.out.println("Exiting the ATM. Thank you!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    public static void main(String[] args) {
        String pin = "1234"; // Set your initial PIN
        double balance = 1000.00; // Set your initial balance

        ATM myATM = new ATM(pin, balance);
        myATM.start();
    }
}