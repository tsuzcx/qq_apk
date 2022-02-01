package com.tencent.oskplayer.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadUtils
{
  private static final String TAG = "ThreadUtils";
  
  public static void executePriorityTask(ArrayList<Runnable> paramArrayList)
  {
    try
    {
      executePriorityTask(paramArrayList, 2);
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public static void executePriorityTask(ArrayList<Runnable> paramArrayList, int paramInt)
  {
    try
    {
      PriorityExecutor localPriorityExecutor = new PriorityExecutor(paramInt);
      Iterator localIterator = paramArrayList.iterator();
      long l;
      for (paramArrayList = Long.valueOf(1L); localIterator.hasNext(); paramArrayList = Long.valueOf(l + 1L))
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        l = paramArrayList.longValue();
        localPriorityExecutor.execute(localRunnable, paramArrayList.longValue());
      }
      localPriorityExecutor.shutdown();
      return;
    }
    finally {}
  }
  
  public static Object submitTask(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    throws InterruptedException, ExecutionException
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    paramString1 = "job " + paramString1 + " ";
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      if (paramBoolean)
      {
        PlayerUtils.log(4, paramString2, paramString1 + "cancelled");
        paramCallable.cancel(true);
      }
    }
    return null;
  }
  
  public static Future<?> submitTask(Runnable paramRunnable, String paramString)
  {
    paramString = new FlexibleSizeExecutor("job " + paramString + " ");
    paramRunnable = paramString.submit(paramRunnable);
    paramString.shutdown();
    return paramRunnable;
  }
  
  public static void submitTask(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
    throws InterruptedException, ExecutionException
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    paramRunnable = localExecutorService.submit(paramRunnable);
    localExecutorService.shutdown();
    paramString = "job " + paramString + " ";
    long l = paramInt;
    try
    {
      paramRunnable.get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (!paramBoolean) {}
      PlayerUtils.log(4, "ThreadUtils", paramString + "cancelled");
      paramRunnable.cancel(true);
    }
  }
  
  public static Object submitTaskCatchAll(Callable<?> paramCallable, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = Executors.newSingleThreadExecutor();
    paramCallable = ((ExecutorService)localObject).submit(paramCallable);
    ((ExecutorService)localObject).shutdown();
    paramString1 = "job " + paramString1 + " ";
    long l = paramInt;
    try
    {
      localObject = paramCallable.get(l, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (InterruptedException paramCallable)
    {
      PlayerUtils.log(4, paramString2, paramString1 + "interrupted");
      return null;
    }
    catch (ExecutionException paramCallable)
    {
      for (;;)
      {
        PlayerUtils.log(4, paramString2, paramString1 + "caught exception " + PlayerUtils.getPrintableStackTrace(paramCallable));
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        if (paramBoolean)
        {
          PlayerUtils.log(4, paramString2, paramString1 + "cancelled");
          paramCallable.cancel(true);
        }
      }
    }
  }
  
  public static void submitTaskCatchAll(Runnable paramRunnable, int paramInt, boolean paramBoolean, String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    paramRunnable = localExecutorService.submit(paramRunnable);
    localExecutorService.shutdown();
    paramString = "job " + paramString + " ";
    long l = paramInt;
    try
    {
      paramRunnable.get(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      PlayerUtils.log(5, "ThreadUtils", paramString + "interrupted");
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      PlayerUtils.log(6, "ThreadUtils", paramString + "caught exception: " + PlayerUtils.getPrintableStackTrace(paramRunnable));
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (!paramBoolean) {}
      PlayerUtils.log(4, "ThreadUtils", paramString + "cancelled");
      paramRunnable.cancel(true);
    }
  }
  
  static class ComparableFutureTask<T>
    extends FutureTask<T>
    implements Comparable<ComparableFutureTask<T>>
  {
    volatile long priority = 0L;
    
    public ComparableFutureTask(Runnable paramRunnable, T paramT, long paramLong)
    {
      super(paramT);
      this.priority = paramLong;
    }
    
    public ComparableFutureTask(Callable<T> paramCallable, long paramLong)
    {
      super();
      this.priority = paramLong;
    }
    
    public int compareTo(ComparableFutureTask<T> paramComparableFutureTask)
    {
      return Long.valueOf(this.priority).compareTo(Long.valueOf(paramComparableFutureTask.priority));
    }
  }
  
  public static class FlexibleSizeExecutor
    extends ThreadPoolExecutor
  {
    String jobDescription = "";
    
    public FlexibleSizeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
    }
    
    public FlexibleSizeExecutor(String paramString)
    {
      super(1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      this.jobDescription = paramString;
    }
    
    protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      super.afterExecute(paramRunnable, paramThrowable);
      Throwable localThrowable1 = paramThrowable;
      if (paramThrowable == null)
      {
        localThrowable1 = paramThrowable;
        if (!(paramRunnable instanceof Future)) {}
      }
      try
      {
        paramRunnable = (Future)paramRunnable;
        localThrowable1 = paramThrowable;
        if (paramRunnable.isDone())
        {
          localThrowable1 = paramThrowable;
          if (!paramRunnable.isCancelled())
          {
            PlayerUtils.log(3, "ThreadUtils", "before future.get()");
            paramRunnable.get();
            PlayerUtils.log(3, "ThreadUtils", "after future.get()");
            localThrowable1 = paramThrowable;
          }
        }
      }
      catch (CancellationException localCancellationException)
      {
        for (;;)
        {
          PlayerUtils.log(5, "ThreadUtils", "CancellationException");
        }
      }
      catch (ExecutionException paramRunnable)
      {
        for (;;)
        {
          PlayerUtils.log(5, "ThreadUtils", "ExecutionException");
          localThrowable2 = paramRunnable.getCause();
        }
      }
      catch (InterruptedException paramRunnable)
      {
        for (;;)
        {
          PlayerUtils.log(5, "ThreadUtils", "InterruptedException");
          Thread.currentThread().interrupt();
          Throwable localThrowable2 = paramThrowable;
        }
      }
      if (localThrowable1 != null) {
        PlayerUtils.log(6, "ThreadUtils", this.jobDescription + " error occurred during processing request : " + PlayerUtils.getPrintableStackTrace(localThrowable1));
      }
    }
    
    protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      super.beforeExecute(paramThread, paramRunnable);
      PlayerUtils.log(4, "ThreadUtils", "beforeExecute: thread=" + paramThread.toString() + " thread.state=" + paramThread.getState() + " runnable=" + paramRunnable.toString());
    }
    
    public int getPendingTaskCount()
    {
      return getActiveCount() + getQueue().size();
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      return super.newTaskFor(paramRunnable, paramT);
    }
  }
  
  static class PriorityExecutor
    extends ThreadPoolExecutor
  {
    public PriorityExecutor(int paramInt)
    {
      this(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
    }
    
    public PriorityExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
    }
    
    public void execute(Runnable paramRunnable, long paramLong)
    {
      super.execute(new ThreadUtils.ComparableFutureTask(paramRunnable, null, paramLong));
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      return (RunnableFuture)paramRunnable;
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
    {
      return (RunnableFuture)paramCallable;
    }
    
    public Future<?> submit(Runnable paramRunnable, long paramLong)
    {
      return super.submit(new ThreadUtils.ComparableFutureTask(paramRunnable, null, paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */