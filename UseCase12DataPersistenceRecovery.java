/**
 * Use Case 12: Data Persistence & System Recovery
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {
    private static final String INVENTORY_FILE = "inventory.ser";
    private static final String HISTORY_FILE = "history.ser";

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("      Hotel Booking System v12.0          ");
        System.out.println("==========================================");

        // Step 1: Simulate existing state and saving it
        System.out.println("--- Phase 1: Simulation of Data Saving ---");
        RoomInventory inventory = new RoomInventory();
        inventory.registerRoom("Single Room", 10);
        inventory.decrementAvailability("Single Room");
        
        BookingHistory history = new BookingHistory();
        history.addRecord(new Reservation("Grace", "Single Room"));

        PersistenceService.saveState(INVENTORY_FILE, inventory);
        PersistenceService.saveState(HISTORY_FILE, history);

        System.out.println("\n--- Phase 2: Simulation of System Restart & Recovery ---");
        // Simulate restart by trying to load from files
        RoomInventory recoveredInventory = (RoomInventory) PersistenceService.loadState(INVENTORY_FILE);
        BookingHistory recoveredHistory = (BookingHistory) PersistenceService.loadState(HISTORY_FILE);

        if (recoveredInventory != null) {
            System.out.println("Recovered Inventory:");
            recoveredInventory.displayInventory();
        }

        if (recoveredHistory != null) {
            System.out.println("Recovered Booking History:");
            for (Reservation r : recoveredHistory.getHistory()) {
                System.out.println("- " + r.toString());
            }
        }

        System.out.println("\nSystem operation resumed with recovered state.");
        System.out.println("==========================================");
    }
}
