package com.weiyun.sdk.util;

import com.weiyun.sdk.log.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFactory
{
  public static PriorityThreadPoolExecutor createPriorityThreadPoolExecutor(int paramInt1, int paramInt2, String paramString)
  {
    return new PriorityThreadPoolExecutor(paramInt1, paramInt2, new PriorityThreadFactory(paramString, 10));
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    return new ThreadPoolExecutorImpl(paramInt1, paramInt2, paramLong, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(paramString, 10));
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    return new ThreadPoolExecutorImpl(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt, long paramLong, String paramString)
  {
    return new ThreadPoolExecutorImpl(paramInt, paramInt, paramLong, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(paramString, 10));
  }
  
  private static class RunnableProxy
    implements Runnable
  {
    private final String TAG = "Execption";
    private final Runnable mR;
    
    public RunnableProxy(Runnable paramRunnable)
    {
      this.mR = paramRunnable;
    }
    
    public void run()
    {
      try
      {
        this.mR.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.w("Execption", localThrowable);
      }
    }
  }
  
  private static class ThreadPoolExecutorImpl
    extends ThreadPoolExecutor
  {
    public ThreadPoolExecutorImpl(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
    {
      super(paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    }
    
    public void execute(Runnable paramRunnable)
    {
      super.execute(new ThreadPoolFactory.RunnableProxy(paramRunnable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.util.ThreadPoolFactory
 * JD-Core Version:    0.7.0.1
 */