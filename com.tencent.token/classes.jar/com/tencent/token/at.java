package com.tencent.token;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;

final class at
{
  private static at a;
  private aw b;
  private final BroadcastReceiver c = new au(this);
  private final BroadcastReceiver d = new av(this);
  
  public static at a()
  {
    try
    {
      if (a == null) {
        a = new at();
      }
      at localat = a;
      return localat;
    }
    finally {}
  }
  
  public final void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null)
    {
      paramNetworkInfo = bq.b;
      bq.b();
      String str = bq.b;
      if (!paramNetworkInfo.equals(str))
      {
        if ((paramNetworkInfo.equals(bq.a)) && (bq.f()))
        {
          paramNetworkInfo = this.b;
          if (paramNetworkInfo != null)
          {
            paramNetworkInfo.a();
            return;
          }
          b.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
          return;
        }
        if ((!str.equals(bq.a)) && (bq.f()))
        {
          paramNetworkInfo = this.b;
          if (paramNetworkInfo != null)
          {
            paramNetworkInfo.a();
            return;
          }
          b.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
        }
      }
    }
  }
  
  public final void a(aw paramaw)
  {
    this.b = paramaw;
    paramaw = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    f.a().registerReceiver(this.c, paramaw);
    b.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    b.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    paramaw = new IntentFilter("action.scheduler.access.trigger.timer");
    f.a().registerReceiver(this.d, paramaw);
    paramaw = (AlarmManager)f.a().getSystemService("alarm");
    if (paramaw != null)
    {
      long l = System.currentTimeMillis();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      paramaw.setRepeating(3, 1800000L + l, 1800000L, PendingIntent.getBroadcast(f.a(), 0, localIntent, 0));
      b.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  public final void b()
  {
    aw localaw = this.b;
    if (localaw != null)
    {
      localaw.a();
      return;
    }
    b.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      try
      {
        at.this.b();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private Intent a;
    
    b(Intent paramIntent)
    {
      this.a = paramIntent;
    }
    
    public final void run()
    {
      NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      at.this.a(localNetworkInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.at
 * JD-Core Version:    0.7.0.1
 */