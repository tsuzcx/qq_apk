package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class CallableBackgroundInitializer<T>
  extends BackgroundInitializer<T>
{
  private final Callable<T> callable;
  
  public CallableBackgroundInitializer(Callable<T> paramCallable)
  {
    checkCallable(paramCallable);
    this.callable = paramCallable;
  }
  
  public CallableBackgroundInitializer(Callable<T> paramCallable, ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
    checkCallable(paramCallable);
    this.callable = paramCallable;
  }
  
  private void checkCallable(Callable<T> paramCallable)
  {
    if (paramCallable == null) {
      throw new IllegalArgumentException("Callable must not be null!");
    }
  }
  
  protected T initialize()
    throws Exception
  {
    return this.callable.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.CallableBackgroundInitializer
 * JD-Core Version:    0.7.0.1
 */