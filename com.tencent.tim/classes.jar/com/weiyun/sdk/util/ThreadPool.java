package com.weiyun.sdk.util;

import com.weiyun.sdk.log.Log;

public class ThreadPool
{
  private static final int CORE_POOL_SIZE = 4;
  public static final JobContext JOB_CONTEXT_STUB = new JobContextStub(null);
  private static final int MAX_POOL_SIZE = 8;
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  private static final String TAG = "ThreadPool";
  private final PriorityThreadPoolExecutor mExecutor;
  
  public ThreadPool()
  {
    this(4, 8);
  }
  
  public ThreadPool(int paramInt1, int paramInt2)
  {
    this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(paramInt1, paramInt2, "thread-pool");
  }
  
  public ThreadPool(int paramInt1, int paramInt2, String paramString)
  {
    this.mExecutor = ThreadPoolFactory.createPriorityThreadPoolExecutor(paramInt1, paramInt2, paramString);
  }
  
  public PriorityThreadPoolExecutor getExecutor()
  {
    return this.mExecutor;
  }
  
  public <T> Future<T> submit(Job<T> paramJob)
  {
    return submit(paramJob, 0, null);
  }
  
  public <T> Future<T> submit(Job<T> paramJob, int paramInt)
  {
    return submit(paramJob, paramInt, null);
  }
  
  public <T> Future<T> submit(Job<T> paramJob, int paramInt, FutureListener<T> paramFutureListener)
  {
    paramJob = new Worker(paramJob, paramFutureListener);
    this.mExecutor.submit(paramJob, paramInt);
    return paramJob;
  }
  
  public <T> Future<T> submit(Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    return submit(paramJob, 0, paramFutureListener);
  }
  
  public static abstract interface CancelListener
  {
    public abstract void onCancel();
  }
  
  public static abstract interface Job<T>
  {
    public abstract T run(ThreadPool.JobContext paramJobContext);
  }
  
  public static abstract interface JobContext
  {
    public abstract boolean isCancelled();
    
    public abstract void setCancelListener(ThreadPool.CancelListener paramCancelListener);
    
    public abstract boolean setMode(int paramInt);
  }
  
  static class JobContextStub
    implements ThreadPool.JobContext
  {
    public boolean isCancelled()
    {
      return false;
    }
    
    public void setCancelListener(ThreadPool.CancelListener paramCancelListener) {}
    
    public boolean setMode(int paramInt)
    {
      return true;
    }
  }
  
  class Worker<T>
    implements Future<T>, ThreadPool.JobContext, Runnable
  {
    private static final String TAG = "Worker";
    private ThreadPool.CancelListener mCancelListener;
    private volatile boolean mIsCancelled;
    private boolean mIsDone;
    private ThreadPool.Job<T> mJob;
    private FutureListener<T> mListener;
    private T mResult;
    
    public Worker(FutureListener<T> paramFutureListener)
    {
      this.mJob = paramFutureListener;
      Object localObject;
      this.mListener = localObject;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 50	com/weiyun/sdk/util/ThreadPool$Worker:mIsCancelled	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 50	com/weiyun/sdk/util/ThreadPool$Worker:mIsCancelled	Z
      //   19: aload_0
      //   20: getfield 52	com/weiyun/sdk/util/ThreadPool$Worker:mCancelListener	Lcom/weiyun/sdk/util/ThreadPool$CancelListener;
      //   23: ifnull -12 -> 11
      //   26: aload_0
      //   27: getfield 52	com/weiyun/sdk/util/ThreadPool$Worker:mCancelListener	Lcom/weiyun/sdk/util/ThreadPool$CancelListener;
      //   30: invokeinterface 57 1 0
      //   35: goto -24 -> 11
      //   38: astore_2
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_2
      //   42: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	43	0	this	Worker
      //   6	2	1	bool	boolean
      //   38	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	38	finally
      //   14	35	38	finally
    }
    
    public T get()
    {
      try
      {
        for (;;)
        {
          boolean bool = this.mIsDone;
          if (bool) {
            break;
          }
          try
          {
            wait();
          }
          catch (Exception localException)
          {
            Log.w("Worker", "ingore exception", localException);
          }
        }
        localObject2 = this.mResult;
      }
      finally {}
      Object localObject2;
      return localObject2;
    }
    
    public boolean isCancelled()
    {
      return this.mIsCancelled;
    }
    
    public boolean isDone()
    {
      try
      {
        boolean bool = this.mIsDone;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void run()
    {
      Object localObject4 = null;
      Object localObject1 = localObject4;
      if (setMode(1)) {}
      try
      {
        localObject1 = this.mJob.run(this);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            setMode(0);
            this.mResult = localObject1;
            this.mIsDone = true;
            notifyAll();
            if (this.mListener != null) {
              this.mListener.onFutureDone(this);
            }
            return;
          }
          finally {}
          localThrowable = localThrowable;
          Log.w("Worker", "Exception in running a job", localThrowable);
          Object localObject2 = localObject4;
        }
      }
    }
    
    public void setCancelListener(ThreadPool.CancelListener paramCancelListener)
    {
      try
      {
        this.mCancelListener = paramCancelListener;
        if ((this.mIsCancelled) && (this.mCancelListener != null)) {
          this.mCancelListener.onCancel();
        }
        return;
      }
      finally
      {
        paramCancelListener = finally;
        throw paramCancelListener;
      }
    }
    
    public boolean setMode(int paramInt)
    {
      return !isCancelled();
    }
    
    public void waitDone()
    {
      get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.util.ThreadPool
 * JD-Core Version:    0.7.0.1
 */