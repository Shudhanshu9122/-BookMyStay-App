import java.util.List;

public class SearchService {
    private RoomInventory inventory;
    private List<Room> rooms;

    public SearchService(RoomInventory inventory, List<Room> rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    public void displayAvailableRooms() {
        System.out.println("--- Available Rooms ---");
        for (Room room : rooms) {
            int availableCount = inventory.getAvailableCount(room.getName());
            if (availableCount > 0) {
                System.out.println("Room Type: " + room.getName() + " | Beds: " + room.getNumberOfBeds() + 
                                   " | Price: $" + room.getPrice() + " | Available: " + availableCount);
            }
        }
    }
}
