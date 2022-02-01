package com.tencent.token;

import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;

public final class auk
{
  public static ke a()
  {
    String str;
    try
    {
      NetworkInfo localNetworkInfo = arq.a().a();
    }
    catch (NullPointerException localNullPointerException)
    {
      new StringBuilder(" getActiveNetworkInfo NullPointerException--- \n").append(localNullPointerException.getMessage());
      str = null;
    }
    if (str == null) {
      return ke.a;
    }
    if (str.getType() == 1) {
      return ke.c;
    }
    if (str.getType() == 0)
    {
      str = b();
      if ((str != null) && (str.length() > 0) && (c() > 0)) {
        return ke.d;
      }
      return ke.e;
    }
    return ke.e;
  }
  
  public static String b()
  {
    if (e()) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(arn.a());
  }
  
  public static int c()
  {
    if (e()) {}
    try
    {
      int i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label17:
      break label17;
    }
    return -1;
    return Proxy.getPort(arn.a());
  }
  
  public static boolean d()
  {
    NetworkInfo localNetworkInfo = f();
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  private static boolean e()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  private static NetworkInfo f()
  {
    try
    {
      NetworkInfo localNetworkInfo = arq.a().a();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      new StringBuilder(" getActiveNetworkInfo NullPointerException--- \n").append(localNullPointerException.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.auk
 * JD-Core Version:    0.7.0.1
 */