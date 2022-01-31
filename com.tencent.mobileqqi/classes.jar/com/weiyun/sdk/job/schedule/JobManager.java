package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JobManager
  implements Job.JobListener
{
  private static final int DEFAULT_MAX_RUNNING_JOB = 1;
  private static final String TAG = "JobManager";
  private final HashMap<Long, JobProxy> mDoneList;
  private final boolean mKeepDoneTask;
  private final Lock mLock;
  private final int mMaxRunningJob;
  private JobQueueListener mQueueListener = null;
  private final LinkedList<JobProxy> mRunningList;
  private volatile boolean mSuspend = false;
  private final ThreadPoolExecutor mThreadPool;
  private final LinkedList<JobProxy> mWaitingList;
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this(paramThreadPoolExecutor, false);
  }
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    this(paramThreadPoolExecutor, paramBoolean, 1);
  }
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean, int paramInt)
  {
    this.mThreadPool = paramThreadPoolExecutor;
    this.mKeepDoneTask = paramBoolean;
    this.mLock = new ReentrantLock();
    this.mWaitingList = new LinkedList();
    this.mRunningList = new LinkedList();
    this.mDoneList = new HashMap();
    this.mMaxRunningJob = paramInt;
  }
  
  private void dispatchTaskInternal()
  {
    this.mLock.lock();
    try
    {
      int i = this.mRunningList.size();
      int j = this.mMaxRunningJob;
      if (i >= j) {
        return;
      }
    }
    finally
    {
      this.mLock.unlock();
    }
    this.mLock.unlock();
    this.mThreadPool.submit(new DispatchTask(null));
  }
  
  private JobProxy findTaskInternal(long paramLong)
  {
    Iterator localIterator = this.mRunningList.iterator();
    if (!localIterator.hasNext()) {
      localIterator = this.mWaitingList.iterator();
    }
    JobProxy localJobProxy;
    do
    {
      if (!localIterator.hasNext())
      {
        if (!this.mKeepDoneTask) {
          break label104;
        }
        return (JobProxy)this.mDoneList.get(Long.valueOf(paramLong));
        localJobProxy = (JobProxy)localIterator.next();
        if (localJobProxy.getId() != paramLong) {
          break;
        }
        return localJobProxy;
      }
      localJobProxy = (JobProxy)localIterator.next();
    } while (localJobProxy.getId() != paramLong);
    return localJobProxy;
    label104:
    return null;
  }
  
  private JobProxy removeRunningJobInternal(long paramLong)
  {
    Iterator localIterator = this.mRunningList.iterator();
    JobProxy localJobProxy;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localJobProxy = (JobProxy)localIterator.next();
    } while (paramLong != localJobProxy.getId());
    localIterator.remove();
    return localJobProxy;
  }
  
  private boolean removeTaskInternal(long paramLong)
  {
    boolean bool = false;
    Iterator localIterator = this.mRunningList.iterator();
    if (!localIterator.hasNext()) {
      localIterator = this.mWaitingList.iterator();
    }
    do
    {
      if (!localIterator.hasNext())
      {
        if (!this.mKeepDoneTask) {
          break label160;
        }
        if ((JobProxy)this.mDoneList.remove(Long.valueOf(paramLong)) != null) {
          bool = true;
        }
        return bool;
        JobProxy localJobProxy = (JobProxy)localIterator.next();
        if (paramLong != localJobProxy.getId()) {
          break;
        }
        if (!localJobProxy.getJob().cancel())
        {
          Log.w("JobManager", "cancel task failed. id = " + paramLong);
          return false;
        }
        localIterator.remove();
        return true;
      }
    } while (paramLong != ((JobProxy)localIterator.next()).getId());
    localIterator.remove();
    return true;
    label160:
    return true;
  }
  
  private void submitTaskInternal()
  {
    this.mLock.lock();
    try
    {
      int i = this.mRunningList.size();
      int j = this.mMaxRunningJob;
      if (i >= j) {}
      Object localObject1;
      do
      {
        do
        {
          return;
          do
          {
            localObject1 = (JobProxy)this.mWaitingList.removeFirst();
            this.mRunningList.add(localObject1);
            ((JobProxy)localObject1).getJob().addListener(this);
            if (!((JobProxy)localObject1).submit(this.mThreadPool)) {
              Log.w("JobManager", "start task failed! task = " + ((JobProxy)localObject1).getId());
            }
          } while ((this.mRunningList.size() < this.mMaxRunningJob) && (this.mWaitingList.size() > 0));
          i = this.mRunningList.size();
          this.mLock.unlock();
        } while (i > 0);
        localObject1 = this.mQueueListener;
      } while (localObject1 == null);
      ((JobQueueListener)localObject1).onQueueEmpty();
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public boolean addTask(JobProxy paramJobProxy)
  {
    this.mLock.lock();
    try
    {
      if (findTaskInternal(paramJobProxy.getId()) == null)
      {
        this.mWaitingList.add(paramJobProxy);
        this.mLock.unlock();
        dispatchTaskInternal();
        return true;
      }
      return false;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  /* Error */
  public void cancelTasks()
  {
    // Byte code:
    //   0: new 63	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 64	java/util/LinkedList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 90 1 0
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 68	com/weiyun/sdk/job/schedule/JobManager:mRunningList	Ljava/util/LinkedList;
    //   22: invokevirtual 206	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 66	com/weiyun/sdk/job/schedule/JobManager:mWaitingList	Ljava/util/LinkedList;
    //   30: invokevirtual 209	java/util/LinkedList:clear	()V
    //   33: aload_2
    //   34: invokevirtual 112	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   37: astore_2
    //   38: aload_2
    //   39: invokeinterface 118 1 0
    //   44: istore_1
    //   45: iload_1
    //   46: ifne +13 -> 59
    //   49: aload_0
    //   50: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 97 1 0
    //   58: return
    //   59: aload_2
    //   60: invokeinterface 134 1 0
    //   65: checkcast 130	com/weiyun/sdk/job/schedule/JobProxy
    //   68: invokevirtual 210	com/weiyun/sdk/job/schedule/JobProxy:cancel	()Z
    //   71: pop
    //   72: goto -34 -> 38
    //   75: astore_2
    //   76: aload_0
    //   77: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 97 1 0
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	JobManager
    //   44	2	1	bool	boolean
    //   7	53	2	localObject1	Object
    //   75	11	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	38	75	finally
    //   38	45	75	finally
    //   59	72	75	finally
  }
  
  protected abstract boolean checkCondition();
  
  public void dispatchTask()
  {
    this.mSuspend = false;
    dispatchTaskInternal();
  }
  
  public JobProxy findTask(long paramLong)
  {
    this.mLock.lock();
    try
    {
      JobProxy localJobProxy = findTaskInternal(paramLong);
      return localJobProxy;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public int getUnDoneTaskSize()
  {
    this.mLock.lock();
    try
    {
      int i = this.mRunningList.size();
      int j = this.mWaitingList.size();
      return i + j;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    Log.d("JobManager", "task id " + paramJob.getId() + " new state " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
    case 6: 
    case 7: 
      paramJob.removeListener(this);
      this.mLock.lock();
      try
      {
        removeRunningJobInternal(paramJob.getId());
        this.mLock.unlock();
        dispatchTaskInternal();
        return;
      }
      finally
      {
        this.mLock.unlock();
      }
    }
    paramJob.removeListener(this);
    this.mLock.lock();
    try
    {
      paramJob = removeRunningJobInternal(paramJob.getId());
      if (paramJob != null) {
        this.mWaitingList.add(paramJob);
      }
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public boolean removeTask(long paramLong)
  {
    this.mLock.lock();
    try
    {
      boolean bool = removeTaskInternal(paramLong);
      return bool;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void setJobQueueListener(JobQueueListener paramJobQueueListener)
  {
    this.mQueueListener = paramJobQueueListener;
  }
  
  /* Error */
  public void suspendTasks()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 52	com/weiyun/sdk/job/schedule/JobManager:mSuspend	Z
    //   5: aload_0
    //   6: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   9: invokeinterface 90 1 0
    //   14: aload_0
    //   15: getfield 68	com/weiyun/sdk/job/schedule/JobManager:mRunningList	Ljava/util/LinkedList;
    //   18: invokevirtual 112	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface 118 1 0
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +13 -> 43
    //   33: aload_0
    //   34: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   37: invokeinterface 97 1 0
    //   42: return
    //   43: aload_2
    //   44: invokeinterface 134 1 0
    //   49: checkcast 130	com/weiyun/sdk/job/schedule/JobProxy
    //   52: invokevirtual 248	com/weiyun/sdk/job/schedule/JobProxy:suspend	()Z
    //   55: pop
    //   56: goto -34 -> 22
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 61	com/weiyun/sdk/job/schedule/JobManager:mLock	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 97 1 0
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	JobManager
    //   28	2	1	bool	boolean
    //   21	23	2	localIterator	Iterator
    //   59	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	59	finally
    //   22	29	59	finally
    //   43	56	59	finally
  }
  
  private class DispatchTask
    implements Runnable
  {
    private DispatchTask() {}
    
    public void run()
    {
      if ((!JobManager.this.mSuspend) && (JobManager.this.checkCondition())) {
        JobManager.this.submitTaskInternal();
      }
      JobManager.JobQueueListener localJobQueueListener;
      do
      {
        return;
        localJobQueueListener = JobManager.this.mQueueListener;
      } while (localJobQueueListener == null);
      localJobQueueListener.onQueueSuspend();
    }
  }
  
  public static abstract interface JobQueueListener
  {
    public abstract void onQueueEmpty();
    
    public abstract void onQueueSuspend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.JobManager
 * JD-Core Version:    0.7.0.1
 */