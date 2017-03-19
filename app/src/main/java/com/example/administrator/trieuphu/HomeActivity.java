package com.example.administrator.trieuphu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends Activity implements View.OnClickListener {
    Intent svc;
    Button btnStart,btnHighScore,btnExit;
    ImageView soudImg;
    Dialog dialogReady;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_home);
        svc = new Intent(this, BackgroundSoundService.class);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnHighScore = (Button) findViewById(R.id.btnScore);
        btnExit = (Button) findViewById(R.id.btnExit);
        soudImg = (ImageView) findViewById(R.id.btnSpeak);
        btnStart.setOnClickListener(this);
        btnHighScore.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        soudImg.setOnClickListener(this);
        dialogReady = new Dialog(this);
        dialogReady.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogReady.setContentView(R.layout.custom_dialog_ready);
        Button btnReady = (Button) dialogReady.findViewById(R.id.btnReady);
        Button btnNotReady = (Button) dialogReady.findViewById(R.id.btnNotReady);
        btnReady.setOnClickListener(this);
        btnNotReady.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(soudImg.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.speak).getConstantState()){
            startService(svc);
        }else{
            stopService(svc);
        }
    }

    @Override
    protected void onPause() {
        stopService(svc);
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnStart:{
                dialogReady.show();
                break;
            }
            case R.id.btnReady: {
                  Intent intent = new Intent(this,GameActivity.class);
                  startActivity(intent);
                break;
            }
            case R.id.btnNotReady:{
                dialogReady.cancel();
                break;
            }
            case R.id.btnScore:{
                Intent intent = new Intent(this,ScoreActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnExit:{
                System.exit(0);
                break;
            }
            case R.id.btnSpeak:{
                if(soudImg.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.speak).getConstantState()){
                    stopService(svc);
                    soudImg.setImageResource(R.drawable.nonspeak);
                }else{
                    startService(svc);
                    soudImg.setImageResource(R.drawable.speak);
                }

                break;
            }

        }
    }
}
