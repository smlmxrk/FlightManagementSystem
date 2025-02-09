package mark.dao;

import mark.model.Flight;
import mark.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FlightDAO {
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flights";

        try (Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setFlightNumber(rs.getString("flightNumber"));
                flight.setDestination(rs.getString("destination"));
                flight.setDepartureTime(rs.getTimestamp("departureTime").toLocalDateTime());
                flight.setArrivalTime(rs.getTimestamp("arrivalTime").toLocalDateTime());
                flight.setGateNumber(rs.getString("gateNumber"));
                flight.setStatus(rs.getString("status"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public void addFlight(Flight flight) {
        String sql  = "INSERT INTO Flights (flightNumber, destination, departureTime, arrivalTime, gateNumber, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, flight.getFlightNumber());
            pstmt.setString(2, flight.getDestination());
            pstmt.setTimestamp(3, Timestamp.valueOf(flight.getDepartureTime()));
            pstmt.setTimestamp(4, Timestamp.valueOf(flight.getArrivalTime()));
            pstmt.setString(5, flight.getGateNumber());
            pstmt.setString(6, flight.getStatus());

            pstmt.executeUpdate();
        }    catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteFlight(int flightID) {
        String sql = "DELETE FROM Flights WHERE flightID = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, flightID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void updateFlightStatus(int flightID, String status) {
        String sql = "UPDATE Flights SET status = ? WHERE flightID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, flightID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Flight getFlightById(int flightID) {
        String sql = "SELECT * FROM Flights WHERE flightID = ?";
        Flight flight = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, flightID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    flight = new Flight();
                    flight.setFlightID(rs.getInt("flightID"));
                    flight.setFlightNumber(rs.getString("flightNumber"));
                    flight.setDestination(rs.getString("destination"));
                    flight.setDepartureTime(rs.getTimestamp("departureTime").toLocalDateTime());
                    flight.setArrivalTime(rs.getTimestamp("arrivalTime").toLocalDateTime());
                    flight.setGateNumber(rs.getString("gateNumber"));
                    flight.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;

    }
}
