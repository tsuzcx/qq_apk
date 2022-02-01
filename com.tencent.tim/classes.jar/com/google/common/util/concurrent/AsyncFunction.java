package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface AsyncFunction<I, O>
{
  public abstract ListenableFuture<O> apply(@Nullable I paramI)
    throws Exception;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AsyncFunction
 * JD-Core Version:    0.7.0.1
 */