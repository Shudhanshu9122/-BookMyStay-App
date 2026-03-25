import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * @version 10.0
 */
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("      Hotel Booking System v10.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        inventory.registerRoom("Single Room", 5);
        inventory.registerRoom("Double Room", 2);
        
        // Simulating some existing allocations
        Map<String, Set<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.get("Single Room").add("SIN-1234");
        allocatedRooms.get("Single Room").add("SIN-5678");
        inventory.decrementAvailability("Single Room");
        inventory.decrementAvailability("Single Room"); // available is now 3
        
        CancellationService cancellationService = new CancellationService(inventory, allocatedRooms);
        
        System.out.println("Initial Inventory State:");
        inventory.displayInventory();
        
        System.out.println("\nExecuting Cancellations...");
        cancellationService.cancelBooking("Single Room", "SIN-1234");
        cancellationService.cancelBooking("Single Room", "SIN-9999"); // Doesn't exist
        cancellationService.cancelBooking("Single Room", "SIN-5678");
        
        System.out.println("\nPost-Cancellation Inventory State:");
        inventory.displayInventory();
        
        System.out.println();
        cancellationService.displayReleasedRooms();
        
        System.out.println("==========================================");
    }
}
