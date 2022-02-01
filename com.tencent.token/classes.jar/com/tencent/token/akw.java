package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class akw
  extends alp
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  @Nullable
  static akw b;
  private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
  private boolean e;
  @Nullable
  private akw f;
  private long g;
  
  private static void a(akw paramakw, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        b = new akw();
        new a().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        paramakw.g = (Math.min(paramLong, paramakw.c() - l) + l);
      }
      else if (paramLong != 0L)
      {
        paramakw.g = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label180;
        }
        paramakw.g = paramakw.c();
      }
      paramLong = paramakw.g;
      for (akw localakw = b; (localakw.f != null) && (paramLong - l >= localakw.f.g - l); localakw = localakw.f) {}
      paramakw.f = localakw.f;
      localakw.f = paramakw;
      if (localakw == b)
      {
        akw.class.notify();
        return;
      }
      return;
      label180:
      throw new AssertionError();
    }
    finally {}
  }
  
  private static boolean a(akw paramakw)
  {
    try
    {
      for (akw localakw = b; localakw != null; localakw = localakw.f) {
        if (localakw.f == paramakw)
        {
          localakw.f = paramakw.f;
          paramakw.f = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  @Nullable
  static akw e()
  {
    akw localakw = b.f;
    if (localakw == null)
    {
      l1 = System.nanoTime();
      akw.class.wait(a);
      if ((b.f == null) && (System.nanoTime() - l1 >= d)) {
        return b;
      }
      return null;
    }
    long l1 = System.nanoTime();
    l1 = localakw.g - l1;
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      akw.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    b.f = localakw.f;
    localakw.f = null;
    return localakw;
  }
  
  protected IOException a(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  protected void a() {}
  
  final void a(boolean paramBoolean)
  {
    if (c_())
    {
      if (!paramBoolean) {
        return;
      }
      throw a(null);
    }
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!c_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final void b_()
  {
    if (!this.e)
    {
      long l = d_();
      boolean bool = e_();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.e = true;
      a(this, l, bool);
      return;
    }
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  public final boolean c_()
  {
    if (!this.e) {
      return false;
    }
    this.e = false;
    return a(this);
  }
  
  static final class a
    extends Thread
  {
    a()
    {
      super();
      setDaemon(true);
    }
    
    public final void run()
    {
      try
      {
        for (;;)
        {
          try
          {
            akw localakw = akw.e();
            if (localakw == null) {}
            if (localakw == akw.b)
            {
              akw.b = null;
              return;
            }
            localakw.a();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akw
 * JD-Core Version:    0.7.0.1
 */