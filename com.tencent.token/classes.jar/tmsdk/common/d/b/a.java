package tmsdk.common.d.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a
  extends tmsdk.common.a.a
  implements b
{
  public NetworkInfo a()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)tmsdk.common.a.a().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.b.a
 * JD-Core Version:    0.7.0.1
 */