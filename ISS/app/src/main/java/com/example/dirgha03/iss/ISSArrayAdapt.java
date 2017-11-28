package com.example.dirgha03.iss;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v4.widget.ListViewCompat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ISSArrayAdapt extends ArrayAdapter<products> {
    Context context;
    public ArrayList<products> proctsList;

    public ISSArrayAdapt(Context context, ArrayList<products> list) {
        super(context, R.layout.list, list);
        this.context = context;
        this.proctsList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.list, parent, false);
        TextView tvItemName = (TextView) rowView.findViewById(R.id.tvItemName);
        TextView tvMname = (TextView) rowView.findViewById(R.id.tvMname);
        TextView tvMcost = (TextView) rowView.findViewById(R.id.tvMcost);


        AppCompatImageView ivThumbnail = (AppCompatImageView) rowView.findViewById(R.id.ivThumbnail);


        products localpro = proctsList.get(position);


        tvItemName.setText(localpro.getItem_name());
        tvMname.setText(localpro.getmName());
        tvMcost.setText(localpro.getmCost());


        String one = localpro.getPhoto();

        byte[] decodedString = Base64.decode(one, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        ivThumbnail.setImageBitmap(decodedByte);

        return rowView;


    }

}
