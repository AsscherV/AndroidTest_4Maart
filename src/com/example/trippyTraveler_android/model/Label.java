package com.example.trippyTraveler_android.model;


import java.io.Serializable;


public class Label implements Serializable {
    private int id;
    private String name;
    //TODO: enkel cascade DELETE fzo
    //@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Trip trip;

    public Label() {
    }

    public Label(String label) {
        this.name=label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
