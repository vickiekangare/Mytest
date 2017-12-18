package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CMNotIntrested extends AppCompatActivity {

    public ArrayList<Details> proctsList;
  //  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmnot_intrested);
        getSupportActionBar().hide();
        Intent intent  = getIntent();
        int position=intent.getIntExtra("list", 0);

        ArrayList<Details> list = new ArrayList<>();
        CMMydbhandler dbhandler=new CMMydbhandler(this);
        list=dbhandler.databasep();
        this.proctsList=list;
        proctsList.get(position).getId();
        Details localpro=proctsList.get(position);

        TextView mEtComments= (TextView)findViewById(R.id.etComments2);
        mEtComments.setText(localpro.getIntComment());
    }
}
