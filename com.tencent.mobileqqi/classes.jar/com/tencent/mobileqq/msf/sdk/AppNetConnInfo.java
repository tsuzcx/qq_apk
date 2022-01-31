package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class AppNetConnInfo
{
  public static int getConnInfo()
  {
    return a.c();
  }
  
  public static String getCurrentAPN()
  {
    return a.g();
  }
  
  public static String getSubtypeName()
  {
    return a.h();
  }
  
  public static boolean isMobileConn()
  {
    return a.e();
  }
  
  public static boolean isNeedWifiAuth()
  {
    return a.f();
  }
  
  public static boolean isNetSupport()
  {
    return a.b();
  }
  
  public static boolean isWifiConn()
  {
    return a.d();
  }
  
  public static void registerConnectionChangeReceiver(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    a.a(paramContext, paramINetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.AppNetConnInfo
 * JD-Core Version:    0.7.0.1
 */