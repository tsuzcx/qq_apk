package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public abstract interface AsyncCallable<V>
{
  public abstract ListenableFuture<V> call()
    throws Exception;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AsyncCallable
 * JD-Core Version:    0.7.0.1
 */