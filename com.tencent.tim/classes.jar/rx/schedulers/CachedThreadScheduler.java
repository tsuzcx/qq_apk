package rx.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

final class CachedThreadScheduler
  extends Scheduler
  implements SchedulerLifecycle
{
  static final RxThreadFactory EVICTOR_THREAD_FACTORY;
  private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor-";
  private static final long KEEP_ALIVE_TIME = 60L;
  private static final TimeUnit KEEP_ALIVE_UNIT;
  static final CachedWorkerPool NONE;
  static final ThreadWorker SHUTDOWN_THREADWORKER;
  static final RxThreadFactory WORKER_THREAD_FACTORY = new RxThreadFactory("RxCachedThreadScheduler-");
  private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler-";
  final AtomicReference<CachedWorkerPool> pool = new AtomicReference(NONE);
  
  static
  {
    EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    SHUTDOWN_THREADWORKER = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
    SHUTDOWN_THREADWORKER.unsubscribe();
    NONE = new CachedWorkerPool(0L, null);
    NONE.shutdown();
  }
  
  public CachedThreadScheduler()
  {
    start();
  }
  
  public Scheduler.Worker createWorker()
  {
    return new EventLoopWorker((CachedWorkerPool)this.pool.get());
  }
  
  public void shutdown()
  {
    CachedWorkerPool localCachedWorkerPool;
    do
    {
      localCachedWorkerPool = (CachedWorkerPool)this.pool.get();
      if (localCachedWorkerPool == NONE) {
        return;
      }
    } while (!this.pool.compareAndSet(localCachedWorkerPool, NONE));
    localCachedWorkerPool.shutdown();
  }
  
  public void start()
  {
    CachedWorkerPool localCachedWorkerPool = new CachedWorkerPool(60L, KEEP_ALIVE_UNIT);
    if (!this.pool.compareAndSet(NONE, localCachedWorkerPool)) {
      localCachedWorkerPool.shutdown();
    }
  }
  
  static final class CachedWorkerPool
  {
    private final CompositeSubscription allWorkers;
    private final ScheduledExecutorService evictorService;
    private final Future<?> evictorTask;
    private final ConcurrentLinkedQueue<CachedThreadScheduler.ThreadWorker> expiringWorkerQueue;
    private final long keepAliveTime;
    
    CachedWorkerPool(long paramLong, TimeUnit paramTimeUnit)
    {
      ScheduledFuture localScheduledFuture;
      if (paramTimeUnit != null)
      {
        paramLong = paramTimeUnit.toNanos(paramLong);
        this.keepAliveTime = paramLong;
        this.expiringWorkerQueue = new ConcurrentLinkedQueue();
        this.allWorkers = new CompositeSubscription();
        if (paramTimeUnit == null) {
          break label105;
        }
        paramTimeUnit = Executors.newScheduledThreadPool(1, CachedThreadScheduler.EVICTOR_THREAD_FACTORY);
        NewThreadWorker.tryEnableCancelPolicy(paramTimeUnit);
        localScheduledFuture = paramTimeUnit.scheduleWithFixedDelay(new CachedThreadScheduler.CachedWorkerPool.1(this), this.keepAliveTime, this.keepAliveTime, TimeUnit.NANOSECONDS);
      }
      for (;;)
      {
        this.evictorService = paramTimeUnit;
        this.evictorTask = localScheduledFuture;
        return;
        paramLong = 0L;
        break;
        label105:
        localScheduledFuture = null;
        paramTimeUnit = localObject;
      }
    }
    
    void evictExpiredWorkers()
    {
      if (!this.expiringWorkerQueue.isEmpty())
      {
        long l = now();
        Iterator localIterator = this.expiringWorkerQueue.iterator();
        while (localIterator.hasNext())
        {
          CachedThreadScheduler.ThreadWorker localThreadWorker = (CachedThreadScheduler.ThreadWorker)localIterator.next();
          if (localThreadWorker.getExpirationTime() > l) {
            break;
          }
          if (this.expiringWorkerQueue.remove(localThreadWorker)) {
            this.allWorkers.remove(localThreadWorker);
          }
        }
      }
    }
    
    CachedThreadScheduler.ThreadWorker get()
    {
      if (this.allWorkers.isUnsubscribed()) {
        return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
      }
      while (!this.expiringWorkerQueue.isEmpty())
      {
        localThreadWorker = (CachedThreadScheduler.ThreadWorker)this.expiringWorkerQueue.poll();
        if (localThreadWorker != null) {
          return localThreadWorker;
        }
      }
      CachedThreadScheduler.ThreadWorker localThreadWorker = new CachedThreadScheduler.ThreadWorker(CachedThreadScheduler.WORKER_THREAD_FACTORY);
      this.allWorkers.add(localThreadWorker);
      return localThreadWorker;
    }
    
    long now()
    {
      return System.nanoTime();
    }
    
    void release(CachedThreadScheduler.ThreadWorker paramThreadWorker)
    {
      paramThreadWorker.setExpirationTime(now() + this.keepAliveTime);
      this.expiringWorkerQueue.offer(paramThreadWorker);
    }
    
    void shutdown()
    {
      try
      {
        if (this.evictorTask != null) {
          this.evictorTask.cancel(true);
        }
        if (this.evictorService != null) {
          this.evictorService.shutdownNow();
        }
        return;
      }
      finally
      {
        this.allWorkers.unsubscribe();
      }
    }
  }
  
  static final class EventLoopWorker
    extends Scheduler.Worker
  {
    static final AtomicIntegerFieldUpdater<EventLoopWorker> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "once");
    private final CompositeSubscription innerSubscription = new CompositeSubscription();
    volatile int once;
    private final CachedThreadScheduler.CachedWorkerPool pool;
    private final CachedThreadScheduler.ThreadWorker threadWorker;
    
    EventLoopWorker(CachedThreadScheduler.CachedWorkerPool paramCachedWorkerPool)
    {
      this.pool = paramCachedWorkerPool;
      this.threadWorker = paramCachedWorkerPool.get();
    }
    
    public boolean isUnsubscribed()
    {
      return this.innerSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return schedule(paramAction0, 0L, null);
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.innerSubscription.isUnsubscribed()) {
        return Subscriptions.unsubscribed();
      }
      paramAction0 = this.threadWorker.scheduleActual(paramAction0, paramLong, paramTimeUnit);
      this.innerSubscription.add(paramAction0);
      paramAction0.addParent(this.innerSubscription);
      return paramAction0;
    }
    
    public void unsubscribe()
    {
      if (ONCE_UPDATER.compareAndSet(this, 0, 1)) {
        this.pool.release(this.threadWorker);
      }
      this.innerSubscription.unsubscribe();
    }
  }
  
  static final class ThreadWorker
    extends NewThreadWorker
  {
    private long expirationTime = 0L;
    
    ThreadWorker(ThreadFactory paramThreadFactory)
    {
      super();
    }
    
    public long getExpirationTime()
    {
      return this.expirationTime;
    }
    
    public void setExpirationTime(long paramLong)
    {
      this.expirationTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler
 * JD-Core Version:    0.7.0.1
 */