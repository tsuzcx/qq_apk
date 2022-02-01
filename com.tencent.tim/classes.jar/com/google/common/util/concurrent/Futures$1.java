package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class Futures$1
  implements Future<O>
{
  Futures$1(Future paramFuture, Function paramFunction) {}
  
  private O applyTransformation(I paramI)
    throws ExecutionException
  {
    try
    {
      paramI = this.val$function.apply(paramI);
      return paramI;
    }
    catch (Throwable paramI)
    {
      throw new ExecutionException(paramI);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.val$input.cancel(paramBoolean);
  }
  
  public O get()
    throws InterruptedException, ExecutionException
  {
    return applyTransformation(this.val$input.get());
  }
  
  public O get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return applyTransformation(this.val$input.get(paramLong, paramTimeUnit));
  }
  
  public boolean isCancelled()
  {
    return this.val$input.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.val$input.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.1
 * JD-Core Version:    0.7.0.1
 */