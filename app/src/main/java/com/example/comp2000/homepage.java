package com.example.comp2000;

import android.os.Bundle;
import android.os.Handler;
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