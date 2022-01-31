package com.qzone.utils.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

abstract class PoolEntryFuture<T>
  implements Future<T>
{
  private final FutureCallback<T> callback;
  private volatile boolean cancelled;
  private volatile boolean completed;
  private final Condition condition;
  private final Lock lock;
  private T result;
  
  PoolEntryFuture(Lock paramLock, FutureCallback<T> paramFutureCallback)
  {
    this.lock = paramLock;
    this.condition = paramLock.newCondition();
    this.callback = paramFutureCallback;
  }
  
  public boolean await(Date paramDate)
    throws InterruptedException
  {
    this.lock.lock();
    try
    {
      if (this.cancelled) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      this.lock.unlock();
    }
    if (paramDate != null) {}
    for (boolean bool = this.condition.awaitUntil(paramDate); this.cancelled; bool = true)
    {
      throw new InterruptedException("Operation interrupted");
      this.condition.await();
    }
    this.lock.unlock();
    return bool;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.lock.lock();
    try
    {
      paramBoolean = this.completed;
      if (paramBoolean) {
        return false;
      }
      this.completed = true;
      this.cancelled = true;
      if (this.callback != null) {
        this.callback.cancelled();
      }
      this.condition.signalAll();
      return true;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = get(0L, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new ExecutionException(localTimeoutException);
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    this.lock.lock();
    try
    {
      if (this.completed)
      {
        paramTimeUnit = this.result;
        return paramTimeUnit;
      }
      this.result = getPoolEntry(paramLong, paramTimeUnit);
      this.completed = true;
      if (this.callback != null) {
        this.callback.completed(this.result);
      }
      paramTimeUnit = this.result;
      return paramTimeUnit;
    }
    catch (IOException paramTimeUnit)
    {
      this.completed = true;
      this.result = null;
      if (this.callback != null) {
        this.callback.failed(paramTimeUnit);
      }
      throw new ExecutionException(paramTimeUnit);
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected abstract T getPoolEntry(long paramLong, TimeUnit paramTimeUnit)
    throws IOException, InterruptedException, TimeoutException;
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public boolean isDone()
  {
    return this.completed;
  }
  
  public void wakeup()
  {
    this.lock.lock();
    try
    {
      this.condition.signalAll();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.pool.PoolEntryFuture
 * JD-Core Version:    0.7.0.1
 */