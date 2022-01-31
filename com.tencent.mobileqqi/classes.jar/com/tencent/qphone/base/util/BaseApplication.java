package com.tencent.qphone.base.util;

import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import java.util.ArrayList;

public abstract class BaseApplication
  extends Application
{
  public static int appnewavmsgicon;
  public static int appnewmsgicon = 0;
  static Context context;
  public static int defaultNotifSoundResourceId = 0;
  public static int devlockQuickloginIcon = 0;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static MonitorSocketStat monitor;
  public static int qqlaunchicon;
  public static int qqwifiicon;
  
  static
  {
    appnewavmsgicon = 0;
    qqlaunchicon = 0;
    qqwifiicon = 0;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static int getDefaultNotifSoundResourceId()
  {
    return defaultNotifSoundResourceId;
  }
  
  public static int getDevlockQuickloginIcon()
  {
    return devlockQuickloginIcon;
  }
  
  public static MonitorSocketStat getMonitor()
  {
    return monitor;
  }
  
  public static int getQQLaunchIcon()
  {
    return qqlaunchicon;
  }
  
  public static int getQQNewAVMsgIcon()
  {
    return appnewavmsgicon;
  }
  
  public static int getQQNewMsgIcon()
  {
    return appnewmsgicon;
  }
  
  public static int getQQWiFiIcon()
  {
    return qqwifiicon;
  }
  
  public void onCreate()
  {
    super.onCreate();
    context = this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */