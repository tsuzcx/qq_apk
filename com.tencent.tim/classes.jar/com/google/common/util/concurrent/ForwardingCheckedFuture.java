package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class ForwardingCheckedFuture<V, X extends Exception>
  extends ForwardingListenableFuture<V>
  implements CheckedFuture<V, X>
{
  @CanIgnoreReturnValue
  public V checkedGet()
    throws Exception
  {
    return delegate().checkedGet();
  }
  
  @CanIgnoreReturnValue
  public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, Exception
  {
    return delegate().checkedGet(paramLong, paramTimeUnit);
  }
  
  protected abstract CheckedFuture<V, X> delegate();
  
  @Beta
  public static abstract class SimpleForwardingCheckedFuture<V, X extends Exception>
    extends ForwardingCheckedFuture<V, X>
  {
    private final CheckedFuture<V, X> delegate;
    
    protected SimpleForwardingCheckedFuture(CheckedFuture<V, X> paramCheckedFuture)
    {
      this.delegate = ((CheckedFuture)Preconditions.checkNotNull(paramCheckedFuture));
    }
    
    protected final CheckedFuture<V, X> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ForwardingCheckedFuture
 * JD-Core Version:    0.7.0.1
 */