package com.example.app_progressbar;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView textView = findViewById(R.id.tvRating);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                progressBar.setProgress((int) rating);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Rating Submitted");
                builder.setMessage("You selected rating: " + rating);
                builder.setPositiveButton("OK", null);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}