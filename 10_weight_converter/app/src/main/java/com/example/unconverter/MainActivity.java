package com.example.unconverter;

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

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText kilogramsEditText;
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

        kilogramsEditText = findViewById(R.id.kilogramsEditText);
        Button convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(v -> convertWeight());
    }

    private void convertWeight() {
        String input = kilogramsEditText.getText().toString().trim();

        if (input.isEmpty()) {
            resultTextView.setText("Please enter a weight in kilograms.");
            Toast.makeText(this, "Input required", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double kilograms = Double.parseDouble(input);
            double grams = kilograms * 1000;
            double pounds = kilograms * 2.20462;
            double ounces = kilograms * 35.274;

            String result = String.format(
                    Locale.US,
                    "Kilograms: %.2f kg%nGrams: %.2f g%nPounds: %.2f lb%nOunces: %.2f oz",
                    kilograms,
                    grams,
                    pounds,
                    ounces
            );
            resultTextView.setText(result);
        } catch (NumberFormatException exception) {
            resultTextView.setText("Enter a valid numeric value.");
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }
}
