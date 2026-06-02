// Exercise 37: Using javap to Inspect Bytecode
//
// Steps:
// 1. Compile this file:  javac BytecodeDemo.java
// 2. Run javap:          javap -c BytecodeDemo
// 3. For full details:   javap -verbose BytecodeDemo
//
// Sample javap output you will see:
// ─────────────────────────────────────────
// public class BytecodeDemo {
//   public BytecodeDemo();
//     Code:
//        0: aload_0
//        1: invokespecial #1  // Method java/lang/Object."<init>":()V
//        4: return
//
//   public static int addNumbers(int, int);
//     Code:
//        0: iload_0
//        1: iload_1
//        2: iadd
//        3: ireturn
//
//   public static void main(java.lang.String[]);
//     Code:
//        0: iconst_5
//        1: istore_1
//        ...
// ─────────────────────────────────────────

public class BytecodeDemo {

    public static int addNumbers(int a, int b) {
        return a + b;
    }

    public static String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int sum = addNumbers(x, y);
        System.out.println("Sum: " + sum);
        System.out.println(greet("Community Portal"));
        System.out.println("5! = " + factorial(5));

        System.out.println("\nTo inspect bytecode, run:");
        System.out.println("  javac BytecodeDemo.java");
        System.out.println("  javap -c BytecodeDemo");
    }
}
