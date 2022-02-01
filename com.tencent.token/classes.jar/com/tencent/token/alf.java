package com.tencent.token;

import java.util.concurrent.TimeUnit;

public final class alf
  extends alq
{
  public alq a;
  
  public alf(alq paramalq)
  {
    if (paramalq != null)
    {
      this.a = paramalq;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final alq a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public final alq a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public final long c()
  {
    return this.a.c();
  }
  
  public final alq d()
  {
    return this.a.d();
  }
  
  public final long d_()
  {
    return this.a.d_();
  }
  
  public final boolean e_()
  {
    return this.a.e_();
  }
  
  public final void f()
  {
    this.a.f();
  }
  
  public final alq f_()
  {
    return this.a.f_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alf
 * JD-Core Version:    0.7.0.1
 */