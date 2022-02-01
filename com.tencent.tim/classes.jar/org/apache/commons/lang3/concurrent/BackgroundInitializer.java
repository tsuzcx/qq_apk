package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class BackgroundInitializer<T>
  implements ConcurrentInitializer<T>
{
  private ExecutorService executor;
  private ExecutorService externalExecutor;
  private Future<T> future;
  
  protected BackgroundInitializer()
  {
    this(null);
  }
  
  protected BackgroundInitializer(ExecutorService paramExecutorService)
  {
    setExternalExecutor(paramExecutorService);
  }
  
  private ExecutorService createExecutor()
  {
    return Executors.newFixedThreadPool(getTaskCount());
  }
  
  private Callable<T> createTask(ExecutorService paramExecutorService)
  {
    return new InitializationTask(paramExecutorService);
  }
  
  public T get()
    throws ConcurrentException
  {
    try
    {
      Object localObject = getFuture().get();
      return localObject;
    }
    catch (ExecutionException localExecutionException)
    {
      ConcurrentUtils.handleCause(localExecutionException);
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new ConcurrentException(localInterruptedException);
    }
  }
  
  protected final ExecutorService getActiveExecutor()
  {
    try
    {
      ExecutorService localExecutorService = this.executor;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ExecutorService getExternalExecutor()
  {
    try
    {
      ExecutorService localExecutorService = this.externalExecutor;
      return localExecutorService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Future<T> getFuture()
  {
    try
    {
      if (this.future == null) {
        throw new IllegalStateException("start() must be called first!");
      }
    }
    finally {}
    Future localFuture = this.future;
    return localFuture;
  }
  
  protected int getTaskCount()
  {
    return 1;
  }
  
  protected abstract T initialize()
    throws Exception;
  
  /* Error */
  public boolean isStarted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	org/apache/commons/lang3/concurrent/BackgroundInitializer:future	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	BackgroundInitializer
    //   12	7	1	bool	boolean
    //   6	2	2	localFuture	Future
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final void setExternalExecutor(ExecutorService paramExecutorService)
  {
    try
    {
      if (isStarted()) {
        throw new IllegalStateException("Cannot set ExecutorService after start()!");
      }
    }
    finally {}
    this.externalExecutor = paramExecutorService;
  }
  
  /* Error */
  public boolean start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 105	org/apache/commons/lang3/concurrent/BackgroundInitializer:isStarted	()Z
    //   6: ifne +57 -> 63
    //   9: aload_0
    //   10: aload_0
    //   11: invokevirtual 110	org/apache/commons/lang3/concurrent/BackgroundInitializer:getExternalExecutor	()Ljava/util/concurrent/ExecutorService;
    //   14: putfield 85	org/apache/commons/lang3/concurrent/BackgroundInitializer:executor	Ljava/util/concurrent/ExecutorService;
    //   17: aload_0
    //   18: getfield 85	org/apache/commons/lang3/concurrent/BackgroundInitializer:executor	Ljava/util/concurrent/ExecutorService;
    //   21: ifnonnull +37 -> 58
    //   24: aload_0
    //   25: invokespecial 112	org/apache/commons/lang3/concurrent/BackgroundInitializer:createExecutor	()Ljava/util/concurrent/ExecutorService;
    //   28: astore_2
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 85	org/apache/commons/lang3/concurrent/BackgroundInitializer:executor	Ljava/util/concurrent/ExecutorService;
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 85	org/apache/commons/lang3/concurrent/BackgroundInitializer:executor	Ljava/util/concurrent/ExecutorService;
    //   39: aload_0
    //   40: aload_2
    //   41: invokespecial 114	org/apache/commons/lang3/concurrent/BackgroundInitializer:createTask	(Ljava/util/concurrent/ExecutorService;)Ljava/util/concurrent/Callable;
    //   44: invokeinterface 120 2 0
    //   49: putfield 90	org/apache/commons/lang3/concurrent/BackgroundInitializer:future	Ljava/util/concurrent/Future;
    //   52: iconst_1
    //   53: istore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_1
    //   57: ireturn
    //   58: aconst_null
    //   59: astore_2
    //   60: goto -26 -> 34
    //   63: iconst_0
    //   64: istore_1
    //   65: goto -11 -> 54
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	BackgroundInitializer
    //   53	12	1	bool	boolean
    //   28	32	2	localExecutorService	ExecutorService
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	68	finally
    //   34	52	68	finally
  }
  
  class InitializationTask
    implements Callable<T>
  {
    private final ExecutorService execFinally;
    
    public InitializationTask(ExecutorService paramExecutorService)
    {
      this.execFinally = paramExecutorService;
    }
    
    public T call()
      throws Exception
    {
      try
      {
        Object localObject1 = BackgroundInitializer.this.initialize();
        return localObject1;
      }
      finally
      {
        if (this.execFinally != null) {
          this.execFinally.shutdown();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.BackgroundInitializer
 * JD-Core Version:    0.7.0.1
 */