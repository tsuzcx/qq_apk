package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
public abstract class AbstractExecutionThreadService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
  private final Service delegate = new AbstractExecutionThreadService.1(this);
  
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
    return new AbstractExecutionThreadService.2(this);
  }
  
  public final Throwable failureCause()
  {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void run()
    throws Exception;
  
  protected String serviceName()
  {
    return getClass().getSimpleName();
  }
  
  protected void shutDown()
    throws Exception
  {}
  
  @CanIgnoreReturnValue
  public final Service startAsync()
  {
    this.delegate.startAsync();
    return this;
  }
  
  protected void startUp()
    throws Exception
  {}
  
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
  
  protected void triggerShutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractExecutionThreadService
 * JD-Core Version:    0.7.0.1
 */