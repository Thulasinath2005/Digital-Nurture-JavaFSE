import java.util.concurrent.atomic.AtomicInteger;

// Exercise 40: Virtual Threads (Java 21)
public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {

        int THREAD_COUNT = 100_000;
        AtomicInteger completedVirtual    = new AtomicInteger(0);
        AtomicInteger completedPlatform   = new AtomicInteger(0);

        // ─── Virtual Threads ───────────────────────────────────
        System.out.println("Starting " + THREAD_COUNT + " VIRTUAL threads...");
        long startVirtual = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            virtualThreads[i] = Thread.ofVirtual().start(() -> {
                // Each virtual thread does a tiny task
                completedVirtual.incrementAndGet();
            });
        }

        // Wait for all virtual threads
        for (Thread t : virtualThreads) t.join();
        long endVirtual = System.currentTimeMillis();

        System.out.println("Virtual threads completed: " + completedVirtual.get());
        System.out.println("Virtual threads time     : " + (endVirtual - startVirtual) + " ms");

        // ─── Platform (Traditional) Threads — smaller count to avoid OOM ───
        int PLATFORM_COUNT = 1_000;
        System.out.println("\nStarting " + PLATFORM_COUNT + " PLATFORM threads...");
        long startPlatform = System.currentTimeMillis();

        Thread[] platformThreads = new Thread[PLATFORM_COUNT];
        for (int i = 0; i < PLATFORM_COUNT; i++) {
            platformThreads[i] = new Thread(() -> completedPlatform.incrementAndGet());
            platformThreads[i].start();
        }

        for (Thread t : platformThreads) t.join();
        long endPlatform = System.currentTimeMillis();

        System.out.println("Platform threads completed: " + completedPlatform.get());
        System.out.println("Platform threads time     : " + (endPlatform - startPlatform) + " ms");

        // ─── Comparison Summary ───
        System.out.println("\n=== Comparison ===");
        System.out.println("Virtual  threads: 100,000 completed in " + (endVirtual - startVirtual) + " ms");
        System.out.println("Platform threads:   1,000 completed in " + (endPlatform - startPlatform) + " ms");
        System.out.println("Virtual threads are lightweight — millions can run concurrently!");
        System.out.println("Platform threads are OS-level and consume much more memory.");
    }
}
