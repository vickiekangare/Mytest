package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import java.util.ArrayList;

public class CMProductActivity extends AppCompatActivity {

    public ArrayList<Details> proctsList;
   // int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_product_display);
        getSupportActionBar().hide();

        Intent intent  = getIntent();
        int position=intent.getIntExtra("list", 0);
//        proctsList.get(position).getId();
        ArrayList<Details> list = new ArrayList<>();

        CMMydbhandler dbhandler=new CMMydbhandler(this);
        list=dbhandler.databasep();
        this.proctsList=list;

//        proctsList.get(position).getId();

        Details localpro=proctsList.get(position);


        TextView tvProName=(TextView)findViewById(R.id.tvProName);
        tvProName.setText(localpro.getProName());

        TextView tvPay= (TextView)findViewById(R.id.tvPayType);
        tvPay.setText(localpro.getProExpansetype());

        TextView tvRec= (TextView)findViewById(R.id.tvReccuring);
        tvRec.setText(localpro.getProReccuring());

        TextView tvIns= (TextView)findViewById(R.id.tvInstall);
        tvIns.setText(localpro.getProInstallmentcost());

        TextView mEtFeachers=(TextView)findViewById(R.id.etFeachers);
        mEtFeachers.setText(localpro.getProFeacher());

        TextView mEtImprovements= (TextView)findViewById(R.id.etImprovements);
        mEtImprovements.setText(localpro.getProImprovement());

        TextView mEtComments= (TextView)findViewById(R.id.etComments);
        mEtComments.setText(localpro.getProComment());
    }
}
