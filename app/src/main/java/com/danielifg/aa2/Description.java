package com.danielifg.aa2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        TextView title = (TextView) findViewById(R.id.descriptionTitle);
        ImageView img = (ImageView) findViewById(R.id.descriptionImg);

        if(getIntent().hasExtra("dinos_img")){
            title.setText(getIntent().getExtras().getString("dinos_img"));
        }else{
            title.setText("No name");
            title.setTextColor(Color.RED);
        }

        if(getIntent().hasExtra("dinos_ids")){
            img.setImageResource(getIntent().getExtras().getInt("dinos_ids"));
        }else{
            img.setImageResource(R.drawable.devcartoon);
        }

    }
}
