package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.tencent.mobileqq.msf.sdk.n;
import java.io.File;

public class QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final String ERR_KEY = "qq_error|";
  public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
  private static final String[] PERMS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  public static final int USR = 1;
  public static String sBuildNumber = "";
  private static boolean sHasStoragePermission;
  
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
  
  public static String getLogExternalPath(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!isHasStoragePermission(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
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
  
  public static boolean isHasStoragePermission(Context paramContext)
  {
    boolean bool2 = sHasStoragePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS[0]) == 0)
        {
          sHasStoragePermission = true;
          bool1 = sHasStoragePermission;
        }
      }
    }
    return bool1;
    label48:
    sHasStoragePermission = true;
    return sHasStoragePermission;
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