class MyThread extends Thread {
   

    public void run() {
        // Simulate some work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println();
            e.printStackTrace();
        }
        System.out.println("Task " + Thread,currentThread().getId() + " is running");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create 5 threads
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        thread1.start();
        thread1.start();
        
        

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
        }
            

            catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("All tasks completed");
        }

    }

