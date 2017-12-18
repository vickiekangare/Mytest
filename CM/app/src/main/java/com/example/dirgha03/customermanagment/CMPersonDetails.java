package com.example.dirgha03.customermanagment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CMPersonDetails extends AppCompatActivity implements CMAppConstant{


    public String mStrName = "";
    public String mStrPhone = "";
    public String mStrAddress = "";
    public String mStrType = "";
    public String mStrNoemploye = "";
    public String mStrComment = "";
    public String mStrMedia = "";
    public String mStrUrl = "";
    public String mStrProInfo = "";

    String mStrEmail;
    String mStrMobile;
    String mStrRadio;

    EditText mEtName;
    EditText mEtDesignation;

    RadioGroup rgGender;

    RadioButton mRbMale;
    RadioButton mRbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmperson_details);
        getSupportActionBar().hide();

        mEtName = (EditText) findViewById(R.id.etName);
        mEtDesignation = (EditText) findViewById(R.id.etDesignation);

        rgGender = (RadioGroup) findViewById(R.id.Gender);
        mRbMale = (RadioButton) findViewById(R.id.rbMale);
        mRbFemale = (RadioButton) findViewById(R.id.rbFemale);

//        rgGender.addView(mRbMale);
        mRbMale.setChecked(true);

        Bundle Data = getIntent().getExtras();

        if (Data == null) {
            return;
        }

        mStrName = Data.getString(KEY_ORG_NAME);
        mStrPhone = Data.getString(KEY_PHONE);
        mStrAddress = Data.getString(KEY_ADDRESS);
        mStrType = Data.getString(KEY_ORAGNISATION_TYPE);
        mStrNoemploye = Data.getString(KEY_NO_OF_EMPLOYEE);
        mStrComment = Data.getString(KEY_COMMENT);
        mStrMedia = Data.getString(KEY_CHECKBOX);
        mStrUrl = Data.getString(KEY_URL);
        mStrProInfo = Data.getString(KEY_PRODUCT_INFO);



    }


    public boolean checkForEmail() {
        Context c;
        EditText mEtEmail = (EditText) findViewById(R.id.etEmail);
         mStrEmail = mEtEmail.getText().toString();
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(mStrEmail).matches()) {
            return true;
        }
        Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Email_is_not_valid),Toast.LENGTH_LONG).show();
        return false;
    }


    public boolean checkForMobile() {
        Context c;
        EditText mEtMobile = (EditText) findViewById(R.id.etMobile);
         mStrMobile = mEtMobile.getText().toString();
        if (android.util.Patterns.PHONE.matcher(mStrMobile).matches()) {
            return true;
        }
        Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Phone_No_is_not_valid), Toast.LENGTH_LONG).show();
        return false;
    }


    public void next(View view) {

        mStrRadio = ((RadioButton) this.findViewById(rgGender.getCheckedRadioButtonId())).getText().toString();

        boolean check = checkForEmail();
        boolean check1 = checkForMobile();
        if (check) {

            if (check1) {


                if (mStrProInfo.equals(KEY_YES)) {




                    if ((mEtName.getText().toString().equals(""))) {
                        Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Name_is_empty), Toast.LENGTH_SHORT).show();
                    } else if ((mEtDesignation.getText().toString().equals(""))) {
                        Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Designation_is_empty), Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(this, CMProductInfo.class);

                        String mStrPname = mEtName.getText().toString();
                        intent.putExtra(KEY_PNAME, mStrPname);

                        String mStrDesignation = mEtDesignation.getText().toString();
                        intent.putExtra(KEY_DESIGNATION, mStrDesignation);

//            String mStrMobile = mEtMobile.getText().toString();
                        intent.putExtra(KEY_MOBILE, mStrMobile);

                 //       checkForEmail();
//            String mStrEmail = mEtEmail.getText().toString();
                        intent.putExtra( KEY_EMAIL, mStrEmail);

                 //       checkForMobile();

                        intent.putExtra(KEY_GENDER, mStrRadio);

                        intent.putExtra(KEY_ORG_NAME, mStrName);
                        intent.putExtra(KEY_PHONE, mStrPhone);
                        intent.putExtra(KEY_ADDRESS, mStrAddress);
                        intent.putExtra(KEY_NO_OF_EMPLOYEE, mStrNoemploye);
                        intent.putExtra(KEY_COMMENT, mStrComment);
                        intent.putExtra(KEY_CHECKBOX, mStrMedia);
                        intent.putExtra(KEY_URL, mStrUrl);
                        intent.putExtra(KEY_ORAGNISATION_TYPE, mStrType);
                        intent.putExtra(KEY_PRODUCT_INFO, mStrProInfo);

                        startActivity(intent);
                    }

                } else {
                    Intent intent = new Intent(this, CMInterestInfo.class);

                    String mStrPname = mEtName.getText().toString();
                    intent.putExtra(KEY_PNAME, mStrPname);

                    String mStrDesignation = mEtDesignation.getText().toString();
                    intent.putExtra(KEY_DESIGNATION, mStrDesignation);

                    //            String mStrMobile = mEtMobile.getText().toString();
                    intent.putExtra(KEY_MOBILE, mStrMobile);

              //      checkForEmail();
                    //            String mStrEmail = mEtEmail.getText().toString();
                    intent.putExtra(KEY_EMAIL, mStrEmail);

                  //  checkForMobile();

                    intent.putExtra(KEY_GENDER, mStrRadio);
                    intent.putExtra(KEY_ORG_NAME, mStrName);
                    intent.putExtra(KEY_PHONE, mStrPhone);
                    intent.putExtra(KEY_ADDRESS, mStrAddress);
                    intent.putExtra(KEY_NO_OF_EMPLOYEE, mStrNoemploye);
                    intent.putExtra(KEY_COMMENT, mStrComment);
                    intent.putExtra(KEY_CHECKBOX, mStrMedia);
                    intent.putExtra(KEY_URL, mStrUrl);
                    intent.putExtra(KEY_ORAGNISATION_TYPE, mStrType);
                    intent.putExtra(KEY_PRODUCT_INFO, mStrProInfo);


                    startActivity(intent);
                }


            }
            else {
                Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Phone_No_is_not_valid), Toast.LENGTH_LONG).show();

            }

        }
        else {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Email_is_not_valid), Toast.LENGTH_LONG).show();

        }
    }
    public void Skip(View view) {
        if (mStrProInfo.equals(KEY_YES)) {
            Intent intent = new Intent(this, CMProductInfo.class);
            intent.putExtra(KEY_ORG_NAME, mStrName);
            intent.putExtra(KEY_PHONE, mStrPhone);
            intent.putExtra(KEY_ADDRESS, mStrAddress);
            intent.putExtra(KEY_NO_OF_EMPLOYEE, mStrNoemploye);
            intent.putExtra(KEY_COMMENT, mStrComment);
            intent.putExtra(KEY_CHECKBOX, mStrMedia);
            intent.putExtra(KEY_URL, mStrUrl);
            intent.putExtra(KEY_ORAGNISATION_TYPE, mStrType);
            intent.putExtra(KEY_PRODUCT_INFO, mStrProInfo);
            startActivity(intent);

        } else {
            Intent intent = new Intent(this, CMInterestInfo.class);

            intent.putExtra(KEY_ORG_NAME, mStrName);
            intent.putExtra(KEY_PHONE, mStrPhone);
            intent.putExtra(KEY_ADDRESS, mStrAddress);
            intent.putExtra(KEY_NO_OF_EMPLOYEE, mStrNoemploye);
            intent.putExtra(KEY_COMMENT, mStrComment);
            intent.putExtra(KEY_CHECKBOX, mStrMedia);
            intent.putExtra(KEY_URL, mStrUrl);
            intent.putExtra(KEY_ORAGNISATION_TYPE, mStrType);
            intent.putExtra(KEY_PRODUCT_INFO, mStrProInfo);
            startActivity(intent);
        }
    }


}