package com.hexadata.prototype.hexadata.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hexadata.prototype.hexadata.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by daudj on 8/3/2017.
 */

public class InputActivity extends AppCompatActivity {
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Bitmap bm= null;
    ImageView ivTicket;
    ImageView ivImage;
    ImageView ivMobil;
    private static final int REQUEST_WRITE_PERMISSION = 786;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        getSupportActionBar().hide();
        Button cancel = (Button) findViewById(R.id.btnCancle);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InputActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        ivTicket = (ImageView) findViewById(R.id.ivImageTicket);
        ivMobil = (ImageView) findViewById(R.id.ivImageMobil);
        ivTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                ivImage = ivTicket;
            }
        });
        ivMobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                ivImage = ivMobil;
            }
        });


    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
            selectImage();
        } else {
            selectImage();
        }
    }
    private void selectImage() {

       // final CharSequence[] items = {"Take Photo", "Choose from Library",
         //       "Cancel"};

        //AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("Add Photo!");
        //builder.setItems(items, new DialogInterface.OnClickListener() {
          //  @Override
            //public void onClick(DialogInterface dialog, int item) {
              //  if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

               // } else if (items[item].equals("Choose from Library")) {
                 //   Intent intent = new Intent(
                   //         Intent.ACTION_PICK,
                     //       MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   // intent.setType("image/*");
                    //startActivityForResult(
                      //      Intent.createChooser(intent, "Select File"),
                        //    SELECT_FILE);
               // } else if (items[item].equals("Cancel")) {
                 //   dialog.dismiss();
                //}
            //}
        //});
       // builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE) {
                //onSelectFromGalleryResult(data);
            } else if (requestCode == REQUEST_CAMERA) {
                onCaptureImageResult(data);
            }
        }
    }

    public void onCaptureImageResult(Intent data) {
        bm = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage.setImageBitmap(bm);

    }

}
