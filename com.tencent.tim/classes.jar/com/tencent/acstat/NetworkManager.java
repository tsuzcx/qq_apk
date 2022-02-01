package com.tencent.acstat;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpHost;

public class NetworkManager
{
  public static final int TYPE_NOT_WIFI = 2;
  public static final int TYPE_NO_NETWORK = 0;
  public static final int TYPE_WIFI = 1;
  private static NetworkManager g = null;
  private List<String> a = new ArrayList(10);
  private volatile int b = 2;
  private volatile String c = "";
  private volatile HttpHost d = null;
  private Handler e = null;
  private int f = 0;
  private Context h = null;
  private StatLogger i = null;
  
  private NetworkManager(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    HandlerThread localHandlerThread = new HandlerThread("StatNetworkMan");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
    g.a(paramContext);
    this.i = StatCommonHelper.getLogger();
    c();
    b();
    a();
  }
  
  private void b()
  {
    this.a.add("117.135.169.101");
    this.a.add("140.207.54.125");
    this.a.add("180.153.8.53");
    this.a.add("120.198.203.175");
    this.a.add("14.17.43.18");
    this.a.add("163.177.71.186");
    this.a.add("111.30.131.31");
    this.a.add("123.126.121.167");
    this.a.add("123.151.152.111");
    this.a.add("113.142.45.79");
    this.a.add("123.138.162.90");
    this.a.add("103.7.30.94");
  }
  
  private void c()
  {
    this.b = 0;
    this.d = null;
    this.c = null;
  }
  
  public static NetworkManager getInstance(Context paramContext)
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new NetworkManager(paramContext);
      }
      return g;
    }
    finally {}
  }
  
  void a()
  {
    if (Util.isNetworkAvailable(this.h))
    {
      this.c = StatCommonHelper.getLinkedWay(this.h);
      if (StatConfig.isDebugEnable()) {
        this.i.i("NETWORK name:" + this.c);
      }
      if (StatCommonHelper.isStringValid(this.c)) {
        if (!"WIFI".equalsIgnoreCase(this.c)) {
          break label105;
        }
      }
      label105:
      for (this.b = 1;; this.b = 2)
      {
        this.d = StatCommonHelper.getHttpProxy(this.h);
        if (StatServiceImpl.a()) {
          StatServiceImpl.e(this.h);
        }
        return;
      }
    }
    if (StatConfig.isDebugEnable()) {
      this.i.i("NETWORK TYPE: network is close.");
    }
    c();
  }
  
  public String getCurNetwrokName()
  {
    return this.c;
  }
  
  public HttpHost getHttpProxy()
  {
    return this.d;
  }
  
  public int getNetworkType()
  {
    return this.b;
  }
  
  public boolean isNetworkAvailable()
  {
    return this.b != 0;
  }
  
  public boolean isWifi()
  {
    return this.b == 1;
  }
  
  public void onDispatchFailed()
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      this.f = ((this.f + 1) % this.a.size());
    }
  }
  
  public void registerBroadcast()
  {
    try
    {
      this.h.getApplicationContext().registerReceiver(new a(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      return;
    }
    catch (Throwable localThrowable)
    {
      this.i.e(localThrowable);
    }
  }
  
  public void updateIpList(String paramString)
  {
    if (StatConfig.isDebugEnable()) {
      this.i.i("updateIpList " + paramString);
    }
    this.f = new Random().nextInt(this.a.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.NetworkManager
 * JD-Core Version:    0.7.0.1
 */