package com.tencent.turingfd.sdk.base;

import android.os.Handler;

public class ci
  extends am
{
  public ci(cr paramcr, String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      if (!cr.c(this.a)) {
        return;
      }
      if (cr.g(this.a) == null) {
        return;
      }
    }
    if (!cr.g(this.a).a(cr.a(this.a).b, cr.h(this.a))) {
      return;
    }
    long l = cr.g(this.a).e.b;
    cs localcs = cr.f(this.a);
    int i = (int)(cr.a(this.a).b / dy.a);
    localcs.a = 1;
    localcs.b = i;
    localcs.c = l;
    l = l + dy.a - System.currentTimeMillis();
    if (l > 0L) {
      cr.d(this.a).postDelayed(cr.f(this.a), l);
    }
    for (;;)
    {
      return;
      cr.d(this.a).post(cr.f(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ci
 * JD-Core Version:    0.7.0.1
 */