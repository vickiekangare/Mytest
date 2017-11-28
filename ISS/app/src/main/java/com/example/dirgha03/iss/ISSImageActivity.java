package com.example.dirgha03.iss;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


@SuppressWarnings("ALL")
public class ISSImageActivity extends AppCompatActivity implements IssAppConstants {

    public String Item_name2 = "";
    public String bill_name2 = "";
    public String Description2 = "";
    public String quantity2 = "";
    public String color2 = "";
    public String date2 = "";
    public String check1 = "";
    public String mDate = "";

    public String mName1 = "";
    public String mOf1 = "";
    public String mCost1 = "";
    public String mWarrenty = "";

    public String encodeString1 = "";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    ImageView imageView1;
    ISSMydbhandler dbhandler;

    private AppCompatImageView CircleImageView;


    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        getSupportActionBar().hide();


        // Button camera_button=(Button)findViewById(R.id.btnCamera);
        imageView = (ImageView) this.findViewById(R.id.ivItemimage);
        imageView1 = (ImageView) findViewById(R.id.ivCam);


        dbhandler = new ISSMydbhandler(this);


        Bundle Data = getIntent().getExtras();
        if (Data == null) {
            return;
        }

        Item_name2 = Data.getString(KEY_NEW_NAME);
        bill_name2 = Data.getString(KEY_NEW_BILL);
        Description2 = Data.getString(KEY_NEW_DESCRIPTION);
        quantity2 = Data.getString(KEY_NEW_QUNTITY);
        color2 = Data.getString(KEY_NEW_COLOR);
        date2 = Data.getString(DATE);
        mName1 = Data.getString(KEY_MNUFACTURER_NAME);
        mOf1 = Data.getString(KEY_MADE_OF);
        mCost1 = Data.getString(KEY_COST);
        mWarrenty = Data.getString(KEY_WARRENTY);
        check1 = Data.getString(KEY_MATERIAL);
        mDate = Data.getString(KEY_NEW_DATE);
        showDialogOnButtonClick();

    }


    public void showDialogOnButtonClick() {

        AppCompatImageView ivCam = (AppCompatImageView) findViewById(R.id.ivCam);


        ivCam.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (id == DIALOG_ID)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        return null;

    }


    /*
        public void launch_camera(View view)
        {
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
        }
    */
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            ByteArrayOutputStream baos = null;
            byte[] baat = null;
            String encodeString = null;

            baos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            baat = baos.toByteArray();
            encodeString = Base64.encodeToString(baat, Base64.DEFAULT);

            //System.out.print(encodeString);
         //   Log.d(encodeString,"");


            imageView.setImageBitmap(photo);

            encodeString1=encodeString;
        }

    }




        public void sub(View view)
        {
        products a = new products();
        a.setItem_name(Item_name2);
        a.setColor_name(color2);
        a.setBill_name(bill_name2);
        a.setDescription(Description2);
        a.setQuntity(quantity2);
        a.setCheck1(check1);
        a.setmCost(mCost1);
        a.setWarrenty(mWarrenty);
        a.setmName(mName1);
        a.setmOf(mOf1);
        a.setDate(date2);
        a.setmDate(mDate);
        a.setPhoto(encodeString1);




            if(encodeString1=="")
            {
                Toast.makeText(this,this.getString(R.string.snape), Toast.LENGTH_SHORT).show();

            }

            else
                {

                    dbhandler.addproduct(a);

                    dbhandler.databasep();

                    Toast.makeText(this,this.getString(R.string.Success), Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(this, ISSAddActivity.class);
                startActivity(intent);
            }
    }


}