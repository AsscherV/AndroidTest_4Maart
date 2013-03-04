package com.example.trippyTraveler_android.controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.example.trippyTraveler_android.R;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 26/02/13
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
public class AlertDialogManagement {

    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */
    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
