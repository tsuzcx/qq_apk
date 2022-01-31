package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class SysCoreQua2Utils
{
  private static final byte CORE_TYPE_BLINK = 2;
  private static final byte CORE_TYPE_SYS = 0;
  private static final byte CORE_TYPE_X5 = 1;
  private static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String TAG = "QBInfoUtils";
  private static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  private static boolean mIsTablet = false;
  private static boolean mPadCheckFinished;
  private static String mParentPackageName;
  private static String mParentPackageVersion;
  private static String mTbsQua;
  private static String sLCID = "9397";
  
  static
  {
    mTbsQua = "";
    mParentPackageName = "PP";
    mParentPackageVersion = "PPVC";
    mPadCheckFinished = false;
  }
  
  private static void appendInfo(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static String generateQUA2(Context paramContext, byte paramByte, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    int i = 0;
    String str2 = "x5Version";
    byte b = 0;
    String str1 = "blinkVersion";
    String str3;
    switch (paramByte)
    {
    default: 
      paramByte = b;
      str3 = "11111";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QV").append("=").append("2");
      appendInfo(localStringBuilder, "PL", "ADR");
      if (paramBoolean)
      {
        appendInfo(localStringBuilder, "PR", "TBS");
        label92:
        if (0 == 0) {
          break label438;
        }
        appendInfo(localStringBuilder, "PB", "PAD");
        label105:
        appendInfo(localStringBuilder, "VE", "B1");
        if (!paramBoolean) {
          break label498;
        }
        appendInfo(localStringBuilder, "VN", paramString2);
        label127:
        if (i == 0) {
          break label510;
        }
        appendInfo(localStringBuilder, "CO", "X5");
        appendInfo(localStringBuilder, "COVN", str2);
        label150:
        if (0 == 0) {
          break label555;
        }
        appendInfo(localStringBuilder, "RF", "SDK");
      }
      break;
    }
    for (;;)
    {
      if ((paramBoolean) || (0 != 0))
      {
        appendInfo(localStringBuilder, "PP", paramString3);
        appendInfo(localStringBuilder, "PPVC", paramString4);
      }
      appendInfo(localStringBuilder, "RL", getDeviceWidth(paramContext) + "*" + getDeviceHeight(paramContext));
      paramString1 = getDeviceName();
      try
      {
        paramString2 = new String(paramString1.getBytes("UTF-8"), "ISO8859-1");
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          continue;
          if (0 != 0) {
            appendInfo(localStringBuilder, "DE", "TV");
          } else {
            appendInfo(localStringBuilder, "DE", "PHONE");
          }
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        appendInfo(localStringBuilder, "MO", paramString1);
      }
      if (!isRealPad(paramContext)) {
        break label588;
      }
      appendInfo(localStringBuilder, "DE", "PAD");
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        label302:
        break label302;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        appendInfo(localStringBuilder, "OS", paramContext);
      }
      appendInfo(localStringBuilder, "API", Build.VERSION.SDK_INT + "");
      paramContext = str3;
      if (TextUtils.isEmpty("11111")) {
        paramContext = "0";
      }
      appendInfo(localStringBuilder, "CHID", paramContext);
      appendInfo(localStringBuilder, "LCID", getLCID());
      if (0 != 0)
      {
        appendInfo(localStringBuilder, "TMSV", "1.1");
        appendInfo(localStringBuilder, "ROMN", getNewBeeROMName());
      }
      return localStringBuilder.toString();
      i = 1;
      str2 = paramString1;
      paramByte = b;
      break;
      paramByte = 1;
      str1 = paramString1;
      break;
      appendInfo(localStringBuilder, "PR", "QB");
      break label92;
      label438:
      if (0 != 0)
      {
        appendInfo(localStringBuilder, "PB", "TV");
        break label105;
      }
      if (0 != 0)
      {
        appendInfo(localStringBuilder, "PB", "INT");
        break label105;
      }
      if (0 != 0)
      {
        appendInfo(localStringBuilder, "PB", "TMS");
        break label105;
      }
      appendInfo(localStringBuilder, "PB", "GE");
      break label105;
      label498:
      appendInfo(localStringBuilder, "VN", "QBVersion");
      break label127;
      label510:
      if (paramByte != 0)
      {
        appendInfo(localStringBuilder, "CO", "Blink");
        appendInfo(localStringBuilder, "COVN", str1);
        break label150;
      }
      appendInfo(localStringBuilder, "CO", "AMTT");
      appendInfo(localStringBuilder, "COVN", paramString1);
      break label150;
      label555:
      if (0 != 0) {
        appendInfo(localStringBuilder, "RF", "LAPP");
      } else {
        appendInfo(localStringBuilder, "RF", "PRI");
      }
    }
  }
  
  private static String getAndroidOsSystemProperties(String paramString)
  {
    try
    {
      paramString = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      if (paramString != null) {
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    return paramString;
  }
  
  private static int getDensityDpi(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi;
  }
  
  private static int getDeviceHeight(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  private static String getDeviceName()
  {
    return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  private static int getDeviceWidth(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private static String getLCID()
  {
    return sLCID;
  }
  
  private static String getNewBeeROMName()
  {
    return getAndroidOsSystemProperties("ro.build.version.newbee.display");
  }
  
  public static String getQUA2(Context paramContext)
  {
    if (!mTbsQua.equals("")) {
      return mTbsQua;
    }
    Object localObject1 = paramContext.getApplicationInfo();
    try
    {
      Object localObject2 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0);
      mParentPackageName = ((ApplicationInfo)localObject1).packageName;
      mParentPackageVersion = String.valueOf(((PackageInfo)localObject2).versionCode);
      localObject1 = null;
      if (mParentPackageName.equals("com.tencent.mm")) {
        localObject1 = AppUtil.getAppMetadata(paramContext.getApplicationContext(), "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      }
      localObject2 = mParentPackageName;
      if (localObject1 != null)
      {
        mTbsQua = generateQUA2(paramContext, (byte)0, "0", true, "2.0.0.1044", (String)localObject2, (String)localObject1);
        return mTbsQua;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        String str = mParentPackageVersion;
      }
    }
  }
  
  private static boolean isRealPad(Context paramContext)
  {
    if (mPadCheckFinished) {
      return mIsTablet;
    }
    if (Math.min(getDeviceWidth(paramContext), getDeviceHeight(paramContext)) * 160 / getDensityDpi(paramContext) >= 700) {}
    for (boolean bool = true;; bool = false)
    {
      mIsTablet = bool;
      mPadCheckFinished = true;
      return mIsTablet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.SysCoreQua2Utils
 * JD-Core Version:    0.7.0.1
 */