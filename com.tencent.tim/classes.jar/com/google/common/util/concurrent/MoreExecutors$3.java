package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

final class MoreExecutors$3
  extends WrappingExecutorService
{
  MoreExecutors$3(ExecutorService paramExecutorService, Supplier paramSupplier)
  {
    super(paramExecutorService);
  }
  
  protected Runnable wrapTask(Runnable paramRunnable)
  {
    return Callables.threadRenaming(paramRunnable, this.val$nameSupplier);
  }
  
  protected <T> Callable<T> wrapTask(Callable<T> paramCallable)
  {
    return Callables.threadRenaming(paramCallable, this.val$nameSupplier);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.3
 * JD-Core Version:    0.7.0.1
 */