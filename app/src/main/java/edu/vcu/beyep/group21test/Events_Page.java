package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Events_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout layoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events__page);

        layoutDrawer = findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(this, layoutDrawer, R.string.open, R.string.close);

        layoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);

        onPrepareOptionsMenu(nav_view.getMenu());

        displayEvents();

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



    public boolean displayEvents() {

        LinearLayout targetLayout = findViewById(R.id.eventListLayout);
        /* NOW WE UNDERSTAND WHAT TO DO...
        LayoutInflater layoutInflater = getLayoutInflater(); // Gets layout inflater from the current "context"
        View recView = layoutInflater.inflate(R.layout.event_tab, null,false);
        View recView2 = layoutInflater.inflate(R.layout.event_tab, null,false);
        targetLayout.addView(recView);
        targetLayout.addView(recView2);
         */

        return true;
    }

}
