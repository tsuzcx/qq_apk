package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import java.util.concurrent.Callable;

class WrappingExecutorService$1
  implements Runnable
{
  WrappingExecutorService$1(WrappingExecutorService paramWrappingExecutorService, Callable paramCallable) {}
  
  public void run()
  {
    try
    {
      this.val$wrapped.call();
      return;
    }
    catch (Exception localException)
    {
      Throwables.throwIfUnchecked(localException);
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.WrappingExecutorService.1
 * JD-Core Version:    0.7.0.1
 */