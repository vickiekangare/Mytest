package com.example.dirgha03.customermanagment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CMListActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView mListItem;
    ArrayList<Details> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_listbase);
        list = new ArrayList<>();
        mListItem=(ListView)findViewById(R.id.listItem);
        CMMydbhandler dbhandler = new CMMydbhandler(this);
        list=dbhandler.databasep();
        mListItem.setOnItemClickListener(this);
        mListItem.setAdapter(new AAdapter(this,list));
    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        list.get(position).getIntrest();
        list.get(position).getId();
        Intent intent = new Intent(this, CMDisplayOrg.class);
        intent.putExtra("list", position);
        startActivity(intent);

    }


}
