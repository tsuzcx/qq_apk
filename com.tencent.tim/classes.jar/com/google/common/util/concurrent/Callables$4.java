package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

final class Callables$4
  implements Runnable
{
  Callables$4(Supplier paramSupplier, Runnable paramRunnable) {}
  
  public void run()
  {
    Thread localThread = Thread.currentThread();
    String str = localThread.getName();
    boolean bool = Callables.access$000((String)this.val$nameSupplier.get(), localThread);
    try
    {
      this.val$task.run();
      return;
    }
    finally
    {
      if (bool) {
        Callables.access$000(str, localThread);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Callables.4
 * JD-Core Version:    0.7.0.1
 */