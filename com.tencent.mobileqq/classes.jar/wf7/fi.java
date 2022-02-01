package wf7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class fi
{
  public static boolean I(String paramString)
  {
    if (2 != getNetworkType()) {
      return false;
    }
    paramString = null;
    try
    {
      String str = fj.a(new fi.1());
      paramString = str;
    }
    catch (ex localex)
    {
      label24:
      break label24;
    }
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  public static boolean dG()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static String dH()
  {
    if (dG()) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(ea.cr());
  }
  
  public static boolean dI()
  {
    NetworkInfo localNetworkInfo = getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  public static NetworkInfo getActiveNetworkInfo()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)ea.cr().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public static int getNetworkType()
  {
    try
    {
      localObject = getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject;
      label7:
      break label7;
    }
    localObject = null;
    if (localObject == null) {
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 2;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      localObject = dH();
      if ((localObject != null) && (((String)localObject).length() > 0) && (getProxyPort() > 0)) {
        return 3;
      }
    }
    return 4;
  }
  
  public static int getProxyPort()
  {
    if (dG()) {}
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
    return Proxy.getPort(ea.cr());
  }
  
  public static int o(Context paramContext)
  {
    if (!fh.pT)
    {
      fh.pT = false;
      fh.m(paramContext);
    }
    switch (fh.pX)
    {
    case 17: 
    default: 
      return 0;
    case 16: 
      return 16;
    case 15: 
      return 15;
    case 14: 
      return 14;
    case 13: 
      return 13;
    case 12: 
      return 12;
    case 11: 
      return 11;
    case 10: 
      return 10;
    case 9: 
      return 9;
    case 8: 
      return 8;
    case 7: 
      return 7;
    case 6: 
      return 6;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fi
 * JD-Core Version:    0.7.0.1
 */