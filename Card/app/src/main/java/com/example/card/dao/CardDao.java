package com.example.card.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.card.bean.CardBean;
import com.example.card.bean.UserBean;
import com.example.card.db.sjk;

import java.util.ArrayList;

public class CardDao {

    public static SQLiteDatabase db = sjk.db;
    public static long addCard(CardBean card){
        ContentValues values = new ContentValues();
        values.put("id",card.getId());
        values.put("name",card.getName());
        values.put("xl",card.getXl());
        values.put("qy",card.getQy());
        values.put("price",card.getPrice());
        values.put("total",card.getTotal());
        long row;
        try{
            row = db.insert("card",null,values);
        }catch (Exception e){
            return 0;
        }
        return row;
    }
    public static long addCard(SQLiteDatabase db,CardBean card){
        ContentValues values = new ContentValues();
        values.put("id",card.getId());
        values.put("name",card.getName());
        values.put("xl",card.getXl());
        values.put("qy",card.getQy());
        values.put("price",card.getPrice());
        values.put("total",card.getTotal());
        long row = db.insert("card",null,values);
        return row;
    }

    public static long updateCard(CardBean card){

        ContentValues values = new ContentValues();
        values.put("name",card.getName());
        values.put("xl",card.getXl());
        values.put("qy",card.getQy());
        values.put("price",card.getPrice());
        values.put("total",card.getTotal());
        long rowId = db.update("card",values,"id=?",new String[]{card.getId()});
        return rowId;

    }

    public static ArrayList<CardBean> getAllCard(){
        Cursor r = db.rawQuery("select * from card",null);
        ArrayList<CardBean> list = new ArrayList<>();
        while(r.moveToNext()){
            String id = r.getString(0);
            String name = r.getString(1);
            String xl = r.getString(2);
            String qy = r.getString(3);
            String price = r.getString(4);
            String total = r.getString(5);
            CardBean cardBean = new CardBean(id,name,xl,qy,price,total);
            list.add(cardBean);
        }
        return list;
    }

    public static ArrayList<CardBean> getAllCardByXl(String sname) {
        String sql = "select * from card where xl like '%" + sname + "%'";

        Cursor res = db.rawQuery(sql,null);
        ArrayList<CardBean> list = new ArrayList<>();
        while(res.moveToNext()){

            String id = res.getString(0);
            String name = res.getString(1);
            String xl = res.getString(2);
            String qy = res.getString(3);
            String price = res.getString(4);
            String total = res.getString(5);

            CardBean cardBean = new CardBean(id,name,xl,qy,price,total);
            list.add(cardBean);
        }
        return list;
    }
}


