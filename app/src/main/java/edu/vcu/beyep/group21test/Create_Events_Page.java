package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Create_Events_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout LayoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__events__page);
        LayoutDrawer =  findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(this,LayoutDrawer, R.string.open,R.string.close);
        LayoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);
        onPrepareOptionsMenu(nav_view.getMenu());

    }

    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.Nav_create_event);
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
            LayoutDrawer.closeDrawers();


        }
        if (menuItem.getItemId() == R.id.Nav_HomeScreen){
            Intent intent = new Intent(this , homeScreen.class);
            startActivity(intent);
        }
        return false;
    }
}
