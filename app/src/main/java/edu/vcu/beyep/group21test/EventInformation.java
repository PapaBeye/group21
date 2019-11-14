package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class EventInformation extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_information);

        backButton = findViewById(R.id.backToEventList);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        get_json();

    }

    public void get_json(){


        try{

            InputStream is = getAssets().open("events.json");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            String json = new String(buffer,"UTF-8");
            JSONArray jsonarray = new JSONArray(json);

            TextView viewName = findViewById(R.id.name);
            TextView viewDescription = findViewById(R.id.description);
            TextView viewLocation = findViewById(R.id.location);
            TextView viewFee = findViewById(R.id.fee);

            int numRetrieved = getIntent().getIntExtra("num", 0);
            JSONObject jsonobject= (JSONObject) jsonarray.get(numRetrieved);

            String eventName = jsonobject.optString("name");
            String eventDescription = jsonobject.optString("description");
            String eventLocation = jsonobject.optString("location");
            String eventFee = jsonobject.optString("fee");

            viewName.setText(eventName);
            viewDescription.setText(eventDescription);
            viewLocation.setText(eventLocation);
            viewFee.setText(eventFee);

        } catch (IOException | JSONException exc) {
            exc.printStackTrace();
        }

    }
}
