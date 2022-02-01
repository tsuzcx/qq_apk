package wf7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class bu
{
  public static ConnectivityManager a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean ap()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = a(bz.av().t());
      boolean bool1 = bool2;
      int i;
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
        bool1 = bool2;
        if (localObject != null) {
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localObject.length)
        {
          NetworkInfo.State localState1 = localObject[i].getState();
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
    catch (Throwable localThrowable) {}
  }
  
  public static boolean aq()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bz.av().t().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1)) {
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    return false;
  }
  
  public static NetworkInfo ar()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bz.av().t().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.bu
 * JD-Core Version:    0.7.0.1
 */