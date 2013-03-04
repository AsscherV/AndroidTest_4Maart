package com.example.trippyTraveler_android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.trippyTraveler_android.R;
import com.example.trippyTraveler_android.controllers.SessionManagement;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 26/02/13
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public class TripListActivity extends Activity {

    private TextView welcome;
    private Button logout;
    SessionManagement session;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triplist);

        session = new SessionManagement(getApplicationContext());
        welcome=(TextView)findViewById(R.id.tv_welcome);
        logout=(Button)findViewById(R.id.btn_logout);

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManagement.KEY_NAME);

        // email
        String email = user.get(SessionManagement.KEY_EMAIL);

        // displaying user data
        welcome.setText("Welcome, " + name + ", " + email);

        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();

            }
        });

        //initViews();
    }

}
