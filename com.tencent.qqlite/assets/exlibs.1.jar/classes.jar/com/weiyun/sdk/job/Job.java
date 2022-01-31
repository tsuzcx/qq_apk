package com.weiyun.sdk.job;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Job
  implements Runnable
{
  public static final int STATE_CANCELED = 7;
  public static final int STATE_FAILED = 6;
  public static final int STATE_INIT = 0;
  public static final int STATE_RUNNING = 4;
  public static final int STATE_START = 2;
  public static final int STATE_SUCCESS = 5;
  public static final int STATE_SUSPEND = 8;
  public static final int STATE_WAIT = 1;
  public static final int STATE_WAIT_URL = 3;
  private final long mId;
  private volatile int mLastErrorNo = 0;
  private volatile String mLastErrorString = "OK";
  private final CopyOnWriteArrayList<JobListener> mListeners;
  private volatile int mState;
  
  public Job(long paramLong)
  {
    this.mId = paramLong;
    this.mListeners = new CopyOnWriteArrayList();
    this.mState = 0;
  }
  
  public void addListener(JobListener paramJobListener)
  {
    this.mListeners.addIfAbsent(paramJobListener);
  }
  
  public boolean cancel()
  {
    return true;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  public int getLastErrorNo()
  {
    return this.mLastErrorNo;
  }
  
  public String getLastErrorString()
  {
    return this.mLastErrorString;
  }
  
  protected int getState()
  {
    try
    {
      int i = this.mState;
      return i;
    }
    finally {}
  }
  
  public boolean isAlive()
  {
    return true;
  }
  
  protected void notifyError(int paramInt, String paramString)
  {
    this.mLastErrorNo = paramInt;
    this.mLastErrorString = paramString;
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((JobListener)localIterator.next()).notifyProgressChanged(paramLong1, paramLong2, this);
    }
  }
  
  protected void notifyStateChanged(int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((JobListener)localIterator.next()).notifyStateChanged(paramInt, this);
    }
  }
  
  public void removeListener(JobListener paramJobListener)
  {
    this.mListeners.remove(paramJobListener);
  }
  
  public boolean restart()
  {
    return true;
  }
  
  public void run()
  {
    setState(5);
  }
  
  protected void setLastErrorNo(int paramInt)
  {
    this.mLastErrorNo = paramInt;
  }
  
  protected void setLastErrorString(String paramString)
  {
    this.mLastErrorString = paramString;
  }
  
  protected void setState(int paramInt)
  {
    try
    {
      this.mState = paramInt;
      notifyStateChanged(paramInt);
      return;
    }
    finally {}
  }
  
  public boolean start()
  {
    return true;
  }
  
  public boolean suspend()
  {
    return true;
  }
  
  public static abstract interface JobListener
  {
    public abstract void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob);
    
    public abstract void notifyStateChanged(int paramInt, Job paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.Job
 * JD-Core Version:    0.7.0.1
 */