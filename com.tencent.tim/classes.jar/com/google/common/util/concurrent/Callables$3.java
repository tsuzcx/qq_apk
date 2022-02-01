package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

final class Callables$3
  implements Callable<T>
{
  Callables$3(Supplier paramSupplier, Callable paramCallable) {}
  
  public T call()
    throws Exception
  {
    Thread localThread = Thread.currentThread();
    String str = localThread.getName();
    boolean bool = Callables.access$000((String)this.val$nameSupplier.get(), localThread);
    try
    {
      Object localObject1 = this.val$callable.call();
      return localObject1;
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
 * Qualified Name:     com.google.common.util.concurrent.Callables.3
 * JD-Core Version:    0.7.0.1
 */