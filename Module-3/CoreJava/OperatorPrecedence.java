// Exercise 8: Operator Precedence
public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;          // * before +
        int result2 = (10 + 5) * 2;        // () overrides
        int result3 = 10 + 5 * 2 - 3 / 3; // * and / before + and -
        int result4 = 2 + 3 * 4 - 8 / 2;  // 2 + 12 - 4 = 10
        boolean result5 = 5 > 3 && 10 < 20; // comparison then &&

        System.out.println("10 + 5 * 2         = " + result1 + "  (5*2=10 first, then +10)");
        System.out.println("(10 + 5) * 2       = " + result2 + "  (parentheses first)");
        System.out.println("10 + 5*2 - 3/3     = " + result3 + "  (*,/ then +,-)");
        System.out.println("2 + 3*4 - 8/2      = " + result4 + "  (= 2+12-4)");
        System.out.println("5 > 3 && 10 < 20   = " + result5 + " (comparison before &&)");
    }
}
