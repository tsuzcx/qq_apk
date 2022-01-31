package com.tencent.component.network.utils.a.b;

import com.tencent.component.network.downloader.handler.a;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

abstract class f<T>
  implements Future<T>
{
  private final Lock a;
  private final a<T> b;
  private final Condition c;
  private volatile boolean d;
  private volatile boolean e;
  private T f;
  
  f(Lock paramLock, a<T> parama)
  {
    this.a = paramLock;
    this.c = paramLock.newCondition();
    this.b = null;
  }
  
  protected abstract T a(long paramLong, TimeUnit paramTimeUnit)
    throws IOException, InterruptedException, TimeoutException;
  
  public final void a()
  {
    this.a.lock();
    try
    {
      this.c.signalAll();
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public final boolean a(Date paramDate)
    throws InterruptedException
  {
    this.a.lock();
    try
    {
      if (this.d) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      this.a.unlock();
    }
    if (paramDate != null) {}
    for (boolean bool = this.c.awaitUntil(paramDate); this.d; bool = true)
    {
      throw new InterruptedException("Operation interrupted");
      this.c.await();
    }
    this.a.unlock();
    return bool;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.a.lock();
    try
    {
      paramBoolean = this.e;
      if (paramBoolean) {
        return false;
      }
      this.e = true;
      this.d = true;
      if (this.b != null) {
        a locala = this.b;
      }
      this.c.signalAll();
      return true;
    }
    finally
    {
      this.a.unlock();
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
    this.a.lock();
    try
    {
      if (this.e)
      {
        paramTimeUnit = this.f;
        return paramTimeUnit;
      }
      this.f = a(paramLong, paramTimeUnit);
      this.e = true;
      if (this.b != null)
      {
        paramTimeUnit = this.b;
        paramTimeUnit = this.f;
      }
      paramTimeUnit = this.f;
      return paramTimeUnit;
    }
    catch (IOException paramTimeUnit)
    {
      this.e = true;
      this.f = null;
      if (this.b != null) {
        a locala = this.b;
      }
      throw new ExecutionException(paramTimeUnit);
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public boolean isCancelled()
  {
    return this.d;
  }
  
  public boolean isDone()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.f
 * JD-Core Version:    0.7.0.1
 */