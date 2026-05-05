package com.example.input_controls;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextName;
    MaterialRadioButton radioMale, radioFemale;
    CheckBox checkBoxSubscribe;
    Button buttonSubmit;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        checkBoxSubscribe = findViewById(R.id.checkBoxSubscribe);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewOutput = findViewById(R.id.textViewOutput);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText() != null ? editTextName.getText().toString().trim() : "";
            String gender = radioMale.isChecked() ? "Male" :
                    radioFemale.isChecked() ? "Female" : "Not selected";
            boolean isSubscribed = checkBoxSubscribe.isChecked();

            String output = "Name: " + name + "\n" +
                    "Gender: " + gender + "\n" +
                    "Subscribed: " + (isSubscribed ? "Yes" : "No");

            textViewOutput.setText(output);
        });
    }
}