package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CMContactPersonActivity extends AppCompatActivity implements CMAppConstant{

    public ArrayList<Details> proctsList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmcontact_person);
        Intent intent  = getIntent();
        int position=intent.getIntExtra(KEY_List, 0);
        ArrayList<Details> list = new ArrayList<>();
        CMMydbhandler dbhandler=new CMMydbhandler(this);
        list=dbhandler.databasep();
        this.proctsList=list;
        Details localpro=proctsList.get(position);

        TextView tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvTitle.setText(localpro.getpName());

        TextView tvDesignation=(TextView)findViewById(R.id.tvDesignation);
        tvDesignation.setText(localpro.getoDesignation());

        TextView tvGender= (TextView)findViewById(R.id.tvGender);
        tvGender.setText(localpro.getpGender());

        TextView tvMob= (TextView)findViewById(R.id.tvMob);
        tvMob.setText(localpro.getpMob());

        TextView tvEmail= (TextView)findViewById(R.id.tvEmail);
        tvEmail.setText(localpro.getpEmail());
    }
}
