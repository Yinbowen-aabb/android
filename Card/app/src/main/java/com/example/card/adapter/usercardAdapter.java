package com.example.card.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ImageButton;
import com.example.card.R;
import com.example.card.bean.CardBean;
import com.example.card.dao.CardDao;
import com.example.card.TTS.tts;
import java.util.ArrayList;

public class usercardAdapter extends ArrayAdapter<CardBean> {
    private tts t;
    private ArrayList<CardBean> list;

    public usercardAdapter(@NonNull Context context, ArrayList<CardBean> list) {
        super(context, R.layout.user_list,list);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_list,parent,false);
        }

        TextView xl = convertView.findViewById(R.id.xilie);
        TextView qiuyuan = convertView.findViewById(R.id.qiuyuan);
        TextView jiage = convertView.findViewById(R.id.jiage);
        TextView kc = convertView.findViewById(R.id.kucunshuliang);
        CardBean cardBean = list.get(position);
        xl.setText(cardBean.getXl());
        qiuyuan.setText(cardBean.getQy());
        jiage.setText(cardBean.getPrice());
        kc.setText(cardBean.getTotal());

        t = new tts(getContext());
        ImageButton img = convertView.findViewById(R.id.bf);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSpeak = "系列" + xl.getText().toString() + "球员" + qiuyuan.getText().toString() + "价格" + jiage.getText().toString(); // 指定的文字
                t.speak(textToSpeak);
            }
        });



        return convertView;
    }
}
