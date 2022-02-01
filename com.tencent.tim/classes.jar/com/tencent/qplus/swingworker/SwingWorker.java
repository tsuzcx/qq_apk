package com.tencent.qplus.swingworker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class SwingWorker<T, V>
  implements RunnableFuture<T>
{
  private static final Object DO_SUBMIT_LOCK = new Object();
  private static final int MAX_WORKER_THREADS = 10;
  public static final String PROPERTY_CHANGE_NAME_PROGRESS = "progress";
  private static ExecutorService executorService;
  private static AccumulativeRunnable<Runnable> mDoSubmit;
  private AccumulativeRunnable<Integer> doNotifyProgressChange = null;
  private AccumulativeRunnable<V> doProcess = null;
  private final AccumulativeRunnable<Runnable> doSubmit = getDoSubmit();
  private final FutureTask<T> future = new SwingWorker.2(this, new SwingWorker.1(this));
  private volatile int progress;
  private final PropertyChangeSupport propertyChangeSupport = new SwingWorkerPropertyChangeSupport(this);
  private volatile StateValue state = StateValue.PENDING;
  
  public static void dispose()
  {
    try
    {
      if (executorService != null)
      {
        executorService.shutdown();
        executorService = null;
        mDoSubmit = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void doneEDT()
  {
    SwingWorker.5 local5 = new SwingWorker.5(this);
    if (WorkerUtilities.isUIThread())
    {
      local5.run();
      return;
    }
    this.doSubmit.add(new Runnable[] { local5 });
  }
  
  private static AccumulativeRunnable<Runnable> getDoSubmit()
  {
    synchronized (DO_SUBMIT_LOCK)
    {
      if (mDoSubmit == null) {
        mDoSubmit = new DoSubmitAccumulativeRunnable(null);
      }
      AccumulativeRunnable localAccumulativeRunnable = mDoSubmit;
      return localAccumulativeRunnable;
    }
  }
  
  private static ExecutorService getWorkersExecutorService()
  {
    try
    {
      if (executorService == null)
      {
        localObject1 = new SwingWorker.6();
        ScheduleLinkedBlockingQueue localScheduleLinkedBlockingQueue = new ScheduleLinkedBlockingQueue();
        executorService = new ThreadPoolExecutor(10, 10, 600L, TimeUnit.SECONDS, localScheduleLinkedBlockingQueue, (ThreadFactory)localObject1);
        localScheduleLinkedBlockingQueue.setExecutor((ThreadPoolExecutor)executorService);
      }
      Object localObject1 = executorService;
      return localObject1;
    }
    finally {}
  }
  
  public final void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    getPropertyChangeSupport().addPropertyChangeListener(paramPropertyChangeListener);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return this.future.cancel(paramBoolean);
  }
  
  protected abstract T doInBackground()
    throws Exception;
  
  protected void done() {}
  
  protected void execute() {}
  
  public final void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
  {
    getPropertyChangeSupport().firePropertyChange(paramString, paramObject1, paramObject2);
  }
  
  public final T get()
    throws InterruptedException, ExecutionException
  {
    return this.future.get();
  }
  
  public final T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.future.get(paramLong, paramTimeUnit);
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final PropertyChangeSupport getPropertyChangeSupport()
  {
    return this.propertyChangeSupport;
  }
  
  public final StateValue getState()
  {
    if (isDone()) {
      return StateValue.DONE;
    }
    return this.state;
  }
  
  public final boolean isCancelled()
  {
    return this.future.isCancelled();
  }
  
  public final boolean isDone()
  {
    return this.future.isDone();
  }
  
  protected void process(List<V> paramList) {}
  
  protected final void publish(V... paramVarArgs)
  {
    try
    {
      if (this.doProcess == null) {
        this.doProcess = new SwingWorker.3(this);
      }
      this.doProcess.add(paramVarArgs);
      return;
    }
    finally {}
  }
  
  public final void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    getPropertyChangeSupport().removePropertyChangeListener(paramPropertyChangeListener);
  }
  
  public final void run()
  {
    this.future.run();
  }
  
  protected final void setProgress(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 100)) {
      throw new IllegalArgumentException("the value should be from 0 to 100");
    }
    if (this.progress == paramInt) {}
    int i;
    do
    {
      return;
      i = this.progress;
      this.progress = paramInt;
    } while (!getPropertyChangeSupport().hasListeners("progress"));
    try
    {
      if (this.doNotifyProgressChange == null) {
        this.doNotifyProgressChange = new SwingWorker.4(this);
      }
      this.doNotifyProgressChange.add(new Integer[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      return;
    }
    finally {}
  }
  
  protected void setState(StateValue paramStateValue)
  {
    StateValue localStateValue = this.state;
    this.state = paramStateValue;
    firePropertyChange("state", localStateValue, paramStateValue);
  }
  
  static class DoSubmitAccumulativeRunnable
    extends AccumulativeRunnable<Runnable>
  {
    private static final int DELAY = 33;
    
    protected void run(List<Runnable> paramList)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          return;
        }
        ((Runnable)paramList.next()).run();
      }
    }
    
    protected void submit()
    {
      WorkerUtilities.invokeInLooper(this, 33L);
    }
  }
  
  public static enum StateValue
  {
    PENDING,  STARTED,  DONE;
  }
  
  class SwingWorkerPropertyChangeSupport
    extends PropertyChangeSupport
  {
    private Object source;
    
    SwingWorkerPropertyChangeSupport(Object paramObject)
    {
      super();
      this.source = paramObject;
    }
    
    public void firePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
    {
      if (WorkerUtilities.isUIThread())
      {
        super.firePropertyChange(paramPropertyChangeEvent);
        return;
      }
      SwingWorker.this.doSubmit.add(new Runnable[] { new SwingWorker.SwingWorkerPropertyChangeSupport.1(this, paramPropertyChangeEvent) });
    }
    
    public void firePropertyChange(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      firePropertyChange(paramString, new Integer(paramInt1), new Integer(paramInt2));
    }
    
    public void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
    {
      if ((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) {
        return;
      }
      firePropertyChange(new PropertyChangeEvent(this.source, paramString, paramObject1, paramObject2));
    }
    
    public void firePropertyChange(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1 == paramBoolean2) {
        return;
      }
      firePropertyChange(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker
 * JD-Core Version:    0.7.0.1
 */