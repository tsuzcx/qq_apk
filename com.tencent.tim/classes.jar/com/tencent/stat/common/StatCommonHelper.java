package com.tencent.stat.common;

import alla;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class StatCommonHelper
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  private static String d = null;
  private static Random e = null;
  private static DisplayMetrics f = null;
  private static String g = null;
  private static String h = "";
  private static String i = "";
  private static volatile int j = -1;
  private static StatLogger k = null;
  private static String l = null;
  private static String m = null;
  private static volatile int n = -1;
  private static String o = null;
  private static String p = null;
  private static long q = -1L;
  private static String r = "";
  private static k s = null;
  private static String t = "__MTA_FIRST_ACTIVATE__";
  private static int u = -1;
  private static long v = -1L;
  private static int w = 0;
  private static String x = "";
  private static volatile String y = null;
  
  static String a(Context paramContext)
  {
    try
    {
      if (m != null) {
        return m;
      }
      int i1 = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i1) {
          m = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label66:
      break label66;
    }
    return m;
  }
  
  private static long b(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  private static Random b()
  {
    try
    {
      if (e == null) {
        e = new Random();
      }
      Random localRandom = e;
      return localRandom;
    }
    finally {}
  }
  
  private static long c()
  {
    if (q > 0L) {
      return q;
    }
    long l3 = 1L;
    l2 = l3;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      l2 = l3;
      String str = localBufferedReader.readLine();
      l1 = l3;
      l2 = l3;
      if (!TextUtils.isEmpty(str))
      {
        l2 = l3;
        l1 = Integer.valueOf(str.split("\\s+")[1]).intValue() * 1024;
      }
      l2 = l1;
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
      }
    }
    q = l1;
    return q;
  }
  
  public static int checkBluetooth()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null) {
      return -1;
    }
    if (localBluetoothAdapter.isEnabled()) {
      return 1;
    }
    return 0;
  }
  
  public static void checkFirstTimeActivate(Context paramContext)
  {
    u = StatPreferences.getInt(paramContext, t, 1);
    if (u == 1) {
      StatPreferences.putInt(paramContext, t, 0);
    }
  }
  
  public static boolean checkPhoneState(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0;
  }
  
  public static Long convertStringToLong(String paramString1, String paramString2, int paramInt1, int paramInt2, Long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return paramLong;
      String str;
      if (!paramString2.equalsIgnoreCase("."))
      {
        str = paramString2;
        if (!paramString2.equalsIgnoreCase("|")) {}
      }
      else
      {
        str = "\\" + paramString2;
      }
      paramString2 = paramString1.split(str);
    } while (paramString2.length != paramInt2);
    try
    {
      paramString1 = Long.valueOf(0L);
      paramInt2 = 0;
      while (paramInt2 < paramString2.length)
      {
        long l1 = paramInt1;
        long l2 = paramString1.longValue();
        long l3 = Long.valueOf(paramString2[paramInt2]).longValue();
        paramInt2 += 1;
        paramString1 = Long.valueOf(l1 * (l2 + l3));
      }
      return paramString1;
    }
    catch (NumberFormatException paramString1) {}
    return paramLong;
  }
  
  public static byte[] deocdeGZipContent(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte = new byte[4096];
    paramArrayOfByte = new ByteArrayOutputStream(paramArrayOfByte.length * 2);
    for (;;)
    {
      int i1 = localGZIPInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      paramArrayOfByte.write(arrayOfByte, 0, i1);
    }
    arrayOfByte = paramArrayOfByte.toByteArray();
    localByteArrayInputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static String getActivityName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getClass().getName();
  }
  
  public static String getAllSensors(Context paramContext)
  {
    if (isStringValid(r)) {
      return r;
    }
    try
    {
      paramContext = (SensorManager)paramContext.getSystemService("sensor");
      if (paramContext == null) {
        break label115;
      }
      paramContext = paramContext.getSensorList(-1);
      if (paramContext == null) {
        break label115;
      }
      localStringBuilder = new StringBuilder(paramContext.size() * 10);
      i1 = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int i1;
        label115:
        k.e(paramContext);
        continue;
        i1 += 1;
      }
    }
    if (i1 < paramContext.size())
    {
      localStringBuilder.append(((Sensor)paramContext.get(i1)).getType());
      if (i1 != paramContext.size() - 1) {
        localStringBuilder.append(",");
      }
    }
    else
    {
      r = localStringBuilder.toString();
      return r;
    }
  }
  
  public static int getAndroidOsBuildVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String getAppKey(Context paramContext)
  {
    if (b != null) {
      return b;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.getString("TA_APPKEY");
        if (paramContext == null) {
          break label62;
        }
        b = paramContext;
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
    for (;;)
    {
      return null;
      label62:
      k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
  }
  
  public static String getAppSHA1(Context paramContext)
  {
    int i1 = 0;
    if (!TextUtils.isEmpty(y)) {
      return y;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      paramContext = MessageDigest.getInstance("SHA1").digest(paramContext);
      StringBuffer localStringBuffer = new StringBuffer();
      int i2 = paramContext.length;
      if (i1 < i2)
      {
        String str = Integer.toHexString(paramContext[i1] & 0xFF).toUpperCase();
        if (str.length() == 1) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(str);
        if (i1 != i2 - 1) {
          localStringBuffer.append(":");
        }
      }
      else
      {
        y = localStringBuffer.toString();
        return y;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        i1 += 1;
      }
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    if (isStringValid(i)) {
      return i;
    }
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if ((i == null) || (i.length() == 0)) {
        return "unknown";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return i;
  }
  
  public static String getCameras(Context paramContext)
  {
    if (isStringValid(x)) {
      return x;
    }
    return x;
  }
  
  public static k getCamerasHelper(Context paramContext)
  {
    try
    {
      if (s == null) {
        s = new k();
      }
      paramContext = s;
      return paramContext;
    }
    finally {}
  }
  
  public static JSONObject getCpuInfo(Context paramContext)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("n", i.a());
      String str = i.d();
      if ((str != null) && (str.length() > 0)) {
        paramContext.put("na", str);
      }
      int i1 = i.b();
      if (i1 > 0) {
        paramContext.put("fx", i1 / 1000000);
      }
      i1 = i.c();
      if (i1 > 0) {
        paramContext.put("fn", i1 / 1000000);
      }
      return paramContext;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MtaSDK", "get cpu error", localThrowable);
    }
    return paramContext;
  }
  
  public static String getCpuString()
  {
    if (isStringValid(o)) {
      return o;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      o = "Intel";
    }
    for (;;)
    {
      return o;
      try
      {
        Object localObject = new byte[1024];
        RandomAccessFile localRandomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        localRandomAccessFile.read((byte[])localObject);
        localRandomAccessFile.close();
        localObject = new String((byte[])localObject);
        int i1 = ((String)localObject).indexOf(0);
        if (i1 == -1) {
          break label108;
        }
        o = ((String)localObject).substring(0, i1);
      }
      catch (Throwable localThrowable)
      {
        k.e(localThrowable);
      }
      continue;
      label108:
      o = localThrowable;
    }
  }
  
  public static String getCpuType()
  {
    String str2 = getCpuString();
    String str1;
    if (str2.contains("ARMv5")) {
      str1 = "armv5";
    }
    while (str2.contains("neon"))
    {
      return str1 + "_neon";
      if (str2.contains("ARMv6")) {
        str1 = "armv6";
      } else if (str2.contains("ARMv7")) {
        str1 = "armv7";
      } else if (str2.contains("Intel")) {
        str1 = "x86";
      } else {
        return "unknown";
      }
    }
    if (str2.contains("vfpv3")) {
      return str1 + "_vfpv3";
    }
    if (str2.contains(" vfp")) {
      return str1 + "_vfp";
    }
    return str1 + "_none";
  }
  
  public static String getCurAppVersion(Context paramContext)
  {
    if (isStringValid(h)) {
      return h;
    }
    try
    {
      h = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (h == null) {
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return h;
  }
  
  public static String getDatabaseName(Context paramContext)
  {
    return getTagForConcurrentProcess(paramContext, StatConstants.DATABASE_NAME);
  }
  
  public static String getDateFormat(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }
  
  public static String getDateString(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.roll(6, paramInt);
    return new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
  }
  
  public static String getDeviceModel(Context paramContext)
  {
    if (d == null) {
      d = Build.MODEL;
    }
    return d;
  }
  
  public static int getDiffTime(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      w = readDiffTimeFromServer(paramContext);
    }
    return w;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    if (f == null)
    {
      f = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
    }
    return f;
  }
  
  public static String getExternalStorageInfo(Context paramContext)
  {
    Object localObject = null;
    if (isStringValid(l)) {
      paramContext = l;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        if (Util.checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
          String str = Environment.getExternalStorageState();
          paramContext = localObject;
          if (str != null)
          {
            paramContext = localObject;
            if (str.equals("mounted"))
            {
              str = Environment.getExternalStorageDirectory().getPath();
              paramContext = localObject;
              if (str != null)
              {
                paramContext = new StatFs(str);
                long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
                long l2 = paramContext.getAvailableBlocks();
                l2 = paramContext.getBlockSize() * l2 / 1000000L;
                l = String.valueOf(l2) + "/" + String.valueOf(l1);
                return l;
              }
            }
          }
        }
        else
        {
          k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
      }
    }
    return null;
  }
  
  /* Error */
  public static android.location.Location getGPSLocation(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 683
    //   4: invokestatic 636	com/tencent/stat/common/Util:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq +85 -> 92
    //   10: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   13: ldc_w 684
    //   16: invokevirtual 686	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: ldc_w 688
    //   23: invokevirtual 116	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 690	android/location/LocationManager
    //   29: astore_0
    //   30: aload_0
    //   31: ldc_w 692
    //   34: invokevirtual 695	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   37: ifeq +55 -> 92
    //   40: aload_0
    //   41: ldc_w 692
    //   44: invokestatic 700	alky:a	(Landroid/location/LocationManager;Ljava/lang/String;)Landroid/location/Location;
    //   47: astore_0
    //   48: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   51: new 259	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 702
    //   61: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 705	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 686	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   74: aload_0
    //   75: areturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   82: aload_1
    //   83: invokevirtual 360	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -10 -> 79
    //   92: aconst_null
    //   93: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   76	7	1	localThrowable1	Throwable
    //   88	1	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	48	76	java/lang/Throwable
    //   48	74	88	java/lang/Throwable
  }
  
  public static HttpHost getHttpProxy(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    do
    {
      try
      {
        if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
          return null;
        }
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          return null;
        }
        if ((paramContext.getTypeName() != null) && (paramContext.getTypeName().equalsIgnoreCase("WIFI"))) {
          return null;
        }
        paramContext = paramContext.getExtraInfo();
        if (paramContext == null) {
          return null;
        }
        if ((paramContext.equals("cmwap")) || (paramContext.equals("3gwap")) || (paramContext.equals("uniwap")))
        {
          paramContext = new HttpHost("10.0.0.172", 80);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
        return null;
      }
      if (paramContext.equals("ctwap")) {
        return new HttpHost("10.0.0.200", 80);
      }
      paramContext = Proxy.getDefaultHost();
    } while ((paramContext == null) || (paramContext.trim().length() <= 0));
    paramContext = new HttpHost(paramContext, Proxy.getDefaultPort());
    return paramContext;
  }
  
  public static String getInstallChannel(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.get("InstallChannel");
        if (paramContext != null) {
          return paramContext.toString();
        }
        k.w("Could not read InstallChannel meta-data from AndroidManifest.xml");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        k.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
      }
    }
    return null;
  }
  
  public static String getLauncherPackageName(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    } while ((paramContext.activityInfo == null) || (paramContext.activityInfo.packageName.equals("android")));
    return paramContext.activityInfo.packageName;
  }
  
  public static String getLinkedWay(Context paramContext)
  {
    Object localObject;
    try
    {
      if ((Util.checkPermission(paramContext, "android.permission.INTERNET")) && (Util.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          paramContext = ((NetworkInfo)localObject).getTypeName();
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          if (paramContext != null)
          {
            if (paramContext.equalsIgnoreCase("WIFI")) {
              return "WIFI";
            }
            if (paramContext.equalsIgnoreCase("MOBILE"))
            {
              if (localObject == null) {
                break label142;
              }
              if (((String)localObject).trim().length() > 0) {
                break label140;
              }
              break label142;
            }
            if (localObject == null) {
              return paramContext;
            }
            if (((String)localObject).trim().length() > 0) {
              break label140;
            }
            return paramContext;
          }
        }
      }
      else
      {
        k.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        k.e(paramContext);
      }
    }
    return "";
    label140:
    return localObject;
    label142:
    return "MOBILE";
    return paramContext;
  }
  
  public static StatLogger getLogger()
  {
    try
    {
      if (k == null)
      {
        k = new StatLogger("MtaSDK");
        k.setDebugEnable(false);
      }
      StatLogger localStatLogger = k;
      return localStatLogger;
    }
    finally {}
  }
  
  public static String getMacId(Context paramContext)
  {
    try
    {
      if ((c == null) || (c.trim().length() == 0)) {
        c = Util.getWifiMacAddress(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static android.location.Location getNetworkLocation(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 817
    //   4: invokestatic 636	com/tencent/stat/common/Util:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: ldc_w 683
    //   14: invokestatic 636	com/tencent/stat/common/Util:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   17: ifeq +90 -> 107
    //   20: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   23: ldc_w 818
    //   26: invokevirtual 686	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   29: aload_0
    //   30: ldc_w 688
    //   33: invokevirtual 116	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 690	android/location/LocationManager
    //   39: astore_0
    //   40: aload_0
    //   41: ldc_w 820
    //   44: invokevirtual 695	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   47: ifeq +55 -> 102
    //   50: aload_0
    //   51: ldc_w 820
    //   54: invokestatic 700	alky:a	(Landroid/location/LocationManager;Ljava/lang/String;)Landroid/location/Location;
    //   57: astore_0
    //   58: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   61: new 259	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 822
    //   71: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 705	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 686	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: getstatic 62	com/tencent/stat/common/StatCommonHelper:k	Lcom/tencent/stat/common/StatLogger;
    //   92: aload_1
    //   93: invokevirtual 360	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   96: aload_0
    //   97: areturn
    //   98: astore_1
    //   99: goto -10 -> 89
    //   102: aconst_null
    //   103: astore_0
    //   104: goto -46 -> 58
    //   107: aconst_null
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramContext	Context
    //   86	7	1	localThrowable1	Throwable
    //   98	1	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	20	86	java/lang/Throwable
    //   20	58	86	java/lang/Throwable
    //   58	84	98	java/lang/Throwable
  }
  
  public static Integer getNextEventIndexNo(Context paramContext)
  {
    int i1 = 0;
    for (;;)
    {
      int i2;
      try
      {
        if (n > 0)
        {
          i2 = n;
          if (i2 % 1000 == 0) {}
          try
          {
            i2 = n;
            if (n < 2147383647) {
              break label109;
            }
            StatPreferences.putInt(paramContext, "MTA_EVENT_INDEX", i1);
          }
          catch (Throwable paramContext)
          {
            k.w(paramContext);
            continue;
          }
          n += 1;
          i1 = n;
          return Integer.valueOf(i1);
        }
      }
      finally {}
      n = StatPreferences.getInt(paramContext, "MTA_EVENT_INDEX", 0);
      StatPreferences.putInt(paramContext, "MTA_EVENT_INDEX", n + 1000);
      continue;
      label109:
      i1 = i2 + 1000;
    }
  }
  
  public static int getNextSessionID()
  {
    return b().nextInt(2147483647);
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (Util.checkPermission(paramContext, "android.permission.GET_TASKS")) {
      return ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
    }
    k.e("Could not get permission of android.permission.GET_TASKS");
    return null;
  }
  
  public static String getProperty(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.getString(paramString);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return "";
  }
  
  public static String getRomMemory()
  {
    if (isStringValid(p)) {
      return p;
    }
    long l1 = getTotalInternalMemorySize() / 1000000L;
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = localStatFs.getBlockSize();
    l2 = localStatFs.getAvailableBlocks() * l2 / 1000000L;
    p = String.valueOf(l2) + "/" + String.valueOf(l1);
    return p;
  }
  
  public static long getSDKLongVersion(String paramString)
  {
    return convertStringToLong(paramString, ".", 100, 3, Long.valueOf(0L)).longValue();
  }
  
  public static String getSimOperator(Context paramContext)
  {
    if (g != null) {
      return g;
    }
    for (;;)
    {
      try
      {
        if (!Util.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
          continue;
        }
        if (checkPhoneState(paramContext))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            g = alla.f(paramContext);
          }
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
        continue;
      }
      return g;
      k.e("Could not get permission of android.permission.READ_PHONE_STATE");
    }
  }
  
  public static StatReportStrategy getStatSendStrategy(Context paramContext)
  {
    return StatConfig.getStatSendStrategy();
  }
  
  public static String getSystemMemory(Context paramContext)
  {
    try
    {
      long l1 = b(paramContext) / 1000000L;
      long l2 = c() / 1000000L;
      paramContext = String.valueOf(l1) + "/" + String.valueOf(l2);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getTagForConcurrentProcess(Context paramContext, String paramString)
  {
    String str = paramString;
    if (StatConfig.isEnableConcurrentProcess() == true)
    {
      if (m == null) {
        m = a(paramContext);
      }
      str = paramString;
      if (m != null) {
        str = paramString + "_" + m;
      }
    }
    return str;
  }
  
  public static Integer getTelephonyNetworkType(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int i1 = paramContext.getNetworkType();
        return Integer.valueOf(i1);
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static long getTomorrowStartMilliseconds()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      return l1 + 86400000L;
    }
    catch (Throwable localThrowable)
    {
      k.e(localThrowable);
    }
    return System.currentTimeMillis() + 86400000L;
  }
  
  public static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l1;
  }
  
  /* Error */
  public static String getUserID(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   6: ifnull +24 -> 30
    //   9: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   12: invokevirtual 752	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 430	java/lang/String:length	()I
    //   18: ifeq +12 -> 30
    //   21: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic 920	com/tencent/stat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   34: putstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   37: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   40: ifnull +15 -> 55
    //   43: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   46: invokevirtual 752	java/lang/String:trim	()Ljava/lang/String;
    //   49: invokevirtual 430	java/lang/String:length	()I
    //   52: ifne +18 -> 70
    //   55: invokestatic 833	com/tencent/stat/common/StatCommonHelper:b	()Ljava/util/Random;
    //   58: ldc_w 834
    //   61: invokevirtual 837	java/util/Random:nextInt	(I)I
    //   64: invokestatic 922	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   67: putstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   70: getstatic 40	com/tencent/stat/common/StatCommonHelper:a	Ljava/lang/String;
    //   73: astore_0
    //   74: goto -49 -> 25
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	25	77	finally
    //   30	55	77	finally
    //   55	70	77	finally
    //   70	74	77	finally
  }
  
  public static int hasRootAccess(Context paramContext)
  {
    if (j > -1) {
      return j;
    }
    j = 0;
    try
    {
      if (l.a()) {
        j = 1;
      }
      return j;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        k.e(paramContext);
      }
    }
    finally {}
  }
  
  public static boolean haveGravity(Context paramContext)
  {
    return (SensorManager)paramContext.getSystemService("sensor") != null;
  }
  
  public static boolean isApplicationBroughtToBackground(Context paramContext)
  {
    if (!Util.checkPermission(paramContext, "android.permission.GET_TASKS")) {
      return false;
    }
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    return (!localList.isEmpty()) && (!((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equals(paramContext.getPackageName()));
  }
  
  public static boolean isBackground(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equalsIgnoreCase(paramContext.getPackageName()))
      {
        k.i("isBackground processName:" + localRunningAppProcessInfo.processName + ", importance:" + localRunningAppProcessInfo.importance);
        if ((localRunningAppProcessInfo.importance == 400) || (localRunningAppProcessInfo.importance == 130)) {
          return true;
        }
        if ((localRunningAppProcessInfo.importance == 100) || (localRunningAppProcessInfo.importance == 200)) {
          return isLockScreenOn(paramContext);
        }
        return false;
      }
    }
    return false;
  }
  
  public static boolean isBackgroundRunning(Context paramContext)
  {
    if (paramContext == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return false;
          localObject = (ActivityManager)paramContext.getSystemService("activity");
        } while (localObject == null);
        paramContext = paramContext.getPackageName();
        localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while (!localRunningAppProcessInfo.processName.startsWith(paramContext));
    if (localRunningAppProcessInfo.importance == 400) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isLockScreenOn(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean isSpecifyReportedValid(StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (paramStatSpecifyReportedInfo == null) {
      return false;
    }
    return isStringValid(paramStatSpecifyReportedInfo.getAppKey());
  }
  
  public static boolean isStringValid(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  /* Error */
  public static int isTheFirstTimeActivate(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 86	com/tencent/stat/common/StatCommonHelper:u	I
    //   6: iconst_m1
    //   7: if_icmpeq +12 -> 19
    //   10: getstatic 86	com/tencent/stat/common/StatCommonHelper:u	I
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokestatic 962	com/tencent/stat/common/StatCommonHelper:checkFirstTimeActivate	(Landroid/content/Context;)V
    //   23: getstatic 86	com/tencent/stat/common/StatCommonHelper:u	I
    //   26: istore_1
    //   27: goto -13 -> 14
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramContext	Context
    //   13	14	1	i1	int
    // Exception table:
    //   from	to	target	type
    //   3	14	30	finally
    //   19	27	30	finally
  }
  
  public static boolean isWiFiActive(Context paramContext)
  {
    try
    {
      if (!Util.checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        break label71;
      }
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null) {
        break label100;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label100;
      }
      i1 = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i1;
        label71:
        k.e(paramContext);
        continue;
        i1 += 1;
      }
    }
    if (i1 < paramContext.length) {
      if ((paramContext[i1].getTypeName().equalsIgnoreCase("WIFI")) && (paramContext[i1].isConnected()))
      {
        return true;
        k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return false;
      }
    }
    label100:
    return false;
  }
  
  public static String md5sum(String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i1 = 0;
      while (i1 < paramString.length)
      {
        int i2 = paramString[i1] & 0xFF;
        if (i2 < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(i2));
        i1 += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (Throwable paramString) {}
    return "0";
  }
  
  public static boolean needCheckTime(Context paramContext)
  {
    if (v < 0L) {
      v = StatPreferences.getLong(paramContext, "mta.qq.com.checktime", 0L);
    }
    return Math.abs(System.currentTimeMillis() - v) > 86400000L;
  }
  
  public static int readDiffTimeFromServer(Context paramContext)
  {
    return StatPreferences.getInt(paramContext, "mta.qq.com.difftime", 0);
  }
  
  public static void updateCheckTime(Context paramContext)
  {
    v = System.currentTimeMillis();
    StatPreferences.putLong(paramContext, "mta.qq.com.checktime", v);
  }
  
  public static void writeDiffTimeFromServer(Context paramContext, int paramInt)
  {
    w = paramInt;
    StatPreferences.putInt(paramContext, "mta.qq.com.difftime", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.common.StatCommonHelper
 * JD-Core Version:    0.7.0.1
 */