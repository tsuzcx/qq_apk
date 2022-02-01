package com.tencent.token;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public final class asq
{
  public Context a = null;
  Handler b = null;
  public long c = 180000L;
  ass d = null;
  private boolean e = false;
  private asr f = null;
  private long g = 10000L;
  
  public asq(Context paramContext, ass paramass)
  {
    this.a = paramContext;
    this.f = new asr(this);
    if (this.a == null) {
      return;
    }
    this.d = paramass;
    this.b = new asu(this);
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
      asp.a(this.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", this.c);
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
      asp.a(this.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
      this.b.removeMessages(0);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asq
 * JD-Core Version:    0.7.0.1
 */