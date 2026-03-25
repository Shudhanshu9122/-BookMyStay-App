import java.util.List;

public class BookingReportService {
    private BookingHistory bookingHistory;

    public BookingReportService(BookingHistory bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public void generateSummaryReport() {
        List<Reservation> records = bookingHistory.getHistory();
        System.out.println("--- Booking Summary Report ---");
        System.out.println("Total Confirmed Bookings: " + records.size());
        
        int singleCount = 0, doubleCount = 0, suiteCount = 0;
        for (Reservation r : records) {
            switch (r.getRoomType()) {
                case "Single Room": singleCount++; break;
                case "Double Room": doubleCount++; break;
                case "Suite Room": suiteCount++; break;
            }
        }
        
        System.out.println("Single Rooms: " + singleCount);
        System.out.println("Double Rooms: " + doubleCount);
        System.out.println("Suite Rooms: " + suiteCount);
    }

    public void displayDetailedHistory() {
        List<Reservation> records = bookingHistory.getHistory();
        System.out.println("--- Detailed Booking History ---");
        if (records.isEmpty()) {
            System.out.println("No booking records found.");
        } else {
            for (int i = 0; i < records.size(); i++) {
                System.out.println((i + 1) + ". " + records.get(i).toString());
            }
        }
    }
}
