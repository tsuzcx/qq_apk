package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T>
  extends AbstractFuture.TrustedFuture<V>
  implements Runnable
{
  @Nullable
  Class<X> exceptionType;
  @Nullable
  F fallback;
  @Nullable
  ListenableFuture<? extends V> inputFuture;
  
  AbstractCatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, F paramF)
  {
    this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
    this.exceptionType = ((Class)Preconditions.checkNotNull(paramClass));
    this.fallback = Preconditions.checkNotNull(paramF);
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction)
  {
    paramClass = new CatchingFuture(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.directExecutor());
    return paramClass;
  }
  
  static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction, Executor paramExecutor)
  {
    paramClass = new CatchingFuture(paramListenableFuture, paramClass, paramFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, paramClass));
    return paramClass;
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction)
  {
    paramClass = new AsyncCatchingFuture(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.directExecutor());
    return paramClass;
  }
  
  static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction, Executor paramExecutor)
  {
    paramClass = new AsyncCatchingFuture(paramListenableFuture, paramClass, paramAsyncFunction);
    paramListenableFuture.addListener(paramClass, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, paramClass));
    return paramClass;
  }
  
  protected final void afterDone()
  {
    maybePropagateCancellation(this.inputFuture);
    this.inputFuture = null;
    this.exceptionType = null;
    this.fallback = null;
  }
  
  @Nullable
  @ForOverride
  abstract T doFallback(F paramF, X paramX)
    throws Exception;
  
  public final void run()
  {
    int k = 1;
    Object localObject3 = null;
    Object localObject1 = this.inputFuture;
    localClass = this.exceptionType;
    localObject4 = this.fallback;
    int i;
    int j;
    if (localObject1 == null)
    {
      i = 1;
      if (localClass != null) {
        break label61;
      }
      j = 1;
      label37:
      if (localObject4 != null) {
        break label66;
      }
    }
    for (;;)
    {
      if ((k | j | i | isCancelled()) == 0) {
        break label71;
      }
      return;
      i = 0;
      break;
      label61:
      j = 0;
      break label37;
      label66:
      k = 0;
    }
    label71:
    this.inputFuture = null;
    this.exceptionType = null;
    this.fallback = null;
    try
    {
      localObject1 = Futures.getDone((Future)localObject1);
      localObject3 = localObject1;
      localObject1 = null;
    }
    catch (ExecutionException localExecutionException)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = (Throwable)Preconditions.checkNotNull(localExecutionException.getCause());
      }
      if (Platform.isInstanceOfThrowableClass((Throwable)localObject2, localClass)) {
        break label149;
      }
      setException((Throwable)localObject2);
      return;
      try
      {
        localObject2 = doFallback(localObject4, (Throwable)localObject2);
        setResult(localObject2);
        return;
      }
      catch (Throwable localThrowable1)
      {
        setException(localThrowable1);
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      label100:
      break label100;
    }
    if (localObject1 == null)
    {
      set(localObject3);
      return;
    }
  }
  
  @ForOverride
  abstract void setResult(@Nullable T paramT);
  
  static final class AsyncCatchingFuture<V, X extends Throwable>
    extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>>
  {
    AsyncCatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction)
    {
      super(paramClass, paramAsyncFunction);
    }
    
    ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> paramAsyncFunction, X paramX)
      throws Exception
    {
      paramAsyncFunction = paramAsyncFunction.apply(paramX);
      Preconditions.checkNotNull(paramAsyncFunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      return paramAsyncFunction;
    }
    
    void setResult(ListenableFuture<? extends V> paramListenableFuture)
    {
      setFuture(paramListenableFuture);
    }
  }
  
  static final class CatchingFuture<V, X extends Throwable>
    extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V>
  {
    CatchingFuture(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction)
    {
      super(paramClass, paramFunction);
    }
    
    @Nullable
    V doFallback(Function<? super X, ? extends V> paramFunction, X paramX)
      throws Exception
    {
      return paramFunction.apply(paramX);
    }
    
    void setResult(@Nullable V paramV)
    {
      set(paramV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractCatchingFuture
 * JD-Core Version:    0.7.0.1
 */