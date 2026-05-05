package com.example.inputcontrols;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnPickDate;
    TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickDate = findViewById(R.id.btnPickDate);
        txtDate = findViewById(R.id.txtDate);

        btnPickDate.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, y, m, d) -> {
                        String date = d + "/" + (m + 1) + "/" + y;
                        txtDate.setText("Selected Date: " + date);
                    },
                    year, month, day
            );

            dialog.show();
        });
    }
}