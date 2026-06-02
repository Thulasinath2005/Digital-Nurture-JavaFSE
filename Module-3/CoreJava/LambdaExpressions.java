import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Exercise 27: Lambda Expressions
public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> events = Arrays.asList(
            "Music Festival", "Art Exhibition", "Tech Meetup",
            "Food Fair", "Book Fair", "Sports Day"
        );

        System.out.println("Original list:");
        events.forEach(e -> System.out.println("  " + e));

        // Sort ascending using lambda
        List<String> sorted = new java.util.ArrayList<>(events);
        Collections.sort(sorted, (a, b) -> a.compareTo(b));

        System.out.println("\nSorted (A-Z):");
        sorted.forEach(e -> System.out.println("  " + e));

        // Sort descending
        Collections.sort(sorted, (a, b) -> b.compareTo(a));
        System.out.println("\nSorted (Z-A):");
        sorted.forEach(e -> System.out.println("  " + e));

        // Sort by length
        Collections.sort(sorted, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("\nSorted by length:");
        sorted.forEach(e -> System.out.println("  " + e + " (" + e.length() + " chars)"));
    }
}
