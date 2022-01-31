package com.tencent.smtt.sdk;

public class QbSdkLog
{
  private static QbSdkLogClient mQbSdkLogClient = null;
  
  static
  {
    if (mQbSdkLogClient == null) {
      setQbSdkLogClient(new QbSdkLogClient());
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    mQbSdkLogClient.d(paramString1, "QB_SDK:" + paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    mQbSdkLogClient.e(paramString1, "QB_SDK:" + paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    mQbSdkLogClient.i(paramString1, "QB_SDK:" + paramString2);
  }
  
  public static boolean setQbSdkLogClient(QbSdkLogClient paramQbSdkLogClient)
  {
    if (paramQbSdkLogClient == null) {
      return false;
    }
    mQbSdkLogClient = paramQbSdkLogClient;
    return true;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    mQbSdkLogClient.v(paramString1, "QB_SDK:" + paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    mQbSdkLogClient.w(paramString1, "QB_SDK:" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdkLog
 * JD-Core Version:    0.7.0.1
 */