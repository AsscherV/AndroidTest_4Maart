package com.example.trippyTraveler_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.trippyTraveler_android.R;
import com.example.trippyTraveler_android.controllers.AlertDialogManagement;
import com.example.trippyTraveler_android.controllers.NetworkController;
import com.example.trippyTraveler_android.controllers.SessionManagement;
import com.example.trippyTraveler_android.model.TripUser;
import com.example.trippyTraveler_android.util.SHAEncryption;

public class LoginActivity extends Activity {
    private EditText em,pw;
    private TextView error;
    private Button login;
    private ProgressBar progressbar;

    SessionManagement session;
    AlertDialogManagement alert = new AlertDialogManagement();

    private String path;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        session = new SessionManagement(getApplicationContext());

        login=(Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = em.getText().toString();
                String password = pw.getText().toString();

                if(email.equals("") || password.equals("")){
                    error.setText("You must fill in username & password.");
                    alert.showAlertDialog(LoginActivity.this,"Login failed...","Username/password cannot be empty.",false);
                }
                else {
                    //password = SHAEncryption.encrypt(password);
                    error.setVisibility(View.VISIBLE);
                    error.setText(password);
                    path = "/rest/login?Username=" + email + "&Password=" + password;
                    getData(path);
                }

            }
        });

        initViews();
    }

    private void initViews() {
        em=(EditText)findViewById(R.id.et_email);
        pw=(EditText)findViewById(R.id.et_password);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        error=(TextView)findViewById(R.id.tv_error);
        progressbar.setVisibility(View.GONE);
    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, TripUser>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {
                error.setVisibility(View.GONE);
                progressbar.setVisibility(View.VISIBLE);
                super.onPreExecute();
            }

            @Override
            protected TripUser doInBackground(Void... params) {
                TripUser tripUser = null;

                try {
                    tripUser = new NetworkController().getDataFromServer(path);
                } catch (Exception e) {
                    exception = e;
                }

                return tripUser;
            }

            @Override
            protected void onPostExecute(TripUser result) {
                if(exception == null && result != null) {
                    error.setText(result.toString());
                    //nieuwe intent starten & user aan session toevoegen
                    session.createLoginSession(result.getEmail(),result.getPassword());

                    // Staring MainActivity
                    Intent i = new Intent(getApplicationContext(), TripListActivity.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Oops. Something went wrong!", Toast.LENGTH_SHORT).show();
                    error.setText(exception.getMessage().toString());
                }

                error.setVisibility(View.VISIBLE);
                progressbar.setVisibility(View.GONE);
            }

        }.execute();
    }

}

