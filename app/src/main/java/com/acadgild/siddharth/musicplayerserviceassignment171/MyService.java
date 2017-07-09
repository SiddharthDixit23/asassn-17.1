package com.acadgild.siddharth.musicplayerserviceassignment171;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by siddharth on 7/9/2017.
 */

public class MyService extends Service {
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Raw file inflated
    @Override
    public void onCreate() {
        mp = MediaPlayer.create(getApplicationContext(),R.raw.song);
        super.onCreate();

    }
// functionality
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp.start();
        mp.setLooping(false);
        return START_STICKY;
    }
// Destroy method called
    @Override
    public void onDestroy() {
        mp.pause();
        super.onDestroy();
    }
}
