
package atmsim;

import java.util.Scanner;
import java.util.ArrayList;
// main class
public class ATMTest {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // create arraylist for customers
        ArrayList<ATM> customers = new ArrayList<>();
        
        // prompt # of customers and store in array
        System.out.print("Enter number of customers (5-10): ");
        int numCustomers = scanner.nextInt();
        
        if (numCustomers < 5 || numCustomers > 10) {
            System.out.println("Invalid number of customers.");
            return;
        }
       
        // read in info for each customer
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("\nEnter information for Customer " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();

            int pin;
            while (true) {
                System.out.print("Enter 4 digit PIN: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid PIN (Enter 4 Integers): ");
                    scanner.next();
                }
                pin = scanner.nextInt();
                if (pin >= 1000 && pin <= 9999)
                    break;
                else
                    System.out.println("PIN must be 4 digits.");
            }

            System.out.print("Starting balance: ");
            while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid Balance (Enter a valid number): ");
                    scanner.next();
            }
            double balance = scanner.nextDouble();
            scanner.nextLine(); 
            
            customers.add(new ATM(name, pin, balance));
        }
        // print customers formatted
        System.out.println("\n-----Customers-----");
        for (ATM a : customers) {
            System.out.printf("%-15s %-10d $%.2f\n", a.getName(), a.getPin(), a.getBalance());
        }
        // welcome screen
        while (true) {
            System.out.println("\n-------------------");
            System.out.println("Welcome to the ATM");
            System.out.println("-------------------");
            System.out.print("Enter your PIN: ");
            int userPin = scanner.nextInt();
            
            ATM user = null;
            for (ATM a : customers) {
                if (a.getPin() == userPin) {
                    user = a;
                    break;
                }
            }
            // checks if there isn't a customer with entered pin
            if (user == null) {
                System.out.println("Invalid PIN.");
                continue;
            }
            
            System.out.println("\nWelcome, " + user.getName());
            System.out.printf("Your current balance is: $%.2f\n", user.getBalance());
            
            // menu screen
            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawl");
                System.out.println("3. Exit");
                System.out.print("Choice: ");
                
                int choice = scanner.nextInt();
                
                // check conditions
                if (choice == 1) {
                    user.deposit();
                } else if (choice == 2) {
                    user.withdrawl();
                } else if (choice == 3) {
                    System.out.println("Exiting....");
                    break;
                } else {
                    System.out.println("Invalid choice. Returning to menu.");
                    break;
                }
                
                
            }
            
            
        }
        
    }
    
}
