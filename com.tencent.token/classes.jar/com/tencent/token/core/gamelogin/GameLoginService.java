package com.tencent.token.core.gamelogin;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.token.ui.IndexActivity;

public class GameLoginService
  extends Service
{
  private AlarmManager a;
  private PendingIntent b;
  private Intent c;
  private final int d = 3000;
  private int e;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Object localObject = new Intent(this, GameLoginService.class);
    this.a = ((AlarmManager)getSystemService("alarm"));
    this.b = PendingIntent.getService(this, 0, (Intent)localObject, 0);
    this.c = new Intent(this, IndexActivity.class);
    if (Build.VERSION.SDK_INT < 18)
    {
      this.e = ((int)System.currentTimeMillis());
      localObject = PendingIntent.getActivity(this, 0, this.c, 134217728);
      localObject = new NotificationCompat.Builder(this).setContentIntent((PendingIntent)localObject).setDefaults(1).setAutoCancel(true).build();
      startForeground(this.e, (Notification)localObject);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.cancel(this.b);
    if (Build.VERSION.SDK_INT < 18) {
      ((NotificationManager)getSystemService("notification")).cancel(this.e);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      long l = System.currentTimeMillis();
      this.a.set(1, l + 3000L, this.b);
    }
    if (Build.VERSION.SDK_INT < 18) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.gamelogin.GameLoginService
 * JD-Core Version:    0.7.0.1
 */