package com.sir.app.photopicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sir.library.photopicker.PhotoPicker;
import com.sir.library.photopicker.PhotoPreview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button_no_camera).setOnClickListener(this);
        findViewById(R.id.button_one_photo).setOnClickListener(this);
        findViewById(R.id.button_photo_gif).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                PhotoPicker.builder()
                        .setPhotoCount(9)
                        .setGridColumnCount(4)
                        .start(this);
                break;
            case R.id.button_no_camera:
                PhotoPicker.builder()
                        .setPhotoCount(7)
                        .setShowCamera(false)
                        .setPreviewEnabled(false)
                        .start(this);
                break;
            case R.id.button_one_photo:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .start(this);
                break;
            case R.id.button_photo_gif:
                PhotoPicker.builder()
                        .setShowCamera(true)
                        .setShowGif(true)
                        .start(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {
            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                for (String str : photos) {
                    System.out.println(str);
                }
            }
            //     selectedPhotos.clear();
            if (photos != null) {
                // selectedPhotos.addAll(photos);
            }
            //  photoAdapter.notifyDataSetChanged();
        }
    }
}
