package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class akx
  extends alq
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  @Nullable
  static akx b;
  private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
  private boolean e;
  @Nullable
  private akx f;
  private long g;
  
  private static void a(akx paramakx, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        b = new akx();
        new a().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        paramakx.g = (Math.min(paramLong, paramakx.c() - l) + l);
      }
      else if (paramLong != 0L)
      {
        paramakx.g = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label180;
        }
        paramakx.g = paramakx.c();
      }
      paramLong = paramakx.g;
      for (akx localakx = b; (localakx.f != null) && (paramLong - l >= localakx.f.g - l); localakx = localakx.f) {}
      paramakx.f = localakx.f;
      localakx.f = paramakx;
      if (localakx == b)
      {
        akx.class.notify();
        return;
      }
      return;
      label180:
      throw new AssertionError();
    }
    finally {}
  }
  
  private static boolean a(akx paramakx)
  {
    try
    {
      for (akx localakx = b; localakx != null; localakx = localakx.f) {
        if (localakx.f == paramakx)
        {
          localakx.f = paramakx.f;
          paramakx.f = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  @Nullable
  static akx e()
  {
    akx localakx = b.f;
    if (localakx == null)
    {
      l1 = System.nanoTime();
      akx.class.wait(a);
      if ((b.f == null) && (System.nanoTime() - l1 >= d)) {
        return b;
      }
      return null;
    }
    long l1 = System.nanoTime();
    l1 = localakx.g - l1;
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      akx.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    b.f = localakx.f;
    localakx.f = null;
    return localakx;
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
            akx localakx = akx.e();
            if (localakx == null) {}
            if (localakx == akx.b)
            {
              akx.b = null;
              return;
            }
            localakx.a();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akx
 * JD-Core Version:    0.7.0.1
 */