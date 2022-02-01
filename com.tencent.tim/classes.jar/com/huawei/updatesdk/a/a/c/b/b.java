package com.huawei.updatesdk.a.a.c.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;

public class b
{
  private static String a = "NetworkUtil";
  private static int b = -1;
  private static int c = -1;
  private static java.net.Proxy d = null;
  
  private static int a(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    int i = j;
    int k;
    if (paramNetworkInfo != null)
    {
      i = j;
      if (paramNetworkInfo.isConnected())
      {
        k = paramNetworkInfo.getType();
        if ((1 != k) && (13 != k)) {
          break label37;
        }
        i = 1;
      }
    }
    label37:
    do
    {
      return i;
      i = j;
    } while (k != 0);
    switch (paramNetworkInfo.getSubtype())
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 4;
  }
  
  public static java.net.Proxy a()
  {
    return d;
  }
  
  private static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private static void a(java.net.Proxy paramProxy)
  {
    d = paramProxy;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo, Context paramContext)
  {
    int i = paramNetworkInfo.getType();
    boolean bool = a.b(paramContext);
    if ((i == 0) && (bool))
    {
      String str = android.net.Proxy.getHost(paramContext);
      i = android.net.Proxy.getPort(paramContext);
      paramContext = null;
      paramNetworkInfo = paramContext;
      if (str != null)
      {
        paramNetworkInfo = paramContext;
        if (str.length() > 0)
        {
          paramNetworkInfo = paramContext;
          if (i != -1) {
            paramNetworkInfo = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
          }
        }
      }
      a(paramNetworkInfo);
      return true;
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (-1 == c) {
      c(paramContext);
    }
    return c == -3;
  }
  
  public static int c(Context paramContext)
  {
    if (-1 == b)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a(a, "getPsType() need init");
      if (paramContext != null) {
        e(paramContext);
      }
    }
    return b;
  }
  
  public static java.net.Proxy d(Context paramContext)
  {
    if (b(paramContext)) {
      return a();
    }
    return null;
  }
  
  private static void e(Context paramContext)
  {
    a(0);
    NetworkInfo localNetworkInfo = f(paramContext);
    if (localNetworkInfo == null) {
      com.huawei.updatesdk.a.a.b.a.a.a.a(a, "setPsType() info = null");
    }
    do
    {
      return;
      b = a(localNetworkInfo);
    } while (1 == b);
    if (a(localNetworkInfo, paramContext))
    {
      a(-3);
      return;
    }
    a(-2);
  }
  
  private static NetworkInfo f(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return null;
    }
    return paramContext.getActiveNetworkInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b.b
 * JD-Core Version:    0.7.0.1
 */