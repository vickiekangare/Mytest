package com.example.dirgha03.iss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class ISSAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().hide();

    }

    public void onclick(View view)
    {
        Intent intent = new Intent(this,ISSItemActivity.class);
        startActivity(intent);
    }

    public void onClick(View view)
    {
        Intent intent =new Intent(this,listItemActivity.class);
        startActivity(intent);
    }





}



