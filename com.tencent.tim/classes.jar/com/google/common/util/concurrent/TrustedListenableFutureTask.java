package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
class TrustedListenableFutureTask<V>
  extends AbstractFuture.TrustedFuture<V>
  implements RunnableFuture<V>
{
  private TrustedListenableFutureTask<V>.TrustedFutureInterruptibleTask task;
  
  TrustedListenableFutureTask(Callable<V> paramCallable)
  {
    this.task = new TrustedFutureInterruptibleTask(paramCallable);
  }
  
  static <V> TrustedListenableFutureTask<V> create(Runnable paramRunnable, @Nullable V paramV)
  {
    return new TrustedListenableFutureTask(Executors.callable(paramRunnable, paramV));
  }
  
  static <V> TrustedListenableFutureTask<V> create(Callable<V> paramCallable)
  {
    return new TrustedListenableFutureTask(paramCallable);
  }
  
  protected void afterDone()
  {
    super.afterDone();
    if (wasInterrupted())
    {
      TrustedFutureInterruptibleTask localTrustedFutureInterruptibleTask = this.task;
      if (localTrustedFutureInterruptibleTask != null) {
        localTrustedFutureInterruptibleTask.interruptTask();
      }
    }
    this.task = null;
  }
  
  public void run()
  {
    TrustedFutureInterruptibleTask localTrustedFutureInterruptibleTask = this.task;
    if (localTrustedFutureInterruptibleTask != null) {
      localTrustedFutureInterruptibleTask.run();
    }
  }
  
  public String toString()
  {
    return super.toString() + " (delegate = " + this.task + ")";
  }
  
  final class TrustedFutureInterruptibleTask
    extends InterruptibleTask
  {
    private final Callable<V> callable;
    
    TrustedFutureInterruptibleTask()
    {
      Object localObject;
      this.callable = ((Callable)Preconditions.checkNotNull(localObject));
    }
    
    void runInterruptibly()
    {
      if (!TrustedListenableFutureTask.this.isDone()) {}
      try
      {
        TrustedListenableFutureTask.this.set(this.callable.call());
        return;
      }
      catch (Throwable localThrowable)
      {
        TrustedListenableFutureTask.this.setException(localThrowable);
      }
    }
    
    public String toString()
    {
      return this.callable.toString();
    }
    
    boolean wasInterrupted()
    {
      return TrustedListenableFutureTask.this.wasInterrupted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.TrustedListenableFutureTask
 * JD-Core Version:    0.7.0.1
 */