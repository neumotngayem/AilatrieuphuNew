package com.example.administrator.trieuphu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 3/13/2017.
 */

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.intro);
        player.setLooping(true);
        player.setVolume(1.0f,1.0f);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}
