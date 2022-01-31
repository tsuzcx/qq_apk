package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.j;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.feedback.upload.g;

public final class e
  extends j
{
  private static e b;
  private CrashStrategyBean c = null;
  private CrashStrategyBean d = null;
  private b e = null;
  private CrashHandleListener f = null;
  private final boolean g;
  
  private e(Context paramContext, String paramString, boolean paramBoolean, com.tencent.feedback.upload.f paramf, UploadHandleListener paramUploadHandleListener, CrashHandleListener paramCrashHandleListener, CrashStrategyBean paramCrashStrategyBean)
  {
    super(paramContext, paramString, 3, 202, 302, paramf, new c(paramContext.getApplicationContext()), paramUploadHandleListener);
    if (paramCrashStrategyBean != null) {
      com.tencent.feedback.common.e.e("rqdp{  cus eupstrategy} %s", new Object[] { paramCrashStrategyBean });
    }
    for (this.c = paramCrashStrategyBean;; this.c = new CrashStrategyBean())
    {
      this.e = b.a(this.a);
      this.f = paramCrashHandleListener;
      this.g = paramBoolean;
      return;
      com.tencent.feedback.common.e.e("rqdp{  default eupstrategy}", new Object[0]);
    }
  }
  
  public static e a(Context paramContext, String paramString, boolean paramBoolean, com.tencent.feedback.upload.f paramf, UploadHandleListener paramUploadHandleListener, CrashHandleListener paramCrashHandleListener, CrashStrategyBean paramCrashStrategyBean)
  {
    try
    {
      if (b == null)
      {
        com.tencent.feedback.common.e.e("rqdp{  eup create instance}", new Object[0]);
        paramContext = new e(paramContext, paramString, false, paramf, paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
        b = paramContext;
        paramContext.a(true);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.feedback.upload.f a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = g.a(paramContext, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean a(Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte)
  {
    com.tencent.feedback.common.e.e("rqdp{  handleCatchException}", new Object[0]);
    if (!m()) {
      return false;
    }
    Object localObject = k();
    if (localObject == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      return false;
    }
    if (((e)localObject).a()) {}
    for (;;)
    {
      try
      {
        localObject = ((e)localObject).s();
        if (localObject != null) {
          break label111;
        }
        com.tencent.feedback.common.e.c("rqdp{  imposiable chandler null!}", new Object[0]);
        return false;
      }
      catch (Throwable paramThread)
      {
        paramThread.printStackTrace();
        com.tencent.feedback.common.e.d("rqdp{  handleCatchException error} %s", new Object[] { paramThread.toString() });
      }
      return ((b)localObject).a(paramThread, paramThrowable, paramString, paramArrayOfByte, false);
      paramThread = paramThread.getName();
      continue;
      return false;
      label111:
      if (paramThread == null) {
        paramThread = null;
      }
    }
  }
  
  public static e k()
  {
    try
    {
      e locale = b;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean l()
  {
    if (!m()) {
      return false;
    }
    com.tencent.feedback.common.e.e("rqdp{  doUploadExceptionDatas}", new Object[0]);
    e locale = k();
    if (locale == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      return false;
    }
    return locale.h();
  }
  
  public static boolean m()
  {
    boolean bool1 = false;
    e locale = k();
    if (locale == null) {
      com.tencent.feedback.common.e.d("rqdp{  not init eup}", new Object[0]);
    }
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool2 = locale.a();
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (!locale.r());
    return locale.b();
  }
  
  private boolean r()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private b s()
  {
    try
    {
      b localb = this.e;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(CrashStrategyBean paramCrashStrategyBean)
  {
    try
    {
      this.d = paramCrashStrategyBean;
      return;
    }
    finally
    {
      paramCrashStrategyBean = finally;
      throw paramCrashStrategyBean;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 143	com/tencent/feedback/common/j:b	(Z)V
    //   7: aload_0
    //   8: invokevirtual 102	com/tencent/feedback/eup/e:a	()Z
    //   11: ifeq +13 -> 24
    //   14: aload_0
    //   15: getfield 37	com/tencent/feedback/eup/e:e	Lcom/tencent/feedback/eup/b;
    //   18: invokevirtual 145	com/tencent/feedback/eup/b:a	()V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 37	com/tencent/feedback/eup/e:e	Lcom/tencent/feedback/eup/b;
    //   28: invokevirtual 147	com/tencent/feedback/eup/b:b	()V
    //   31: goto -10 -> 21
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	e
    //   0	39	1	paramBoolean	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	34	finally
    //   24	31	34	finally
  }
  
  public final void e()
  {
    int i = -1;
    super.e();
    Context localContext = this.a;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEup() start}", new Object[0]);
    if (localContext == null) {
      com.tencent.feedback.common.e.c("rqdp{  deleteEup() context is null arg}", new Object[0]);
    }
    for (;;)
    {
      com.tencent.feedback.common.e.b("remove fail updata num :%d", new Object[] { Integer.valueOf(i) });
      return;
      i = l.a(localContext, new int[] { 1, 2 }, -1L, 9223372036854775807L, 3, -1);
    }
  }
  
  public final void f()
  {
    int i = -1;
    super.f();
    Context localContext = this.a;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEup() start}", new Object[0]);
    if (localContext == null) {
      com.tencent.feedback.common.e.c("rqdp{  deleteEup() context is null arg}", new Object[0]);
    }
    for (;;)
    {
      com.tencent.feedback.common.e.e("rqdp{  eup clear} %d ", new Object[] { Integer.valueOf(i) });
      com.tencent.feedback.common.e.e("rqdp{  eup strategy clear} %d ", new Object[] { Integer.valueOf(a.b(this.a, 302)) });
      return;
      i = l.a(localContext, new int[] { 1, 2 }, -1L, 9223372036854775807L, -1, -1);
    }
  }
  
  public final int g()
  {
    int i = 0;
    CrashStrategyBean localCrashStrategyBean = q();
    if ((localCrashStrategyBean != null) && (super.g() >= 0))
    {
      if (!localCrashStrategyBean.isMerged())
      {
        com.tencent.feedback.common.e.e("rqdp{  in no merge}", new Object[0]);
        i = c.a(this.a);
      }
      do
      {
        return i;
        com.tencent.feedback.common.e.e("rqdp{  in merge}", new Object[0]);
      } while (!s().c());
      return 1;
    }
    return -1;
  }
  
  public final boolean h()
  {
    if (super.h())
    {
      f localf = f.a(this.a);
      com.tencent.feedback.upload.f localf1 = c();
      if ((localf == null) || (localf1 == null))
      {
        com.tencent.feedback.common.e.c("rqdp{  upDatas or uphandler null!}", new Object[0]);
        return false;
      }
      try
      {
        localf1.a(localf);
        return true;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.feedback.common.e.d("rqdp{  upload eupdata error} %s", new Object[] { localThrowable.toString() });
      }
    }
    return false;
  }
  
  public final boolean i()
  {
    return o() != null;
  }
  
  public final CrashStrategyBean n()
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = this.c;
      return localCrashStrategyBean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final CrashStrategyBean o()
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = this.d;
      return localCrashStrategyBean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final CrashHandleListener p()
  {
    try
    {
      CrashHandleListener localCrashHandleListener = this.f;
      return localCrashHandleListener;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final CrashStrategyBean q()
  {
    for (;;)
    {
      try
      {
        if (t.a(this.a).b().i())
        {
          CrashStrategyBean localCrashStrategyBean1 = o();
          CrashStrategyBean localCrashStrategyBean2 = localCrashStrategyBean1;
          if (localCrashStrategyBean1 == null) {
            localCrashStrategyBean2 = n();
          }
          return localCrashStrategyBean2;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return null;
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.e
 * JD-Core Version:    0.7.0.1
 */