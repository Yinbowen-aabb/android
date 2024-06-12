package com.example.card.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.card.R;
import com.example.card.activity.LoginActivity;
import com.example.card.bean.CardBean;
import com.example.card.dao.CardDao;

import java.util.ArrayList;

public class cardAdapter extends ArrayAdapter<CardBean> {
    private ArrayList<CardBean> list;

    public cardAdapter(@NonNull Context context, ArrayList<CardBean> list) {
        super(context, R.layout.card_list,list);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.card_list,parent,false);
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
        Button tj = convertView.findViewById(R.id.xiugaishuliang);
        tj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl = kc.getText().toString();
                int slint = Integer.parseInt(sl);
                slint = slint + 1;
                kc.setText(String.valueOf(slint));
                cardBean.setTotal(kc.getText().toString());
                CardDao.updateCard(cardBean);
            }
        });
        return convertView;
    }
}
