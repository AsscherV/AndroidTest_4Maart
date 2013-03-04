package com.example.trippyTraveler_android.model;



/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 28/02/13
 * Time: 15:03
 */


public class Cost {

    private int id;
    String text;
    int costValue;
    TripUser tripUser;
    Trip trip;

    public Cost() {
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCostValue() {
        return costValue;
    }

    public void setCostValue(int costValue) {
        this.costValue = costValue;
    }

    public TripUser getTripUser() {
        return tripUser;
    }

    public void setTripUser(TripUser tripUser) {
        this.tripUser = tripUser;
    }
}
