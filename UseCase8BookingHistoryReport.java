/**
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Hotel Booking System v8.0          ");
        System.out.println("==========================================");

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService(history);
        
        System.out.println("Simulating confirmed bookings...");
        history.addRecord(new Reservation("Alice", "Single Room"));
        history.addRecord(new Reservation("Bob", "Double Room"));
        history.addRecord(new Reservation("Charlie", "Single Room"));
        history.addRecord(new Reservation("Diana", "Suite Room"));
        
        System.out.println("\nAdmin requests detailed booking history...");
        reportService.displayDetailedHistory();
        
        System.out.println("\nAdmin requests summary report...");
        reportService.generateSummaryReport();
        
        System.out.println("==========================================");
    }
}
