package com.handsome.qunyingzhuang.chapter_12.Anli03;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.handsome.qunyingzhuang.R;

public class Notification01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification01);
        //第一步：初始化
        Notification.Builder builder = new Notification.Builder(this);
        //第二步：构建点击之后的意图
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        //构造pendingdintent
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent}, 0);
        //第三步：设置通知栏的各种消息
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentText("Title");
        builder.setContentText("内容");
        builder.setSubText("text");
        //第四步：通过NotificationManager来发出
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
