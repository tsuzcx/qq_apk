package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class AbstractCheckedFuture<V, X extends Exception>
  extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V>
  implements CheckedFuture<V, X>
{
  protected AbstractCheckedFuture(ListenableFuture<V> paramListenableFuture)
  {
    super(paramListenableFuture);
  }
  
  @CanIgnoreReturnValue
  public V checkedGet()
    throws Exception
  {
    try
    {
      Object localObject = get();
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw mapException(localInterruptedException);
    }
    catch (CancellationException localCancellationException)
    {
      throw mapException(localCancellationException);
    }
    catch (ExecutionException localExecutionException)
    {
      throw mapException(localExecutionException);
    }
  }
  
  @CanIgnoreReturnValue
  public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, Exception
  {
    try
    {
      paramTimeUnit = get(paramLong, paramTimeUnit);
      return paramTimeUnit;
    }
    catch (InterruptedException paramTimeUnit)
    {
      Thread.currentThread().interrupt();
      throw mapException(paramTimeUnit);
    }
    catch (CancellationException paramTimeUnit)
    {
      throw mapException(paramTimeUnit);
    }
    catch (ExecutionException paramTimeUnit)
    {
      throw mapException(paramTimeUnit);
    }
  }
  
  protected abstract X mapException(Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractCheckedFuture
 * JD-Core Version:    0.7.0.1
 */