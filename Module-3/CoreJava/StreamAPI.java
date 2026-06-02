import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Exercise 28: Stream API
public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                               11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        // Filter even numbers
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);

        // Filter odd numbers
        List<Integer> odds = numbers.stream()
            .filter(n -> n % 2 != 0)
            .collect(Collectors.toList());
        System.out.println("Odd numbers : " + odds);

        // Sum using reduce
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of all  : " + sum);

        // Map: square each number and collect
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squares     : " + squares);

        // Count elements > 10
        long count = numbers.stream().filter(n -> n > 10).count();
        System.out.println("Numbers > 10: " + count);
    }
}
