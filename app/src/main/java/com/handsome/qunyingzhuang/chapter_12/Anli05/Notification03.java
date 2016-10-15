package com.handsome.qunyingzhuang.chapter_12.Anli05;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.handsome.qunyingzhuang.MainActivity;
import com.handsome.qunyingzhuang.R;

public class Notification03 extends AppCompatActivity {

    private static final int NOTIFICATION_ID_HEADSUP = 0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification03);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Headsup Notification")
                .setContentText("I am a Headsup notification.");

        Intent push = new Intent();
        push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        push.setClass(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, push, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentText("Heads-Up Notification on Android 5.0")
                .setFullScreenIntent(pendingIntent, true);

        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID_HEADSUP, builder.build());
    }
}
