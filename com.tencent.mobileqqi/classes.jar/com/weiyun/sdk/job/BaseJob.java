package com.weiyun.sdk.job;

import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class BaseJob
  extends Job
{
  private static final String TAG = "BaseJob";
  protected volatile boolean mCanceled = false;
  protected Future<?> mFuture = null;
  protected final JobContext mJobContext;
  protected volatile boolean mSuspended = false;
  protected ThreadPoolExecutor mThreadPool;
  
  public BaseJob(long paramLong, JobContext paramJobContext)
  {
    super(paramLong);
    this.mJobContext = paramJobContext;
  }
  
  private boolean running()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    setState(2);
    if (!checkCondition())
    {
      localStringBuilder.append("check condition failed. task id=").append(getId());
      localStringBuilder.append(", last error code=").append(getLastErrorNo());
      Log.w("BaseJob", localStringBuilder.toString());
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", localStringBuilder.toString());
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (!isAlive());
          setState(3);
          if (fetchUrl()) {
            break;
          }
          localStringBuilder.append("fetch url failed. task id=").append(getId());
          localStringBuilder.append(", last error code=").append(getLastErrorNo());
          Log.w("BaseJob", localStringBuilder.toString());
        } while (!LogTag.NeedSpecialLog());
        Log.w("FM-TransferFile", localStringBuilder.toString());
        return false;
      } while (!isAlive());
      setState(4);
      if (doTransfer()) {
        break;
      }
      localStringBuilder.append("transfer data failed. task id=").append(getId());
      localStringBuilder.append(", last error code=").append(getLastErrorNo());
      Log.w("BaseJob", localStringBuilder.toString());
    } while (!LogTag.NeedSpecialLog());
    Log.w("FM-TransferFile", localStringBuilder.toString());
    return false;
    Log.i("BaseJob", "task success. task id=" + getId());
    return true;
  }
  
  private boolean terminateJob(Future<?> paramFuture)
  {
    if ((paramFuture.cancel(true)) && (paramFuture.isCancelled()))
    {
      Log.i("BaseJob", "task is canceled. task id=" + getId());
      int i = getState();
      if ((i == 1) || (i == 0))
      {
        if (this.mCanceled) {
          setState(7);
        }
      }
      else {
        return true;
      }
      setState(8);
      return true;
    }
    Log.w("BaseJob", "task can not be canceled. task id=" + getId());
    return false;
  }
  
  public void bindThreadPool(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.mThreadPool = paramThreadPoolExecutor;
  }
  
  /* Error */
  public boolean cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +45 -> 55
    //   13: ldc 8
    //   15: new 36	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 132
    //   21: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 56	com/weiyun/sdk/job/BaseJob:getId	()J
    //   28: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 135	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 27	com/weiyun/sdk/job/BaseJob:mCanceled	Z
    //   42: aload_0
    //   43: bipush 7
    //   45: invokevirtual 43	com/weiyun/sdk/job/BaseJob:setState	(I)V
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    //   55: aload_2
    //   56: invokeinterface 138 1 0
    //   61: ifeq +43 -> 104
    //   64: ldc 8
    //   66: new 36	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 140
    //   72: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: invokevirtual 56	com/weiyun/sdk/job/BaseJob:getId	()J
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 106	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   95: aload_0
    //   96: monitorexit
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield 27	com/weiyun/sdk/job/BaseJob:mCanceled	Z
    //   109: aload_0
    //   110: aload_2
    //   111: invokespecial 142	com/weiyun/sdk/job/BaseJob:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   114: istore_1
    //   115: aload_0
    //   116: monitorenter
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   122: aload_0
    //   123: monitorexit
    //   124: iload_1
    //   125: ireturn
    //   126: astore_2
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: aload_0
    //   133: monitorenter
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_2
    //   142: athrow
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	BaseJob
    //   114	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   50	6	2	localObject1	Object
    //   99	12	2	localFuture2	Future
    //   126	4	2	localObject2	Object
    //   131	11	2	localObject3	Object
    //   143	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   51	53	50	finally
    //   90	97	99	finally
    //   100	102	99	finally
    //   117	124	126	finally
    //   127	129	126	finally
    //   104	115	131	finally
    //   134	141	143	finally
    //   144	146	143	finally
  }
  
  protected abstract boolean checkCondition();
  
  protected abstract boolean doTransfer();
  
  protected abstract boolean fetchUrl();
  
  public JobContext getJobContext()
  {
    return this.mJobContext;
  }
  
  public boolean isAlive()
  {
    return (!this.mCanceled) && (!this.mSuspended);
  }
  
  public boolean restart()
  {
    return start();
  }
  
  public void run()
  {
    try
    {
      if (running()) {
        setState(5);
      }
      for (;;)
      {
        try
        {
          this.mFuture = null;
          return;
        }
        finally {}
        if ((!Thread.interrupted()) && (isAlive())) {
          break label90;
        }
        if (!this.mCanceled) {
          break;
        }
        setState(7);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("BaseJob", localThrowable);
        if (getLastErrorNo() == 0) {
          setLastErrorNo(-10014);
        }
        setState(6);
        continue;
        setState(8);
        continue;
        label90:
        setState(6);
      }
    }
  }
  
  public boolean start()
  {
    if (this.mThreadPool == null)
    {
      Log.e("BaseJob", "thread pool is null!");
      return false;
    }
    try
    {
      if (this.mFuture != null) {
        return false;
      }
    }
    finally {}
    try
    {
      this.mCanceled = false;
      this.mSuspended = false;
      setState(1);
      Future localFuture = submit(this.mThreadPool);
      if (localFuture == null)
      {
        Log.w("BaseJob", "submit task failed! task id=" + getId());
        return false;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.w("BaseJob", localRejectedExecutionException);
      return false;
    }
    try
    {
      if (!localRejectedExecutionException.isDone()) {
        this.mFuture = localRejectedExecutionException;
      }
      Log.i("BaseJob", "submit task ok. task id=" + getId());
      return true;
    }
    finally {}
  }
  
  protected Future<?> submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return paramThreadPoolExecutor.submit(this);
  }
  
  /* Error */
  public boolean suspend()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +45 -> 55
    //   13: ldc 8
    //   15: new 36	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 132
    //   21: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 56	com/weiyun/sdk/job/BaseJob:getId	()J
    //   28: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 135	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 29	com/weiyun/sdk/job/BaseJob:mSuspended	Z
    //   42: aload_0
    //   43: bipush 8
    //   45: invokevirtual 43	com/weiyun/sdk/job/BaseJob:setState	(I)V
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    //   55: aload_2
    //   56: invokeinterface 138 1 0
    //   61: ifeq +43 -> 104
    //   64: ldc 8
    //   66: new 36	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 140
    //   72: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: invokevirtual 56	com/weiyun/sdk/job/BaseJob:getId	()J
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 106	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   95: aload_0
    //   96: monitorexit
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield 29	com/weiyun/sdk/job/BaseJob:mSuspended	Z
    //   109: aload_0
    //   110: aload_2
    //   111: invokespecial 142	com/weiyun/sdk/job/BaseJob:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   114: istore_1
    //   115: aload_0
    //   116: monitorenter
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   122: aload_0
    //   123: monitorexit
    //   124: iload_1
    //   125: ireturn
    //   126: astore_2
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: aload_0
    //   133: monitorenter
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_2
    //   142: athrow
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	BaseJob
    //   114	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   50	6	2	localObject1	Object
    //   99	12	2	localFuture2	Future
    //   126	4	2	localObject2	Object
    //   131	11	2	localObject3	Object
    //   143	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   51	53	50	finally
    //   90	97	99	finally
    //   100	102	99	finally
    //   117	124	126	finally
    //   127	129	126	finally
    //   104	115	131	finally
    //   134	141	143	finally
    //   144	146	143	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.BaseJob
 * JD-Core Version:    0.7.0.1
 */