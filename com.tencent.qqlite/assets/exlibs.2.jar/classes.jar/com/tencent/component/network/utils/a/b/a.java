package com.tencent.component.network.utils.a.b;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class a
{
  private final Lock a = new ReentrantLock();
  private final d<T, C> b;
  private final Map<T, g<T, C, E>> c;
  private final Set<E> d;
  private final LinkedList<E> e;
  private final LinkedList<f<E>> f;
  private final Map<T, Integer> g;
  private volatile boolean h;
  private volatile int i;
  private volatile int j;
  
  public a(d<T, C> paramd)
  {
    this.b = paramd;
    this.c = new HashMap();
    this.d = new HashSet();
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = new HashMap();
    this.i = 2;
    this.j = 20;
  }
  
  private E a(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, f<E> paramf)
    throws IOException, InterruptedException, TimeoutException
  {
    g localg;
    Object localObject;
    label69:
    e locale;
    int k;
    label210:
    int n;
    int m;
    if (paramLong > 0L)
    {
      paramTimeUnit = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
      this.a.lock();
      try
      {
        localg = a(paramT);
        localObject = null;
      }
      finally
      {
        this.a.unlock();
      }
      throw new TimeoutException("Timeout waiting for connection");
      if (this.h) {
        throw new IllegalStateException("Connection pool shut down");
      }
      for (;;)
      {
        locale = localg.b(paramObject);
        if ((locale == null) || ((!locale.d()) && (!locale.a(System.currentTimeMillis())))) {
          break;
        }
        locale.e();
        this.e.remove(locale);
        localg.a(locale, false);
      }
      if (locale != null)
      {
        this.e.remove(locale);
        this.d.add(locale);
        this.a.unlock();
        return locale;
      }
      localObject = (Integer)this.g.get(paramT);
      if (localObject != null)
      {
        k = ((Integer)localObject).intValue();
        n = Math.max(0, localg.a() + 1 - k);
        if (n > 0)
        {
          m = 0;
          break label532;
        }
      }
    }
    for (;;)
    {
      label237:
      if (localg.a() < k)
      {
        k = this.d.size();
        k = Math.max(this.j - k, 0);
        if (k > 0)
        {
          if ((this.e.size() > k - 1) && (!this.e.isEmpty()))
          {
            paramT = (e)this.e.removeLast();
            paramT.e();
            a(paramT.f()).a(paramT);
          }
          paramT = localg.c(this.b.a());
          this.d.add(paramT);
          this.a.unlock();
          return paramT;
          k = this.i;
          break label210;
        }
      }
      label532:
      do
      {
        for (;;)
        {
          localObject = localg.b();
          if (localObject == null) {
            break label237;
          }
          ((e)localObject).e();
          this.e.remove(localObject);
          localg.a((e)localObject);
          m += 1;
          break label532;
          try
          {
            localg.a(paramf);
            this.f.add(paramf);
            boolean bool = paramf.a(paramTimeUnit);
            localg.b(paramf);
            this.f.remove(paramf);
            localObject = locale;
            if (!bool)
            {
              localObject = locale;
              if (paramTimeUnit != null)
              {
                if (paramTimeUnit.getTime() <= System.currentTimeMillis()) {
                  break;
                }
                localObject = locale;
              }
            }
          }
          finally
          {
            localg.b(paramf);
            this.f.remove(paramf);
          }
        }
        if (localObject == null) {
          break label69;
        }
        break;
      } while (m < n);
    }
  }
  
  private g<T, C, E> a(T paramT)
  {
    g localg = (g)this.c.get(paramT);
    Object localObject = localg;
    if (localg == null)
    {
      localObject = new b(this, paramT, paramT);
      this.c.put(paramT, localObject);
    }
    return localObject;
  }
  
  private void a(g<T, C, E> paramg)
  {
    paramg = paramg.c();
    if (paramg != null) {
      this.f.remove(paramg);
    }
    for (;;)
    {
      if (paramg != null) {
        paramg.a();
      }
      return;
      paramg = (f)this.f.poll();
    }
  }
  
  protected abstract E a(T paramT, C paramC);
  
  public final void a()
    throws IOException
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.a.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.e.iterator();
        if (!localIterator.hasNext())
        {
          localIterator = this.d.iterator();
          if (!localIterator.hasNext())
          {
            localIterator = this.c.values().iterator();
            if (localIterator.hasNext()) {
              break label159;
            }
            this.c.clear();
            this.d.clear();
            this.e.clear();
          }
        }
        else
        {
          ((e)localIterator.next()).e();
          continue;
        }
        ((e)localObject.next()).e();
      }
      finally
      {
        this.a.unlock();
      }
      continue;
      label159:
      ((g)localObject.next()).d();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.a.lock();
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final void a(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong < 0L)
    {
      paramLong = l;
      for (;;)
      {
        l = System.currentTimeMillis();
        this.a.lock();
        try
        {
          paramTimeUnit = this.e.iterator();
          for (;;)
          {
            boolean bool = paramTimeUnit.hasNext();
            if (!bool) {
              return;
            }
            e locale = (e)paramTimeUnit.next();
            if (locale.i() <= l - paramLong)
            {
              locale.e();
              g localg = a(locale.f());
              localg.a(locale);
              paramTimeUnit.remove();
              a(localg);
            }
          }
        }
        finally
        {
          this.a.unlock();
        }
      }
    }
  }
  
  /* Error */
  public final void a(E paramE, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 98 1 0
    //   9: aload_0
    //   10: getfield 49	com/tencent/component/network/utils/a/b/a:d	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 267 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 176	com/tencent/component/network/utils/a/b/e:f	()Ljava/lang/Object;
    //   27: invokespecial 101	com/tencent/component/network/utils/a/b/a:a	(Ljava/lang/Object;)Lcom/tencent/component/network/utils/a/b/g;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 138	com/tencent/component/network/utils/a/b/g:a	(Lcom/tencent/component/network/utils/a/b/e;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 111	com/tencent/component/network/utils/a/b/a:h	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 54	com/tencent/component/network/utils/a/b/a:e	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 271	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/component/network/utils/a/b/a:a	(Lcom/tencent/component/network/utils/a/b/g;)V
    //   61: aload_0
    //   62: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 109 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 131	com/tencent/component/network/utils/a/b/e:e	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 109 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramE	E
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localg	g
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public final Future<E> b(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.h) {
      throw new IllegalStateException("Connection pool shut down");
    }
    return new c(this, this.a, paramT, paramObject);
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   8: invokeinterface 98 1 0
    //   13: aload_0
    //   14: getfield 54	com/tencent/component/network/utils/a/b/a:e	Ljava/util/LinkedList;
    //   17: invokevirtual 228	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   20: astore 4
    //   22: aload 4
    //   24: invokeinterface 233 1 0
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +13 -> 44
    //   34: aload_0
    //   35: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   38: invokeinterface 109 1 0
    //   43: return
    //   44: aload 4
    //   46: invokeinterface 249 1 0
    //   51: checkcast 123	com/tencent/component/network/utils/a/b/e
    //   54: astore 5
    //   56: aload 5
    //   58: lload_1
    //   59: invokevirtual 129	com/tencent/component/network/utils/a/b/e:a	(J)Z
    //   62: ifeq -40 -> 22
    //   65: aload 5
    //   67: invokevirtual 131	com/tencent/component/network/utils/a/b/e:e	()V
    //   70: aload_0
    //   71: aload 5
    //   73: invokevirtual 176	com/tencent/component/network/utils/a/b/e:f	()Ljava/lang/Object;
    //   76: invokespecial 101	com/tencent/component/network/utils/a/b/a:a	(Ljava/lang/Object;)Lcom/tencent/component/network/utils/a/b/g;
    //   79: astore 6
    //   81: aload 6
    //   83: aload 5
    //   85: invokevirtual 179	com/tencent/component/network/utils/a/b/g:a	(Lcom/tencent/component/network/utils/a/b/e;)Z
    //   88: pop
    //   89: aload 4
    //   91: invokeinterface 264 1 0
    //   96: aload_0
    //   97: aload 6
    //   99: invokespecial 266	com/tencent/component/network/utils/a/b/a:a	(Lcom/tencent/component/network/utils/a/b/g;)V
    //   102: goto -80 -> 22
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 37	com/tencent/component/network/utils/a/b/a:a	Ljava/util/concurrent/locks/Lock;
    //   111: invokeinterface 109 1 0
    //   116: aload 4
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	a
    //   3	56	1	l	long
    //   29	2	3	bool	boolean
    //   20	70	4	localIterator	Iterator
    //   105	12	4	localObject	Object
    //   54	30	5	locale	e
    //   79	19	6	localg	g
    // Exception table:
    //   from	to	target	type
    //   13	22	105	finally
    //   22	30	105	finally
    //   44	102	105	finally
  }
  
  public final void b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.a.lock();
    try
    {
      this.i = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.a
 * JD-Core Version:    0.7.0.1
 */