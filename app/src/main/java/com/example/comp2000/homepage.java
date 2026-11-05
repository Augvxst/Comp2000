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

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_homepage);
        TextView welcomeText = findViewById(R.id.welcomeText);
        animateText(welcomeText, "Welcome User");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button staffbutton = (Button) findViewById(R.id.staffButton);
        staffbutton.setOnClickListener(x -> onstaffButtonclick());

        Button Announcement_button = (Button) findViewById(R.id.AnnouncementButton);
        Announcement_button.setOnClickListener(x -> onAnnouncementsButtonclick());

        Button Messages_button = (Button) findViewById(R.id.messagesButton);
        Messages_button.setOnClickListener(x -> onMessagesButtonclick());

        Button Bookings_button = (Button) findViewById(R.id.bookingButton);
        Bookings_button.setOnClickListener(x -> onBookingsButtonclick());

    }

    void onstaffButtonclick() {
        Intent intent = new Intent(this, Stafflist.class);
        startActivity(intent);
    }
    void onAnnouncementsButtonclick() {
        Intent intent = new Intent(this, Announcements.class);
        startActivity(intent);
    }

    void onMessagesButtonclick() {
        Intent intent = new Intent(this, messages.class);
        startActivity(intent);
    }

    void onBookingsButtonclick() {
        Intent intent = new Intent(this, bookingroomnum.class);
        startActivity(intent);
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