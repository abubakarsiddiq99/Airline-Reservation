import java.util.Date;

public class Ticket {
    private String ticketId;
    private User user;
    private Flight flight;
    private String seat;
    private Date bookingDate;

    public Ticket(String ticketId, User user, Flight flight, String seat, Date bookingDate) {
        this.ticketId = ticketId;
        this.user = user;
        this.flight = flight;
        this.seat = seat;
        this.bookingDate = bookingDate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public User getUser() {
        return user;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeat() {
        return seat;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + "\n" +
                "Passenger Name: " + user.getName() + "\n" +
                "Flight: " + flight.getFlightId() + " (" + flight.getOrigin() + " to " + flight.getDestination() + ")\n" +
                "Seat: " + seat + "\n" +
                "Booking Date: " + bookingDate;
    }
}
