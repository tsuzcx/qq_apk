package c.t.m.g;

import alky;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bz
{
  public static boolean a = false;
  
  public static int a(CellLocation paramCellLocation)
  {
    if ((paramCellLocation instanceof CdmaCellLocation)) {
      return ((CdmaCellLocation)paramCellLocation).getBaseStationId();
    }
    try
    {
      int i = ((GsmCellLocation)paramCellLocation).getCid();
      return i;
    }
    catch (Exception paramCellLocation) {}
    return -1;
  }
  
  public static CellLocation a(ap paramap)
  {
    boolean bool2 = false;
    TelephonyManager localTelephonyManager = paramap.f;
    if (localTelephonyManager != null) {}
    for (;;)
    {
      boolean bool3;
      try
      {
        CellLocation localCellLocation = alky.a(localTelephonyManager);
        int i;
        if (localTelephonyManager.getSimState() == 5)
        {
          i = 1;
          if (i != 0)
          {
            bool3 = a(paramap.a);
            i = a(localCellLocation);
            if ((localCellLocation != null) && (!b(localCellLocation)))
            {
              bool1 = bool2;
              if (i >= 0) {
                a = bool1;
              }
            }
          }
          else
          {
            return localCellLocation;
          }
        }
        else
        {
          i = 0;
          continue;
          return CellLocation.getEmpty();
        }
      }
      catch (Exception paramap)
      {
        a = true;
      }
      boolean bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt != bj.a.c.ordinal();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = true;
    boolean bool1;
    if (b(paramInt1)) {
      if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 > 0) && (paramInt4 < 65535) && (paramInt5 > 0) && (paramInt5 < 65535))
      {
        bool1 = bool2;
        if (paramInt3 == 0)
        {
          bool1 = bool2;
          if (paramInt4 == 0)
          {
            bool1 = bool2;
            if (paramInt5 != 0) {}
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
    do
    {
      return bool1;
      if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 <= 0) || (paramInt4 >= 65535) || (paramInt5 == 268435455) || (paramInt5 == 2147483647) || (paramInt5 == 50594049) || (paramInt5 == 65535)) {
        break;
      }
      bool1 = bool2;
    } while (paramInt5 > 0);
    return false;
  }
  
  public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    if ((paramSignalStrength1 == null) || (paramSignalStrength2 == null)) {}
    int i;
    do
    {
      do
      {
        return true;
        i = Math.abs(b(paramInt, paramSignalStrength1, paramSignalStrength2));
        if (!a(paramInt)) {
          break;
        }
      } while (i > 3);
      return false;
      if (!b(paramInt)) {
        break;
      }
    } while (i > 6);
    return false;
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        if (Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on") != 1) {
          break label47;
        }
        return true;
      }
      int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
      if (i != 1) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      bool = false;
    }
    return bool;
    label47:
    return false;
  }
  
  public static boolean a(CellLocation paramCellLocation1, CellLocation paramCellLocation2)
  {
    int i;
    if ((paramCellLocation1 == null) || (paramCellLocation2 == null))
    {
      i = 1;
      if (i == 0) {
        break label21;
      }
    }
    label21:
    label62:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            i = 0;
            break;
          } while (paramCellLocation1.getClass() != paramCellLocation2.getClass());
          if (!(paramCellLocation1 instanceof GsmCellLocation)) {
            break label62;
          }
          paramCellLocation1 = (GsmCellLocation)paramCellLocation1;
          paramCellLocation2 = (GsmCellLocation)paramCellLocation2;
        } while (paramCellLocation1.getCid() != paramCellLocation2.getCid());
        return true;
      } while (!(paramCellLocation1 instanceof CdmaCellLocation));
      paramCellLocation1 = (CdmaCellLocation)paramCellLocation1;
      paramCellLocation2 = (CdmaCellLocation)paramCellLocation2;
    } while (paramCellLocation1.getBaseStationId() != paramCellLocation2.getBaseStationId());
    return true;
  }
  
  public static boolean a(bj parambj)
  {
    if (parambj == null) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    return a(parambj.a.ordinal(), parambj.b, parambj.c, parambj.d, parambj.e);
  }
  
  private static int b(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    try
    {
      if (a(paramInt)) {
        return paramSignalStrength1.getGsmSignalStrength() - paramSignalStrength2.getGsmSignalStrength();
      }
      if (b(paramInt))
      {
        paramInt = paramSignalStrength1.getCdmaDbm();
        int i = paramSignalStrength2.getCdmaDbm();
        return paramInt - i;
      }
    }
    catch (Throwable paramSignalStrength1) {}
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public static List<CellInfo> b(ap paramap)
  {
    try
    {
      paramap = alky.a(paramap.f);
      if (paramap != null) {
        return paramap;
      }
    }
    catch (Throwable paramap) {}
    return new ArrayList();
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == bj.a.c.ordinal();
  }
  
  private static boolean b(CellLocation paramCellLocation)
  {
    try
    {
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      if (paramCellLocation.getCid() == 0)
      {
        int i = paramCellLocation.getLac();
        if (i == 0) {
          return true;
        }
      }
    }
    catch (ClassCastException paramCellLocation) {}
    return false;
  }
  
  public static List<NeighboringCellInfo> c(ap paramap)
  {
    paramap = paramap.f;
    if (paramap != null) {
      try
      {
        paramap = paramap.getNeighboringCellInfo();
        return paramap;
      }
      catch (Exception paramap) {}
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bz
 * JD-Core Version:    0.7.0.1
 */