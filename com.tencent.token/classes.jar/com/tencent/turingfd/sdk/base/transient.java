package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.net.HttpURLConnection;

public class transient
{
  public HttpURLConnection a = null;
  public boolean b = false;
  
  public static String a(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(paramContext);
  }
  
  public static int b(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      label30:
      break label30;
    }
    return -1;
    return Proxy.getPort(paramContext);
  }
  
  public static enum do
  {
    static
    {
      do localdo = Hj;
      localdo = Ij;
      localdo = Jj;
      localdo = Kj;
    }
    
    public do() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.transient
 * JD-Core Version:    0.7.0.1
 */