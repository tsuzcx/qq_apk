package com.qzone.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qzone.common.logging.QDLog;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String TAG = NetworkState.class.getName();
  private static NetworkState instance = null;
  private static int networkType = 0;
  private Context context = null;
  private List<NetworkStateListener> observers = new ArrayList();
  private String providerName = null;
  
  public static NetworkState g()
  {
    if (instance == null) {
      instance = new NetworkState();
    }
    return instance;
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    }
    for (;;)
    {
      networkType = 0;
      return networkType;
      networkType = 1;
      return networkType;
      switch (paramNetworkInfo.getSubtype())
      {
      }
    }
    networkType = 3;
    return networkType;
    networkType = 2;
    return networkType;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return true;
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getAllNetworkInfo();
        if (paramContext == null) {
          break;
        }
        i = 0;
        if (i >= paramContext.length) {
          break;
        }
        if (paramContext[i].isConnectedOrConnecting())
        {
          getNetworkType(paramContext[i]);
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (this.observers)
      {
        NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateListener[this.observers.size()];
        this.observers.toArray(arrayOfNetworkStateListener);
        if (arrayOfNetworkStateListener != null)
        {
          int j = arrayOfNetworkStateListener.length;
          i = 0;
          if (i < j) {}
        }
        else
        {
          return;
        }
      }
      localObject[i].onNetworkConnect(paramBoolean);
      i += 1;
    }
  }
  
  public void addListener(NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.observers)
    {
      if (!this.observers.contains(paramNetworkStateListener)) {
        this.observers.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public int getNetworkType()
  {
    return networkType;
  }
  
  public String getProviderName()
  {
    return this.providerName;
  }
  
  public boolean isNetworkAvailable()
  {
    boolean bool1;
    if (this.context == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    QDLog.e(TAG, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public boolean isNetworkConnected()
  {
    if (this.context == null) {
      return true;
    }
    return isNetworkConnected(this.context);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QDLog.e(TAG, "NetworkStateReceiver ====== " + paramIntent.getAction());
    if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
      notifyObservers(isNetworkConnected(paramContext));
    }
  }
  
  public void removeListener(NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.observers)
    {
      this.observers.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
    Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject1 = null;
    try
    {
      localObject2 = ((TelephonyManager)localObject2).getSubscriberId();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      label24:
      break label24;
    }
    if ((localObject1 == null) || ("".equals(localObject1))) {
      this.providerName = "unknown";
    }
    for (;;)
    {
      paramContext.registerReceiver(this, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
      isNetworkConnected(paramContext);
      return;
      if ((localObject1.startsWith("46000")) || (localObject1.startsWith("46002"))) {
        this.providerName = "ChinaMobile";
      } else if (localObject1.startsWith("46001")) {
        this.providerName = "ChinaUnicom";
      } else if (localObject1.startsWith("46003")) {
        this.providerName = "ChinaTelecom";
      } else {
        this.providerName = "unknown";
      }
    }
  }
  
  public void unregisterReceiver()
  {
    this.context.unregisterReceiver(this);
  }
  
  public static abstract interface NetworkStateListener
  {
    public abstract void onNetworkConnect(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.NetworkState
 * JD-Core Version:    0.7.0.1
 */