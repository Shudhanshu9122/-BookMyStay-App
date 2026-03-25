import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("      Hotel Booking System v11.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        // Only 2 rooms available to test contention/exhaustion
        inventory.registerRoom("Single Room", 2);
        
        BookingQueue queue = new BookingQueue();
        
        // Simulating multiple threads adding to queue concurrently
        System.out.println("Guests are submitting requests simultaneously...");
        
        Thread t1 = new Thread(() -> queue.addRequest(new Reservation("User_A", "Single Room")));
        Thread t2 = new Thread(() -> queue.addRequest(new Reservation("User_B", "Single Room")));
        Thread t3 = new Thread(() -> queue.addRequest(new Reservation("User_C", "Single Room")));
        
        t1.start(); t2.start(); t3.start();
        
        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        queue.displayQueue();

        System.out.println("\nProcessing requests concurrently...");
        
        // Using a thread pool to simulate concurrent processing
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Reservation request = queue.processNextRequest();
                if (request != null) {
                    synchronized (inventory) {
                        if (inventory.getAvailableCount(request.getRoomType()) > 0) {
                            inventory.decrementAvailability(request.getRoomType());
                            System.out.println("[SUCCESS] Allocated for: " + request.getGuestName());
                        } else {
                            System.out.println("[FAILED] No rooms left for: " + request.getGuestName());
                        }
                    }
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Inventory State:");
        inventory.displayInventory();
        System.out.println("==========================================");
    }
}
