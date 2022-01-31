package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public final class s
{
  public static Uri a = Uri.parse("content://telephony/carriers/preferapn");
  
  public static String a(Context paramContext)
  {
    int i = 1;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext == null) || (!paramContext.isAvailable())) {
      i = 0;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        int j = paramContext.getType();
        if (j == 1)
        {
          i = 5;
        }
        else
        {
          if (j == 0)
          {
            paramContext = paramContext.getExtraInfo();
            if ((paramContext == null) || (paramContext.equals("")))
            {
              i = 6;
              continue;
            }
            if (paramContext.equalsIgnoreCase("cmwap")) {
              continue;
            }
            if (paramContext.equalsIgnoreCase("3gwap"))
            {
              i = 3;
              continue;
            }
            if (paramContext.equalsIgnoreCase("uniwap"))
            {
              i = 2;
              continue;
            }
            if (paramContext.equalsIgnoreCase("ctwap"))
            {
              i = 4;
              continue;
            }
          }
          i = 6;
        }
        break;
      }
    }
    return "wifi";
    return "3gwap";
    return "uniwap";
    return "cmwap";
    return "ctwap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.s
 * JD-Core Version:    0.7.0.1
 */