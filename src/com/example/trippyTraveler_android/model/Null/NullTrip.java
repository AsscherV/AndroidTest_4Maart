package com.example.trippyTraveler_android.model.Null;


import com.example.trippyTraveler_android.model.Trip;

public class NullTrip extends Trip implements Nullable{
    @Override
    public boolean isNull() {
        return true;
    }
}
