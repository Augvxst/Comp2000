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

public class messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_messages);
        TextView MessagesText = findViewById(R.id.messagesText);
        animateText(MessagesText, "Messages");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button staffButton= (Button) findViewById(R.id.staffButton);
        staffButton.setOnClickListener(x -> OnstaffButtonClick());

        Button messageButton= (Button) findViewById(R.id.sendMessage);
        messageButton.setOnClickListener(x -> OnMessageButtonClick());

        Button messageboxButton= (Button) findViewById(R.id.messageButton1);
        messageboxButton.setOnClickListener(x -> OnMessageboxButtonClick());

        Button messageboxButton1= (Button) findViewById(R.id.messageButton2);
        messageboxButton1.setOnClickListener(x -> OnMessageboxButtonClick());

        Button messageboxButton2= (Button) findViewById(R.id.messageButton3);
        messageboxButton2.setOnClickListener(x -> OnMessageboxButtonClick());

        Button messageboxButton3= (Button) findViewById(R.id.messageButton4);
        messageboxButton3.setOnClickListener(x -> OnMessageboxButtonClick());

        Button messageboxButton4= (Button) findViewById(R.id.messageButton5);
        messageboxButton4.setOnClickListener(x -> OnMessageboxButtonClick());

        Button messageboxButton5= (Button) findViewById(R.id.messageButton6);
        messageboxButton5.setOnClickListener(x -> OnMessageboxButtonClick());

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(x -> OnhomeButtonClick());

        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(x -> OnsettingsButtonClick());
    }


    private void OnsettingsButtonClick(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    private void OnstaffButtonClick(){
        Intent intent = new Intent(this, Stafflist.class);
        startActivity(intent);
    }

    private void  OnMessageButtonClick() {
        Intent intent = new Intent(this, sendmessage.class);
        startActivity(intent);
    }

    private void  OnMessageboxButtonClick() {
        Intent intent = new Intent(this, receivedmessage.class);
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