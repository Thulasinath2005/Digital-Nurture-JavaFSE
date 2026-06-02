// Exercise 7: Type Casting Example
public class TypeCastingExample {
    public static void main(String[] args) {
        // double to int (narrowing cast)
        double d = 9.99;
        int fromDouble = (int) d;
        System.out.println("double " + d + " cast to int: " + fromDouble);

        // int to double (widening cast)
        int i = 42;
        double fromInt = (double) i;
        System.out.println("int " + i + " cast to double: " + fromInt);

        // char to int
        char c = 'Z';
        int charVal = (int) c;
        System.out.println("char '" + c + "' cast to int (ASCII): " + charVal);
    }
}
