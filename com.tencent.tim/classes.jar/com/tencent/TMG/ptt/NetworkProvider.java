package com.tencent.TMG.ptt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkProvider
{
  private static String TAG = "NetworkProvider";
  
  public static int getNetTypeName(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      if (paramContext.getType() == 0)
      {
        switch (paramContext.getSubtype())
        {
        default: 
          paramContext = paramContext.getSubtypeName();
          Log.d(TAG, "network type = " + paramContext);
          if ((paramContext.equalsIgnoreCase("TD-SCDMA")) || (paramContext.equalsIgnoreCase("WCDMA")) || (paramContext.equalsIgnoreCase("CDMA2000"))) {
            return 3;
          }
          break;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          return 2;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        case 13: 
          return 4;
        }
        Log.d(TAG, "unknown network type = " + paramContext);
        return 0;
      }
    }
    return 0;
  }
  
  public static abstract interface NETWORK_TYPE
  {
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_WIRED = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.NetworkProvider
 * JD-Core Version:    0.7.0.1
 */