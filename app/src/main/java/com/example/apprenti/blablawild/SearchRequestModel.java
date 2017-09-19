package com.example.apprenti.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 19/09/17.
 */

public class SearchRequestModel {

    private String depart;
    private String arrivee;
    private Date date;

    public SearchRequestModel(String depart, String arrivee, Date date) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.date = date;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
