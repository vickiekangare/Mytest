package com.example.dirgha03.customermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class CMProductInfo extends AppCompatActivity implements CMAppConstant{

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


    Spinner dropdown;
    String select;
    String mStrRadio;

    RadioGroup rgInfo;
    RadioButton mRbYes1;
    RadioButton mRbNo1;


    // CMMydbhandler dbhandler;
    CMMydbhandler dbhandler = new CMMydbhandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmproduct_info);
        getSupportActionBar().hide();

        dropdown = (Spinner)findViewById(R.id.spinner1);

//        rgInfo = (RadioGroup)findViewById(R.id.info);
//        mRbYes1=(RadioButton)findViewById(R.id.rbYes);
//        mRbNo1=(RadioButton)findViewById(R.id.rbNo);

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
        mStrMedia1=Data.getString(KEY_CHECKBOX);
        mStrUrl1=Data.getString(KEY_URL);
        mStrProInfo=Data.getString(KEY_PRODUCT_INFO);

        mStrPname=Data.getString(KEY_PNAME);
        mStrDesignation=Data.getString(KEY_DESIGNATION);
        mStrMobile=Data.getString(KEY_MOBILE);
        mStrEmail=Data.getString(KEY_EMAIL);
        mStrGender=Data.getString(KEY_GENDER);

        String[] items = new String[]{"Monthly", "Yearly", "One time", "Installment"};



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);
        select=dropdown.getSelectedItem().toString();





//        mRbNo1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mRbNo1.isChecked()){
//                    Intent intent = new Intent(CMProductInfo.this,CMInterestInfo.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
//        rgInfo.addView(mRbYes1);
//        mRbYes1.setChecked(true);
//
//        mStrRadio=((RadioButton)this.findViewById(rgInfo.getCheckedRadioButtonId())).getText().toString();

    }


    public void sub(View view) {

        EditText mEtName = (EditText) findViewById(R.id.etName);
        EditText mEtSeller = (EditText) findViewById(R.id.etSeller);
        EditText mEtFeachers = (EditText) findViewById(R.id.etFeachers);
        EditText mEtRecurringexpanse = (EditText) findViewById(R.id.etRecurringexpanse);
        EditText mEtInstallmentcost = (EditText) findViewById(R.id.etInstallmentcost);
        EditText mEtImprovements = (EditText) findViewById(R.id.etImprovements);
        EditText mEtComments = (EditText) findViewById(R.id.etComments);



        if ((mEtName.getText().toString().equals("")))
        {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Name_is_empty), Toast.LENGTH_SHORT).show();
        }

        else if ((mEtSeller.getText().toString().equals("")))
        {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.seller_is_empty),Toast.LENGTH_SHORT).show();
        }


        else if ((mEtFeachers.getText().toString().equals("")))
        {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Feachers_is_empty),Toast.LENGTH_SHORT).show();
        }

        else if ((mEtRecurringexpanse.getText().toString().equals("")))
        {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Recurringexpanse_is_empty),Toast.LENGTH_SHORT).show();
        }

        else
        {
//            Intent intent = new Intent(this,CMInterestInfo.class); //
//
           String mStrProname = mEtName.getText().toString();
//            intent.putExtra("Product name",mStrProname);
//
            String mStrSeller =mEtSeller.getText().toString();
//            intent.putExtra("Seller",mStrSeller);
//
            String mStrRecurringexpanse = mEtRecurringexpanse.getText().toString();
//            intent.putExtra("Recurringexpanse",mStrRecurringexpanse);
//
            String mStrInstallmentcost = mEtInstallmentcost.getText().toString();
//            intent.putExtra("Installmentcost",mStrInstallmentcost);
//
            String mStrImprovements =  mEtImprovements.getText().toString();
//            intent.putExtra("Improvements",mStrImprovements);
//
            String mStrComments = mEtComments.getText().toString();
//            intent.putExtra("Comments",mStrComments);

       //     String mStrPaytype = dropdown.toString();


            String mStrFeachers = mEtFeachers.getText().toString();
//
////            intent.putExtra("Radio info",mStrRadio);
//
//            intent.putExtra("Oragnisation_name",mStrName1);
//            intent.putExtra("Phone", mStrPhone1);
//            intent.putExtra("Address",mStrAddress1);
//            intent.putExtra("No of employee",mStrNoemploye1);
//            intent.putExtra("Comment",mStrComment1);
//            intent.putExtra("checkbox", mStrMedia1);
//            intent.putExtra("Url",mStrUrl1);
//
//            intent.putExtra("Person name",mStrPname);
//            intent.putExtra("Designation",mStrDesignation);
//            intent.putExtra("Mobile", mStrMobile);
//            intent.putExtra("Email",mStrEmail);
//            intent.putExtra("Gender",mStrGender);


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

            a.setProName(mStrProname);
            a.setProSeller(mStrSeller);
            a.setProExpansetype(select);
            a.setProFeacher(mStrFeachers);
            a.setProReccuring(mStrRecurringexpanse);
            a.setProImprovement(mStrImprovements);
            a.setProInstallmentcost(mStrInstallmentcost);
            a.setProComment(mStrComments);

            dbhandler.addDetails(a);

            dbhandler.databasep();

            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Successfull), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
