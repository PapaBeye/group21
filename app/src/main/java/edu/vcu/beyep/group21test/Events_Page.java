package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Events_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout layoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events__page);

        layoutDrawer = findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(this, layoutDrawer, R.string.open, R.string.close);

        layoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.eventslist);

        ArrayList<String> events = new ArrayList<>();
        events.add("Ramfest");
        events.add("Fall Fest");
        events.add("VCU Mens BasketBall vs LSU");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, events);
        listView.setAdapter(adapter);

        EditText filter = (EditText) findViewById(R.id.search);
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (Events_Page.this).adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);

        onPrepareOptionsMenu(nav_view.getMenu());

    }

    // For preparing menu options (actionbar) before it is loaded when an activity starts.
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.Nav_Event);
        if ( item != null ) item.setVisible(false);
        else return false;

        return true;
    }

    // Implemented by Papa Beye.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if ( toggleDrawer.onOptionsItemSelected(item) ) return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId()== R.id.Nav_Food){
            Intent intent = new Intent(Events_Page.this , food_swipes.class);
            startActivity(intent);
        }
        else if (menuItem.getItemId() == R.id.Nav_create_event){
            Intent intent = new Intent(this , Create_Events_Page.class);
            startActivity(intent);
        }
        else if (menuItem.getItemId() == R.id.Nav_HomeScreen){
            Intent intent = new Intent(this , homeScreen.class);
            startActivity(intent);
        }

        return false;
    }


}
