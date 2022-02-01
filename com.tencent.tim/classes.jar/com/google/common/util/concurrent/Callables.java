package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Callables
{
  @Beta
  @GwtIncompatible
  public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> paramCallable, ListeningExecutorService paramListeningExecutorService)
  {
    Preconditions.checkNotNull(paramCallable);
    Preconditions.checkNotNull(paramListeningExecutorService);
    return new Callables.2(paramListeningExecutorService, paramCallable);
  }
  
  public static <T> Callable<T> returning(@Nullable T paramT)
  {
    return new Callables.1(paramT);
  }
  
  @GwtIncompatible
  static Runnable threadRenaming(Runnable paramRunnable, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    Preconditions.checkNotNull(paramRunnable);
    return new Callables.4(paramSupplier, paramRunnable);
  }
  
  @GwtIncompatible
  static <T> Callable<T> threadRenaming(Callable<T> paramCallable, Supplier<String> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    Preconditions.checkNotNull(paramCallable);
    return new Callables.3(paramSupplier, paramCallable);
  }
  
  @GwtIncompatible
  private static boolean trySetName(String paramString, Thread paramThread)
  {
    try
    {
      paramThread.setName(paramString);
      return true;
    }
    catch (SecurityException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Callables
 * JD-Core Version:    0.7.0.1
 */