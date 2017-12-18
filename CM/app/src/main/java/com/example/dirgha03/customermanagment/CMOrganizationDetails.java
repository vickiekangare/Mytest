package com.example.dirgha03.customermanagment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Toast;

public class CMOrganizationDetails extends AppCompatActivity implements CMAppConstant {

    public String mStrCheck="";
    public String mUrl="";

    String  mStrMobile;

    RadioGroup rgEmploye;
    RadioButton mRb1;

    RadioGroup rgProductinfo;

    RadioButton mRbyes;

    CheckBox mCbWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_organization_details);
        getSupportActionBar().hide();

        rgEmploye = (RadioGroup)findViewById(R.id.rg1);
        mRb1=(RadioButton)findViewById(R.id.rb1);
        mRb1.setChecked(true);

        rgProductinfo = (RadioGroup)findViewById(R.id.Info);
        mRbyes=(RadioButton)findViewById(R.id.rbYes);
        mRbyes.setChecked(true);

//code to show and hide url edittext
        mCbWebsite=(CheckBox)findViewById(R.id.cbWebsite);

        final EditText mEtUrl=(EditText)findViewById(R.id.etUrl);

        mCbWebsite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if( isChecked )
                {
                    mEtUrl.setVisibility(View.VISIBLE);

                }else {
                    mEtUrl.setVisibility(View.GONE);
                }
            }
        });


        if(mEtUrl.isShown())
        {
            mUrl = mEtUrl.getText().toString();
        }
        checkForMobile();

    }

    public boolean checkForMobile() {
        Context c;
        EditText mEtPhone=(EditText)findViewById(R.id.etPhone);
         mStrMobile = mEtPhone.getText().toString();
        if (android.util.Patterns.PHONE.matcher(mStrMobile).matches()) {
            return true;
        }
        else {

            return false;
        }
    }




public void next(final View view) {
    boolean check = checkForMobile();

    if (check) {

        EditText mEtName = (EditText) findViewById(R.id.etName);

        EditText mEtAddress = (EditText) findViewById(R.id.etAddress);
        EditText mEtOrganisationtype = (EditText) findViewById(R.id.etOrganisationtype);
        EditText mEtComment = (EditText) findViewById(R.id.etComment);


        RadioButton mRb2 = (RadioButton) findViewById(R.id.rb2);
        RadioButton mRb3 = (RadioButton) findViewById(R.id.rb3);
        RadioButton mRb4 = (RadioButton) findViewById(R.id.rb4);

        String mStrRadioEmploye = ((RadioButton) this.findViewById(rgEmploye.getCheckedRadioButtonId())).getText().toString();


        RadioButton mRbno = (RadioButton) findViewById(R.id.rbNo);

        String mStrRadioProduct = ((RadioButton) this.findViewById(rgProductinfo.getCheckedRadioButtonId())).getText().toString();

        CheckBox mCbFacebook = (CheckBox) findViewById(R.id.cbFacebook);
        CheckBox mCbJustdial = (CheckBox) findViewById(R.id.cbJustdial);


        mCbFacebook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mStrCheck ="facebook";

                }
            }
        });


        mCbJustdial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mStrCheck = "Justdial";

                }
            }
        });


        StringBuilder result = new StringBuilder();
        if (mCbWebsite.isChecked()) {
            result.append(KEY_WEBSITE);
        }

        if (mCbFacebook.isChecked()) {
            result.append(KEY_FACEBOOK);
        }

        if (mCbJustdial.isChecked()) {
            result.append(KEY_JUSTDIAL);
        }


        if ((mEtName.getText().toString().equals(""))) {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Name_is_empty), Toast.LENGTH_SHORT).show();


        } else if ((mEtAddress.getText().toString().equals(""))) {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Address_is_empty),Toast.LENGTH_SHORT).show();
        } else if ((mEtOrganisationtype.getText().toString().equals(""))) {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Type_is_empty), Toast.LENGTH_SHORT).show();
        } else if ((mEtComment.getText().toString().equals(""))) {
            Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Comment_is_empty),Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, CMPersonDetails.class);

            String mstrName = mEtName.getText().toString();
            intent.putExtra(KEY_ORG_NAME, mstrName);


            //   String mstrPhone=mEtPhone.getText().toString();
            intent.putExtra(KEY_PHONE, mStrMobile);

            String mstrAddress = mEtAddress.getText().toString();
            intent.putExtra(KEY_ADDRESS, mstrAddress);

            String mstrType = mEtOrganisationtype.getText().toString();
            intent.putExtra(KEY_ORAGNISATION_TYPE, mstrType);

            String mStrComment = mEtComment.getText().toString();
            intent.putExtra(KEY_COMMENT, mStrComment);

            intent.putExtra(KEY_NO_OF_EMPLOYEE, mStrRadioEmploye);

            intent.putExtra(KEY_CHECKBOX, result.toString());

            intent.putExtra(KEY_URL, mUrl);

            intent.putExtra(KEY_PRODUCT_INFO, mStrRadioProduct);

            startActivity(intent);
        }
   }
    else {
        Toast.makeText(getApplication(),getApplicationContext().getString(R.string.Phone_No_is_not_valid),Toast.LENGTH_LONG).show();

    }
}

}
