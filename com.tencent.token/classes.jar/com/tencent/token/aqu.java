package com.tencent.token;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public final class aqu
{
  public Context a = null;
  Handler b = null;
  public long c = 180000L;
  aqw d = null;
  private boolean e = false;
  private aqv f = null;
  private long g = 10000L;
  
  public aqu(Context paramContext, aqw paramaqw)
  {
    this.a = paramContext;
    this.f = new aqv(this);
    if (this.a == null) {
      return;
    }
    this.d = paramaqw;
    this.b = new aqy(this);
  }
  
  public final void a()
  {
    try
    {
      b();
      if (!this.e)
      {
        this.a.registerReceiver(this.f, new IntentFilter("com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE"));
        this.e = true;
      }
      aqt.a(this.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", this.c);
      return;
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    long l2 = this.g;
    long l1 = paramLong;
    if (paramLong < l2) {
      l1 = l2;
    }
    this.c = l1;
  }
  
  public final void b()
  {
    try
    {
      if (this.e)
      {
        this.a.unregisterReceiver(this.f);
        this.e = false;
      }
      aqt.a(this.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
      this.b.removeMessages(0);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqu
 * JD-Core Version:    0.7.0.1
 */