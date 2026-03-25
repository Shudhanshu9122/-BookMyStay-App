/**
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v9.0          ");
        System.out.println("==========================================");

        RoomInventory inventory = new RoomInventory();
        inventory.registerRoom("Single Room", 1);
        inventory.registerRoom("Double Room", 0);
        inventory.registerRoom("Suite Room", 2);
        
        BookingValidator validator = new BookingValidator(inventory);
        
        System.out.println("Processing booking requests with validation...\n");
        
        Reservation[] testCases = {
            new Reservation("Alice", "Single Room"), // Valid
            new Reservation("", "Single Room"),      // Invalid Name
            new Reservation("Bob", "Penthouse"),     // Invalid Room Type
            new Reservation("Charlie", "Double Room"), // Fully Booked
            new Reservation("Diana", "Single Room")  // Will be fully booked after Alice
        };

        for (Reservation res : testCases) {
            String guestInfo = res.getGuestName().isEmpty() ? "<Empty>" : res.getGuestName();
            System.out.println("Attempting to book: " + guestInfo + " for " + res.getRoomType());
            try {
                validator.validateBooking(res);
                inventory.decrementAvailability(res.getRoomType());
                System.out.println("[SUCCESS] Booking confirmed for " + guestInfo + ".\n");
            } catch (InvalidBookingException e) {
                System.out.println("[ERROR] Booking failed: " + e.getMessage() + "\n");
            }
        }
        
        System.out.println("System remains stable and continues normal operation.");
        System.out.println("==========================================");
    }
}
