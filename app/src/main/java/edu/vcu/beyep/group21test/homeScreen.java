package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// coding i flow
public class homeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout  LayoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;
    public static List<String> Events = new ArrayList<String>();
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        LayoutDrawer =  findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(homeScreen.this,LayoutDrawer, R.string.open,R.string.close);
        LayoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);
        onPrepareOptionsMenu(nav_view.getMenu());
        Thread server = new ServerClient(homeScreen.this);
        server.start();
        ListView listView = (ListView) findViewById(R.id.eventslist);

        ArrayList<String> events = new ArrayList<>();
        events.add("Ramfest");
        events.add("Fall Fest");
        events.add("VCU Mens BasketBall vs LSU");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, events);
        listView.setAdapter(adapter);

        SearchView filter =  findViewById(R.id.search);
        filter.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }


    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.Nav_HomeScreen);
        if ( item != null ) item.setVisible(false);
        else return false;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (toggleDrawer.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.Nav_Event){
            Intent intent = new Intent(this , Events_Page.class);
            startActivity(intent);
        }

        if (menuItem.getItemId()== R.id.Nav_Food){
            Intent intent = new Intent(this , food_swipes.class);
            startActivity(intent);
        }

        if (menuItem.getItemId() == R.id.Nav_create_event){
            Intent intent = new Intent(this , Create_Events_Page.class);
            startActivity(intent);

        }
        if (menuItem.getItemId() == R.id.Nav_HomeScreen){
            LayoutDrawer.closeDrawers();
        }
        return false;
    }

}
