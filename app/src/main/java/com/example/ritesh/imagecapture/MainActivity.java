package com.example.ritesh.imagecapture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//https://developer.android.com/training/camera/photobasics.html
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView img_caputred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_caputred = (ImageView) findViewById(R.id.img_caputred);

        (findViewById(R.id.btn_capture)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraIntentToCaptureImage();
            }
        });
    }

    private void cameraIntentToCaptureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // resolveActivity() returns the first activity component that can handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img_caputred.setImageBitmap(imageBitmap);
        }
    }
}
