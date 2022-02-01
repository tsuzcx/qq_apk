package com.tencent.qapmsdk.battery;

import android.os.Bundle;
import android.os.Process;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;

public abstract class BatteryUsageItem
{
  public static final int ACTION_CMD_ALARM = 7;
  public static final int ACTION_CPU = 0;
  public static final int ACTION_GPS_SDK_USE = 1;
  public static final int ACTION_GPS_SYS_USE = 2;
  public static final int ACTION_LOG_ALARM = 6;
  public static final int ACTION_WIFI_LOCK_NOT_RELEASE = 10;
  public static final int ACTION_WIFI_LOCK_TIMEOUT = 11;
  public static final int ACTION_WIFI_LOCK_USE = 9;
  public static final int ACTION_WIFI_SCAN = 8;
  public static final int ACTION_WL_NOT_RELEASE = 4;
  public static final int ACTION_WL_TIMEOUT = 5;
  public static final int ACTION_WL_USE = 3;
  public static final int EXCEPTION_HIGH_FREQUENCY = 0;
  public static final int EXCEPTION_NOT_CLOSE = 2;
  public static final int EXCEPTION_TIMEOUT = 1;
  public static final String KEY_ACTION = "key_action";
  public static final int LEVEL_HEAVY = 1;
  public static final int LEVEL_LIGHT = 0;
  public static final int TYPE_CMD = 3;
  public static final int TYPE_GPS = 6;
  public static final int TYPE_LOG = 2;
  public static final int TYPE_WAKE_LOCK = 4;
  public static final int TYPE_WIFI = 5;
  public static String[] sAppIgnoreFrameDict = { BatteryMonitor.class.getName() };
  public static String[] sSysFramePrefixs = { "android.", "com.android.", "dalvik.", "com.google.", "sun.", "com.qihoo360", "com.lbe", "java." };
  public boolean isAppBackground = false;
  public boolean isBeforeRun30Min = true;
  public boolean isInFirstBg5min = false;
  public boolean isRunning = true;
  
  public static StringBuilder getAppStack()
  {
    StringBuilder localStringBuilder = BatteryLog.getReuseStringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = arrayOfStackTraceElement.length - 1;
    if (i >= 0)
    {
      String str = arrayOfStackTraceElement[i].toString();
      if (isAppStackFrame(str))
      {
        if (localStringBuilder.length() != 0) {
          break label61;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i -= 1;
        break;
        label61:
        localStringBuilder.append(",");
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("]");
    }
    return localStringBuilder;
  }
  
  public static boolean isAppStackFrame(String paramString)
  {
    String[] arrayOfString = sSysFramePrefixs;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    arrayOfString = sAppIgnoreFrameDict;
    j = arrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      if (paramString.contains(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  public boolean isHookReady()
  {
    return BatteryMonitor.getInstance().isHookReady;
  }
  
  public boolean isInQQProcess()
  {
    return true;
  }
  
  public void onAppBackground()
  {
    this.isAppBackground = true;
    if (!BatteryMonitor.getInstance().isHasAppBg5Min()) {
      this.isInFirstBg5min = true;
    }
  }
  
  public void onAppForeground()
  {
    this.isAppBackground = false;
    this.isInFirstBg5min = false;
  }
  
  public void onHookReady() {}
  
  public abstract void onOtherProcReport(Bundle paramBundle);
  
  public void onProcessBG5Min()
  {
    this.isInFirstBg5min = false;
  }
  
  public void onProcessRun30Min()
  {
    this.isBeforeRun30Min = false;
  }
  
  public abstract void onProcessStart();
  
  public void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  public void printLog(String paramString)
  {
    printLog(paramString, false);
  }
  
  public void printLog(String paramString, boolean paramBoolean)
  {
    if ((Logger.debug) || (paramBoolean)) {
      Logger.INSTANCE.d(new String[] { paramString });
    }
    BatteryMonitor.IBatteryStatsCallback localIBatteryStatsCallback = BatteryMonitor.getInstance().callback;
    if (localIBatteryStatsCallback != null) {
      localIBatteryStatsCallback.onPrintLog(paramString);
    }
  }
  
  public void stop()
  {
    this.isRunning = false;
  }
  
  public void writeCommonLog(int paramInt, String... paramVarArgs)
  {
    if (!this.isRunning) {
      return;
    }
    long l = (System.currentTimeMillis() - BatteryConstants.BATTERY_START_TIME) / 1000L;
    BatteryLog.writeCommonLog(new Object[] { BaseInfo.userMeta.uin, Integer.valueOf(paramInt), Long.valueOf(l), paramVarArgs });
  }
  
  public void writeCommonLog(String... paramVarArgs)
  {
    writeCommonLog(Process.myPid(), paramVarArgs);
  }
  
  protected void writeReportLog(String... paramVarArgs)
  {
    BatteryLog.writeReportLog(new Object[] { Long.valueOf(System.currentTimeMillis()), paramVarArgs });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.BatteryUsageItem
 * JD-Core Version:    0.7.0.1
 */