package com.tencent.kingkong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

@SuppressLint({"NewApi"})
public class DataReport
{
  private static ConnectivityManager mConnectivetyManager;
  private static Context mContext;
  private static PackageManager mPackageManager = null;
  private static String mQQUni = "0";
  private static SensorManager mSensorManager = null;
  private static TelephonyManager mTelephonyManager = null;
  private static WifiManager mWifiManager;
  
  static
  {
    mConnectivetyManager = null;
    mWifiManager = null;
  }
  
  private static String formatCellInfo(String paramString)
  {
    String str = null;
    Object localObject = null;
    if (paramString != null)
    {
      str = paramString.trim();
      paramString = localObject;
      if (str.length() != 0) {
        paramString = str;
      }
      if (paramString.charAt(0) == '"') {
        return paramString;
      }
      if (paramString.charAt(0) == '[') {
        return paramString;
      }
      if (paramString.charAt(0) == '{') {
        return paramString;
      }
      str = "\"" + paramString + "\"";
    }
    return str;
  }
  
  public static String getAccelerometerName()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getSensorManager();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(1);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getName();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getAccelerometerVendor()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getSensorManager();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(1);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getVendor();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getAccessSubtype()
  {
    try
    {
      TelephonyManager localTelephonyManager = getTelephonyManager();
      int i;
      if (localTelephonyManager != null) {
        i = localTelephonyManager.getNetworkType();
      }
      switch (i)
      {
      default: 
        return "unknown";
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return "2G";
      case 13: 
        return "4G";
      }
      return "3G";
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getAndroidID()
  {
    if (mContext == null) {
      return null;
    }
    try
    {
      String str = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getAppVersion()
  {
    Object localObject;
    if (mContext == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        if (localObject != null)
        {
          localObject = ((PackageInfo)localObject).versionName;
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (!bool) {}
        }
        else
        {
          return null;
        }
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public static int getBatteryLevel()
  {
    int j = -1;
    int i = j;
    try
    {
      if (mContext != null)
      {
        Intent localIntent = mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("level", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static int getBatteryTemp()
  {
    int j = -1;
    int i = j;
    try
    {
      if (mContext != null)
      {
        Intent localIntent = mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("temperature", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static int getBatteryVoltage()
  {
    int j = -1;
    int i = j;
    try
    {
      if (mContext != null)
      {
        Intent localIntent = mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("voltage", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static String getBrand()
  {
    return Build.BRAND;
  }
  
  public static String getCarrier()
  {
    try
    {
      Object localObject = getTelephonyManager();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getNetworkOperatorName();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  private static String getCellIdentity(CellInfo paramCellInfo)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramCellInfo instanceof CellInfoCdma))
    {
      paramCellInfo = ((CellInfoCdma)paramCellInfo).getCellIdentity();
      localObject1 = localObject2;
      if (paramCellInfo != null)
      {
        i = paramCellInfo.getBasestationId();
        localObject1 = String.format("{\"cellType\":\"%s\", \"param\":{\"lat\":%d, \"lon\":%d, \"bid\":%d, \"nid\":%d, \"sid\":%d}}", new Object[] { "CDMA", Integer.valueOf(paramCellInfo.getLatitude()), Integer.valueOf(paramCellInfo.getLongitude()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getNetworkId()), Integer.valueOf(paramCellInfo.getSystemId()) });
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            if ((Build.VERSION.SDK_INT < 18) || (!(paramCellInfo instanceof CellInfoWcdma))) {
              break;
            }
            paramCellInfo = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
            localObject1 = localObject2;
          } while (paramCellInfo == null);
          i = paramCellInfo.getCid();
          return String.format("{\"cellType\":\"%s\", \"param\":{\"lac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "WCDMA", Integer.valueOf(paramCellInfo.getLac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
          if (!(paramCellInfo instanceof CellInfoGsm)) {
            break;
          }
          paramCellInfo = ((CellInfoGsm)paramCellInfo).getCellIdentity();
          localObject1 = localObject2;
        } while (paramCellInfo == null);
        i = paramCellInfo.getCid();
        return String.format("{\"cellType\":\"%s\", \"param\":{\"lac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "GSM", Integer.valueOf(paramCellInfo.getLac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
        localObject1 = localObject2;
      } while (!(paramCellInfo instanceof CellInfoLte));
      paramCellInfo = ((CellInfoLte)paramCellInfo).getCellIdentity();
      localObject1 = localObject2;
    } while (paramCellInfo == null);
    int i = paramCellInfo.getCi();
    return String.format("{\"cellType\":\"%s\", \"param\":{\"tac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "LTE", Integer.valueOf(paramCellInfo.getTac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
  }
  
  public static String getCellInfo()
  {
    Object localObject3 = null;
    label256:
    label266:
    label268:
    label273:
    for (;;)
    {
      int j;
      int i;
      try
      {
        TelephonyManager localTelephonyManager = getTelephonyManager();
        if (localTelephonyManager != null)
        {
          Object localObject1 = localObject3;
          List localList;
          if (Build.VERSION.SDK_INT >= 17)
          {
            localList = localTelephonyManager.getAllCellInfo();
            localObject1 = localObject3;
            if (localList != null)
            {
              localObject1 = localObject3;
              if (localList.size() != 0)
              {
                j = localList.size();
                i = 0;
                break label256;
              }
            }
          }
          if (localObject1 != null) {
            break label266;
          }
          localObject1 = localTelephonyManager.getCellLocation();
          if (localObject1 == null)
          {
            return null;
            localObject1 = (CellInfo)localList.get(i);
            if (!((CellInfo)localObject1).isRegistered()) {
              break label268;
            }
            localObject1 = formatCellInfo(getCellIdentity((CellInfo)localObject1));
            continue;
          }
          if ((localObject1 instanceof GsmCellLocation))
          {
            localObject1 = String.format("{\"cellType\":\"GSM\", \"param\":{\"lac\":%d, \"cid\":%d}}", new Object[] { Integer.valueOf(((GsmCellLocation)localObject1).getLac()), Integer.valueOf(((GsmCellLocation)localObject1).getCid()) });
            return formatCellInfo((String)localObject1);
          }
          if ((localObject1 instanceof CdmaCellLocation))
          {
            localObject1 = String.format("{\"cellType\":\"CDMA\", \"param\":{\"lat\":%d, \"lon\":%d, \"bid\":%d, \"nid\":%d, \"sid\":%d}}", new Object[] { Integer.valueOf(((CdmaCellLocation)localObject1).getBaseStationLatitude()), Integer.valueOf(((CdmaCellLocation)localObject1).getBaseStationLongitude()), Integer.valueOf(((CdmaCellLocation)localObject1).getBaseStationId()), Integer.valueOf(((CdmaCellLocation)localObject1).getNetworkId()), Integer.valueOf(((CdmaCellLocation)localObject1).getSystemId()) });
            continue;
          }
          localObject1 = null;
          continue;
        }
        else
        {
          return null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      for (;;)
      {
        if (i < j) {
          break label273;
        }
        Object localObject2 = localObject3;
        break;
        return localObject2;
        i += 1;
      }
    }
  }
  
  private static ConnectivityManager getConnectivityManager()
  {
    try
    {
      if ((mContext != null) && (mConnectivetyManager == null)) {
        mConnectivetyManager = (ConnectivityManager)mContext.getSystemService("connectivity");
      }
      ConnectivityManager localConnectivityManager = mConnectivetyManager;
      return localConnectivityManager;
    }
    finally {}
  }
  
  public static String getDeviceId()
  {
    try
    {
      Object localObject = getTelephonyManager();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  public static String getGravityName()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getSensorManager();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(9);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getName();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getGravityVendor()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getSensorManager();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(9);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getVendor();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getHardware()
  {
    return Build.HARDWARE;
  }
  
  public static String getImsi()
  {
    try
    {
      Object localObject = getTelephonyManager();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  public static String getIpAddr()
  {
    try
    {
      Object localObject1 = getConnectivityManager();
      if (localObject1 != null)
      {
        Object localObject2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
          if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
          {
            localObject2 = getWifiManager();
            if ((localObject2 != null) && (((WifiManager)localObject2).isWifiEnabled()))
            {
              int i = ((WifiManager)localObject2).getConnectionInfo().getIpAddress();
              return (i & 0xFF) + "." + (i >> 8 & 0xFF) + "." + (i >> 16 & 0xFF) + "." + (i >> 24 & 0xFF);
            }
          }
          localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
          if ((localObject1 != null) && (((NetworkInfo)localObject1).isAvailable()))
          {
            InetAddress localInetAddress;
            do
            {
              localObject1 = NetworkInterface.getNetworkInterfaces();
              while (!((Enumeration)localObject2).hasMoreElements())
              {
                if (!((Enumeration)localObject1).hasMoreElements()) {
                  break;
                }
                localObject2 = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
              }
              localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            } while (localInetAddress.isLoopbackAddress());
            localObject1 = localInetAddress.getHostAddress().toString();
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getLocalMacAddress()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = getWifiManager();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((WifiManager)localObject3).getConnectionInfo();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((WifiInfo)localObject3).getMacAddress();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getModel()
  {
    return Build.MODEL;
  }
  
  public static String getNetworkType()
  {
    try
    {
      localObject = getConnectivityManager();
      if (localObject == null) {
        break label67;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        break label67;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 1: 
        return ((NetworkInfo)localObject).getTypeName();
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      return null;
    }
    localObject = ((NetworkInfo)localObject).getSubtypeName();
    return localObject;
    label67:
    return null;
  }
  
  public static int getOSSDK()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  private static PackageManager getPackageManager()
  {
    try
    {
      if ((mContext != null) && (mPackageManager == null)) {
        mPackageManager = mContext.getPackageManager();
      }
      PackageManager localPackageManager = mPackageManager;
      return localPackageManager;
    }
    finally {}
  }
  
  public static String getPackageName()
  {
    if (mContext == null) {
      return null;
    }
    try
    {
      if (!TextUtils.isEmpty(mContext.getPackageName())) {
        return "com.tencent.token";
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  public static String getQQUin()
  {
    if (!mQQUni.equals("0")) {
      return mQQUni;
    }
    if (mContext != null) {
      return mContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).getString("QQUni", "0");
    }
    return mQQUni;
  }
  
  public static String getResolution()
  {
    try
    {
      if (mContext == null) {
        return null;
      }
      Object localObject1 = (WindowManager)mContext.getSystemService("window");
      Object localObject2 = new DisplayMetrics();
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject1).getRealMetrics((DisplayMetrics)localObject2);
        return ((DisplayMetrics)localObject2).heightPixels + "*" + ((DisplayMetrics)localObject2).widthPixels;
      }
      localObject2 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      localObject1 = localMethod.invoke(localObject1, new Object[0]) + "*" + ((Method)localObject2).invoke(localObject1, new Object[0]);
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getRomTotal()
  {
    try
    {
      Object localObject = Environment.getDataDirectory();
      if (localObject != null)
      {
        if (((File)localObject).getAbsolutePath().length() == 0) {
          return null;
        }
        localObject = new StatFs(((File)localObject).getPath());
        if (Build.VERSION.SDK_INT < 18) {
          return ((StatFs)localObject).getBlockCount() * ((StatFs)localObject).getBlockSize();
        }
        localObject = localObject.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject, new Object[0]);
        if (localObject != null)
        {
          localObject = ((Long)localObject).toString();
          return localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getSDCardTotal()
  {
    try
    {
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        return null;
      }
      Object localObject = Environment.getExternalStorageDirectory();
      if ((localObject != null) && (((File)localObject).getAbsolutePath().length() != 0))
      {
        localObject = new StatFs(((File)localObject).getPath());
        if (Build.VERSION.SDK_INT < 18) {
          return ((StatFs)localObject).getBlockCount() * ((StatFs)localObject).getBlockSize();
        }
        localObject = localObject.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject, new Object[0]);
        if (localObject != null)
        {
          localObject = ((Long)localObject).toString();
          return localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static SensorManager getSensorManager()
  {
    try
    {
      if ((mContext != null) && (mSensorManager == null)) {
        mSensorManager = (SensorManager)mContext.getSystemService("sensor");
      }
      SensorManager localSensorManager = mSensorManager;
      return localSensorManager;
    }
    finally {}
  }
  
  private static TelephonyManager getTelephonyManager()
  {
    try
    {
      if ((mContext != null) && (mTelephonyManager == null)) {
        mTelephonyManager = (TelephonyManager)mContext.getSystemService("phone");
      }
      TelephonyManager localTelephonyManager = mTelephonyManager;
      return localTelephonyManager;
    }
    finally {}
  }
  
  private static WifiManager getWifiManager()
  {
    try
    {
      if ((mContext != null) && (mWifiManager == null)) {
        mWifiManager = (WifiManager)mContext.getSystemService("wifi");
      }
      WifiManager localWifiManager = mWifiManager;
      return localWifiManager;
    }
    finally {}
  }
  
  public static boolean isAccelerometerSupported()
  {
    try
    {
      Object localObject = getSensorManager();
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(1);
        if (localObject != null) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
  
  public static boolean isBlueToothLeSupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.bluetooth_le");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isBlueToothSupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.bluetooth");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isGpsLocationSupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.location.gps");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isGravitySupported()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = getSensorManager();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(9);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isGyroscopeSupported()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = getSensorManager();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(4);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isNfcSupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.nfc");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isProxyEnabled()
  {
    String str = null;
    try
    {
      if (Build.VERSION.SDK_INT > 14) {
        str = System.getProperty("http.proxyHost");
      }
      while (!TextUtils.isEmpty(str))
      {
        return true;
        if (mContext != null) {
          str = Proxy.getHost(mContext);
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public static boolean isRoot()
  {
    boolean bool3 = true;
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "ro.secure" });
      if ((localObject1 != null) && ("1".equals(localObject1)))
      {
        bool1 = bool3;
        if (!new File("/system/bin/su").exists())
        {
          bool1 = bool3;
          if (!new File("/system/xbin/su").exists()) {
            bool1 = false;
          }
        }
        return bool1;
      }
    }
    catch (Exception localException)
    {
      boolean bool2;
      do
      {
        do
        {
          Object localObject2;
          for (;;)
          {
            localObject2 = null;
          }
          if ((localObject2 != null) && ("0".equals(localObject2))) {}
          for (bool2 = true; bool2; bool2 = false) {
            return bool2;
          }
          bool1 = bool3;
        } while (new File("/system/bin/su").exists());
        boolean bool1 = bool3;
      } while (new File("/system/xbin/su").exists());
      return bool2;
    }
  }
  
  public static boolean isTelephonySupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.telephony");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isUsbAccessorySupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.usb.accessory");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isWifiSupported()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = getPackageManager();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.wifi");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static void setQQUni(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (mContext != null)
    {
      SharedPreferences.Editor localEditor = mContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
      localEditor.putString("QQUni", paramString);
      localEditor.commit();
    }
    mQQUni = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.DataReport
 * JD-Core Version:    0.7.0.1
 */