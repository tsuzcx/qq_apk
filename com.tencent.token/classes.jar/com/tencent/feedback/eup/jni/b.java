package com.tencent.feedback.eup.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.feedback.eup.BuglyBroadcastRecevier;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.f;
import java.util.Map;

public final class b
  implements NativeExceptionHandler
{
  private static b b;
  private Context a;
  private String c;
  
  private b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  protected static com.tencent.feedback.eup.e a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8)
  {
    if (paramString3 == null) {
      paramString3 = null;
    }
    for (;;)
    {
      Object localObject = com.tencent.feedback.common.c.a(paramContext);
      String str1 = ((com.tencent.feedback.common.c)localObject).E();
      String str2 = Thread.currentThread().getName();
      paramContext = com.tencent.feedback.eup.b.a(paramContext, ((com.tencent.feedback.common.c)localObject).g(), ((com.tencent.feedback.common.c)localObject).h(), ((com.tencent.feedback.common.c)localObject).j(), ((com.tencent.feedback.common.c)localObject).y(), str1, str2, paramString2, paramString1, paramString6, paramString3, paramLong, paramString7, paramArrayOfByte);
      if (paramContext != null) {
        break;
      }
      return null;
      int i = paramString3.indexOf("java.lang.Thread.getStackTrace");
      if (i >= 0)
      {
        int j = paramString3.indexOf("\n", i);
        if (j >= 0)
        {
          localObject = paramString3.substring(0, i);
          paramString3 = paramString3.substring(j);
          paramString3 = (String)localObject + paramString3;
        }
      }
    }
    if (paramInt1 > 0)
    {
      paramContext.a(paramContext.e() + "(" + paramString5 + ")");
      paramContext.o("kernel");
    }
    for (;;)
    {
      com.tencent.feedback.common.e.a("etype:%s,sType:%s,sPN:%s", new Object[] { paramContext.e(), paramContext.A(), paramContext.z() });
      paramContext.a((byte)2);
      paramContext.h(paramString4);
      paramContext.p(paramString8);
      return paramContext;
      paramContext.o(paramString5);
      if ((paramInt2 > 0) && (!paramString1.equalsIgnoreCase("SIGABRT"))) {
        paramContext.n(com.tencent.feedback.common.a.a(paramInt2));
      } else {
        paramContext.n("unknown" + paramInt2);
      }
    }
  }
  
  public static b a()
  {
    try
    {
      b localb = b;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private String b()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, -1234567890, "", -1, -1, -1, "", "unknown");
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    com.tencent.feedback.common.e.b("rqdp{  na eup p:} %d , t:%d , exT:%d ,exTMS: %d, exTP:%s ,exADD:%s ,parsed exSTA:%s, TMB:%s , si_code:%d , si_CodeType:%s , sPid:%d ,sUid:%d,siErr:%d,siErrMsg:%s,naVersion:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt3), paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), paramString6, paramString7 });
    Log.e("eup", "native crash happen:" + paramString1);
    Log.e("eup", paramString3);
    bool = com.tencent.feedback.anr.b.a(this.a).a();
    String str1;
    String str2;
    Object localObject3;
    Object localObject2;
    CrashHandleListener localCrashHandleListener;
    label226:
    Object localObject1;
    if (bool)
    {
      str1 = "This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!";
      if (bool) {
        Log.e("eup", "This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!");
      }
      str2 = null;
      localObject3 = null;
      localObject2 = null;
      paramLong1 = 1000L * paramLong1 + paramLong2 / 1000L;
      paramString6 = f.l();
      if (paramString6 != null) {
        break label370;
      }
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      localCrashHandleListener = null;
      localObject1 = localObject2;
      if (localCrashHandleListener == null) {}
    }
    label370:
    do
    {
      do
      {
        try
        {
          com.tencent.feedback.common.e.b("your crhanlde start", new Object[0]);
          localCrashHandleListener.onCrashHandleStart(true);
        }
        catch (Throwable paramString6)
        {
          try
          {
            for (;;)
            {
              com.tencent.feedback.common.e.b("your crdata", new Object[0]);
              paramString6 = localCrashHandleListener.getCrashExtraData(true, paramString1, paramString2, paramString3, paramInt3, paramLong1);
              try
              {
                com.tencent.feedback.common.e.b("your crmsg", new Object[0]);
                localObject1 = localCrashHandleListener.getCrashExtraMessage(true, paramString1, paramString2, paramString3, paramInt3, paramLong1);
                str2 = paramString6;
              }
              catch (Throwable localThrowable2)
              {
                for (;;)
                {
                  com.tencent.feedback.common.e.d("get extra msg error %s", new Object[] { localThrowable2.toString() });
                  str3 = paramString6;
                  localObject1 = localObject2;
                  if (!com.tencent.feedback.common.e.a(localThrowable2))
                  {
                    localThrowable2.printStackTrace();
                    str3 = paramString6;
                    localObject1 = localObject2;
                  }
                }
              }
              paramString4 = a(this.a, paramLong1, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, str1, str2, (String)localObject1, paramString7);
              if (paramString4 != null) {
                break label512;
              }
              com.tencent.feedback.common.e.c("rqdp{  cr eup msg fail!}", new Object[0]);
              return;
              str1 = "";
              break;
              localCrashHandleListener = paramString6.r();
              break label226;
              paramString6 = paramString6;
              com.tencent.feedback.common.e.d("on native hanlde start throw %s", new Object[] { paramString6.toString() });
              if (!com.tencent.feedback.common.e.a(paramString6)) {
                paramString6.printStackTrace();
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              com.tencent.feedback.common.e.d("get extra data error %s", new Object[] { localThrowable1.toString() });
              paramString6 = localObject3;
              if (!com.tencent.feedback.common.e.a(localThrowable1))
              {
                localThrowable1.printStackTrace();
                paramString6 = localObject3;
              }
            }
          }
        }
        try
        {
          String str3;
          com.tencent.feedback.common.e.c("rqdp{  get other stack}", new Object[0]);
          paramString5 = com.tencent.feedback.proguard.a.b();
          if (paramString5 != null) {
            paramString4.C().putAll(paramString5);
          }
        }
        catch (Throwable paramString5)
        {
          for (;;)
          {
            com.tencent.feedback.common.e.d("get all threads stack fail", new Object[0]);
            if (!com.tencent.feedback.common.e.a(paramString5))
            {
              paramString5.printStackTrace();
              continue;
              bool = true;
              continue;
              com.tencent.feedback.common.e.c("the eup no need to save!", new Object[0]);
            }
          }
        }
        if (localCrashHandleListener == null) {
          break label781;
        }
        com.tencent.feedback.common.e.b("your ask2save", new Object[0]);
        try
        {
          bool = localCrashHandleListener.onCrashSaving(true, paramString1, paramString2, paramString3, paramInt3, paramLong1, paramString4.k(), paramString4.D(), paramString4.v());
          BuglyBroadcastRecevier.brocastCrash(this.a, paramString4);
          if (!bool) {
            break label824;
          }
        }
        catch (Throwable paramString1)
        {
          com.tencent.feedback.common.e.d("on Crash Saving error %s", new Object[] { paramString1.toString() });
          if (!com.tencent.feedback.common.e.a(paramString1)) {
            paramString1.printStackTrace();
          }
        }
        try
        {
          paramString1 = com.tencent.feedback.eup.c.a(this.a);
          if (paramString1 != null)
          {
            com.tencent.feedback.common.e.b("rqdp{  eup save} %b", new Object[] { Boolean.valueOf(paramString1.a(paramString4, CrashReport.getCrashRuntimeStrategy())) });
            c.a(b());
          }
        }
        catch (Throwable paramString1)
        {
          com.tencent.feedback.common.e.d("your crash handle happen error %s", new Object[] { paramString1.toString() });
          if (com.tencent.feedback.common.e.a(paramString1)) {
            break label657;
          }
          paramString1.printStackTrace();
          break label657;
        }
      } while (localCrashHandleListener == null);
      try
      {
        com.tencent.feedback.common.e.b("your crhanlde end", new Object[0]);
        localCrashHandleListener.onCrashHandleEnd(true);
        return;
      }
      catch (Throwable paramString1)
      {
        com.tencent.feedback.common.e.d("on native hanlde end throw %s", new Object[] { paramString1.toString() });
      }
    } while (com.tencent.feedback.common.e.a(paramString1));
    label512:
    label657:
    paramString1.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.b
 * JD-Core Version:    0.7.0.1
 */