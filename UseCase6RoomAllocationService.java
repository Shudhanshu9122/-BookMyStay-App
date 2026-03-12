/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.0
 */
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v6.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        System.out.println("Initializing inventory...");
        inventory.registerRoom("Single Room", 5);
        inventory.registerRoom("Double Room", 1);
        inventory.registerRoom("Suite Room", 2);

        BookingQueue queue = new BookingQueue();
        System.out.println("Adding booking requests to queue...");
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Double Room")); // Should fail
        queue.addRequest(new Reservation("Diana", "Suite Room"));

        System.out.println();
        BookingService bookingService = new BookingService(queue, inventory);
        
        // Process requests and allocate rooms
        bookingService.processPendingRequests();
        
        System.out.println();
        bookingService.displayAllocatedRooms();
        
        System.out.println();
        inventory.displayInventory();
        System.out.println("==========================================");
    }
}
