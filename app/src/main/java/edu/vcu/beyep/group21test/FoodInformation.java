package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodInformation extends AppCompatActivity {

    ArrayList<String> numberlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_information);

        get_json();
    }

    public void get_json(){
        String json;

        try{
            InputStream is = getAssets().open("swipes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonarray = new JSONArray(json);

            TextView name = findViewById(R.id.name);
            TextView description = findViewById(R.id.descrtiption);
            TextView acceptsSwipes = findViewById(R.id.acceptsSwipes);
            TextView linkToMenu = findViewById(R.id.linkToMenu);

            int num = getIntent().getIntExtra("num", 0);


            JSONObject jsonobject= (JSONObject) jsonarray.get(num);

            String id=jsonobject.optString("name");
            String value1=jsonobject.optString("description");
            String value2=jsonobject.optString("accepts swipes");
            String value3=jsonobject.optString("link to menu");

            name.setText(id);
            description.setText(value1);
            acceptsSwipes.setText(value2);
            linkToMenu.setText(value3);

        } catch (IOException a){
            a.printStackTrace();
        } catch (JSONException a){
            a.printStackTrace();
        }


    }
}
