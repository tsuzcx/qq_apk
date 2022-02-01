package com.tencent.tpns.dataacquisition;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomDeviceInfos
{
  private static final String DEVICEINFOS_REAL_CLASSNAME = "com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos";
  private static boolean isWarned = false;
  private static Boolean ismportImplClassFlag = null;
  
  public static String getAndroidId(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getAndroidId", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static List<PackageInfo> getAppPackages(Context paramContext)
  {
    try
    {
      paramContext = (List)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getAppPackages", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return new ArrayList();
  }
  
  public static String getFacilityIdentity(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getFacilityIdentity", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static String getFacilityMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getFacilityMacAddr", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static String getImsi(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getImsi", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static String getIp(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getIp", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static Map<String, Integer> getRecentTasks(Context paramContext)
  {
    try
    {
      paramContext = (Map)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRecentTasks", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return new HashMap();
  }
  
  public static JSONObject getReportLocationJson(Context paramContext)
  {
    try
    {
      paramContext = (JSONObject)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getReportLocationJson", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return null;
  }
  
  public static Map<String, ActivityManager.RunningAppProcessInfo> getRunningAppProces(Context paramContext)
  {
    try
    {
      paramContext = (Map)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRunningAppProces", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return new HashMap();
  }
  
  public static Map<String, Integer> getRunningProcess(Context paramContext)
  {
    try
    {
      paramContext = (Map)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getRunningProcess", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return new HashMap();
  }
  
  public static String getSimOperator(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getSimOperator", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static String getWiFiBBSID(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWiFiBBSID", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static String getWiFiSSID(Context paramContext)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWiFiSSID", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return "";
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      paramContext = (WifiInfo)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWifiInfo", new Object[] { paramContext }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return null;
  }
  
  public static JSONArray getWifiTopN(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = (JSONArray)Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos").call("getWifiTopN", new Object[] { paramContext, Integer.valueOf(paramInt) }).get();
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      showWarnMessage(paramContext);
    }
    return null;
  }
  
  public static boolean isImportImplClass()
  {
    if (ismportImplClassFlag != null) {
      return ismportImplClassFlag.booleanValue();
    }
    try
    {
      Reflect.on("com.tencent.tpns.customdataacquisition.intf.CustomDeviceInfos");
      ismportImplClassFlag = Boolean.valueOf(true);
      return ismportImplClassFlag.booleanValue();
    }
    catch (ReflectException localReflectException)
    {
      for (;;)
      {
        Log.w("TPush-DataAcq", "isImportImplClass false");
        ismportImplClassFlag = Boolean.valueOf(false);
      }
    }
  }
  
  private static void showWarnMessage(ReflectException paramReflectException)
  {
    if (!isWarned) {
      isWarned = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.dataacquisition.CustomDeviceInfos
 * JD-Core Version:    0.7.0.1
 */