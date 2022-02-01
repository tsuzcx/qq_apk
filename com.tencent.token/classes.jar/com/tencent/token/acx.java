package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.base.Virgo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public final class acx
{
  public static long a = TimeUnit.DAYS.toMillis(1L);
  public static long b = TimeUnit.HOURS.toMillis(1L);
  public aci c;
  public Context d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;
  public long j;
  
  public acx(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = paramContext;
    this.c = new aci(paramInt1);
    this.i = TimeUnit.SECONDS.toMillis(paramInt3);
    this.h = paramInt4;
    this.e = paramInt1;
    this.g = paramInt5;
    this.f = paramInt2;
  }
  
  public acx(Context paramContext, Virgo paramVirgo)
  {
    this.d = paramContext;
    this.j = paramVirgo.rb;
    this.c = new aci(paramVirgo.ub);
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
        localObject = (Long)((aci)localObject).a(((aci)localObject).b.size() - this.f);
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
  
  public final void b()
  {
    this.j = System.currentTimeMillis();
    abn.a();
    abn.a(this.d, this.g, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acx
 * JD-Core Version:    0.7.0.1
 */