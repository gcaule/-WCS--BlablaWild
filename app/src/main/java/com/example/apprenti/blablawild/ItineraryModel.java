package com.example.apprenti.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 16/10/17.
 */

public class ItineraryModel {

    private int userID;
    private String lastName;
    private String firstName;

    private Date departureDate;
    private String price;
    private String departure;
    private String destination;
    private String departureTime;


    private ItineraryModel(int userID, String lastName, String firstName) {
        this.userID = userID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public ItineraryModel() {

    }

    public ItineraryModel(Date departureDate, String price, String departure, String destination, String departureTime) {
        this.departureDate = departureDate;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

}