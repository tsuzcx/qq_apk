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

final class as
{
  private static as a;
  private av b;
  private final BroadcastReceiver c = new at(this);
  private final BroadcastReceiver d = new au(this);
  
  public static as a()
  {
    try
    {
      if (a == null) {
        a = new as();
      }
      as localas = a;
      return localas;
    }
    finally {}
  }
  
  public final void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null)
    {
      paramNetworkInfo = bp.b;
      bp.b();
      String str = bp.b;
      if (!paramNetworkInfo.equals(str))
      {
        if ((paramNetworkInfo.equals(bp.a)) && (bp.f()))
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
        if ((!str.equals(bp.a)) && (bp.f()))
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
  
  public final void a(av paramav)
  {
    this.b = paramav;
    paramav = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    f.a().registerReceiver(this.c, paramav);
    b.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    b.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    paramav = new IntentFilter("action.scheduler.access.trigger.timer");
    f.a().registerReceiver(this.d, paramav);
    paramav = (AlarmManager)f.a().getSystemService("alarm");
    if (paramav != null)
    {
      long l = System.currentTimeMillis();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      paramav.setRepeating(3, 1800000L + l, 1800000L, PendingIntent.getBroadcast(f.a(), 0, localIntent, 0));
      b.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  public final void b()
  {
    av localav = this.b;
    if (localav != null)
    {
      localav.a();
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
        as.this.b();
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
      as.this.a(localNetworkInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.as
 * JD-Core Version:    0.7.0.1
 */