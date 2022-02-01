package com.tribe.async.async;

import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.dispatch.AbsEventBatcher;
import com.tribe.async.log.SLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class LightWeightExecutor
  extends AbsEventBatcher<Runnable>
  implements Executor
{
  private static final int QUEUE_SIZE_LIMIT = 200;
  private static final long RUN_TIME_LIMIT = 120000L;
  private static final String TAG = "async.boss.LightWeightExecutor";
  private final byte[] holderLock = new byte[0];
  private MonitorThreadPoolExecutor.ThreadPoolMonitorListener mMonitorListener;
  private int mQueueSizeLimit = 200;
  private long mRunTimeLimit = 120000L;
  private RunnableHolder mRunnableHolder;
  
  public LightWeightExecutor(Looper paramLooper, int paramInt)
  {
    super(paramLooper, new RunnableQueue(), paramInt);
  }
  
  private void checkRunning()
  {
    if (this.mMonitorListener == null) {
      return;
    }
    int i = getEnqueueSize();
    if (i > this.mQueueSizeLimit)
    {
      this.mMonitorListener.onQueueExceedLimit("async.boss.LightWeightExecutor", i);
      SLog.d("async.boss.LightWeightExecutor", "cur state = " + getCurState());
      synchronized (this.holderLock)
      {
        if (this.mRunnableHolder != null)
        {
          ??? = (Runnable)this.mRunnableHolder.get();
          if (??? != null) {
            SLog.d("async.boss.LightWeightExecutor", "cur runnable = " + ???);
          }
        }
        dumpAllEvent();
      }
    }
    for (;;)
    {
      synchronized (this.holderLock)
      {
        if (this.mRunnableHolder != null)
        {
          Runnable localRunnable = (Runnable)this.mRunnableHolder.get();
          if ((localRunnable != null) && (this.mRunnableHolder.getItemRunTimes() > this.mRunTimeLimit))
          {
            ??? = new ArrayList();
            ((List)???).add(localRunnable);
            if ((??? == null) || (((List)???).size() <= 0)) {
              break;
            }
            this.mMonitorListener.onWorkerExceedTime("async.boss.LightWeightExecutor", (List)???, 1);
            return;
            localObject5 = finally;
            throw localObject5;
          }
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    enqueue(paramRunnable);
    checkRunning();
  }
  
  protected void handleItem(Runnable arg1)
  {
    synchronized (this.holderLock)
    {
      this.mRunnableHolder = new RunnableHolder(???);
      ???.run();
    }
    synchronized (this.holderLock)
    {
      this.mRunnableHolder = null;
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public void setMonitorListener(MonitorThreadPoolExecutor.ThreadPoolMonitorListener paramThreadPoolMonitorListener)
  {
    this.mMonitorListener = paramThreadPoolMonitorListener;
  }
  
  public void setQueueSizeLimit(int paramInt)
  {
    this.mQueueSizeLimit = paramInt;
  }
  
  public void setRunTimeLimit(long paramLong)
  {
    this.mRunTimeLimit = paramLong;
  }
  
  static class RunnableHolder
    extends WeakReference<Runnable>
  {
    private long mRunStartTime = SystemClock.elapsedRealtime();
    
    public RunnableHolder(Runnable paramRunnable)
    {
      super();
    }
    
    public RunnableHolder(Runnable paramRunnable, ReferenceQueue<? super Runnable> paramReferenceQueue)
    {
      super(paramReferenceQueue);
    }
    
    public long getItemRunTimes()
    {
      return SystemClock.elapsedRealtime() - this.mRunStartTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.LightWeightExecutor
 * JD-Core Version:    0.7.0.1
 */