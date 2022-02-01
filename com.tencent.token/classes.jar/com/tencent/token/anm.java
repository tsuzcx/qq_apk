package com.tencent.token;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class anm
{
  public static final anm c = new anm()
  {
    public final anm a(long paramAnonymousLong)
    {
      return this;
    }
    
    public final anm a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
    
    public final void f() {}
  };
  private boolean a;
  private long b;
  private long d;
  
  public anm a(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public anm a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        this.d = paramTimeUnit.toNanos(paramLong);
        return this;
      }
      throw new IllegalArgumentException("unit == null");
    }
    throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(paramLong)));
  }
  
  public long c()
  {
    if (this.a) {
      return this.b;
    }
    throw new IllegalStateException("No deadline");
  }
  
  public anm d()
  {
    this.d = 0L;
    return this;
  }
  
  public long e_()
  {
    return this.d;
  }
  
  public void f()
  {
    if (!Thread.interrupted())
    {
      if (this.a)
      {
        if (this.b - System.nanoTime() > 0L) {
          return;
        }
        throw new InterruptedIOException("deadline reached");
      }
      return;
    }
    throw new InterruptedIOException("thread interrupted");
  }
  
  public boolean f_()
  {
    return this.a;
  }
  
  public anm g_()
  {
    this.a = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anm
 * JD-Core Version:    0.7.0.1
 */