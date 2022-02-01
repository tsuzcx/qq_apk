package com.tencent.token;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ly
{
  long a = 0L;
  long b = 0L;
  long c = 0L;
  int d = 0;
  private mk e;
  private a f = new a((byte)0);
  
  public ly(mk parammk)
  {
    this.e = parammk;
  }
  
  public final long a()
  {
    return this.c - this.b;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d += paramInt2;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.a;
    this.a = l1;
    Object localObject1 = this.e;
    ((mk)localObject1).m += l1 - l2;
    localObject1 = this.f;
    int j = 1;
    if (paramInt1 <= 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    l1 = SystemClock.elapsedRealtime();
    int i = (int)(l1 - ((a)localObject1).a);
    ((a)localObject1).a = l1;
    if (((a)localObject1).d.size() == 0)
    {
      i = j;
      if (paramInt2 == 0)
      {
        ((a)localObject1).d.add(new ly.a.a(paramInt1));
        i = j;
      }
    }
    else
    {
      Object localObject2 = ((a)localObject1).d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ly.a.a locala = (ly.a.a)((Iterator)localObject2).next();
        locala.b += i;
        if ((paramInt2 == 0) && (locala.b > 2000))
        {
          locala.b = 0;
          locala.a = paramInt1;
          paramInt2 = 1;
        }
      }
      if (paramInt2 == 0) {
        if (((a)localObject1).d.size() > 2000 / kx.f + 1)
        {
          localObject2 = new StringBuilder("records.size():");
          ((StringBuilder)localObject2).append(((a)localObject1).d.size());
          lh.d("CostTimeCounter", ((StringBuilder)localObject2).toString());
        }
        else
        {
          ((a)localObject1).d.add(new ly.a.a(paramInt1));
        }
      }
      if (l1 - ((a)localObject1).b > 200L) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0)
    {
      ((a)localObject1).c = ((a)localObject1).a();
      ((a)localObject1).b = l1;
    }
    this.e.t = this.f.c;
  }
  
  static final class a
  {
    long a = 0L;
    long b = 0L;
    int c = 0;
    List d = new LinkedList();
    
    final int a()
    {
      if (this.d.size() == 0) {
        return 0;
      }
      Iterator localIterator = this.d.iterator();
      long l1 = 0L;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.b <= 2000)
        {
          long l2 = l1 + locala.a;
          l1 = l2;
          if (l2 < 0L)
          {
            StringBuilder localStringBuilder = new StringBuilder("sum:");
            localStringBuilder.append(l2);
            localStringBuilder.append(",len:");
            localStringBuilder.append(locala.a);
            lh.c("CostTimeCounter", localStringBuilder.toString());
            l1 = l2;
          }
        }
      }
      return (int)(l1 * 1000L / 2000L);
    }
    
    static final class a
    {
      public int a = 0;
      public int b = 0;
      
      public a(int paramInt)
      {
        this.a = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ly
 * JD-Core Version:    0.7.0.1
 */