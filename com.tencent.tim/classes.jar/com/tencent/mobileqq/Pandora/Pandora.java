package com.tencent.mobileqq.Pandora;

import android.content.Context;
import com.tencent.mobileqq.Pandora.application.ApplicationManager;
import com.tencent.mobileqq.Pandora.deviceInfo.DeviceInfoManager;
import com.tencent.mobileqq.Pandora.deviceInfo.MacManager;
import com.tencent.mobileqq.Pandora.util.BackgroundUtil;
import java.util.List;

public class Pandora
{
  private static final String TAG = "Pandora";
  
  public static String getAndroidID(Context paramContext)
  {
    return DeviceInfoManager.getAndroidID(paramContext);
  }
  
  public static List<String> getApplicationList(Context paramContext)
  {
    return ApplicationManager.getApplicationList(paramContext);
  }
  
  public static String getDeviceID(Context paramContext)
  {
    return DeviceInfoManager.getsDeviceId(paramContext);
  }
  
  public static String getDeviceID(Context paramContext, int paramInt)
  {
    return DeviceInfoManager.getsDeviceId(paramContext, paramInt);
  }
  
  public static String getImei(Context paramContext)
  {
    return DeviceInfoManager.getIMEI(paramContext);
  }
  
  public static String getImei(Context paramContext, int paramInt)
  {
    return DeviceInfoManager.getIMEI(paramContext, paramInt);
  }
  
  public static String getImsi(Context paramContext)
  {
    return DeviceInfoManager.getImsi(paramContext);
  }
  
  public static String getMac(Context paramContext)
  {
    return MacManager.getMac(paramContext);
  }
  
  public static String getMeid(Context paramContext)
  {
    return DeviceInfoManager.getMeid(paramContext);
  }
  
  public static String getMeid(Context paramContext, int paramInt)
  {
    return DeviceInfoManager.getMeid(paramContext, paramInt);
  }
  
  public static String getRealMac(Context paramContext)
  {
    return MacManager.getRealMac(paramContext);
  }
  
  public static void onApplicationBackground(Context paramContext)
  {
    BackgroundUtil.onApplicationBackground(paramContext);
  }
  
  public static void onApplicationForeground(Context paramContext)
  {
    BackgroundUtil.onApplicationForeground(paramContext);
  }
  
  public static boolean setImsi(Context paramContext, int paramInt, String paramString)
  {
    return DeviceInfoManager.setImsi(paramContext, paramInt, paramString);
  }
  
  public static boolean setImsi(Context paramContext, String paramString)
  {
    return DeviceInfoManager.setImsi(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.Pandora
 * JD-Core Version:    0.7.0.1
 */