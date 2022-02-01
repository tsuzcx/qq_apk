package com.tencent.mobileqq.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadFilePool
  extends ThreadSmartPool
{
  private static final int BLOCKING_QUEUE_SIZE;
  private static final int CORE_POOL_SIZE = 5;
  private static final int KEEP_ALIVE_TIME = 2;
  private static final int MAX_POOL_SIZE = Math.max(5, maximumPoolSize);
  
  static
  {
    if (ThreadSetting.isPublicVersion) {}
    for (int i = 128;; i = 64)
    {
      BLOCKING_QUEUE_SIZE = i;
      return;
    }
  }
  
  private ThreadFilePool(BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(5, MAX_POOL_SIZE, 2L, paramBlockingQueue, paramPriorityThreadFactory);
  }
  
  public static ThreadSmartPool createThreadPool()
  {
    return new ThreadFilePool(new LinkedBlockingQueue(BLOCKING_QUEUE_SIZE), new PriorityThreadFactory("thread_sp_file_", 2));
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  protected String getName()
  {
    return "ThreadFilePool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadFilePool
 * JD-Core Version:    0.7.0.1
 */