package com.tencent.weiyun.utils.thread;

import android.annotation.TargetApi;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
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
  
  @TargetApi(9)
  public PriorityThreadPool(String paramString, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramInt, paramLong, paramTimeUnit, new PriorityBlockingQueue());
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
      return this.mJob.run(paramJobContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */