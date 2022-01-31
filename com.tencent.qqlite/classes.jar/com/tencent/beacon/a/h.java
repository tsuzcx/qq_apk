package com.tencent.beacon.a;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.d.b;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class h
  implements UploadHandleListener
{
  private static h e = null;
  private d a;
  private d b;
  private d c;
  private Context d = null;
  
  private h(Context paramContext)
  {
    this.d = paramContext;
    com.tencent.beacon.upload.h.a(this.d).a(this);
    d();
    if (e() > 0) {
      f();
    }
  }
  
  private d a()
  {
    long l1;
    long l2;
    try
    {
      int i = Process.myUid();
      l1 = TrafficStats.getUidRxBytes(i);
      l2 = TrafficStats.getUidTxBytes(i);
      Object localObject = g.n(this.d);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          this.c = ((d)((Iterator)localObject).next());
        }
      }
      if (this.c == null) {
        break label308;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    if ((l1 != this.c.m) || (l2 != this.c.l))
    {
      boolean bool = b.a(this.d);
      this.c.b = System.currentTimeMillis();
      if (l1 - this.c.m > 0L)
      {
        this.c.k = (l1 - this.c.m);
        if (l2 - this.c.l <= 0L) {
          break label263;
        }
        this.c.j = (l2 - this.c.l);
        label187:
        if (!bool) {
          break label275;
        }
        this.c.d = (this.c.d + this.c.k + this.c.j);
      }
      for (;;)
      {
        this.c.m = l1;
        this.c.l = l2;
        c(this.c);
        return this.c;
        this.c.k = l1;
        break;
        label263:
        this.c.j = l2;
        break label187;
        label275:
        this.c.e = (this.c.e + this.c.k + this.c.j);
      }
      label308:
      this.c = new d();
      long l3 = System.currentTimeMillis();
      this.c.b = l3;
      this.c.m = l1;
      this.c.l = l2;
      c(this.c);
    }
    d locald = this.c;
    return locald;
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new h(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      long l3;
      long l2;
      long l1;
      try
      {
        l3 = new Date().getTime();
        l2 = paramLong1 + paramLong2;
        if (paramBoolean)
        {
          l1 = l2;
          break label277;
          if (this.b == null)
          {
            this.b = new d(1, l3, 1L, l1, l2, paramLong1, paramLong2);
            if (this.a != null) {
              break label190;
            }
            this.a = new d(0, l3, 1L, l1, l2, paramLong1, paramLong2);
          }
        }
        else
        {
          l1 = 0L;
          break label277;
        }
        long l4 = this.b.a();
        this.b = new d(1, this.b.b, 1L + this.b.c, this.b.d + l1, this.b.e + l2, this.b.j + paramLong1, this.b.k + paramLong2);
        this.b.a(l4);
        continue;
        l3 = this.a.a();
      }
      finally {}
      label190:
      this.a = new d(0, this.a.b, this.a.c + 1L, l1 + this.a.d, l2 + this.a.e, this.a.j + paramLong1, this.a.k + paramLong2);
      this.a.a(l3);
      continue;
      label277:
      if (paramBoolean) {
        l2 = 0L;
      }
    }
  }
  
  public static void a(Context paramContext, d paramd)
  {
    paramd.i = paramd.m;
    paramd.h = paramd.l;
    paramd.g = paramd.e;
    paramd.f = paramd.d;
    a(paramContext).c(paramd);
  }
  
  private void a(d paramd)
  {
    try
    {
      this.a = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  private d b()
  {
    try
    {
      d locald = this.a;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static d b(Context paramContext)
  {
    return a(paramContext).b();
  }
  
  private void b(d paramd)
  {
    try
    {
      this.b = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  private d c()
  {
    try
    {
      e();
      d locald = this.b;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static d c(Context paramContext)
  {
    return a(paramContext).a();
  }
  
  private void c(d paramd)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramd != null) {
      localArrayList.add(paramd);
    }
    if (localArrayList.size() > 0) {
      g.c(this.d, (d[])localArrayList.toArray(new d[localArrayList.size()]));
    }
  }
  
  private void d()
  {
    Object localObject = g.m(this.d);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.a == 0) {
          a(locald);
        } else if (locald.a == 1) {
          b(locald);
        }
      }
    }
  }
  
  public static void d(Context paramContext)
  {
    paramContext = a(paramContext);
    long l = new Date().getTime();
    d locald = paramContext.b();
    if ((locald != null) && (locald.a() >= 0L)) {
      g.b(paramContext.d, new d[] { locald });
    }
    paramContext.a(new d(0, l, 0L, 0L, 0L, 0L, 0L));
  }
  
  private int e()
  {
    for (;;)
    {
      try
      {
        long l1 = com.tencent.beacon.b.a.f();
        long l2 = new Date().getTime();
        int i = 0;
        if ((this.b == null) || (this.b.b < l1))
        {
          this.b = new d(1, l2, 0L, 0L, 0L, 0L, 0L);
          i = 1;
        }
        if (this.a == null)
        {
          this.a = new d(0, l2, 0L, 0L, 0L, 0L, 0L);
          i += 1;
          return i;
        }
      }
      finally {}
    }
  }
  
  public static void e(Context paramContext)
  {
    paramContext = a(paramContext);
    long l = new Date().getTime();
    d locald = paramContext.c;
    if ((locald != null) && (locald.a() >= 0L)) {
      g.b(paramContext.d, new d[] { locald });
    }
    paramContext.a(new d(2, l, 0L, 0L, 0L, 0L, 0L));
  }
  
  public static d f(Context paramContext)
  {
    return a(paramContext).c();
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    d locald = b();
    if (locald != null) {
      localArrayList.add(locald);
    }
    locald = c();
    if (locald != null) {
      localArrayList.add(locald);
    }
    if (localArrayList.size() > 0) {
      g.a(this.d, (d[])localArrayList.toArray(new d[localArrayList.size()]));
    }
  }
  
  public final void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    com.tencent.beacon.d.a.h(" req:%d  res:%d  send:%d  recv:%d  result: %b  msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString });
    if (paramInt1 != 5)
    {
      d();
      e();
      a(paramLong1, paramLong2, b.a(this.d));
      f();
      com.tencent.beacon.d.a.f(" [total:%s] \n[today:%s]", new Object[] { b(), c() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.a.h
 * JD-Core Version:    0.7.0.1
 */