package moai.core.utilities.deviceutil;

import alkx;
import alkz;
import alla;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.log.MLog;
import moai.log.MLogManager;

public class Devices
{
  public static String TAG = "Devices";
  private static DeviceInfo info;
  private static final MLog logger = MLogManager.getLogger("moailog");
  private static final String separator = "";
  
  public static String GetHostIp()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Enumeration localEnumeration1 = alkz.getNetworkInterfaces();
      while (localEnumeration1.hasMoreElements())
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
      logger.d(TAG, "GetHostIp err:" + localException.toString());
      return "";
    }
    String str;
    return str;
  }
  
  public static String generateDeviceId(DeviceInfo paramDeviceInfo)
  {
    Object localObject2 = paramDeviceInfo.DEVICE_ID;
    String str1 = paramDeviceInfo.BOARD;
    String str2 = paramDeviceInfo.BRAND;
    String str3 = paramDeviceInfo.CPU_ABI;
    String str4 = paramDeviceInfo.DEVICE;
    String str5 = paramDeviceInfo.DISPLAY;
    String str6 = paramDeviceInfo.HOST;
    String str7 = paramDeviceInfo.ID;
    String str8 = paramDeviceInfo.MANUFACTURER;
    String str13 = paramDeviceInfo.MODEL;
    String str9 = paramDeviceInfo.PRODUCT;
    String str10 = paramDeviceInfo.TYPE;
    String str11 = paramDeviceInfo.USER;
    String str12 = paramDeviceInfo.TAGS;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "111111111111111";
    }
    str13 = str13.toLowerCase();
    int i = 0;
    if (i < ((String)localObject1).length()) {
      if ((((String)localObject1).charAt(i) >= '0') && (((String)localObject1).charAt(i) <= '9')) {}
    }
    for (i = 0;; i = 1)
    {
      if (((String)localObject1).length() < 15)
      {
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= 15 - ((String)localObject1).length()) {
            break;
          }
          localObject1 = (String)localObject1 + "0";
          j += 1;
        }
        i += 1;
        break;
      }
      localObject2 = localObject1;
      localObject1 = new StringBuilder();
      if ((i != 0) && (str13.indexOf("sdk") < 0) && (!((String)localObject2).equals("000000000000000"))) {
        ((StringBuilder)localObject1).append(35).append(str1.length() % 10).append(str2.length() % 10).append(str3.length() % 10).append(str4.length() % 10).append(str5.length() % 10).append(str6.length() % 10).append((String)localObject2).append(str7.length() % 10).append(str8.length() % 10).append(str13.length() % 10).append(str9.length() % 10).append(str12.length() % 10).append(str10.length() % 10).append(str11.length() % 10);
      }
      for (;;)
      {
        localObject1 = ((StringBuilder)localObject1).toString();
        logger.d(TAG, "generate result:" + (String)localObject1 + "," + paramDeviceInfo.toString());
        return localObject1;
        localObject2 = str1.length() % 10 + str2.length() % 10 + str3.length() % 10 + str4.length() % 10 + str5.length() % 10 + str6.length() % 10 + str7.length() % 10 + str8.length() % 10 + str13.length() % 10 + str9.length() % 10 + str12.length() % 10 + str10.length() % 10 + str11.length() % 10;
        ((StringBuilder)localObject1).append(35).append((String)localObject2).append((String)localObject2);
      }
    }
  }
  
  private static String getAvailMemory(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return "free:" + 1.0D * localMemoryInfo.availMem / 1024.0D / 1024.0D + "MB";
  }
  
  public static String getBrand()
  {
    if (getBuildProperty("ro.qrom.build.brand", "").equalsIgnoreCase("tos")) {
      return "tos";
    }
    return getBuildProperty("ro.product.brand", "null").trim();
  }
  
  /* Error */
  public static String getBuildProperty(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 226	java/io/FileInputStream
    //   5: dup
    //   6: new 228	java/io/File
    //   9: dup
    //   10: invokestatic 234	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   13: ldc 236
    //   15: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokespecial 242	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_2
    //   22: new 244	java/util/Properties
    //   25: dup
    //   26: invokespecial 245	java/util/Properties:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual 249	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   35: aload_3
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 252	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull +66 -> 109
    //   46: ldc 13
    //   48: astore_0
    //   49: aload_0
    //   50: astore_3
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_2
    //   56: invokevirtual 255	java/io/FileInputStream:close	()V
    //   59: aload_0
    //   60: astore_3
    //   61: aload_3
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_1
    //   67: astore_3
    //   68: aload_2
    //   69: ifnull -8 -> 61
    //   72: aload_2
    //   73: invokevirtual 255	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore_0
    //   79: aload_1
    //   80: areturn
    //   81: astore_0
    //   82: aload_3
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 255	java/io/FileInputStream:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: areturn
    //   97: astore_1
    //   98: goto -6 -> 92
    //   101: astore_0
    //   102: goto -18 -> 84
    //   105: astore_0
    //   106: goto -40 -> 66
    //   109: goto -60 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString1	String
    //   0	112	1	paramString2	String
    //   21	68	2	localObject1	Object
    //   1	82	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	63	java/io/IOException
    //   72	76	78	java/io/IOException
    //   2	22	81	finally
    //   55	59	94	java/io/IOException
    //   88	92	97	java/io/IOException
    //   22	42	101	finally
    //   22	42	105	java/io/IOException
  }
  
  public static float getDensity(Context paramContext)
  {
    return getDisplayMetrics(paramContext).density;
  }
  
  public static DeviceInfo getDeviceInfos(Context paramContext)
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
        break label138;
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
          logger.e(TAG, "read device info err : " + localException.toString());
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    label138:
    Object localObject2 = new DeviceInfo();
    ((DeviceInfo)localObject2).ID = ((String)localHashMap.get("ID"));
    ((DeviceInfo)localObject2).BOARD = ((String)localHashMap.get("BOARD"));
    ((DeviceInfo)localObject2).BOOTLOADER = ((String)localHashMap.get("BOOTLOADER"));
    ((DeviceInfo)localObject2).BRAND = ((String)localHashMap.get("BRAND"));
    ((DeviceInfo)localObject2).CPU_ABI = ((String)localHashMap.get("CPU_ABI"));
    ((DeviceInfo)localObject2).CPU_ABI2 = ((String)localHashMap.get("CPU_ABI2"));
    ((DeviceInfo)localObject2).DEVICE = ((String)localHashMap.get("DEVICE"));
    ((DeviceInfo)localObject2).DISPLAY = ((String)localHashMap.get("DISPLAY"));
    ((DeviceInfo)localObject2).FINGERPRINT = ((String)localHashMap.get("FINGERPRINT"));
    ((DeviceInfo)localObject2).HARDWARE = ((String)localHashMap.get("HARDWARE"));
    ((DeviceInfo)localObject2).IS_DEBUGGABLE = ((String)localHashMap.get("IS_DEBUGGABLE"));
    ((DeviceInfo)localObject2).MANUFACTURER = ((String)localHashMap.get("MANUFACTURER"));
    ((DeviceInfo)localObject2).MODEL = ((String)localHashMap.get("MODEL"));
    ((DeviceInfo)localObject2).PRODUCT = ((String)localHashMap.get("PRODUCT"));
    ((DeviceInfo)localObject2).RADIO = ((String)localHashMap.get("RADIO"));
    ((DeviceInfo)localObject2).sdkIntVersion = String.valueOf(Build.VERSION.SDK_INT);
    ((DeviceInfo)localObject2).SERIAL = ((String)localHashMap.get("SERIAL"));
    ((DeviceInfo)localObject2).TAGS = ((String)localHashMap.get("TAGS"));
    ((DeviceInfo)localObject2).TIME = ((String)localHashMap.get("TIME"));
    ((DeviceInfo)localObject2).TYPE = ((String)localHashMap.get("TYPE"));
    ((DeviceInfo)localObject2).USER = ((String)localHashMap.get("USER"));
    ((DeviceInfo)localObject2).HOST = ((String)localHashMap.get("HOST"));
    if (Build.VERSION.RELEASE == null) {}
    for (String str1 = "";; str1 = Build.VERSION.RELEASE)
    {
      ((DeviceInfo)localObject2).releaseVersion = str1;
      ((DeviceInfo)localObject2).userAgent = System.getProperty("http.agent");
      ((DeviceInfo)localObject2).IMEI = getFakeIMEI(paramContext);
      ((DeviceInfo)localObject2).DEVICE_ID = getFakeIMEI(paramContext);
      ((DeviceInfo)localObject2).APP_DEVICE_ID = generateDeviceId((DeviceInfo)localObject2);
      info = (DeviceInfo)localObject2;
      return info;
    }
  }
  
  public static String getDeviceescription(Context paramContext)
  {
    paramContext = getDeviceInfos(paramContext);
    return paramContext.MANUFACTURER + "" + paramContext.DEVICE + "" + paramContext.MODEL + "";
  }
  
  private static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static String getFakeIMEI(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      paramContext = alla.a((TelephonyManager)paramContext.getSystemService("phone"));
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        localObject = alla.getString(paramContext.getContentResolver(), "android_id");
        if (localObject == null) {
          break;
        }
        paramContext = (Context)localObject;
      } while (!"9774d56d682e549c".equals(localObject));
      paramContext = Build.SERIAL;
      localObject = paramContext;
      if (!legal(paramContext)) {
        localObject = getWifiMacAddress();
      }
      paramContext = (Context)localObject;
    } while (legal((String)localObject));
    return "0";
  }
  
  public static String getInnerMemSpaceLog(Context paramContext)
  {
    return getAvailMemory(paramContext) + "," + getTotalMemory();
  }
  
  public static List<AppInfo> getInstalledApps(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    List localList = alkx.a(paramContext, 0);
    int i = 0;
    while (i < localList.size())
    {
      PackageInfo localPackageInfo = (PackageInfo)localList.get(i);
      AppInfo localAppInfo = new AppInfo();
      localAppInfo.appName = localPackageInfo.applicationInfo.loadLabel(paramContext).toString();
      localAppInfo.packageName = localPackageInfo.packageName;
      localAppInfo.versionName = localPackageInfo.versionName;
      localAppInfo.versionCode = localPackageInfo.versionCode;
      localArrayList.add(localAppInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getReadableResolution(Context paramContext)
  {
    paramContext = getDisplayMetrics(paramContext);
    return paramContext.widthPixels + "*" + paramContext.heightPixels;
  }
  
  public static List<String> getRunningAppProcesses(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramContext.add(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName);
    }
    return paramContext;
  }
  
  private static String getSDAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getAvailableBlocks();
    return "free:" + l2 * l1 * 1.0D / 1024.0D / 1024.0D + "MB";
  }
  
  private static String getSDTotalSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getBlockCount();
    return "total:" + l2 * l1 * 1.0D / 1024.0D / 1024.0D + "MB";
  }
  
  public static String getSDcardSpaceLog()
  {
    return getSDAvailableSize() + "," + getSDTotalSize();
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    return getDisplayMetrics(paramContext).heightPixels;
  }
  
  public static float getScreenScale(Context paramContext)
  {
    return getDisplayMetrics(paramContext).scaledDensity;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    return getDisplayMetrics(paramContext).widthPixels;
  }
  
  public static int[] getScreenWidthHeight(Context paramContext)
  {
    paramContext = getDisplayMetrics(paramContext);
    return new int[] { paramContext.widthPixels, paramContext.heightPixels };
  }
  
  private static String getTotalMemory()
  {
    long l = 0L;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 256);
      try
      {
        String str1 = localBufferedReader.readLine();
        if (str1 != null)
        {
          String[] arrayOfString = str1.split("\\s+");
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str2 = arrayOfString[i];
            Log.i(str1, str2 + "/t");
            i += 1;
          }
          i = Integer.valueOf(arrayOfString[1]).intValue();
          l = i;
        }
        return "total:" + l * 1.0D / 1024.0D + "MB";
      }
      finally
      {
        localBufferedReader.close();
      }
      return "";
    }
    catch (IOException localIOException)
    {
      logger.d(TAG, "getTotalMemory err:" + localIOException.toString());
    }
  }
  
  public static String getWifiIp(Context paramContext)
  {
    return intToIp(alkz.a((WifiManager)paramContext.getSystemService("wifi")).getIpAddress());
  }
  
  private static String getWifiMacAddress()
  {
    try
    {
      Object localObject1 = Collections.list(alkz.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = alkz.a((NetworkInterface)localObject2);
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return localObject1;
        }
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static boolean isEInk()
  {
    return Build.MANUFACTURER.contains("Onyx");
  }
  
  public static boolean isPhoneRoot()
  {
    return (new File("/system/bin/su").exists()) || (new File("/system/xbin/su").exists());
  }
  
  public static boolean[] isScreenReaderActive(Context paramContext)
  {
    paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
    boolean bool = paramContext.isEnabled();
    if (Build.VERSION.SDK_INT >= 14) {
      return new boolean[] { bool, paramContext.isTouchExplorationEnabled() };
    }
    return new boolean[] { 0, 0 };
  }
  
  private static boolean legal(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.equals("")) || (paramString.contains("*")))
    {
      bool1 = false;
      return bool1;
    }
    int j = paramString.charAt(0);
    int i = 1;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label65;
      }
      bool1 = bool2;
      if (paramString.charAt(i) != j) {
        break;
      }
      i += 1;
    }
    label65:
    return false;
  }
  
  public static Bitmap takeScreenShot(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = ((Activity)paramContext).getWindow().getDecorView().getRootView();
      paramContext.buildDrawingCache();
      Bitmap localBitmap = Bitmap.createBitmap(paramContext.getWidth(), paramContext.getHeight(), Bitmap.Config.ARGB_8888);
      paramContext.draw(new Canvas(localBitmap));
      paramContext.destroyDrawingCache();
      return localBitmap;
    }
    catch (Throwable paramContext)
    {
      logger.d(TAG, "takeScreenShot fail:" + paramContext.toString());
    }
    return null;
  }
  
  public static boolean takeScreenShot(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      View localView = ((Activity)paramContext).getWindow().getDecorView().getRootView();
      localView.setDrawingCacheEnabled(true);
      paramContext = Bitmap.createBitmap(localView.getDrawingCache());
      localView.setDrawingCacheEnabled(false);
      paramString = new FileOutputStream(new File(paramString));
      paramContext.compress(Bitmap.CompressFormat.JPEG, 50, paramString);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Throwable paramContext)
    {
      logger.d(TAG, "takeScreenShot fail:" + paramContext.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.deviceutil.Devices
 * JD-Core Version:    0.7.0.1
 */