package com.tencent.qqmail.utilities.deviceid;

import alkx;
import alkz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.core.utilities.deviceutil.Devices;

public class DeviceUtil
{
  public static String TAG = "DeviceUtil";
  private static DeviceInfo info;
  
  public static int dip2px(float paramFloat)
  {
    return (int)(QMApplicationContext.sharedInstance().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String getAppVersion(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        PackageManager localPackageManager = QMApplicationContext.sharedInstance().getPackageManager();
        if (localPackageManager.getPackageInfo(paramString, 0) != null)
        {
          String str = localPackageManager.getPackageInfo(paramString, 0).versionName;
          int i = localPackageManager.getPackageInfo(paramString, 0).versionCode;
          paramString = "versionName:" + str + ",versionCode:" + i;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return "getAppVersion error:" + paramString.toString();
      }
    }
    return "getAppVersion null";
  }
  
  private static String getAvailMemory()
  {
    ActivityManager localActivityManager = (ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return "free:" + 1.0D * localMemoryInfo.availMem / 1024.0D / 1024.0D + "MB";
  }
  
  public static DeviceInfo getDeviceInfos()
  {
    if (info != null) {
      return info;
    }
    HashMap localHashMap = new HashMap();
    Field[] arrayOfField = Build.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label129;
      }
      Object localObject1 = arrayOfField[i];
      try
      {
        ((Field)localObject1).setAccessible(true);
        String str2 = ((Field)localObject1).getName();
        if (str2 != null)
        {
          localObject2 = ((Field)localObject1).get(null).toString();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localHashMap.put(str2, localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, "DeviceUtil", "read device info err : " + localException.toString());
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    label129:
    info = new DeviceInfo();
    info.ID = ((String)localHashMap.get("ID"));
    info.BOARD = ((String)localHashMap.get("BOARD"));
    info.BOOTLOADER = ((String)localHashMap.get("BOOTLOADER"));
    info.BRAND = ((String)localHashMap.get("BRAND"));
    info.CPU_ABI = ((String)localHashMap.get("CPU_ABI"));
    info.CPU_ABI2 = ((String)localHashMap.get("CPU_ABI2"));
    info.DEVICE = ((String)localHashMap.get("DEVICE"));
    info.DISPLAY = ((String)localHashMap.get("DISPLAY"));
    info.FINGERPRINT = ((String)localHashMap.get("FINGERPRINT"));
    info.HARDWARE = ((String)localHashMap.get("HARDWARE"));
    info.IS_DEBUGGABLE = ((String)localHashMap.get("IS_DEBUGGABLE"));
    info.MANUFACTURER = ((String)localHashMap.get("MANUFACTURER"));
    info.MODEL = ((String)localHashMap.get("MODEL"));
    info.PRODUCT = ((String)localHashMap.get("PRODUCT"));
    info.RADIO = ((String)localHashMap.get("RADIO"));
    info.sdkIntVersion = String.valueOf(Build.VERSION.SDK_INT);
    info.SERIAL = ((String)localHashMap.get("SERIAL"));
    info.TAGS = ((String)localHashMap.get("TAGS"));
    info.TIME = ((String)localHashMap.get("TIME"));
    info.TYPE = ((String)localHashMap.get("TYPE"));
    info.USER = ((String)localHashMap.get("USER"));
    info.HOST = ((String)localHashMap.get("HOST"));
    Object localObject2 = info;
    if (Build.VERSION.RELEASE == null) {}
    for (String str1 = "";; str1 = Build.VERSION.RELEASE)
    {
      ((DeviceInfo)localObject2).releaseVersion = str1;
      info.userAgent = System.getProperty("http.agent");
      info.IMEI = Devices.getFakeIMEI(QMApplicationContext.sharedInstance());
      info.DEVICE_ID = Devices.getFakeIMEI(QMApplicationContext.sharedInstance());
      return info;
    }
  }
  
  private static String getHostIp()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Enumeration localEnumeration1 = alkz.getNetworkInterfaces();
      while ((localEnumeration1 != null) && (localEnumeration1.hasMoreElements()))
      {
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        while (localEnumeration2.hasMoreElements())
        {
          InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
          if (!localInetAddress.isLoopbackAddress()) {
            localStringBuilder.append(localInetAddress.getHostAddress() + "####");
          }
        }
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      QMLog.log(6, "DEVICEUTIL", "GetHostIp err:" + localException.toString());
      return "";
    }
    String str;
    return str;
  }
  
  public static String getInnerMemSpaceLog()
  {
    return getAvailMemory() + "," + getTotalMemory();
  }
  
  public static List<AppInfo> getInstalledApps()
  {
    localArrayList = new ArrayList();
    try
    {
      PackageManager localPackageManager = QMApplicationContext.sharedInstance().getPackageManager();
      List localList = alkx.a(localPackageManager, 0);
      int i = 0;
      while (i < localList.size())
      {
        PackageInfo localPackageInfo = (PackageInfo)localList.get(i);
        AppInfo localAppInfo = new AppInfo();
        localAppInfo.appName = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
        localAppInfo.packageName = localPackageInfo.packageName;
        localAppInfo.versionName = localPackageInfo.versionName;
        localAppInfo.versionCode = localPackageInfo.versionCode;
        localArrayList.add(localAppInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(localException));
    }
  }
  
  public static String getLogIpString()
  {
    return "wifi:" + getWifiIp() + ";other:" + getHostIp();
  }
  
  public static long getRootAvailableSize()
  {
    Object localObject = Environment.getRootDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return i * l;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "getRootAvailableSize error " + localException.getMessage());
    }
    return 0L;
  }
  
  public static long getRootTotalSize()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getBlockCount();
      return i * l;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "getRootTotalSize error " + localException.getMessage());
    }
    return 0L;
  }
  
  public static List<String> getRunningAppProcesses()
  {
    Object localObject = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName);
    }
    return localArrayList;
  }
  
  private static String getSDAvailableSize()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      localObject = "free:" + l2 * l1 * 1.0D / 1024.0D / 1024.0D + "MB";
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "getSDAvailableSize error " + localException.getMessage());
    }
    return "free: 0MB";
  }
  
  private static String getSDTotalSize()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = "total:" + l2 * l1 * 1.0D / 1024.0D / 1024.0D + "MB";
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "getSDTotalSize error " + localException.getMessage());
    }
    return "total: 0MB";
  }
  
  public static String getSDcardSpaceLog()
  {
    return getSDAvailableSize() + "," + getSDTotalSize();
  }
  
  public static int getScreenHeight(Activity paramActivity)
  {
    if (paramActivity == null) {
      return -1;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public static int getScreenWidth(Activity paramActivity)
  {
    if (paramActivity == null) {
      return -1;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  @SuppressLint({"NewApi"})
  public static int[] getScreenWidthHeight(Context paramContext)
  {
    Point localPoint = new Point();
    paramContext = (WindowManager)paramContext.getSystemService("window");
    int j;
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramContext.getDefaultDisplay().getSize(localPoint);
      j = localPoint.x;
    }
    for (int i = localPoint.y;; i = paramContext.getHeight())
    {
      return new int[] { j, i };
      paramContext = paramContext.getDefaultDisplay();
      j = paramContext.getWidth();
    }
  }
  
  private static String getTotalMemory()
  {
    long l = 0L;
    try
    {
      FileReader localFileReader = new FileReader("/proc/meminfo");
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 256);
      String str1;
      String[] arrayOfString;
      int j;
      int i;
      String str2;
      return "";
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        str1 = localBufferedReader.readLine();
        if (str1 != null)
        {
          arrayOfString = str1.split("\\s+");
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            str2 = arrayOfString[i];
            Log.i(str1, str2 + "/t");
            i += 1;
          }
          i = Integer.valueOf(arrayOfString[1]).intValue();
          l = i;
        }
        return "total:" + l * 1.0D / 1024.0D + "MB";
      }
      catch (IOException localIOException2)
      {
        QMLog.log(6, TAG, "getTotalMemory err:" + localIOException2.toString());
        return "";
        localFileNotFoundException = localFileNotFoundException;
        QMLog.log(6, TAG, "getTotalMemory err: file not found");
        return "";
      }
      finally
      {
        localBufferedReader.close();
        localFileNotFoundException.close();
      }
    }
    catch (IOException localIOException1)
    {
      QMLog.log(6, TAG, "getTotalMemory err:" + localIOException1.toString());
    }
  }
  
  private static String getWifiIp()
  {
    Object localObject = (WifiManager)QMApplicationContext.sharedInstance().getApplicationContext().getSystemService("wifi");
    try
    {
      localObject = intToIp(alkz.a((WifiManager)localObject).getIpAddress());
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, "Cannot get ip from wifimanager.");
    }
    return "";
  }
  
  private static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static boolean isAppInstalled(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.equals("")) {}
    }
    try
    {
      paramString = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(paramString, 0);
      bool1 = bool2;
      if (paramString != null) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isPhoneRoot()
  {
    return (new File("/system/bin/su").exists()) || (new File("/system/xbin/su").exists());
  }
  
  public static boolean isQCloudInstalled()
  {
    return isAppInstalled("com.qq.qcloud");
  }
  
  public static boolean isQQBrowserInstalled()
  {
    return isAppInstalled("com.tencent.mtt");
  }
  
  public static boolean isQQInstalled()
  {
    return isAppInstalled("com.tencent.mobileqq");
  }
  
  public static boolean[] isScreenReaderActive()
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)QMApplicationContext.sharedInstance().getSystemService("accessibility");
    boolean bool = localAccessibilityManager.isEnabled();
    if (Build.VERSION.SDK_INT >= 14) {
      return new boolean[] { bool, localAccessibilityManager.isTouchExplorationEnabled() };
    }
    return new boolean[] { 0, 0 };
  }
  
  public static boolean isServiceAlive(String paramString1, String paramString2)
  {
    try
    {
      Iterator localIterator = ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getRunningServices(2147483647).iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
        if ((localRunningServiceInfo.service != null) && (localRunningServiceInfo.service.getPackageName() != null) && (localRunningServiceInfo.service.getPackageName().equals(paramString1)) && (localRunningServiceInfo.service.getClassName() != null) && (localRunningServiceInfo.service.getClassName().equals(paramString2)))
        {
          QMLog.log(4, TAG, "Service is Alive:" + paramString1 + "/" + paramString2);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramString1));
    }
    return false;
  }
  
  public static boolean isWeChatInstalled()
  {
    return isAppInstalled("com.tencent.mm");
  }
  
  public static boolean isWeChatPhoneBookInstalled()
  {
    return isAppInstalled("com.tencent.pb");
  }
  
  public static boolean isWeWorkInstalled()
  {
    return isAppInstalled("com.tencent.wework");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.deviceid.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */