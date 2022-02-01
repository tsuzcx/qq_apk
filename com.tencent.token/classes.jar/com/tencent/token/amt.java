package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class amt
  extends anm
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  @Nullable
  static amt b;
  private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
  private boolean e;
  @Nullable
  private amt f;
  private long g;
  
  private static void a(amt paramamt, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        b = new amt();
        new a().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        paramamt.g = (Math.min(paramLong, paramamt.c() - l) + l);
      }
      else if (paramLong != 0L)
      {
        paramamt.g = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label180;
        }
        paramamt.g = paramamt.c();
      }
      paramLong = paramamt.g;
      for (amt localamt = b; (localamt.f != null) && (paramLong - l >= localamt.f.g - l); localamt = localamt.f) {}
      paramamt.f = localamt.f;
      localamt.f = paramamt;
      if (localamt == b)
      {
        amt.class.notify();
        return;
      }
      return;
      label180:
      throw new AssertionError();
    }
    finally {}
  }
  
  private static boolean a(amt paramamt)
  {
    try
    {
      for (amt localamt = b; localamt != null; localamt = localamt.f) {
        if (localamt.f == paramamt)
        {
          localamt.f = paramamt.f;
          paramamt.f = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  @Nullable
  static amt e()
  {
    amt localamt = b.f;
    if (localamt == null)
    {
      l1 = System.nanoTime();
      amt.class.wait(a);
      if ((b.f == null) && (System.nanoTime() - l1 >= d)) {
        return b;
      }
      return null;
    }
    long l1 = System.nanoTime();
    l1 = localamt.g - l1;
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      amt.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    b.f = localamt.f;
    localamt.f = null;
    return localamt;
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
    if (d_())
    {
      if (!paramBoolean) {
        return;
      }
      throw a(null);
    }
  }
  
  final IOException b(IOException paramIOException)
  {
    if (!d_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final void c_()
  {
    if (!this.e)
    {
      long l = e_();
      boolean bool = f_();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.e = true;
      a(this, l, bool);
      return;
    }
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  public final boolean d_()
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
            amt localamt = amt.e();
            if (localamt == null) {}
            if (localamt == amt.b)
            {
              amt.b = null;
              return;
            }
            localamt.a();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amt
 * JD-Core Version:    0.7.0.1
 */