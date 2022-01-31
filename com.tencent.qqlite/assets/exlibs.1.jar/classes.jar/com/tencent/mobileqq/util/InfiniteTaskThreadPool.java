package com.tencent.mobileqq.util;

import esg;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class InfiniteTaskThreadPool
  extends ThreadPoolExecutor
{
  public static final int a = 3;
  public static final long a = 10L;
  private static InfiniteTaskThreadPool a;
  public static final String a = "InfiniteTaskThread_";
  private static int b = 0;
  
  public InfiniteTaskThreadPool(int paramInt, long paramLong)
  {
    super(paramInt, 2147483647, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new esg(), new ThreadPoolExecutor.CallerRunsPolicy());
  }
  
  public static final InfiniteTaskThreadPool a()
  {
    if (a == null) {
      a = new InfiniteTaskThreadPool(3, 10L);
    }
    return a;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      super.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.InfiniteTaskThreadPool
 * JD-Core Version:    0.7.0.1
 */