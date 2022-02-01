package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.d;

public final class fg
  implements Closeable, Flushable
{
  static final Pattern a;
  final fv b;
  final int c;
  d d;
  final LinkedHashMap<String, b> e;
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
    if (!fg.class.desiredAssertionStatus()) {}
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
  
  void a(a parama, boolean paramBoolean)
  {
    int i3 = 0;
    b localb;
    try
    {
      localb = parama.a;
      if (localb.f != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!localb.e)
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.c) {
            break;
          }
          if (parama.b[i1] == 0)
          {
            parama.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!this.b.b(localb.d[i1]))
          {
            parama.b();
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
        parama = localb.d[i2];
        if (paramBoolean)
        {
          if (this.b.b(parama))
          {
            File localFile = localb.c[i2];
            this.b.a(parama, localFile);
            l1 = localb.b[i2];
            long l2 = this.b.c(localFile);
            localb.b[i2] = l2;
            this.l = (this.l - l1 + l2);
          }
        }
        else {
          this.b.a(parama);
        }
      }
      else
      {
        this.f += 1;
        localb.f = null;
        if ((localb.e | paramBoolean))
        {
          localb.e = true;
          this.d.b("CLEAN").i(32);
          this.d.b(localb.a);
          localb.a(this.d);
          this.d.i(10);
          if (paramBoolean)
          {
            l1 = this.m;
            this.m = (1L + l1);
            localb.g = l1;
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
          this.e.remove(localb.a);
          this.d.b("REMOVE").i(32);
          this.d.b(localb.a);
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
  
  boolean a(b paramb)
  {
    if (paramb.f != null) {
      paramb.f.a();
    }
    int i1 = 0;
    while (i1 < this.c)
    {
      this.b.a(paramb.c[i1]);
      this.l -= paramb.b[i1];
      paramb.b[i1] = 0L;
      i1 += 1;
    }
    this.f += 1;
    this.d.b("REMOVE").i(32).b(paramb.a).i(10);
    this.e.remove(paramb.a);
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
      a((b)this.e.values().iterator().next());
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
        b[] arrayOfb = (b[])this.e.values().toArray(new b[this.e.size()]);
        int i2 = arrayOfb.length;
        int i1 = 0;
        if (i1 < i2)
        {
          b localb = arrayOfb[i1];
          if (localb.f != null) {
            localb.f.b();
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
    //   3: getfield 211	com/tencent/token/fg:g	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 223	com/tencent/token/fg:d	()V
    //   18: aload_0
    //   19: invokevirtual 219	com/tencent/token/fg:c	()V
    //   22: aload_0
    //   23: getfield 132	com/tencent/token/fg:d	Lokio/d;
    //   26: invokeinterface 155 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	fg
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public final class a
  {
    final fg.b a;
    final boolean[] b;
    private boolean d;
    
    void a()
    {
      int i;
      if (this.a.f == this) {
        i = 0;
      }
      for (;;)
      {
        if (i < this.c.c) {}
        try
        {
          this.c.b.a(this.a.d[i]);
          label45:
          i += 1;
          continue;
          this.a.f = null;
          return;
        }
        catch (IOException localIOException)
        {
          break label45;
        }
      }
    }
    
    public void b()
    {
      synchronized (this.c)
      {
        if (this.d) {
          throw new IllegalStateException();
        }
      }
      if (this.a.f == this) {
        this.c.a(this, false);
      }
      this.d = true;
    }
  }
  
  private final class b
  {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    fg.a f;
    long g;
    
    void a(d paramd)
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramd.i(32).l(l);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fg
 * JD-Core Version:    0.7.0.1
 */