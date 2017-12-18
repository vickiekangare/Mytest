package com.example.dirgha03.customermanagment;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
public class AAdapter extends ArrayAdapter<Details> {

    Context context;
    public ArrayList<Details> proctsList;

    public AAdapter(Context context, ArrayList<Details> list)
    {super(context, R.layout.activity_cmlist,list);
        this.context=context;
        this.proctsList=list;
    }



    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_cmlist,parent,false);

        TextView tvOrgname = (TextView) rowView.findViewById(R.id.tvName);
        TextView tvOrgType=  (TextView) rowView.findViewById(R.id.tvOrgType);
        TextView tvProInfo=  (TextView) rowView.findViewById(R.id.tvProInfo);
        TextView tvInt=  (TextView) rowView.findViewById(R.id.tvInt);

        Details localpro = proctsList.get(position);
        tvOrgname.setText(localpro.getoName());
        tvOrgType.setText(localpro.getoTpe());
        tvProInfo.setText(localpro.getProInfo());
        tvInt.setText(localpro.getIntrest());
        return rowView;
    }
}
