// Exercise 26: Thread Creation
public class ThreadCreation {

    // Thread using extends Thread
    static class MessageThread extends Thread {
        private String message;
        private int count;

        MessageThread(String message, int count) {
            this.message = message;
            this.count   = count;
        }

        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + message + " #" + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    // Thread using implements Runnable
    static class RunnableTask implements Runnable {
        private String task;

        RunnableTask(String task) { this.task = task; }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + task + " #" + i);
                try { Thread.sleep(150); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Thread 1 - extends Thread
        MessageThread t1 = new MessageThread("Hello from Thread-1", 4);
        t1.setName("Thread-A");

        // Thread 2 - implements Runnable
        Thread t2 = new Thread(new RunnableTask("Task from Thread-2"), "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both threads finished.");
    }
}
