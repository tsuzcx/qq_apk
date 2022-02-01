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
    if (paramString3 == null)
    {
      paramString3 = null;
    }
    else
    {
      int i = paramString3.indexOf("java.lang.Thread.getStackTrace");
      int j;
      if (i >= 0)
      {
        j = paramString3.indexOf("\n", i);
        if (j < 0) {}
      }
      else
      {
        localObject1 = paramString3.substring(0, i);
        paramString3 = paramString3.substring(j);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString3);
        paramString3 = ((StringBuilder)localObject2).toString();
      }
    }
    Object localObject1 = com.tencent.feedback.common.c.a(paramContext);
    Object localObject2 = ((com.tencent.feedback.common.c)localObject1).E();
    String str = Thread.currentThread().getName();
    paramContext = com.tencent.feedback.eup.b.a(paramContext, ((com.tencent.feedback.common.c)localObject1).g(), ((com.tencent.feedback.common.c)localObject1).h(), ((com.tencent.feedback.common.c)localObject1).j(), ((com.tencent.feedback.common.c)localObject1).y(), (String)localObject2, str, paramString2, paramString1, paramString6, paramString3, paramLong, paramString7, paramArrayOfByte);
    if (paramContext == null) {
      return null;
    }
    if (paramInt1 > 0)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramContext.e());
      paramString1.append("(");
      paramString1.append(paramString5);
      paramString1.append(")");
      paramContext.a(paramString1.toString());
      paramContext.o("kernel");
    }
    else
    {
      paramContext.o(paramString5);
      if ((paramInt2 > 0) && (!paramString1.equalsIgnoreCase("SIGABRT")))
      {
        paramContext.n(com.tencent.feedback.common.a.a(paramInt2));
      }
      else
      {
        paramString1 = new StringBuilder("unknown");
        paramString1.append(paramInt2);
        paramContext.n(paramString1.toString());
      }
    }
    com.tencent.feedback.common.e.a("etype:%s,sType:%s,sPN:%s", new Object[] { paramContext.e(), paramContext.A(), paramContext.z() });
    paramContext.a((byte)2);
    paramContext.h(paramString4);
    paramContext.p(paramString8);
    return paramContext;
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
    paramString6 = new StringBuilder("native crash happen:");
    paramString6.append(paramString1);
    Log.e("eup", paramString6.toString());
    Log.e("eup", paramString3);
    boolean bool = com.tencent.feedback.anr.b.a(this.a).a();
    String str3;
    if (bool) {
      str3 = "This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!";
    } else {
      str3 = "";
    }
    if (bool) {
      Log.e("eup", "This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!");
    }
    paramLong1 = paramLong1 * 1000L + paramLong2 / 1000L;
    paramString6 = f.l();
    if (paramString6 == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      paramString6 = null;
    }
    else
    {
      paramString6 = paramString6.r();
    }
    Object localObject;
    String str2;
    if (paramString6 != null)
    {
      try
      {
        com.tencent.feedback.common.e.b("your crhanlde start", new Object[0]);
        paramString6.onCrashHandleStart(true);
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.feedback.common.e.d("on native hanlde start throw %s", new Object[] { localThrowable1.toString() });
        if (!com.tencent.feedback.common.e.a(localThrowable1)) {
          localThrowable1.printStackTrace();
        }
      }
      try
      {
        com.tencent.feedback.common.e.b("your crdata", new Object[0]);
        byte[] arrayOfByte = paramString6.getCrashExtraData(true, paramString1, paramString2, paramString3, paramInt3, paramLong1);
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.feedback.common.e.d("get extra data error %s", new Object[] { localThrowable2.toString() });
        if (!com.tencent.feedback.common.e.a(localThrowable2)) {
          localThrowable2.printStackTrace();
        }
        localObject = null;
      }
      try
      {
        com.tencent.feedback.common.e.b("your crmsg", new Object[0]);
        String str1 = paramString6.getCrashExtraMessage(true, paramString1, paramString2, paramString3, paramInt3, paramLong1);
      }
      catch (Throwable localThrowable3)
      {
        com.tencent.feedback.common.e.d("get extra msg error %s", new Object[] { localThrowable3.toString() });
        if (!com.tencent.feedback.common.e.a(localThrowable3)) {
          localThrowable3.printStackTrace();
        }
        str2 = null;
      }
    }
    else
    {
      str2 = null;
      localObject = str2;
    }
    paramString4 = a(this.a, paramLong1, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, str3, localObject, str2, paramString7);
    if (paramString4 == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  cr eup msg fail!}", new Object[0]);
      return;
    }
    try
    {
      com.tencent.feedback.common.e.c("rqdp{  get other stack}", new Object[0]);
      paramString5 = com.tencent.feedback.proguard.a.b();
      if (paramString5 != null) {
        paramString4.C().putAll(paramString5);
      }
    }
    catch (Throwable paramString5)
    {
      com.tencent.feedback.common.e.d("get all threads stack fail", new Object[0]);
      if (!com.tencent.feedback.common.e.a(paramString5)) {
        paramString5.printStackTrace();
      }
    }
    if (paramString6 != null)
    {
      com.tencent.feedback.common.e.b("your ask2save", new Object[0]);
      try
      {
        bool = paramString6.onCrashSaving(true, paramString1, paramString2, paramString3, paramInt3, paramLong1, paramString4.k(), paramString4.D(), paramString4.v());
      }
      catch (Throwable paramString1)
      {
        com.tencent.feedback.common.e.d("on Crash Saving error %s", new Object[] { paramString1.toString() });
        if (!com.tencent.feedback.common.e.a(paramString1)) {
          paramString1.printStackTrace();
        }
      }
    }
    else
    {
      bool = true;
    }
    paramString1 = this;
    BuglyBroadcastRecevier.brocastCrash(paramString1.a, paramString4);
    if (bool)
    {
      try
      {
        paramString1 = com.tencent.feedback.eup.c.a(paramString1.a);
        if (paramString1 == null) {
          break label767;
        }
        com.tencent.feedback.common.e.b("rqdp{  eup save} %b", new Object[] { Boolean.valueOf(paramString1.a(paramString4, CrashReport.getCrashRuntimeStrategy())) });
        c.a(b());
      }
      catch (Throwable paramString1)
      {
        com.tencent.feedback.common.e.d("your crash handle happen error %s", new Object[] { paramString1.toString() });
        if (com.tencent.feedback.common.e.a(paramString1)) {
          break label767;
        }
      }
      paramString1.printStackTrace();
    }
    else
    {
      com.tencent.feedback.common.e.c("the eup no need to save!", new Object[0]);
    }
    label767:
    if (paramString6 != null) {
      try
      {
        com.tencent.feedback.common.e.b("your crhanlde end", new Object[0]);
        paramString6.onCrashHandleEnd(true);
        return;
      }
      catch (Throwable paramString1)
      {
        com.tencent.feedback.common.e.d("on native hanlde end throw %s", new Object[] { paramString1.toString() });
        if (!com.tencent.feedback.common.e.a(paramString1)) {
          paramString1.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.b
 * JD-Core Version:    0.7.0.1
 */