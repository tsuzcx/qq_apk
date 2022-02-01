package com.tencent.qapmsdk.resource.runnable;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import com.tencent.qapmsdk.resource.meta.PerfItem;
import java.util.Vector;

public class MonitorRunnable
  implements Runnable
{
  private static final long MILLS_SECOND = 1000L;
  private static final long SPAN_DEBUG = 1000L;
  private static final long SPAN_PUBLIC = 5000L;
  @Nullable
  private static volatile MonitorRunnable instance = null;
  private long delayTime = 1000L;
  private Handler handler = new Handler(ThreadManager.getMonitorThreadLooper());
  
  private MonitorRunnable()
  {
    if (ResourceMonitor.getInstance().isPublicMode()) {
      this.delayTime = 5000L;
    }
  }
  
  @Nullable
  public static MonitorRunnable getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MonitorRunnable();
      }
      return instance;
    }
    finally {}
  }
  
  public void run()
  {
    ResourceMonitor.getInstance().samplePerfValue(new PerfItem()).eventTime = (System.currentTimeMillis() / 1000L);
    Object localObject = getInstance();
    this.handler.postDelayed((Runnable)localObject, this.delayTime);
    if (ResourceMonitor.immediatePerfItems.size() > 900)
    {
      localObject = DumpSampleFileRunnable.getInstance();
      this.handler.post((Runnable)localObject);
    }
  }
  
  public void scheduleDumpOnce()
  {
    this.handler.post(this);
  }
  
  public void stop()
  {
    this.handler.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.MonitorRunnable
 * JD-Core Version:    0.7.0.1
 */