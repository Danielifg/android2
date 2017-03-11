package com.danielifg.aa2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
/**
 *Class that will get the Extras in the bundle placed by the MainActivity.
 * The extras will contain the index position in the arrays, to display the correct content for each
 * selection in the ListView from dinoAdapter in MAinActivity.
 *
 * The method will place the content for the TextViews and the ImageView.
 *
 * @author Daniel Flores
 * @version 1.0
 */

public class Description extends AppCompatActivity {
    public static final String TAG = "ABOUTACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        String[] descriptions = getResources().getStringArray(R.array.dinosaursDescription);

        TextView title = (TextView) findViewById(R.id.descriptionTitle);
        TextView description = (TextView) findViewById(R.id.description);
        ImageView img = (ImageView) findViewById(R.id.descriptionImg);

        if (getIntent().hasExtra("dinos_img")) {
            title.setText(getIntent().getExtras().getString("dinos_img"));
            Log.d(TAG,"dino name found");
        } else {
            title.setText("No name");
            title.setTextColor(Color.RED);
            Log.d(TAG," No dino name found");
        }

        if (getIntent().hasExtra("dinos_ids")) {
            img.setImageResource(getIntent().getExtras().getInt("dinos_ids"));
            Log.d(TAG,"dino image in place");
        } else {
            img.setImageResource(R.drawable.devcartoon);
            Log.d(TAG,"image not found");
        }
        if (getIntent().hasExtra("index")) {

            int index = getIntent().getExtras().getInt("index");
            Log.d(TAG,"description in place");
            description.setText(descriptions[index]);

        } else {
            description.setText("No name");
            Log.d(TAG,"no desription found");
        }
    }


}
