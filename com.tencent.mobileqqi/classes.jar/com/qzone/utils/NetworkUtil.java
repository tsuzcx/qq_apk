package com.qzone.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.HashMap;

public class NetworkUtil
{
  public static final String APN_NAME_WIFI = "wifi";
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  private static final HashMap<String, NetworkProxy> sAPNProxies = new HashMap();
  
  static
  {
    sAPNProxies.put("cmwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("3gwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("uniwap", new NetworkProxy("10.0.0.172", 80));
    sAPNProxies.put("ctwap", new NetworkProxy("10.0.0.200", 80));
  }
  
  public static String getAPN(Context paramContext)
  {
    localObject1 = null;
    NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
    if (localNetworkInfo == null)
    {
      paramContext = (Context)localObject1;
      return paramContext;
    }
    Object localObject4 = null;
    localObject2 = null;
    localObject3 = null;
    localObject1 = null;
    if (localNetworkInfo.getType() == 1) {
      localObject1 = "wifi";
    }
    while (localNetworkInfo.getType() != 0)
    {
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        break;
      }
      return ((String)localObject1).toLowerCase();
    }
    Cursor localCursor;
    if (PlatformUtil.version() < 17)
    {
      localObject2 = null;
      localCursor = null;
      localObject1 = localObject3;
      localObject3 = localCursor;
    }
    for (;;)
    {
      try
      {
        localCursor = paramContext.getContentResolver().query(PREFERRED_APN_URI, null, null, null, null);
        paramContext = localObject4;
        if (localCursor != null)
        {
          localObject1 = paramContext;
          localObject3 = localCursor;
          localObject2 = localCursor;
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
        localObject2 = paramContext;
        if (localCursor != null)
        {
          localCursor.close();
          localObject2 = paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        localObject2 = localObject1;
        if (localObject3 == null) {
          continue;
        }
        localObject3.close();
        localObject2 = localObject1;
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localNetworkInfo.getExtraInfo();
      break;
      localObject1 = paramContext;
      localObject3 = localCursor;
      localObject2 = localCursor;
      paramContext = localCursor.getString(localCursor.getColumnIndex("apn"));
    }
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static DNS getDNS(Context paramContext)
  {
    DNS localDNS = new DNS();
    if ((paramContext != null) && (isWifiConnected(paramContext)))
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
      if (paramContext != null)
      {
        localDNS.primary = int32ToIPStr(paramContext.dns1);
        localDNS.secondary = int32ToIPStr(paramContext.dns2);
      }
    }
    if ((localDNS.primary == null) && (localDNS.secondary == null))
    {
      localDNS.primary = PropertyUtil.get("net.dns1", null);
      localDNS.secondary = PropertyUtil.get("net.dns2", null);
    }
    return localDNS;
  }
  
  public static NetworkProxy getProxy(Context paramContext)
  {
    if (!isViaMobile(paramContext)) {}
    String str;
    int i;
    do
    {
      return null;
      str = getProxyHost(paramContext);
      i = getProxyPort(paramContext);
    } while ((isEmpty(str)) || (i < 0));
    return new NetworkProxy(str, i);
  }
  
  public static NetworkProxy getProxy(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return getProxy(paramContext);
    }
    return getProxyByAPN(paramContext);
  }
  
  public static NetworkProxy getProxyByAPN(Context paramContext)
  {
    if (!isViaMobile(paramContext)) {}
    do
    {
      return null;
      paramContext = getAPN(paramContext);
      paramContext = (NetworkProxy)sAPNProxies.get(paramContext);
    } while (paramContext == null);
    return paramContext.copy();
  }
  
  private static String getProxyHost(Context paramContext)
  {
    if (PlatformUtil.version() < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  private static int getProxyPort(Context paramContext)
  {
    int j = -1;
    int i;
    if (PlatformUtil.version() < 11) {
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      if (i >= 0)
      {
        j = i;
        if (i <= 65535) {}
      }
      else
      {
        j = -1;
      }
      return j;
      paramContext = System.getProperty("http.proxyPort");
      i = j;
      if (!isEmpty(paramContext)) {
        try
        {
          i = Integer.parseInt(paramContext);
        }
        catch (NumberFormatException paramContext)
        {
          i = j;
        }
      }
    }
  }
  
  private static String int32ToIPStr(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuffer.append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isViaMobile(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((paramContext == null) || (paramContext.getType() != 0));
    return true;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((paramContext == null) || (paramContext.getType() != 1));
    return true;
  }
  
  public static final class DNS
  {
    public String primary;
    public String secondary;
    
    public String toString()
    {
      return this.primary + "," + this.secondary;
    }
  }
  
  public static class NetworkProxy
    implements Cloneable
  {
    public final String host;
    public final int port;
    
    NetworkProxy(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
    
    final NetworkProxy copy()
    {
      try
      {
        NetworkProxy localNetworkProxy = (NetworkProxy)clone();
        return localNetworkProxy;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public String toString()
    {
      return this.host + ":" + this.port;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */