import java.util.List;
import java.util.stream.Collectors;

// Exercise 29: Records (Java 16+)
public class RecordsDemo {

    // Define a record — immutable data class
    record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create record instances
        Person p1 = new Person("Alice",   28);
        Person p2 = new Person("Bob",     17);
        Person p3 = new Person("Charlie", 35);
        Person p4 = new Person("Diana",   22);
        Person p5 = new Person("Ethan",   15);

        // Print all persons — records auto-generate toString()
        List<Person> people = List.of(p1, p2, p3, p4, p5);
        System.out.println("All persons:");
        people.forEach(System.out::println);

        // Filter: only adults (age >= 18) using Stream
        List<Person> adults = people.stream()
            .filter(p -> p.age() >= 18)
            .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(p -> System.out.println("  " + p.name() + " — age " + p.age()));

        // Records are immutable — accessing fields via accessor methods
        System.out.println("\nRecord accessor demo:");
        System.out.println("p1.name() = " + p1.name());
        System.out.println("p1.age()  = " + p1.age());
    }
}
