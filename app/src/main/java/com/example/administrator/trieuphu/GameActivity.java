package com.example.administrator.trieuphu;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameActivity extends Activity implements View.OnClickListener {
    List<ArrayList<String>> listQuest;
    ListView listViewQuest;
    ListViewAdapter adapter;
    TextView btnAnswerA,btnAnswerB,btnAnswerC,btnAnswerD,tvQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        listViewQuest = (ListView) findViewById(R.id.listQuest);
        listViewQuest.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listQuest = new ArrayList<>();
        ArrayList<String> mnList = new ArrayList<>();
        Collections.addAll(mnList,"200","400","600","1,000","2,000","3,000","6.000","10,000","14,000","22,000","30,000","40,000","60,000","85,000","150,000");
        for (int i = 14; i>=0;i--){
            ArrayList<String> temp = new ArrayList<>();
            temp.add((i+1)+"");
            temp.add(mnList.get(i));
            listQuest.add(temp);
        }
        adapter = new ListViewAdapter(this,listQuest);
        listViewQuest.setAdapter(adapter);
        btnAnswerA = (TextView)findViewById(R.id.ansA);
        btnAnswerB = (TextView)findViewById(R.id.ansB);
        btnAnswerC = (TextView)findViewById(R.id.ansC);
        btnAnswerD = (TextView)findViewById(R.id.ansD);
        tvQuest = (TextView)findViewById(R.id.tvQuest);
        btnAnswerA.setOnClickListener(this);
        btnAnswerB.setOnClickListener(this);
        btnAnswerC.setOnClickListener(this);
        btnAnswerD.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.ansA:{
                removeQuestList();

                break;
            }
            case R.id.ansB:{

                initQuestList(14);


                break;
            }

        }
    }
    void removeQuestList(){
        //animator dich ra
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.slide_right_exit);
        set.setTarget(listViewQuest);
        set.start();
        // cac text view ve binh thuong
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btnAnswerA.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_widthnor);
        btnAnswerA.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerB.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_widthnor);
        btnAnswerB.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerC.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_widthnor);
        btnAnswerC.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerD.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_widthnor);
        btnAnswerD.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) tvQuest.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.questtext_view_widthnor);
        tvQuest.setLayoutParams(params);

    }
    void initQuestList(final int indexSelect){
        //animator dich vao
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.slide_right_enter);
        set.setTarget(listViewQuest);
        set.start();
        //cac text view thut vao
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btnAnswerA.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_width);
        btnAnswerA.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerB.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_width);
        btnAnswerB.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerC.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_width);
        btnAnswerC.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) btnAnswerD.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.text_view_width);
        btnAnswerD.setLayoutParams(params);
        params = (RelativeLayout.LayoutParams) tvQuest.getLayoutParams();
        params.width=getResources().getDimensionPixelSize(R.dimen.questtext_view_width);
        tvQuest.setLayoutParams(params);
        //nhap nhay
        new CountDownTimer(1500, 100) {
            boolean flag = true;
            @Override
            public void onTick(long millisUntilFinished) {
                if(flag){
                    adapter.setSelectedItem(indexSelect);
                    flag=false;
                }else{
                    adapter.setSelectedItem(-1);
                    flag=true;
                }

            }

            @Override
            public void onFinish() {
                adapter.setSelectedItem(indexSelect);
            }
        }.start();
    }
}
