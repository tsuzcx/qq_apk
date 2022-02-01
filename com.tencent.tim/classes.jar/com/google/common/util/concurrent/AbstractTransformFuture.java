package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T>
  extends AbstractFuture.TrustedFuture<O>
  implements Runnable
{
  @Nullable
  F function;
  @Nullable
  ListenableFuture<? extends I> inputFuture;
  
  AbstractTransformFuture(ListenableFuture<? extends I> paramListenableFuture, F paramF)
  {
    this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
    this.function = Preconditions.checkNotNull(paramF);
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    paramFunction = new TransformFuture(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(paramFunction, MoreExecutors.directExecutor());
    return paramFunction;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFunction);
    paramFunction = new TransformFuture(paramListenableFuture, paramFunction);
    paramListenableFuture.addListener(paramFunction, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, paramFunction));
    return paramFunction;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
  {
    paramAsyncFunction = new AsyncTransformFuture(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(paramAsyncFunction, MoreExecutors.directExecutor());
    return paramAsyncFunction;
  }
  
  static <I, O> ListenableFuture<O> create(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramExecutor);
    paramAsyncFunction = new AsyncTransformFuture(paramListenableFuture, paramAsyncFunction);
    paramListenableFuture.addListener(paramAsyncFunction, MoreExecutors.rejectionPropagatingExecutor(paramExecutor, paramAsyncFunction));
    return paramAsyncFunction;
  }
  
  protected final void afterDone()
  {
    maybePropagateCancellation(this.inputFuture);
    this.inputFuture = null;
    this.function = null;
  }
  
  @Nullable
  @ForOverride
  abstract T doTransform(F paramF, @Nullable I paramI)
    throws Exception;
  
  public final void run()
  {
    int i = 1;
    Object localObject2 = this.inputFuture;
    Object localObject1 = this.function;
    boolean bool2 = isCancelled();
    boolean bool1;
    if (localObject2 == null)
    {
      bool1 = true;
      if (localObject1 != null) {
        break label45;
      }
    }
    for (;;)
    {
      if ((i | bool1 | bool2) == 0) {
        break label50;
      }
      return;
      bool1 = false;
      break;
      label45:
      i = 0;
    }
    label50:
    this.inputFuture = null;
    this.function = null;
    try
    {
      localObject2 = Futures.getDone((Future)localObject2);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      try
      {
        localObject1 = doTransform(localObject1, localObject2);
        setResult(localObject1);
        return;
      }
      catch (UndeclaredThrowableException localUndeclaredThrowableException)
      {
        setException(localUndeclaredThrowableException.getCause());
        return;
      }
      catch (Throwable localThrowable)
      {
        setException(localThrowable);
      }
      localCancellationException = localCancellationException;
      cancel(false);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      setException(localExecutionException.getCause());
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      setException(localRuntimeException);
      return;
    }
    catch (Error localError)
    {
      setException(localError);
      return;
    }
  }
  
  @ForOverride
  abstract void setResult(@Nullable T paramT);
  
  static final class AsyncTransformFuture<I, O>
    extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>>
  {
    AsyncTransformFuture(ListenableFuture<? extends I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
    {
      super(paramAsyncFunction);
    }
    
    ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> paramAsyncFunction, @Nullable I paramI)
      throws Exception
    {
      paramAsyncFunction = paramAsyncFunction.apply(paramI);
      Preconditions.checkNotNull(paramAsyncFunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      return paramAsyncFunction;
    }
    
    void setResult(ListenableFuture<? extends O> paramListenableFuture)
    {
      setFuture(paramListenableFuture);
    }
  }
  
  static final class TransformFuture<I, O>
    extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O>
  {
    TransformFuture(ListenableFuture<? extends I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
    {
      super(paramFunction);
    }
    
    @Nullable
    O doTransform(Function<? super I, ? extends O> paramFunction, @Nullable I paramI)
    {
      return paramFunction.apply(paramI);
    }
    
    void setResult(@Nullable O paramO)
    {
      set(paramO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractTransformFuture
 * JD-Core Version:    0.7.0.1
 */