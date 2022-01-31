package com.tencent.feedback.common;

import android.content.Context;
import com.tencent.feedback.proguard.s;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import com.tencent.feedback.proguard.w.a;
import com.tencent.feedback.proguard.x;
import com.tencent.feedback.proguard.z;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.feedback.upload.f;

public class j
  implements s, x
{
  protected final Context a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private f g;
  private com.tencent.feedback.upload.e h;
  private int i = 0;
  
  public j(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, f paramf, com.tencent.feedback.upload.e parame, UploadHandleListener paramUploadHandleListener)
  {
    this.a = paramContext.getApplicationContext();
    if (c.p() == null) {
      c.a(this.a, paramString, "unknown");
    }
    for (;;)
    {
      this.b = 3;
      this.c = 202;
      this.d = 302;
      this.g = paramf;
      this.h = parame;
      if (paramf != null)
      {
        paramf.a(302, parame);
        paramf.a(paramUploadHandleListener);
      }
      paramContext = t.a(this.a);
      paramContext.a(this);
      paramContext.a(this);
      paramContext.a(3, paramf);
      return;
      if ((paramString != null) && (!"10000".equals(paramString)) && (paramString.trim().length() > 0)) {
        c.p().a(paramString);
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
  
  private com.tencent.feedback.upload.e k()
  {
    try
    {
      com.tencent.feedback.upload.e locale = this.h;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int l()
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
  
  public final void a(w paramw)
  {
    e.h("rqdp{  com strateyg changed }%s", new Object[] { getClass().toString() });
    if (paramw != null)
    {
      paramw = paramw.e(this.b);
      if (paramw != null) {
        if ((!paramw.c()) || (!paramw.b())) {
          break label92;
        }
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      if (a() != bool)
      {
        e.f("rqdp{  module} %d rqdp{  able changed }%b", new Object[] { Integer.valueOf(this.b), Boolean.valueOf(bool) });
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
      localObject = ((t)localObject).b().e(this.b);
      if ((localObject != null) && (((w.a)localObject).b() != paramBoolean))
      {
        e.e("rqdp{  mid:}%d rqdp{  change user switch} %b", new Object[] { Integer.valueOf(this.b), Boolean.valueOf(paramBoolean) });
        ((w.a)localObject).a(paramBoolean);
        if ((!((w.a)localObject).b()) || (!((w.a)localObject).c())) {
          break label99;
        }
      }
    }
    label99:
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
  
  public final f c()
  {
    try
    {
      f localf = this.g;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d()
  {
    e.h("rqdp{  com query start }%s", new Object[] { getClass().toString() });
    a(l() + 1);
  }
  
  public void e()
  {
    e.h("rqdp{  com query end }%s", new Object[] { getClass().toString() });
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
        if (localw == null) {
          return;
        }
        w.a locala = localw.e(this.b);
        if ((!a()) || (locala == null)) {
          break label339;
        }
        e.b("rqdp{  isable}", new Object[0]);
        bool1 = locala.d();
        boolean bool2 = localw.k();
        if (!bool1) {
          break label349;
        }
        if (bool2)
        {
          bool1 = true;
          e.b("rqdp{  needDetail} %b rqdp{  allQ:}%b rqdp{  result:}%b", new Object[] { Boolean.valueOf(locala.d()), Boolean.valueOf(localw.k()), Boolean.valueOf(bool1) });
          if (g() <= 0) {
            break label354;
          }
          j = 1;
          if (j == 0) {
            break label300;
          }
          e.e("rqdp{  asyn up module} %d", new Object[] { Integer.valueOf(this.b) });
          b.b().a(new Runnable()
          {
            public final void run()
            {
              j.this.h();
            }
          });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        e.d("rqdp{  common query end error} %s", new Object[] { localThrowable.toString() });
        return;
      }
      if (!i())
      {
        z localz = com.tencent.feedback.proguard.a.a(this.a, this.d);
        if (localz != null)
        {
          com.tencent.feedback.upload.e locale = k();
          if (locale == null) {
            e.c("rqdp{  imposiable eup reshandler not ready}", new Object[0]);
          } else {
            locale.a(this.d, localz.c(), false);
          }
        }
        else if (!i())
        {
          bool1 = true;
          continue;
          label300:
          if (bool1)
          {
            e.e("rqdp{  asyn query module }%d", new Object[] { Integer.valueOf(this.b) });
            b.b().a(new Runnable()
            {
              public final void run()
              {
                j.this.j();
              }
            });
            return;
            label339:
            e.b("rqdp{  disable}", new Object[0]);
          }
          return;
        }
      }
      label349:
      boolean bool1 = false;
      continue;
      label354:
      int j = 0;
    }
  }
  
  public void f()
  {
    e.h("rqdp{  app first start} %s", new Object[] { getClass().toString() });
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
    f localf;
    do
    {
      return false;
      localf = c();
    } while (localf == null);
    localf.a(new com.tencent.feedback.upload.a(this.a, this.b, this.c));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.common.j
 * JD-Core Version:    0.7.0.1
 */