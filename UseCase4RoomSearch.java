import java.util.Arrays;

/**
 * Use Case 4: Room Search & Availability Check
 * @version 4.0
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v4.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        System.out.println("Initializing inventory...");
        inventory.registerRoom("Single Room", 5);
        // Double Room deliberately set to 0 to show it's filtered out
        inventory.registerRoom("Double Room", 0);
        inventory.registerRoom("Suite Room", 2);

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        SearchService searchService = new SearchService(inventory, Arrays.asList(singleRoom, doubleRoom, suiteRoom));
        
        System.out.println("\nGuest initiates a room search...");
        searchService.displayAvailableRooms();
        
        System.out.println("\nSystem state (inventory) remains unchanged.");
        inventory.displayInventory();
        System.out.println("==========================================");
    }
}
