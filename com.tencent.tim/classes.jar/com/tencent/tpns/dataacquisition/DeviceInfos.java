package com.tencent.tpns.dataacquisition;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.tpns.dataacquisition.a.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceInfos
{
  public static final byte NETWORK_TYPE_2G = 2;
  public static final byte NETWORK_TYPE_3G = 3;
  public static final byte NETWORK_TYPE_4G = 4;
  public static final byte NETWORK_TYPE_UNCONNECTED = -1;
  public static final byte NETWORK_TYPE_UNKNOWN = 0;
  public static final byte NETWORK_TYPE_WIFI = 1;
  
  public static int checkBluetooth(Context paramContext)
  {
    return a.j(paramContext);
  }
  
  public static boolean checkHasBluetooth(Context paramContext)
  {
    return a.k(paramContext);
  }
  
  public static boolean checkHasLightSensor(Context paramContext)
  {
    return a.l(paramContext);
  }
  
  public static boolean checkSimulator(Context paramContext)
  {
    return a.m(paramContext);
  }
  
  public static String getBootTime()
  {
    return a.i();
  }
  
  public static String getCarrierInfo(Context paramContext)
  {
    return a.v(paramContext);
  }
  
  public static int getChangedStatus(Context paramContext)
  {
    return a.t(paramContext);
  }
  
  public static JSONObject getCpuInfo(Context paramContext)
  {
    return a.p(paramContext);
  }
  
  public static String getCpuString()
  {
    return a.c();
  }
  
  public static String getCpuType()
  {
    return a.d();
  }
  
  public static String getDM()
  {
    return a.a();
  }
  
  public static String getDeviceName(Context paramContext)
  {
    return a.u(paramContext);
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    return a.f(paramContext);
  }
  
  public static String getExternalStorageInfo(Context paramContext)
  {
    return a.i(paramContext);
  }
  
  public static String getLinkedWay(Context paramContext)
  {
    return a.e(paramContext);
  }
  
  public static byte getNetworkType(Context paramContext)
  {
    return a.c(paramContext);
  }
  
  public static String getRomMemory()
  {
    return a.e();
  }
  
  public static JSONArray getSensorsJson(Context paramContext)
  {
    return a.r(paramContext);
  }
  
  public static String getSensorsString(Context paramContext)
  {
    return a.q(paramContext);
  }
  
  public static String getSimulatorModel(Context paramContext)
  {
    return a.n(paramContext);
  }
  
  public static String getSysFileTime()
  {
    return a.j();
  }
  
  public static String getSystemMemory(Context paramContext)
  {
    return a.o(paramContext);
  }
  
  public static Integer getTelephonyNetworkType(Context paramContext)
  {
    return a.a(paramContext);
  }
  
  public static long getTotalInternalMemorySize()
  {
    return a.f();
  }
  
  public static long getTotalMemory()
  {
    return a.g();
  }
  
  public static int hasRootAccess(Context paramContext)
  {
    return a.h(paramContext);
  }
  
  public static boolean haveGravity(Context paramContext)
  {
    return a.g(paramContext);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    return a.b(paramContext);
  }
  
  public static boolean isSDCardMounted()
  {
    return a.h();
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    return a.s(paramContext);
  }
  
  public static boolean isWifiNet(Context paramContext)
  {
    return a.d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.dataacquisition.DeviceInfos
 * JD-Core Version:    0.7.0.1
 */