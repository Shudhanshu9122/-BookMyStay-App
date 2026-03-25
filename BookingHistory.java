import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.Serializable;

public class BookingHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    public void addRecord(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
