package com.tencent.mobileqq.Pandora.deviceInfo;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.Pandora.util.BackgroundUtil;
import com.tencent.mobileqq.Pandora.util.Log;
import com.tencent.mobileqq.Pandora.util.PermissionUtil;
import com.tencent.mobileqq.Pandora.util.SharedPreferencesManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceInfoManager
{
  private static final Object LOCKANDROIDID = new Object();
  private static final Object LOCKDEVICEID;
  private static final Object LOCKIMEI;
  private static final Object LOCKIMSI;
  private static final Object LOCKMEID = new Object();
  private static final String TAG = "DeviceInfoManager";
  private static Map<Integer, String> mDeviceIdMap = new ConcurrentHashMap();
  private static Map<Integer, String> mImeiMap = new ConcurrentHashMap();
  private static Map<Integer, String> mMeidMap = new ConcurrentHashMap();
  private static String sAndroidID;
  private static String sDeviceId;
  private static String sImei;
  private static String sImsi;
  private static String sMeid;
  private static String sModel;
  
  static
  {
    LOCKIMEI = new Object();
    LOCKIMSI = new Object();
    LOCKDEVICEID = new Object();
  }
  
  private static boolean beforeGetMeidCheck(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT >= 29)) {}
    while (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return false;
    }
    return true;
  }
  
  public static String getAndroidID(Context paramContext)
  {
    if (!TextUtils.isEmpty(sAndroidID)) {
      return sAndroidID;
    }
    if (SharedPreferencesManager.contain(paramContext, "android_id").booleanValue())
    {
      sAndroidID = SharedPreferencesManager.getData(paramContext, "android_id");
      return sAndroidID;
    }
    for (;;)
    {
      synchronized (LOCKANDROIDID)
      {
        if (SharedPreferencesManager.contain(paramContext, "android_id").booleanValue()) {
          sAndroidID = SharedPreferencesManager.getData(paramContext, "android_id");
        }
      }
      sAndroidID = updateAndroidID(paramContext);
    }
  }
  
  public static String getIMEI(Context paramContext)
  {
    if (!TextUtils.isEmpty(sImei)) {
      return sImei;
    }
    if (SharedPreferencesManager.contain(paramContext, "imei").booleanValue())
    {
      sImei = SharedPreferencesManager.getData(paramContext, "imei");
      return sImei;
    }
    for (;;)
    {
      synchronized (LOCKIMEI)
      {
        if (SharedPreferencesManager.contain(paramContext, "imei").booleanValue()) {
          sImei = SharedPreferencesManager.getData(paramContext, "imei");
        }
      }
      sImei = updateIMEI(paramContext);
    }
  }
  
  public static String getIMEI(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty((CharSequence)mImeiMap.get(Integer.valueOf(paramInt)))) {
      return (String)mImeiMap.get(Integer.valueOf(paramInt));
    }
    if (SharedPreferencesManager.contain(paramContext, "imei" + paramInt).booleanValue())
    {
      mImeiMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "imei" + paramInt));
      return (String)mImeiMap.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      synchronized (LOCKIMEI)
      {
        if (SharedPreferencesManager.contain(paramContext, "imei" + paramInt).booleanValue()) {
          mImeiMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "imei" + paramInt));
        }
      }
      mImeiMap.put(Integer.valueOf(paramInt), updateIMEI(paramContext, paramInt));
    }
  }
  
  public static String getImsi(Context paramContext)
  {
    if (!TextUtils.isEmpty(sImsi)) {
      return sImsi;
    }
    if (SharedPreferencesManager.contain(paramContext, "imsi").booleanValue())
    {
      sImsi = SharedPreferencesManager.getData(paramContext, "imsi");
      return sImsi;
    }
    for (;;)
    {
      synchronized (LOCKIMSI)
      {
        if (SharedPreferencesManager.contain(paramContext, "imsi").booleanValue()) {
          sImsi = SharedPreferencesManager.getData(paramContext, "imsi");
        }
      }
      sImsi = updateIMSI(paramContext);
    }
  }
  
  public static String getMeid(Context paramContext)
  {
    if (!TextUtils.isEmpty(sMeid)) {
      return sMeid;
    }
    if (SharedPreferencesManager.contain(paramContext, "meid").booleanValue())
    {
      sMeid = SharedPreferencesManager.getData(paramContext, "meid");
      return sMeid;
    }
    for (;;)
    {
      synchronized (LOCKMEID)
      {
        if (SharedPreferencesManager.contain(paramContext, "meid").booleanValue()) {
          sMeid = SharedPreferencesManager.getData(paramContext, "meid");
        }
      }
      sMeid = updateMeid(paramContext);
    }
  }
  
  public static String getMeid(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty((CharSequence)mMeidMap.get(Integer.valueOf(paramInt)))) {
      return (String)mMeidMap.get(Integer.valueOf(paramInt));
    }
    if (SharedPreferencesManager.contain(paramContext, "meid" + paramInt).booleanValue())
    {
      mMeidMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "meid" + paramInt));
      return (String)mMeidMap.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      synchronized (LOCKMEID)
      {
        if (SharedPreferencesManager.contain(paramContext, "meid" + paramInt).booleanValue()) {
          mMeidMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "meid" + paramInt));
        }
      }
      mMeidMap.put(Integer.valueOf(paramInt), updateMeid(paramContext, paramInt));
    }
  }
  
  public static String getModel(Context paramContext)
  {
    if (!TextUtils.isEmpty(sModel)) {
      return sModel;
    }
    if (SharedPreferencesManager.contain(paramContext, "model").booleanValue()) {}
    for (sModel = SharedPreferencesManager.getData(paramContext, "model");; sModel = updateModel(paramContext)) {
      return sModel;
    }
  }
  
  public static String getsDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    if (SharedPreferencesManager.contain(paramContext, "deviceId").booleanValue())
    {
      sDeviceId = SharedPreferencesManager.getData(paramContext, "deviceId");
      return sDeviceId;
    }
    for (;;)
    {
      synchronized (LOCKDEVICEID)
      {
        if (SharedPreferencesManager.contain(paramContext, "deviceId").booleanValue()) {
          sDeviceId = SharedPreferencesManager.getData(paramContext, "deviceId");
        }
      }
      sDeviceId = updateDeviceId(paramContext);
    }
  }
  
  public static String getsDeviceId(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty((CharSequence)mDeviceIdMap.get(Integer.valueOf(paramInt)))) {
      return (String)mDeviceIdMap.get(Integer.valueOf(paramInt));
    }
    if (SharedPreferencesManager.contain(paramContext, "deviceId" + paramInt).booleanValue())
    {
      mDeviceIdMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "deviceId" + paramInt));
      return (String)mDeviceIdMap.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      synchronized (LOCKDEVICEID)
      {
        if (SharedPreferencesManager.contain(paramContext, "deviceId" + paramInt).booleanValue()) {
          mDeviceIdMap.put(Integer.valueOf(paramInt), SharedPreferencesManager.getData(paramContext, "deviceId" + paramInt));
        }
      }
      mDeviceIdMap.put(Integer.valueOf(paramInt), updateDeviceId(paramContext, paramInt));
    }
  }
  
  public static boolean setImsi(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      SharedPreferencesManager.save(paramContext, "imsi" + paramInt, paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.e("DeviceInfoManager", "set IMSI failed :", paramContext);
    }
    return false;
  }
  
  public static boolean setImsi(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferencesManager.save(paramContext, "imsi", paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.e("DeviceInfoManager", "set IMSI failed :", paramContext);
    }
    return false;
  }
  
  private static String updateAndroidID(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    try
    {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      Log.e("DeviceInfoManager", "Settings.Secure.getString class", new Throwable());
      sAndroidID = str;
      SharedPreferencesManager.save(paramContext, "android_id", sAndroidID);
      return sAndroidID;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
        Log.e("DeviceInfoManager", "Settings.Secure.getString exception is ", localThrowable);
      }
    }
  }
  
  private static String updateDeviceId(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      Log.e("DeviceInfoManager", "tm.getDeviceId class", new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "TelephonyManager getDeviceId exception is ", localException);
      }
    }
    sDeviceId = str1;
    SharedPreferencesManager.save(paramContext, "deviceId", sDeviceId);
    return sDeviceId;
  }
  
  private static String updateDeviceId(Context paramContext, int paramInt)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId(paramInt);
      Log.e("DeviceInfoManager", "tm.getDeviceId index class " + paramInt, new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "TelephonyManager getDeviceId exception is ", localException);
      }
    }
    mDeviceIdMap.put(Integer.valueOf(paramInt), str1);
    SharedPreferencesManager.save(paramContext, "deviceId" + paramInt, str1);
    return str1;
  }
  
  private static String updateIMEI(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getImei();
      Log.e("DeviceInfoManager", "tm.getImei class", new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "TelephonyManager getDeviceId exception is ", localException);
      }
    }
    sImei = str1;
    SharedPreferencesManager.save(paramContext, "imei", sImei);
    return sImei;
  }
  
  private static String updateIMEI(Context paramContext, int paramInt)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getImei(paramInt);
      Log.e("DeviceInfoManager", "tm.getImei index class " + paramInt, new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "TelephonyManager getDeviceId exception is ", localException);
      }
    }
    mImeiMap.put(Integer.valueOf(paramInt), str1);
    SharedPreferencesManager.save(paramContext, "imei" + paramInt, str1);
    return str1;
  }
  
  public static String updateIMSI(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (!PermissionUtil.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      Log.e("DeviceInfoManager", "tm.getSubscriberId class", new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "TelephonyManager getSubscriberId exception is ", localException);
      }
    }
    sImsi = str1;
    SharedPreferencesManager.save(paramContext, "imsi", sImsi);
    return sImsi;
  }
  
  private static String updateMeid(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (!beforeGetMeidCheck(paramContext)) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getMeid();
      Log.e("DeviceInfoManager", "tm.getmeid class", new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "getMeid exception is ", localException);
      }
    }
    sMeid = str1;
    SharedPreferencesManager.save(paramContext, "meid", sMeid);
    return sMeid;
  }
  
  private static String updateMeid(Context paramContext, int paramInt)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    if (!beforeGetMeidCheck(paramContext)) {
      return "";
    }
    try
    {
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getMeid(paramInt);
      Log.e("DeviceInfoManager", "tm.getmeid index class " + paramInt, new Throwable());
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = "";
        Log.e("DeviceInfoManager", "getMeid exception is ", localException);
      }
    }
    mMeidMap.put(Integer.valueOf(paramInt), str1);
    SharedPreferencesManager.save(paramContext, "meid" + paramInt, str1);
    return str1;
  }
  
  public static String updateModel(Context paramContext)
  {
    if (BackgroundUtil.isOnBackgroud(paramContext)) {
      return "";
    }
    sModel = Build.MODEL;
    return sModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.deviceInfo.DeviceInfoManager
 * JD-Core Version:    0.7.0.1
 */