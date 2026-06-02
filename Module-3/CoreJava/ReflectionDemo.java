import java.lang.reflect.*;

// Exercise 39: Reflection in Java
public class ReflectionDemo {

    // Sample class to reflect on
    static class EventService {
        private String portalName = "Community Portal";

        public String getEventName(int id) {
            return "Event #" + id;
        }

        public void printWelcome(String name) {
            System.out.println("Welcome to " + portalName + ", " + name + "!");
        }

        private int calculateFee(int seats) {
            return seats * 50;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Reflection Demo ===\n");

        // 1. Load class by name
        Class<?> clazz = Class.forName("ReflectionDemo$EventService");
        System.out.println("Class name: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());

        // 2. List all declared methods
        System.out.println("\nDeclared Methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("  " + m.getReturnType().getSimpleName()
                + " " + m.getName() + "(" + getParamTypes(m) + ")");
        }

        // 3. List fields
        System.out.println("\nDeclared Fields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println("  " + f.getType().getSimpleName() + " " + f.getName());
        }

        // 4. Invoke a public method dynamically
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method getEvent = clazz.getMethod("getEventName", int.class);
        Object result = getEvent.invoke(instance, 42);
        System.out.println("\nInvoked getEventName(42): " + result);

        Method printWelcome = clazz.getMethod("printWelcome", String.class);
        printWelcome.invoke(instance, "Alice");

        // 5. Access private method via setAccessible
        Method privateFee = clazz.getDeclaredMethod("calculateFee", int.class);
        privateFee.setAccessible(true);
        Object fee = privateFee.invoke(instance, 10);
        System.out.println("\nPrivate calculateFee(10): " + fee);
    }

    static String getParamTypes(Method m) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> c : m.getParameterTypes()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(c.getSimpleName());
        }
        return sb.toString();
    }
}
