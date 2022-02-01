package com.tencent.component.network.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityThreadPool
  extends ThreadPool
{
  public PriorityThreadPool()
  {
    this("priority-thread-pool", DEFAULT_POOL_SIZE);
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
    private static final AtomicLong SEQ = new AtomicLong(0L);
    private final boolean mFifo;
    private final ThreadPool.Job<T> mJob;
    private final int mPriority;
    private final long mSeqNum;
    
    public PriorityJob(ThreadPool.Job<T> paramJob, int paramInt, boolean paramBoolean)
    {
      this.mJob = paramJob;
      this.mPriority = paramInt;
      this.mFifo = paramBoolean;
      this.mSeqNum = SEQ.getAndIncrement();
    }
    
    private int subCompareTo(PriorityJob paramPriorityJob)
    {
      int i;
      if (this.mSeqNum < paramPriorityJob.mSeqNum) {
        i = -1;
      }
      while (this.mFifo)
      {
        return i;
        if (this.mSeqNum > paramPriorityJob.mSeqNum) {
          i = 1;
        } else {
          i = 0;
        }
      }
      return -i;
    }
    
    public int compareTo(PriorityJob paramPriorityJob)
    {
      if (this.mPriority > paramPriorityJob.mPriority) {
        return -1;
      }
      if (this.mPriority < paramPriorityJob.mPriority) {
        return 1;
      }
      return subCompareTo(paramPriorityJob);
    }
    
    public T run(ThreadPool.JobContext paramJobContext)
    {
      try
      {
        String str = Thread.currentThread().getName();
        str = str.substring(0, str.indexOf(" sub:") + " sub:".length());
        Thread.currentThread().setName(str + this.mJob.getClass().toString());
        label58:
        return this.mJob.run(paramJobContext);
      }
      catch (Exception localException)
      {
        break label58;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */