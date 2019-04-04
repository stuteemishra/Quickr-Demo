package com.example.quickrdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class AddPostActivity extends AppCompatActivity {

    private EditText mCategoryEditText;
    private EditText mBrandEditText;
    private EditText mPrice;
    private Button mPostAdBtn;
    private ImageView mUplaodedImgView;
    private ImageView mClickImgToUpload;
    private LinearLayout mImageUploadLayout;
    private int PICK_IMAGE_REQUEST = 1;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        mCategoryEditText = findViewById(R.id.input_category);
        mBrandEditText = findViewById(R.id.input_brand_name);
        mPrice = findViewById(R.id.input_price);
        mPostAdBtn = findViewById(R.id.post_ad_btn);
        mUplaodedImgView = findViewById(R.id.uploaded_image);
        mImageUploadLayout = findViewById(R.id.add_image_layout);
        mClickImgToUpload = findViewById(R.id.click_to_add_img);

        mClickImgToUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        mPostAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = mCategoryEditText.getText().toString();
                String brandName = mBrandEditText.getText().toString();
                String price = mPrice.getText().toString();
                if(categoryName.equals("") || brandName.equals("") || price.equals("")){
                    Toast.makeText(AddPostActivity.this,"All fields are mandatory!",Toast.LENGTH_SHORT).show();
                }else{
                    HomeActivity.mBitmapForAdImages[0] = bitmap;
                    HomeActivity.mProductTitleForAd[0] = brandName;
                    HomeActivity.mProductPrice[0] = price;
                    HomeActivity.mBitmapForAdImages[1] = bitmap;
                    HomeActivity.mProductTitleForAd[1] = brandName;
                    HomeActivity.mProductPrice[1] = price;
                    HomeActivity.mBitmapForAdImages[2] = bitmap;
                    HomeActivity.mProductTitleForAd[2] = brandName;
                    HomeActivity.mProductPrice[2] = price;
                    finish();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                mImageUploadLayout.setVisibility(View.GONE);
                mUplaodedImgView.setVisibility(View.VISIBLE);
                mUplaodedImgView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
