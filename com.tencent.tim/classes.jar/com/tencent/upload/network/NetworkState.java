package com.tencent.upload.network;

import alla;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int IP_STACK_DUAL = 3;
  public static final int IP_STACK_IPV4 = 1;
  public static final int IP_STACK_IPV6 = 2;
  public static final int IP_STACK_NONE = 0;
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_4G = 6;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String TAG = "NetworkState";
  private static NetworkState instance = null;
  private static int networkType = 0;
  private String apn = "none";
  private Context context = null;
  private boolean loadProviderName = false;
  private List<NetworkStateListener> observers = new ArrayList();
  private String providerName = null;
  
  public static NetworkState getInstance()
  {
    if (instance == null) {
      instance = new NetworkState();
    }
    return instance;
  }
  
  public static int getNetworkStackType()
  {
    if (!ConnectionImpl.isLibraryPrepared()) {
      return 1;
    }
    return ConnectionImpl.getIpStack();
  }
  
  public static int getNetworkStackTypeInner()
  {
    if (UploadGlobalConfig.getConfig() == null) {}
    while (!UploadGlobalConfig.getConfig().enableV6Route()) {
      return 1;
    }
    return getNetworkStackType();
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    default: 
      networkType = 0;
    }
    for (;;)
    {
      return networkType;
      networkType = 1;
      continue;
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        networkType = 3;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        networkType = 2;
        break;
      case 13: 
        networkType = 6;
      }
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          boolean bool;
          if (paramContext != null) {
            bool = paramContext.isConnected();
          }
          return bool;
        }
      }
      catch (Throwable paramContext)
      {
        return true;
      }
      paramContext = null;
    }
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    int j;
    int i;
    NetworkInfo localNetworkInfo;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label59;
      }
      j = paramContext.length;
      i = 0;
    }
    catch (SecurityException paramContext)
    {
      return true;
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    if (localNetworkInfo.isConnectedOrConnecting())
    {
      getNetworkType(localNetworkInfo);
      return true;
    }
    label59:
    label79:
    for (;;)
    {
      return false;
      for (;;)
      {
        if (i >= j) {
          break label79;
        }
        localNetworkInfo = paramContext[i];
        if (localNetworkInfo != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void notifyApnChanged(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].onNetworkApnChanged(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].onNetworkConnected(paramBoolean);
          i += 1;
        }
      }
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
  
  public String getApnName()
  {
    return this.apn;
  }
  
  public String getApnValue()
  {
    if (this.context == null) {
      return "none";
    }
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)this.context.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
            break;
          }
          if (1 == ((NetworkInfo)localObject1).getType()) {
            return "wifi";
          }
          if (((NetworkInfo)localObject1).getExtraInfo() != null) {
            return ((NetworkInfo)localObject1).getExtraInfo().toLowerCase();
          }
          return "unknown";
        }
      }
      catch (Throwable localThrowable)
      {
        return "unknown";
      }
      Object localObject2 = null;
    }
    return "none";
  }
  
  public int getNetworkType()
  {
    return networkType;
  }
  
  public String getProviderName()
  {
    Object localObject1;
    if (!this.loadProviderName)
    {
      this.loadProviderName = true;
      localObject1 = (TelephonyManager)this.context.getSystemService("phone");
    }
    try
    {
      localObject1 = alla.e((TelephonyManager)localObject1);
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        this.providerName = "unknown";
        return this.providerName;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        if ((localObject2.startsWith("46000")) || (localObject2.startsWith("46002"))) {
          this.providerName = "ChinaMobile";
        } else if (localObject2.startsWith("46001")) {
          this.providerName = "ChinaUnicom";
        } else if (localObject2.startsWith("46003")) {
          this.providerName = "ChinaTelecom";
        } else {
          this.providerName = "unknown";
        }
      }
    }
  }
  
  public boolean isNetworkAvailable()
  {
    boolean bool1;
    if (this.context == null) {
      bool1 = true;
    }
    Object localObject;
    boolean bool2;
    do
    {
      return bool1;
      localObject = null;
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        localObject = localNetworkInfo;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          UploadLog.e("NetworkState", "fail to get active network info", localThrowable);
        }
        bool2 = localObject.isConnected();
        bool1 = bool2;
      }
      if (localObject == null) {
        return false;
      }
    } while (bool2);
    UploadLog.e("NetworkState", "isNetworkEnable() : FALSE with TYPE = " + localObject.getType());
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
    String str = getApnValue();
    UploadLog.d("NetworkState", "NetworkStateReceiver ====== " + paramIntent.getAction() + " apn:" + this.apn + " -> " + str + " Available:" + isNetworkAvailable(paramContext));
    if (paramIntent.getAction() == null) {}
    do
    {
      return;
      if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
        notifyObservers(isNetworkConnected(paramContext));
      }
    } while ((str == null) || (str.equalsIgnoreCase(this.apn)));
    notifyApnChanged(true);
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
    paramContext.registerReceiver(this, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
    isNetworkConnected(paramContext);
  }
  
  public void unregisterReceiver()
  {
    this.context.unregisterReceiver(this);
  }
  
  public static final class APNName
  {
    public static final String NAME_3GNET = "3gnet";
    public static final String NAME_3GWAP = "3gwap";
    public static final String NAME_777 = "#777";
    public static final String NAME_CMCC = "cmcc";
    public static final String NAME_CMCT = "cmct";
    public static final String NAME_CMNET = "cmnet";
    public static final String NAME_CMWAP = "cmwap";
    public static final String NAME_CTNET = "ctnet";
    public static final String NAME_CTWAP = "ctwap";
    public static final String NAME_NONE = "none";
    public static final String NAME_UNICOM = "unicom";
    public static final String NAME_UNINET = "uninet";
    public static final String NAME_UNIWAP = "uniwap";
    public static final String NAME_UNKNOWN = "unknown";
    public static final String NAME_WIFI = "wifi";
  }
  
  public static abstract interface NetworkStateListener
  {
    public abstract void onNetworkApnChanged(boolean paramBoolean);
    
    public abstract void onNetworkConnected(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.NetworkState
 * JD-Core Version:    0.7.0.1
 */