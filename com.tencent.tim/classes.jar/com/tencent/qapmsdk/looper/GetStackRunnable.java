package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GetStackRunnable
  implements Runnable
{
  private static final int BUILDER_SIZE = 1024;
  private static final int MAX_STACK_DEPTH = 100;
  private static final int MAX_STACK_LENGTH = 30000;
  private static final int MAX_STACK_TIME_SPAN = 500;
  private static final int MAX_TIME_SPAN = 100000;
  private static final String TAG = "QAPM_looper_GetStackRunnable";
  private static final int TIME_TOLERANCE = 10;
  private static final int WAIT_MORE_BEFORE_STACK = 200;
  private static final String WHITE_LIST = "android.support.v4.";
  @Nullable
  private static Handler handler;
  @NonNull
  private StringBuilder builder = new StringBuilder(1024);
  private int checkInterval = PluginCombination.loopStackPlugin.threshold;
  private int randomRange = 500 - this.checkInterval;
  private ArrayList<String> stackStorage;
  private final String[] systemStackElementPrefix = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private Thread watchingThread;
  
  GetStackRunnable(Thread paramThread)
  {
    if (this.randomRange > 0) {}
    for (int i = this.randomRange;; i = this.checkInterval * 4)
    {
      this.randomRange = i;
      this.stackStorage = new ArrayList(100);
      this.watchingThread = paramThread;
      handler = new Handler(ThreadManager.getStackThreadLooper());
      return;
    }
  }
  
  private String getStack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.stackStorage.clear();
        localObject = this.watchingThread.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label245;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int m;
        Logger.INSTANCE.exception("QAPM_looper_GetStackRunnable", localThrowable);
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.systemStackElementPrefix;
        m = arrayOfString.length;
        j = 0;
        if (j < m)
        {
          if (!str.startsWith(arrayOfString[j])) {
            break label271;
          }
          if (!str.startsWith("android.support.v4.")) {
            break label266;
          }
          j = 0;
          break label253;
        }
      }
      else
      {
        if (this.stackStorage.size() > 0)
        {
          this.builder.setLength(0);
          i = this.stackStorage.size() - 1;
          if ((i >= 0) && (i > this.stackStorage.size() - 1 - 100) && (this.builder.length() < 30000))
          {
            this.builder.append((String)this.stackStorage.get(i)).append(",");
            i -= 1;
            continue;
            this.stackStorage.add(str);
            break label289;
          }
          if (this.builder.length() > 0)
          {
            localObject = this.builder.toString();
            return localObject;
          }
          return null;
        }
        return null;
      }
      int j = 0;
      break label253;
      label245:
      int k = 0;
      int i = 0;
      continue;
      for (;;)
      {
        label253:
        if (j == 0) {
          break label278;
        }
        j = i;
        if (i == 0) {
          break label289;
        }
        break;
        label266:
        j = 1;
      }
      label271:
      j += 1;
      continue;
      label278:
      j = i;
      if (i == 0)
      {
        j = 1;
        continue;
        label289:
        k += 1;
        i = j;
      }
    }
  }
  
  private void onThreadMonitorEnd(MonitorInfo paramMonitorInfo)
  {
    try
    {
      paramMonitorInfo.stackGetter = null;
      paramMonitorInfo.stackGetterInited = false;
      paramMonitorInfo.callback.onMonitorEnd();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    Object localObject = (MonitorInfo)LooperMonitor.monitorMap.get(this.watchingThread.getName());
    if (localObject == null) {
      return;
    }
    if (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin))
    {
      onThreadMonitorEnd((MonitorInfo)localObject);
      return;
    }
    localObject = new Step1Runnable(handler, (MonitorInfo)localObject);
    handler.postDelayed((Runnable)localObject, this.checkInterval);
  }
  
  class Step1Runnable
    implements Runnable
  {
    private MonitorInfo mi;
    private Handler stepHandler;
    
    public Step1Runnable(Handler paramHandler, MonitorInfo paramMonitorInfo)
    {
      this.stepHandler = paramHandler;
      this.mi = paramMonitorInfo;
    }
    
    public void run()
    {
      if (this.mi.lastStackRequestTime != 0L)
      {
        long l1 = this.mi.lastStackRequestTime;
        long l2 = SystemClock.uptimeMillis() - l1 - GetStackRunnable.this.checkInterval;
        if (l2 > 100000L)
        {
          this.stepHandler.post(GetStackRunnable.this);
          return;
        }
        if (l2 < -10L)
        {
          localObject = new GetStackRunnable.Step2Runnable(GetStackRunnable.this, this.stepHandler, this.mi, l1);
          this.stepHandler.postDelayed((Runnable)localObject, -l2);
          return;
        }
        l2 = SystemClock.uptimeMillis() - l1;
        if ((l2 < GetStackRunnable.this.checkInterval - 10) || (l2 > 100000L))
        {
          this.stepHandler.post(GetStackRunnable.this);
          return;
        }
        Object localObject = new GetStackRunnable.Step3Runnable(GetStackRunnable.this, this.stepHandler, this.mi, l1);
        this.stepHandler.postDelayed((Runnable)localObject, 200L);
        return;
      }
      this.stepHandler.post(GetStackRunnable.this);
    }
  }
  
  class Step2Runnable
    implements Runnable
  {
    private MonitorInfo mi;
    private long requestTimeRef;
    private Handler stepHandler;
    
    public Step2Runnable(Handler paramHandler, MonitorInfo paramMonitorInfo, long paramLong)
    {
      this.stepHandler = paramHandler;
      this.mi = paramMonitorInfo;
      this.requestTimeRef = paramLong;
    }
    
    public void run()
    {
      long l = SystemClock.uptimeMillis() - this.requestTimeRef;
      if ((l < GetStackRunnable.this.checkInterval - 10) || (l > 100000L))
      {
        this.stepHandler.post(GetStackRunnable.this);
        return;
      }
      GetStackRunnable.Step3Runnable localStep3Runnable = new GetStackRunnable.Step3Runnable(GetStackRunnable.this, this.stepHandler, this.mi, this.requestTimeRef);
      this.stepHandler.postDelayed(localStep3Runnable, 200L);
    }
  }
  
  class Step3Runnable
    implements Runnable
  {
    private MonitorInfo mi;
    private long requestTimeRef;
    private Handler stepHandler;
    
    public Step3Runnable(Handler paramHandler, MonitorInfo paramMonitorInfo, long paramLong)
    {
      this.stepHandler = paramHandler;
      this.mi = paramMonitorInfo;
      this.requestTimeRef = paramLong;
    }
    
    public void run()
    {
      long l = SystemClock.uptimeMillis() - this.mi.lastStackRequestTime;
      if ((this.requestTimeRef == this.mi.lastStackRequestTime) && (l >= GetStackRunnable.this.checkInterval + 200 - 10) && (l < 100000L))
      {
        this.mi.cacheRealStackTime = System.currentTimeMillis();
        String str = GetStackRunnable.this.getStack(true);
        this.mi.stack = str;
        this.mi.lastStackRequestTime = 0L;
      }
      this.stepHandler.post(GetStackRunnable.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable
 * JD-Core Version:    0.7.0.1
 */