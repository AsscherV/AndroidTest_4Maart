package com.example.trippyTraveler_android;

import android.test.ActivityInstrumentationTestCase2;
import com.example.trippyTraveler_android.activities.LoginActivity;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.trippyTraveler_android.LoginActivityTest \
 * com.example.trippyTraveler_android.tests/android.test.InstrumentationTestRunner
 */
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super("com.example.trippyTraveler_android", LoginActivity.class);
    }

    public void testConnection(){

    }

}
