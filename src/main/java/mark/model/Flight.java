package mark.model;

import java.time.LocalDateTime;

public class Flight {

    //fields

    private int flightID;
    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String gateNumber;
    private String status;

    public Flight() {

    }

    public Flight(int flightID, String flightNumber, String destination,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, String gateNumber) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gateNumber = gateNumber;
        this.status = status;
    }



    public int getFlightID() {
    return flightID;
    }

    public void setFlightID(int flightID) {
    this.flightID = flightID;
    }

    public String getFlightNumber() {
    return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
    }

    public String getDestination() {
    return destination;
    }

    public void setDestination(String destination) {
    this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
    return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //override method for showing the properties of a flight object
    @Override
    public String toString() {
        return "Flight {" +
                "flightID = " + flightID +
                ", flightNumber = " + flightNumber +
                ", destination = " + destination +
                ", departureTime = " + departureTime +
                ", arrivalTime = " + arrivalTime +
                ", gateNumber = " + gateNumber +
                ", status = " + status +
                '}';
    }


}
