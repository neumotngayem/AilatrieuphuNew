package com.example.administrator.trieuphu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 3/2/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater  inflater;
    private List<ArrayList<String>> list;
    private  ArrayList<String> model;

    public ListViewAdapter(Context context, List<ArrayList<String>> list) {
        if(list!=null){
            this.list = list;
        }else{
            list = new ArrayList<>();
        }
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_quest,parent,false);
        if(view!=null){
            model=list.get(position);
            if(model!=null) {
                TextView txtQNum = (TextView) view.findViewById(R.id.txtQuestNum);
                TextView txtMoney = (TextView) view.findViewById(R.id.txtMoney);
                txtQNum.setText(String.valueOf(model.get(0)));
                txtMoney.setText(String.valueOf(model.get(1)));
            }
        }
        LinearLayout ActiveItem = (LinearLayout) view;
        if (position == selectedItem){
            ActiveItem.setBackgroundColor(Color.parseColor("#EF6C00"));

            // for focus on it
            int top = (ActiveItem == null) ? 0 : ActiveItem.getTop();
            ((ListView) parent).setSelectionFromTop(position, top);
        }
        else{
            ActiveItem.setBackgroundResource(R.color.colorPrimaryDark);
        }
        return view;
    }
    private int selectedItem=-1;

    public void setSelectedItem(int position) {
        selectedItem = position;
        notifyDataSetChanged();
    }
}
