package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible(emulated=true)
public final class MoreExecutors
{
  @Beta
  @GwtIncompatible
  public static void addDelayedShutdownHook(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
    new Application().addDelayedShutdownHook(paramExecutorService, paramLong, paramTimeUnit);
  }
  
  public static Executor directExecutor()
  {
    return DirectExecutor.INSTANCE;
  }
  
  @Beta
  @GwtIncompatible
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return new Application().getExitingExecutorService(paramThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible
  public static ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Application().getExitingExecutorService(paramThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  @Beta
  @GwtIncompatible
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    return new Application().getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor);
  }
  
  @Beta
  @GwtIncompatible
  public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Application().getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
  }
  
  /* Error */
  @GwtIncompatible
  static <T> T invokeAnyImpl(ListeningExecutorService paramListeningExecutorService, java.util.Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 82	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload 5
    //   7: invokestatic 82	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_1
    //   12: invokeinterface 88 1 0
    //   17: istore 6
    //   19: iload 6
    //   21: ifle +199 -> 220
    //   24: iconst_1
    //   25: istore 8
    //   27: iload 8
    //   29: invokestatic 92	com/google/common/base/Preconditions:checkArgument	(Z)V
    //   32: iload 6
    //   34: invokestatic 98	com/google/common/collect/Lists:newArrayListWithCapacity	(I)Ljava/util/ArrayList;
    //   37: astore 15
    //   39: invokestatic 104	com/google/common/collect/Queues:newLinkedBlockingQueue	()Ljava/util/concurrent/LinkedBlockingQueue;
    //   42: astore 16
    //   44: aload 5
    //   46: lload_3
    //   47: invokevirtual 110	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   50: lstore_3
    //   51: aconst_null
    //   52: astore 5
    //   54: iload_2
    //   55: ifeq +171 -> 226
    //   58: invokestatic 116	java/lang/System:nanoTime	()J
    //   61: lstore 9
    //   63: aload_1
    //   64: invokeinterface 120 1 0
    //   69: astore 17
    //   71: aload 15
    //   73: aload_0
    //   74: aload 17
    //   76: invokeinterface 126 1 0
    //   81: checkcast 128	java/util/concurrent/Callable
    //   84: aload 16
    //   86: invokestatic 132	com/google/common/util/concurrent/MoreExecutors:submitAndAddQueueListener	(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
    //   89: invokeinterface 138 2 0
    //   94: pop
    //   95: iload 6
    //   97: iconst_1
    //   98: isub
    //   99: istore 7
    //   101: iconst_1
    //   102: istore 6
    //   104: aload 5
    //   106: astore_1
    //   107: aload 16
    //   109: invokeinterface 143 1 0
    //   114: checkcast 145	java/util/concurrent/Future
    //   117: astore 5
    //   119: aload 5
    //   121: ifnonnull +266 -> 387
    //   124: iload 7
    //   126: ifle +106 -> 232
    //   129: aload 15
    //   131: aload_0
    //   132: aload 17
    //   134: invokeinterface 126 1 0
    //   139: checkcast 128	java/util/concurrent/Callable
    //   142: aload 16
    //   144: invokestatic 132	com/google/common/util/concurrent/MoreExecutors:submitAndAddQueueListener	(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
    //   147: invokeinterface 138 2 0
    //   152: pop
    //   153: iload 7
    //   155: iconst_1
    //   156: isub
    //   157: istore 7
    //   159: iload 6
    //   161: iconst_1
    //   162: iadd
    //   163: istore 6
    //   165: aload 5
    //   167: ifnull +217 -> 384
    //   170: iload 6
    //   172: iconst_1
    //   173: isub
    //   174: istore 6
    //   176: aload 5
    //   178: invokeinterface 148 1 0
    //   183: astore_1
    //   184: aload 15
    //   186: invokeinterface 149 1 0
    //   191: astore_0
    //   192: aload_0
    //   193: invokeinterface 153 1 0
    //   198: ifeq +184 -> 382
    //   201: aload_0
    //   202: invokeinterface 126 1 0
    //   207: checkcast 145	java/util/concurrent/Future
    //   210: iconst_1
    //   211: invokeinterface 157 2 0
    //   216: pop
    //   217: goto -25 -> 192
    //   220: iconst_0
    //   221: istore 8
    //   223: goto -196 -> 27
    //   226: lconst_0
    //   227: lstore 9
    //   229: goto -166 -> 63
    //   232: iload 6
    //   234: ifne +57 -> 291
    //   237: aload_1
    //   238: astore_0
    //   239: aload_1
    //   240: ifnonnull +12 -> 252
    //   243: new 72	java/util/concurrent/ExecutionException
    //   246: dup
    //   247: aconst_null
    //   248: invokespecial 160	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   251: astore_0
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: aload 15
    //   257: invokeinterface 149 1 0
    //   262: astore_1
    //   263: aload_1
    //   264: invokeinterface 153 1 0
    //   269: ifeq +107 -> 376
    //   272: aload_1
    //   273: invokeinterface 126 1 0
    //   278: checkcast 145	java/util/concurrent/Future
    //   281: iconst_1
    //   282: invokeinterface 157 2 0
    //   287: pop
    //   288: goto -25 -> 263
    //   291: iload_2
    //   292: ifeq +56 -> 348
    //   295: aload 16
    //   297: lload_3
    //   298: getstatic 164	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   301: invokeinterface 167 4 0
    //   306: checkcast 145	java/util/concurrent/Future
    //   309: astore 5
    //   311: aload 5
    //   313: ifnonnull +11 -> 324
    //   316: new 74	java/util/concurrent/TimeoutException
    //   319: dup
    //   320: invokespecial 168	java/util/concurrent/TimeoutException:<init>	()V
    //   323: athrow
    //   324: invokestatic 116	java/lang/System:nanoTime	()J
    //   327: lstore 13
    //   329: lload 13
    //   331: lstore 11
    //   333: lload_3
    //   334: lload 13
    //   336: lload 9
    //   338: lsub
    //   339: lsub
    //   340: lstore_3
    //   341: lload 11
    //   343: lstore 9
    //   345: goto -180 -> 165
    //   348: aload 16
    //   350: invokeinterface 171 1 0
    //   355: checkcast 145	java/util/concurrent/Future
    //   358: astore 5
    //   360: goto -195 -> 165
    //   363: astore_1
    //   364: new 72	java/util/concurrent/ExecutionException
    //   367: dup
    //   368: aload_1
    //   369: invokespecial 160	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   372: astore_1
    //   373: goto -266 -> 107
    //   376: aload_0
    //   377: athrow
    //   378: astore_1
    //   379: goto -6 -> 373
    //   382: aload_1
    //   383: areturn
    //   384: goto -11 -> 373
    //   387: goto -222 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramListeningExecutorService	ListeningExecutorService
    //   0	390	1	paramCollection	java.util.Collection<? extends Callable<T>>
    //   0	390	2	paramBoolean	boolean
    //   0	390	3	paramLong	long
    //   0	390	5	paramTimeUnit	TimeUnit
    //   17	216	6	i	int
    //   99	59	7	j	int
    //   25	197	8	bool	boolean
    //   61	283	9	l1	long
    //   331	11	11	l2	long
    //   327	8	13	l3	long
    //   37	219	15	localArrayList	java.util.ArrayList
    //   42	307	16	localLinkedBlockingQueue	java.util.concurrent.LinkedBlockingQueue
    //   69	64	17	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   58	63	254	finally
    //   63	95	254	finally
    //   107	119	254	finally
    //   129	153	254	finally
    //   176	184	254	finally
    //   243	252	254	finally
    //   252	254	254	finally
    //   295	311	254	finally
    //   316	324	254	finally
    //   324	329	254	finally
    //   348	360	254	finally
    //   364	373	254	finally
    //   176	184	363	java/lang/RuntimeException
    //   176	184	378	java/util/concurrent/ExecutionException
  }
  
  @GwtIncompatible
  private static boolean isAppEngine()
  {
    if (System.getProperty("com.google.appengine.runtime.environment") == null) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]);
        if (localObject != null) {
          return true;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return false;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return false;
  }
  
  @GwtIncompatible
  public static ListeningExecutorService listeningDecorator(ExecutorService paramExecutorService)
  {
    if ((paramExecutorService instanceof ListeningExecutorService)) {
      return (ListeningExecutorService)paramExecutorService;
    }
    if ((paramExecutorService instanceof ScheduledExecutorService)) {
      return new ScheduledListeningDecorator((ScheduledExecutorService)paramExecutorService);
    }
    return new ListeningDecorator(paramExecutorService);
  }
  
  @GwtIncompatible
  public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService instanceof ListeningScheduledExecutorService)) {
      return (ListeningScheduledExecutorService)paramScheduledExecutorService;
    }
    return new ScheduledListeningDecorator(paramScheduledExecutorService);
  }
  
  @GwtIncompatible
  public static ListeningExecutorService newDirectExecutorService()
  {
    return new DirectExecutorService(null);
  }
  
  @GwtIncompatible
  static Thread newThread(String paramString, Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramRunnable);
    paramRunnable = platformThreadFactory().newThread(paramRunnable);
    try
    {
      paramRunnable.setName(paramString);
      return paramRunnable;
    }
    catch (SecurityException paramString) {}
    return paramRunnable;
  }
  
  @Beta
  @GwtIncompatible
  public static ThreadFactory platformThreadFactory()
  {
    if (!isAppEngine()) {
      return Executors.defaultThreadFactory();
    }
    try
    {
      ThreadFactory localThreadFactory = (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
      return localThreadFactory;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localClassNotFoundException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw Throwables.propagate(localInvocationTargetException.getCause());
    }
  }
  
  static Executor rejectionPropagatingExecutor(Executor paramExecutor, AbstractFuture<?> paramAbstractFuture)
  {
    Preconditions.checkNotNull(paramExecutor);
    Preconditions.checkNotNull(paramAbstractFuture);
    if (paramExecutor == directExecutor()) {
      return paramExecutor;
    }
    return new MoreExecutors.5(paramExecutor, paramAbstractFuture);
  }
  
  @GwtIncompatible
  static Executor renamingDecorator(Executor paramExecutor, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramExecutor);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramExecutor;
    }
    return new MoreExecutors.2(paramExecutor, paramSupplier);
  }
  
  @GwtIncompatible
  static ExecutorService renamingDecorator(ExecutorService paramExecutorService, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramExecutorService);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramExecutorService;
    }
    return new MoreExecutors.3(paramExecutorService, paramSupplier);
  }
  
  @GwtIncompatible
  static ScheduledExecutorService renamingDecorator(ScheduledExecutorService paramScheduledExecutorService, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramScheduledExecutorService);
    Preconditions.checkNotNull(paramSupplier);
    if (isAppEngine()) {
      return paramScheduledExecutorService;
    }
    return new MoreExecutors.4(paramScheduledExecutorService, paramSupplier);
  }
  
  @Deprecated
  @GwtIncompatible
  public static ListeningExecutorService sameThreadExecutor()
  {
    return new DirectExecutorService(null);
  }
  
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static boolean shutdownAndAwaitTermination(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong) / 2L;
    paramExecutorService.shutdown();
    try
    {
      if (!paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS))
      {
        paramExecutorService.shutdownNow();
        paramExecutorService.awaitTermination(paramLong, TimeUnit.NANOSECONDS);
      }
      return paramExecutorService.isTerminated();
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
        paramExecutorService.shutdownNow();
      }
    }
  }
  
  @GwtIncompatible
  private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService paramListeningExecutorService, Callable<T> paramCallable, BlockingQueue<Future<T>> paramBlockingQueue)
  {
    paramListeningExecutorService = paramListeningExecutorService.submit(paramCallable);
    paramListeningExecutorService.addListener(new MoreExecutors.1(paramBlockingQueue, paramListeningExecutorService), directExecutor());
    return paramListeningExecutorService;
  }
  
  @GwtIncompatible
  private static void useDaemonThreadFactory(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramThreadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(paramThreadPoolExecutor.getThreadFactory()).build());
  }
  
  @GwtIncompatible
  @VisibleForTesting
  static class Application
  {
    final void addDelayedShutdownHook(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramExecutorService);
      Preconditions.checkNotNull(paramTimeUnit);
      addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + paramExecutorService, new MoreExecutors.Application.1(this, paramExecutorService, paramLong, paramTimeUnit)));
    }
    
    @VisibleForTesting
    void addShutdownHook(Thread paramThread)
    {
      Runtime.getRuntime().addShutdownHook(paramThread);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor)
    {
      return getExitingExecutorService(paramThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(paramThreadPoolExecutor);
      paramThreadPoolExecutor = Executors.unconfigurableExecutorService(paramThreadPoolExecutor);
      addDelayedShutdownHook(paramThreadPoolExecutor, paramLong, paramTimeUnit);
      return paramThreadPoolExecutor;
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
    {
      return getExitingScheduledExecutorService(paramScheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit)
    {
      MoreExecutors.useDaemonThreadFactory(paramScheduledThreadPoolExecutor);
      paramScheduledThreadPoolExecutor = Executors.unconfigurableScheduledExecutorService(paramScheduledThreadPoolExecutor);
      addDelayedShutdownHook(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
      return paramScheduledThreadPoolExecutor;
    }
  }
  
  static enum DirectExecutor
    implements Executor
  {
    INSTANCE;
    
    private DirectExecutor() {}
    
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
    
    public String toString()
    {
      return "MoreExecutors.directExecutor()";
    }
  }
  
  @GwtIncompatible
  static final class DirectExecutorService
    extends AbstractListeningExecutorService
  {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private int runningTasks = 0;
    @GuardedBy("lock")
    private boolean shutdown = false;
    
    private void endTask()
    {
      synchronized (this.lock)
      {
        int i = this.runningTasks - 1;
        this.runningTasks = i;
        if (i == 0) {
          this.lock.notifyAll();
        }
        return;
      }
    }
    
    private void startTask()
    {
      synchronized (this.lock)
      {
        if (this.shutdown) {
          throw new RejectedExecutionException("Executor already shutdown");
        }
      }
      this.runningTasks += 1;
    }
    
    public boolean awaitTermination(long paramLong, TimeUnit arg3)
      throws InterruptedException
    {
      long l1;
      long l2;
      for (paramLong = ???.toNanos(paramLong);; paramLong -= l2 - l1)
      {
        synchronized (this.lock)
        {
          if ((this.shutdown) && (this.runningTasks == 0)) {
            return true;
          }
          if (paramLong <= 0L) {
            return false;
          }
        }
        l1 = System.nanoTime();
        TimeUnit.NANOSECONDS.timedWait(this.lock, paramLong);
        l2 = System.nanoTime();
      }
    }
    
    public void execute(Runnable paramRunnable)
    {
      startTask();
      try
      {
        paramRunnable.run();
        return;
      }
      finally
      {
        endTask();
      }
    }
    
    public boolean isShutdown()
    {
      synchronized (this.lock)
      {
        boolean bool = this.shutdown;
        return bool;
      }
    }
    
    public boolean isTerminated()
    {
      for (;;)
      {
        synchronized (this.lock)
        {
          if ((this.shutdown) && (this.runningTasks == 0))
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
    
    public void shutdown()
    {
      synchronized (this.lock)
      {
        this.shutdown = true;
        if (this.runningTasks == 0) {
          this.lock.notifyAll();
        }
        return;
      }
    }
    
    public List<Runnable> shutdownNow()
    {
      shutdown();
      return Collections.emptyList();
    }
  }
  
  @GwtIncompatible
  static class ListeningDecorator
    extends AbstractListeningExecutorService
  {
    private final ExecutorService delegate;
    
    ListeningDecorator(ExecutorService paramExecutorService)
    {
      this.delegate = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    }
    
    public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return this.delegate.awaitTermination(paramLong, paramTimeUnit);
    }
    
    public final void execute(Runnable paramRunnable)
    {
      this.delegate.execute(paramRunnable);
    }
    
    public final boolean isShutdown()
    {
      return this.delegate.isShutdown();
    }
    
    public final boolean isTerminated()
    {
      return this.delegate.isTerminated();
    }
    
    public final void shutdown()
    {
      this.delegate.shutdown();
    }
    
    public final List<Runnable> shutdownNow()
    {
      return this.delegate.shutdownNow();
    }
  }
  
  @GwtIncompatible
  static final class ScheduledListeningDecorator
    extends MoreExecutors.ListeningDecorator
    implements ListeningScheduledExecutorService
  {
    final ScheduledExecutorService delegate;
    
    ScheduledListeningDecorator(ScheduledExecutorService paramScheduledExecutorService)
    {
      super();
      this.delegate = ((ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService));
    }
    
    public ListenableScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramRunnable = TrustedListenableFutureTask.create(paramRunnable, null);
      return new ListenableScheduledTask(paramRunnable, this.delegate.schedule(paramRunnable, paramLong, paramTimeUnit));
    }
    
    public <V> ListenableScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramCallable = TrustedListenableFutureTask.create(paramCallable);
      return new ListenableScheduledTask(paramCallable, this.delegate.schedule(paramCallable, paramLong, paramTimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      paramRunnable = new NeverSuccessfulListenableFutureTask(paramRunnable);
      return new ListenableScheduledTask(paramRunnable, this.delegate.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
    }
    
    public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      paramRunnable = new NeverSuccessfulListenableFutureTask(paramRunnable);
      return new ListenableScheduledTask(paramRunnable, this.delegate.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
    }
    
    static final class ListenableScheduledTask<V>
      extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
      implements ListenableScheduledFuture<V>
    {
      private final ScheduledFuture<?> scheduledDelegate;
      
      public ListenableScheduledTask(ListenableFuture<V> paramListenableFuture, ScheduledFuture<?> paramScheduledFuture)
      {
        super();
        this.scheduledDelegate = paramScheduledFuture;
      }
      
      public boolean cancel(boolean paramBoolean)
      {
        boolean bool = super.cancel(paramBoolean);
        if (bool) {
          this.scheduledDelegate.cancel(paramBoolean);
        }
        return bool;
      }
      
      public int compareTo(Delayed paramDelayed)
      {
        return this.scheduledDelegate.compareTo(paramDelayed);
      }
      
      public long getDelay(TimeUnit paramTimeUnit)
      {
        return this.scheduledDelegate.getDelay(paramTimeUnit);
      }
    }
    
    @GwtIncompatible
    static final class NeverSuccessfulListenableFutureTask
      extends AbstractFuture<Void>
      implements Runnable
    {
      private final Runnable delegate;
      
      public NeverSuccessfulListenableFutureTask(Runnable paramRunnable)
      {
        this.delegate = ((Runnable)Preconditions.checkNotNull(paramRunnable));
      }
      
      public void run()
      {
        try
        {
          this.delegate.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          setException(localThrowable);
          throw Throwables.propagate(localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors
 * JD-Core Version:    0.7.0.1
 */