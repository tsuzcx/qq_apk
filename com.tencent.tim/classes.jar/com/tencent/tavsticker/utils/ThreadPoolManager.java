package com.tencent.tavsticker.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolManager
{
  private static final int MAX_RUNNING_THREAD = 5;
  private static volatile ThreadPoolManager _instance = null;
  private ScheduledExecutorService executor = null;
  
  private ThreadPoolManager()
  {
    try
    {
      this.executor = Executors.newScheduledThreadPool(5, new CommonThreadFactory("ThreadPool"));
      return;
    }
    catch (Throwable localThrowable)
    {
      this.executor = Executors.newScheduledThreadPool(5, new CommonThreadFactory("ThreadPool"));
    }
  }
  
  public static ThreadPoolManager get()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new ThreadPoolManager();
      }
      return _instance;
    }
    finally {}
  }
  
  public void start(Runnable paramRunnable)
  {
    if (this.executor != null) {
      paramRunnable = this.executor.submit(paramRunnable);
    }
    try
    {
      paramRunnable.get();
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      paramRunnable.printStackTrace();
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      paramRunnable.printStackTrace();
      return;
    }
    catch (Throwable paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
  
  public void startDelayed(Runnable paramRunnable, long paramLong)
  {
    if (this.executor != null) {
      this.executor.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
    }
  }
  
  static class CommonThreadFactory
    implements ThreadFactory
  {
    public final ThreadGroup group = Thread.currentThread().getThreadGroup();
    public final String threadNamePrefix;
    public final AtomicInteger threadNumber = new AtomicInteger(1);
    
    public CommonThreadFactory(String paramString)
    {
      this.threadNamePrefix = (paramString + "-");
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, this.threadNamePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 1) {
        paramRunnable.setPriority(1);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.utils.ThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */