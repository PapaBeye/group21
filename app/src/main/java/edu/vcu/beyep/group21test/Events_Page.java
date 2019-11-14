package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        try {
            displayEvents();
        }catch (JSONException e){
            e.printStackTrace();
        }

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


    // Implemented by Jared Artis, do not tinker with this unless your Jared Artis.
    public boolean displayEvents() throws JSONException {
        List<String> Evnts = new ArrayList<String>();
        Evnts = homeScreen.Events;
        ListIterator<String> litr = Evnts.listIterator();
        int cur = 0;
        // Just testing out Layout Inflater.
        for (int i = 0; i < Evnts.size(); i ++) {
            String Stxt = Evnts.get(i);
            JSONObject obj = new JSONObject(Stxt);
            LinearLayout baseLayout = (LinearLayout) findViewById(R.id.eventArea);
            LayoutInflater layoutInflater = getLayoutInflater(); // Retrieves layout inflater of the current context.
            ConstraintLayout retrievedView = (ConstraintLayout) layoutInflater.inflate( R.layout.events_tab, baseLayout, false);
            ConstraintSet set = new ConstraintSet();
            LinearLayout linearLayout = new LinearLayout(retrievedView.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.setLayoutParams(params);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setId(View.generateViewId());
            TextView txtV = new TextView(linearLayout.getContext());
            txtV.setText(obj.getString("Event_Name"));
            txtV.setWidth(364);
            txtV.setHeight(50);
            txtV.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            txtV.setId(View.generateViewId());
            linearLayout.addView(txtV,0);
            txtV = new TextView(linearLayout.getContext());
            txtV.setText(obj.getString("Location"));
            txtV.setWidth(364);
            txtV.setHeight(50);
            txtV.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            txtV.setId(View.generateViewId());
            linearLayout.addView(txtV,1);
            txtV = new TextView(linearLayout.getContext());
            txtV.setText(obj.getString("Description"));
            txtV.setWidth(364);
            txtV.setHeight(110);
            txtV.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            txtV.setId(View.generateViewId());
            linearLayout.addView(txtV,2);
            retrievedView.addView(linearLayout,0);
            set.clone(retrievedView);
            set.connect(linearLayout.getId(),ConstraintSet.TOP,retrievedView.getId(),ConstraintSet.TOP,10);
            set.applyTo(retrievedView);
            baseLayout.addView((View) retrievedView);
        }

        return true;
    }

}
