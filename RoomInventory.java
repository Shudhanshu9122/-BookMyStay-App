import java.util.HashMap;
import java.util.Map;

import java.io.Serializable;

public class RoomInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public synchronized void registerRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public synchronized int getAvailableCount(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public synchronized void decrementAvailability(String roomType) {
        if (inventory.containsKey(roomType) && inventory.get(roomType) > 0) {
            inventory.put(roomType, inventory.get(roomType) - 1);
        }
    }

    public synchronized void displayInventory() {
        System.out.println("--- Current Inventory State ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " available");
        }
    }
}
