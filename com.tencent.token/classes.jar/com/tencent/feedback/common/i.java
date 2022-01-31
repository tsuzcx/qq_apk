package com.tencent.feedback.common;

import android.content.Context;
import com.tencent.feedback.proguard.s;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import com.tencent.feedback.proguard.w.a;
import com.tencent.feedback.proguard.x;
import com.tencent.feedback.proguard.z;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.feedback.upload.d;

public class i
  implements s, x
{
  protected final Context a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private com.tencent.feedback.upload.e g;
  private d h;
  private int i = 0;
  
  public i(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, com.tencent.feedback.upload.e parame, d paramd, UploadHandleListener paramUploadHandleListener)
  {
    if (paramContext == null) {}
    for (;;)
    {
      this.a = paramContext;
      paramContext = c.a(this.a);
      if ((paramString != null) && (paramString.trim().length() > 0)) {
        paramContext.a(paramString);
      }
      this.b = 3;
      this.c = 530;
      this.d = 510;
      this.g = parame;
      this.h = paramd;
      if (parame != null)
      {
        parame.a(paramd);
        parame.a(paramUploadHandleListener);
      }
      paramContext = t.a(this.a);
      paramContext.a(this);
      paramContext.a(this);
      paramContext.a(3, parame);
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.i = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      this.f = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private d l()
  {
    try
    {
      d locald = this.h;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(w paramw)
  {
    e.b("rqdp{  com strateyg changed }%s", new Object[] { getClass().toString() });
    if (paramw != null)
    {
      paramw = paramw.c(this.b);
      if (paramw != null) {
        if ((!paramw.c()) || (!paramw.b())) {
          break label94;
        }
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      if (a() != bool)
      {
        e.a("rqdp{  module} %d rqdp{  able changed }%b", new Object[] { Integer.valueOf(this.b), Boolean.valueOf(bool) });
        b(bool);
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = t.a(this.a);
    if (localObject != null)
    {
      localObject = ((t)localObject).b().c(this.b);
      if ((localObject != null) && (((w.a)localObject).b() != paramBoolean))
      {
        e.a("rqdp{  mid:}%d rqdp{  change user switch} %b", new Object[] { Integer.valueOf(this.b), Boolean.valueOf(paramBoolean) });
        ((w.a)localObject).a(paramBoolean);
        if ((!((w.a)localObject).b()) || (!((w.a)localObject).c())) {
          break label100;
        }
      }
    }
    label100:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      if (paramBoolean != a()) {
        b(paramBoolean);
      }
      return;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.feedback.upload.e c()
  {
    try
    {
      com.tencent.feedback.upload.e locale = this.g;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
  {
    e.b("rqdp{  com query start }%s", new Object[] { getClass().toString() });
    a(k() + 1);
  }
  
  public void e()
  {
    e.b("rqdp{  com query end }%s", new Object[] { getClass().toString() });
    if (!b())
    {
      e.b("rqdp{  step after query}", new Object[0]);
      c(true);
    }
    for (;;)
    {
      try
      {
        w localw = t.a(this.a).b();
        w.a locala = localw.c(this.b);
        if ((a()) && (locala != null))
        {
          e.b("rqdp{  isable}", new Object[0]);
          bool1 = locala.d();
          boolean bool2 = localw.g();
          if (!bool1) {
            break label360;
          }
          if (bool2)
          {
            bool1 = true;
            e.b("rqdp{  needDetail} %b rqdp{  allQ:}%b rqdp{  result:}%b", new Object[] { Boolean.valueOf(locala.d()), Boolean.valueOf(localw.g()), Boolean.valueOf(bool1) });
            if (g() <= 0) {
              break label365;
            }
            j = 1;
            if (j != 0)
            {
              e.b("rqdp{  asyn up module} %d", new Object[] { Integer.valueOf(this.b) });
              b.b().a(new i.1(this));
            }
          }
          else
          {
            if (i()) {
              break label360;
            }
            z localz = com.tencent.feedback.proguard.a.a(this.a, this.d);
            if (localz != null)
            {
              d locald = l();
              if (locald == null)
              {
                e.c("rqdp{  imposiable eup reshandler not ready}", new Object[0]);
                break label360;
              }
              locald.a(this.d, localz.c(), false);
            }
            if (i()) {
              break label360;
            }
            bool1 = true;
            continue;
          }
          if (!bool1) {
            break label359;
          }
          e.b("rqdp{  asyn query module }%d", new Object[] { Integer.valueOf(this.b) });
          b.b().a(new i.2(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (!e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        e.d("rqdp{  common query end error} %s", new Object[] { localThrowable.toString() });
        return;
      }
      e.b("rqdp{  disable}", new Object[0]);
      label359:
      return;
      label360:
      boolean bool1 = false;
      continue;
      label365:
      int j = 0;
    }
  }
  
  public void f()
  {
    e.a("rqdp{  app first start} %s", new Object[] { getClass().toString() });
  }
  
  public int g()
  {
    if (!a()) {
      return -1;
    }
    return 0;
  }
  
  public boolean h()
  {
    return a();
  }
  
  public boolean i()
  {
    return true;
  }
  
  public final boolean j()
  {
    if (!a()) {}
    com.tencent.feedback.upload.e locale;
    do
    {
      return false;
      locale = c();
    } while (locale == null);
    locale.a(new com.tencent.feedback.upload.a(this.a, this.b, this.c));
    return true;
  }
  
  public final int k()
  {
    try
    {
      int j = this.i;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.i
 * JD-Core Version:    0.7.0.1
 */