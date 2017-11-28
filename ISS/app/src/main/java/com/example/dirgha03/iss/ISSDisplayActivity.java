package com.example.dirgha03.iss;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class ISSDisplayActivity extends AppCompatActivity  {

    public ArrayList<products> proctsList;
    int position;

    String two = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();
        Intent intent  = getIntent();

        int position=intent.getIntExtra("list", 0);


        ArrayList<products> list = new ArrayList<>();

        ISSMydbhandler dbhandler=new ISSMydbhandler(this);

        list=dbhandler.databasep();

        this.proctsList=list;


        products localpro=proctsList.get(position);

        TextView tvName= (TextView)findViewById(R.id.tvName);

        tvName.setText(localpro.getItem_name());
        TextView tvDesc= (TextView)findViewById(R.id.tvDesc);
        tvDesc.setText(localpro.getDescription());
        TextView tvColor= (TextView)findViewById(R.id.tvColor);
        tvColor.setText(localpro.getColor_name());
        TextView tvPdate= (TextView)findViewById(R.id.tvPdate);
        tvPdate.setText(localpro.getDate());
        TextView tvBill= (TextView)findViewById(R.id.tvBill);
        tvBill.setText(localpro.getBill_name());
        TextView tvQuntity= (TextView)findViewById(R.id.tvQuntity);
        tvQuntity.setText(localpro.getQuntity());
        TextView tvMname= (TextView)findViewById(R.id.tvMname);
        tvMname.setText(localpro.getmName());
        TextView tvMadeof= (TextView)findViewById(R.id.tvMadeof);
        tvMadeof.setText(localpro.getmOf());
        TextView tvCost= (TextView)findViewById(R.id.tvCost);
        tvCost.setText(localpro.getmCost());
        TextView tvWarrenty= (TextView)findViewById(R.id.tvWarrenty);
        tvWarrenty.setText(localpro.getWarrenty());
        TextView tvMdate= (TextView)findViewById(R.id.tvMdate);
        tvMdate.setText(localpro.getmDate());
        TextView tvProperty=(TextView)findViewById(R.id.tvProperty);
        tvProperty.setText(localpro.getCheck1());

//code for decoded string image
        AppCompatImageView imageView = (AppCompatImageView)findViewById(R.id.imageView);

        String one =localpro.getPhoto();

        byte[] decodedString = Base64.decode(one, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);



       // Log.d(one,"");

    }
}
