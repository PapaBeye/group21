package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

    // Event listing attributes. (How attributes are listed in code.
    String orderType = "Ascending"; // String noting if events are ordered in a ascending or discending fashion.
    String sortedBy = "Name"; // Notes which attribute of an event is used to sort the events in the list.

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

        displayEvents(); // This will actually get events "inflated"/listed onto the events page.

    }

    // Will return filter options results. Implemented by Jared Artis.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataRetrieved) {

        super.onActivityResult( requestCode, resultCode, dataRetrieved);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            orderType = dataRetrieved.getStringExtra("ORDER_TYPE");
            sortedBy = dataRetrieved.getStringExtra("SORTED_BY");

        }

    }

    // For preparing menu options (actionbar) before it is loaded when an activity starts.
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem navEvent = menu.findItem(R.id.Nav_Event);
        if ( navEvent != null ) navEvent.setVisible(false);

        MenuItem navConfig = menu.findItem(R.id.Nav_Config);
        if ( navConfig != null ) navConfig.setVisible(true);

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
        else if (menuItem.getItemId() == R.id.Nav_Config) {

            Intent intent = new Intent(this , EventListConfigPage.class);
            startActivity(intent);

        }

        return false;
    }

    // Implemented by Jared Artis, do not tinker with this unless your Jared Artis.
    // Will end up using sockets for this to connect to Papa Beye's end.
    public boolean displayEvents() {

        // Just testing out Layout Inflater.
        /*
        for (int i = 0; i < 5; i ++) {

            // Retrieves layout where xml will be inserted into by id "eventArea".
            LinearLayout baseLayout = (LinearLayout) findViewById(R.id.eventArea);

            // Gets layout inflator from the current "context".
            LayoutInflater layoutInflater = getLayoutInflater(); // Retrieves layout inflater of the current context.
            View retrievedView = layoutInflater.inflate(R.layout.events_tab , baseLayout, false);

            // Actually adds the view to the layout that we are "inflating into"
            baseLayout.addView(retrievedView);

            // Listeners will be attatched for every single event generated.
            // This will be a very hefty process. Poor time-complexity can ruin the functionality of this app in this stage.
            // Will use java library sort (especially dual pivot sort).
            retrievedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View givenView) {
                    // Will start activity when inflated event_tab is clicked on.
                }
            });

        }
        */

        return true;
    }

}
