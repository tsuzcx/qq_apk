package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.SparseBooleanArray;
import anpi;
import awit;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import jqo;
import lbx;
import lch;

public class MonitorTimeExecutor
  extends ThreadPoolExecutor
{
  private static long CHECK_PERIOD = 5000L;
  private static boolean DEBUG;
  private static Handler aV;
  private static volatile ThreadPoolExecutor h;
  private static long to = 30000L;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private TimeTrackedRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable;
  
  private MonitorTimeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new lch(), new lbx());
  }
  
  private static String a(Thread paramThread)
  {
    if (paramThread == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|").append("pub").append("|").append(System.currentTimeMillis());
    localStringBuilder.append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
    localStringBuilder.append("|").append("monitorThread=").append(paramThread.getName()).append(",tid=").append(paramThread.getId()).append(",state=").append(paramThread.getState());
    localStringBuilder.append(anpi.Am());
    localStringBuilder.append(anpi.An());
    return localStringBuilder.toString();
  }
  
  private static void a(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    QLog.i("MonitorTimeExecutor", 1, "[startWatching] for " + paramMonitorTimeExecutor);
    if (!((Boolean)awit.f("sp_key_kandian_thread_pool_monitor_enable", Boolean.valueOf(false))).booleanValue())
    {
      QLog.i("MonitorTimeExecutor", 1, "[startWatching] won't start since monitor disabled");
      return;
    }
    CHECK_PERIOD = ((Long)awit.f("sp_key_kandian_thread_pool_check_period", Long.valueOf(5000L))).longValue();
    to = ((Long)awit.f("sp_key_kandian_thread_pool_time_out_threshold", Long.valueOf(30000L))).longValue();
    QLog.i("MonitorTimeExecutor", 1, "[startWatching] CHECK_PERIOD=" + CHECK_PERIOD + " THRESHOLD=" + to);
    if (aV == null) {
      aV = new Handler(ThreadManager.getFileThreadLooper());
    }
    aV.post(new WatchDogRunnable(paramMonitorTimeExecutor, null));
  }
  
  private static boolean a(StringBuilder paramStringBuilder, String paramString)
  {
    QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] ");
    for (;;)
    {
      int i;
      try
      {
        Thread[] arrayOfThread = new Thread[Thread.activeCount()];
        Thread.enumerate(arrayOfThread);
        i = 0;
        if (i < arrayOfThread.length)
        {
          Object localObject = arrayOfThread[i];
          if (localObject != null)
          {
            paramStringBuilder.append("Name:").append(((Thread)localObject).getName()).append("\n").append("State:").append(((Thread)localObject).getState()).append("\n").append("Tid:").append(((Thread)localObject).getId()).append("\n");
            if (((Thread)localObject).isAlive())
            {
              localObject = ((Thread)localObject).getStackTrace();
              int k = localObject.length;
              int j = 0;
              if (j < k)
              {
                paramStringBuilder.append(localObject[j].toString()).append("\n");
                j += 1;
                continue;
              }
              paramStringBuilder.append("\n");
            }
          }
        }
        else
        {
          paramStringBuilder.append("\n").append(paramString);
          return true;
        }
      }
      catch (Exception paramStringBuilder)
      {
        QLog.e("MonitorTimeExecutor", 1, "[dumpAllJavaStacks] failed ", paramStringBuilder);
        return false;
      }
      i += 1;
    }
  }
  
  private static void b(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    TimeTrackedRunnable localTimeTrackedRunnable = paramMonitorTimeExecutor.a();
    if ((localTimeTrackedRunnable != null) && (TimeTrackedRunnable.a(localTimeTrackedRunnable) > 0L))
    {
      long l = SystemClock.uptimeMillis() - TimeTrackedRunnable.a(localTimeTrackedRunnable);
      if (DEBUG) {
        QLog.d("MonitorTimeExecutor", 2, "[run] currentTask=" + localTimeTrackedRunnable + " running for " + l + "ms");
      }
      if ((l > to) && (!Debug.isDebuggerConnected()))
      {
        QLog.e("MonitorTimeExecutor", 1, "[run] time limit exceed!, task=" + localTimeTrackedRunnable);
        if (!paramMonitorTimeExecutor.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(localTimeTrackedRunnable.c().hashCode(), false)) {
          break label147;
        }
        QLog.i("MonitorTimeExecutor", 1, "[checkBlockingState] skip task since already reported");
      }
    }
    return;
    label147:
    String str2 = a(localTimeTrackedRunnable.a());
    String str1 = str2;
    for (;;)
    {
      try
      {
        localObject = anpi.nC("kandian");
        str1 = str2;
        i = anpi.h(BaseApplication.getContext(), (String)localObject, str2);
        if (i != 1) {
          continue;
        }
        str1 = str2;
        QLog.i("MonitorTimeExecutor", 1, "[checkBlockingState] trace dumped: " + (String)localObject);
        str1 = str2;
        str2 = jqo.e(new FileInputStream((String)localObject));
        str1 = str2;
        jqo.deleteFile((String)localObject);
        str1 = str2;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("MonitorTimeExecutor", 1, "[checkBlockingState] ", localException);
        continue;
      }
      QQCatchedExceptionReporter.reportQQCatchedException(new KandianTaskRunningTooLongException(null), "", str1);
      paramMonitorTimeExecutor.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(localTimeTrackedRunnable.c().hashCode(), true);
      return;
      str1 = str2;
      QLog.e("MonitorTimeExecutor", 1, "[checkBlockingState] dump thread result: " + i);
      str1 = str2;
      localObject = new StringBuilder();
      str1 = str2;
      if (a((StringBuilder)localObject, str2))
      {
        str1 = str2;
        str2 = ((StringBuilder)localObject).toString();
        str1 = str2;
      }
      else
      {
        str1 = str2;
        QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] failed");
        str1 = str2;
      }
    }
  }
  
  public static ExecutorService e()
  {
    if (h == null) {}
    try
    {
      if (h == null)
      {
        MonitorTimeExecutor localMonitorTimeExecutor = new MonitorTimeExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        a(localMonitorTimeExecutor);
        h = localMonitorTimeExecutor;
      }
      QLog.i("MonitorTimeExecutor", 1, "[newThreadExecutor]: " + h);
      return h;
    }
    finally {}
  }
  
  public TimeTrackedRunnable a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable == paramRunnable) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable = null;
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    if ((paramRunnable instanceof TimeTrackedRunnable)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineMonitorTimeExecutor$TimeTrackedRunnable = ((TimeTrackedRunnable)paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new TimeTrackedRunnable(paramRunnable, null));
  }
  
  public void shutdown()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdown]");
  }
  
  public List<Runnable> shutdownNow()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdownNow]");
    return Collections.emptyList();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return super.submit(new TimeTrackedRunnable(paramRunnable, null));
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return super.submit(new TimeTrackedRunnable(paramRunnable, null), paramT);
  }
  
  static class KandianTaskRunningTooLongException
    extends RuntimeException
  {
    public String getMessage()
    {
      return super.getMessage();
    }
  }
  
  static class TimeTrackedRunnable
    implements Runnable
  {
    private Thread currentThread;
    private final Runnable task;
    private final long tp;
    private long tq;
    private long tr;
    
    private TimeTrackedRunnable(@NonNull Runnable paramRunnable)
    {
      this.task = paramRunnable;
      this.tp = SystemClock.uptimeMillis();
    }
    
    public Thread a()
    {
      return this.currentThread;
    }
    
    public Runnable c()
    {
      return this.task;
    }
    
    public void run()
    {
      this.tq = SystemClock.uptimeMillis();
      this.tr = (this.tq - this.tp);
      this.currentThread = Thread.currentThread();
      this.task.run();
    }
    
    public String toString()
    {
      return "TimeTrackedRunnable{timestampAdded=" + this.tp + ", timestampStarted=" + this.tq + ", task=" + this.task + ", timeWaited=" + this.tr + ", currentThread=" + this.currentThread + '}';
    }
  }
  
  static class WatchDogRunnable
    implements Runnable
  {
    private final MonitorTimeExecutor a;
    
    private WatchDogRunnable(@NonNull MonitorTimeExecutor paramMonitorTimeExecutor)
    {
      this.a = paramMonitorTimeExecutor;
    }
    
    public void run()
    {
      if (MonitorTimeExecutor.DEBUG) {
        QLog.d("WatchDog", 2, "[run] checking " + this.a);
      }
      if ((!this.a.isTerminating()) && (!this.a.isTerminated()) && (!this.a.isShutdown()))
      {
        MonitorTimeExecutor.c(this.a);
        if (MonitorTimeExecutor.q() != null) {
          MonitorTimeExecutor.q().postDelayed(this, MonitorTimeExecutor.CHECK_PERIOD);
        }
        return;
      }
      QLog.d("WatchDog", 2, "[run] skip since executor terminated: " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor
 * JD-Core Version:    0.7.0.1
 */