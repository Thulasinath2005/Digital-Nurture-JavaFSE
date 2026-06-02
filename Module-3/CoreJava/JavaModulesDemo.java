// Exercise 34: Java Module System
// Folder structure to create:
//
// module-demo/
// ├── com.utils/
// │   ├── module-info.java
// │   └── com/utils/StringUtils.java
// └── com.greetings/
//     ├── module-info.java
//     └── com/greetings/Main.java
//
// ─────────────────────────────────────────────
// FILE 1: com.utils/module-info.java
// ─────────────────────────────────────────────
// module com.utils {
//     exports com.utils;
// }
//
// ─────────────────────────────────────────────
// FILE 2: com.utils/com/utils/StringUtils.java
// ─────────────────────────────────────────────
// package com.utils;
//
// public class StringUtils {
//     public static String greet(String name) {
//         return "Hello, " + name + "! Welcome to the Community Portal.";
//     }
//     public static String toUpperCase(String s) {
//         return s.toUpperCase();
//     }
// }
//
// ─────────────────────────────────────────────
// FILE 3: com.greetings/module-info.java
// ─────────────────────────────────────────────
// module com.greetings {
//     requires com.utils;
// }
//
// ─────────────────────────────────────────────
// FILE 4: com.greetings/com/greetings/Main.java
// ─────────────────────────────────────────────
// package com.greetings;
// import com.utils.StringUtils;
//
// public class Main {
//     public static void main(String[] args) {
//         System.out.println(StringUtils.greet("Alice"));
//         System.out.println(StringUtils.toUpperCase("community portal"));
//     }
// }
//
// ─────────────────────────────────────────────
// COMPILE AND RUN COMMANDS:
// ─────────────────────────────────────────────
// javac -d out/com.utils   com.utils/module-info.java   com.utils/com/utils/StringUtils.java
// javac -d out/com.greetings --module-path out com.greetings/module-info.java com.greetings/com/greetings/Main.java
// java --module-path out -m com.greetings/com.greetings.Main

// ─────────────────────────────────────────────
// RUNNABLE INLINE VERSION (without module system):
// ─────────────────────────────────────────────
public class JavaModulesDemo {

    // Simulating com.utils.StringUtils
    static class StringUtils {
        public static String greet(String name) {
            return "Hello, " + name + "! Welcome to the Community Portal.";
        }
        public static String toUpperCase(String s) {
            return s.toUpperCase();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Java Module System Demo ===");
        System.out.println("(See comments above for full module project structure)");
        System.out.println();
        System.out.println(StringUtils.greet("Alice"));
        System.out.println(StringUtils.greet("Bob"));
        System.out.println(StringUtils.toUpperCase("community event portal"));
    }
}
