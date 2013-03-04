package com.example.trippyTraveler_android.model.Null;


import com.example.trippyTraveler_android.model.Address;

public class NullAddress extends Address implements Nullable{
    @Override
    public boolean isNull() {
        return true;
    }
}
