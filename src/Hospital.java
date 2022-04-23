import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private final List<Request> bookingHistory = new LinkedList<>();
    private final String name;
    private final Position position;

    public Hospital(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void addSuccessfulRequest(Request request) {
        bookingHistory.add(request);
    }

    /**
     * This method is used by the hospital client to get the list of previous bookings.
     */
    private void showBookingHistory() {
        bookingHistory.forEach(System.out::println);
    }
}
