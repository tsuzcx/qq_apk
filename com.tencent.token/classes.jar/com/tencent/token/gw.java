package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.h;

public final class gw
  implements Closeable, Flushable
{
  static final Pattern a;
  final hw b;
  final int c;
  h d;
  final LinkedHashMap e;
  int f;
  boolean g;
  boolean h;
  boolean i;
  private long k;
  private long l;
  private long m;
  private final Executor n;
  private final Runnable o;
  
  static
  {
    if (!gw.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      a = Pattern.compile("[a-z0-9_-]{1,120}");
      return;
    }
  }
  
  private void d()
  {
    try
    {
      if (b()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  void a(gx paramgx, boolean paramBoolean)
  {
    int i3 = 0;
    gy localgy;
    try
    {
      localgy = paramgx.a;
      if (localgy.f != paramgx) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!localgy.e)
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.c) {
            break;
          }
          if (paramgx.b[i1] == 0)
          {
            paramgx.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!this.b.b(localgy.d[i1]))
          {
            paramgx.b();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.c)
      {
        paramgx = localgy.d[i2];
        if (paramBoolean)
        {
          if (this.b.b(paramgx))
          {
            File localFile = localgy.c[i2];
            this.b.a(paramgx, localFile);
            l1 = localgy.b[i2];
            long l2 = this.b.c(localFile);
            localgy.b[i2] = l2;
            this.l = (this.l - l1 + l2);
          }
        }
        else {
          this.b.a(paramgx);
        }
      }
      else
      {
        this.f += 1;
        localgy.f = null;
        if ((localgy.e | paramBoolean))
        {
          localgy.e = true;
          this.d.b("CLEAN").i(32);
          this.d.b(localgy.a);
          localgy.a(this.d);
          this.d.i(10);
          if (paramBoolean)
          {
            l1 = this.m;
            this.m = (1L + l1);
            localgy.g = l1;
          }
        }
        for (;;)
        {
          this.d.flush();
          if ((this.l <= this.k) && (!a())) {
            break;
          }
          this.n.execute(this.o);
          break;
          this.e.remove(localgy.a);
          this.d.b("REMOVE").i(32);
          this.d.b(localgy.a);
          this.d.i(10);
        }
      }
      i2 += 1;
    }
  }
  
  boolean a()
  {
    return (this.f >= 2000) && (this.f >= this.e.size());
  }
  
  boolean a(gy paramgy)
  {
    if (paramgy.f != null) {
      paramgy.f.a();
    }
    int i1 = 0;
    while (i1 < this.c)
    {
      this.b.a(paramgy.c[i1]);
      this.l -= paramgy.b[i1];
      paramgy.b[i1] = 0L;
      i1 += 1;
    }
    this.f += 1;
    this.d.b("REMOVE").i(32).b(paramgy.a).i(10);
    this.e.remove(paramgy.a);
    if (a()) {
      this.n.execute(this.o);
    }
    return true;
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void c()
  {
    while (this.l > this.k) {
      a((gy)this.e.values().iterator().next());
    }
    this.i = false;
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        if ((!this.g) || (this.h))
        {
          this.h = true;
          return;
        }
        gy[] arrayOfgy = (gy[])this.e.values().toArray(new gy[this.e.size()]);
        int i2 = arrayOfgy.length;
        int i1 = 0;
        if (i1 < i2)
        {
          gy localgy = arrayOfgy[i1];
          if (localgy.f != null) {
            localgy.f.b();
          }
        }
        else
        {
          c();
          this.d.close();
          this.d = null;
          this.h = true;
          continue;
        }
        i1 += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/token/gw:g	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 222	com/tencent/token/gw:d	()V
    //   18: aload_0
    //   19: invokevirtual 218	com/tencent/token/gw:c	()V
    //   22: aload_0
    //   23: getfield 131	com/tencent/token/gw:d	Lokio/h;
    //   26: invokeinterface 154 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	gw
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gw
 * JD-Core Version:    0.7.0.1
 */