package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
public abstract class AbstractIdleService
  implements Service
{
  private final Service delegate = new DelegateService(null);
  private final Supplier<String> threadNameSupplier = new ThreadNameSupplier(null);
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor)
  {
    this.delegate.addListener(paramListener, paramExecutor);
  }
  
  public final void awaitRunning()
  {
    this.delegate.awaitRunning();
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.delegate.awaitRunning(paramLong, paramTimeUnit);
  }
  
  public final void awaitTerminated()
  {
    this.delegate.awaitTerminated();
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.delegate.awaitTerminated(paramLong, paramTimeUnit);
  }
  
  protected Executor executor()
  {
    return new AbstractIdleService.1(this);
  }
  
  public final Throwable failureCause()
  {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
  
  protected abstract void shutDown()
    throws Exception;
  
  @CanIgnoreReturnValue
  public final Service startAsync()
  {
    this.delegate.startAsync();
    return this;
  }
  
  protected abstract void startUp()
    throws Exception;
  
  public final Service.State state()
  {
    return this.delegate.state();
  }
  
  @CanIgnoreReturnValue
  public final Service stopAsync()
  {
    this.delegate.stopAsync();
    return this;
  }
  
  public String toString()
  {
    return serviceName() + " [" + state() + "]";
  }
  
  final class DelegateService
    extends AbstractService
  {
    private DelegateService() {}
    
    protected final void doStart()
    {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService.DelegateService.1(this));
    }
    
    protected final void doStop()
    {
      MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService.DelegateService.2(this));
    }
    
    public String toString()
    {
      return AbstractIdleService.this.toString();
    }
  }
  
  final class ThreadNameSupplier
    implements Supplier<String>
  {
    private ThreadNameSupplier() {}
    
    public String get()
    {
      return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractIdleService
 * JD-Core Version:    0.7.0.1
 */