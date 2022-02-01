package tmsdk.common.d.a.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public class b
{
  private boolean a = false;
  private c b = null;
  private Context c = null;
  private Handler d = null;
  private long e = 180000L;
  private long f = 10000L;
  private d g = null;
  
  public b(Context paramContext, d paramd)
  {
    this.c = paramContext;
    this.b = new c(this);
    if (this.c == null) {
      return;
    }
    this.g = paramd;
    this.d = new f(this);
  }
  
  Context a()
  {
    return this.c;
  }
  
  public void a(long paramLong)
  {
    long l2 = this.f;
    long l1 = paramLong;
    if (paramLong < l2) {
      l1 = l2;
    }
    this.e = l1;
  }
  
  public void b()
  {
    try
    {
      d();
      if (!this.a)
      {
        this.c.registerReceiver(this.b, new IntentFilter("com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE"));
        this.a = true;
      }
      a.a(this.c, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", f());
      return;
    }
    finally {}
  }
  
  public void c()
  {
    a.a(this.c, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
    a.a(this.c, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", f());
  }
  
  public void d()
  {
    try
    {
      if (this.a)
      {
        this.c.unregisterReceiver(this.b);
        this.a = false;
      }
      a.a(this.c, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
      this.d.removeMessages(0);
      return;
    }
    finally {}
  }
  
  void e()
  {
    d locald = this.g;
    if (locald != null) {
      locald.j();
    }
  }
  
  public long f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */