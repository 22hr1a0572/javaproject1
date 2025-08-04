Objective: Build a basic calculator using Java console I/O.
Tools :Java (JDK), VS Code or IntelliJ CE, Terminal/Command Prompt.
Deliverables: Java source code (.java file).
'''
import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Basic Calculator =====");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

        scanner.close();
    }
}
'''
output:
---------
PS C:\SOU> javac BasicCalculator.java
PS C:\SOU> java BasicCalculator.java 
===== Basic Calculator =====
Enter first number: 10
Enter operator (+, -, *, /): +
Enter second number: 20
Result: 30.0
-------------
