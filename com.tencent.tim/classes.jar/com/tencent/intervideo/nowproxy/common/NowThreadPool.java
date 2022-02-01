package com.tencent.intervideo.nowproxy.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class NowThreadPool
{
  public static ThreadPoolProvider sThreadPoolProvider = new NowThreadPool.1();
  
  public static void setThreadPoolProvider(ThreadPoolProvider paramThreadPoolProvider)
  {
    sThreadPoolProvider = paramThreadPoolProvider;
  }
  
  public static abstract interface ThreadPoolProvider
  {
    public abstract ExecutorService getFixedThreadPool(int paramInt);
    
    public abstract ScheduledExecutorService getScheduledThreadPool(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.NowThreadPool
 * JD-Core Version:    0.7.0.1
 */