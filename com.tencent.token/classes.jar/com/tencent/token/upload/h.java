package com.tencent.token.upload;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.Iterator;
import java.util.List;

public class h
{
  public static double a(Context paramContext, int paramInt)
  {
    label115:
    for (;;)
    {
      try
      {
        double d1 = g.b;
        double d2 = g.b;
        LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
        paramContext = localLocationManager.getProviders(true);
        if (paramContext.contains("gps"))
        {
          paramContext = "gps";
          paramContext = localLocationManager.getLastKnownLocation(paramContext);
          if (paramContext == null) {
            break label115;
          }
          d1 = paramContext.getLatitude();
          d2 = paramContext.getLongitude();
          if (paramInt == g.c) {
            return d1;
          }
        }
        else
        {
          if (!paramContext.contains("network")) {
            break;
          }
          paramContext = "network";
          continue;
        }
        int i = g.d;
        if (paramInt == i) {
          return d2;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return g.b;
    }
    return 0.0D;
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
    return g.b;
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
    return g.b;
  }
  
  public static int c(Context paramContext)
  {
    int k = 0;
    int i = 0;
    int j = k;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNeighboringCellInfo();
      if (paramContext != null)
      {
        j = k;
        if (paramContext.size() > 0)
        {
          j = k;
          Iterator localIterator = paramContext.iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            j = i;
            i += ((NeighboringCellInfo)localIterator.next()).getRssi() * 2 - 133;
          }
          j = i;
          i /= paramContext.size();
          return i;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return j;
    }
    return 0;
  }
  
  public static int d(Context paramContext)
  {
    int j = 1;
    try
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      if (paramContext == null) {
        return 0;
      }
      boolean bool1 = paramContext.isProviderEnabled("gps");
      boolean bool2 = paramContext.isProviderEnabled("network");
      if ((!bool1) && (!bool2)) {
        break label57;
      }
      i = 1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
        continue;
        i = 0;
      }
    }
    if (i != 0)
    {
      i = j;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.h
 * JD-Core Version:    0.7.0.1
 */