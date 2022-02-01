package com.tencent.token;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ajw
{
  static final Executor a = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), akt.a("OkHttp ConnectionPool", true));
  final int b = 5;
  final Runnable c = new Runnable()
  {
    public final void run()
    {
      for (;;)
      {
        long l1 = ajw.this.a(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
        long l2;
        if (l1 > 0L) {
          l2 = l1 / 1000000L;
        }
        try
        {
          synchronized (ajw.this)
          {
            ajw.this.wait(l2, (int)(l1 - 1000000L * l2));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          label65:
          break label65;
        }
      }
      throw localObject;
    }
  };
  final Deque<alb> d = new ArrayDeque();
  final alc e = new alc();
  boolean f;
  private final long h;
  
  public ajw()
  {
    this(TimeUnit.MINUTES);
  }
  
  private ajw(TimeUnit paramTimeUnit)
  {
    this.h = paramTimeUnit.toNanos(5L);
  }
  
  final long a(long paramLong)
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        Iterator localIterator = this.d.iterator();
        long l1 = -9223372036854775808L;
        Object localObject1 = null;
        int i = 0;
        j = 0;
        if (localIterator.hasNext())
        {
          alb localalb = (alb)localIterator.next();
          List localList = localalb.j;
          k = 0;
          if (k < localList.size())
          {
            Object localObject3 = (Reference)localList.get(k);
            if (((Reference)localObject3).get() != null)
            {
              k += 1;
              continue;
            }
            localObject3 = (alf.a)localObject3;
            Object localObject4 = new StringBuilder("A connection to ");
            ((StringBuilder)localObject4).append(localalb.a.a.a);
            ((StringBuilder)localObject4).append(" was leaked. Did you forget to close a response body?");
            localObject4 = ((StringBuilder)localObject4).toString();
            amn.c().a((String)localObject4, ((alf.a)localObject3).a);
            localList.remove(k);
            localalb.g = true;
            if (!localList.isEmpty()) {
              continue;
            }
            localalb.k = (paramLong - this.h);
            k = 0;
          }
          else
          {
            k = localList.size();
            break label351;
            k = i + 1;
            long l2 = paramLong - localalb.k;
            i = k;
            if (l2 <= l1) {
              continue;
            }
            localObject1 = localalb;
            l1 = l2;
            i = k;
          }
        }
        else
        {
          if ((l1 < this.h) && (i <= this.b))
          {
            if (i > 0)
            {
              paramLong = this.h;
              return paramLong - l1;
            }
            if (j > 0)
            {
              paramLong = this.h;
              return paramLong;
            }
            this.f = false;
            return -1L;
          }
          this.d.remove(localObject1);
          akt.a(localObject1.b);
          return 0L;
        }
      }
      finally {}
      label351:
      if (k > 0) {
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajw
 * JD-Core Version:    0.7.0.1
 */