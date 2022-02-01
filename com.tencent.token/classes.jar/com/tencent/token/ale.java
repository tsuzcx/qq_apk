package com.tencent.token;

import java.util.concurrent.TimeUnit;

public final class ale
  extends alp
{
  public alp a;
  
  public ale(alp paramalp)
  {
    if (paramalp != null)
    {
      this.a = paramalp;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final alp a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public final alp a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public final long c()
  {
    return this.a.c();
  }
  
  public final alp d()
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
  
  public final alp f_()
  {
    return this.a.f_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ale
 * JD-Core Version:    0.7.0.1
 */