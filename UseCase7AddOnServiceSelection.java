/**
 * Use Case 7: Add-On Service Selection
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v7.0          ");
        System.out.println("==========================================");

        AddOnServiceManager serviceManager = new AddOnServiceManager();
        
        AddOnService wifi = new AddOnService("Premium WiFi", 15.0);
        AddOnService breakfast = new AddOnService("Breakfast Buffet", 25.0);
        AddOnService spa = new AddOnService("Spa Access", 50.0);
        
        String reservationId = "RES-1001";
        
        System.out.println("Guest adds services for reservation " + reservationId + "...");
        serviceManager.addService(reservationId, wifi);
        serviceManager.addService(reservationId, breakfast);
        
        String anotherResId = "RES-2022";
        serviceManager.addService(anotherResId, spa);
        
        System.out.println();
        serviceManager.displayServices(reservationId);
        
        System.out.println();
        serviceManager.displayServices(anotherResId);
        
        System.out.println("\nCore booking and inventory state remain unchanged.");
        System.out.println("==========================================");
    }
}
