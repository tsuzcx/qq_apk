package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.IWyTaskManager.TaskListener;
import com.weiyun.sdk.context.ErrorMessages;
import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class JobProxy
  implements Job.JobListener, IWyTaskManager.Task
{
  private static final String TAG = "JobProxy";
  protected final Object mContext;
  protected final BaseJob mJob;
  protected final JobManager mJobManager;
  protected final CopyOnWriteArrayList<IWyTaskManager.TaskListener> mListeners;
  
  public JobProxy(BaseJob paramBaseJob, Object paramObject, JobManager paramJobManager)
  {
    this.mJob = paramBaseJob;
    this.mContext = paramObject;
    this.mListeners = new CopyOnWriteArrayList();
    this.mJob.addListener(this);
    this.mJobManager = paramJobManager;
  }
  
  private IWyFileSystem.WyErrorStatus getErrorStatus(Job paramJob)
  {
    IWyFileSystem.WyErrorStatus localWyErrorStatus = new IWyFileSystem.WyErrorStatus();
    localWyErrorStatus.errorCode = paramJob.getLastErrorNo();
    String str = ErrorMessages.getErrorString(paramJob.getLastErrorNo());
    if (!NetworkUtils.hasInternet(null)) {
      localWyErrorStatus.errorCode = -10003;
    }
    if (!Utils.isEmptyString(str)) {
      localWyErrorStatus.errorMsg = str;
    }
    for (;;)
    {
      if ((localWyErrorStatus.errorCode == -30012) || (localWyErrorStatus.errorCode == -30026)) {
        localWyErrorStatus.errorCode = -10003;
      }
      if (localWyErrorStatus.errorCode == -10003) {
        localWyErrorStatus.errorCode = 9004;
      }
      return localWyErrorStatus;
      if (!Utils.isEmptyString(paramJob.getLastErrorString())) {
        localWyErrorStatus.errorMsg = paramJob.getLastErrorString();
      } else {
        localWyErrorStatus.errorMsg = "未知错误!";
      }
    }
  }
  
  public boolean addListener(IWyTaskManager.TaskListener paramTaskListener)
  {
    return this.mListeners.addIfAbsent(paramTaskListener);
  }
  
  public boolean cancel()
  {
    this.mJob.removeListener(this.mJobManager);
    if ((this == this.mJobManager.findTask(this.mJob.getId())) && (this.mJobManager.removeTask(this.mJob.getId())))
    {
      this.mJobManager.dispatchTask();
      return true;
    }
    return false;
  }
  
  public Object getContext()
  {
    return this.mContext;
  }
  
  public long getId()
  {
    return this.mJob.getId();
  }
  
  public BaseJob getJob()
  {
    return this.mJob;
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob)
  {
    paramJob = this.mListeners.iterator();
    for (;;)
    {
      if (!paramJob.hasNext()) {
        return;
      }
      ((IWyTaskManager.TaskListener)paramJob.next()).onProgressChange(this, this.mContext, paramLong1, paramLong2);
    }
  }
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    Log.d("JobProxy", "task id " + paramJob.getId() + " new state " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramJob = this.mListeners.iterator();
      while (paramJob.hasNext()) {
        ((IWyTaskManager.TaskListener)paramJob.next()).onStarted(this, this.mContext);
      }
      continue;
      paramJob.removeListener(this);
      paramJob = this.mListeners.iterator();
      while (paramJob.hasNext()) {
        ((IWyTaskManager.TaskListener)paramJob.next()).onCanceled(this, this.mContext);
      }
      continue;
      paramJob.removeListener(this);
      paramJob = this.mListeners.iterator();
      while (paramJob.hasNext()) {
        ((IWyTaskManager.TaskListener)paramJob.next()).onSucceed(this, this.mContext);
      }
      continue;
      paramJob.removeListener(this);
      paramJob = getErrorStatus(paramJob);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((IWyTaskManager.TaskListener)localIterator.next()).onFailed(this, this.mContext, paramJob);
      }
    }
  }
  
  public void removeListener(IWyTaskManager.TaskListener paramTaskListener)
  {
    this.mListeners.remove(paramTaskListener);
  }
  
  public boolean submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.mJob.bindThreadPool(paramThreadPoolExecutor);
    return this.mJob.start();
  }
  
  public boolean suspend()
  {
    return this.mJob.suspend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.JobProxy
 * JD-Core Version:    0.7.0.1
 */