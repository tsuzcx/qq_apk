package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class SettableFuture<V>
  extends AbstractFuture.TrustedFuture<V>
{
  public static <V> SettableFuture<V> create()
  {
    return new SettableFuture();
  }
  
  @CanIgnoreReturnValue
  public boolean set(@Nullable V paramV)
  {
    return super.set(paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean setException(Throwable paramThrowable)
  {
    return super.setException(paramThrowable);
  }
  
  @Beta
  @CanIgnoreReturnValue
  public boolean setFuture(ListenableFuture<? extends V> paramListenableFuture)
  {
    return super.setFuture(paramListenableFuture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.SettableFuture
 * JD-Core Version:    0.7.0.1
 */