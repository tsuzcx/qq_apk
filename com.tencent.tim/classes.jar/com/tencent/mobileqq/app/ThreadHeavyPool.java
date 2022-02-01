package com.tencent.mobileqq.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadHeavyPool
  extends ThreadSmartPool
{
  private static final int BLOCKING_QUEUE_SIZE = 15;
  private static final int CORE_POOL_SIZE = 5;
  private static final int KEEP_ALIVE_TIME = 2;
  private static final int MAX_POOL_SIZE = 64;
  
  private ThreadHeavyPool(BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(5, 64, 2L, paramBlockingQueue, paramPriorityThreadFactory);
  }
  
  public static ThreadSmartPool createThreadPool()
  {
    return new ThreadHeavyPool(new LinkedBlockingQueue(15), new PriorityThreadFactory("thread_heavy_", 2));
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  protected String getName()
  {
    return "ThreadHeavyPool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInHeavy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadHeavyPool
 * JD-Core Version:    0.7.0.1
 */