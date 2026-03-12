import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {
    private Queue<Reservation> queue;

    public BookingQueue() {
        this.queue = new LinkedList<>();
    }

    public void addRequest(Reservation request) {
        queue.add(request);
    }

    public Reservation processNextRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        System.out.println("--- Current Booking Queue ---");
        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            for (Reservation r : queue) {
                System.out.println(r.toString());
            }
        }
    }
}
