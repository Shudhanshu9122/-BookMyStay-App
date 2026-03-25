import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
    }

    public double calculateTotalCost(String reservationId) {
        List<AddOnService> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        double total = 0;
        for (AddOnService s : services) {
            total += s.getPrice();
        }
        return total;
    }

    public void displayServices(String reservationId) {
        List<AddOnService> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        System.out.println("Add-On Services for Reservation: " + reservationId);
        if (services.isEmpty()) {
            System.out.println("No add-on services selected.");
        } else {
            for (AddOnService s : services) {
                System.out.println("- " + s.toString());
            }
            System.out.println("Total Add-On Cost: $" + calculateTotalCost(reservationId));
        }
    }
}
