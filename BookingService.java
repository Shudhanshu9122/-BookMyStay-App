import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BookingService {
    private BookingQueue bookingQueue;
    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;

    public BookingService(BookingQueue queue, RoomInventory inventory) {
        this.bookingQueue = queue;
        this.inventory = inventory;
        this.allocatedRooms = new HashMap<>();
    }

    public void processPendingRequests() {
        System.out.println("Processing booking requests...");
        while (!bookingQueue.isEmpty()) {
            Reservation request = bookingQueue.processNextRequest();
            String roomType = request.getRoomType();
            
            if (inventory.getAvailableCount(roomType) > 0) {
                // Generate unique room ID
                String prefix = roomType.substring(0, 3).toUpperCase();
                String uniqueId = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
                String roomId = prefix + "-" + uniqueId;
                
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                
                // Ensure room uniqueness (Set structure implicitly tracks uniqueness)
                allocatedRooms.get(roomType).add(roomId);
                
                // Decrement inventory immediately
                inventory.decrementAvailability(roomType);
                System.out.println("Confirmed! " + request.getGuestName() + " is allocated room: " + roomId);
            } else {
                System.out.println("Failed: " + request.getGuestName() + " - " + roomType + " is fully booked.");
            }
        }
    }

    public void displayAllocatedRooms() {
        System.out.println("--- Allocated Rooms ---");
        if (allocatedRooms.isEmpty()) {
            System.out.println("No rooms allocated yet.");
        } else {
            for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
