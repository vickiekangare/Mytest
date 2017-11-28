package com.example.dirgha03.iss;


public class products
{
    private int id;
    private String Item_name,Color_name,quntity,bill_name,Description,mName,mOf,mCost,check1,date,mDate,warrenty,photo;


    public products()
    {
        this.Item_name = Item_name;
        this.Color_name=Color_name;


    }

    public String getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.warrenty = warrenty;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getCheck1() {
        return check1;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmOf(String mOf) {
        this.mOf = mOf;
    }

    public void setmCost(String mCost) {
        this.mCost = mCost;
    }

    public String getBill_name() {
        return bill_name;
    }

    public String getDescription() {
        return Description;
    }

    public String getmName() {
        return mName;
    }

    public String getmOf() {
        return mOf;
    }

    public String getmCost() {
        return mCost;
    }

    public int getId()
    {
        return id;
    }

    public String getItem_name()
    {
        return Item_name;
    }

    public String getColor_name()
    {
        return Color_name;
    }

    public String getQuntity()
    {
        return quntity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem_name(String item_name)
    {
        Item_name = item_name;
    }

    public void setPhoto(String photo1) {
        this.photo = photo1;
    }

    public String getPhoto() {
        return photo;

    }

    public void setColor_name(String color_name)
    {
        Color_name = color_name;

    }

    public void setQuntity(String quntity)
    {
        this.quntity = quntity;
    }
}
