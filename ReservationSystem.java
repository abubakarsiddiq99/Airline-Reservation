import java.util.*;

public class ReservationSystem {
    private List<Flight> flights = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public ReservationSystem() {
        // Adding sample flights
        flights.add(new Flight("AIR_IND-101", "Hyderabad", "Trivandrum", "10:00", "22:00", 5));
        flights.add(new Flight("AIR_IND-201", "Trivandrum", "Hyderabad", "22:00", "10:00", 2));
        flights.add(new Flight("AIR_IND-102", "Mumbai", "Delhi", "08:00", "23:00", 2));
        flights.add(new Flight("AIR_IND-202", "Delhi", "Mumbai", "23:00", "08:00", 2));
    }

    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination)) {
                results.add(f);
            }
        }
        return results;
    }

    public Ticket bookTicket(User user, Flight flight) {
        if (flight.bookSeat()) {
            String ticketId = UUID.randomUUID().toString();
            String seat = "A" + (5 - flight.getSeatsAvailable());
            Ticket ticket = new Ticket(ticketId, user, flight, seat, new Date());
            tickets.add(ticket);

            // Generate PDF for the booking
            PDFGenerator.generateBookingPDF(ticket);

            return ticket;
        } else {
            System.out.println("No seats available on this flight.");
            return null;
        }
    }
}
