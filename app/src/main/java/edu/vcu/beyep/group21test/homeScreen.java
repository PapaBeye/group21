package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

// coding i flow
public class homeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout  LayoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        LayoutDrawer =  findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(homeScreen.this,LayoutDrawer, R.string.open,R.string.close);
        LayoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);

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
            Toast.makeText(homeScreen.this, "Switching to Event page Activity",Toast.LENGTH_SHORT).show();
        }

        if (menuItem.getItemId()== R.id.Nav_Food){
            Toast.makeText(homeScreen.this, "Switching to Swipes page Activity",Toast.LENGTH_SHORT).show();
        }

        if (menuItem.getItemId() == R.id.Nav_create_event){
            Toast.makeText(homeScreen.this, "Switching to Create events page Activity",Toast.LENGTH_LONG).show();

        }
        return false;
    }
}
