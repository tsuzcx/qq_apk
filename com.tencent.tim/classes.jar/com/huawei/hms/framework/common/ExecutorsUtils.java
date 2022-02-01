package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsUtils
{
  private static final String THREADNAME_HEADER = "NetworkKit_";
  
  public static ThreadFactory createThreadFactory(String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      throw new NullPointerException("ThreadName is empty");
    }
    return new ExecutorsUtils.1(paramString);
  }
  
  public static ExecutorService newCachedThreadPool(String paramString)
  {
    paramString = createThreadFactory(paramString);
    return new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), paramString);
  }
  
  public static ExecutorService newFixedThreadPool(int paramInt, String paramString)
  {
    paramString = createThreadFactory(paramString);
    return new ThreadPoolExecutor(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), paramString);
  }
  
  public static ScheduledExecutorService newScheduledThreadPool(int paramInt, String paramString)
  {
    return new ScheduledThreadPoolExecutor(paramInt, createThreadFactory(paramString));
  }
  
  public static ExecutorService newSingleThreadExecutor(String paramString)
  {
    return Executors.newSingleThreadExecutor(createThreadFactory(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExecutorsUtils
 * JD-Core Version:    0.7.0.1
 */