package com.example.card.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.card.bean.UserBean;
import com.example.card.db.sjk;

public class UserDao {
    public static SQLiteDatabase db = sjk.db;

    //注册用户
    public static long addUser(UserBean user){
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("userPassword",user.getUserPassword());
        long row = 0;
        try{
            row = db.insert("user",null,values);
        }catch (Exception e){
            return 0;
        }
        return row;
    }

    public static long addUser(SQLiteDatabase db,UserBean user){
        ContentValues values = new ContentValues();
        values.put("userName",user.getUserName());
        values.put("userPassword",user.getUserPassword());
        long row = db.insert("user",null,values);
        return row;
    }
    public static UserBean login(String username,String pwd){//登录是否成功
        String sql = "select * from user where userName=? and userPassword=?";
        String values[] = {username,pwd};

        Cursor res= db.rawQuery(sql,values);
        while(res.moveToNext()){
            String name = res.getString(0);
            String password = res.getString(1);

            UserBean user = new UserBean(name,password);
            return user;

        }
        return null;
    }
}
