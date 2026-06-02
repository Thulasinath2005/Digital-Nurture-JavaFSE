import java.util.Scanner;

// Exercise 5: Multiplication Table
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Multiplication Table for " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %d%n", n, i, n * i);
        }
        sc.close();
    }
}
