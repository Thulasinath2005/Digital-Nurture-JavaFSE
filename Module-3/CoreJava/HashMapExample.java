import java.util.HashMap;
import java.util.Scanner;

// Exercise 25: HashMap Example
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student ID and name (enter 0 to stop):");
        while (true) {
            System.out.print("Student ID: ");
            int id = sc.nextInt();
            if (id == 0) break;
            sc.nextLine(); // consume newline
            System.out.print("Student Name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
            System.out.println("Added: " + id + " -> " + name);
        }

        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Found: " + studentMap.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        System.out.println("\nAll Students:");
        studentMap.forEach((id, name) -> System.out.println("ID " + id + " -> " + name));
        sc.close();
    }
}
