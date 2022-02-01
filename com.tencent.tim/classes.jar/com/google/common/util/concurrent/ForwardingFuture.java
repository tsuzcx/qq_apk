package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingFuture<V>
  extends ForwardingObject
  implements Future<V>
{
  public boolean cancel(boolean paramBoolean)
  {
    return delegate().cancel(paramBoolean);
  }
  
  protected abstract Future<? extends V> delegate();
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    return delegate().get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return delegate().get(paramLong, paramTimeUnit);
  }
  
  public boolean isCancelled()
  {
    return delegate().isCancelled();
  }
  
  public boolean isDone()
  {
    return delegate().isDone();
  }
  
  public static abstract class SimpleForwardingFuture<V>
    extends ForwardingFuture<V>
  {
    private final Future<V> delegate;
    
    protected SimpleForwardingFuture(Future<V> paramFuture)
    {
      this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
    }
    
    protected final Future<V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ForwardingFuture
 * JD-Core Version:    0.7.0.1
 */