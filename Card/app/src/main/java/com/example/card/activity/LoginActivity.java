package com.example.card.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.card.MainActivity;
import com.example.card.R;
import com.example.card.bean.UserBean;
import com.example.card.dao.UserDao;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText zh = findViewById(R.id.shuruzhanghao);
        EditText mm = findViewById(R.id.shurumima);
        UserDao dao = new UserDao();
        Button login = findViewById(R.id.denglu);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(zh.getText().toString() == "" || mm.getText().toString() == ""){
                    Toast.makeText(LoginActivity.this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                }else{
                    UserBean user = dao.login(zh.getText().toString(),mm.getText().toString());
                    if(user != null){
                        if(user.getUserName().equals("root")){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, RootActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, UserLoginActivity.class));
                        }

                    }else{
                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        Button back = findViewById(R.id.loginback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}