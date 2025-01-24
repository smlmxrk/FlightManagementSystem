package mark.test.dao;

import mark.dao.FlightDAO;
import mark.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class FlightDAOTest {

    public static void main(String[] args) {
        FlightDAO flightDao = new FlightDAO();

        // add a new flight
        Flight newFlight = new Flight();
        newFlight.setFlightNumber("AI101");
        newFlight.setDestination("New York");
        newFlight.setDepartureTime(LocalDateTime.now().plusHours(3));
        newFlight.setArrivalTime(LocalDateTime.now().plusHours(8));
        newFlight.setGateNumber("G5");
        newFlight.setStatus("Scheduled");

        flightDao.addFlight(newFlight);


        List<Flight> flights = flightDao.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("No flights found in the database. Test failed!");
            return;
        }

        Flight addedFlight = flightDao.getFlightById(newFlight.getFlightID());
        if(addedFlight != null) {
            System.out.println("Flight added successfully: " + formatFlight(addedFlight));
        } else {
            System.out.println("Flight addition failed!");
        }

        // test to get all flights

        System.out.println("\nTesting getAllFlights...");
        System.out.println("Retrieved Flights:");

        for (Flight flight : flights) {
            System.out.println(formatFlight(flight));
        }

        // test: update the flight status

        System.out.println("\nTesting updateFlightStatus...");
        Flight firstFlight = flights.get(0);
        FlightDAO.updateFlightStatus(firstFlight.getFlightID(), "Delayed");

        Flight updatedFlight = flightDao.getFlightById(firstFlight.getFlightID());
        if (updatedFlight != null && "Delayed".equals(updatedFlight.getStatus())) {
            System.out.println("Flight status updated successfully: " + formatFlight(updatedFlight));
        } else {
            System.out.println("Failed to update flight status!");
        }

        // test: get flight by ID
        System.out.println("\nTesting getFlightById...");
        Flight flightById = flightDao.getFlightById(firstFlight.getFlightID());
        if (flightById != null) {
            System.out.println("Retrieved flight by ID successfully: " + formatFlight(flightById));
        } else {
            System.out.println("Failed to retrieve flight by ID!");
        }

        //database disconnect hook

        Runtime.getRuntime().addShutdownHook(new Thread(() ->  {
            try {
                if (mark.util.DBConnection.getConnection() != null &&
                    !mark.util.DBConnection.getConnection().isClosed()) {
                    mark.util.DBConnection.getConnection().close();
                    System.out.println("\nDatabase connection closed.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));

    }

    private static String formatFlight(Flight flight) {
        return String.format("Flight ID %d, Number: %s, Destination: %s, " +
                             "Departure: %s, Arrival %s, Gate: %s, Status: %s",
                             flight.getFlightID(),
                             flight.getFlightNumber(),
                             flight.getDestination(),
                             flight.getDepartureTime(),
                             flight.getArrivalTime(),
                             flight.getGateNumber(),
                             flight.getStatus());
    }
}
