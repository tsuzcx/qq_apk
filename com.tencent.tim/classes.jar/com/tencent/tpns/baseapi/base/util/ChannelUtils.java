package com.tencent.tpns.baseapi.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Method;

public class ChannelUtils
{
  public static Boolean isBrandXiaoMi = null;
  
  private static String a(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      Method localMethod = ((Class)localObject).getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      localObject = (String)localMethod.invoke(localObject, new Object[] { paramString });
      return localObject;
    }
    catch (Exception localException)
    {
      TBaseLogger.w("ChannelUtils", "unexpected for getSystemPropertiesKey:" + paramString);
    }
    return "";
  }
  
  public static String getMiuiVersionCode()
  {
    return a("ro.miui.ui.version.code");
  }
  
  public static String getMiuiVersionName()
  {
    return a("ro.miui.ui.version.name");
  }
  
  public static boolean isBrandBlackShark()
  {
    return "blackshark".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean isBrandHonor()
  {
    return "honor".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean isBrandHuaWei()
  {
    return "huawei".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean isBrandMeiZu()
  {
    return (!TextUtils.isEmpty(a("ro.meizu.product.model"))) || ("meizu".equalsIgnoreCase(Build.BRAND)) || ("meizu".equalsIgnoreCase(Build.MANUFACTURER)) || ("22c4185e".equalsIgnoreCase(Build.BRAND));
  }
  
  public static boolean isBrandXiaoMi()
  {
    try
    {
      if (isBrandXiaoMi == null) {
        isBrandXiaoMi = Boolean.valueOf("xiaomi".equalsIgnoreCase(Build.MANUFACTURER));
      }
      boolean bool = isBrandXiaoMi.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean isMiuiV12()
  {
    return "V12".equals(getMiuiVersionName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.ChannelUtils
 * JD-Core Version:    0.7.0.1
 */