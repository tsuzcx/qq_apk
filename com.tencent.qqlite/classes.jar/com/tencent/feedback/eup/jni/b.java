package com.tencent.feedback.eup.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.feedback.common.a;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.d;

public final class b
  implements NativeExceptionHandler
{
  private static b b;
  private Context a;
  
  private b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static NativeExceptionHandler a(Context paramContext)
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
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, -1234567890, "", -1, -1, -1, "", "unknown");
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    com.tencent.feedback.common.e.e("rqdp{  na eup p:} %d , t:%d , exT:%d ,exTMS: %d, exTP:%s ,exADD:%s ,parsed exSTA:%s, TMB:%s , si_code:%d , si_CodeType:%s , sPid:%d ,sUid:%d,siErr:%d,siErrMsg:%s,naVersion:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt3), paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), paramString6, paramString7 });
    Log.e("eup", "native crash happen");
    Log.e("eup", paramString3);
    String str2 = null;
    paramString6 = null;
    String str3 = null;
    Object localObject1 = com.tencent.feedback.eup.e.k();
    if (localObject1 == null) {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
    }
    for (localObject1 = null;; localObject1 = ((com.tencent.feedback.eup.e)localObject1).p())
    {
      Object localObject2 = str3;
      if (localObject1 != null) {}
      try
      {
        com.tencent.feedback.common.e.b("set exdata", new Object[0]);
        localObject2 = ((CrashHandleListener)localObject1).getCrashExtraData();
        paramString6 = (String)localObject2;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label215:
          String str4;
          com.tencent.feedback.common.e.d("get extra data error %s", new Object[] { localThrowable1.toString() });
          localThrowable1.printStackTrace();
        }
      }
      try
      {
        com.tencent.feedback.common.e.b("set exMsg", new Object[0]);
        localObject2 = ((CrashHandleListener)localObject1).getCrashExtraMessage();
        str2 = paramString6;
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.feedback.common.e.d("get extra msg error %s", new Object[] { localThrowable2.toString() });
        localThrowable2.printStackTrace();
        String str1 = str3;
        str2 = paramString6;
        break label215;
        paramInt5 = paramString3.indexOf("java.lang.Thread.getStackTrace");
        if (paramInt5 >= 0) {
          break label393;
        }
        paramString6 = paramString3;
        break label223;
        paramInt6 = paramString3.indexOf("\n", paramInt5);
        if (paramInt6 >= 0) {
          break label416;
        }
        paramString6 = paramString3;
        break label223;
        paramString6 = paramString3.substring(0, paramInt5);
        str3 = paramString3.substring(paramInt6);
        paramString6 = paramString6 + str3;
        break label223;
        if (paramInt3 <= 0) {
          break label572;
        }
        paramString1.a(paramString1.e() + "(" + paramString5 + ")");
        paramString1.p("kernel");
        for (;;)
        {
          com.tencent.feedback.common.e.a("etype:%s,sType:%s,sPN:%s", new Object[] { paramString1.e(), paramString1.G(), paramString1.F() });
          paramString1.a(true);
          paramString1.c(true);
          paramString1.h(paramString4);
          paramString1.q(paramString7);
          break;
          paramString1.p(paramString5);
          paramString1.o(a.a(this.a, paramInt4));
        }
        paramString2 = com.tencent.feedback.eup.b.a(this.a);
        if (paramString2 == null) {
          break label632;
        }
        com.tencent.feedback.common.e.e("rqdp{  handle na eup} %b", new Object[] { Boolean.valueOf(paramString2.a(paramString1)) });
        if (localObject1 == null) {
          break label299;
        }
        com.tencent.feedback.common.e.e("rqdp{  start your handler to native crash}", new Object[0]);
        try
        {
          ((CrashHandleListener)localObject1).onNativeCrash(paramInt1, paramInt2, paramString3);
          return;
        }
        catch (Throwable paramString1)
        {
          com.tencent.feedback.common.e.d("your crash handle happen error %s", new Object[] { paramString1.toString() });
          paramString1.printStackTrace();
        }
      }
      if (paramString3 != null) {
        break label372;
      }
      paramString6 = null;
      label223:
      str3 = a.h(this.a);
      str4 = Thread.currentThread().getName();
      paramString1 = com.tencent.feedback.eup.b.a(this.a, str3, str4, paramString2, paramString1, paramString1, paramString6, paramLong2 / 1000L + 1000L * paramLong1, (String)localObject2, str2);
      if (paramString1 != null) {
        break label460;
      }
      paramString1 = null;
      if (paramString1 != null) {
        break label596;
      }
      com.tencent.feedback.common.e.c("rqdp{  cr eup msg fail!}", new Object[0]);
      label299:
      return;
    }
    label372:
    label632:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.b
 * JD-Core Version:    0.7.0.1
 */