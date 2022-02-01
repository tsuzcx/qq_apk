package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.a.a;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class AppNetConnInfo
{
  public static final int IPV4 = 1;
  public static final int IPV4V6 = 3;
  public static final int IPV6 = 2;
  public static final int IP_NONE = 0;
  public static final int MOBILE_2G = 1;
  public static final int MOBILE_3G = 2;
  public static final int MOBILE_4G = 3;
  public static final int MOBILE_5G = 4;
  public static final int MOBILE_NONE = -1;
  public static final int MOBILE_UNKNOWN = 0;
  public static final int NET_MOBILE = 0;
  public static final int NET_NONE = -1;
  public static final int NET_WIFI = 1;
  public static final int NET_WIFI_NEEDAUTH = 2;
  private static d impl = new d();
  
  public static void checkNetEvent()
  {
    impl.a(null, false);
  }
  
  public static int getConnInfo()
  {
    impl.a();
    return impl.g() - 1;
  }
  
  public static String getCurrentAPN()
  {
    impl.a();
    return impl.c();
  }
  
  public static d getImpl()
  {
    return impl;
  }
  
  public static int getMobileInfo()
  {
    impl.a();
    return impl.f();
  }
  
  public static NetworkInfo getRecentNetworkInfo()
  {
    impl.a();
    return impl.i();
  }
  
  public static String getSubtypeName()
  {
    impl.a();
    return impl.b().h();
  }
  
  public static int getSystemNetworkType()
  {
    impl.a();
    return impl.j();
  }
  
  public static boolean isMobileConn()
  {
    impl.a();
    return impl.e();
  }
  
  public static boolean isNetSupport()
  {
    impl.a();
    return impl.h();
  }
  
  public static boolean isWifiConn()
  {
    impl.a();
    return impl.d();
  }
  
  public static void registerConnectionChangeReceiver(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    impl.a();
    impl.a(paramContext, paramINetInfoHandler);
  }
  
  public static void registerNetChangeReceiver(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    impl.a();
    impl.a(paramContext, paramINetEventHandler);
  }
  
  public static boolean unregisterNetEventHandler(INetEventHandler paramINetEventHandler)
  {
    impl.a();
    return impl.a(paramINetEventHandler);
  }
  
  public static boolean unregisterNetInfoHandler(INetInfoHandler paramINetInfoHandler)
  {
    impl.a();
    return impl.a(paramINetInfoHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.AppNetConnInfo
 * JD-Core Version:    0.7.0.1
 */