package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public final class Futures
  extends GwtFuturesCatchingSpecialization
{
  private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new Futures.2();
  
  public static <V> void addCallback(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback)
  {
    addCallback(paramListenableFuture, paramFutureCallback, MoreExecutors.directExecutor());
  }
  
  public static <V> void addCallback(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFutureCallback);
    paramListenableFuture.addListener(new Futures.4(paramListenableFuture, paramFutureCallback), paramExecutor);
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new CollectionFuture.ListFuture(ImmutableList.copyOf(paramIterable), true);
  }
  
  @SafeVarargs
  @Beta
  public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new CollectionFuture.ListFuture(ImmutableList.copyOf(paramVarArgs), true);
  }
  
  @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction)
  {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramFunction);
  }
  
  @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, Function<? super X, ? extends V> paramFunction, Executor paramExecutor)
  {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramFunction, paramExecutor);
  }
  
  @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  @CanIgnoreReturnValue
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction)
  {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramAsyncFunction);
  }
  
  @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
  @CanIgnoreReturnValue
  public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> paramListenableFuture, Class<X> paramClass, AsyncFunction<? super X, ? extends V> paramAsyncFunction, Executor paramExecutor)
  {
    return AbstractCatchingFuture.create(paramListenableFuture, paramClass, paramAsyncFunction, paramExecutor);
  }
  
  public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> paramListenableFuture)
  {
    return transformAsync(paramListenableFuture, DEREFERENCER);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass)
    throws Exception
  {
    return FuturesGetChecked.getChecked(paramFuture, paramClass);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass, long paramLong, TimeUnit paramTimeUnit)
    throws Exception
  {
    return FuturesGetChecked.getChecked(paramFuture, paramClass, paramLong, paramTimeUnit);
  }
  
  @CanIgnoreReturnValue
  public static <V> V getDone(Future<V> paramFuture)
    throws ExecutionException
  {
    Preconditions.checkState(paramFuture.isDone(), "Future was expected to be done: %s", paramFuture);
    return Uninterruptibles.getUninterruptibly(paramFuture);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <V> V getUnchecked(Future<V> paramFuture)
  {
    Preconditions.checkNotNull(paramFuture);
    try
    {
      paramFuture = Uninterruptibles.getUninterruptibly(paramFuture);
      return paramFuture;
    }
    catch (ExecutionException paramFuture)
    {
      wrapAndThrowUnchecked(paramFuture.getCause());
      throw new AssertionError();
    }
  }
  
  public static <V> ListenableFuture<V> immediateCancelledFuture()
  {
    return new ImmediateFuture.ImmediateCancelledFuture();
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V paramV)
  {
    return new ImmediateFuture.ImmediateSuccessfulCheckedFuture(paramV);
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X paramX)
  {
    Preconditions.checkNotNull(paramX);
    return new ImmediateFuture.ImmediateFailedCheckedFuture(paramX);
  }
  
  public static <V> ListenableFuture<V> immediateFailedFuture(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    return new ImmediateFuture.ImmediateFailedFuture(paramThrowable);
  }
  
  public static <V> ListenableFuture<V> immediateFuture(@Nullable V paramV)
  {
    if (paramV == null) {
      return ImmediateFuture.ImmediateSuccessfulFuture.NULL;
    }
    return new ImmediateFuture.ImmediateSuccessfulFuture(paramV);
  }
  
  @Beta
  @GwtIncompatible
  public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> paramIterable)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
    ImmutableList.Builder localBuilder = ImmutableList.builder();
    SerializingExecutor localSerializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      ListenableFuture localListenableFuture = (ListenableFuture)paramIterable.next();
      SettableFuture localSettableFuture = SettableFuture.create();
      localConcurrentLinkedQueue.add(localSettableFuture);
      localListenableFuture.addListener(new Futures.3(localConcurrentLinkedQueue, localListenableFuture), localSerializingExecutor);
      localBuilder.add(localSettableFuture);
    }
    return localBuilder.build();
  }
  
  @GwtIncompatible
  public static <I, O> Future<O> lazyTransform(Future<I> paramFuture, Function<? super I, ? extends O> paramFunction)
  {
    Preconditions.checkNotNull(paramFuture);
    Preconditions.checkNotNull(paramFunction);
    return new Futures.1(paramFuture, paramFunction);
  }
  
  @GwtIncompatible
  public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> paramListenableFuture, Function<? super Exception, X> paramFunction)
  {
    return new MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture), paramFunction);
  }
  
  public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> paramListenableFuture)
  {
    return new NonCancellationPropagatingFuture(paramListenableFuture);
  }
  
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new CollectionFuture.ListFuture(ImmutableList.copyOf(paramIterable), false);
  }
  
  @SafeVarargs
  @Beta
  public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new CollectionFuture.ListFuture(ImmutableList.copyOf(paramVarArgs), false);
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
  {
    return AbstractTransformFuture.create(paramListenableFuture, paramFunction);
  }
  
  public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor)
  {
    return AbstractTransformFuture.create(paramListenableFuture, paramFunction, paramExecutor);
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction)
  {
    return AbstractTransformFuture.create(paramListenableFuture, paramAsyncFunction);
  }
  
  public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> paramListenableFuture, AsyncFunction<? super I, ? extends O> paramAsyncFunction, Executor paramExecutor)
  {
    return AbstractTransformFuture.create(paramListenableFuture, paramAsyncFunction, paramExecutor);
  }
  
  public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new FutureCombiner(false, ImmutableList.copyOf(paramIterable), null);
  }
  
  @SafeVarargs
  public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new FutureCombiner(false, ImmutableList.copyOf(paramVarArgs), null);
  }
  
  public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new FutureCombiner(true, ImmutableList.copyOf(paramIterable), null);
  }
  
  @SafeVarargs
  public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... paramVarArgs)
  {
    return new FutureCombiner(true, ImmutableList.copyOf(paramVarArgs), null);
  }
  
  @GwtIncompatible
  public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> paramListenableFuture, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    return TimeoutFuture.create(paramListenableFuture, paramLong, paramTimeUnit, paramScheduledExecutorService);
  }
  
  @GwtIncompatible
  private static void wrapAndThrowUnchecked(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof Error)) {
      throw new ExecutionError((Error)paramThrowable);
    }
    throw new UncheckedExecutionException(paramThrowable);
  }
  
  @Beta
  @GwtCompatible
  @CanIgnoreReturnValue
  public static final class FutureCombiner<V>
  {
    private final boolean allMustSucceed;
    private final ImmutableList<ListenableFuture<? extends V>> futures;
    
    private FutureCombiner(boolean paramBoolean, ImmutableList<ListenableFuture<? extends V>> paramImmutableList)
    {
      this.allMustSucceed = paramBoolean;
      this.futures = paramImmutableList;
    }
    
    @CanIgnoreReturnValue
    public <C> ListenableFuture<C> call(Callable<C> paramCallable)
    {
      return call(paramCallable, MoreExecutors.directExecutor());
    }
    
    @CanIgnoreReturnValue
    public <C> ListenableFuture<C> call(Callable<C> paramCallable, Executor paramExecutor)
    {
      return new CombinedFuture(this.futures, this.allMustSucceed, paramExecutor, paramCallable);
    }
    
    public <C> ListenableFuture<C> callAsync(AsyncCallable<C> paramAsyncCallable)
    {
      return callAsync(paramAsyncCallable, MoreExecutors.directExecutor());
    }
    
    public <C> ListenableFuture<C> callAsync(AsyncCallable<C> paramAsyncCallable, Executor paramExecutor)
    {
      return new CombinedFuture(this.futures, this.allMustSucceed, paramExecutor, paramAsyncCallable);
    }
  }
  
  @GwtIncompatible
  static class MappingCheckedFuture<V, X extends Exception>
    extends AbstractCheckedFuture<V, X>
  {
    final Function<? super Exception, X> mapper;
    
    MappingCheckedFuture(ListenableFuture<V> paramListenableFuture, Function<? super Exception, X> paramFunction)
    {
      super();
      this.mapper = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    protected X mapException(Exception paramException)
    {
      return (Exception)this.mapper.apply(paramException);
    }
  }
  
  static final class NonCancellationPropagatingFuture<V>
    extends AbstractFuture.TrustedFuture<V>
  {
    NonCancellationPropagatingFuture(ListenableFuture<V> paramListenableFuture)
    {
      paramListenableFuture.addListener(new Futures.NonCancellationPropagatingFuture.1(this, paramListenableFuture), MoreExecutors.directExecutor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures
 * JD-Core Version:    0.7.0.1
 */