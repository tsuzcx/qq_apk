package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class arj
  extends aot
  implements ark
{
  public final NetworkInfo a()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)aos.a().getSystemService("connectivity")).getActiveNetworkInfo();
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
 * Qualified Name:     com.tencent.token.arj
 * JD-Core Version:    0.7.0.1
 */