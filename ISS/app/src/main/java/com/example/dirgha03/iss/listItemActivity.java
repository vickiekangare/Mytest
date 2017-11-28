package com.example.dirgha03.iss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class listItemActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView mListItem;
    ArrayList<products> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        list = new ArrayList<>();
        mListItem = (ListView) findViewById(R.id.listItem);
        ISSMydbhandler dbhandler = new ISSMydbhandler(this);
        list = dbhandler.databasep();
        mListItem.setOnItemClickListener(this);
        mListItem.setAdapter(new ISSArrayAdapt(this, list));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        list.get(position).getId();
        Intent intent = new Intent(this, ISSDisplayActivity.class);
        intent.putExtra("list", position);
        startActivity(intent);
    }
}
