package org.libpag.reporter;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class DeviceInfo
{
  private static final String TAG = "MobileBase-DeviceInfo";
  
  public static int getApiLevelInt()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public static String getBrand()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "fail";
  }
  
  public static String getDeviceName()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "fail";
  }
  
  public static String getRomFingerprint(Context paramContext)
  {
    String str = Build.FINGERPRINT;
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "Android";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.reporter.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */