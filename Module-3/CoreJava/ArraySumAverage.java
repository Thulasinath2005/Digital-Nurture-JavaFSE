import java.util.Scanner;

// Exercise 14: Array Sum and Average
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sum = 0;
        for (int x : arr) sum += x;
        double avg = (double) sum / n;

        System.out.println("Sum     = " + sum);
        System.out.printf("Average = %.2f%n", avg);
        sc.close();
    }
}
