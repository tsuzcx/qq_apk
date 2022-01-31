package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  private static NetworkMonitorReceiver a = null;
  private boolean b = false;
  private Handler c = new l(this);
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
  
  public final void a(m paramm)
  {
    if ((!this.d.contains(paramm)) && (paramm != null)) {
      this.d.add(paramm);
    }
  }
  
  public final void b()
  {
    Context localContext = e.a().b();
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
  
  public final void b(m paramm)
  {
    if (paramm != null) {
      this.d.remove(paramm);
    }
  }
  
  public final void c()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      Context localContext = e.a().b();
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
      ((m)localIterator.next()).e();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    j.b("NetworkMonitorReceiver", "network changed!");
    this.c.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    this.c.sendMessageDelayed(paramContext, 3500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */