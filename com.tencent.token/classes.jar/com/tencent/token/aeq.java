package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Almond;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public final class aeq
{
  public static long a = TimeUnit.DAYS.toMillis(1L);
  public static long b = TimeUnit.HOURS.toMillis(1L);
  public adh c;
  public Context d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;
  public long j;
  
  public aeq(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = paramContext;
    this.c = new adh(paramInt1);
    this.i = TimeUnit.SECONDS.toMillis(paramInt3);
    this.h = paramInt4;
    this.e = paramInt1;
    this.g = paramInt5;
    this.f = paramInt2;
  }
  
  public aeq(Context paramContext, Almond paramAlmond, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.j = paramAlmond.c;
    this.c = new adh(paramInt1);
    paramContext = paramAlmond.h.iterator();
    while (paramContext.hasNext())
    {
      Long localLong = (Long)paramContext.next();
      this.c.a(localLong);
    }
    this.i = paramAlmond.d;
    this.h = paramAlmond.e;
    this.e = paramInt1;
    this.g = paramAlmond.b;
    this.f = paramInt2;
  }
  
  public final boolean a()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.j;
    long l1 = this.i;
    l2 = Math.abs(l2 - l3);
    boolean bool = true;
    int k;
    if (l2 > l1) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      if (this.c.b.size() < this.f) {
        return true;
      }
      Object localObject = (Long)this.c.b.getFirst();
      if ((Math.abs(System.currentTimeMillis() - ((Long)localObject).longValue()) < a) && (this.c.b.size() >= this.e)) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0)
      {
        localObject = this.c;
        k = ((adh)localObject).b.size();
        int m = this.f;
        localObject = (Long)((adh)localObject).b.get(k - m);
        if (Math.abs(System.currentTimeMillis() - ((Long)localObject).longValue()) >= b) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeq
 * JD-Core Version:    0.7.0.1
 */