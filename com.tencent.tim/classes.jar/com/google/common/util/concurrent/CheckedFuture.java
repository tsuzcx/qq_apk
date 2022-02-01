package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtCompatible
@CanIgnoreReturnValue
public abstract interface CheckedFuture<V, X extends Exception>
  extends ListenableFuture<V>
{
  public abstract V checkedGet()
    throws Exception;
  
  public abstract V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, Exception;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.CheckedFuture
 * JD-Core Version:    0.7.0.1
 */