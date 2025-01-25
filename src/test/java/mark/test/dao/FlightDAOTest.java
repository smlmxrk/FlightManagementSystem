package mark.test.dao;

import mark.dao.FlightDAO;
import mark.model.Flight;
import mark.util.DBConnection;

import java.time.LocalDateTime;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class FlightDAOTest {
    public static void main(String[] args) {
        FlightDAO flightDAO = new FlightDAO();
        Flight flight = new Flight();

        // Call the test methods here
        testToStringFlight(flight);
        clearFlightsTable(flightDAO);
        testAddFlight(flightDAO);
        testAddFlight2(flightDAO);
        testGetAllFlights(flightDAO);
        testUpdateFlightStatus(flightDAO);
        testGetFlightById(flightDAO);
        testGetFlightById2(flightDAO);
    }
    private static void clearFlightsTable(FlightDAO flightDAO) {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DELETE FROM Flights");

            statement.executeUpdate("ALTER TABLE Flights AUTO_INCREMENT=1");

            System.out.println("Flights table cleared and flightID reset.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testToStringFlight(Flight flight) {
        Flight flight1 = new Flight();

        flight1.setFlightNumber("A2103");
        flight1.setDestination("Atlanta");
        flight1.setDepartureTime(LocalDateTime.of(2025, 1, 10, 10, 10));
        flight1.setArrivalTime(LocalDateTime.of(2025, 1, 10, 13, 13));
        flight1.setGateNumber("G6");
        flight1.setStatus("Scheduled");

        System.out.println(flight1.toString());
    }

    private static void testAddFlight(FlightDAO flightDAO) {
        Flight flight = new Flight();
        flight.setFlightNumber("AI101");
        flight.setDestination("New York");
        flight.setDepartureTime(LocalDateTime.now().plusHours(3));
        flight.setArrivalTime(LocalDateTime.now().plusHours(8));
        flight.setGateNumber("G5");
        flight.setStatus("Scheduled");

        flightDAO.addFlight(flight);
        System.out.println("Test addFlight: Flight added successfully.");
    }

    // second method to test if the update method *actually* works
    private static void testAddFlight2(FlightDAO flightDAO) {
        Flight flight = new Flight();
        flight.setFlightNumber("AC606");
        flight.setDestination("Atlanta");
        flight.setDepartureTime(LocalDateTime.now().plusHours(4));
        flight.setArrivalTime(LocalDateTime.now().plusHours(9));
        flight.setGateNumber("G7");
        flight.setStatus("Scheduled");

        flightDAO.addFlight(flight);
        System.out.println("Test addFlight: Flight added successfully.");
    }

    private static void testGetAllFlights(FlightDAO flightDAO) {
        List<Flight> flights = flightDAO.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("Test getAllFlights: No flights found.");
        } else {
            System.out.println("Test getAllFlights: Retrieved flights:");
            for (Flight flight : flights) {
                System.out.println(flight.getFlightID() + " - " + flight.getFlightNumber() + " - " + flight.getStatus());
            }
        }
    }

    private static void testUpdateFlightStatus(FlightDAO flightDAO) {
        List<Flight> flights = flightDAO.getAllFlights();
        if (!flights.isEmpty()) {
            Flight flight = flights.getFirst(); // Get the first flight
            FlightDAO.updateFlightStatus(flight.getFlightID(), "Delayed");
            System.out.println("Test updateFlightStatus: Updated status for flight ID: " + flight.getFlightID());
        } else {
            System.out.println("Test updateFlightStatus: No flights available to update.");
        }
    }

    private static void testGetFlightById(FlightDAO flightDAO) {
        List<Flight> flights = flightDAO.getAllFlights();
        if (!flights.isEmpty()) {
            Flight flight = flightDAO.getFlightById(flights.get(0).getFlightID());
            System.out.println("Test getFlightById: Retrieved flight:\n " + flight.getFlightNumber() + " - " + flight.getStatus());
        } else {
            System.out.println("Test getFlightById: No flights found to retrieve.");
        }
    }

    private static void testGetFlightById2(FlightDAO flightDAO) {
        List<Flight> flights = flightDAO.getAllFlights();
        if (!flights.isEmpty()) {
            Flight flight = flightDAO.getFlightById(flights.get(1).getFlightID());
            System.out.println("Test getFlightById: Retrieved flight:\n " + flight.getFlightNumber() + " - " + flight.getStatus());
        } else {
            System.out.println("Test getFlightById: No flights found to retrieve.");
        }
    }
}
