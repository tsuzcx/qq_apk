package com.tencent.component.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkManager
{
  public static final int Operator_CMCC = 1;
  public static final int Operator_CMCT = 3;
  public static final int Operator_Unicom = 2;
  public static final int Operator_Unknown = 0;
  public static final int Operator_WIFI = 4;
  private static Context a;
  private static NetworkChangeReceiver b;
  private static Object c = new Object();
  private static List<WeakReference<NetStatusListener>> d = Collections.synchronizedList(new ArrayList());
  
  public static String getApnValue()
  {
    Object localObject = "none";
    if (b == null) {}
    String str;
    do
    {
      return localObject;
      str = b.getApn();
      localObject = str;
    } while (str != "none");
    return b.getApnValue();
  }
  
  public static String getBSSID()
  {
    try
    {
      Object localObject = ((WifiManager)a.getSystemService("wifi")).getConnectionInfo();
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
    return com.tencent.component.network.module.base.a.j();
  }
  
  public static int getIspType()
  {
    return getISPType(getApnValue());
  }
  
  public static void init(Context paramContext)
  {
    if (a != null) {
      return;
    }
    a = paramContext;
    b = new NetworkChangeReceiver(paramContext);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(b, localIntentFilter);
  }
  
  public static boolean isMobile()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)a.getSystemService("connectivity");
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
        Object localObject1 = (ConnectivityManager)a.getSystemService("connectivity");
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
        Object localObject1 = (ConnectivityManager)a.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
            break;
          }
          int i = ((NetworkInfo)localObject1).getType();
          return 1 == i;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      Object localObject2 = null;
    }
    return false;
  }
  
  public static void registNetStatusListener(NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    synchronized (c)
    {
      d.add(localWeakReference);
      return;
    }
  }
  
  public static void unregistNetStatusListener(NetStatusListener paramNetStatusListener)
  {
    synchronized (c)
    {
      Iterator localIterator = new ArrayList(d).iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          return;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((NetStatusListener)localWeakReference.get() != paramNetStatusListener);
      d.remove(localWeakReference);
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
    private Context a;
    private String b = "none";
    private int c = 0;
    
    public NetworkChangeReceiver(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public String getApn()
    {
      return this.b;
    }
    
    public String getApnValue()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = (ConnectivityManager)this.a.getSystemService("connectivity");
          if (localObject1 != null)
          {
            localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
            if (localObject1 != null)
            {
              boolean bool = ((NetworkInfo)localObject1).isConnected();
              if (bool) {}
            }
            else
            {
              return "none";
            }
            int i = ((NetworkInfo)localObject1).getType();
            if (1 == i) {
              return "wifi";
            }
            if (((NetworkInfo)localObject1).getExtraInfo() != null)
            {
              localObject1 = ((NetworkInfo)localObject1).getExtraInfo().toLowerCase();
              return localObject1;
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
    }
    
    public Context getContext()
    {
      return this.a;
    }
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      int i;
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
      {
        paramIntent = getApnValue();
        i = NetworkManager.getISPType(paramIntent);
        Const.c("downloader", "old apn:" + this.b + "  new apn:" + paramIntent + " old isp:" + this.c + " new isp:" + i);
        if (paramIntent.equals(this.b)) {}
      }
      synchronized (NetworkManager.a())
      {
        Iterator localIterator = NetworkManager.b().iterator();
        NetworkManager.NetStatusListener localNetStatusListener;
        do
        {
          if (!localIterator.hasNext())
          {
            this.b = paramIntent;
            this.c = i;
            if ((NetworkManager.isNetworkAvailable()) && (!paramIntent.equals(this.b))) {
              com.tencent.component.network.module.common.a.a().b();
            }
            return;
          }
          localNetStatusListener = (NetworkManager.NetStatusListener)((WeakReference)localIterator.next()).get();
        } while (localNetStatusListener == null);
        localNetStatusListener.onNetworkChanged(this.b, paramIntent);
      }
    }
    
    public void setApn(String paramString)
    {
      this.b = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager
 * JD-Core Version:    0.7.0.1
 */