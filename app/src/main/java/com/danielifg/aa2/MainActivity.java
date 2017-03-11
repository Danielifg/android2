package com.danielifg.aa2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Main Application class responsible for the implementation and logic of the menu.
 * Here we get the data from the resource directory to inflate an
 * Adapter with a ListView.
 *
 * @author Daniel Flores
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    public static final String TAG = "MAINACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getPreferences(MODE_PRIVATE);

        String[] nameTitle = getResources().getStringArray(R.array.dinosaursNames);

        int[] dinos = {R.drawable.achelousaurus_1, R.drawable.allosaurus_2, R.drawable.centrosaurus_3,
                R.drawable.spinosaurus_4, R.drawable.utahraptor_5,
                R.drawable.rajasaurus_6, R.drawable.albertosaurus_7,
                R.drawable.avaceratops_8, R.drawable.anchiceratops_9,
                R.drawable.nipponosaurus_10};


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new dinoAdapter(this, nameTitle, dinos));

    }
//onCreate

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //onCreateOptionsMenu

    /*
    Method to handle the menu itemListeners, calling a website and
    starting another activity.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.www:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.sciencekids.co.nz/pictures/dinosaurs.html"));
                startActivity(intent);
                Log.d(TAG, "web source selected");
                return true;
            case R.id.about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                Log.d(TAG, "about selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //onOptionsItemSelected

    /**
     * This class will extend the baseAdapter class, setting the constructor for
     * the String and Integer arrays.
     * Override its methods and place the logic to inflate it .
     */

    public class dinoAdapter extends BaseAdapter {
        private Context context;
        String[] dinoList;
        int[] dinoIds;
        LayoutInflater inflater;

        public dinoAdapter(Context c, String[] list, int[] imageId) {
            context = c;
            dinoList = list;
            dinoIds = imageId;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return dinoList.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }


        public class ViewHolder {
            TextView desc;
            ImageView img;

        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder vh = new ViewHolder();
            View row = convertView;

            // Here I get the reference to the custom_view for the adapter.

            if (convertView == null) {
                row = inflater.inflate(R.layout.custom_item, null);
                vh.desc = (TextView) row.findViewById(R.id.itemTV);
                vh.img = (ImageView) row.findViewById(R.id.itemIV);
                vh.desc.setText(dinoList[position]);
                vh.img.setImageResource(dinoIds[position]);
                row.setTag(vh);
                Log.d(TAG,"adapter Inflated" );
            } else {
                vh = (ViewHolder) convertView.getTag();
                vh.desc.setText(dinoList[position]);
                vh.img.setImageResource(dinoIds[position]);
            }
            row.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    //Here I am bundling the index position of both arrays to use them
                    // from another activity.

                    Intent intent = new Intent(context, Description.class);
                    intent.putExtra("dinos_img", dinoList[position]);
                    intent.putExtra("dinos_ids", dinoIds[position]);
                    intent.putExtra("index", position);
                    context.startActivity(intent);
                    Log.d(TAG, dinoList[position]);


                }
            });
            return row;


        }
    }


}
