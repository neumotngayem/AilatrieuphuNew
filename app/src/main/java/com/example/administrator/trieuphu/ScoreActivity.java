package com.example.administrator.trieuphu;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ScoreActivity extends Activity {
    TextView textView;
    ArrayList<ArrayList<String>> listHighScore;
    ListView listScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        textView = (TextView)findViewById(R.id.tvHigh) ;
        Typeface face = Typeface.createFromAsset(getAssets(),"font/dorid.ttf");
        textView.setTypeface(face);
        listHighScore = new ArrayList<>();
        for(int i = 0; i< 15;i++){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(i+1+"");
            temp.add("Bac "+i);
            listHighScore.add(temp);
        }
        ListScoreAdapter adapter = new ListScoreAdapter(this,listHighScore);
        listScore = (ListView) findViewById(R.id.listScore);
        listScore.setAdapter(adapter);

    }
}
