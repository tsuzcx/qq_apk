package com.tencent.tmassistantbase.util;

import alkz;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tmassistantbase.common.a;
import com.tencent.tmassistantbase.common.e;

public class o
{
  private static boolean a = true;
  private static e b = new e();
  private static boolean c = false;
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramString.equals("46000")) || (paramString.equals("46002")) || (paramString.equals("46007"))) {
        return 0;
      }
      if (paramString.equals("46001")) {
        return 1;
      }
      if (paramString.equals("46003")) {
        return 2;
      }
    }
    return -1;
  }
  
  public static boolean a()
  {
    return !TextUtils.isEmpty(Proxy.getDefaultHost());
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static e b()
  {
    if (b.a == a.a) {
      c();
    }
    return b;
  }
  
  private static e b(Context paramContext)
  {
    e locale = new e();
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
        Object localObject3;
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 != null) {
            localObject3 = localObject1;
          }
        }
        Throwable localThrowable3;
        Object localObject2 = null;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (((NetworkInfo)localObject1).isAvailable()) {
            continue;
          }
          a = false;
          locale.a = a.m;
          return locale;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable3 = localThrowable1;
          continue;
        }
        localThrowable1 = localThrowable1;
        localObject3 = null;
        a = true;
        if ((localObject3 != null) && (localObject3.getType() == 1))
        {
          locale.a = a.b;
          paramContext = (WifiManager)GlobalUtil.getInstance().getContext().getSystemService("wifi");
          if (paramContext != null) {}
          try
          {
            paramContext = alkz.a(paramContext);
            if (paramContext != null)
            {
              locale.e = paramContext.getBSSID();
              locale.f = paramContext.getSSID();
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            continue;
          }
          return locale;
        }
        return c(paramContext);
      }
    }
  }
  
  private static e c(Context paramContext)
  {
    e locale = new e();
    boolean bool = a();
    locale.d = bool;
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    String str = paramContext.getNetworkOperator();
    locale.b = str;
    int i = paramContext.getNetworkType();
    locale.c = i;
    switch (a(str))
    {
    default: 
      if (!bool) {
        break;
      }
    }
    for (locale.a = a.l;; locale.a = a.k)
    {
      return locale;
      switch (i)
      {
      default: 
        if (!bool) {
          break;
        }
      }
      for (locale.a = a.l;; locale.a = a.k)
      {
        return locale;
        if (bool) {}
        for (locale.a = a.n;; locale.a = a.o) {
          return locale;
        }
        if (bool) {}
        for (locale.a = a.c;; locale.a = a.d) {
          return locale;
        }
        if (bool) {}
        for (locale.a = a.c;; locale.a = a.d) {
          return locale;
        }
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 9: 
      case 11: 
      case 12: 
      case 14: 
      default: 
        if (!bool) {
          break;
        }
      }
      for (locale.a = a.l;; locale.a = a.k)
      {
        return locale;
        if (bool) {}
        for (locale.a = a.n;; locale.a = a.o) {
          return locale;
        }
        if (bool) {}
        for (locale.a = a.g;; locale.a = a.h) {
          return locale;
        }
        if (bool) {}
        for (locale.a = a.e;; locale.a = a.f) {
          return locale;
        }
      }
      switch (i)
      {
      default: 
        if (!bool) {
          break;
        }
      }
      for (locale.a = a.i;; locale.a = a.j)
      {
        return locale;
        if (bool) {}
        for (locale.a = a.n;; locale.a = a.o) {
          return locale;
        }
      }
    }
  }
  
  public static void c()
  {
    if (GlobalUtil.getInstance().getContext() != null) {
      b = b(GlobalUtil.getInstance().getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.o
 * JD-Core Version:    0.7.0.1
 */