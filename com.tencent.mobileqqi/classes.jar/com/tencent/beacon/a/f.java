package com.tencent.beacon.a;

import android.content.Context;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.d.b;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.beacon.upload.h;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  implements UploadHandleListener
{
  private static f d = null;
  private d a;
  private d b;
  private Context c = null;
  
  private f(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    h.a(this.c).a(this);
    c();
    if (d() > 0) {
      e();
    }
  }
  
  private d a()
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
        this.b = new d(1, this.b.b, 1L + this.b.c, this.b.d + l1, this.b.e + l2, this.b.f + paramLong1, this.b.g + paramLong2);
        this.b.a(l4);
        continue;
        l3 = this.a.a();
      }
      finally {}
      label190:
      this.a = new d(0, this.a.b, this.a.c + 1L, l1 + this.a.d, l2 + this.a.e, this.a.f + paramLong1, this.a.g + paramLong2);
      this.a.a(l3);
      continue;
      label277:
      if (paramBoolean) {
        l2 = 0L;
      }
    }
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
      d();
      d locald = this.b;
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
    return a(paramContext).a();
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
  
  private void c()
  {
    Object localObject = e.k(this.c);
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
  
  public static void c(Context paramContext)
  {
    paramContext = a(paramContext);
    long l = new Date().getTime();
    d locald = paramContext.a();
    if ((locald != null) && (locald.a() >= 0L)) {
      e.b(paramContext.c, new d[] { locald });
    }
    paramContext.a(new d(0, l, 0L, 0L, 0L, 0L, 0L));
  }
  
  private int d()
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
  
  public static d d(Context paramContext)
  {
    return a(paramContext).b();
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    d locald = a();
    if (locald != null) {
      localArrayList.add(locald);
    }
    locald = b();
    if (locald != null) {
      localArrayList.add(locald);
    }
    if (localArrayList.size() > 0) {
      e.a(this.c, (d[])localArrayList.toArray(new d[localArrayList.size()]));
    }
  }
  
  public final void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    com.tencent.beacon.d.a.h(" req:%d  res:%d  send:%d  recv:%d  result: %b  msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString });
    c();
    d();
    a(paramLong1, paramLong2, b.a(this.c));
    e();
    com.tencent.beacon.d.a.f(" [total:%s] \n[today:%s]", new Object[] { a(), b() });
  }
  
  public final void onUploadStart(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f
 * JD-Core Version:    0.7.0.1
 */