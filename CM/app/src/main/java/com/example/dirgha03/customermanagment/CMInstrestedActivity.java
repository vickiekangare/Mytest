package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CMInstrestedActivity extends AppCompatActivity implements CMAppConstant{

    public ArrayList<Details> proctsList;
   // int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested);
        getSupportActionBar().hide();
       Intent intent  = getIntent();
       int position=intent.getIntExtra(KEY_List, 0);
//        proctsList.get(position).getId();
        ArrayList<Details> list = new ArrayList<>();


        CMMydbhandler dbhandler=new CMMydbhandler(this);
        list=dbhandler.databasep();
        this.proctsList=list;

//        proctsList.get(position).getId();

        Details localpro=proctsList.get(position);


        TextView tvPay= (TextView)findViewById(R.id.tvPayType1);
        tvPay.setText(localpro.getProExpansetype());

        TextView tvRec= (TextView)findViewById(R.id.tvReccuring1);
        tvRec.setText(localpro.getProReccuring());

        TextView tvIns= (TextView)findViewById(R.id.tvInstall1);
        tvIns.setText(localpro.getProInstallmentcost());

        TextView mEtComments= (TextView)findViewById(R.id.etComments1);
        mEtComments.setText(localpro.getProComment());



    }
}