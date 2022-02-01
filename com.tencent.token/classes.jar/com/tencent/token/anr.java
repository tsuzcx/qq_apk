package com.tencent.token;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class anr
  extends aok
{
  private static final long a = TimeUnit.SECONDS.toMillis(60L);
  @Nullable
  static anr b;
  private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
  private boolean e;
  @Nullable
  private anr f;
  private long g;
  
  private static void a(anr paramanr, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (b == null)
      {
        b = new anr();
        new a().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        paramanr.g = (Math.min(paramLong, paramanr.c() - l) + l);
      }
      else if (paramLong != 0L)
      {
        paramanr.g = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label180;
        }
        paramanr.g = paramanr.c();
      }
      paramLong = paramanr.g;
      for (anr localanr = b; (localanr.f != null) && (paramLong - l >= localanr.f.g - l); localanr = localanr.f) {}
      paramanr.f = localanr.f;
      localanr.f = paramanr;
      if (localanr == b)
      {
        anr.class.notify();
        return;
      }
      return;
      label180:
      throw new AssertionError();
    }
    finally {}
  }
  
  private static boolean a(anr paramanr)
  {
    try
    {
      for (anr localanr = b; localanr != null; localanr = localanr.f) {
        if (localanr.f == paramanr)
        {
          localanr.f = paramanr.f;
          paramanr.f = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  @Nullable
  static anr e()
  {
    anr localanr = b.f;
    if (localanr == null)
    {
      l1 = System.nanoTime();
      anr.class.wait(a);
      if ((b.f == null) && (System.nanoTime() - l1 >= d)) {
        return b;
      }
      return null;
    }
    long l1 = System.nanoTime();
    l1 = localanr.g - l1;
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      anr.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    b.f = localanr.f;
    localanr.f = null;
    return localanr;
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
            anr localanr = anr.e();
            if (localanr == null) {}
            if (localanr == anr.b)
            {
              anr.b = null;
              return;
            }
            localanr.a();
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anr
 * JD-Core Version:    0.7.0.1
 */