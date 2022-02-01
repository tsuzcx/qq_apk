package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.i;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import com.tencent.feedback.upload.AbstractUploadDatas;
import com.tencent.feedback.upload.UploadHandleListener;

public final class f
  extends i
{
  private static f b;
  private CrashStrategyBean c = null;
  private CrashStrategyBean d = null;
  private c e = null;
  private CrashHandleListener f = null;
  private final boolean g;
  
  private f(Context paramContext, String paramString, boolean paramBoolean, com.tencent.feedback.upload.e parame, UploadHandleListener paramUploadHandleListener, CrashHandleListener paramCrashHandleListener, CrashStrategyBean paramCrashStrategyBean)
  {
    super(paramContext, paramString, 3, 530, 510, parame, new d(localContext1), paramUploadHandleListener);
    if (paramCrashStrategyBean != null)
    {
      com.tencent.feedback.common.e.b("rqdp{  cus eupstrategy} %s", new Object[] { paramCrashStrategyBean });
      this.c = paramCrashStrategyBean;
    }
    else
    {
      com.tencent.feedback.common.e.b("rqdp{  default eupstrategy}", new Object[0]);
      this.c = new CrashStrategyBean();
    }
    this.e = c.a(this.a);
    this.f = paramCrashHandleListener;
    this.g = paramBoolean;
  }
  
  public static f a(Context paramContext, String paramString, boolean paramBoolean, com.tencent.feedback.upload.e parame, UploadHandleListener paramUploadHandleListener, CrashHandleListener paramCrashHandleListener, CrashStrategyBean paramCrashStrategyBean)
  {
    try
    {
      if (b == null)
      {
        com.tencent.feedback.common.e.a("rqdp{  eup create instance}", new Object[0]);
        paramContext = new f(paramContext, paramString, false, parame, paramUploadHandleListener, paramCrashHandleListener, paramCrashStrategyBean);
        b = paramContext;
        paramContext.a(true);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.feedback.upload.e a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = com.tencent.feedback.upload.f.a(paramContext, paramBoolean);
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
    com.tencent.feedback.common.e.a("rqdp{  handleCatchException}", new Object[0]);
    if (!o()) {
      return false;
    }
    Object localObject = l();
    if (localObject == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      return false;
    }
    if (((f)localObject).a()) {
      try
      {
        localObject = ((f)localObject).u();
        if (localObject == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  imposiable chandler null!}", new Object[0]);
          return false;
        }
      }
      catch (Throwable paramThread)
      {
        if (!com.tencent.feedback.common.e.a(paramThread)) {
          paramThread.printStackTrace();
        }
        com.tencent.feedback.common.e.d("rqdp{  handleCatchException error} %s", new Object[] { paramThread.toString() });
      }
    }
    for (paramThread = paramThread.getName();; paramThread = null)
    {
      boolean bool = ((c)localObject).a(paramThread, paramThrowable, paramString, paramArrayOfByte, false);
      return bool;
      return false;
      if (paramThread != null) {
        break;
      }
    }
  }
  
  public static f l()
  {
    try
    {
      f localf = b;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static AbstractUploadDatas m()
  {
    try
    {
      boolean bool = o();
      if (!bool) {
        return null;
      }
      if (b == null)
      {
        com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
        return null;
      }
      if (b.a())
      {
        g localg = g.a(b.a);
        return localg;
      }
      return null;
    }
    finally {}
  }
  
  public static boolean n()
  {
    if (!o()) {
      return false;
    }
    com.tencent.feedback.common.e.a("rqdp{  doUploadExceptionDatas}", new Object[0]);
    f localf = l();
    if (localf == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  instance == null}", new Object[0]);
      return false;
    }
    return localf.h();
  }
  
  public static boolean o()
  {
    f localf = l();
    if (localf == null)
    {
      com.tencent.feedback.common.e.d("rqdp{  not init eup}", new Object[0]);
      return false;
    }
    boolean bool2 = localf.a();
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (localf.t()) {
        bool1 = localf.b();
      }
    }
    return bool1;
  }
  
  private boolean t()
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
  
  private c u()
  {
    try
    {
      c localc = this.e;
      return localc;
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
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      super.b(paramBoolean);
      if (a())
      {
        this.e.a();
        return;
      }
      this.e.b();
      return;
    }
    finally {}
  }
  
  public final void e()
  {
    super.e();
    Context localContext = this.a;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEup() start}", new Object[0]);
    int i;
    if (localContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  deleteEup() context is null arg}", new Object[0]);
      i = -1;
    }
    else
    {
      i = l.a(localContext, new int[] { 1, 2 }, -1L, 9223372036854775807L, 3, -1);
    }
    com.tencent.feedback.common.e.b("remove fail updata num :%d", new Object[] { Integer.valueOf(i) });
    if (k() == 1) {
      BuglyBroadcastRecevier.brocastProcessLaunch(this.a);
    }
  }
  
  public final void f()
  {
    super.f();
    Context localContext = this.a;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEup() start}", new Object[0]);
    int i;
    if (localContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  deleteEup() context is null arg}", new Object[0]);
      i = -1;
    }
    else
    {
      i = l.a(localContext, new int[] { 1, 2 }, -1L, 9223372036854775807L, -1, -1);
    }
    com.tencent.feedback.common.e.b("rqdp{  eup clear} %d ", new Object[] { Integer.valueOf(i) });
    com.tencent.feedback.common.e.b("rqdp{  eup strategy clear} %d ", new Object[] { Integer.valueOf(a.b(this.a, 510)) });
  }
  
  public final int g()
  {
    CrashStrategyBean localCrashStrategyBean = s();
    if ((localCrashStrategyBean != null) && (super.g() >= 0))
    {
      if (!localCrashStrategyBean.isMerged())
      {
        com.tencent.feedback.common.e.b("rqdp{  in no merge}", new Object[0]);
        return b.b(this.a);
      }
      com.tencent.feedback.common.e.b("rqdp{  in merge}", new Object[0]);
      if (b.a(this.a)) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public final boolean h()
  {
    if (super.h())
    {
      g localg = g.a(this.a);
      com.tencent.feedback.upload.e locale = c();
      if ((localg != null) && (locale != null)) {
        try
        {
          locale.a(localg);
          return true;
        }
        catch (Throwable localThrowable)
        {
          if (!com.tencent.feedback.common.e.a(localThrowable)) {
            localThrowable.printStackTrace();
          }
          com.tencent.feedback.common.e.d("rqdp{  upload eupdata error} %s", new Object[] { localThrowable.toString() });
          return false;
        }
      }
      com.tencent.feedback.common.e.c("rqdp{  upDatas or uphandler null!}", new Object[0]);
      return false;
    }
    return false;
  }
  
  public final boolean i()
  {
    return q() != null;
  }
  
  public final CrashStrategyBean p()
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
  
  public final CrashStrategyBean q()
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
  
  public final CrashHandleListener r()
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
  
  public final CrashStrategyBean s()
  {
    for (;;)
    {
      try
      {
        if (t.a(this.a).b().f())
        {
          CrashStrategyBean localCrashStrategyBean1 = q();
          CrashStrategyBean localCrashStrategyBean2 = localCrashStrategyBean1;
          if (localCrashStrategyBean1 == null) {
            localCrashStrategyBean2 = p();
          }
          return localCrashStrategyBean2;
        }
      }
      catch (Throwable localThrowable)
      {
        if (!com.tencent.feedback.common.e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        return null;
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.f
 * JD-Core Version:    0.7.0.1
 */