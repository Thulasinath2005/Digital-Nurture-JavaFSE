import java.util.ArrayList;
import java.util.Scanner;

// Exercise 24: ArrayList Example
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to stop):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) break;
            students.add(name);
            System.out.println("Added: " + name);
        }

        System.out.println("\nAll Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        sc.close();
    }
}
