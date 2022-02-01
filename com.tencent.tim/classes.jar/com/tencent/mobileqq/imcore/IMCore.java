package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import mqq.app.AppRuntime;

public class IMCore
{
  private static IMCoreProxyRoute.GetStaticProxy<AppRuntime> appRuntime;
  private static boolean isInit;
  
  public static AppRuntime getAppRuntime()
  {
    if ((isInit) && (appRuntime != null) && (appRuntime.get() != null)) {
      return (AppRuntime)appRuntime.get();
    }
    throw new RuntimeException("Init IMCore Fail, AppRuntime==null ");
  }
  
  public static void init(IMCoreProxyRoute.GetStaticProxy<AppRuntime> paramGetStaticProxy)
  {
    if (isInit) {
      return;
    }
    appRuntime = paramGetStaticProxy;
    isInit = true;
  }
  
  public static boolean isInit()
  {
    return isInit;
  }
  
  public static void syncAppSetting(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    com.tencent.mobileqq.imcore.constants.AppSetting.isPublicVersion = paramBoolean1;
    com.tencent.mobileqq.imcore.constants.AppSetting.isDebugVersion = paramBoolean2;
    com.tencent.mobileqq.imcore.constants.AppSetting.isGrayVersion = paramBoolean3;
    com.tencent.mobileqq.imcore.constants.AppSetting.isGooglePlayVersion = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCore
 * JD-Core Version:    0.7.0.1
 */