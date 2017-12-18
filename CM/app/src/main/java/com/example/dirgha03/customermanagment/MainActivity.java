package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void add(View view)
    {
        Intent intent = new Intent(this,CMOrganizationDetails.class);
        startActivity(intent);
    }


    public void view(View view)
    {
        Intent intent = new Intent(this,CMListActivity.class);
        startActivity(intent);
    }

}
