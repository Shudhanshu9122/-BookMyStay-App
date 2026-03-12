/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v5.0          ");
        System.out.println("==========================================");

        BookingQueue bookingQueue = new BookingQueue();
        
        System.out.println("Receiving booking requests...");
        
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double Room"));
        
        System.out.println("\nRequests added to queue preserving arrival order.");
        
        bookingQueue.displayQueue();
        
        System.out.println("\nNo inventory mutation occurs at this stage.");
        System.out.println("==========================================");
    }
}
