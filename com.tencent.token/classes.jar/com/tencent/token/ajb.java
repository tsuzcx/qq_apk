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

public final class ajb
  implements Closeable, Flushable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  final akl b;
  final int c;
  ala d;
  final LinkedHashMap<String, b> e;
  int f;
  boolean g;
  boolean h;
  boolean i;
  private long k;
  private long l;
  private final Executor m;
  private final Runnable n;
  
  private void a(a parama)
  {
    try
    {
      b localb = parama.a;
      if (localb.f == parama)
      {
        int i1 = 0;
        while (i1 < this.c)
        {
          parama = localb.d[i1];
          this.b.a(parama);
          i1 += 1;
        }
        this.f += 1;
        localb.f = null;
        if ((false | localb.e))
        {
          localb.e = true;
          this.d.b("CLEAN").h(32);
          this.d.b(localb.a);
          localb.a(this.d);
          this.d.h(10);
        }
        else
        {
          this.e.remove(localb.a);
          this.d.b("REMOVE").h(32);
          this.d.b(localb.a);
          this.d.h(10);
        }
        this.d.flush();
        if ((this.l > this.k) || (a())) {
          this.m.execute(this.n);
        }
        return;
      }
      throw new IllegalStateException();
    }
    finally {}
  }
  
  private boolean a()
  {
    int i1 = this.f;
    return (i1 >= 2000) && (i1 >= this.e.size());
  }
  
  private boolean a(b paramb)
  {
    a locala = paramb.f;
    int i2 = 0;
    int i1 = i2;
    if (locala != null)
    {
      locala = paramb.f;
      i1 = i2;
      if (locala.a.f == locala) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < locala.c.c) {}
      try
      {
        locala.c.b.a(locala.a.d[i1]);
        label73:
        i1 += 1;
        continue;
        locala.a.f = null;
        i1 = i2;
        while (i1 < this.c)
        {
          this.b.a(paramb.c[i1]);
          this.l -= paramb.b[i1];
          paramb.b[i1] = 0L;
          i1 += 1;
        }
        this.f += 1;
        this.d.b("REMOVE").h(32).b(paramb.a).h(10);
        this.e.remove(paramb.a);
        if (a()) {
          this.m.execute(this.n);
        }
        return true;
      }
      catch (IOException localIOException)
      {
        break label73;
      }
    }
  }
  
  private boolean b()
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
  
  private void c()
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      throw new IllegalStateException("cache is closed");
    }
    finally {}
  }
  
  private void d()
  {
    while (this.l > this.k) {
      a((b)this.e.values().iterator().next());
    }
    this.i = false;
  }
  
  public final void close()
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((this.g) && (!this.h))
        {
          b[] arrayOfb = (b[])this.e.values().toArray(new b[this.e.size()]);
          int i2 = arrayOfb.length;
          i1 = 0;
          if (i1 < i2)
          {
            ??? = arrayOfb[i1];
            if (((b)???).f != null)
            {
              a locala = ((b)???).f;
              synchronized (locala.c)
              {
                if (!locala.b)
                {
                  if (locala.a.f == locala) {
                    locala.c.a(locala);
                  }
                  locala.b = true;
                  break label181;
                }
                throw new IllegalStateException();
              }
            }
          }
          else
          {
            d();
            this.d.close();
            this.d = null;
            this.h = true;
          }
        }
        else
        {
          this.h = true;
          return;
        }
      }
      finally {}
      label181:
      i1 += 1;
    }
  }
  
  public final void flush()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      c();
      d();
      this.d.flush();
      return;
    }
    finally {}
  }
  
  public final class a
  {
    final ajb.b a;
    boolean b;
  }
  
  final class b
  {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    ajb.a f;
    
    final void a(ala paramala)
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramala.h(32).k(l);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajb
 * JD-Core Version:    0.7.0.1
 */