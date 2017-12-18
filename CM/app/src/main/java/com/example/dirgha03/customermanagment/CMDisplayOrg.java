package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CMDisplayOrg extends AppCompatActivity implements CMAppConstant{

    public ArrayList<Details> proctsList;
    ArrayList<Details> list;
    int position;
    ArrayList<Details> var;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_display_org);
        getSupportActionBar().hide();
        Intent intent = getIntent();
         position = intent.getIntExtra(KEY_List, 0);
        ArrayList<Details> list = new ArrayList<>();

        CMMydbhandler dbhandler = new CMMydbhandler(this);
        list = dbhandler.databasep();
        this.proctsList = list;
        Details localpro = proctsList.get(position);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(localpro.getoName());

        TextView tvMobile = (TextView) findViewById(R.id.tvMobile);
        tvMobile.setText(localpro.getoPhone());

        TextView tvAddress = (TextView) findViewById(R.id.tvAddrees);
        tvAddress.setText(localpro.getoAddress());

        TextView tvType = (TextView) findViewById(R.id.tvType);
        tvType.setText(localpro.getoTpe());

        TextView tvEmploye = (TextView) findViewById(R.id.tvEmployee);
        tvEmploye.setText(localpro.getoNoemployee());

        TextView tvComment = (TextView) findViewById(R.id.tvComment);
        tvComment.setText(localpro.getoComment());

        TextView tvMedia = (TextView) findViewById(R.id.tvMedia);
        tvMedia.setText(localpro.getoMedia());

         s = list.get(position).getIntrest();

//        (localpro.getpName().equals("")

    /*  if (intrest.mStrIntrest.equals("Yes"))
        {
            num = 1;
        }

        else
        {
            num = 2;
        }*/



    }

    public void cperson(View view) {
        Intent intent = new Intent(this, CMContactPersonActivity.class);
        intent.putExtra(KEY_List, position);
        startActivity(intent);

    }

    public void product(View view) {

//        CMMydbhandler dbhandler = new CMMydbhandler(this);
//        var = new ArrayList<>();
//       var=dbhandler.databasep();
//        var.get(position).getIntrest();



        if(s == null)
        {

            Intent intent = new Intent(this,CMProductActivity.class);
            intent.putExtra(KEY_List, position);
            startActivity(intent);
        }

        else  if (s.equals(KEY_YES))
        {

            Intent intent = new Intent(this,CMInstrestedActivity.class);
            intent.putExtra(KEY_List, position);
            startActivity(intent);

        }
        else if (s.equals(KEY_NO))
        {

            Intent intent = new Intent(this,CMNotIntrested.class);
            intent.putExtra(KEY_List, position);
            startActivity(intent);

        }

    }
}