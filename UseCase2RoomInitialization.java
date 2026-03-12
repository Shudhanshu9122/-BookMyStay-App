/**
 * Use Case 2: Basic Room Types & Static Availability
 * @version 2.0
 */
public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v2.0          ");
        System.out.println("==========================================");
        
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        System.out.println("\n--- Room Details & Availability ---");
        singleRoom.displayDetails();
        System.out.println("Available count: " + singleRoomAvailability);
        
        System.out.println();
        doubleRoom.displayDetails();
        System.out.println("Available count: " + doubleRoomAvailability);
        
        System.out.println();
        suiteRoom.displayDetails();
        System.out.println("Available count: " + suiteRoomAvailability);
        
        System.out.println("==========================================");
    }
}
