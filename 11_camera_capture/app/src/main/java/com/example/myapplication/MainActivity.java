package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView photoPreview;
    private TextView statusTextView;

    private final ActivityResultLauncher<Void> cameraLauncher =
            registerForActivityResult(new ActivityResultContracts.TakePicturePreview(), this::showPhotoPreview);

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

        photoPreview = findViewById(R.id.photoPreview);
        statusTextView = findViewById(R.id.statusTextView);
        Button openCameraButton = findViewById(R.id.openCameraButton);

        openCameraButton.setOnClickListener(v -> cameraLauncher.launch(null));
    }

    private void showPhotoPreview(Bitmap bitmap) {
        if (bitmap == null) {
            statusTextView.setText("Photo capture was cancelled.");
            Toast.makeText(this, "No photo captured", Toast.LENGTH_SHORT).show();
            return;
        }

        photoPreview.setImageBitmap(bitmap);
        statusTextView.setText("Photo captured successfully.");
        Toast.makeText(this, "Camera photo captured", Toast.LENGTH_SHORT).show();
    }
}
