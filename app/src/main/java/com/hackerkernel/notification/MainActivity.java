package com.hackerkernel.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){

                    NotificationChannel channel=new NotificationChannel("mynotification","notification",NotificationManager.IMPORTANCE_DEFAULT);

                    NotificationManager manager=getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }


                NotificationCompat.Builder mbuilder=(NotificationCompat.Builder)
                        new NotificationCompat.Builder(MainActivity.this,"mynotification")
                        .setSmallIcon(R.drawable.ankit)
                        .setContentTitle("notification")
                        .setContentText("my name is nagendra patel")
                        .setAutoCancel(true);


               /* Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                resultIntent.putExtra("ankit",message);

                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,
                        0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                mbuilder.setContentIntent(pendingIntent);*/

               /* TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                stackBuilder.addParentStack(ResultActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                mbuilder.setContentIntent(resultPendingIntent);*/

               // mbuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

              NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(MainActivity.this);
              notificationManagerCompat.notify(999,mbuilder.build());

            }
        });
    }
}