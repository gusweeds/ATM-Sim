/*
IT 205 Intro to Object Oriented Programming 
Programmer: William Wedertz 
Date: 11/10/2025
NetBeans IDE 27

This is my own program
 */
package atmsim;

import java.util.Scanner;
// ATM class
public class ATM {
    
   Scanner scanner = new Scanner(System.in);
   
   // variables
   private String name;
   private int pin;
   private double balance;
    
   // constructor to initialize variables 
   public ATM(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }
    
    // getters
    public String getName() {
        return name;
    }
    
    public int getPin() {
        return pin;
    }
    
    public double getBalance() {
        return balance;
    }
    // deposit method 
    public void deposit() {
        double depositAmnt = 0;
        
        while (true) {
            System.out.print("Enter deposit amount: ");
            depositAmnt = scanner.nextDouble();

            if (depositAmnt <= 0) {
                System.out.println("Deposit amount must be positive.");
            } else {
                break; 
            }
        }
        
        balance += depositAmnt;
        System.out.println("Your new balance is: " + balance);
    }
    // withdrawl method
    public void withdrawl() {
        double withdrawlAmnt = 0;
        
        while (true) {
            System.out.print("Enter withdrawal amount: ");
            withdrawlAmnt = scanner.nextDouble();

            if (withdrawlAmnt <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (withdrawlAmnt > balance) {
                System.out.println("Insufficient funds.");
            } else {
                break; 
            }
        }
       
        balance -= withdrawlAmnt;
        System.out.println("Your new balance is: " + balance);
    }
}
