package com.tencent.component.network.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityThreadPool
  extends ThreadPool
{
  public PriorityThreadPool()
  {
    this("priority-thread-pool", 4);
  }
  
  public PriorityThreadPool(String paramString, int paramInt)
  {
    super(paramString, paramInt, paramInt, new PriorityBlockingQueue());
  }
  
  public PriorityThreadPool(Executor paramExecutor)
  {
    super(paramExecutor);
  }
  
  public static PriorityThreadPool getDefault()
  {
    return InstanceHolder.INSTANCE;
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, null, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    return submit(paramJob, paramFutureListener, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener, Priority paramPriority)
  {
    Priority localPriority = paramPriority;
    if (paramPriority == null) {
      localPriority = Priority.NORMAL;
    }
    return super.submit(new PriorityJob(paramJob, localPriority.priority, localPriority.fifo), paramFutureListener);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, Priority paramPriority)
  {
    return submit(paramJob, null, paramPriority);
  }
  
  static class InstanceHolder
  {
    public static final PriorityThreadPool INSTANCE = new PriorityThreadPool();
  }
  
  public static class Priority
  {
    public static final Priority HIGH = new Priority(1, false);
    public static final Priority LOW = new Priority(-1, true);
    public static final Priority NORMAL = new Priority(0, true);
    public final boolean fifo;
    public final int priority;
    
    public Priority(int paramInt, boolean paramBoolean)
    {
      this.priority = paramInt;
      this.fifo = paramBoolean;
    }
  }
  
  static class PriorityJob<T>
    implements ThreadPool.Job<T>, Comparable<PriorityJob>
  {
    private static final AtomicLong a = new AtomicLong(0L);
    private final ThreadPool.Job<T> b;
    private final int c;
    private final boolean d;
    private final long e;
    
    public PriorityJob(ThreadPool.Job<T> paramJob, int paramInt, boolean paramBoolean)
    {
      this.b = paramJob;
      this.c = paramInt;
      this.d = paramBoolean;
      this.e = a.getAndIncrement();
    }
    
    public int compareTo(PriorityJob paramPriorityJob)
    {
      int i = -1;
      int j;
      if (this.c > paramPriorityJob.c)
      {
        j = i;
        return j;
      }
      if (this.c < paramPriorityJob.c) {
        return 1;
      }
      if (this.e < paramPriorityJob.e) {}
      for (;;)
      {
        j = i;
        if (this.d) {
          break;
        }
        return -i;
        if (this.e > paramPriorityJob.e) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    
    public T run(ThreadPool.JobContext paramJobContext)
    {
      try
      {
        String str = Thread.currentThread().getName();
        str = str.substring(0, str.indexOf(" sub:") + 5);
        Thread.currentThread().setName(str + this.b.getClass().toString());
        label54:
        return this.b.run(paramJobContext);
      }
      catch (Exception localException)
      {
        break label54;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */