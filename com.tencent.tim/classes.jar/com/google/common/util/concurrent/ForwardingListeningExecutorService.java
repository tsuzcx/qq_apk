package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingListeningExecutorService
  extends ForwardingExecutorService
  implements ListeningExecutorService
{
  protected abstract ListeningExecutorService delegate();
  
  public ListenableFuture<?> submit(Runnable paramRunnable)
  {
    return delegate().submit(paramRunnable);
  }
  
  public <T> ListenableFuture<T> submit(Runnable paramRunnable, T paramT)
  {
    return delegate().submit(paramRunnable, paramT);
  }
  
  public <T> ListenableFuture<T> submit(Callable<T> paramCallable)
  {
    return delegate().submit(paramCallable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ForwardingListeningExecutorService
 * JD-Core Version:    0.7.0.1
 */