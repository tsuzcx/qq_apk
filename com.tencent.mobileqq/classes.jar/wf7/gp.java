package wf7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;

public class gp
{
  public static ConnectivityManager a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static NetworkInfo ar()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)gv.dE().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean w(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = a(paramContext);
      boolean bool1 = bool2;
      int i;
      if (paramContext != null)
      {
        paramContext = paramContext.getAllNetworkInfo();
        bool1 = bool2;
        if (paramContext != null) {
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < paramContext.length)
        {
          NetworkInfo.State localState1 = paramContext[i].getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramContext) {}
  }
  
  public static int x(Context paramContext)
  {
    int j = 4;
    Object localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = ar();
      localObject = localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      label12:
      int i;
      break label12;
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
          localObject = y(paramContext);
          i = j;
        } while (localObject == null);
        i = j;
      } while (((String)localObject).length() <= 0);
      i = j;
    } while (z(paramContext) <= 0);
    return 3;
  }
  
  public static String y(Context paramContext)
  {
    if (dk.bJ() >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(paramContext);
  }
  
  public static int z(Context paramContext)
  {
    if (dk.bJ() >= 14) {
      try
      {
        int i = Integer.parseInt(System.getProperty("http.proxyPort"));
        return i;
      }
      catch (NumberFormatException paramContext)
      {
        return -1;
      }
    }
    return Proxy.getPort(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gp
 * JD-Core Version:    0.7.0.1
 */