package com.tencent.component.network;

import alkz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.component.network.downloader.GlobalHandlerThread;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkManager
{
  private static Object LOCK_NETLSTENER = new Object();
  public static final int Operator_CMCC = 1;
  public static final int Operator_CMCT = 3;
  public static final int Operator_Unicom = 2;
  public static final int Operator_Unknown = 0;
  public static final int Operator_WIFI = 4;
  private static Context mContext;
  private static List<WeakReference<NetStatusListener>> mNetworkListener = Collections.synchronizedList(new ArrayList());
  private static NetworkChangeReceiver sNetworkChangeReceiver;
  
  public static String getApnValue()
  {
    if (sNetworkChangeReceiver == null) {}
    while ("none" != "none") {
      return "none";
    }
    return sNetworkChangeReceiver.getApnValue();
  }
  
  public static String getBSSID()
  {
    try
    {
      Object localObject = alkz.a((WifiManager)mContext.getSystemService("wifi"));
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static int getISPType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((paramString.contains("cmnet")) || (paramString.contains("cmwap")) || (paramString.contains("cmcc"))) {
      return 1;
    }
    if ((paramString.contains("uninet")) || (paramString.contains("uniwap")) || (paramString.contains("unicom")) || (paramString.contains("3gnet")) || (paramString.contains("3gwap"))) {
      return 2;
    }
    if ((paramString.contains("ctwap")) || (paramString.contains("ctnet")) || (paramString.contains("cmct")) || (paramString.contains("#777"))) {
      return 3;
    }
    return getOperator();
  }
  
  public static int getIspType()
  {
    return getISPType(getApnValue());
  }
  
  private static int getOperator()
  {
    return Config.getOperator();
  }
  
  public static void init(Context paramContext)
  {
    if (mContext != null) {
      return;
    }
    mContext = paramContext;
    try
    {
      sNetworkChangeReceiver = new NetworkChangeReceiver(paramContext);
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.registerReceiver(sNetworkChangeReceiver, localIntentFilter);
      return;
    }
    catch (Exception paramContext)
    {
      QDLog.e("NetworkManager", "downloader register NetworkChangeReceiver failed!", paramContext);
    }
  }
  
  public static boolean isMobile()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 == null) {
          break label49;
        }
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
          break;
        }
        int i = ((NetworkInfo)localObject1).getType();
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable) {}
      return false;
      label49:
      Object localObject2 = null;
    }
    return false;
  }
  
  public static boolean isNetworkAvailable()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          boolean bool;
          if (localObject1 != null) {
            bool = ((NetworkInfo)localObject1).isConnected();
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        return true;
      }
      Object localObject2 = null;
    }
  }
  
  public static boolean isWap()
  {
    String str = getApnValue();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.contains("cmwap")) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap"))) {
      return false;
    }
    return true;
  }
  
  public static boolean isWifi()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 == null) {
            break;
          }
          if (!((NetworkInfo)localObject1).isConnected()) {
            return false;
          }
          int i = ((NetworkInfo)localObject1).getType();
          if (1 == i)
          {
            bool = true;
            return bool;
          }
          boolean bool = false;
          continue;
        }
        Object localObject2 = null;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
    }
    return false;
  }
  
  public static void registNetStatusListener(NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    if (localWeakReference != null) {
      synchronized (LOCK_NETLSTENER)
      {
        mNetworkListener.add(localWeakReference);
        return;
      }
    }
  }
  
  public static void unregistNetStatusListener(NetStatusListener paramNetStatusListener)
  {
    synchronized (LOCK_NETLSTENER)
    {
      Iterator localIterator = new ArrayList(mNetworkListener).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((NetStatusListener)localWeakReference.get() == paramNetStatusListener) {
          mNetworkListener.remove(localWeakReference);
        }
      }
      return;
    }
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
  
  public static abstract interface NetStatusListener
  {
    public abstract void onNetworkChanged(String paramString1, String paramString2);
  }
  
  public static class NetworkChangeReceiver
    extends BroadcastReceiver
  {
    private String mApn = "none";
    private Context mContext;
    
    public NetworkChangeReceiver(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public String getApn()
    {
      return this.mApn;
    }
    
    public String getApnValue()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = (ConnectivityManager)this.mContext.getSystemService("connectivity");
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
    
    public Context getContext()
    {
      return this.mContext;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
        GlobalHandlerThread.getInstance(paramContext).getHandler().post(new NetworkManager.NetworkChangeReceiver.1(this));
      }
    }
    
    public void setApn(String paramString)
    {
      this.mApn = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager
 * JD-Core Version:    0.7.0.1
 */