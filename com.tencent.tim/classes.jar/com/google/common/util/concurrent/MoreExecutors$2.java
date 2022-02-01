package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;

final class MoreExecutors$2
  implements Executor
{
  MoreExecutors$2(Executor paramExecutor, Supplier paramSupplier) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.val$executor.execute(Callables.threadRenaming(paramRunnable, this.val$nameSupplier));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.2
 * JD-Core Version:    0.7.0.1
 */