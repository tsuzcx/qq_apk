package com.tencent.hydevteam.common.progress;

import com.tencent.hydevteam.common.annotation.API;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@API
public class ProgressFutureImpl<T>
  implements ProgressFuture<T>
{
  private Future<T> a;
  private Progress b;
  
  public ProgressFutureImpl(Future<T> paramFuture, Progress paramProgress)
  {
    this.a = paramFuture;
    this.b = paramProgress;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.a.cancel(paramBoolean);
  }
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    return this.a.get();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.a.get(paramLong, paramTimeUnit);
  }
  
  public double getProgress()
  {
    if (this.b == null) {
      return 0.0D;
    }
    return this.b.getProgress();
  }
  
  public boolean isCancelled()
  {
    return this.a.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.a.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.common.progress.ProgressFutureImpl
 * JD-Core Version:    0.7.0.1
 */