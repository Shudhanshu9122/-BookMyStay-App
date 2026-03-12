/**
 * Use Case 3: Centralized Room Inventory Management
 * @version 3.0
 */
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v3.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        
        System.out.println("Initializing inventory...");
        inventory.registerRoom("Single Room", 5);
        inventory.registerRoom("Double Room", 3);
        inventory.registerRoom("Suite Room", 2);

        inventory.displayInventory();

        System.out.println("\nSimulating a booking for Single Room...");
        inventory.decrementAvailability("Single Room");

        inventory.displayInventory();
        System.out.println("==========================================");
    }
}
