import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {
    private Queue<Reservation> queue;

    public BookingQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void addRequest(Reservation request) {
        queue.add(request);
    }

    public synchronized Reservation processNextRequest() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void displayQueue() {
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
