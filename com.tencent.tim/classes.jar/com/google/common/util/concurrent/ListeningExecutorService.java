package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract interface ListeningExecutorService
  extends ExecutorService
{
  public abstract <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException;
  
  public abstract <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract ListenableFuture<?> submit(Runnable paramRunnable);
  
  public abstract <T> ListenableFuture<T> submit(Runnable paramRunnable, T paramT);
  
  public abstract <T> ListenableFuture<T> submit(Callable<T> paramCallable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ListeningExecutorService
 * JD-Core Version:    0.7.0.1
 */