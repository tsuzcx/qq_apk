package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingListenableFuture<V>
  extends ForwardingFuture<V>
  implements ListenableFuture<V>
{
  public void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    delegate().addListener(paramRunnable, paramExecutor);
  }
  
  protected abstract ListenableFuture<? extends V> delegate();
  
  public static abstract class SimpleForwardingListenableFuture<V>
    extends ForwardingListenableFuture<V>
  {
    private final ListenableFuture<V> delegate;
    
    protected SimpleForwardingListenableFuture(ListenableFuture<V> paramListenableFuture)
    {
      this.delegate = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
    }
    
    protected final ListenableFuture<V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ForwardingListenableFuture
 * JD-Core Version:    0.7.0.1
 */