package com.huawei.hianalytics.ab.bc.bc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hianalytics.ab.bc.ef.ab;

public class cd
{
  private static String ab(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      String str;
      if ((!paramString.equalsIgnoreCase("TD-SCDMA")) && (!paramString.equalsIgnoreCase("WCDMA")))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase("CDMA2000")) {}
      }
      else
      {
        str = "3G";
      }
      return str;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return "2G";
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return "3G";
    }
    return "4G";
  }
  
  public static String ab(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0))
    {
      ab.cd("hmsSdk", "not have network state phone permission!");
      return "";
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        if (paramContext.getType() == 1) {
          return "WIFI";
        }
        if (paramContext.getType() == 0)
        {
          String str = paramContext.getSubtypeName();
          ab.bc("hmsSdk", "Network getSubtypeName : " + str);
          return ab(paramContext.getSubtype(), str);
        }
        if (paramContext.getType() == 16)
        {
          ab.cd("hmsSdk", "type name = " + "COMPANION_PROXY");
          return "COMPANION_PROXY";
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.bc.cd
 * JD-Core Version:    0.7.0.1
 */