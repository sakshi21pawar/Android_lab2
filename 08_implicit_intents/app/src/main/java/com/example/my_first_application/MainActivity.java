package com.example.my_first_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSms, btnSettings, btnNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this matches XML name

        // Initialize buttons
        btnSms = findViewById(R.id.btnSms);
        btnSettings = findViewById(R.id.btnSettings);
        btnNetwork = findViewById(R.id.btnNetwork);

        // Send SMS
        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:9876543210")); // test number
            intent.putExtra("sms_body", "Hello from my_first_application!");
            startActivity(intent);
        });

        // Open general Settings
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        });

        // Open Network/Wireless Settings
        btnNetwork.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(intent);
        });
    }
}
