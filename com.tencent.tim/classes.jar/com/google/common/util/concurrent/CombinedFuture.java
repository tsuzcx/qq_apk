package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.Nullable;

@GwtCompatible
final class CombinedFuture<V>
  extends AggregateFuture<Object, V>
{
  CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> paramImmutableCollection, boolean paramBoolean, Executor paramExecutor, AsyncCallable<V> paramAsyncCallable)
  {
    init(new CombinedFutureRunningState(paramImmutableCollection, paramBoolean, new AsyncCallableInterruptibleTask(paramAsyncCallable, paramExecutor)));
  }
  
  CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> paramImmutableCollection, boolean paramBoolean, Executor paramExecutor, Callable<V> paramCallable)
  {
    init(new CombinedFutureRunningState(paramImmutableCollection, paramBoolean, new CallableInterruptibleTask(paramCallable, paramExecutor)));
  }
  
  final class AsyncCallableInterruptibleTask
    extends CombinedFuture<V>.CombinedFutureInterruptibleTask
  {
    private final AsyncCallable<V> callable;
    
    public AsyncCallableInterruptibleTask(Executor paramExecutor)
    {
      super(localExecutor);
      this.callable = ((AsyncCallable)Preconditions.checkNotNull(paramExecutor));
    }
    
    void setValue()
      throws Exception
    {
      CombinedFuture.this.setFuture(this.callable.call());
    }
  }
  
  final class CallableInterruptibleTask
    extends CombinedFuture<V>.CombinedFutureInterruptibleTask
  {
    private final Callable<V> callable;
    
    public CallableInterruptibleTask(Executor paramExecutor)
    {
      super(localExecutor);
      this.callable = ((Callable)Preconditions.checkNotNull(paramExecutor));
    }
    
    void setValue()
      throws Exception
    {
      CombinedFuture.this.set(this.callable.call());
    }
  }
  
  abstract class CombinedFutureInterruptibleTask
    extends InterruptibleTask
  {
    private final Executor listenerExecutor;
    volatile boolean thrownByExecute = true;
    
    public CombinedFutureInterruptibleTask(Executor paramExecutor)
    {
      this.listenerExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    }
    
    final void execute()
    {
      try
      {
        this.listenerExecutor.execute(this);
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        while (!this.thrownByExecute) {}
        CombinedFuture.this.setException(localRejectedExecutionException);
      }
    }
    
    final void runInterruptibly()
    {
      this.thrownByExecute = false;
      if (!CombinedFuture.this.isDone()) {}
      try
      {
        setValue();
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        CombinedFuture.this.setException(localExecutionException.getCause());
        return;
      }
      catch (CancellationException localCancellationException)
      {
        CombinedFuture.this.cancel(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        CombinedFuture.this.setException(localThrowable);
      }
    }
    
    abstract void setValue()
      throws Exception;
    
    final boolean wasInterrupted()
    {
      return CombinedFuture.this.wasInterrupted();
    }
  }
  
  final class CombinedFutureRunningState
    extends AggregateFuture<Object, V>.RunningState
  {
    private CombinedFuture<V>.CombinedFutureInterruptibleTask task;
    
    CombinedFutureRunningState(boolean paramBoolean, CombinedFuture<V>.CombinedFutureInterruptibleTask paramCombinedFuture)
    {
      super(paramBoolean, paramCombinedFuture, false);
      Object localObject;
      this.task = localObject;
    }
    
    void collectOneValue(boolean paramBoolean, int paramInt, @Nullable Object paramObject) {}
    
    void handleAllCompleted()
    {
      CombinedFuture.CombinedFutureInterruptibleTask localCombinedFutureInterruptibleTask = this.task;
      if (localCombinedFutureInterruptibleTask != null)
      {
        localCombinedFutureInterruptibleTask.execute();
        return;
      }
      Preconditions.checkState(CombinedFuture.this.isDone());
    }
    
    void interruptTask()
    {
      CombinedFuture.CombinedFutureInterruptibleTask localCombinedFutureInterruptibleTask = this.task;
      if (localCombinedFutureInterruptibleTask != null) {
        localCombinedFutureInterruptibleTask.interruptTask();
      }
    }
    
    void releaseResourcesAfterFailure()
    {
      super.releaseResourcesAfterFailure();
      this.task = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.CombinedFuture
 * JD-Core Version:    0.7.0.1
 */