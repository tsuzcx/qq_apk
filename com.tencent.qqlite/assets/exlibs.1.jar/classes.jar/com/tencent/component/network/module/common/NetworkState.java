package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String a = NetworkState.class.getName();
  private static NetworkState b = null;
  private static int e = 0;
  private Context c = null;
  private String d = null;
  private List<NetworkStateListener> f = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (this.f)
      {
        int j = this.f.size();
        NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateListener[j];
        this.f.toArray(arrayOfNetworkStateListener);
        i = 0;
        if (i >= j) {
          return;
        }
      }
      localObject[i].onNetworkConnect(paramBoolean);
      i += 1;
    }
  }
  
  public static NetworkState g()
  {
    if (b == null) {
      b = new NetworkState();
    }
    return b;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return true;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAllNetworkInfo();
        int i;
        if (paramContext != null)
        {
          i = 0;
          if (i < paramContext.length) {
            if (paramContext[i].isConnectedOrConnecting()) {
              paramContext = paramContext[i];
            }
          }
        }
        switch (paramContext.getType())
        {
        case 1: 
          e = 0;
          continue;
          e = 1;
          break;
        case 0: 
          switch (paramContext.getSubtype())
          {
          case 1: 
          case 2: 
          case 4: 
          case 7: 
          case 11: 
            e = 3;
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
            e = 2;
            continue;
            i += 1;
            continue;
            return false;
          }
        default: 
          continue;
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        return true;
      }
    }
  }
  
  public void addListener(NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.f)
    {
      if (!this.f.contains(paramNetworkStateListener)) {
        this.f.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public int getNetworkType()
  {
    return e;
  }
  
  public String getProviderName()
  {
    return this.d;
  }
  
  public boolean isNetworkAvailable()
  {
    boolean bool1;
    if (this.c == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    Const.e(a, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public boolean isNetworkConnected()
  {
    if (this.c == null) {
      return true;
    }
    return isNetworkConnected(this.c);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Const.e(a, "NetworkStateReceiver ====== " + paramIntent.getAction());
    if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
      a(isNetworkConnected(paramContext));
    }
  }
  
  public void removeListener(NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.f)
    {
      this.f.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    if (this.c != null) {
      return;
    }
    this.c = paramContext;
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        this.d = "unknown";
        paramContext.registerReceiver(this, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
        isNetworkConnected(paramContext);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        if ((localObject2.startsWith("46000")) || (localObject2.startsWith("46002"))) {
          this.d = "ChinaMobile";
        } else if (localObject2.startsWith("46001")) {
          this.d = "ChinaUnicom";
        } else if (localObject2.startsWith("46003")) {
          this.d = "ChinaTelecom";
        } else {
          this.d = "unknown";
        }
      }
    }
  }
  
  public void unregisterReceiver()
  {
    this.c.unregisterReceiver(this);
  }
  
  public static abstract interface NetworkStateListener
  {
    public abstract void onNetworkConnect(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkState
 * JD-Core Version:    0.7.0.1
 */