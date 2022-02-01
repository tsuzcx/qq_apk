package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@GwtIncompatible
public final class RemovalListeners
{
  public static <K, V> RemovalListener<K, V> asynchronous(RemovalListener<K, V> paramRemovalListener, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRemovalListener);
    Preconditions.checkNotNull(paramExecutor);
    return new RemovalListeners.1(paramExecutor, paramRemovalListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.RemovalListeners
 * JD-Core Version:    0.7.0.1
 */