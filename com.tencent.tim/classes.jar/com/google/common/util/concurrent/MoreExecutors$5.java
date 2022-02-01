package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class MoreExecutors$5
  implements Executor
{
  volatile boolean thrownFromDelegate = true;
  
  MoreExecutors$5(Executor paramExecutor, AbstractFuture paramAbstractFuture) {}
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.val$delegate.execute(new MoreExecutors.5.1(this, paramRunnable));
      return;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      while (!this.thrownFromDelegate) {}
      this.val$future.setException(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.5
 * JD-Core Version:    0.7.0.1
 */