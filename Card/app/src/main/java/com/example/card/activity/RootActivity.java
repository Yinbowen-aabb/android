package com.example.card.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.card.MainActivity;
import com.example.card.R;
import com.example.card.adapter.cardAdapter;
import com.example.card.bean.CardBean;
import com.example.card.dao.CardDao;

//import com.example.card.dao.UserDao;

import java.util.ArrayList;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        ListView list = findViewById(R.id.kucunliebiao);
        ArrayList<CardBean> data = CardDao.getAllCard();

        cardAdapter adapter;
        if(data == null || data.size() == 0){
            list.setAdapter(null);
        }else{
            adapter = new cardAdapter(this,data);
            list.setAdapter(adapter);
        }

        Button back = findViewById(R.id.rootloginback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RootActivity.this, MainActivity.class));
            }
        });




    }
}