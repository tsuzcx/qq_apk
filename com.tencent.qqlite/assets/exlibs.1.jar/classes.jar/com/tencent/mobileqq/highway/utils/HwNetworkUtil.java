package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.qphone.base.util.QLog;

public class HwNetworkUtil
{
  public static final int CARRIER_OPERATOR_TYPE_CHINAMOBILE = 2;
  public static final int CARRIER_OPERATOR_TYPE_CHINATELECOM = 4;
  public static final int CARRIER_OPERATOR_TYPE_CHINAUNICOM = 3;
  public static final int CARRIER_OPERATOR_TYPE_UNKOWN = 1;
  public static final String TAG = "HwNetworkUtil";
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static int getCarrierOperatorType(Context paramContext)
  {
    int j = 1;
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    int i = j;
    if (paramContext != null)
    {
      if ((!paramContext.startsWith("46000")) && (!paramContext.startsWith("46002"))) {
        break label43;
      }
      i = 2;
    }
    label43:
    do
    {
      return i;
      if (paramContext.startsWith("46001")) {
        return 3;
      }
      i = j;
    } while (!paramContext.startsWith("46003"));
    return 4;
  }
  
  public static int getCellId(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {}
    do
    {
      for (;;)
      {
        return -1;
        try
        {
          CellLocation localCellLocation = paramContext.getCellLocation();
          if ((localCellLocation instanceof CdmaCellLocation))
          {
            paramContext = (CdmaCellLocation)paramContext.getCellLocation();
            if (paramContext != null) {
              return paramContext.getBaseStationId();
            }
          }
          else if ((localCellLocation instanceof GsmCellLocation))
          {
            paramContext = (GsmCellLocation)paramContext.getCellLocation();
            if (paramContext != null)
            {
              int i = paramContext.getCid();
              return i;
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HwNetworkUtil", 2, "getCellId() error " + paramContext, paramContext);
    return -1;
  }
  
  public static String getCurrentApn(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
      paramContext = localObject1;
      if (localObject2 != null)
      {
        paramContext = localObject1;
        if (((NetworkInfo)localObject2).getType() == 0) {
          paramContext = ((NetworkInfo)localObject2).getExtraInfo();
        }
      }
    }
    return paramContext;
  }
  
  public static String getCurrentWifiBSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext.getSSID() == null) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      str = paramContext.getBSSID().replaceAll(":", "");
      paramContext = str;
    } while (!str.equals("<unknown ssid>"));
    return null;
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext.getSSID() == null) {
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      str = paramContext.getSSID().replaceAll("\"", "");
      paramContext = str;
    } while (!str.equals("<unknown ssid>"));
    return null;
  }
  
  public static String getIMEI(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HwNetworkUtil", 2, "getIMEI() error " + paramContext, paramContext);
      }
    }
    return "";
  }
  
  public static String getIMSI(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "46000";
    }
    try
    {
      paramContext = paramContext.getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HwNetworkUtil", 2, "getIMSI() error " + paramContext, paramContext);
      }
    }
    return "46000";
  }
  
  public static String getNetworkName(Context paramContext)
  {
    switch (getSystemNetwork(paramContext))
    {
    default: 
      return "UNKOWN";
    case 1: 
      return "Wi-Fi";
    }
    return BdhUtils.getApnType(paramContext);
  }
  
  public static int getNetworkType(Context paramContext)
  {
    int j = -1;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i = j;
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      i = j;
      if (paramContext != null) {
        i = paramContext.getType();
      }
    }
    return i;
  }
  
  public static int getSystemNetwork(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {}
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      return 0;
    case 9: 
      return 5;
    case 1: 
    case 6: 
      return 1;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    case 4: 
    case 7: 
    case 11: 
    default: 
      return 2;
    case 13: 
      return 4;
    }
    return 3;
  }
  
  public static boolean is3Gor4G(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      if (QLog.isColorLevel()) {
        QLog.d("is3Gor4G", 2, "type:" + i);
      }
      if ((i == 8) || (i == 13) || (i == 3) || (i == 15) || (i == 10) || (i == 5) || (i == 14) || (i == 6) || (i == 9) || (i == 12)) {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isAirplaneModeOn(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isMobileNetWork(Context paramContext)
  {
    try
    {
      boolean bool = isMobileNetworkInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public static boolean isNetSupport(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getAllNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        int i = 0;
        while (i < paramContext.length)
        {
          NetworkInfo.State localState1 = paramContext[i].getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    boolean bool1;
    if (paramContext == null) {
      bool1 = false;
    }
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        bool2 = true;
        bool1 = bool2;
      } while (paramContext == null);
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        break;
      }
      bool1 = bool2;
    } while (paramContext.isConnected());
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isWifiEnabled(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName().toLowerCase().equals("wifi");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.HwNetworkUtil
 * JD-Core Version:    0.7.0.1
 */