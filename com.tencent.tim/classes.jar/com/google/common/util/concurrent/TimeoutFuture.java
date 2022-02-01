package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@GwtIncompatible
final class TimeoutFuture<V>
  extends AbstractFuture.TrustedFuture<V>
{
  @Nullable
  private ListenableFuture<V> delegateRef;
  @Nullable
  private Future<?> timer;
  
  private TimeoutFuture(ListenableFuture<V> paramListenableFuture)
  {
    this.delegateRef = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
  }
  
  static <V> ListenableFuture<V> create(ListenableFuture<V> paramListenableFuture, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    TimeoutFuture localTimeoutFuture = new TimeoutFuture(paramListenableFuture);
    Fire localFire = new Fire(localTimeoutFuture);
    localTimeoutFuture.timer = paramScheduledExecutorService.schedule(localFire, paramLong, paramTimeUnit);
    paramListenableFuture.addListener(localFire, MoreExecutors.directExecutor());
    return localTimeoutFuture;
  }
  
  protected void afterDone()
  {
    maybePropagateCancellation(this.delegateRef);
    Future localFuture = this.timer;
    if (localFuture != null) {
      localFuture.cancel(false);
    }
    this.delegateRef = null;
    this.timer = null;
  }
  
  static final class Fire<V>
    implements Runnable
  {
    @Nullable
    TimeoutFuture<V> timeoutFutureRef;
    
    Fire(TimeoutFuture<V> paramTimeoutFuture)
    {
      this.timeoutFutureRef = paramTimeoutFuture;
    }
    
    public void run()
    {
      TimeoutFuture localTimeoutFuture = this.timeoutFutureRef;
      if (localTimeoutFuture == null) {}
      ListenableFuture localListenableFuture;
      do
      {
        return;
        localListenableFuture = localTimeoutFuture.delegateRef;
      } while (localListenableFuture == null);
      this.timeoutFutureRef = null;
      if (localListenableFuture.isDone())
      {
        localTimeoutFuture.setFuture(localListenableFuture);
        return;
      }
      try
      {
        localTimeoutFuture.setException(new TimeoutException("Future timed out: " + localListenableFuture));
        return;
      }
      finally
      {
        localListenableFuture.cancel(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.TimeoutFuture
 * JD-Core Version:    0.7.0.1
 */