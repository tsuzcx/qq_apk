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
    try
    {
      Object localObject = a(bz.av().t());
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
        if (localObject != null)
        {
          int i = 0;
          while (i < localObject.length)
          {
            NetworkInfo.State localState1 = localObject[i].getState();
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
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean aq()
  {
    try
    {
      localNetworkInfo = ((ConnectivityManager)bz.av().t().getSystemService("connectivity")).getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      NetworkInfo localNetworkInfo;
      label21:
      break label21;
    }
    localNetworkInfo = null;
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }
  
  public static NetworkInfo ar()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bz.av().t().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      label20:
      break label20;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bu
 * JD-Core Version:    0.7.0.1
 */