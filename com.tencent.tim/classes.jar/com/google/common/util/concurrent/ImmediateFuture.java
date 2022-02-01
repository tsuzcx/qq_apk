package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class ImmediateFuture<V>
  implements ListenableFuture<V>
{
  private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    try
    {
      paramExecutor.execute(paramRunnable);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      log.log(Level.SEVERE, "RuntimeException while executing runnable " + paramRunnable + " with executor " + paramExecutor, localRuntimeException);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public abstract V get()
    throws ExecutionException;
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException
  {
    Preconditions.checkNotNull(paramTimeUnit);
    return get();
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  static final class ImmediateCancelledFuture<V>
    extends AbstractFuture.TrustedFuture<V>
  {
    ImmediateCancelledFuture()
    {
      cancel(false);
    }
  }
  
  @GwtIncompatible
  static class ImmediateFailedCheckedFuture<V, X extends Exception>
    extends ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    private final X thrown;
    
    ImmediateFailedCheckedFuture(X paramX)
    {
      this.thrown = paramX;
    }
    
    public V checkedGet()
      throws Exception
    {
      throw this.thrown;
    }
    
    public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
      throws Exception
    {
      Preconditions.checkNotNull(paramTimeUnit);
      throw this.thrown;
    }
    
    public V get()
      throws ExecutionException
    {
      throw new ExecutionException(this.thrown);
    }
  }
  
  static final class ImmediateFailedFuture<V>
    extends AbstractFuture.TrustedFuture<V>
  {
    ImmediateFailedFuture(Throwable paramThrowable)
    {
      setException(paramThrowable);
    }
  }
  
  @GwtIncompatible
  static class ImmediateSuccessfulCheckedFuture<V, X extends Exception>
    extends ImmediateFuture<V>
    implements CheckedFuture<V, X>
  {
    @Nullable
    private final V value;
    
    ImmediateSuccessfulCheckedFuture(@Nullable V paramV)
    {
      this.value = paramV;
    }
    
    public V checkedGet()
    {
      return this.value;
    }
    
    public V checkedGet(long paramLong, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      return this.value;
    }
    
    public V get()
    {
      return this.value;
    }
  }
  
  static class ImmediateSuccessfulFuture<V>
    extends ImmediateFuture<V>
  {
    static final ImmediateSuccessfulFuture<Object> NULL = new ImmediateSuccessfulFuture(null);
    @Nullable
    private final V value;
    
    ImmediateSuccessfulFuture(@Nullable V paramV)
    {
      this.value = paramV;
    }
    
    public V get()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ImmediateFuture
 * JD-Core Version:    0.7.0.1
 */