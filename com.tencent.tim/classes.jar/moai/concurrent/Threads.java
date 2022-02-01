package moai.concurrent;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import moai.log.MLog;
import moai.log.MLogManager;

public final class Threads
{
  private static final int CORE_CONCURRENT = 3;
  private static final long KEEP_ALIVE_TIME = 30L;
  private static final int MAX_CONCURRENT = 64;
  private static final boolean SWITCH = false;
  protected static final String TAG;
  private static final int WAIT_COUNT = 256;
  private static ExecutorService jobsForUI;
  private static final MLog logger = MLogManager.getLogger("moailog");
  private static Handler mainHandler;
  private static Thread mainThread;
  private static ConcurrentHashMap<Runnable, List<Runnable>> mapToMainHandler;
  private static ConcurrentHashMap<Runnable, ScheduledFuture<?>> mapToMainHandlerSchedule;
  private static Handler sSingleHandler;
  private static ThreadPoolExecutor threadPoolExecutor;
  private static ScheduledThreadPoolExecutor threadPoolExecutorSchedule;
  
  static
  {
    TAG = Threads.class.getSimpleName();
    jobsForUI = Executors.newFixedThreadPool(3, new MThreadFactory("MJobsForUI", 4));
    mapToMainHandler = new ConcurrentHashMap();
    threadPoolExecutor = createThreadPool();
    initSingleHandler();
    Looper localLooper = Looper.getMainLooper();
    mainThread = localLooper.getThread();
    mainHandler = new Handler(localLooper);
  }
  
  public static <T> void cancelTask(Future<T> paramFuture)
  {
    if (paramFuture != null) {
      paramFuture.cancel(true);
    }
  }
  
  private static ScheduledThreadPoolExecutor createScheduleThreadPool()
  {
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3, new MThreadFactory("MPool", 3), new LogAndAbortPolicy(null));
    localScheduledThreadPoolExecutor.setMaximumPoolSize(64);
    localScheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
    return localScheduledThreadPoolExecutor;
  }
  
  private static ThreadPoolExecutor createThreadPool()
  {
    return new ThreadPoolExecutor(3, 64, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new MThreadFactory("MPool", 3), new LogAndAbortPolicy(null));
  }
  
  public static <T> T getFromTask(Future<T> paramFuture, String paramString1, String paramString2)
  {
    MLog localMLog;
    StringBuilder localStringBuilder;
    try
    {
      paramFuture = paramFuture.get();
      return paramFuture;
    }
    catch (Exception localException)
    {
      localMLog = logger;
      localStringBuilder = new StringBuilder();
      if (paramString2 == null) {}
    }
    for (paramFuture = paramString2 + ": ";; paramFuture = "")
    {
      localMLog.e(paramString1, paramFuture + localException.toString());
      return null;
    }
  }
  
  private static int getThreadPoolIdleCount()
  {
    return threadPoolExecutor.getMaximumPoolSize() - threadPoolExecutor.getActiveCount();
  }
  
  private static boolean hasCallback(Handler paramHandler, Runnable paramRunnable)
  {
    try
    {
      boolean bool = ((Boolean)Handler.class.getMethod("hasCallbacks", new Class[] { Runnable.class }).invoke(paramHandler, new Object[] { paramRunnable })).booleanValue();
      return bool;
    }
    catch (Exception paramHandler) {}
    return false;
  }
  
  public static boolean hasCallbackInBackground(Runnable paramRunnable)
  {
    return (mapToMainHandler.contains(paramRunnable)) || (hasCallback(sSingleHandler, paramRunnable));
  }
  
  public static boolean hasCallbackOnMainThread(Runnable paramRunnable)
  {
    return hasCallback(mainHandler, paramRunnable);
  }
  
  private static void initSingleHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("moai-single-thread", 10);
    localHandlerThread.start();
    localHandlerThread.setUncaughtExceptionHandler(new Threads.1());
    sSingleHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static boolean isOnMainThread()
  {
    return mainThread == Thread.currentThread();
  }
  
  public static StringBuilder logAllThreadStackTrace()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Map localMap = Thread.getAllStackTraces();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Thread)localIterator.next();
      localStringBuilder.append("Thread ").append(((Thread)localObject).getName()).append("\n");
      localObject = (StackTraceElement[])localMap.get(localObject);
      int i = 0;
      while (i < localObject.length)
      {
        localStringBuilder.append("\tat ").append(localObject[i]).append("\n");
        i += 1;
      }
    }
    return localStringBuilder;
  }
  
  public static void removeCallbackInBackground(Runnable paramRunnable)
  {
    List localList = (List)mapToMainHandler.remove(paramRunnable);
    if ((localList != null) && (localList.size() > 0)) {
      try
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Runnable localRunnable = (Runnable)localIterator.next();
          mainHandler.removeCallbacks(localRunnable);
        }
      }
      finally {}
    }
    sSingleHandler.removeCallbacks(paramRunnable);
  }
  
  public static void removeCallbackOnMain(Runnable paramRunnable)
  {
    mainHandler.removeCallbacks(paramRunnable);
  }
  
  public static void replaceCallbackInBackground(Runnable paramRunnable)
  {
    replaceCallbackInBackground(paramRunnable, 0L);
  }
  
  public static void replaceCallbackInBackground(Runnable paramRunnable, long paramLong)
  {
    try
    {
      removeCallbackInBackground(paramRunnable);
      sSingleHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public static void replaceCallbackOnMainThread(Runnable paramRunnable)
  {
    replaceCallbackOnMainThread(paramRunnable, 0L);
  }
  
  public static void replaceCallbackOnMainThread(Runnable paramRunnable, long paramLong)
  {
    try
    {
      removeCallbackOnMain(paramRunnable);
      runOnMainThread(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public static void runInBackground(Runnable paramRunnable)
  {
    threadPoolExecutor.execute(paramRunnable);
  }
  
  /* Error */
  public static void runInBackground(Runnable paramRunnable, long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifgt +8 -> 11
    //   6: aload_0
    //   7: invokestatic 346	moai/concurrent/Threads:runInBackground	(Ljava/lang/Runnable;)V
    //   10: return
    //   11: new 348	moai/concurrent/Threads$3
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 350	moai/concurrent/Threads$3:<init>	(Ljava/lang/Runnable;)V
    //   19: astore 5
    //   21: getstatic 83	moai/concurrent/Threads:mapToMainHandler	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_0
    //   25: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 314	java/util/List
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: ifnonnull +32 -> 70
    //   41: aload_0
    //   42: monitorenter
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: ifnonnull +20 -> 68
    //   51: new 353	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 354	java/util/ArrayList:<init>	()V
    //   58: astore_3
    //   59: getstatic 83	moai/concurrent/Threads:mapToMainHandler	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: aload_0
    //   63: aload_3
    //   64: invokevirtual 358	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_3
    //   71: monitorenter
    //   72: aload_3
    //   73: aload 5
    //   75: invokeinterface 361 2 0
    //   80: pop
    //   81: aload_3
    //   82: monitorexit
    //   83: getstatic 111	moai/concurrent/Threads:mainHandler	Landroid/os/Handler;
    //   86: aload 5
    //   88: lload_1
    //   89: invokevirtual 332	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   92: pop
    //   93: return
    //   94: astore_3
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_3
    //   98: athrow
    //   99: astore_0
    //   100: aload_3
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramRunnable	Runnable
    //   0	104	1	paramLong	long
    //   35	47	3	localObject1	Object
    //   94	7	3	localObject2	Object
    //   31	16	4	localList	List
    //   19	68	5	local3	Threads.3
    // Exception table:
    //   from	to	target	type
    //   51	68	94	finally
    //   68	70	94	finally
    //   95	97	94	finally
    //   72	83	99	finally
    //   100	102	99	finally
  }
  
  public static void runInBackgroundIfNotExist(Runnable paramRunnable)
  {
    runInBackgroundIfNotExist(paramRunnable, 0L);
  }
  
  public static void runInBackgroundIfNotExist(Runnable paramRunnable, long paramLong)
  {
    if (!hasCallbackInBackground(paramRunnable)) {
      try
      {
        if (!hasCallbackInBackground(paramRunnable)) {
          sSingleHandler.postDelayed(paramRunnable, paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnMainThread(Runnable paramRunnable)
  {
    if (isOnMainThread())
    {
      paramRunnable.run();
      return;
    }
    mainHandler.post(paramRunnable);
  }
  
  public static void runOnMainThread(Runnable paramRunnable, long paramLong)
  {
    if (paramLong <= 0L)
    {
      runOnMainThread(paramRunnable);
      return;
    }
    mainHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void runOnMainThreadIfNotExist(Runnable paramRunnable)
  {
    runOnMainThread(paramRunnable, 0L);
  }
  
  public static void runOnMainThreadIfNotExist(Runnable paramRunnable, long paramLong)
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
  
  public static void setFutureTaskExecutor(ExecutorService paramExecutorService)
  {
    if ((paramExecutorService != null) && (paramExecutorService != jobsForUI))
    {
      jobsForUI.shutdown();
      jobsForUI = paramExecutorService;
    }
  }
  
  public static void setThreadPoolExecutor(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    if ((paramThreadPoolExecutor != null) && (paramThreadPoolExecutor != threadPoolExecutor))
    {
      threadPoolExecutor.shutdown();
      threadPoolExecutor = paramThreadPoolExecutor;
    }
  }
  
  public static void startConsumer(Runnable paramRunnable, String paramString)
  {
    runInBackground(new Threads.2(paramString, paramRunnable));
  }
  
  public static final void startLongRunJob(String paramString1, String paramString2, Runnable paramRunnable)
  {
    new MThreadFactory(paramString1, 3).newThread(paramRunnable, "" + paramString2).start();
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
    catch (InterruptedException paramObject) {}catch (Exception paramObject) {}
  }
  
  public static void waitNoException(Object paramObject, long paramLong)
  {
    try
    {
      paramObject.wait(paramLong);
      return;
    }
    catch (InterruptedException paramObject) {}catch (Exception paramObject) {}
  }
  
  static class LogAndAbortPolicy
    extends ThreadPoolExecutor.AbortPolicy
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      Threads.logger.e(Threads.TAG, "rejectedExecution: " + paramRunnable);
      paramRunnable = Threads.logAllThreadStackTrace().toString();
      Threads.logger.e(Threads.TAG, paramRunnable);
      Threads.threadPoolExecutor.shutdownNow();
      Threads.access$302(Threads.access$400());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.Threads
 * JD-Core Version:    0.7.0.1
 */