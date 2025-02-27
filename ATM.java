import java.util.*;

public class ATM {
    double balance;
    int pin;
    
    public ATM(double initialBalance,int userpin) {
        this.balance = initialBalance;
        this.pin = userpin;
    }

    // check pin
    public boolean validatepin(int enteredpin) {
        return this.pin==enteredpin;
    }

    // check balance
    public void checkBalance() {
        System.out.println("Your balance is: Rs." + balance);
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew Rs." + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public static void main(String[] args) {
        Scanner karna = new Scanner(System.in);
        ATM atm = new ATM(1000,1234);  // Initial balance 1000

        System.out.print("Enter the PIN :");
        int enteredpin = karna.nextInt();

        if(atm.validatepin(enteredpin)){
            while (true) {
                System.out.println("\n--- ATM Machine ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = karna.nextInt();
                
                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = karna.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = karna.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
        else{
            System.out.println("Invalid Pin Number.");
        }
    }
}