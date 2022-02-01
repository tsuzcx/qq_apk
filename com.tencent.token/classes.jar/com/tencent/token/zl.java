package com.tencent.token;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.Iterator;
import java.util.List;

public final class zl
{
  public static double a(Context paramContext, int paramInt)
  {
    try
    {
      double d1 = zk.b;
      double d2 = zk.b;
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      paramContext = localLocationManager.getProviders(true);
      if (paramContext.contains("gps"))
      {
        paramContext = "gps";
      }
      else
      {
        if (!paramContext.contains("network")) {
          break label105;
        }
        paramContext = "network";
      }
      paramContext = localLocationManager.getLastKnownLocation(paramContext);
      if (paramContext != null)
      {
        d1 = paramContext.getLatitude();
        d2 = paramContext.getLongitude();
      }
      if (paramInt == zk.c) {
        return d1;
      }
      int i = zk.d;
      if (paramInt == i)
      {
        return d2;
        label105:
        return 0.0D;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.b;
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation();
      if (paramContext != null)
      {
        int i = paramContext.getCid();
        return i;
      }
      return -1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.b;
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      paramContext = (GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation();
      if (paramContext != null)
      {
        int i = paramContext.getLac();
        return i;
      }
      return -1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.b;
  }
  
  public static int c(Context paramContext)
  {
    int m = 0;
    int n = 0;
    int k = 0;
    int i = m;
    int j;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNeighboringCellInfo();
      j = n;
      if (paramContext != null)
      {
        i = m;
        j = n;
        if (paramContext.size() > 0)
        {
          i = m;
          Iterator localIterator = paramContext.iterator();
          j = k;
          for (;;)
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            i = j;
            j += ((NeighboringCellInfo)localIterator.next()).getRssi() * 2 - 133;
          }
          i = j;
          j /= paramContext.size();
          return j;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      j = i;
    }
    return j;
  }
  
  public static int d(Context paramContext)
  {
    int i;
    try
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      if (paramContext == null) {
        return 0;
      }
      boolean bool1 = paramContext.isProviderEnabled("gps");
      boolean bool2 = paramContext.isProviderEnabled("network");
      if ((!bool1) && (!bool2)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    if (i != 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zl
 * JD-Core Version:    0.7.0.1
 */