package com.acadgild.siddharth.musicplayerserviceassignment171;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button playbtn,stopbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbtn = (Button) findViewById(R.id.play);
        stopbtn = (Button) findViewById(R.id.stop);

        // On click listener for the play button

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);

                // Notification start function called

                simpleNotification();
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });
    }

    // Notification function

    private void simpleNotification(){
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Song playing")
                .setContentTitle("Music player");

        NotificationManager mNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotification.notify(1,mbuilder.build());

    }
}
