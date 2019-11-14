package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Spinner;
import android.util.Log;

public class EventListConfigPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_config);

        // Gives access to button for exiting (if no default android back button) if not back button is provided by default.
        Button backButton = (Button) findViewById(R.id.applyFilterButton);

        // Listener being established through lambda expression.
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    // Created a new intent to pass data back to list events page.
                    Intent intent = new Intent();

                    // Retrieves spinners to get selected data from.
                    Spinner orderTypeSpinner = (Spinner) findViewById(R.id.orderTypeSpinner);
                    Spinner sortedBySpinner = (Spinner) findViewById(R.id.sortedBySpinner);

                    // Put extra will package data into an intent to pass back to the events list page eventually.
                    // Packaging strings for now, but will use enums most likely.
                    intent.putExtra("ORDER_TYPE", orderTypeSpinner.getSelectedItem().toString() );
                    intent.putExtra("SORTED_BY",  sortedBySpinner.getSelectedItem().toString() );

                    setResult(RESULT_OK,intent);

                    finish(); // Exits activity officially.

            }

        });


    }

}
