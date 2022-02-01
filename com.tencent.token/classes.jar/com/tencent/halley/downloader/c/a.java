package com.tencent.halley.downloader.c;

import android.os.SystemClock;
import com.tencent.halley.common.b;
import com.tencent.token.l;
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
    locale.j += l1 - l2;
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
            b.c("CostTimeCounter", localStringBuilder.toString());
            l1 = l2;
          }
        }
      }
      return (int)(l1 * 1000L / 2000L);
    }
    
    public final int a()
    {
      return this.c;
    }
    
    public final void a(int paramInt)
    {
      int k = 1;
      int i;
      if (paramInt <= 0) {
        i = 1;
      } else {
        i = 0;
      }
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
      }
      else
      {
        Object localObject = this.d.iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          locala.b += j;
          if ((i == 0) && (locala.b > 2000))
          {
            locala.b = 0;
            locala.a = paramInt;
            i = 1;
          }
        }
        if (i == 0) {
          if (this.d.size() > 2000 / l.f + 1)
          {
            localObject = new StringBuilder("records.size():");
            ((StringBuilder)localObject).append(this.d.size());
            b.d("CostTimeCounter", ((StringBuilder)localObject).toString());
          }
          else
          {
            this.d.add(new a(paramInt));
          }
        }
        if (l - this.b > 200L) {
          j = k;
        } else {
          j = 0;
        }
      }
      if (j != 0)
      {
        this.c = b();
        this.b = l;
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