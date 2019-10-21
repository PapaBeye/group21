package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class EventInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_information);

        get_json();
    }

    public void get_json(){
        String json;

        try{
            InputStream is = getAssets().open("events.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonarray = new JSONArray(json);

            TextView name = findViewById(R.id.name);
            TextView description = findViewById(R.id.description);
            TextView location = findViewById(R.id.location);
            TextView fee = findViewById(R.id.fee);

            int num = getIntent().getIntExtra("num", 0);


            JSONObject jsonobject= (JSONObject) jsonarray.get(num);

            String id=jsonobject.optString("name");
            String value1=jsonobject.optString("description");
            String value2=jsonobject.optString("location");
            String value3=jsonobject.optString("fee");

            name.setText(id);
            description.setText(value1);
            location.setText(value2);
            fee.setText(value3);

        } catch (IOException a){
            a.printStackTrace();
        } catch (JSONException a){
            a.printStackTrace();
        }


    }
}
