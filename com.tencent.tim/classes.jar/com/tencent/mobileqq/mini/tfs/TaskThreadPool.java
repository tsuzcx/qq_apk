package com.tencent.mobileqq.mini.tfs;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskThreadPool
{
  private static final int PERIOD_TASK_QOS = 100;
  private static final int SIZE_CORE_POOL = 3;
  private static final int SIZE_MAX_POOL = 4;
  private static final int SIZE_WORK_QUEUE = 100;
  private static final int TIME_KEEP_ALIVE = 5000;
  private final Runnable mAccessBufferThread = new TaskThreadPool.2(this);
  private final RejectedExecutionHandler mHandler = new TaskThreadPool.1(this);
  protected final ScheduledFuture<?> mTaskHandler = this.scheduler.scheduleAtFixedRate(this.mAccessBufferThread, 0L, 100L, TimeUnit.MILLISECONDS);
  private final Queue<Runnable> mTaskQueue = new LinkedList();
  private final ThreadPoolExecutor mThreadPool;
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  
  public TaskThreadPool(String paramString, int paramInt1, int paramInt2)
  {
    this.mThreadPool = new ThreadPoolExecutor(paramInt1, paramInt2, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new CustomThreadFactory(paramString), this.mHandler);
  }
  
  private boolean hasMoreAcquire()
  {
    return !this.mTaskQueue.isEmpty();
  }
  
  public void addExecuteTask(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.mThreadPool.execute(paramRunnable);
    }
  }
  
  protected boolean isTaskEnd()
  {
    return this.mThreadPool.getActiveCount() == 0;
  }
  
  public void perpare()
  {
    if ((this.mThreadPool.isShutdown()) && (!this.mThreadPool.prestartCoreThread())) {
      this.mThreadPool.prestartAllCoreThreads();
    }
  }
  
  public void shutdown()
  {
    this.mTaskQueue.clear();
    this.mThreadPool.shutdown();
  }
  
  static class CustomThreadFactory
    implements ThreadFactory
  {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    CustomThreadFactory(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.group = ((ThreadGroup)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = "threadpool";
        }
        this.namePrefix = ((String)localObject + "-" + poolNumber.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskThreadPool
 * JD-Core Version:    0.7.0.1
 */