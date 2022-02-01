package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadSmartPool
  extends ThreadPoolExecutor
{
  private static int BLOCKING_TIME_OUT = 9990000;
  private static int CHECK_PERIOD = 9990000;
  protected static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int MAX_Report_Size = 1;
  protected static final int maximumPoolSize = CPU_COUNT * 2 + 1;
  private Handler REJECTED_THREAD_HANDLER;
  private int blockingReportCount = 0;
  private int initMaxPoolSize;
  protected long poolcheckTime = -1L;
  private boolean sAlreadyOutOfPool = false;
  private SmartRejectedExecutionHandler smartRejectedExecutionHandler = new SmartRejectedExecutionHandler();
  
  ThreadSmartPool(int paramInt1, int paramInt2, long paramLong, BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, TimeUnit.SECONDS, paramBlockingQueue, paramPriorityThreadFactory);
    setRejectedExecutionHandler(this.smartRejectedExecutionHandler);
    this.initMaxPoolSize = paramInt2;
  }
  
  private void checkBlockingState()
  {
    if (this.sAlreadyOutOfPool) {}
    label7:
    Object localObject;
    StringBuilder localStringBuilder;
    do
    {
      Job localJob;
      do
      {
        long l;
        do
        {
          do
          {
            return;
            break label7;
            while (!ThreadLog.needReportRunOrBlocking()) {}
            l = SystemClock.uptimeMillis();
          } while (l - this.poolcheckTime <= get_CHECK_PERIOD());
          this.poolcheckTime = l;
          ThreadLog.printQLog("ThreadManager", getName() + "_checkBlockingState");
          localObject = getQueue().iterator();
          l = SystemClock.uptimeMillis();
        } while (!((Iterator)localObject).hasNext());
        localJob = (Job)((Iterator)localObject).next();
        localJob.blcokingCost = (l - localJob.addPoint);
      } while (localJob.blcokingCost < get_BLOCKING_TIME_OUT());
      localObject = getName() + "_BlockingException";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n revision:" + ThreadSetting.revision);
      getRunningJob((String)localObject, localStringBuilder);
      localStringBuilder.append("\nblocking JOB: " + localJob.toString());
      localStringBuilder.append("\nblocking Executor:" + toString());
      ThreadLog.printQLog("ThreadManager", localStringBuilder.toString());
    } while ((!ThreadManagerV2.OPEN_RDM_REPORT) || (ThreadManagerV2.sThreadWrapContext == null) || (this.blockingReportCount >= 1));
    ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPBlockingCatchedException((String)localObject), (String)localObject, localStringBuilder.toString());
    this.blockingReportCount += 1;
  }
  
  private void doJobOneByOne(Runnable paramRunnable)
  {
    this.REJECTED_THREAD_HANDLER = getRejectedHandler();
    if (this.REJECTED_THREAD_HANDLER != null) {
      this.REJECTED_THREAD_HANDLER.post(paramRunnable);
    }
  }
  
  private Handler getRejectedHandler()
  {
    if (this.REJECTED_THREAD_HANDLER == null) {
      try
      {
        Object localObject = ThreadExcutor.getInstance().newFreeHandlerThread(getName() + "_Rejected_Handler", 10);
        ((HandlerThread)localObject).start();
        this.REJECTED_THREAD_HANDLER = new Handler(((HandlerThread)localObject).getLooper());
        localObject = this.REJECTED_THREAD_HANDLER;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ThreadLog.printQLog("ThreadManager", getName() + "_getRejectedHandler:", localOutOfMemoryError);
      }
    }
    return this.REJECTED_THREAD_HANDLER;
  }
  
  private StringBuilder getRunningJob(String paramString, StringBuilder paramStringBuilder)
  {
    ThreadLog.printQLog("ThreadManager", "\ngetRunningJob from: " + paramString);
    paramString = getRunningJobCache();
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramStringBuilder.append("\n" + str);
      }
    }
    return paramStringBuilder;
  }
  
  private static long get_BLOCKING_TIME_OUT()
  {
    if (!ThreadSetting.isPublicVersion) {
      BLOCKING_TIME_OUT = 30000;
    }
    return BLOCKING_TIME_OUT;
  }
  
  private static long get_CHECK_PERIOD()
  {
    if (!ThreadSetting.isPublicVersion) {
      CHECK_PERIOD = 30000;
    }
    return CHECK_PERIOD;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (ThreadManagerV2.IsRunTimeShutDown)
    {
      ThreadLog.printQLog("ThreadManager", "pool has shutdown:" + paramRunnable.toString());
      return;
    }
    if (!(paramRunnable instanceof Job))
    {
      if (ThreadSetting.logcatBgTaskMonitor) {
        ThreadLog.printQLog("ThreadManager", "command is not instanceof Job " + paramRunnable.toString());
      }
      Job localJob;
      if ((this instanceof ThreadAsyncTaskPool)) {
        localJob = ThreadExcutor.buildJob(256, paramRunnable, null, false);
      }
      for (localJob.poolNum = 10; localJob == null; localJob.poolNum = 11)
      {
        ThreadLog.printQLog("ThreadManager", "sp execute job == null ");
        doJobOneByOne(paramRunnable);
        return;
        localJob = ThreadExcutor.buildJob(512, paramRunnable, null, false);
      }
    }
    for (paramRunnable = (Job)paramRunnable;; paramRunnable = localOutOfMemoryError) {
      try
      {
        if (ThreadSetting.logcatBgTaskMonitor) {
          ThreadLog.printQLog("ThreadManager", "tsp execute:" + paramRunnable.toString());
        }
        checkBlockingState();
        super.execute(paramRunnable);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ThreadLog.printQLog("ThreadManager", "execute job OutOfMemoryError:" + paramRunnable.toString(), localOutOfMemoryError);
        doJobOneByOne(paramRunnable);
        return;
      }
      catch (InternalError paramRunnable)
      {
        ThreadLog.printQLog("ThreadManager", "java.lang.InternalError: Thread starting during runtime shutdown", paramRunnable);
        return;
      }
    }
  }
  
  int getInitMaxPoolSize()
  {
    return this.initMaxPoolSize;
  }
  
  protected String getName()
  {
    return "ThreadOtherPool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInOther;
  }
  
  protected void terminated()
  {
    super.terminated();
  }
  
  class SmartRejectedExecutionHandler
    implements RejectedExecutionHandler
  {
    private int rejectReportCount = 0;
    
    public SmartRejectedExecutionHandler() {}
    
    private boolean needReportRejectedError()
    {
      return (this.rejectReportCount < 1) && (ThreadLog.needRecordJob());
    }
    
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      ThreadSmartPool.access$002(ThreadSmartPool.this, true);
      if ((needReportRejectedError()) && ((paramThreadPoolExecutor instanceof ThreadSmartPool)))
      {
        String str1 = ((ThreadSmartPool)paramThreadPoolExecutor).getName();
        String str2 = str1 + "_RejectedExecution";
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n revision:" + ThreadSetting.revision);
        ThreadSmartPool.this.getRunningJob(str2, localStringBuilder);
        localStringBuilder.append("\n" + str2 + paramThreadPoolExecutor.toString());
        ThreadLog.printQLog("ThreadManager", str2 + localStringBuilder.toString());
        if (ThreadManagerV2.sThreadWrapContext != null)
        {
          ThreadManagerV2.sThreadWrapContext.reportRDMException(new TSPRejectedCatchedException(str2), str2, localStringBuilder.toString());
          this.rejectReportCount += 1;
          paramThreadPoolExecutor = new HashMap();
          paramThreadPoolExecutor.put("executor", str1);
          paramThreadPoolExecutor.put("process", String.valueOf(ThreadSetting.sProcessId));
          ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "sp_reject_exception_report", true, 0L, 0L, paramThreadPoolExecutor, "", false);
        }
      }
      ThreadSmartPool.this.doJobOneByOne(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadSmartPool
 * JD-Core Version:    0.7.0.1
 */