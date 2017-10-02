package com.example.apprenti.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 13/09/17.
 */

public class TripResultModel {

    private String firstName;
    private Date departureTime;
    private int viewPrice;

    public TripResultModel(String firstName, Date departureTime, int viewPrice) {
        this.firstName = firstName;
        this.departureTime = departureTime;
        this.viewPrice = viewPrice;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public int getViewPrice() {
        return this.viewPrice;
    }

}