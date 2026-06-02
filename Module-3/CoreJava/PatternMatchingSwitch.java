// Exercise 30: Pattern Matching for switch (Java 21)
public class PatternMatchingSwitch {

    static String describeObject(Object obj) {
        return switch (obj) {
            case Integer i  -> "Integer with value: " + i + (i > 0 ? " (positive)" : " (non-positive)");
            case Double  d  -> "Double with value: " + d;
            case String  s  -> "String: \"" + s + "\" (length: " + s.length() + ")";
            case Boolean b  -> "Boolean: " + b;
            case int[]   arr-> "int array of length: " + arr.length;
            case null       -> "null value";
            default         -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        Object[] objects = { 42, -5, 3.14, "Hello", "Community Portal", true, null, new int[]{1, 2, 3} };

        System.out.println("Pattern Matching for switch (Java 21):");
        System.out.println("=".repeat(50));
        for (Object obj : objects) {
            System.out.println(describeObject(obj));
        }
    }
}
