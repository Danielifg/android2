package com.danielifg.aa2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * This class is used only to display the view
 * for the developer information.
 *
 * @author Daniel Flores
 * @version 1.0
 */

public class About extends AppCompatActivity {
    public static final String TAG = "ABOUTACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.d(TAG,"about activity invocation");
    }

}
