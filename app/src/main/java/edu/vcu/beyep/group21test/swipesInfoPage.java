package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class swipesInfoPage extends AppCompatActivity {
    private TextView swipesInfo;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipes_info_page);
        swipesInfo = findViewById(R.id.swipesTextInfo);
        backButton = findViewById(R.id.back);
        swipesInfo.setText("Swipe Detail");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
