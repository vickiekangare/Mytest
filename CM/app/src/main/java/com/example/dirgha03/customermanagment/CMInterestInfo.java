package com.example.dirgha03.customermanagment;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

public class CMInterestInfo extends AppCompatActivity implements CMAppConstant{


    public String mStrName1 ="";
    public String mStrPhone1 ="";
    public String mStrAddress1 ="";
    public String mStrType1="";
    public String mStrNoemploye1="";
    public String mStrComment1="";
    public String mStrMedia1="";
    public String mStrUrl1="";
    public String mStrProInfo="";

    public String mStrPname ="";
    public String mStrDesignation ="";
    public String mStrMobile ="";
    public String mStrEmail="";
    public String mStrGender="";

    String mStrExpanses;
    String mStrCost;
    String mStrPaytype;

    CMMydbhandler dbhandler;

    RadioGroup rgInfo;
    String mStrIntrest;



//     EditText mEtExpense;
//     EditText mEtCost;
//     Spinner spinner1;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cminterest_info);
        getSupportActionBar().hide();

        dbhandler = new CMMydbhandler(this);


        rgInfo = (RadioGroup)findViewById(R.id.Info1);

        RadioButton mRbYes=(RadioButton)findViewById(R.id.rbYes1);
        RadioButton mRbNo=(RadioButton)findViewById(R.id.rbNo1);
//
//       rgInfo.addView(mRbYes);
        mRbYes.setChecked(true);
        mStrIntrest="Yes";

        final EditText mEtExpense=(EditText)findViewById(R.id.etExpense);;
        final EditText mEtCost=(EditText)findViewById(R.id.etCost);
        final Spinner dropdown =(Spinner)findViewById(R.id.spinner2);
        final TextView mTvPaytype = (TextView)findViewById(R.id.tvPaytype);


        String[] items = new String[]{"Monthly", "Yearly", "One time", "Installment"};
        // Spinner dropdown = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        mRbNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked )
                {
                    mEtExpense.setVisibility(View.GONE);
                    mEtCost.setVisibility(View.GONE);
                    mTvPaytype.setVisibility(View.GONE);
                    dropdown .setVisibility(View.GONE);
                }
                else
                {
                    mEtExpense.setVisibility(View.VISIBLE);
                    mEtCost.setVisibility(View.VISIBLE);
                    mTvPaytype.setVisibility(View.VISIBLE);
                    dropdown.setVisibility(View.VISIBLE);
                }


            }
        });


        if(mEtExpense.isShown())
        {
            mStrExpanses = mEtExpense.getText().toString();
        }

        if(mEtCost.isShown())
        {
            mStrCost = mEtCost.getText().toString();
        }


        if(dropdown .isShown())
        {
            mStrPaytype = dropdown .toString();
        }


        Bundle Data = getIntent().getExtras();

        if (Data==null)
        {
            return;
        }

        mStrName1=Data.getString(KEY_ORG_NAME);
        mStrPhone1=Data.getString(KEY_PHONE);
        mStrAddress1=Data.getString(KEY_ADDRESS);
        mStrType1=Data.getString(KEY_ORAGNISATION_TYPE);
        mStrNoemploye1=Data.getString(KEY_NO_OF_EMPLOYEE);
        mStrComment1=Data.getString(KEY_COMMENT);
        mStrMedia1=Data.getString( KEY_CHECKBOX);
        mStrUrl1=Data.getString(KEY_URL);
        mStrProInfo=Data.getString(KEY_PRODUCT_INFO);

        mStrPname=Data.getString(KEY_PNAME);
        mStrDesignation=Data.getString(KEY_DESIGNATION);
        mStrMobile=Data.getString(KEY_MOBILE);
        mStrEmail=Data.getString(KEY_EMAIL);
        mStrGender=Data.getString(KEY_GENDER);


    }




    public void sub(View view)
    {
        EditText mEtComment = (EditText) findViewById(R.id.etComment);

        mStrIntrest=((RadioButton)this.findViewById(rgInfo.getCheckedRadioButtonId())).getText().toString();

        if (mEtComment.getText().toString().equals(""))
        {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Comment_is_empty), Toast.LENGTH_SHORT).show();
        }

        else
        {
            String mStrIntComment=mEtComment.getText().toString();
            Details a = new Details();
            a.setoName(mStrName1);
            a.setoPhone(mStrPhone1);
            a.setoAddress(mStrAddress1);
            a.setoNoemployee(mStrNoemploye1);
            a.setoTpe(mStrType1);
            a.setoComment(mStrComment1);
            a.setoMedia(mStrMedia1);
            a.setoUrl(mStrUrl1);
            a.setProInfo(mStrProInfo);

            a.setpName(mStrPname);
            a.setoDesignation(mStrDesignation);
            a.setpMob(mStrMobile);
            a.setpGender(mStrGender);
            a.setpEmail(mStrEmail);

            a.setIntComment(mStrIntComment);
            a.setIntCost(mStrCost);
            a.setIntExpenses(mStrExpanses);
            a.setIntpaytype(mStrPaytype);
            a.setIntrest(mStrIntrest);

            dbhandler.addDetails(a);

            dbhandler.databasep();

            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Successfull), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

}
