package com.example.card.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import com.example.card.bean.CardBean;
//import com.example.card.dao.CardDao;
import com.example.card.bean.CardBean;
import com.example.card.bean.UserBean;

import com.example.card.dao.CardDao;
import com.example.card.dao.UserDao;


public class sjk extends SQLiteOpenHelper {

    //数据库名称
    private static final String DB_NAME = "pharmacy.db";

    //通过db来操作数据库
    public static SQLiteDatabase db = null;

    private static final int VERSION = 6;//数据库的版本

    private Context context;



    public sjk(Context context){
        super(context,DB_NAME,null,VERSION,null);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //取消外键
        db.execSQL("PRAGMA foreign_keys = false");

        db.execSQL("drop table if exists user");

        db.execSQL("create table user(userName varchar(20) primary key," +
                "userPassword varchar(20))");

        UserDao.addUser(db,new UserBean("root","123"));



        db.execSQL("drop table if exists card");

        db.execSQL("create table card(id varchar(20) primary key," +
                "name varchar(20)," +
                "xl varchar(20)," +
                "qy varchar(20)," +
                "price varchar(20)," +
                "total varchar(20))");

        CardBean card1 = new CardBean("1","卡名1","系列1","球星1","11.12","10");
        CardBean card2 = new CardBean("2","卡名2","系列2","球星2","12.02","28");
        CardBean card3 = new CardBean("3","卡名3","系列3","球星3","12.02","28");
        CardDao.addCard(db,card1);
        CardDao.addCard(db,card2);
        CardDao.addCard(db,card3);
        db.execSQL("PRAGMA foreign_keys = true");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

}