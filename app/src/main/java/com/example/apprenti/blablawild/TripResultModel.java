package com.example.apprenti.blablawild;

/**
 * Created by apprenti on 13/09/17.
 */

public class TripResultModel {

    private String firstName;
    private String departureTime;
    private int viewPrice;

    public TripResultModel(String firstName, String departureTime, int viewPrice) {
        this.firstName = firstName;
        this.departureTime = departureTime;
        this.viewPrice = viewPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getViewPrice() {
        return viewPrice;
    }

}
