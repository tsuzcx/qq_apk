package com.tencent.qqlive.module.videoreport.report.element;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class PendingQueue
{
  private static final String TAG = "PendingQueue";
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private OnQueueListener mOnQueueListener;
  private ArrayMap<Long, PendingTask> mPendingTasks = new ArrayMap();
  
  void clearQueue()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  void enqueue(List<ExposureElementInfo> paramList, long paramLong)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.mPendingTasks.clear();
      int j = paramList.size();
      int i = 0;
      Object localObject1;
      Object localObject2;
      if (i < j)
      {
        ExposureElementInfo localExposureElementInfo = (ExposureElementInfo)paramList.get(i);
        localObject1 = localExposureElementInfo.getView();
        localObject2 = ((ExposureElementInfo)paramList.get(i)).getFinalData();
        if ((localObject1 == null) || (localObject2 == null)) {}
        for (;;)
        {
          i += 1;
          break;
          long l = Math.max(0L, ReportHelper.getExposureMinTime(DataBinder.getDataEntity(localObject1)) + paramLong);
          localObject2 = (PendingTask)this.mPendingTasks.get(Long.valueOf(l));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new PendingTask(null);
            this.mPendingTasks.put(Long.valueOf(l), localObject1);
          }
          ((PendingTask)localObject1).add(localExposureElementInfo);
        }
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PendingQueue", "enqueue: mPendingTasks.size() = " + this.mPendingTasks.size());
      }
      paramList = this.mPendingTasks.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject2 = (Map.Entry)paramList.next();
        localObject1 = (Long)((Map.Entry)localObject2).getKey();
        localObject2 = (PendingTask)((Map.Entry)localObject2).getValue();
        if (VideoReportInner.getInstance().isDebugMode()) {
          Log.d("PendingQueue", "enqueue: delay = " + localObject1 + ", view count = " + ((PendingTask)localObject2).pendingExposureElementInfoRef.size());
        }
        if (((Long)localObject1).longValue() != 0L) {
          this.mHandler.postDelayed((Runnable)localObject2, ((Long)localObject1).longValue());
        } else {
          ((PendingTask)localObject2).run();
        }
      }
    }
  }
  
  void setOnQueueListener(OnQueueListener paramOnQueueListener)
  {
    this.mOnQueueListener = paramOnQueueListener;
  }
  
  public static abstract interface OnQueueListener
  {
    public abstract void onDequeue(ExposureElementInfo paramExposureElementInfo);
  }
  
  class PendingTask
    implements Runnable
  {
    final List<ExposureElementInfo> pendingExposureElementInfoRef = new ArrayList();
    
    private PendingTask() {}
    
    void add(ExposureElementInfo paramExposureElementInfo)
    {
      this.pendingExposureElementInfoRef.add(paramExposureElementInfo);
    }
    
    public void run()
    {
      int j = this.pendingExposureElementInfoRef.size();
      int i = 0;
      while (i < j)
      {
        ExposureElementInfo localExposureElementInfo = (ExposureElementInfo)this.pendingExposureElementInfoRef.get(i);
        if ((localExposureElementInfo != null) && (PendingQueue.this.mOnQueueListener != null)) {
          PendingQueue.this.mOnQueueListener.onDequeue(localExposureElementInfo);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.PendingQueue
 * JD-Core Version:    0.7.0.1
 */