package mark.model;

import java.time.LocalDateTime;

public class Flight {

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



    public int flightID;
    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String gateNumber;
    private String status;
}
