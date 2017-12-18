package com.example.dirgha03.customermanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CMMydbhandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "details.db";
    public static final String TABLE_DETAILS = "Details";
    public static final String COLUMN_ID = "id";

    public static final String Oname = "Orag_name";
    public static final String Oaddress = "Orag_address";
    public static final String Ophone = "Orag_phone";
    public static final String Otype = "Orag_type";
    public static final String OnoOFemploye = "Orag_employe";
    public static final String Ocomment = "Orag_comment";
    public static final String Omedia = "Orag_media";
    public static final String Ourl = "Orag_url";
    public static final String ProInfo = "Pro_info";

    public static final String Pname = "Per_name";
    public static final String Designation = "Designation";
    public static final String Mob = "Mobile";
    public static final String email = "Email";
    public static final String gendar = "gender";

    public static final String Intrest = "Intrest_radio";
    public static final String Intcomment = "Int_comment";
    public static final String Cost = "Int_Cost";
    public static final String Expanses = "Int_Expanse";
    public static final String Paytype = "Int_Paytype";

    public static final String Proname = "Pro_name";
    public static final String Seller = "Pro_seller";
    public static final String ProPaytype = "Pro_type";
    public static final String Feachers = "Pro_feachers";
    public static final String Improvements = "Pro_improvment";
    public static final String Installmentcost = "Pro_installment";
    public static final String Recurringexpanse = "Pro_reccuring";
    public static final String Comments = "Pro_comment";


    public CMMydbhandler(Context context) {
        super(context, "details.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Details (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Oname + " text, "
                        + Oaddress +" text, "
                        + Ophone + " text,"
                        + Otype + " text, "
                        + OnoOFemploye +" text, "
                        + Ocomment+" text, "
                        +Omedia +" text,"
                        +Ourl+" text,"
                        +ProInfo+" text,"

                        +Pname+" text, "
                        +Designation+" text, "
                        +Mob+" text, "
                        +email+" text, "
                        +gendar+" text, "

                        +Intrest+" text, "
                        +Intcomment+" text, "
                        +Cost+" text, "
                        +Expanses+" text, "
                        +Paytype+" text, "

                        +Proname+" text, "
                        +Seller+" text, "
                        +ProPaytype+" text, "
                        +Improvements+" text, "
                        +Feachers+" text, "
                        +Installmentcost+" text, "
                        +Recurringexpanse+" text, "
                        +Comments+" text)");



//                Orag_comment text, Orag_media text, Orag_url text, Per_name text," +
//                "Designation text, Mobile text, Email text, gender text, Int_comment text, Int_Cost text, Int_Expanse text," +
//                "Int_Paytype text, Pro_name text, Pro_seller text, Pro_type text, Pro_improvment text, Pro_installment text," +
//                "Pro_reccuring text, Pro_comment text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Details");
        onCreate(db);

    }


    public void addDetails(Details detail) {
        ContentValues values = new ContentValues();
        values.put(Oname, detail.getoName());
        values.put(Ophone, detail.getoPhone());
        values.put(Oaddress, detail.getoAddress());
        values.put(Otype, detail.getoTpe());
        values.put(Ocomment, detail.getoComment());
        values.put(OnoOFemploye, detail.getoNoemployee());
        values.put(Omedia,detail.getoMedia());
        values.put(Ourl,detail.getoUrl());
        values.put(ProInfo,detail.getProInfo());

        values.put(Pname,detail.getpName());
        values.put(Designation,detail.getoDesignation());
        values.put(Mob,detail.getpMob());
        values.put(email,detail.getpEmail());
        values.put(gendar,detail.getpGender());

        values.put(Intrest,detail.getIntrest());
        values.put(Paytype,detail.getIntpaytype());
        values.put(Intcomment,detail.getIntComment());
        values.put(Cost,detail.getIntCost());
        values.put(Expanses,detail.getIntExpenses());
        values.put(Intcomment,detail.getIntComment());

        values.put(Proname,detail.getProName());
        values.put(Seller,detail.getProSeller());
        values.put(ProPaytype,detail.getProExpansetype());
        values.put(Recurringexpanse,detail.getProReccuring());
        values.put(Comments,detail.getProComment());
        values.put(Improvements,detail.getProImprovement());
        values.put(Feachers,detail.getProFeacher());
        values.put(Installmentcost,detail.getProInstallmentcost());




        SQLiteDatabase db = getWritableDatabase();

        db.insert("Details", null, values);
        db.close();
    }

    public ArrayList<Details> databasep() {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[] = {COLUMN_ID, Oname, Oaddress, Ophone, Otype, OnoOFemploye, Ocomment, Omedia, Ourl, ProInfo, Intrest,Pname, Designation,
                Mob, email, gendar, Intcomment, Cost, Expanses, Paytype, Proname, Seller, ProPaytype, Improvements, Installmentcost, Recurringexpanse, Feachers, Comments};

        Cursor c = db.query("Details", projection, null, null, null, null, null);

        ArrayList<Details> list = new ArrayList<>();

        if (c != null && c.moveToFirst())

            do {

               /* String s = "id" + c.getString(c.getColumnIndex(COLUMN_ID)) +
                                "Org name"+c.getString(c.getColumnIndex(Oname)) +
                        "o add"+c.getString(c.getColumnIndex(Oaddress)) +
                        "o pho"+c.getString(c.getColumnIndex(Ophone)) +
                        "o type"+c.getString(c.getColumnIndex(Otype)) +
                        "o comment"+c.getString(c.getColumnIndex(Ocomment)) +
                        "no of emp"+c.getString(c.getColumnIndex(OnoOFemploye)) +
                        "media"+c.getString(c.getColumnIndex(Omedia)) +
                        "url"+c.getString(c.getColumnIndex(Ourl)) +

                        "p nam"+c.getString(c.getColumnIndex(Pname)) +
                        "des"+c.getString(c.getColumnIndex(Designation)) +
                        "mob"+c.getString(c.getColumnIndex(Mob)) +
                        "email"+c.getString(c.getColumnIndex(email)) +
                        "gender"+c.getString(c.getColumnIndex(gendar)) +

                        "pro nam"+c.getString(c.getColumnIndex(Proname)) +
                        "seller"+c.getString(c.getColumnIndex(Seller)) +
                        "ptyp"+c.getString(c.getColumnIndex(ProPaytype)) +
                        "improv"+c.getString(c.getColumnIndex(Improvements)) +
                        "com"+c.getString(c.getColumnIndex(Comments)) +
                        "imp"+c.getString(c.getColumnIndex(Improvements))+
                        "install"+c.getString(c.getColumnIndex(Installmentcost));

                System.out.println(s);
*/

                Details deInfo = new Details();
                deInfo.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
                deInfo.setoName(c.getString(c.getColumnIndex(Oname)));
                deInfo.setoPhone(c.getString(c.getColumnIndex(Ophone)));
                deInfo.setoTpe(c.getString(c.getColumnIndex(Otype)));
                deInfo.setoAddress(c.getString(c.getColumnIndex(Oaddress)));

                deInfo.setpName(c.getString(c.getColumnIndex(Pname)));
                deInfo.setoDesignation(c.getString(c.getColumnIndex(Designation)));
                deInfo.setpMob(c.getString(c.getColumnIndex(Mob)));
                deInfo.setpEmail(c.getString(c.getColumnIndex(email)));
                deInfo.setpGender(c.getString(c.getColumnIndex(gendar)));

                deInfo.setProName(c.getString(c.getColumnIndex(Proname)));
                deInfo.setProSeller(c.getString(c.getColumnIndex(Seller)));
                deInfo.setProExpansetype(c.getString(c.getColumnIndex(ProPaytype)));
                deInfo.setProReccuring(c.getString(c.getColumnIndex(Recurringexpanse)));
                deInfo.setProFeacher(c.getString(c.getColumnIndex(Feachers)));
                deInfo.setProComment(c.getString(c.getColumnIndex(Comments)));
                deInfo.setProInstallmentcost(c.getString(c.getColumnIndex(Installmentcost)));
                deInfo.setProImprovement(c.getString(c.getColumnIndex(Improvements)));
                deInfo.setIntComment(c.getString(c.getColumnIndex(Intcomment)));


                deInfo.setoComment(c.getString(c.getColumnIndex(Ocomment)));
                deInfo.setoNoemployee(c.getString(c.getColumnIndex(OnoOFemploye)));
                deInfo.setoMedia(c.getString(c.getColumnIndex(Omedia)));
                deInfo.setoUrl(c.getString(c.getColumnIndex(Ourl)));
                deInfo.setProInfo(c.getString(c.getColumnIndex(ProInfo)));
                deInfo.setIntrest(c.getString(c.getColumnIndex(Intrest)));
                list.add(deInfo);



            } while (c.moveToNext());
         return list;
    }

}
