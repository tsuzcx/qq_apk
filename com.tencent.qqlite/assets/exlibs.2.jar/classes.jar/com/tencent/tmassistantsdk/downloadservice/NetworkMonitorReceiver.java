package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  private static NetworkMonitorReceiver a = null;
  private static Handler c;
  private boolean b = false;
  private ArrayList d = new ArrayList();
  
  public static NetworkMonitorReceiver a()
  {
    try
    {
      if (a == null) {
        a = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = a;
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public final void a(l paraml)
  {
    if ((!this.d.contains(paraml)) && (paraml != null)) {
      this.d.add(paraml);
    }
  }
  
  public final void b()
  {
    Context localContext = f.a().b();
    if (localContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.b = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.b = false;
      localThrowable.printStackTrace();
    }
  }
  
  public final void b(l paraml)
  {
    if (paraml != null) {
      this.d.remove(paraml);
    }
  }
  
  public final void c()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      Context localContext = f.a().b();
      if (localContext != null) {
        try
        {
          if (this.b)
          {
            localContext.unregisterReceiver(this);
            this.b = false;
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public final void d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).e();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    k.b("NetworkMonitorReceiver", "network changed!");
    if (c == null) {
      c = new m(this);
    }
    c.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    c.sendMessageDelayed(paramContext, 3500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */