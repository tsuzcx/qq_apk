package com.tencent.qphone.base.util;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.msf.sdk.n;

public class QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final String ERR_KEY = "qq_error|";
  public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
  public static final int USR = 1;
  public static String sBuildNumber = "";
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    n.d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    n.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public static void doReportLogSelf(int paramInt, String paramString1, String paramString2)
  {
    n.a(paramInt, paramString1, paramString2);
  }
  
  public static void dumpCacheToFile() {}
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    n.a(paramString1, paramInt, paramString2, null);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    n.a(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public static void endColorLog(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString)
  {
    n.a(paramArrayOfString, paramInt, paramBoolean, paramString);
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    n.c(paramString1, paramInt, paramString2, null);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    n.c(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public static void init(Context paramContext)
  {
    n.a(paramContext);
  }
  
  public static boolean isColorLevel()
  {
    return n.f();
  }
  
  public static boolean isDevelopLevel()
  {
    return n.g();
  }
  
  public static void p(String paramString1, String paramString2)
  {
    n.a(paramString1, paramString2);
  }
  
  public static void setLogToFile(boolean paramBoolean)
  {
    n.a(paramBoolean);
  }
  
  public static void startColorLog(String[] paramArrayOfString)
  {
    n.a(paramArrayOfString);
  }
  
  public static void syncReportLogSelf(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    n.a(paramInt, paramString1, paramString2, paramString3);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    n.b(paramString1, paramInt, paramString2, null);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    n.b(paramString1, paramInt, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog
 * JD-Core Version:    0.7.0.1
 */