package com.tencent.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppSetting
{
  private static int APP_ID = 537104606;
  private static String LC1;
  private static String aHJ;
  public static final String aHK;
  private static String aHL;
  private static final String aHM;
  private static String aHN;
  private static String aHO;
  private static String aHP;
  public static String aHQ;
  public static String aHR = Build.MANUFACTURER + "-" + Build.MODEL;
  public static boolean aNQ = true;
  public static boolean aNR;
  public static boolean aNS;
  public static boolean aNT;
  public static boolean aNU;
  private static boolean aNV;
  private static volatile boolean aNW;
  public static boolean aNX;
  public static boolean aNY;
  public static boolean aNZ;
  public static int bAd;
  public static int bAe;
  public static int bAf;
  public static int bAg;
  private static AtomicBoolean bm;
  private static String channelId;
  public static int displayWidth;
  public static boolean enableTalkBack;
  public static boolean isEnableAutoDumpLeak;
  
  static
  {
    LC1 = "F5F5D02C5CC3ED77";
    aHJ = "V 3.4.4.3058";
    aHK = aHJ;
    aHL = "3.4.4.3058.2021-11-22.1d5677cf.YingYongBao";
    aNR = true;
    aHM = Build.VERSION.RELEASE;
    channelId = "0";
    aHN = "";
    bAe = 1048576;
    aNX = true;
    aHQ = "use_msg_reflesh_delay";
    aNY = true;
    aNZ = true;
    bAf = 1000;
    bAg = bAf + 1;
  }
  
  public static boolean Nu()
  {
    if (bm == null) {
      bm = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("sso_list", 4).getBoolean("sso_list_enable_ipv6", false));
    }
    return bm.get();
  }
  
  public static boolean Nv()
  {
    return aNV;
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      return "//";
    }
    String str3 = "";
    String str5 = "";
    String str4 = "";
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    String str1 = str4;
    paramConnectivityManager = str5;
    String str2 = str3;
    if (localNetworkInfo != null)
    {
      str1 = str4;
      paramConnectivityManager = str5;
      str2 = str3;
      if (localNetworkInfo.isAvailable()) {
        switch (localNetworkInfo.getType())
        {
        case 7: 
        case 8: 
        default: 
          paramConnectivityManager = "unknown";
          str1 = "unknown";
          str2 = str3;
        }
      }
    }
    for (;;)
    {
      return paramConnectivityManager + "/" + str2 + "/" + str1;
      paramConnectivityManager = "cable";
      str1 = str4;
      str2 = str3;
      continue;
      paramConnectivityManager = "WIFI";
      str1 = str4;
      str2 = str3;
      continue;
      str2 = gP(paramTelephonyManager.getNetworkOperatorName());
      switch (paramTelephonyManager.getNetworkType())
      {
      default: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
        break;
      case 13: 
        paramConnectivityManager = "4G";
        str1 = "LTE";
        break;
      case 3: 
        paramConnectivityManager = "3G";
        str1 = "UMTS";
        break;
      case 5: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_0";
        break;
      case 6: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_A";
        break;
      case 8: 
        paramConnectivityManager = "3G";
        str1 = "SDPA";
        break;
      case 9: 
        paramConnectivityManager = "3G";
        str1 = "HSUPA";
        break;
      case 10: 
        paramConnectivityManager = "3G";
        str1 = "HSPA";
        break;
      case 12: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_B";
        break;
      case 14: 
        paramConnectivityManager = "3G";
        str1 = "EHRPD";
        break;
      case 15: 
        paramConnectivityManager = "3G";
        str1 = "HSPAP";
        break;
      case 1: 
        paramConnectivityManager = "2G";
        str1 = "GPRS";
        break;
      case 2: 
        paramConnectivityManager = "2G";
        str1 = "EDGE";
        break;
      case 4: 
        paramConnectivityManager = "2G";
        str1 = "CDMA";
        break;
      case 7: 
        paramConnectivityManager = "2G";
        str1 = "1xRTT";
        break;
      case 11: 
        paramConnectivityManager = "2G";
        str1 = "IDEN";
        break;
      case 0: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
      }
    }
  }
  
  public static String aq(Context paramContext)
  {
    int i = 0;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
    return "3.4.4." + i;
  }
  
  private static void bBK()
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getContext().getPackageManager().getApplicationInfo(BaseApplicationImpl.getContext().getPackageName(), 128);
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
      {
        localObject1 = ((ApplicationInfo)localObject1).metaData.getString("AppSetting_params");
        if (localObject1 != null) {
          tW((String)localObject1);
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject3 = null;
      }
    }
  }
  
  private static void bBL()
  {
    if ((aNQ) && (!aNW)) {
      try
      {
        if (!aNW)
        {
          bBK();
          aNW = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public static int bs(String paramString)
    throws NumberFormatException
  {
    String[] arrayOfString = "3.4.4".split("\\.");
    paramString = paramString.split("\\.");
    int i;
    int j;
    if (arrayOfString.length < paramString.length)
    {
      i = arrayOfString.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label83;
      }
      int k = Integer.parseInt(arrayOfString[j]);
      int m = Integer.parseInt(paramString[j]);
      if (k > m)
      {
        return 1;
        i = paramString.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label83:
    return 0;
  }
  
  private static String gP(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  public static final int getAppId()
  {
    bBL();
    return APP_ID;
  }
  
  public static final String getChannelId()
  {
    bBL();
    return channelId;
  }
  
  public static final String getLC()
  {
    bBL();
    return LC1;
  }
  
  public static final String getQUA()
  {
    if (aHO != null) {
      return aHO;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label302;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer(32);
      int i = 0;
      while (i < localObject2.length)
      {
        if ((localObject2[i] > ' ') && (localObject2[i] != '/') && (localObject2[i] != '_') && (localObject2[i] != '&') && (localObject2[i] != '|') && (localObject2[i] != '-')) {
          localStringBuffer.append(localObject2[i]);
        }
        i += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      aHO = "AQQ_2013 4.6/2013 3.4.43058&NA_0/000000&ADR&" + aHP + "18" + "&" + (String)localObject2 + "&" + getChannelId() + "&" + getLC() + "&" + aHM + "&" + "V3";
      return aHO;
      label302:
      str2 = "ALL";
    }
  }
  
  public static String getRevision()
  {
    return "1d5677cf";
  }
  
  public static final String getVersion()
  {
    return "android 3.4.4";
  }
  
  public static String nT()
  {
    bBL();
    return aHJ;
  }
  
  public static String nU()
  {
    bBL();
    return aHL;
  }
  
  public static String t(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    localObject2 = "";
    long l = aqgz.getSystemTotalMemory() / 1048576L;
    localObject1 = localObject2;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = localObject2;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = localObject2;
      paramContext = Pandora.getDeviceID(paramContext);
      localObject1 = paramContext;
      localObject2 = a(localTelephonyManager, localConnectivityManager);
      localObject1 = localObject2;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "//";
        localObject2 = localObject1;
      }
    }
    localStringBuffer.append((String)localObject2 + "/");
    localStringBuffer.append(getChannelId() + "/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(getAppId() + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(gP(Build.MODEL) + "/");
    localStringBuffer.append(gP(Build.BRAND) + "/");
    localStringBuffer.append(l + "/");
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(0 + "/");
    return localStringBuffer.toString();
  }
  
  public static void tW(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("#");
      APP_ID = Integer.valueOf(paramString[0]).intValue();
      LC1 = paramString[1];
      channelId = paramString[2];
      aHN = paramString[3];
    }
    if (!"".equals(aHN)) {
      aHL = "3.4.4.3058.2021-11-22.1d5677cf.YingYongBao";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */