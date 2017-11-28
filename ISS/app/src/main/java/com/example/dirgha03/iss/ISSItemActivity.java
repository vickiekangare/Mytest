package com.example.dirgha03.iss;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


@SuppressWarnings("ALL")
public class ISSItemActivity extends AppCompatActivity implements IssAppConstants {

    private EditText mEtName;
    private EditText mEtdescription;
    private EditText mEtbill;
    private EditText mEtQuntity;
    private EditText mEtColor;
    private EditText etPdate;
    private AppCompatImageView imageView3;
    private int value1=1;
    private String value;
    StringBuilder date =new StringBuilder();

    AppCompatImageView iV_plus;
    AppCompatImageView iV_minus;

    private Context mContext=ISSItemActivity.this;

    Button date_button;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        getSupportActionBar().hide();
        final Calendar cal = Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        month_x=cal.get(Calendar.MONTH);
        day_x=cal.get(Calendar.DAY_OF_MONTH);

        //this part is for the quntity field.

        mEtQuntity = (EditText)findViewById(R.id.etQuntity);
        AppCompatImageView iV_plus =(AppCompatImageView)findViewById(R.id.ivPlus);
        AppCompatImageView iV_minus=(AppCompatImageView)findViewById(R.id.ivMinus);

        iV_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 + 1;
                mEtQuntity.setText(Integer.toString(value1));
            }
        });

        mEtQuntity.setText(Integer.toString(value1));

        iV_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value1>1)
                {
                    value1 = value1 - 1;
                    mEtQuntity.setText(Integer.toString(value1));
                }
                else {
                    Toast.makeText(mContext,mContext.getString(R.string.correct_quntity), Toast.LENGTH_SHORT).show();
                }
            }
        });

        mEtQuntity.setText(Integer.toString(value1));


        showDialogOnButtonClick();

    }



    public void showDialogOnButtonClick() {



        AppCompatImageView imageView3=(AppCompatImageView)findViewById(R.id.ivCalender);


        imageView3.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showDialog(DIALOG_ID);
                    }
                }
        );


    }



        @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id==DIALOG_ID)


            return new DatePickerDialog(this,dpickerListner,year_x,month_x,day_x);
            return null;

    }
    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth)
        {
            year_x = year;
            month_x=monthOfYear;
            day_x=dayOfMonth;

            sDate();
        }



    };



    public void sDate()
    {
        TextView etPdate=(TextView)findViewById(R.id.tvPdate1);
        date.append(year_x);
        date.append("/");
        date.append(month_x);
        date.append("/");
        date.append(day_x);
        etPdate.setText(date.toString());
    }



    public void  click(View view)
    {
        EditText mEtName=(EditText)findViewById(R.id.etName);
        EditText mEtColor=(EditText)findViewById(R.id.etColor);
        EditText mEtQuntity=(EditText)findViewById(R.id.etQuntity);
        EditText mEtDescription=(EditText)findViewById(R.id.etDescription);
        EditText mEtBill=(EditText)findViewById(R.id.etBill);



        if ((mEtName.getText().toString().equals("")))
        {
            Toast.makeText(mContext,mContext.getString(R.string.name_empty), Toast.LENGTH_SHORT).show();
        }
        else if((mEtColor.getText().toString().equals("")))
        {
            Toast.makeText(mContext,mContext.getString(R.string.color_empty), Toast.LENGTH_SHORT).show();
        }

        else if((mEtQuntity.getText().toString().equals(0)))
        {
            Toast.makeText(mContext,mContext.getString(R.string.correct_quntity), Toast.LENGTH_SHORT).show();
        }




        else
        {
            Intent intent = new Intent(mContext,ISSManufacActivity.class);


            String mStrBill=mEtBill.getText().toString();
            intent.putExtra(KEY_BILL, mStrBill);

            String mStrName=mEtName.getText().toString();
            intent.putExtra(KEY_NAME,mStrName);


            String mStrDescription=mEtDescription.getText().toString();
            intent.putExtra(KEY_DESCRIPTION,mStrDescription);


            String mStrColor=mEtColor.getText().toString();
            intent.putExtra(KEY_COLOR,mStrColor);


            String mStrQuantity=mEtQuntity.getText().toString();
            intent.putExtra(KEY_QUNTITY,mStrQuantity);

            intent.putExtra(DATE,date.toString());

            Toast.makeText(mContext, mStrName  +"\n"+ mStrDescription +"\n"+ mStrBill +"\n"+ mStrColor +"\n"+ mStrQuantity +"\n"+date.toString(),Toast.LENGTH_LONG).show();

            startActivity(intent);
        }
    }

}
