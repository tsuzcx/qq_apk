package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.d;
import com.tencent.feedback.common.f;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.feedback.proguard.p;
import com.tencent.feedback.proguard.u;
import com.tencent.feedback.upload.UploadHandleListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class CrashReport
{
  public static boolean addPlugin(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    com.tencent.feedback.common.c localc2 = com.tencent.feedback.common.c.p();
    com.tencent.feedback.common.c localc1 = localc2;
    if (localc2 == null)
    {
      com.tencent.feedback.common.c.a(paramContext, "10000", "unknown");
      localc1 = com.tencent.feedback.common.c.p();
    }
    paramContext = paramString3;
    if (paramString3 == null) {
      paramContext = "";
    }
    return localc1.a(paramString1, paramString2, paramContext);
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    f.c(paramContext);
  }
  
  public static int countExceptionDatas(Context paramContext)
  {
    if (!e.m()) {
      return -1;
    }
    paramContext = e.k();
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      return -1;
    }
    return paramContext.g();
  }
  
  public static int countStoredRecord(Context paramContext)
  {
    return c.a(paramContext);
  }
  
  public static boolean doUploadExceptionDatas()
  {
    return e.l();
  }
  
  public static CrashStrategyBean getCrashRuntimeStrategy()
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = e.k().q();
      return localCrashStrategyBean;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = f.b(paramContext);
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      return paramContext.d + paramContext.e;
    }
    return -1L;
  }
  
  public static boolean handleCatchException(Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte)
  {
    return e.a(paramThread, paramThrowable, paramString, paramArrayOfByte);
  }
  
  public static void initCrashReport(Context paramContext)
  {
    initCrashReport(paramContext, null, null, true, null);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean)
  {
    e.a(paramContext, "10000", false, e.a(paramContext, paramBoolean), paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean, long paramLong)
  {
    if (paramLong > 0L)
    {
      long l = paramLong;
      if (paramLong > 10000L) {
        l = 10000L;
      }
      u.a(l);
    }
    e.a(paramContext, "10000", false, e.a(paramContext, paramBoolean), paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
  }
  
  public static void initCrashReport(Context paramContext, boolean paramBoolean)
  {
    e.a(paramContext, "10000", false, e.a(paramContext, paramBoolean), null, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, paramList, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List<File> paramList, File paramFile)
  {
    if (paramFile != null)
    {
      if (!NativeExceptionUpload.loadRQDNativeLib(paramFile))
      {
        com.tencent.feedback.common.e.d("load lib fail %s close native return!", new Object[] { paramFile.getAbsoluteFile() });
        return;
      }
      com.tencent.feedback.common.e.a("load lib sucess from specify!", new Object[0]);
    }
    label306:
    label311:
    label315:
    for (;;)
    {
      NativeExceptionUpload.setmHandler(com.tencent.feedback.eup.jni.b.a(paramContext));
      Object localObject = paramList;
      if (paramFile != null)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramFile);
      }
      label98:
      boolean bool2;
      if ((paramContext == null) || (paramString == null))
      {
        com.tencent.feedback.common.e.c("rqdp{  nreg param!}", new Object[0]);
        d.a(paramContext);
        paramList = d.d();
        d.a(paramContext);
        NativeExceptionUpload.registEUP(paramString, paramList, Integer.parseInt(d.c()));
        NativeExceptionUpload.enableNativeEUP(true);
        if (!paramBoolean) {
          break label306;
        }
        NativeExceptionUpload.setNativeLogMode(3);
        return;
        if (paramList == null) {
          break label311;
        }
        bool2 = NativeExceptionUpload.loadRQDNativeLib(paramList);
        bool1 = bool2;
        if (bool2) {
          com.tencent.feedback.common.e.a("load lib sucess from list!", new Object[0]);
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if (bool1) {
          break label315;
        }
        if (!NativeExceptionUpload.loadRQDNativeLib())
        {
          com.tencent.feedback.common.e.d("load lib fail default close native return!", new Object[0]);
          return;
        }
        com.tencent.feedback.common.e.a("load lib sucess default!", new Object[0]);
        break;
        paramList = e.k().q();
        long l1 = com.tencent.feedback.proguard.a.b();
        long l2 = paramList.getRecordOverDays() * 24 * 3600 * 1000;
        int i = paramList.getMaxStoredNum();
        com.tencent.feedback.common.b.b().a(new com.tencent.feedback.eup.jni.c(paramString, l1 - l2, i));
        paramList = "/data/data/" + paramContext.getPackageName() + "/lib/";
        com.tencent.feedback.common.b.b().a(new com.tencent.feedback.eup.jni.a(paramContext, paramList, (List)localObject));
        break label98;
        NativeExceptionUpload.setNativeLogMode(5);
        return;
      }
    }
  }
  
  public static void removePlugin(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      com.tencent.feedback.common.c localc2 = com.tencent.feedback.common.c.p();
      com.tencent.feedback.common.c localc1 = localc2;
      if (localc2 == null)
      {
        com.tencent.feedback.common.c.a(paramContext, "10000", "unknown");
        localc1 = com.tencent.feedback.common.c.p();
      }
      localc1.d(paramString);
    }
  }
  
  public static void setCrashReportAble(boolean paramBoolean)
  {
    e locale = e.k();
    if (locale != null) {
      locale.a(paramBoolean);
    }
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.feedback.common.e.a = paramBoolean1;
    com.tencent.feedback.common.e.b = paramBoolean2;
  }
  
  public static void setNativeCrashReportAble(boolean paramBoolean)
  {
    NativeExceptionUpload.enableNativeEUP(paramBoolean);
  }
  
  public static void setThreadPoolService(ScheduledExecutorService paramScheduledExecutorService)
  {
    com.tencent.feedback.common.b.a(com.tencent.feedback.common.b.a(paramScheduledExecutorService));
  }
  
  public static void setUserId(Context paramContext, String paramString)
  {
    com.tencent.feedback.common.c localc = com.tencent.feedback.common.c.p();
    if (localc == null)
    {
      com.tencent.feedback.common.c.a(paramContext, paramString, "unknown");
      com.tencent.feedback.common.c.p();
      return;
    }
    localc.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport
 * JD-Core Version:    0.7.0.1
 */