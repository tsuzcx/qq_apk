package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ak
{
  public static long a = TimeUnit.DAYS.toMillis(1L);
  public static long b = TimeUnit.HOURS.toMillis(1L);
  public v c;
  public Context d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;
  public long j;
  
  public ak(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = paramContext;
    this.c = new v(paramInt1);
    this.i = TimeUnit.SECONDS.toMillis(paramInt3);
    this.h = paramInt4;
    this.e = paramInt1;
    this.g = paramInt5;
    this.f = paramInt2;
  }
  
  public ak(Context paramContext, Virgo paramVirgo)
  {
    this.d = paramContext;
    this.j = paramVirgo.rb;
    this.c = new v(paramVirgo.ub);
    paramContext = paramVirgo.wb.iterator();
    while (paramContext.hasNext())
    {
      Long localLong = (Long)paramContext.next();
      this.c.a(localLong);
    }
    this.i = paramVirgo.sb;
    this.h = paramVirgo.tb;
    this.e = paramVirgo.ub;
    this.g = paramVirgo.qb;
    this.f = paramVirgo.vb;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.j;
    long l3 = this.i;
    if (Math.abs(l1 - l2) > l3) {
      k = 1;
    }
    Object localObject;
    while (k != 0) {
      if (this.c.b() < this.f)
      {
        return true;
        k = 0;
      }
      else
      {
        localObject = (Long)this.c.a();
        if ((Math.abs(System.currentTimeMillis() - ((Long)localObject).longValue()) < a) && (this.c.b() >= this.e)) {
          break label159;
        }
      }
    }
    label159:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {}
      for (;;)
      {
        return false;
        localObject = this.c;
        localObject = (Long)((v)localObject).a(((v)localObject).b() - this.f);
        if (Math.abs(System.currentTimeMillis() - ((Long)localObject).longValue()) >= b) {
          break;
        }
      }
      return false;
    }
  }
  
  public void b()
  {
    this.j = System.currentTimeMillis();
    a.a().a(this.d, this.g, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ak
 * JD-Core Version:    0.7.0.1
 */