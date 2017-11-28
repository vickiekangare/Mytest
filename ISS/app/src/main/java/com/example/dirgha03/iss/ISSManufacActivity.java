package com.example.dirgha03.iss;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


@SuppressWarnings("ALL")
public class ISSManufacActivity extends AppCompatActivity implements IssAppConstants{

    public String mStrName1 ="";
    public String mStrBill1 ="";
    public String mStrDescription1 ="";
    public String mStrQuantity1="";
    public String mStrColor1="";
    public String mStrCheck1="";
    public String mStrDate1="";
    EditText etWarrenty;

    StringBuilder date =new StringBuilder();

    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacturer);
        getSupportActionBar().hide();

        final Calendar cal = Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        month_x=cal.get(Calendar.MONTH);
        day_x=cal.get(Calendar.DAY_OF_MONTH);




        Bundle Data = getIntent().getExtras();
        if (Data==null)
        {
            return;
        }

        mStrName1 =  Data.getString(KEY_NAME);
        mStrBill1 = Data.getString(KEY_BILL);
        mStrDescription1= Data.getString(KEY_DESCRIPTION);
        mStrQuantity1= Data.getString(KEY_QUNTITY);
        mStrColor1= Data.getString(KEY_COLOR);
        mStrDate1=Data.getString(DATE);



        showDialogOnButtonClick();

    }


    public void showDialogOnButtonClick() {



        AppCompatImageView imageView2=(AppCompatImageView)findViewById(R.id.ivCalendar);


        imageView2.setOnClickListener(
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
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            year_x = year;
            month_x=monthOfYear;
            day_x=dayOfMonth;

            sDate();
        }
    };




    public void sDate()
    {
        TextView tvMdate=(TextView)findViewById(R.id.tvMdate);

        date.append(year_x);
        date.append("/");
        date.append(month_x);
        date.append("/");
        date.append(day_x);
        tvMdate.setText(date.toString());

    }





    public void onClick(View view)
    {
        EditText mEtMname = (EditText) findViewById(R.id.etMname);
        EditText mEtMadeof = (EditText) findViewById(R.id.etMadeof);
        EditText mEtCost=(EditText)findViewById(R.id.etCost);
        EditText mEtWarrenty= (EditText)findViewById(R.id.etWarrenty);




        CheckBox cB_delicate=(CheckBox)findViewById(R.id.cbDelicate);
        cB_delicate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mStrCheck1 = "delicate";

                }
            }
        });
        CheckBox cB_fragile=(CheckBox)findViewById(R.id.cbFragile);
        cB_fragile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mStrCheck1 = "fragile";

                }
            }
        });
        CheckBox cB_hard=(CheckBox)findViewById(R.id.cbHard);
        cB_hard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mStrCheck1 = "hard";

                }
            }
        });
        CheckBox cB_strong=(CheckBox)findViewById(R.id.cbStrong);
        cB_strong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mStrCheck1 = "strong";

                }
            }
        });

        StringBuilder result=new StringBuilder();





        if (( mEtMname.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.Manufacturers_name_is_empty), Toast.LENGTH_SHORT).show();
        }

        else if ((mEtMadeof.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.made_of_is_empty), Toast.LENGTH_SHORT).show();
        }

        else if ((mEtCost.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.cost_is_empty), Toast.LENGTH_SHORT).show();
        }

        else
            {
                Intent intent = new Intent(this, ISSImageActivity.class);

                String mStrMname =mEtMname.getText().toString();
                intent.putExtra(KEY_MNUFACTURER_NAME,mStrMname);

                String mStrMof=mEtMadeof.getText().toString();
                intent.putExtra(KEY_MADE_OF,mStrMof);

                String mStrCost=mEtCost.getText().toString();
                intent.putExtra(KEY_COST,mStrCost);

                String mStrWarrenty=mEtWarrenty.getText().toString();
                intent.putExtra(KEY_WARRENTY,mStrWarrenty);

                intent.putExtra(KEY_NEW_NAME,mStrName1);
                intent.putExtra(KEY_NEW_BILL,mStrBill1);
                intent.putExtra(KEY_NEW_DESCRIPTION,mStrDescription1);
                intent.putExtra(KEY_NEW_QUNTITY,mStrQuantity1);
                intent.putExtra(KEY_NEW_COLOR,mStrColor1);
                intent.putExtra(DATE,mStrDate1);

                if(cB_delicate.isChecked())
                {
                   result.append(KEY_DELICATE);
                }

                if(cB_fragile.isChecked())
                {
                    result.append(KEY_FRAGILE);
                }

                if(cB_hard.isChecked())
                {
                    result.append(KEY_HARD);
                }

                if(cB_strong.isChecked())
                {
                    result.append(KEY_STRONG);
                }


                intent.putExtra(KEY_NEW_DATE,date.toString());

                intent.putExtra(KEY_MATERIAL,result.toString());


                Toast.makeText(this,mStrMname +"\n"+ mStrMof + mStrCost +"\n"+ mStrWarrenty +"\n"+ result.toString() ,Toast.LENGTH_LONG).show();

                startActivity(intent);
        }


    }

}











