package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Events_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout LayoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events__page);
        LayoutDrawer =  findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(this,LayoutDrawer, R.string.open,R.string.close);
        LayoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
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
            LayoutDrawer.closeDrawers();
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
            System.out.println("cbig check");
            Intent intent = new Intent(this , homeScreen.class);
            startActivity(intent);
        }
        return false;
    }


    @Override
    public void onClick(View view) {
            Intent intent = new Intent(this, EventInformation.class);
            String num = "num";
            switch(view.getId()){
                case R.id.button1:
                    intent.putExtra(num, 0);
                    startActivity(intent);
                    break;
            }
    }
}
