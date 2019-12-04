package edu.vcu.beyep.group21test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import com.google.android.material.navigation.NavigationView;

public class food_swipes extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    private DrawerLayout LayoutDrawer;
    private ActionBarDrawerToggle toggleDrawer;
    private Button BlickerButton;


    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_swipes);
        LayoutDrawer =  findViewById(R.id.drawer);
        toggleDrawer = new ActionBarDrawerToggle(this,LayoutDrawer, R.string.open,R.string.close);
        LayoutDrawer.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = findViewById(R.id.nav_drawer);
        nav_view.setNavigationItemSelectedListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button20 = (Button) findViewById(R.id.button20);
        button21 = (Button) findViewById(R.id.button21);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button24 = (Button) findViewById(R.id.button24);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
        button18.setOnClickListener(this);
        button19.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button24.setOnClickListener(this);
        onPrepareOptionsMenu(nav_view.getMenu());

    }

    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.Nav_Food);
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
            LayoutDrawer.closeDrawers();

        }

        if (menuItem.getItemId() == R.id.Nav_create_event){
            Intent intent = new Intent(this , Create_Events_Page.class);
            startActivity(intent);

        }
        if (menuItem.getItemId() == R.id.Nav_HomeScreen){
            Intent intent = new Intent(this , homeScreen.class);
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, FoodInformation.class);
        String num = "num";
        switch(view.getId()){
            case R.id.button1:
                intent.putExtra(num, 0);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.putExtra(num, 1);
                startActivity(intent);
                break;
            case R.id.button3:
                intent.putExtra(num, 2);
                startActivity(intent);
                break;
            case R.id.button4:
                intent.putExtra(num, 3);
                startActivity(intent);
                break;
            case R.id.button5:
                intent.putExtra(num, 4);
                startActivity(intent);
                break;
            case R.id.button6:
                intent.putExtra(num, 5);
                startActivity(intent);
                break;
            case R.id.button7:
                intent.putExtra(num, 6);
                startActivity(intent);
                break;
            case R.id.button8:
                intent.putExtra(num, 7);
                startActivity(intent);
                break;
            case R.id.button9:
                intent.putExtra(num, 8);
                startActivity(intent);
                break;
            case R.id.button10:
                intent.putExtra(num, 9);
                startActivity(intent);
                break;
            case R.id.button11:
                intent.putExtra(num, 10);
                startActivity(intent);
                break;
            case R.id.button12:
                intent.putExtra(num, 11);
                startActivity(intent);
                break;
            case R.id.button13:
                intent.putExtra(num, 12);
                startActivity(intent);
                break;
            case R.id.button14:
                intent.putExtra(num, 13);
                startActivity(intent);
                break;
            case R.id.button15:
                intent.putExtra(num, 14);
                startActivity(intent);
                break;
            case R.id.button16:
                intent.putExtra(num, 15);
                startActivity(intent);
                break;
            case R.id.button17:
                intent.putExtra(num, 16);
                startActivity(intent);
                break;
            case R.id.button18:
                intent.putExtra(num, 17);
                startActivity(intent);
                break;
            case R.id.button19:
                intent.putExtra(num, 18);
                startActivity(intent);
                break;
            case R.id.button20:
                intent.putExtra(num, 19);
                startActivity(intent);
                break;
            case R.id.button21:
                intent.putExtra(num, 20);
                startActivity(intent);
                break;
            case R.id.button22:
                intent.putExtra(num, 21);
                startActivity(intent);
                break;
            case R.id.button23:
                intent.putExtra(num, 22);
                startActivity(intent);
                break;
            case R.id.button24:
                intent.putExtra(num, 23);
                startActivity(intent);
                break;
        }
    }

}
