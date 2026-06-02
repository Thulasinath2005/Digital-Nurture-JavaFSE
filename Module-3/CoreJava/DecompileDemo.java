// Exercise 38: Decompile a Class File
//
// Steps:
// 1. Compile:   javac DecompileDemo.java
// 2. Use CFR decompiler (download cfr.jar):
//    java -jar cfr.jar DecompileDemo.class
//
// OR use JD-GUI (GUI tool):
//    Open DecompileDemo.class in JD-GUI application
//
// The decompiler will reconstruct source code like:
// ────────────────────────────────────────────
// public class DecompileDemo {
//     private String name;
//     private int score;
//
//     public DecompileDemo(String name, int score) {
//         this.name = name;
//         this.score = score;
//     }
//     public void display() {
//         System.out.println(this.name + ": " + this.score);
//     }
//     ...
// }
// ────────────────────────────────────────────

public class DecompileDemo {
    private String name;
    private int    score;

    public DecompileDemo(String name, int score) {
        this.name  = name;
        this.score = score;
    }

    public void display() {
        System.out.println("Student: " + name + " | Score: " + score);
    }

    public String getGrade() {
        if      (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else                  return "F";
    }

    public static void main(String[] args) {
        DecompileDemo s1 = new DecompileDemo("Alice", 95);
        DecompileDemo s2 = new DecompileDemo("Bob",   78);

        s1.display();
        System.out.println("Grade: " + s1.getGrade());
        s2.display();
        System.out.println("Grade: " + s2.getGrade());

        System.out.println("\nCompile and decompile this file:");
        System.out.println("  javac DecompileDemo.java");
        System.out.println("  java -jar cfr.jar DecompileDemo.class");
    }
}
