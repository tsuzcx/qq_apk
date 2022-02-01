package com.tencent.qqmail.utilities.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Threads
{
  private static final ScheduledThreadPoolExecutor EXECUTOR;
  private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
  private static final String TAG = "Threads";
  private static final ExecutorService jobsForUI = QMSchedulers.futureTask;
  private static Field sField_FutureTask_callable;
  private static Field sField_RunnableAdapter_task;
  private static Method sMethod_Handler_hasCallbacks;
  
  static
  {
    EXECUTOR = QMSchedulers.background;
    try
    {
      sMethod_Handler_hasCallbacks = Handler.class.getMethod("hasCallbacks", new Class[] { Runnable.class });
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Field localField = Class.forName("java.util.concurrent.Executors$RunnableAdapter").getDeclaredField("task");
          localField.setAccessible(true);
          sField_RunnableAdapter_task = localField;
          localField = FutureTask.class.getDeclaredField("callable");
          localField.setAccessible(true);
          sField_FutureTask_callable = localField;
          return;
        }
        catch (Exception localException2)
        {
          QMLog.log(5, "Threads", "callable failed", localException2);
        }
        localException1 = localException1;
        QMLog.log(5, "Threads", "hasCallbacks failed", localException1);
      }
    }
  }
  
  public static <T> void cancelTask(Future<T> paramFuture)
  {
    if (paramFuture != null) {
      paramFuture.cancel(true);
    }
  }
  
  public static StringBuilder dumpAllThread(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Map localMap = Thread.getAllStackTraces();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Thread)localIterator.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(localObject1);
      if (!paramBoolean)
      {
        localStringBuilder.append("\n");
        localObject1 = (StackTraceElement[])localMap.get(localObject1);
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localStringBuilder.append("\tat ").append(localObject2).append("\n");
          i += 1;
        }
      }
    }
    return localStringBuilder;
  }
  
  public static boolean hasCallbackInBackground(Runnable paramRunnable)
  {
    Iterator localIterator = EXECUTOR.getQueue().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Runnable)localIterator.next();
      if (localObject != null) {
        try
        {
          localObject = sField_FutureTask_callable.get(localObject);
          if (localObject != null)
          {
            localObject = sField_RunnableAdapter_task.get(localObject);
            if (paramRunnable == localObject) {
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          QMLog.log(5, "Threads", "hasCallbackInBackground failed", localException);
        }
      }
    }
    return false;
  }
  
  public static boolean hasCallbackOnMainThread(@NonNull Runnable paramRunnable)
  {
    try
    {
      boolean bool = ((Boolean)sMethod_Handler_hasCallbacks.invoke(MAIN_HANDLER, new Object[] { paramRunnable })).booleanValue();
      return bool;
    }
    catch (Exception paramRunnable)
    {
      QMLog.log(5, "Threads", "invoke hasCallbacks failed", paramRunnable);
    }
    return false;
  }
  
  public static boolean isOnMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static void removeCallbackInBackground(Runnable paramRunnable)
  {
    Iterator localIterator = EXECUTOR.getQueue().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject != null) {
        try
        {
          localObject = sField_FutureTask_callable.get(localObject);
          if ((localObject != null) && (paramRunnable == sField_RunnableAdapter_task.get(localObject))) {
            localIterator.remove();
          }
        }
        catch (Exception localException)
        {
          QMLog.log(5, "Threads", "removeCallbackInBackground failed", localException);
        }
      }
    }
  }
  
  public static void removeCallbackOnMain(@NonNull Runnable paramRunnable)
  {
    MAIN_HANDLER.removeCallbacks(paramRunnable);
  }
  
  public static void replaceCallbackInBackground(Runnable paramRunnable, long paramLong)
  {
    try
    {
      removeCallbackInBackground(paramRunnable);
      runInBackground(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public static void replaceCallbackOnMainThread(@NonNull Runnable paramRunnable, long paramLong)
  {
    try
    {
      removeCallbackOnMain(paramRunnable);
      runOnMainThread(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public static void runInBackground(@NonNull Runnable paramRunnable)
  {
    EXECUTOR.execute(paramRunnable);
  }
  
  public static void runInBackground(@NonNull Runnable paramRunnable, long paramLong)
  {
    EXECUTOR.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static void runInBackgroundIfNotExist(Runnable paramRunnable, long paramLong)
  {
    if (!hasCallbackInBackground(paramRunnable)) {
      try
      {
        if (!hasCallbackInBackground(paramRunnable)) {
          runInBackground(paramRunnable, paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runInBackgroundRepeatly(Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    EXECUTOR.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
  }
  
  public static void runOnMainThread(@NonNull Runnable paramRunnable)
  {
    runOnMainThread(paramRunnable, 0L);
  }
  
  public static void runOnMainThread(@NonNull Runnable paramRunnable, long paramLong)
  {
    if ((paramLong <= 0L) && (isOnMainThread()))
    {
      paramRunnable.run();
      return;
    }
    MAIN_HANDLER.postDelayed(paramRunnable, paramLong);
  }
  
  public static void runOnMainThreadIfNotExist(@NonNull Runnable paramRunnable, long paramLong)
  {
    if (!hasCallbackOnMainThread(paramRunnable)) {
      try
      {
        if (!hasCallbackOnMainThread(paramRunnable)) {
          runOnMainThread(paramRunnable, paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnNotMainThread(Runnable paramRunnable)
  {
    if (!isOnMainThread())
    {
      paramRunnable.run();
      return;
    }
    runInBackground(paramRunnable);
  }
  
  public static <T> Future<T> submitTask(Callable<T> paramCallable)
  {
    return jobsForUI.submit(paramCallable);
  }
  
  public static void waitNoException(Object paramObject)
  {
    try
    {
      paramObject.wait();
      return;
    }
    catch (Exception paramObject) {}
  }
  
  public static void waitNoException(Object paramObject, long paramLong)
  {
    try
    {
      paramObject.wait(paramLong);
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.thread.Threads
 * JD-Core Version:    0.7.0.1
 */