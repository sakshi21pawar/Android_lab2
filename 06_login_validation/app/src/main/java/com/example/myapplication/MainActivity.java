package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        resultTextView = findViewById(R.id.resultTextView);

        loginButton.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            resultTextView.setText("Please enter both username and password.");
            Toast.makeText(this, "Missing login details", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            resultTextView.setText("Password must contain at least 6 characters.");
            Toast.makeText(this, "Weak password", Toast.LENGTH_SHORT).show();
            return;
        }

        resultTextView.setText("Login details accepted for user: " + username);
        Toast.makeText(this, "Login validated successfully", Toast.LENGTH_SHORT).show();
    }
}
