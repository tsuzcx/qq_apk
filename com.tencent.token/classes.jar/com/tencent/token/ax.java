package com.tencent.token;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.tencent.halley.common.c;
import com.tencent.halley.common.h;

final class ax
{
  private static ax a = null;
  private bc b;
  private final BroadcastReceiver c = new ba(this);
  private final BroadcastReceiver d = new bb(this);
  
  public static ax a()
  {
    try
    {
      if (a == null) {
        a = new ax();
      }
      ax localax = a;
      return localax;
    }
    finally {}
  }
  
  public final void a(NetworkInfo paramNetworkInfo)
  {
    String str;
    if (paramNetworkInfo != null)
    {
      paramNetworkInfo = cb.b;
      cb.b();
      str = cb.b;
      if (!paramNetworkInfo.equals(str))
      {
        if ((!paramNetworkInfo.equals(cb.a)) || (!cb.f())) {
          break label64;
        }
        if (this.b == null) {
          break label56;
        }
        this.b.a();
      }
    }
    label56:
    label64:
    while ((str.equals(cb.a)) || (!cb.f()))
    {
      return;
      c.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
      return;
    }
    if (this.b != null)
    {
      this.b.a();
      return;
    }
    c.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
  }
  
  public final void a(bc parambc)
  {
    this.b = parambc;
    parambc = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    h.a().registerReceiver(this.c, parambc);
    c.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    c.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    parambc = new IntentFilter("action.scheduler.access.trigger.timer");
    h.a().registerReceiver(this.d, parambc);
    parambc = (AlarmManager)h.a().getSystemService("alarm");
    if (parambc != null)
    {
      long l = System.currentTimeMillis();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      parambc.setRepeating(3, l + 1800000L, 1800000L, PendingIntent.getBroadcast(h.a(), 0, localIntent, 0));
      c.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  public final void b()
  {
    if (this.b != null)
    {
      this.b.a();
      return;
    }
    c.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ax
 * JD-Core Version:    0.7.0.1
 */