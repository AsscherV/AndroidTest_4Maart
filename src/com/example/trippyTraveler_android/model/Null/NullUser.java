package com.example.trippyTraveler_android.model.Null;


import com.example.trippyTraveler_android.model.TripUser;

public class NullUser extends TripUser implements Nullable{
    @Override
    public boolean isNull() {
        return true;
    }
}
