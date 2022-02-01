package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

@Beta
@GwtIncompatible
public final class JdkFutureAdapters
{
  public static <V> ListenableFuture<V> listenInPoolThread(Future<V> paramFuture)
  {
    if ((paramFuture instanceof ListenableFuture)) {
      return (ListenableFuture)paramFuture;
    }
    return new ListenableFutureAdapter(paramFuture);
  }
  
  public static <V> ListenableFuture<V> listenInPoolThread(Future<V> paramFuture, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramExecutor);
    if ((paramFuture instanceof ListenableFuture)) {
      return (ListenableFuture)paramFuture;
    }
    return new ListenableFutureAdapter(paramFuture, paramExecutor);
  }
  
  static class ListenableFutureAdapter<V>
    extends ForwardingFuture<V>
    implements ListenableFuture<V>
  {
    private static final Executor defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
    private final Executor adapterExecutor;
    private final Future<V> delegate;
    private final ExecutionList executionList = new ExecutionList();
    private final AtomicBoolean hasListeners = new AtomicBoolean(false);
    
    ListenableFutureAdapter(Future<V> paramFuture)
    {
      this(paramFuture, defaultAdapterExecutor);
    }
    
    ListenableFutureAdapter(Future<V> paramFuture, Executor paramExecutor)
    {
      this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
      this.adapterExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    }
    
    public void addListener(Runnable paramRunnable, Executor paramExecutor)
    {
      this.executionList.add(paramRunnable, paramExecutor);
      if (this.hasListeners.compareAndSet(false, true))
      {
        if (this.delegate.isDone()) {
          this.executionList.execute();
        }
      }
      else {
        return;
      }
      this.adapterExecutor.execute(new JdkFutureAdapters.ListenableFutureAdapter.1(this));
    }
    
    protected Future<V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.JdkFutureAdapters
 * JD-Core Version:    0.7.0.1
 */