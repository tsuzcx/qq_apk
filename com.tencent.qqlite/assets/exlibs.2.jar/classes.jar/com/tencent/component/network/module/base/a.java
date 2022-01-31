package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.IDownloadConfig;

public final class a
{
  private static IDownloadConfig a = null;
  
  public static String a()
  {
    if (a != null) {
      return a.getTerminal();
    }
    return "android";
  }
  
  public static void a(IDownloadConfig paramIDownloadConfig)
  {
    a = paramIDownloadConfig;
  }
  
  public static String b()
  {
    if (a != null) {
      return a.getVersion();
    }
    return "1.0";
  }
  
  public static String c()
  {
    if (a != null) {
      return a.getRefer();
    }
    return "tencent";
  }
  
  public static String d()
  {
    if (a != null) {
      return a.getUserAgent();
    }
    return "android-tencent";
  }
  
  public static String e()
  {
    if (a != null) {
      return a.getQUA();
    }
    return "";
  }
  
  public static long f()
  {
    if (a != null) {
      return a.getCurrentUin();
    }
    return 0L;
  }
  
  public static boolean g()
  {
    if (a != null) {
      return a.enableDns114();
    }
    return true;
  }
  
  public static int h()
  {
    if (a != null) {
      return a.photoDownloadKeepAliveConfig();
    }
    return -1;
  }
  
  public static int i()
  {
    if (a != null) {
      return a.photoDownloadKeepAliveProxyConfig();
    }
    return -1;
  }
  
  public static int j()
  {
    if (a != null) {
      return a.getOperator();
    }
    return 0;
  }
  
  public static int k()
  {
    if (a != null) {
      return a.getReportPercent();
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.a
 * JD-Core Version:    0.7.0.1
 */