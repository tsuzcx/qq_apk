package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class eg
{
  public static long a = TimeUnit.DAYS.toMillis(1L);
  public static long b = TimeUnit.HOURS.toMillis(1L);
  public ak c;
  public Context d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;
  public long j;
  
  public eg(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = paramContext;
    this.c = new ak(paramInt1);
    this.i = TimeUnit.SECONDS.toMillis(paramInt3);
    this.h = paramInt4;
    this.e = paramInt1;
    this.g = paramInt5;
    this.f = paramInt2;
  }
  
  public eg(Context paramContext, Centaurus paramCentaurus)
  {
    this.d = paramContext;
    this.j = paramCentaurus.qb;
    this.c = new ak(paramCentaurus.tb);
    paramContext = paramCentaurus.vb.iterator();
    while (paramContext.hasNext())
    {
      Long localLong = (Long)paramContext.next();
      this.c.a(localLong);
    }
    this.i = paramCentaurus.rb;
    this.h = paramCentaurus.sb;
    this.e = paramCentaurus.tb;
    this.g = paramCentaurus.pb;
    this.f = paramCentaurus.ub;
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
        localObject = (Long)((ak)localObject).a(((ak)localObject).b() - this.f);
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
    ai.a().a(this.d, this.g, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.eg
 * JD-Core Version:    0.7.0.1
 */