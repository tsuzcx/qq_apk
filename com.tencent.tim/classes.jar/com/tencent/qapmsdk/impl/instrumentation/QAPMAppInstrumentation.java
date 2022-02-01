package com.tencent.qapmsdk.impl.instrumentation;

import android.content.Context;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.appstate.AppStateTimeInfo;
import com.tencent.qapmsdk.impl.appstate.QAPMActivityTrace;

public class QAPMAppInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMAppInstrumentation";
  public static QAPMActivityTrace activityTrace = new QAPMActivityTrace();
  public static AppStateTimeInfo appStateTimeInfo;
  public static volatile boolean isAppInBackground;
  
  static
  {
    try
    {
      appStateTimeInfo = AppStateTimeInfo.getInstance();
      label16:
      isAppInBackground = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label16;
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityCreateBeginIns(String paramString)
  {
    try
    {
      activityTrace.onCreateOrOnRestartEnterMethod(paramString, "#onCreate");
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityCreateBeginIns(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityCreateBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityCreateEndIns()
  {
    try
    {
      activityTrace.onCreateOrOnRestartExitMethod();
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityCreateEndIns();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityCreateEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityRestartBeginIns(String paramString)
  {
    try
    {
      activityTrace.onCreateOrOnRestartEnterMethod(paramString, "#onRestart");
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityRestartBeginIns(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityRestartBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityRestartEndIns()
  {
    activityTrace.onCreateOrOnRestartExitMethod();
    try
    {
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityRestartEndIns();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityRestartEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityResumeBeginIns(String paramString)
  {
    try
    {
      activityTrace.onResumeEnterMethod(paramString);
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityResumeBeginIns(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityResumeBeginIns() has an error :", paramString);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityResumeEndIns()
  {
    try
    {
      if (isAppInBackground) {
        appStateTimeInfo.activityResumeEndIns();
      }
      activityTrace.onResumeExitMethod();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityResumeEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void activityStartBeginIns(String paramString)
  {
    try
    {
      activityTrace.onStartEnterMethod(paramString);
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityStartBeginIns(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityStartBeginIns() has an error :", paramString);
    }
  }
  
  public static void activityStartEndIns()
  {
    try
    {
      activityTrace.onStartExitMethod();
      if (!isAppInBackground) {
        return;
      }
      appStateTimeInfo.activityStartEndIns();
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  activityStartEndIns() has an error :", localException);
    }
  }
  
  @QAPMReplaceCallSite
  public static void applicationCreateBeginIns()
  {
    try
    {
      appStateTimeInfo.applicationCreateBeginIns();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  applicationCreateBeginIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void applicationCreateEndIns()
  {
    try
    {
      appStateTimeInfo.applicationCreateEndIns();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  applicationCreateEndIns() has an error :", localThrowable);
    }
  }
  
  @QAPMReplaceCallSite
  public static void attachBaseContextBeginIns(Context paramContext)
  {
    try
    {
      appStateTimeInfo.attachBaseContextBeginIns(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  attachBaseContextBeginIns() has an error :", paramContext);
    }
  }
  
  @QAPMReplaceCallSite
  public static void attachBaseContextEndIns()
  {
    try
    {
      appStateTimeInfo.attachBaseContextEndIns();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMAppInstrumentation", "QAPMAppInstrumentation  attachBaseContextEndIns() has an error :", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation
 * JD-Core Version:    0.7.0.1
 */