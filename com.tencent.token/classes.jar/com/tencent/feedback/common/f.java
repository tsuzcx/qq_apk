package com.tencent.feedback.common;

import android.content.Context;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.p;
import com.tencent.feedback.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  implements UploadHandleListener
{
  private static f d;
  private p a;
  private p b;
  private Context c = null;
  
  private f(Context paramContext)
  {
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
    this.c = paramContext;
    com.tencent.feedback.upload.f.a(this.c).a(this);
    c();
    if (d() > 0) {
      e();
    }
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new f(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private p a()
  {
    try
    {
      p localp = this.a;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      long l2;
      try
      {
        l3 = new Date().getTime();
        l2 = paramLong1 + paramLong2;
        if (!paramBoolean) {
          break label271;
        }
        l1 = l2;
      }
      finally {}
      if (this.b == null)
      {
        this.b = new p(1, l3, 1L, l1, l2, paramLong1, paramLong2);
      }
      else
      {
        long l4 = this.b.a();
        this.b = new p(1, this.b.b, this.b.c + 1L, this.b.d + l1, this.b.e + l2, this.b.f + paramLong1, this.b.g + paramLong2);
        this.b.a(l4);
      }
      if (this.a == null)
      {
        this.a = new p(0, l3, 1L, l1, l2, paramLong1, paramLong2);
        return;
      }
      long l3 = this.a.a();
      this.a = new p(0, this.a.b, this.a.c + 1L, this.a.d + l1, this.a.e + l2, this.a.f + paramLong1, this.a.g + paramLong2);
      this.a.a(l3);
      return;
      label271:
      long l1 = 0L;
      if (paramBoolean) {
        l2 = 0L;
      }
    }
  }
  
  private void a(p paramp)
  {
    try
    {
      this.a = paramp;
      return;
    }
    finally
    {
      paramp = finally;
      throw paramp;
    }
  }
  
  private p b()
  {
    try
    {
      d();
      p localp = this.b;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static p b(Context paramContext)
  {
    return a(paramContext).a();
  }
  
  private void b(p paramp)
  {
    try
    {
      this.b = paramp;
      return;
    }
    finally
    {
      paramp = finally;
      throw paramp;
    }
  }
  
  private void c()
  {
    Object localObject = a.a(this.c);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        p localp = (p)((Iterator)localObject).next();
        if (localp.a == 0) {
          a(localp);
        } else if (localp.a == 1) {
          b(localp);
        }
      }
    }
  }
  
  public static void c(Context paramContext)
  {
    paramContext = a(paramContext);
    long l = new Date().getTime();
    p localp = paramContext.a();
    if ((localp != null) && (localp.a() >= 0L)) {
      a.b(paramContext.c, new p[] { localp });
    }
    paramContext.a(new p(0, l, 0L, 0L, 0L, 0L, 0L));
  }
  
  private int d()
  {
    try
    {
      long l1 = a.c();
      long l2 = new Date().getTime();
      int i = 0;
      if ((this.b == null) || (this.b.b < l1))
      {
        this.b = new p(1, l2, 0L, 0L, 0L, 0L, 0L);
        i = 1;
      }
      int j = i;
      if (this.a == null)
      {
        this.a = new p(0, l2, 0L, 0L, 0L, 0L, 0L);
        j = i + 1;
      }
      return j;
    }
    finally {}
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    p localp = a();
    if (localp != null) {
      localArrayList.add(localp);
    }
    localp = b();
    if (localp != null) {
      localArrayList.add(localp);
    }
    if (localArrayList.size() > 0) {
      a.a(this.c, (p[])localArrayList.toArray(new p[localArrayList.size()]));
    }
  }
  
  public final void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    e.a("rqdp{  req:}%d rqdp{  res:}%d rqdp{  send:}%d rqdp{  recv:}%d rqdp{  result:}%b rqdp{  msg:}%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString });
    c();
    d();
    a(paramLong1, paramLong2, g.a(this.c));
    e();
    e.b("rqdp{  [total:}%s]rqdp{  \n[today:}%s]", new Object[] { a(), b() });
  }
  
  public final void onUploadStart(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.f
 * JD-Core Version:    0.7.0.1
 */