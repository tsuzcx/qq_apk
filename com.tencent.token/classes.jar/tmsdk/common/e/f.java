package tmsdk.common.e;

import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;

public class f
{
  public static b.a a()
  {
    String str;
    try
    {
      NetworkInfo localNetworkInfo = tmsdk.common.b.a().a();
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getActiveNetworkInfo NullPointerException--- \n");
      localStringBuilder.append(localNullPointerException.getMessage());
      localStringBuilder.toString();
      str = null;
    }
    if (str == null) {
      return b.a.a;
    }
    if (str.getType() == 1) {
      return b.a.c;
    }
    if (str.getType() == 0)
    {
      str = c();
      if ((str != null) && (str.length() > 0) && (d() > 0)) {
        return b.a.d;
      }
      return b.a.e;
    }
    return b.a.e;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static String c()
  {
    if (b()) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(tmsdk.common.a.a());
  }
  
  public static int d()
  {
    if (b()) {}
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
    return Proxy.getPort(tmsdk.common.a.a());
  }
  
  public static boolean e()
  {
    NetworkInfo localNetworkInfo = f();
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  public static NetworkInfo f()
  {
    try
    {
      NetworkInfo localNetworkInfo = tmsdk.common.b.a().a();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getActiveNetworkInfo NullPointerException--- \n");
      localStringBuilder.append(localNullPointerException.getMessage());
      localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.f
 * JD-Core Version:    0.7.0.1
 */