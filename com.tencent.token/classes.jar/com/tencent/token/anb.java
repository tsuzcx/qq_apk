package com.tencent.token;

import java.util.concurrent.TimeUnit;

public final class anb
  extends anm
{
  public anm a;
  
  public anb(anm paramanm)
  {
    if (paramanm != null)
    {
      this.a = paramanm;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final anm a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public final anm a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public final long c()
  {
    return this.a.c();
  }
  
  public final anm d()
  {
    return this.a.d();
  }
  
  public final long e_()
  {
    return this.a.e_();
  }
  
  public final void f()
  {
    this.a.f();
  }
  
  public final boolean f_()
  {
    return this.a.f_();
  }
  
  public final anm g_()
  {
    return this.a.g_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anb
 * JD-Core Version:    0.7.0.1
 */