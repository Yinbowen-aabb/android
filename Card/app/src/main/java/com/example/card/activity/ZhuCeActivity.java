package com.example.card.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.card.R;
import com.example.card.bean.UserBean;
import com.example.card.dao.UserDao;

public class ZhuCeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//
        setContentView(R.layout.activity_zhu_ce);
        EditText zh = findViewById(R.id.zc_zh);
        EditText mm = findViewById(R.id.zc_mm);
        EditText mm2 = findViewById(R.id.zc_mm2);
        Button btn = findViewById(R.id.btn_zc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zh.getText().toString() == "" || mm.getText().toString() == "" || mm2.getText().toString() == ""){
                    Toast.makeText(ZhuCeActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else if(!mm.getText().toString().equals(mm2.getText().toString())){
                    Toast.makeText(ZhuCeActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                }else{
                    long i = UserDao.addUser(new UserBean(zh.getText().toString(),mm.getText().toString()));
                    if(i > 0){
                        Toast.makeText(ZhuCeActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ZhuCeActivity.this,LoginActivity.class));
                    }else{
                        Toast.makeText(ZhuCeActivity.this,"注册失败，账号已存在",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button back = findViewById(R.id.zcback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}