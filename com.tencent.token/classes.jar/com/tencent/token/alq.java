package com.tencent.token;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class alq
{
  public static final alq c = new alq()
  {
    public final alq a(long paramAnonymousLong)
    {
      return this;
    }
    
    public final alq a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
    
    public final void f() {}
  };
  private boolean a;
  private long b;
  private long d;
  
  public alq a(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public alq a(long paramLong, TimeUnit paramTimeUnit)
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
  
  public alq d()
  {
    this.d = 0L;
    return this;
  }
  
  public long d_()
  {
    return this.d;
  }
  
  public boolean e_()
  {
    return this.a;
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
  
  public alq f_()
  {
    this.a = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alq
 * JD-Core Version:    0.7.0.1
 */