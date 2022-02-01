package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetWorkUtil
{
  private static int a(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      if (paramNetworkInfo.getType() == 1) {
        return 1;
      }
      if (paramNetworkInfo.getType() == 0)
      {
        switch (paramNetworkInfo.getSubtype())
        {
        default: 
          return 6;
        case 1: 
        case 2: 
        case 4: 
          return 2;
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 15: 
          return 3;
        }
        return 4;
      }
    }
    return 0;
  }
  
  private static NetworkInfo a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getActiveNetworkInfo();
    }
    return null;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    return a(a(paramContext));
  }
  
  public static final class NetType
  {
    public static final int NET = -2;
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_5G = 5;
    public static final int TYPE_NEED_INIT = -1;
    public static final int TYPE_OTHER = 6;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
    public static final int WAP = -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.NetWorkUtil
 * JD-Core Version:    0.7.0.1
 */