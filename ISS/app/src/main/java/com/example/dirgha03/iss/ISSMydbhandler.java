package com.example.dirgha03.iss;


import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class ISSMydbhandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_PRODUCTS = "Products";
    public static final String COLUMN_ID = "id";
    public static final String Item_name = "product_name";
    public static final String Color_name = "product_color";
    public static final String date = "product_date";

    public static final String quntity = "product_quntity";
    public static final String bill_name = "product_bName";
    public static final String Description = "product_description";
    public static final String mName = "product_mName";
    public static final String mOf = "product_mOf";
    public static final String mCost = "product_mCost";
    public static final String mWarrenty = "product_mWarrenty";
    public static final String check = "product_delicate";
    public static final String mDate = "product_mDate";

    public static final String image = "product_image";

    public static String s;


    public Cursor c;

    public ISSMydbhandler(Context context) {
        super(context, "products.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Products (id INTEGER PRIMARY KEY AUTOINCREMENT, product_name text, product_color text, product_quntity text," +
                "product_bName text, product_description text, product_mName text, product_mOf text, product_mCost text," +
                "product_delicate text, product_mWarrenty text, product_image text, product_date text, product_mDate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Products");
        onCreate(db);
    }

    public void addproduct(products product) {

        ContentValues values = new ContentValues();


        values.put(Item_name, product.getItem_name());
        values.put(Color_name, product.getColor_name());
        values.put(quntity, product.getQuntity());
        values.put(bill_name, product.getBill_name());
        values.put(Description, product.getDescription());
        values.put(mName, product.getmName());
        values.put(mOf, product.getmOf());
        values.put(mCost, product.getmCost());
        values.put(mWarrenty, product.getWarrenty());
        values.put(check, product.getCheck1());
        values.put(date, product.getDate());
        values.put(mDate, product.getmDate());
        values.put(image, product.getPhoto());

        SQLiteDatabase db = getWritableDatabase();

        db.insert("Products", null, values);
        db.close();

    }


    public ArrayList<products> databasep() {

        SQLiteDatabase db = this.getReadableDatabase();
        String projection[] = {COLUMN_ID, Item_name, Color_name, bill_name, quntity, Description, mName, mOf, mCost, mWarrenty, check, date, image, mDate};
        Cursor c = db.query("Products", projection, null, null, null, null, null);


        ArrayList<products> list = new ArrayList<>();
        if (c != null && c.moveToFirst())

            // c.moveToFirst();
            do {

           /* String s="id" + c.getString(c.getColumnIndex("id")) +
                     c.getString(c.getColumnIndex("product_name")); */


                products proItem = new products();
                proItem.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
                proItem.setItem_name(c.getString(c.getColumnIndex(Item_name)));
                proItem.setColor_name(c.getString(c.getColumnIndex(Color_name)));
                proItem.setQuntity(c.getString(c.getColumnIndex(quntity)));
                proItem.setDate(c.getString(c.getColumnIndex(date)));
                proItem.setBill_name(c.getString(c.getColumnIndex(bill_name)));
                proItem.setDescription(c.getString(c.getColumnIndex(Description)));
                proItem.setmName(c.getString(c.getColumnIndex(mName)));
                proItem.setmOf(c.getString(c.getColumnIndex(mOf)));
                proItem.setmDate(c.getString(c.getColumnIndex(mDate)));
                proItem.setmCost(c.getString(c.getColumnIndex(mCost)));
                proItem.setWarrenty(c.getString(c.getColumnIndex(mWarrenty)));
                proItem.setCheck1(c.getString(c.getColumnIndex(check)));
                proItem.setPhoto(c.getString(c.getColumnIndex(image)));
                list.add(proItem);

                // System.out.println(s);

            } while (c.moveToNext());
        return list;

    }

    public void getId()

    {
        int Id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[] = {COLUMN_ID, Item_name, Color_name, bill_name, quntity, Description, mName, mOf, mCost, check, date, image, mDate};

        Cursor c = db.query("Products", projection, null, null, null, null, null);

        String query = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE "
                + COLUMN_ID + " = " + Id;

        ArrayList<products> list = new ArrayList<>();


        c.moveToFirst();
        do {
            products proItem = new products();
            proItem.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
            proItem.setItem_name(c.getString(c.getColumnIndex(Item_name)));
            proItem.setColor_name(c.getString(c.getColumnIndex(Color_name)));
            proItem.setQuntity(c.getString(c.getColumnIndex(quntity)));
            proItem.setDate(c.getString(c.getColumnIndex(date)));
            proItem.setBill_name(c.getString(c.getColumnIndex(bill_name)));
            proItem.setDescription(c.getString(c.getColumnIndex(Description)));
            proItem.setmName(c.getString(c.getColumnIndex(mName)));
            proItem.setmName(c.getString(c.getColumnIndex(mOf)));
            proItem.setmName(c.getString(c.getColumnIndex(mDate)));
            proItem.setmCost(c.getString(c.getColumnIndex(mCost)));
            proItem.setWarrenty(c.getString(c.getColumnIndex(mWarrenty)));
            proItem.setCheck1(c.getString(c.getColumnIndex(check)));
            proItem.setPhoto(c.getString(c.getColumnIndex(image)));
            list.add(proItem);


        } while (c.moveToNext());


    }

}









