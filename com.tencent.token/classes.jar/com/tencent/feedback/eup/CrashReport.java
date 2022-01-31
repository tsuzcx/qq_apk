package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.e.a;
import com.tencent.feedback.eup.jni.NativeExceptionHandler;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.feedback.proguard.o;
import com.tencent.feedback.proguard.p;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.u;
import com.tencent.feedback.proguard.y;
import com.tencent.feedback.upload.AbstractUploadDatas;
import com.tencent.feedback.upload.UploadHandleListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class CrashReport
{
  public static boolean addPlugin(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    c localc = c.a(paramContext);
    paramContext = paramString3;
    if (paramString3 == null) {
      paramContext = "";
    }
    return localc.a(paramString1, paramString2, paramContext);
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    com.tencent.feedback.common.f.c(paramContext);
  }
  
  public static int countExceptionDatas(Context paramContext)
  {
    if (!f.o()) {
      return -1;
    }
    paramContext = f.l();
    if (paramContext == null)
    {
      e.c("rqdp{  instance == null}", new Object[0]);
      return -1;
    }
    return paramContext.g();
  }
  
  public static int countStoredRecord(Context paramContext)
  {
    return b.b(paramContext);
  }
  
  public static boolean doUploadExceptionDatas()
  {
    return f.n();
  }
  
  public static Set getAllUserDataKeys(Context paramContext)
  {
    if (paramContext == null) {
      e.c("getAllUserDataKeys args context should not be null", new Object[0]);
    }
    return c.a(paramContext).J();
  }
  
  public static CrashStrategyBean getCrashRuntimeStrategy()
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = f.l().s();
      return localCrashStrategyBean;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] getExceptionDatas(Context paramContext)
  {
    paramContext = f.m();
    if (paramContext != null)
    {
      byte[] arrayOfByte = paramContext.a(true);
      if (arrayOfByte != null) {
        paramContext.done(true);
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = com.tencent.feedback.common.f.b(paramContext);
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      long l = paramContext.d;
      return paramContext.e + l;
    }
    return -1L;
  }
  
  public static String getUserData(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      if ((paramString != null) && (paramString.trim().length() > 0)) {}
      for (int i = 0; i == 0; i = 1) {
        return c.a(paramContext).k(paramString);
      }
    }
  }
  
  public static int getUserDatasSize(Context paramContext)
  {
    if (paramContext == null) {
      e.c("getUserDatasSize args context should not be null", new Object[0]);
    }
    return c.a(paramContext).I();
  }
  
  public static int getUserSceneTagId(Context paramContext)
  {
    if (paramContext == null)
    {
      e.c("get user scene tag context is null", new Object[0]);
      return -1;
    }
    return c.a(paramContext).F();
  }
  
  public static boolean handleCatchException(Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte)
  {
    return f.a(paramThread, paramThrowable, paramString, paramArrayOfByte);
  }
  
  public static void initCrashReport(Context paramContext)
  {
    initCrashReport(paramContext, null, null, true, null);
  }
  
  public static void initCrashReport(Context paramContext, CrashHandleListener paramCrashHandleListener, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, CrashStrategyBean paramCrashStrategyBean)
  {
    f.a(paramContext, "10000", false, f.a(paramContext, paramBoolean), paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
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
    f.a(paramContext, null, false, f.a(paramContext, paramBoolean), paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
  }
  
  public static void initCrashReport(Context paramContext, boolean paramBoolean)
  {
    f.a(paramContext, "10000", false, f.a(paramContext, paramBoolean), null, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, null, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List paramList)
  {
    initNativeCrashReport(paramContext, paramString, paramBoolean, paramList, null);
  }
  
  public static void initNativeCrashReport(Context paramContext, String paramString, boolean paramBoolean, List paramList, File paramFile)
  {
    if (com.tencent.feedback.eup.jni.b.a() != null)
    {
      e.a("already inited Native", new Object[0]);
      return;
    }
    Object localObject;
    if (paramFile != null)
    {
      if (!NativeExceptionUpload.loadRQDNativeLib(paramFile))
      {
        e.d("load lib fail %s close native return!", new Object[] { paramFile.getAbsoluteFile() });
        return;
      }
      e.a("load lib sucess from specify!", new Object[0]);
      localObject = com.tencent.feedback.eup.jni.b.a(paramContext);
      ((com.tencent.feedback.eup.jni.b)localObject).a(paramString);
      NativeExceptionUpload.setmHandler((NativeExceptionHandler)localObject);
      localObject = paramList;
      if (paramFile != null)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramFile);
      }
      if ((paramContext != null) && (paramString != null)) {
        break label197;
      }
      e.c("rqdp{  nreg param!}", new Object[0]);
    }
    for (;;)
    {
      com.tencent.feedback.common.d.a(paramContext);
      paramList = com.tencent.feedback.common.d.d();
      com.tencent.feedback.common.d.a(paramContext);
      NativeExceptionUpload.registEUP(paramString, paramList, Integer.parseInt(com.tencent.feedback.common.d.c()));
      NativeExceptionUpload.enableNativeEUP(true);
      if (!paramBoolean) {
        break label342;
      }
      NativeExceptionUpload.setNativeLogMode(3);
      return;
      if (!NativeExceptionUpload.loadRQDNativeLib())
      {
        e.d("load lib fail default close native return!", new Object[0]);
        return;
      }
      e.a("load lib sucess default!", new Object[0]);
      break;
      label197:
      paramList = f.l().s();
      long l1 = com.tencent.feedback.proguard.a.c();
      long l2 = paramList.getRecordOverDays() * 24 * 3600 * 1000;
      int i = paramList.getMaxStoredNum();
      t.a(paramContext).a(new com.tencent.feedback.eup.jni.d(paramContext, paramString, l1 - l2, i, "tomb_", ".txt"));
      e.a("add clean task to query listener", new Object[0]);
      paramList = "/data/data/" + paramContext.getPackageName() + "/lib/";
      if (c.a(paramContext).A() == null)
      {
        e.b("no setted SO , query so!", new Object[0]);
        com.tencent.feedback.common.b.b().a(new com.tencent.feedback.eup.jni.a(paramContext, paramList, (List)localObject));
      }
    }
    label342:
    NativeExceptionUpload.setNativeLogMode(5);
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      e.c("putUserData args context should not be null", new Object[0]);
      return;
    }
    if ((paramString1 != null) && (paramString1.trim().length() > 0)) {}
    for (int i = 0; i != 0; i = 1)
    {
      e.c("putUserData args key should not be null", new Object[0]);
      return;
    }
    if (!paramString1.matches("[a-zA-Z[0-9]]+"))
    {
      e.c("putUserData args key should match [a-zA-Z[0-9]]+  {" + paramString1 + "}", new Object[0]);
      return;
    }
    Object localObject = paramString2;
    paramString2 = (String)localObject;
    if (((String)localObject).length() > 200)
    {
      e.c("user data value length over limit %d , has been cutted!", new Object[] { Integer.valueOf(200) });
      paramString2 = ((String)localObject).substring(0, 200);
    }
    localObject = c.a(paramContext);
    if (((c)localObject).J().contains(paramString1))
    {
      c.a(paramContext).a(paramString1, paramString2);
      e.b("replace KV %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    if (((c)localObject).I() >= 10)
    {
      e.c("user data size is over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(10), paramString1 });
      return;
    }
    if (paramString1.length() > 50)
    {
      e.c("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      return;
    }
    c.a(paramContext).a(paramString1, paramString2);
    e.b("added KV %s %s", new Object[] { paramString1, paramString2 });
  }
  
  public static void removePlugin(Context paramContext, String paramString)
  {
    if (paramString != null) {
      c.a(paramContext).f(paramString);
    }
  }
  
  public static String removeUserData(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramContext == null) {
      e.c("removeUserData args context should not be null", new Object[0]);
    }
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    while (i != 0)
    {
      return null;
      i = 1;
    }
    return c.a(paramContext).j(paramString);
  }
  
  public static void setAPKSHa1(Context paramContext, String paramString)
  {
    c.a(paramContext).d(paramString);
    e.b("set sha1 %s", new Object[] { paramString });
  }
  
  public static void setCountryName(Context paramContext, String paramString)
  {
    c.a(paramContext).g(paramString);
  }
  
  public static void setCrashReportAble(boolean paramBoolean)
  {
    f localf = f.l();
    if (localf != null) {
      localf.a(paramBoolean);
    }
  }
  
  public static void setDengta_AppKey(Context paramContext, String paramString)
  {
    c.a(paramContext).e(paramString);
    e.b("setted beacon appkey %s", new Object[] { paramString });
  }
  
  public static void setDeviceId(Context paramContext, String paramString)
  {
    c.a(paramContext).b(paramString);
  }
  
  public static void setDeviceRooted(Context paramContext, boolean paramBoolean)
  {
    c.a(paramContext).a(paramBoolean);
    e.b("setted isRT %s", new Object[] { paramBoolean });
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (e.a locala = new e.a();; locala = null)
    {
      e.a(locala);
      if (paramBoolean1) {
        e.c("'setLogAble(boolean)' is true , so running in debug model , close it when you release!", new Object[0]);
      }
      return;
    }
  }
  
  public static void setNativeCrashReportAble(boolean paramBoolean)
  {
    NativeExceptionUpload.enableNativeEUP(paramBoolean);
  }
  
  public static void setProductID(Context paramContext, String paramString)
  {
    c.a(paramContext).i(paramString);
    e.b("setted ProductID %s", new Object[] { paramString });
  }
  
  public static void setProductVersion(Context paramContext, String paramString)
  {
    c.a(paramContext).h(paramString);
    e.b("setted version %s", new Object[] { paramString });
  }
  
  public static void setSOFile(Context paramContext, List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramContext = c.a(paramContext);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SOFile localSOFile = (SOFile)paramList.next();
        o localo = new o();
        localo.a(localSOFile.fileName);
        localo.c(localSOFile.arch);
        localo.b(localSOFile.sha1);
        e.b("setsofile %s %s %s", new Object[] { localo.a(), localo.f(), localo.d() });
        localArrayList.add(localo);
      }
      if (localArrayList.size() > 0)
      {
        paramContext.a(localArrayList);
        e.b("setted so count %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      }
    }
  }
  
  public static void setThreadPoolService(ScheduledExecutorService paramScheduledExecutorService)
  {
    com.tencent.feedback.common.b.a(com.tencent.feedback.common.b.a(paramScheduledExecutorService));
  }
  
  public static void setUserId(Context paramContext, String paramString)
  {
    c.a(paramContext).a(paramString);
    paramContext = y.a();
    if (paramContext != null)
    {
      e.b("record uidstate async", new Object[0]);
      paramContext.c();
    }
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      e.c("setTag args context should not be null", new Object[0]);
      return;
    }
    if (paramInt <= 0)
    {
      e.c("setTag args tagId should > 0", new Object[0]);
      return;
    }
    c.a(paramContext).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport
 * JD-Core Version:    0.7.0.1
 */