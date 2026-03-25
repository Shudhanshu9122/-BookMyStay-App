import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CancellationService {
    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;
    private Stack<String> releasedRooms;

    public CancellationService(RoomInventory inventory, Map<String, Set<String>> allocatedRooms) {
        this.inventory = inventory;
        this.allocatedRooms = allocatedRooms;
        this.releasedRooms = new Stack<>();
    }

    public void cancelBooking(String roomType, String roomId) {
        System.out.println("Processing cancellation for Room ID: " + roomId + " (" + roomType + ")");
        
        Set<String> roomsOfType = allocatedRooms.get(roomType);
        
        if (roomsOfType != null && roomsOfType.contains(roomId)) {
            roomsOfType.remove(roomId);
            inventory.registerRoom(roomType, inventory.getAvailableCount(roomType) + 1); // increment
            releasedRooms.push(roomId);
            System.out.println("[SUCCESS] Cancellation confirmed. Room " + roomId + " released.");
        } else {
            System.out.println("[ERROR] Cancellation failed: Room " + roomId + " not found or already cancelled.");
        }
    }

    public void displayReleasedRooms() {
        System.out.println("--- Recently Released Rooms (LIFO) ---");
        if (releasedRooms.isEmpty()) {
            System.out.println("No rooms have been released.");
        } else {
            for (int i = releasedRooms.size() - 1; i >= 0; i--) {
                System.out.println("- " + releasedRooms.get(i));
            }
        }
    }
}
