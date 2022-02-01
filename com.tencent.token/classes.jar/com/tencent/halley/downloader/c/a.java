package com.tencent.halley.downloader.c;

import android.os.SystemClock;
import com.tencent.halley.common.b;
import com.tencent.token.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private long a = 0L;
  private e b;
  private long c = 0L;
  private long d = 0L;
  private int e = 0;
  private a f = new a((byte)0);
  
  public a(e parame)
  {
    this.b = parame;
  }
  
  public final void a()
  {
    this.a = SystemClock.elapsedRealtime();
    this.c = 0L;
    this.d = 0L;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.e += paramInt2;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.a;
    this.a = l1;
    e locale = this.b;
    locale.j = (l1 - l2 + locale.j);
    this.f.a(paramInt1);
    this.b.q = this.f.a();
  }
  
  public final void b()
  {
    this.c = System.currentTimeMillis();
  }
  
  public final void c()
  {
    this.d = System.currentTimeMillis();
  }
  
  public final long d()
  {
    return this.d - this.c;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  static final class a
  {
    private long a = 0L;
    private long b = 0L;
    private int c = 0;
    private List d = new LinkedList();
    
    private int b()
    {
      if (this.d.size() == 0) {
        return 0;
      }
      Iterator localIterator = this.d.iterator();
      long l1;
      for (long l2 = 0L; localIterator.hasNext(); l2 = l1)
      {
        a locala = (a)localIterator.next();
        l1 = l2;
        if (locala.b <= 2000)
        {
          l2 += locala.a;
          l1 = l2;
          if (l2 < 0L)
          {
            b.c("CostTimeCounter", "sum:" + l2 + ",len:" + locala.a);
            l1 = l2;
          }
        }
      }
      return (int)(1000L * l2 / 2000L);
    }
    
    public final int a()
    {
      return this.c;
    }
    
    public final void a(int paramInt)
    {
      int k = 1;
      if (paramInt <= 0) {}
      for (int i = 1;; i = 0)
      {
        long l = SystemClock.elapsedRealtime();
        int j = (int)(l - this.a);
        this.a = l;
        if (this.d.size() == 0)
        {
          j = k;
          if (i == 0)
          {
            this.d.add(new a(paramInt));
            j = k;
          }
          if (j != 0)
          {
            this.c = b();
            this.b = l;
          }
          return;
        }
        Iterator localIterator = this.d.iterator();
        label99:
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          locala.b += j;
          if ((i != 0) || (locala.b <= 2000)) {
            break label262;
          }
          locala.b = 0;
          locala.a = paramInt;
          i = 1;
        }
        label262:
        for (;;)
        {
          break label99;
          if (i == 0)
          {
            if (this.d.size() <= 2000 / k.f + 1) {
              break label241;
            }
            b.d("CostTimeCounter", "records.size():" + this.d.size());
          }
          for (;;)
          {
            j = k;
            if (l - this.b > 200L) {
              break;
            }
            j = 0;
            break;
            label241:
            this.d.add(new a(paramInt));
          }
        }
      }
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
 * Qualified Name:     com.tencent.halley.downloader.c.a
 * JD-Core Version:    0.7.0.1
 */