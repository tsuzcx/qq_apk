package com.tencent.mobileqq.dinifly;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T>
{
  public static Executor EXECUTOR = ;
  private final Set<LottieListener<Throwable>> failureListeners = new LinkedHashSet(1);
  private final Handler handler = new Handler(Looper.getMainLooper());
  @Nullable
  private volatile LottieResult<T> result = null;
  private final Set<LottieListener<T>> successListeners = new LinkedHashSet(1);
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public LottieTask(Callable<LottieResult<T>> paramCallable)
  {
    this(paramCallable, false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  LottieTask(Callable<LottieResult<T>> paramCallable, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        setResult((LottieResult)paramCallable.call());
        return;
      }
      catch (Throwable paramCallable)
      {
        setResult(new LottieResult(paramCallable));
        return;
      }
    }
    EXECUTOR.execute(new LottieFutureTask(paramCallable));
  }
  
  /* Error */
  private void notifyFailureListeners(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 114	java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: getfield 57	com/tencent/mobileqq/dinifly/LottieTask:failureListeners	Ljava/util/Set;
    //   10: invokespecial 117	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokeinterface 123 1 0
    //   20: ifeq +15 -> 35
    //   23: ldc 125
    //   25: ldc 127
    //   27: aload_1
    //   28: invokestatic 133	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_2
    //   36: invokeinterface 137 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 142 1 0
    //   48: ifeq -16 -> 32
    //   51: aload_2
    //   52: invokeinterface 145 1 0
    //   57: checkcast 147	com/tencent/mobileqq/dinifly/LottieListener
    //   60: aload_1
    //   61: invokeinterface 150 2 0
    //   66: goto -24 -> 42
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	LottieTask
    //   0	74	1	paramThrowable	Throwable
    //   13	39	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	69	finally
    //   35	42	69	finally
    //   42	66	69	finally
  }
  
  private void notifyListeners()
  {
    this.handler.post(new LottieTask.1(this));
  }
  
  private void notifySuccessListeners(T paramT)
  {
    try
    {
      Iterator localIterator = new ArrayList(this.successListeners).iterator();
      while (localIterator.hasNext()) {
        ((LottieListener)localIterator.next()).onResult(paramT);
      }
    }
    finally {}
  }
  
  private void setResult(@Nullable LottieResult<T> paramLottieResult)
  {
    if (this.result != null) {
      throw new IllegalStateException("A task may only be set once.");
    }
    this.result = paramLottieResult;
    notifyListeners();
  }
  
  public LottieTask<T> addFailureListener(LottieListener<Throwable> paramLottieListener)
  {
    try
    {
      if ((this.result != null) && (this.result.getException() != null)) {
        paramLottieListener.onResult(this.result.getException());
      }
      this.failureListeners.add(paramLottieListener);
      return this;
    }
    finally {}
  }
  
  public LottieTask<T> addListener(LottieListener<T> paramLottieListener)
  {
    try
    {
      if ((this.result != null) && (this.result.getValue() != null)) {
        paramLottieListener.onResult(this.result.getValue());
      }
      this.successListeners.add(paramLottieListener);
      return this;
    }
    finally {}
  }
  
  public LottieTask<T> removeFailureListener(LottieListener<Throwable> paramLottieListener)
  {
    try
    {
      this.failureListeners.remove(paramLottieListener);
      return this;
    }
    finally
    {
      paramLottieListener = finally;
      throw paramLottieListener;
    }
  }
  
  public LottieTask<T> removeListener(LottieListener<T> paramLottieListener)
  {
    try
    {
      this.successListeners.remove(paramLottieListener);
      return this;
    }
    finally
    {
      paramLottieListener = finally;
      throw paramLottieListener;
    }
  }
  
  class LottieFutureTask
    extends FutureTask<LottieResult<T>>
  {
    LottieFutureTask()
    {
      super();
    }
    
    protected void done()
    {
      if (isCancelled()) {
        return;
      }
      try
      {
        LottieTask.this.setResult((LottieResult)get());
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        LottieTask.this.setResult(new LottieResult(localInterruptedException));
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        label24:
        break label24;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieTask
 * JD-Core Version:    0.7.0.1
 */