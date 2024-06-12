package com.example.card.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.card.MainActivity;
import com.example.card.R;
import com.example.card.adapter.usercardAdapter;
import com.example.card.bean.CardBean;
import com.example.card.bean.ImageBean;
import com.example.card.dao.CardDao;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class UserLoginActivity extends AppCompatActivity {
    ArrayList<CardBean> search_list;
    usercardAdapter adapter;
    private List<ImageBean> imageList = new ArrayList<>();
    private Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ListView list = findViewById(R.id.userlist);
        ArrayList<CardBean> data = CardDao.getAllCard();

        banner = findViewById(R.id.banner);

        imageList.add(new ImageBean(R.drawable.e,"图片1"));
        imageList.add(new ImageBean(R.drawable.b,"图片2"));
        imageList.add(new ImageBean(R.drawable.c,"图片3"));
        imageList.add(new ImageBean(R.drawable.d,"图片4"));
        banner.setAdapter(new BannerImageAdapter<ImageBean>(imageList){
            @Override
            public void onBindView(BannerImageHolder holder, ImageBean imageList, int position, int size) {
                holder.imageView.setImageResource(imageList.getImg());
            }
        }).addBannerLifecycleObserver(this).setIndicator(new CircleIndicator(this));
        if(data == null || data.size() == 0){
            list.setAdapter(null);
        }else{
            adapter = new usercardAdapter(this,data);
            list.setAdapter(adapter);
        }

        EditText search = findViewById(R.id.sousuowenbenkuang);//搜索的内容

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String xl = search.getText().toString();
                search_list = CardDao.getAllCardByXl(xl);
                if(search_list == null || search_list.size() == 0){
                    list.setAdapter(null);
                }else{
                    adapter = new usercardAdapter(UserLoginActivity.this,search_list);
                    list.setAdapter(adapter);
                }
            }
        });

        Button back = findViewById(R.id.userback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLoginActivity.this, MainActivity.class));
            }
        });
    }
}