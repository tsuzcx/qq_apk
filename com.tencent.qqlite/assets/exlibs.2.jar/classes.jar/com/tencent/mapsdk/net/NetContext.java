package com.tencent.mapsdk.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.tencentmap.mapsdk.a.d;

public class NetContext
{
  private static NetContext b;
  private Context a;
  
  public static Context getContext()
  {
    return getInstance().a;
  }
  
  public static NetContext getInstance()
  {
    if (b == null) {
      b = new NetContext();
    }
    return b;
  }
  
  public static String getNetworkType()
  {
    try
    {
      Object localObject = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      int i = ((NetworkInfo)localObject).getType();
      if (i == 1) {
        return "wifi";
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo();
      boolean bool = d.a((String)localObject);
      if (bool) {
        return "unknown";
      }
      localObject = ((String)localObject).toLowerCase();
      return localObject;
    }
    catch (Exception localException) {}
    return "unknown";
  }
  
  public static boolean isInitialized()
  {
    return getContext() != null;
  }
  
  public static boolean isNetAvailable()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isAvailable();
        return bool;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isPorxyPrefer(boolean paramBoolean)
  {
    if (isWifi()) {}
    for (;;)
    {
      return false;
      if (b.c() == 1) {}
      for (int i = 1; ((i == 0) || (paramBoolean)) && (!d.a(Proxy.getDefaultHost())); i = 0) {
        return true;
      }
    }
  }
  
  public static boolean isWAPFeePage(String paramString)
  {
    return (paramString != null) && (paramString.contains("vnd.wap.wml"));
  }
  
  public static boolean isWifi()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void notifyNetworkChanged(Intent paramIntent)
  {
    if (!isInitialized()) {
      return;
    }
    b.a().b();
    a.a(paramIntent);
  }
  
  public void init(Context paramContext)
  {
    if (this.a == null) {
      this.a = paramContext.getApplicationContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mapsdk.net.NetContext
 * JD-Core Version:    0.7.0.1
 */