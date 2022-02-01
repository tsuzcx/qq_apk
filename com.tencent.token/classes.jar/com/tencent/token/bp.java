package com.tencent.token;

import com.tencent.halley.common.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public final class bp
  implements bj
{
  private static AtomicInteger k = new AtomicInteger(0);
  public d a;
  public int b = 0;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  public az h;
  public long i;
  public int j;
  private d l;
  private byte[] m;
  private int n = 0;
  
  public bp(d paramd)
  {
    new CountDownLatch(1);
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = null;
    this.i = 0L;
    this.j = 20;
    this.l = paramd;
    this.n = k.getAndIncrement();
    this.l.a(this.n);
  }
  
  public final d a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    bo.a().a(this, paramInt);
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final az d()
  {
    return this.h;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.e;
  }
  
  public final int h()
  {
    return this.f;
  }
  
  public final void i()
  {
    this.m = this.l.a();
  }
  
  public final int j()
  {
    return this.n;
  }
  
  public final byte[] k()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bp
 * JD-Core Version:    0.7.0.1
 */