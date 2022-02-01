package com.tencent.android.tpush.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.apache.http.HttpHost;

public class b
{
  private static volatile b a = null;
  private volatile int b = 2;
  private volatile String c = "";
  private volatile HttpHost d = null;
  private Context e = null;
  private c f = null;
  
  private b(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    f.a(paramContext);
    this.f = com.tencent.android.tpush.stat.b.b.b();
    f();
    d();
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void f()
  {
    this.b = 0;
    this.d = null;
    this.c = null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  public boolean c()
  {
    return this.b != 0;
  }
  
  void d()
  {
    if (DeviceInfos.isNetworkAvailable(this.e))
    {
      this.c = DeviceInfos.getLinkedWay(this.e);
      if (d.b()) {
        this.f.b("NETWORK name:" + this.c);
      }
      if (com.tencent.android.tpush.stat.b.b.c(this.c)) {
        if (!"WIFI".equalsIgnoreCase(this.c)) {
          break label95;
        }
      }
      label95:
      for (this.b = 1;; this.b = 2)
      {
        this.d = com.tencent.android.tpush.stat.b.b.b(this.e);
        return;
      }
    }
    if (d.b()) {
      this.f.b("NETWORK TYPE: network is close.");
    }
    f();
  }
  
  @JgMethodChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK})
  public void e()
  {
    try
    {
      this.e.getApplicationContext().registerReceiver(new b.1(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("registerBroadcast", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b
 * JD-Core Version:    0.7.0.1
 */