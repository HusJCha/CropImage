package com.cropimage.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity
{
    Button btn_img;
    ImageView img_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByid();
        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(MainActivity.this);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                img_img.setImageURI(resultUri);
                Toast.makeText(getApplicationContext(),resultUri.toString(),Toast.LENGTH_SHORT).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    private void findViewByid()
    {
        btn_img = findViewById(R.id.btn_img);
        img_img = findViewById(R.id.img_img);
    }
}
