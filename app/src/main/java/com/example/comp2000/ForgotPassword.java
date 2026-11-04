package com.example.comp2000;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(x -> OnBackButtonClick());

        Button confirmButton = (Button) findViewById(R.id.Confirm_button);
        confirmButton.setOnClickListener(x -> OnconfirmButtonClick());

        Button resetButton = (Button) findViewById(R.id.resend_email_button);
        resetButton.setOnClickListener(x -> OnresetButtonClick());
    }

    private void OnBackButtonClick() {
        finish();
    }

    private void OnconfirmButtonClick() {
       TextView resetText= (TextView) findViewById(R.id.reset_pass_text);
       resetText.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {
            resetText.setVisibility(View.INVISIBLE);
        }, 3000);
    }

    private void OnresetButtonClick() {
        showResetText();
    }

    private void showResetText() {
        TextView resetText = findViewById(R.id.reset_pass_text);

        resetText.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {
            resetText.setVisibility(View.INVISIBLE);
        }, 3000);
    }
}