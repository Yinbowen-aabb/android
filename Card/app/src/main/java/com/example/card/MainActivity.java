package com.example.card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.card.activity.LoginActivity;
import com.example.card.activity.UserLoginActivity;
import com.example.card.activity.ZhuCeActivity;
import com.example.card.db.sjk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sjk dataBase = new sjk(MainActivity.this);
        SQLiteDatabase db = dataBase.getWritableDatabase();//获取连接
        dataBase.db = db;

        Button login_btn = findViewById(R.id.login);
        Button reg_btn = findViewById(R.id.register);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ZhuCeActivity.class));
            }
        });
    }
}