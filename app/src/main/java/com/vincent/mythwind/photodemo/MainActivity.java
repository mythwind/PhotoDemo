package com.vincent.mythwind.photodemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.cameraview.CameraView;
import com.vincent.mythwind.photodemo.base.BaseActivity;
import com.vincent.mythwind.photodemo.utils.MLog;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private CameraView mCameraView;
    private ImageButton mIbPhotoButton;

    private CameraView.Callback mCallBack = new CameraView.Callback() {
        @Override
        public void onCameraOpened(CameraView cameraView) {
            super.onCameraOpened(cameraView);

            mCameraView.setVisibility(View.VISIBLE);
            MLog.err("onCameraOpened");
        }

        @Override
        public void onCameraClosed(CameraView cameraView) {
            MLog.err("onCameraClosed");
        }

        @Override
        public void onPictureTaken(CameraView cameraView, byte[] data) {
            //super.onPictureTaken(cameraView, data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentView();

        registerListinner();

        w();
        mCameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void initComponentView() {
        mCameraView = findViewById(R.id.viewport);
        mIbPhotoButton = findViewById(R.id.photo_button);

    }
    private void registerListinner() {
        mIbPhotoButton.setSoundEffectsEnabled(false);
        mIbPhotoButton.setOnClickListener(this);


        if (mCameraView != null) {
            mCameraView.addCallback(mCallBack);
        }

    }


    private void w() {
        if (e.b().intValue() != 0) {
            this.N.setImageResource(R.drawable.color_filter_selected);
        } else {
            this.N.setImageResource(R.drawable.color_filter_none);
        }
        this.M.setVisibility(0);
        this.L.setVisibility(0);
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        this.N.setVisibility(0);
        this.Z.setVisibility(4);
        this.Y.setVisibility(4);
        this.X.setVisibility(4);
        this.W.setVisibility(4);
        this.aa.setVisibility(4);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo_button:
                takePics();
                break;
        }
    }

    private void takePics() {
        MLog.err("====take pics");
        //mIbPhotoButton.setOnClickListener(null);
        if (mCameraView == null) {
            return ;
        }

        if(mCameraView.isCameraOpened()) {
            mCameraView.takePicture();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA) || Build.VERSION.SDK_INT < 23) {
                mCameraView.takePicture();

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if(grantResults[0] != 0) {
                    showToast(R.string.camera_permissions_not_granted);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    Intent intent = new Intent(this, MainActivity.class);
                    //268468224   0x10008000
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }

                return ;
        }
    }
}
