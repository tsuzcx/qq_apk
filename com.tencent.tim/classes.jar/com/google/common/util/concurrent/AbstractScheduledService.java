package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public abstract class AbstractScheduledService
  implements Service
{
  private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
  private final AbstractService delegate = new ServiceDelegate(null);
  
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
  
  protected ScheduledExecutorService executor()
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new AbstractScheduledService.1ThreadFactoryImpl(this));
    addListener(new AbstractScheduledService.1(this, localScheduledExecutorService), MoreExecutors.directExecutor());
    return localScheduledExecutorService;
  }
  
  public final Throwable failureCause()
  {
    return this.delegate.failureCause();
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void runOneIteration()
    throws Exception;
  
  protected abstract Scheduler scheduler();
  
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
  
  @Beta
  public static abstract class CustomScheduler
    extends AbstractScheduledService.Scheduler
  {
    public CustomScheduler()
    {
      super();
    }
    
    protected abstract Schedule getNextSchedule()
      throws Exception;
    
    final Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable)
    {
      paramAbstractService = new ReschedulableCallable(paramAbstractService, paramScheduledExecutorService, paramRunnable);
      paramAbstractService.reschedule();
      return paramAbstractService;
    }
    
    class ReschedulableCallable
      extends ForwardingFuture<Void>
      implements Callable<Void>
    {
      @GuardedBy("lock")
      private Future<Void> currentFuture;
      private final ScheduledExecutorService executor;
      private final ReentrantLock lock = new ReentrantLock();
      private final AbstractService service;
      private final Runnable wrappedRunnable;
      
      ReschedulableCallable(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable)
      {
        this.wrappedRunnable = paramRunnable;
        this.executor = paramScheduledExecutorService;
        this.service = paramAbstractService;
      }
      
      public Void call()
        throws Exception
      {
        this.wrappedRunnable.run();
        reschedule();
        return null;
      }
      
      public boolean cancel(boolean paramBoolean)
      {
        this.lock.lock();
        try
        {
          paramBoolean = this.currentFuture.cancel(paramBoolean);
          return paramBoolean;
        }
        finally
        {
          this.lock.unlock();
        }
      }
      
      protected Future<Void> delegate()
      {
        throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
      }
      
      public boolean isCancelled()
      {
        this.lock.lock();
        try
        {
          boolean bool = this.currentFuture.isCancelled();
          return bool;
        }
        finally
        {
          this.lock.unlock();
        }
      }
      
      public void reschedule()
      {
        try
        {
          localSchedule = AbstractScheduledService.CustomScheduler.this.getNextSchedule();
          localThrowable1 = null;
          this.lock.lock();
        }
        catch (Throwable localThrowable2)
        {
          AbstractScheduledService.CustomScheduler.Schedule localSchedule;
          Throwable localThrowable1;
          label65:
          this.service.notifyFailed(localThrowable2);
          return;
        }
        try
        {
          if ((this.currentFuture == null) || (!this.currentFuture.isCancelled())) {
            this.currentFuture = this.executor.schedule(this, AbstractScheduledService.CustomScheduler.Schedule.access$800(localSchedule), AbstractScheduledService.CustomScheduler.Schedule.access$900(localSchedule));
          }
        }
        catch (Throwable localThrowable3)
        {
          this.lock.unlock();
          break label65;
        }
        finally
        {
          this.lock.unlock();
        }
        if (localThrowable1 != null) {
          this.service.notifyFailed(localThrowable1);
        }
      }
    }
    
    @Beta
    public static final class Schedule
    {
      private final long delay;
      private final TimeUnit unit;
      
      public Schedule(long paramLong, TimeUnit paramTimeUnit)
      {
        this.delay = paramLong;
        this.unit = ((TimeUnit)Preconditions.checkNotNull(paramTimeUnit));
      }
    }
  }
  
  public static abstract class Scheduler
  {
    public static Scheduler newFixedDelaySchedule(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      if (paramLong2 > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "delay must be > 0, found %s", paramLong2);
        return new AbstractScheduledService.Scheduler.1(paramLong1, paramLong2, paramTimeUnit);
      }
    }
    
    public static Scheduler newFixedRateSchedule(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      Preconditions.checkNotNull(paramTimeUnit);
      if (paramLong2 > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "period must be > 0, found %s", paramLong2);
        return new AbstractScheduledService.Scheduler.2(paramLong1, paramLong2, paramTimeUnit);
      }
    }
    
    abstract Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable);
  }
  
  final class ServiceDelegate
    extends AbstractService
  {
    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock = new ReentrantLock();
    private volatile Future<?> runningTask;
    private final Runnable task = new Task();
    
    private ServiceDelegate() {}
    
    protected final void doStart()
    {
      this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new AbstractScheduledService.ServiceDelegate.1(this));
      this.executorService.execute(new AbstractScheduledService.ServiceDelegate.2(this));
    }
    
    protected final void doStop()
    {
      this.runningTask.cancel(false);
      this.executorService.execute(new AbstractScheduledService.ServiceDelegate.3(this));
    }
    
    public String toString()
    {
      return AbstractScheduledService.this.toString();
    }
    
    class Task
      implements Runnable
    {
      Task() {}
      
      public void run()
      {
        AbstractScheduledService.ServiceDelegate.this.lock.lock();
        try
        {
          boolean bool = AbstractScheduledService.ServiceDelegate.this.runningTask.isCancelled();
          if (bool) {
            return;
          }
          AbstractScheduledService.this.runOneIteration();
          return;
        }
        catch (Throwable localThrowable)
        {
          try
          {
            AbstractScheduledService.this.shutDown();
            AbstractScheduledService.ServiceDelegate.this.notifyFailed(localThrowable);
            AbstractScheduledService.ServiceDelegate.this.runningTask.cancel(false);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", localException);
            }
          }
        }
        finally
        {
          AbstractScheduledService.ServiceDelegate.this.lock.unlock();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService
 * JD-Core Version:    0.7.0.1
 */