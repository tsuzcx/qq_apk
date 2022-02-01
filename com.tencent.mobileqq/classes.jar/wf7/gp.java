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
    catch (Exception paramContext)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  public static NetworkInfo ar()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)gv.dE().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public static boolean w(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getAllNetworkInfo();
        if (paramContext != null)
        {
          int i = 0;
          while (i < paramContext.length)
          {
            NetworkInfo.State localState1 = paramContext[i].getState();
            NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
            if (localState1 == localState2) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static int x(Context paramContext)
  {
    try
    {
      localObject = ar();
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
      localObject = y(paramContext);
      if ((localObject != null) && (((String)localObject).length() > 0) && (z(paramContext) > 0)) {
        return 3;
      }
    }
    return 4;
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
    if (dk.bJ() >= 14) {}
    try
    {
      int i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      label19:
      break label19;
    }
    return -1;
    return Proxy.getPort(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.gp
 * JD-Core Version:    0.7.0.1
 */