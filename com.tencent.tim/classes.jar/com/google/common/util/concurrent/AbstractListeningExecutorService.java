package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
@CanIgnoreReturnValue
public abstract class AbstractListeningExecutorService
  extends AbstractExecutorService
  implements ListeningExecutorService
{
  protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return TrustedListenableFutureTask.create(paramRunnable, paramT);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return TrustedListenableFutureTask.create(paramCallable);
  }
  
  public ListenableFuture<?> submit(Runnable paramRunnable)
  {
    return (ListenableFuture)super.submit(paramRunnable);
  }
  
  public <T> ListenableFuture<T> submit(Runnable paramRunnable, @Nullable T paramT)
  {
    return (ListenableFuture)super.submit(paramRunnable, paramT);
  }
  
  public <T> ListenableFuture<T> submit(Callable<T> paramCallable)
  {
    return (ListenableFuture)super.submit(paramCallable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractListeningExecutorService
 * JD-Core Version:    0.7.0.1
 */