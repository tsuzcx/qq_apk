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
      boolean bool;
      break label24;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (bool = true;; bool = false) {
      return bool;
    }
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
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static int getNetworkType()
  {
    int j = 4;
    Object localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = getActiveNetworkInfo();
      localObject = localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      label10:
      int i;
      break label10;
    }
    if (localObject == null) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (((NetworkInfo)localObject).getType() == 1) {
              return 2;
            }
            i = j;
          } while (((NetworkInfo)localObject).getType() != 0);
          localObject = dH();
          i = j;
        } while (localObject == null);
        i = j;
      } while (((String)localObject).length() <= 0);
      i = j;
    } while (getProxyPort() <= 0);
    return 3;
  }
  
  public static int getProxyPort()
  {
    if (dG()) {
      try
      {
        int i = Integer.parseInt(System.getProperty("http.proxyPort"));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return -1;
      }
    }
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
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    case 5: 
      return 5;
    case 6: 
      return 6;
    case 7: 
      return 7;
    case 8: 
      return 8;
    case 9: 
      return 9;
    case 10: 
      return 10;
    case 11: 
      return 11;
    case 12: 
      return 12;
    case 13: 
      return 13;
    case 14: 
      return 14;
    case 15: 
      return 15;
    }
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fi
 * JD-Core Version:    0.7.0.1
 */