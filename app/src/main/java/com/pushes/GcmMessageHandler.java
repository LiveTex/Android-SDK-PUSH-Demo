package com.pushes;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;


/**
 * Created by user on 11.08.15.
 */
public class GcmMessageHandler extends IntentService {

    public static final int NOTIFICATION_ID = 1;

    private String mes;
    private Handler handler;


    public GcmMessageHandler() {
        super("GcmMessageHandler");
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        handler = new Handler();

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        final String mess = extras.getString("text");
        Log.d("tag", "push " + mess);
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(GcmMessageHandler.this, mess, Toast.LENGTH_LONG).show();
            }
        });


    }

    private void sendNotification(String text, Intent intent) {

    }



}
