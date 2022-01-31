package com.qzone.utils.http.pool;

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

public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>>
  implements ConnPool<T, E>, ConnPoolControl<T>
{
  private final LinkedList<E> available;
  private final ConnFactory<T, C> connFactory;
  private volatile int defaultMaxPerRoute;
  private volatile boolean isShutDown;
  private final Set<E> leased;
  private final Lock lock;
  private final Map<T, Integer> maxPerRoute;
  private volatile int maxTotal;
  private final LinkedList<PoolEntryFuture<E>> pending;
  private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
  
  public AbstractConnPool(ConnFactory<T, C> paramConnFactory, int paramInt1, int paramInt2)
  {
    if (paramConnFactory == null) {
      throw new IllegalArgumentException("Connection factory may not null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Max per route value may not be negative or zero");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Max total value may not be negative or zero");
    }
    this.lock = new ReentrantLock();
    this.connFactory = paramConnFactory;
    this.routeToPool = new HashMap();
    this.leased = new HashSet();
    this.available = new LinkedList();
    this.pending = new LinkedList();
    this.maxPerRoute = new HashMap();
    this.defaultMaxPerRoute = paramInt1;
    this.maxTotal = paramInt2;
  }
  
  private int getMax(T paramT)
  {
    paramT = (Integer)this.maxPerRoute.get(paramT);
    if (paramT != null) {
      return paramT.intValue();
    }
    return this.defaultMaxPerRoute;
  }
  
  private RouteSpecificPool<T, C, E> getPool(final T paramT)
  {
    RouteSpecificPool localRouteSpecificPool = (RouteSpecificPool)this.routeToPool.get(paramT);
    Object localObject = localRouteSpecificPool;
    if (localRouteSpecificPool == null)
    {
      localObject = new RouteSpecificPool(paramT)
      {
        protected E createEntry(C paramAnonymousC)
        {
          return AbstractConnPool.this.createEntry(paramT, paramAnonymousC);
        }
      };
      this.routeToPool.put(paramT, localObject);
    }
    return localObject;
  }
  
  private E getPoolEntryBlocking(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, PoolEntryFuture<E> paramPoolEntryFuture)
    throws IOException, InterruptedException, TimeoutException
  {
    Date localDate = null;
    if (paramLong > 0L) {
      localDate = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
    }
    this.lock.lock();
    RouteSpecificPool localRouteSpecificPool;
    try
    {
      localRouteSpecificPool = getPool(paramT);
      paramTimeUnit = null;
    }
    finally
    {
      this.lock.unlock();
    }
    throw new TimeoutException("Timeout waiting for connection");
    if (this.isShutDown) {
      throw new IllegalStateException("Connection pool shut down");
    }
    Object localObject;
    do
    {
      if ((!((PoolEntry)localObject).isClosed()) && (!((PoolEntry)localObject).isExpired(System.currentTimeMillis()))) {
        break;
      }
      ((PoolEntry)localObject).close();
      this.available.remove(localObject);
      localRouteSpecificPool.free((PoolEntry)localObject, false);
      localObject = localRouteSpecificPool.getFree(paramObject);
    } while (localObject != null);
    if (localObject != null)
    {
      this.available.remove(localObject);
      this.leased.add(localObject);
      this.lock.unlock();
      return localObject;
    }
    int j = getMax(paramT);
    int k = Math.max(0, localRouteSpecificPool.getAllocatedCount() + 1 - j);
    int i;
    if (k > 0) {
      i = 0;
    }
    for (;;)
    {
      if (localRouteSpecificPool.getAllocatedCount() < j)
      {
        i = this.leased.size();
        i = Math.max(this.maxTotal - i, 0);
        if (i > 0)
        {
          if ((this.available.size() > i - 1) && (!this.available.isEmpty()))
          {
            paramObject = (PoolEntry)this.available.removeLast();
            paramObject.close();
            getPool(paramObject.getRoute()).remove(paramObject);
          }
          paramT = localRouteSpecificPool.add(this.connFactory.create(paramT));
          this.leased.add(paramT);
          this.lock.unlock();
          return paramT;
        }
      }
      label490:
      label498:
      do
      {
        for (;;)
        {
          paramTimeUnit = localRouteSpecificPool.getLastUsed();
          if (paramTimeUnit == null) {
            break;
          }
          paramTimeUnit.close();
          this.available.remove(paramTimeUnit);
          localRouteSpecificPool.remove(paramTimeUnit);
          i += 1;
          break label498;
          try
          {
            localRouteSpecificPool.queue(paramPoolEntryFuture);
            this.pending.add(paramPoolEntryFuture);
            boolean bool = paramPoolEntryFuture.await(localDate);
            localRouteSpecificPool.unqueue(paramPoolEntryFuture);
            this.pending.remove(paramPoolEntryFuture);
            paramTimeUnit = (TimeUnit)localObject;
            if (!bool)
            {
              paramTimeUnit = (TimeUnit)localObject;
              if (localDate != null)
              {
                paramTimeUnit = (TimeUnit)localObject;
                if (localDate.getTime() > System.currentTimeMillis()) {
                  break label490;
                }
              }
            }
          }
          finally
          {
            localRouteSpecificPool.unqueue(paramPoolEntryFuture);
            this.pending.remove(paramPoolEntryFuture);
          }
        }
      } while (i < k);
    }
  }
  
  private void notifyPending(RouteSpecificPool<T, C, E> paramRouteSpecificPool)
  {
    paramRouteSpecificPool = paramRouteSpecificPool.nextPending();
    if (paramRouteSpecificPool != null) {
      this.pending.remove(paramRouteSpecificPool);
    }
    for (;;)
    {
      if (paramRouteSpecificPool != null) {
        paramRouteSpecificPool.wakeup();
      }
      return;
      paramRouteSpecificPool = (PoolEntryFuture)this.pending.poll();
    }
  }
  
  /* Error */
  public void closeExpired()
  {
    // Byte code:
    //   0: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   8: invokeinterface 146 1 0
    //   13: aload_0
    //   14: getfield 74	com/qzone/utils/http/pool/AbstractConnPool:available	Ljava/util/LinkedList;
    //   17: invokevirtual 266	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   20: astore 4
    //   22: aload 4
    //   24: invokeinterface 271 1 0
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +13 -> 44
    //   34: aload_0
    //   35: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   38: invokeinterface 154 1 0
    //   43: return
    //   44: aload 4
    //   46: invokeinterface 274 1 0
    //   51: checkcast 163	com/qzone/utils/http/pool/PoolEntry
    //   54: astore 5
    //   56: aload 5
    //   58: lload_1
    //   59: invokevirtual 171	com/qzone/utils/http/pool/PoolEntry:isExpired	(J)Z
    //   62: ifeq -40 -> 22
    //   65: aload 5
    //   67: invokevirtual 174	com/qzone/utils/http/pool/PoolEntry:close	()V
    //   70: aload_0
    //   71: aload 5
    //   73: invokevirtual 216	com/qzone/utils/http/pool/PoolEntry:getRoute	()Ljava/lang/Object;
    //   76: invokespecial 148	com/qzone/utils/http/pool/AbstractConnPool:getPool	(Ljava/lang/Object;)Lcom/qzone/utils/http/pool/RouteSpecificPool;
    //   79: astore 6
    //   81: aload 6
    //   83: aload 5
    //   85: invokevirtual 219	com/qzone/utils/http/pool/RouteSpecificPool:remove	(Lcom/qzone/utils/http/pool/PoolEntry;)Z
    //   88: pop
    //   89: aload 4
    //   91: invokeinterface 276 1 0
    //   96: aload_0
    //   97: aload 6
    //   99: invokespecial 278	com/qzone/utils/http/pool/AbstractConnPool:notifyPending	(Lcom/qzone/utils/http/pool/RouteSpecificPool;)V
    //   102: goto -80 -> 22
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   111: invokeinterface 154 1 0
    //   116: aload 4
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	AbstractConnPool
    //   3	56	1	l	long
    //   29	2	3	bool	boolean
    //   20	70	4	localIterator	Iterator
    //   105	12	4	localObject	Object
    //   54	30	5	localPoolEntry	PoolEntry
    //   79	19	6	localRouteSpecificPool	RouteSpecificPool
    // Exception table:
    //   from	to	target	type
    //   13	22	105	finally
    //   22	30	105	finally
    //   44	102	105	finally
  }
  
  /* Error */
  public void closeIdle(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +14 -> 15
    //   4: new 43	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 282
    //   11: invokespecial 48	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_3
    //   16: lload_1
    //   17: invokevirtual 139	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   20: lstore 4
    //   22: lload 4
    //   24: lstore_1
    //   25: lload 4
    //   27: lconst_0
    //   28: lcmp
    //   29: ifge +5 -> 34
    //   32: lconst_0
    //   33: lstore_1
    //   34: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   37: lstore 4
    //   39: aload_0
    //   40: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   43: invokeinterface 146 1 0
    //   48: aload_0
    //   49: getfield 74	com/qzone/utils/http/pool/AbstractConnPool:available	Ljava/util/LinkedList;
    //   52: invokevirtual 266	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   55: astore_3
    //   56: aload_3
    //   57: invokeinterface 271 1 0
    //   62: istore 6
    //   64: iload 6
    //   66: ifne +13 -> 79
    //   69: aload_0
    //   70: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 154 1 0
    //   78: return
    //   79: aload_3
    //   80: invokeinterface 274 1 0
    //   85: checkcast 163	com/qzone/utils/http/pool/PoolEntry
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 285	com/qzone/utils/http/pool/PoolEntry:getUpdated	()J
    //   95: lload 4
    //   97: lload_1
    //   98: lsub
    //   99: lcmp
    //   100: ifgt -44 -> 56
    //   103: aload 7
    //   105: invokevirtual 174	com/qzone/utils/http/pool/PoolEntry:close	()V
    //   108: aload_0
    //   109: aload 7
    //   111: invokevirtual 216	com/qzone/utils/http/pool/PoolEntry:getRoute	()Ljava/lang/Object;
    //   114: invokespecial 148	com/qzone/utils/http/pool/AbstractConnPool:getPool	(Ljava/lang/Object;)Lcom/qzone/utils/http/pool/RouteSpecificPool;
    //   117: astore 8
    //   119: aload 8
    //   121: aload 7
    //   123: invokevirtual 219	com/qzone/utils/http/pool/RouteSpecificPool:remove	(Lcom/qzone/utils/http/pool/PoolEntry;)Z
    //   126: pop
    //   127: aload_3
    //   128: invokeinterface 276 1 0
    //   133: aload_0
    //   134: aload 8
    //   136: invokespecial 278	com/qzone/utils/http/pool/AbstractConnPool:notifyPending	(Lcom/qzone/utils/http/pool/RouteSpecificPool;)V
    //   139: goto -83 -> 56
    //   142: astore_3
    //   143: aload_0
    //   144: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   147: invokeinterface 154 1 0
    //   152: aload_3
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	AbstractConnPool
    //   0	154	1	paramLong	long
    //   0	154	3	paramTimeUnit	TimeUnit
    //   20	76	4	l	long
    //   62	3	6	bool	boolean
    //   88	34	7	localPoolEntry	PoolEntry
    //   117	18	8	localRouteSpecificPool	RouteSpecificPool
    // Exception table:
    //   from	to	target	type
    //   48	56	142	finally
    //   56	64	142	finally
    //   79	139	142	finally
  }
  
  protected abstract E createEntry(T paramT, C paramC);
  
  public int getDefaultMaxPerRoute()
  {
    this.lock.lock();
    try
    {
      int i = this.defaultMaxPerRoute;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getMaxPerRoute(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    this.lock.lock();
    try
    {
      int i = getMax(paramT);
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getMaxTotal()
  {
    this.lock.lock();
    try
    {
      int i = this.maxTotal;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public PoolStats getStats(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    this.lock.lock();
    try
    {
      RouteSpecificPool localRouteSpecificPool = getPool(paramT);
      paramT = new PoolStats(localRouteSpecificPool.getLeasedCount(), localRouteSpecificPool.getPendingCount(), localRouteSpecificPool.getAvailableCount(), getMax(paramT));
      return paramT;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public PoolStats getTotalStats()
  {
    this.lock.lock();
    try
    {
      PoolStats localPoolStats = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      return localPoolStats;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean isShutdown()
  {
    return this.isShutDown;
  }
  
  public Future<E> lease(T paramT, Object paramObject)
  {
    return lease(paramT, paramObject, null);
  }
  
  public Future<E> lease(final T paramT, final Object paramObject, FutureCallback<E> paramFutureCallback)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.isShutDown) {
      throw new IllegalStateException("Connection pool shut down");
    }
    new PoolEntryFuture(this.lock, paramFutureCallback)
    {
      public E getPoolEntry(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, TimeoutException, IOException
      {
        return AbstractConnPool.this.getPoolEntryBlocking(paramT, paramObject, paramAnonymousLong, paramAnonymousTimeUnit, this);
      }
    };
  }
  
  /* Error */
  public void release(E paramE, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 146 1 0
    //   9: aload_0
    //   10: getfield 69	com/qzone/utils/http/pool/AbstractConnPool:leased	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 324 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 216	com/qzone/utils/http/pool/PoolEntry:getRoute	()Ljava/lang/Object;
    //   27: invokespecial 148	com/qzone/utils/http/pool/AbstractConnPool:getPool	(Ljava/lang/Object;)Lcom/qzone/utils/http/pool/RouteSpecificPool;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 182	com/qzone/utils/http/pool/RouteSpecificPool:free	(Lcom/qzone/utils/http/pool/PoolEntry;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 156	com/qzone/utils/http/pool/AbstractConnPool:isShutDown	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 74	com/qzone/utils/http/pool/AbstractConnPool:available	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 328	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 278	com/qzone/utils/http/pool/AbstractConnPool:notifyPending	(Lcom/qzone/utils/http/pool/RouteSpecificPool;)V
    //   61: aload_0
    //   62: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 154 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 174	com/qzone/utils/http/pool/PoolEntry:close	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 57	com/qzone/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 154 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	AbstractConnPool
    //   0	90	1	paramE	E
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localRouteSpecificPool	RouteSpecificPool
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.lock.lock();
    try
    {
      this.defaultMaxPerRoute = paramInt;
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void setMaxPerRoute(T paramT, int paramInt)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.lock.lock();
    try
    {
      this.maxPerRoute.put(paramT, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void setMaxTotal(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.lock.lock();
    try
    {
      this.maxTotal = paramInt;
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void shutdown()
    throws IOException
  {
    if (this.isShutDown) {
      return;
    }
    this.isShutDown = true;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.available.iterator();
        if (!localIterator.hasNext())
        {
          localIterator = this.leased.iterator();
          if (!localIterator.hasNext())
          {
            localIterator = this.routeToPool.values().iterator();
            if (localIterator.hasNext()) {
              break label159;
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
          }
        }
        else
        {
          ((PoolEntry)localIterator.next()).close();
          continue;
        }
        ((PoolEntry)localObject.next()).close();
      }
      finally
      {
        this.lock.unlock();
      }
      continue;
      label159:
      ((RouteSpecificPool)localObject.next()).shutdown();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.leased);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.available);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.pending);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.pool.AbstractConnPool
 * JD-Core Version:    0.7.0.1
 */