package com.example.apprenti.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by apprenti on 19/09/17.
 */

public class SearchRequestModel implements Parcelable {

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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depart);
        dest.writeString(arrivee);
        dest.writeLong(date.getTime());
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>()
    {
        @Override
        public SearchRequestModel createFromParcel(Parcel source)
        {
            return new SearchRequestModel(source);
        }

        @Override
        public SearchRequestModel[] newArray(int size)
        {
            return new SearchRequestModel[size];
        }
    };

    public SearchRequestModel(Parcel in) {
        this.depart = in.readString();
        this.arrivee = in.readString();
        this.date = new Date(in.readLong());
    }

}