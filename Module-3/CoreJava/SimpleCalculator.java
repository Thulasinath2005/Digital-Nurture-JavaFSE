import java.util.Scanner;

// Exercise 2: Simple Calculator
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char op = sc.next().charAt(0);

        double result;
        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b == 0) { System.out.println("Error: Division by zero!"); return; }
                result = a / b; break;
            default:
                System.out.println("Invalid operator!"); return;
        }

        System.out.printf("Result: %.2f %c %.2f = %.2f%n", a, op, b, result);
        sc.close();
    }
}
