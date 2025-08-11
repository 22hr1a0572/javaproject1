Task 5: Bank Account Simulation
Objective: Simulate basic bank operations using Java OOP.
Tools :Java, VS Code, Terminal.
Deliverables: Class-based Java program with transactions.
'''
import java.util.Scanner;
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }
    public void displayAccountInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ₹");
        double balance = scanner.nextDouble();
        BankAccount account = new BankAccount(name, accNumber, balance);
        boolean running = true;
        while (running) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
PS C:\SOU> javac BankSimulation.java
PS C:\SOU> java BankSimulation.java 
Enter account holder name: souji
Enter account number: 123456789
Enter initial balance: ?500

--- Bank Menu ---
1. Deposit       
2. Withdraw
3. Check Balance
4. Account Info
5. Exit
Choose an option: 1
Enter amount to deposit: ?200
Successfully deposited: ?200.0

--- Bank Menu ---
1. Deposit
2. Withdraw
3. Check Balance
4. Account Info
5. Exit
Choose an option: 2
Enter amount to withdraw: ?100
Successfully withdrawn: ?100.0

--- Bank Menu ---
1. Deposit
2. Withdraw
3. Check Balance
4. Account Info
5. Exit
Choose an option: 3
Current balance: ?600.0

--- Bank Menu ---
1. Deposit
2. Withdraw
3. Check Balance
4. Account Info
5. Exit
Choose an option: 4

--- Account Information ---
Account Holder: souji
Account Number: 123456789
Balance: ?600.0

--- Bank Menu ---
1. Deposit
2. Withdraw
3. Check Balance
4. Account Info
5. Exit
Choose an option: 5
Thank you for banking with us!
PS C:\SOU> 
--------------------
'''
output:
---------
