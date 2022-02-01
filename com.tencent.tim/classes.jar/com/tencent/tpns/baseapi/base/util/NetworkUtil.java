package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil
{
  public static final String TAG = "NetworkUtil";
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          return bool;
        }
      }
      catch (Throwable paramContext)
      {
        Logger.i("NetworkUtil", paramContext.getMessage());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */