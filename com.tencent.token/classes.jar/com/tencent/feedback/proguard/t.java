package com.tencent.feedback.proguard;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.feedback.common.b;
import com.tencent.feedback.upload.d;
import java.util.ArrayList;
import java.util.List;

public final class t
{
  private static t a;
  private w b = null;
  private boolean c = false;
  private int d = 0;
  private d e = null;
  private Runnable f = null;
  private List<s> g = new ArrayList(5);
  private SparseArray<com.tencent.feedback.upload.e> h = new SparseArray(5);
  private List<x> i = new ArrayList(5);
  
  private t(Context paramContext)
  {
    this.e = new r(paramContext);
    this.f = new u(paramContext);
    b.b().a(this.f);
  }
  
  public static t a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new t(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.feedback.upload.e a()
  {
    try
    {
      if (a != null)
      {
        com.tencent.feedback.upload.e locale = a.f();
        return locale;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private com.tencent.feedback.upload.e f()
  {
    try
    {
      if ((this.h != null) && (this.h.size() > 0))
      {
        com.tencent.feedback.upload.e locale = (com.tencent.feedback.upload.e)this.h.valueAt(0);
        return locale;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private x[] h()
  {
    try
    {
      if ((this.i != null) && (this.i.size() > 0))
      {
        x[] arrayOfx = (x[])this.i.toArray(new x[0]);
        return arrayOfx;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      com.tencent.feedback.common.e.b("rqdp{  step }%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, com.tencent.feedback.upload.e parame)
  {
    try
    {
      if (this.h != null)
      {
        if (parame == null)
        {
          this.h.remove(paramInt);
          return;
        }
        this.h.put(paramInt, parame);
        parame.a(c());
      }
      return;
    }
    finally {}
  }
  
  public final void a(final s params)
  {
    if (params == null) {
      return;
    }
    try
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      if (!this.g.contains(params))
      {
        this.g.add(params);
        final int j = e();
        if (g())
        {
          com.tencent.feedback.common.e.b("rqdp{  add listener should notify app first run! }%s", new Object[] { params.toString() });
          b.b().a(new Runnable()
          {
            public final void run()
            {
              params.f();
            }
          });
        }
        if (j >= 2)
        {
          com.tencent.feedback.common.e.b("rqdp{  add listener should notify app start query!} %s", new Object[] { params.toString() });
          b.b().a(new Runnable()
          {
            public final void run()
            {
              params.d();
              if (j >= 3)
              {
                com.tencent.feedback.common.e.b("rqdp{  query finished should notify}", new Object[0]);
                params.e();
              }
            }
          });
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(w paramw)
  {
    x[] arrayOfx = h();
    if (arrayOfx != null)
    {
      int k = arrayOfx.length;
      int j = 0;
      while (j < k)
      {
        x localx = arrayOfx[j];
        try
        {
          localx.a(paramw);
        }
        catch (Throwable localThrowable)
        {
          if (!com.tencent.feedback.common.e.a(localThrowable)) {
            localThrowable.printStackTrace();
          }
          com.tencent.feedback.common.e.d("rqdp{  com strategy changed error }%s", new Object[] { localThrowable.toString() });
        }
        j += 1;
      }
    }
  }
  
  public final void a(x paramx)
  {
    if (paramx != null) {}
    try
    {
      if ((this.i != null) && (!this.i.contains(paramx))) {
        this.i.add(paramx);
      }
    }
    finally {}
  }
  
  protected final void a(boolean paramBoolean)
  {
    try
    {
      this.c = true;
      com.tencent.feedback.common.e.b("rqdp{  isFirst }%b", new Object[] { Boolean.valueOf(true) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final w b()
  {
    try
    {
      w localw = this.b;
      return localw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(s params)
  {
    try
    {
      if ((this.g != null) && (params != null))
      {
        if (this.g.contains(params)) {
          this.g.remove(params);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public final d c()
  {
    try
    {
      d locald = this.e;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final s[] d()
  {
    try
    {
      if ((this.g != null) && (this.g.size() > 0))
      {
        s[] arrayOfs = (s[])this.g.toArray(new s[0]);
        return arrayOfs;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int j = this.d;
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
 * Qualified Name:     com.tencent.feedback.proguard.t
 * JD-Core Version:    0.7.0.1
 */