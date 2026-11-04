package com.example.comp2000;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Login_button = (Button) findViewById(R.id.login_button);
        Login_button.setOnClickListener(x -> onLoginButtonclick());

        Button resetpass_button = (Button) findViewById(R.id.reset_pass_button);
        resetpass_button.setOnClickListener(x -> onResetPassButtonclick());

    }


    void onLoginButtonclick() {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);

    }

    void onResetPassButtonclick() {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    private void OnBackButtonClick() {
        finish();
    }


}