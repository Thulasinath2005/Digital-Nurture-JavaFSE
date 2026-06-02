import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Exercise 41: Executor Service and Callable
public class ExecutorServiceDemo {

    // Callable task that returns a result
    static class EventFetchTask implements Callable<String> {
        private int eventId;

        EventFetchTask(int eventId) { this.eventId = eventId; }

        @Override
        public String call() throws Exception {
            // Simulate processing time
            Thread.sleep((long)(Math.random() * 500 + 100));
            return "Event #" + eventId + " fetched by " + Thread.currentThread().getName();
        }
    }

    // Callable that returns a computed result
    static class FactorialTask implements Callable<Long> {
        private int n;

        FactorialTask(int n) { this.n = n; }

        @Override
        public Long call() {
            long result = 1;
            for (int i = 2; i <= n; i++) result *= i;
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ─── Part 1: Fixed Thread Pool with event fetch tasks ───
        System.out.println("=== ExecutorService with Callable<String> ===");
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Future<String>> eventFutures = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Future<String> future = pool.submit(new EventFetchTask(i));
            eventFutures.add(future);
        }

        for (Future<String> f : eventFutures) {
            System.out.println(f.get());  // Future.get() blocks until result is ready
        }

        pool.shutdown();

        // ─── Part 2: Factorial tasks ───
        System.out.println("\n=== ExecutorService with Callable<Long> ===");
        ExecutorService pool2 = Executors.newFixedThreadPool(4);

        int[] inputs = {5, 10, 12, 15, 20};
        List<Future<Long>> factFutures = new ArrayList<>();

        for (int n : inputs) {
            factFutures.add(pool2.submit(new FactorialTask(n)));
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i] + "! = " + factFutures.get(i).get());
        }

        pool2.shutdown();
        System.out.println("\nAll tasks completed.");
    }
}
