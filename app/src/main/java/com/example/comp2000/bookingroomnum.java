package com.example.comp2000;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class bookingroomnum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_bookingroomnum);
        TextView bookingText = findViewById(R.id.bookingText);
        animateText(bookingText, "Bookings");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(x -> OnhomeButtonClick());

        Button room1Button = (Button) findViewById(R.id.room1);
        room1Button.setOnClickListener(x -> Onroom1ButtonClick());

        Button room2Button = (Button) findViewById(R.id.room2);
        room2Button.setOnClickListener(x -> Onroom2ButtonClick());

        Button room3Button = (Button) findViewById(R.id.room3);
        room3Button.setOnClickListener(x -> Onroom3ButtonClick());

        Button room4Button = (Button) findViewById(R.id.room4);
        room4Button.setOnClickListener(x -> Onroom4ButtonClick());

        Button room5Button = (Button) findViewById(R.id.room5);
        room5Button.setOnClickListener(x -> Onroom5ButtonClick());


        Button mybookingButton = (Button) findViewById(R.id.bookingButton);
        mybookingButton.setOnClickListener(x -> OnbookingButtonClick());

        Button staffButton = (Button) findViewById(R.id.staffButton);
        staffButton.setOnClickListener(x -> OnstaffButtonClick());

    }

    private void OnstaffButtonClick() {
        Intent intent = new Intent(this, Stafflist.class);
        startActivity(intent);
    }

    private void OnbookingButtonClick(){
        Intent intent = new Intent(this, Mybookins.class);
        startActivity(intent);
    }
    private void Onroom1ButtonClick(){
        Intent intent = new Intent(this, bookings.class);
        startActivity(intent);
    }

    private void Onroom2ButtonClick(){
        Intent intent = new Intent(this, bookings.class);
        startActivity(intent);
    }

    private void Onroom3ButtonClick(){
        Intent intent = new Intent(this, bookings.class);
        startActivity(intent);
    }

    private void Onroom4ButtonClick(){
        Intent intent = new Intent(this, bookings.class);
        startActivity(intent);
    }

    private void Onroom5ButtonClick(){
        Intent intent = new Intent(this, bookings.class);
        startActivity(intent);
    }
    private void OnhomeButtonClick(){
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }
    private void OnBackButtonClick() {
        finish();
    }

    private void animateText(TextView textView, String text) {
        textView.setText("");

        Handler handler = new Handler();

        final int[] index = {0};

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (index[0] < text.length()) {

                    textView.append(
                            String.valueOf(text.charAt(index[0]))
                    );

                    index[0]++;

                    handler.postDelayed(this, 120);
                }
            }
        };

        handler.post(runnable);
    }
}
