import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem rs = new ReservationSystem();

        System.out.println("Welcome to the Airline Reservation System");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        User user = new User(UUID.randomUUID().toString(), name, email, "test123");

        System.out.print("Enter origin: ");
        String origin = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        List<Flight> availableFlights = rs.searchFlights(origin, destination);

        if (availableFlights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        System.out.println("Available Flights:");
        for (int i = 0; i < availableFlights.size(); i++) {
            System.out.println((i + 1) + ". " + availableFlights.get(i).getFlightId() + " (" +
                    availableFlights.get(i).getOrigin() + " to " + availableFlights.get(i).getDestination() + ")");
        }

        System.out.print("Select a flight (1,2...): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Flight selectedFlight = availableFlights.get(choice - 1);
        Ticket ticket = rs.bookTicket(user, selectedFlight);

        if (ticket != null) {
            System.out.println("Booking successful!");
            System.out.println(ticket);
        } else {
            System.out.println("Booking failed.");
        }
    }
}
