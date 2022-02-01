package com.tencent.token;

import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import com.tencent.token.global.RqdApplication;

public final class wn
  extends ContextWrapper
{
  private NotificationManager a;
  
  public wn(Context paramContext)
  {
    super(paramContext);
  }
  
  private NotificationManager a()
  {
    if (this.a == null) {
      this.a = ((NotificationManager)getSystemService("notification"));
    }
    return this.a;
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        NotificationChannel localNotificationChannel = new NotificationChannel("channel_qqsafe", "channel_name_qqsafe", 4);
        a().createNotificationChannel(localNotificationChannel);
      }
      if (Build.VERSION.SDK_INT >= 26) {
        paramString1 = new Notification.Builder(RqdApplication.n(), "channel_qqsafe").setDefaults(1).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent).setSmallIcon(2131099914).setAutoCancel(true);
      } else {
        paramString1 = null;
      }
      paramString1 = paramString1.build();
      a().notify(paramInt, paramString1);
      return;
    }
    paramString1 = new ck.b(RqdApplication.n(), (byte)0).c().a(paramString1).b(paramString2);
    paramString1.e = paramPendingIntent;
    paramString1 = paramString1.a().b().d();
    a().notify(paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wn
 * JD-Core Version:    0.7.0.1
 */