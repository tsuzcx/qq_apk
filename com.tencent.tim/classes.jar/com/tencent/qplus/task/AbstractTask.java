package com.tencent.qplus.task;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import com.tencent.qplus.swingworker.SwingWorker;
import com.tencent.qplus.swingworker.SwingWorker.StateValue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTask<ReturnResult, InterParam>
  extends SwingWorker<ReturnResult, InterParam>
{
  protected static final String TAG = "Task";
  protected final Context context;
  private String description = null;
  private long doneTime = -1L;
  private InputBlocker inputBlocker;
  private String message = null;
  private long messageTime = -1L;
  private boolean progressPropertyIsValid = false;
  private Resources resources;
  private long startTime = -1L;
  private List<TaskListener<ReturnResult, InterParam>> taskListeners;
  private TaskService taskService = null;
  private String title = null;
  private boolean userCanCancel = true;
  
  public AbstractTask(Context paramContext)
  {
    this.context = paramContext;
    initTask(defaultResourceMap(paramContext));
  }
  
  public AbstractTask(Context paramContext, Resources paramResources)
  {
    this.context = paramContext;
    initTask(paramResources);
  }
  
  private Resources defaultResourceMap(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getResources();
    }
    return null;
  }
  
  private void fireCancelledListeners()
  {
    TaskEvent localTaskEvent = new TaskEvent(this, null);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).cancelled(localTaskEvent);
    }
  }
  
  /* Error */
  private void fireCompletionListeners()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	com/tencent/qplus/task/AbstractTask:isCancelled	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokespecial 135	com/tencent/qplus/task/AbstractTask:fireCancelledListeners	()V
    //   11: aload_0
    //   12: invokespecial 138	com/tencent/qplus/task/AbstractTask:fireFinishedListeners	()V
    //   15: return
    //   16: aload_0
    //   17: aload_0
    //   18: invokevirtual 141	com/tencent/qplus/task/AbstractTask:get	()Ljava/lang/Object;
    //   21: invokespecial 145	com/tencent/qplus/task/AbstractTask:fireSucceededListeners	(Ljava/lang/Object;)V
    //   24: goto -13 -> 11
    //   27: astore_1
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 149	com/tencent/qplus/task/AbstractTask:fireInterruptedListeners	(Ljava/lang/InterruptedException;)V
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: invokespecial 138	com/tencent/qplus/task/AbstractTask:fireFinishedListeners	()V
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 153	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   49: invokespecial 157	com/tencent/qplus/task/AbstractTask:fireFailedListeners	(Ljava/lang/Throwable;)V
    //   52: goto -41 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	AbstractTask
    //   27	3	1	localInterruptedException	InterruptedException
    //   36	6	1	localObject	Object
    //   43	3	1	localExecutionException	ExecutionException
    // Exception table:
    //   from	to	target	type
    //   16	24	27	java/lang/InterruptedException
    //   0	11	36	finally
    //   16	24	36	finally
    //   28	33	36	finally
    //   44	52	36	finally
    //   16	24	43	java/util/concurrent/ExecutionException
  }
  
  private void fireDoInBackgroundListeners()
  {
    TaskEvent localTaskEvent = new TaskEvent(this, null);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).doInBackground(localTaskEvent);
    }
  }
  
  private void fireFailedListeners(Throwable paramThrowable)
  {
    paramThrowable = new TaskEvent(this, paramThrowable);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).failed(paramThrowable);
    }
  }
  
  private void fireFinishedListeners()
  {
    TaskEvent localTaskEvent = new TaskEvent(this, null);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).finished(localTaskEvent);
    }
  }
  
  private void fireInterruptedListeners(InterruptedException paramInterruptedException)
  {
    paramInterruptedException = new TaskEvent(this, paramInterruptedException);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).interrupted(paramInterruptedException);
    }
  }
  
  private void fireProcessListeners(List<InterParam> paramList)
  {
    paramList = new TaskEvent(this, paramList);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).process(paramList);
    }
  }
  
  private void fireSucceededListeners(ReturnResult paramReturnResult)
  {
    paramReturnResult = new TaskEvent(this, paramReturnResult);
    Iterator localIterator = this.taskListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((TaskListener)localIterator.next()).succeeded(paramReturnResult);
    }
  }
  
  private void initTask(Resources paramResources)
  {
    this.resources = paramResources;
    if (paramResources != null) {
      this.messageTime = System.currentTimeMillis();
    }
    addPropertyChangeListener(new StatePCL(null));
    this.taskListeners = new CopyOnWriteArrayList();
  }
  
  public void addTaskListener(TaskListener<ReturnResult, InterParam> paramTaskListener)
  {
    if (paramTaskListener == null) {
      throw new IllegalArgumentException("null listener");
    }
    this.taskListeners.add(paramTaskListener);
  }
  
  protected void cancelled() {}
  
  public final void done()
  {
    try
    {
      if (isCancelled()) {
        cancelled();
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          finished();
          setTaskService(null);
          return;
        }
        finally {}
        try
        {
          succeeded(get());
        }
        catch (InterruptedException localInterruptedException)
        {
          interrupted(localInterruptedException);
          continue;
          localObject1 = finally;
        }
        catch (ExecutionException localExecutionException)
        {
          try
          {
            finished();
            setTaskService(null);
            throw localObject1;
          }
          finally
          {
            setTaskService(null);
          }
          localExecutionException = localExecutionException;
          failed(localExecutionException.getCause());
        }
      }
    }
  }
  
  protected void failed(Throwable paramThrowable)
  {
    Log.e("Task", String.format("%s failed: %s", new Object[] { this, paramThrowable }), paramThrowable);
  }
  
  protected void finished() {}
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public String getDescription()
  {
    try
    {
      String str = this.description;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getExecutionDuration(TimeUnit paramTimeUnit)
  {
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        l1 = this.startTime;
        l2 = this.doneTime;
        if (l1 == -1L)
        {
          l1 = 0L;
          return paramTimeUnit.convert(Math.max(0L, l1), TimeUnit.MILLISECONDS);
        }
      }
      finally {}
      if (l2 == -1L) {
        l1 = System.currentTimeMillis() - l1;
      } else {
        l1 = l2 - l1;
      }
    }
  }
  
  public final InputBlocker getInputBlocker()
  {
    return this.inputBlocker;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public long getMessageDuration(TimeUnit paramTimeUnit)
  {
    long l1 = 0L;
    for (;;)
    {
      long l2;
      try
      {
        l2 = this.messageTime;
        if (l2 == -1L) {
          return paramTimeUnit.convert(l1, TimeUnit.MILLISECONDS);
        }
      }
      finally {}
      l1 = Math.max(0L, System.currentTimeMillis() - l2);
    }
  }
  
  public final Resources getResources()
  {
    return this.resources;
  }
  
  public TaskListener<ReturnResult, InterParam>[] getTaskListeners()
  {
    return (TaskListener[])this.taskListeners.toArray(new TaskListener[this.taskListeners.size()]);
  }
  
  public TaskService getTaskService()
  {
    try
    {
      TaskService localTaskService = this.taskService;
      return localTaskService;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getTitle()
  {
    try
    {
      String str = this.title;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean getUserCanCancel()
  {
    try
    {
      boolean bool = this.userCanCancel;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void interrupted(InterruptedException paramInterruptedException) {}
  
  public final boolean isPending()
  {
    return getState() == SwingWorker.StateValue.PENDING;
  }
  
  public boolean isProgressPropertyValid()
  {
    try
    {
      boolean bool = this.progressPropertyIsValid;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isStarted()
  {
    return getState() == SwingWorker.StateValue.STARTED;
  }
  
  protected final void message(int paramInt, Object... paramVarArgs)
  {
    Resources localResources = getResources();
    if (localResources != null)
    {
      if (paramVarArgs.length == 0)
      {
        setMessage(localResources.getString(paramInt));
        return;
      }
      setMessage(String.format(localResources.getString(paramInt), paramVarArgs));
      return;
    }
    setMessage(paramInt);
  }
  
  public void process(List<InterParam> paramList)
  {
    fireProcessListeners(paramList);
  }
  
  public void removeTaskListener(TaskListener<ReturnResult, InterParam> paramTaskListener)
  {
    if (paramTaskListener == null) {
      throw new IllegalArgumentException("null listener");
    }
    this.taskListeners.remove(paramTaskListener);
  }
  
  protected void setDescription(String paramString)
  {
    try
    {
      String str = this.description;
      this.description = paramString;
      paramString = this.description;
      firePropertyChange("description", str, paramString);
      return;
    }
    finally {}
  }
  
  public final void setInputBlocker(InputBlocker paramInputBlocker)
  {
    if (getTaskService() != null) {
      throw new IllegalStateException("task already being executed");
    }
    try
    {
      InputBlocker localInputBlocker = this.inputBlocker;
      this.inputBlocker = paramInputBlocker;
      paramInputBlocker = this.inputBlocker;
      firePropertyChange("inputBlocker", localInputBlocker, paramInputBlocker);
      return;
    }
    finally {}
  }
  
  protected void setMessage(String paramString)
  {
    try
    {
      String str = this.message;
      this.message = paramString;
      paramString = this.message;
      this.messageTime = System.currentTimeMillis();
      firePropertyChange("message", str, paramString);
      return;
    }
    finally {}
  }
  
  protected final void setProgress(float paramFloat)
  {
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D)) {
      throw new IllegalArgumentException("invalid percentage");
    }
    setProgress(Math.round(100.0F * paramFloat));
  }
  
  protected final void setProgress(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("invalid range: min >= max");
    }
    if ((paramFloat1 < paramFloat2) || (paramFloat1 > paramFloat3)) {
      throw new IllegalArgumentException("invalid value");
    }
    setProgress(Math.round((paramFloat1 - paramFloat2) / (paramFloat3 - paramFloat2) * 100.0F));
  }
  
  protected final void setProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= paramInt3) {
      throw new IllegalArgumentException("invalid range: min >= max");
    }
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new IllegalArgumentException("invalid value");
    }
    setProgress(Math.round((paramInt1 - paramInt2) / (paramInt3 - paramInt2) * 100.0F));
  }
  
  /* Error */
  void setTaskService(TaskService paramTaskService)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 64	com/tencent/qplus/task/AbstractTask:taskService	Lcom/tencent/qplus/task/TaskService;
    //   8: astore_2
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 64	com/tencent/qplus/task/AbstractTask:taskService	Lcom/tencent/qplus/task/TaskService;
    //   14: aload_0
    //   15: getfield 64	com/tencent/qplus/task/AbstractTask:taskService	Lcom/tencent/qplus/task/TaskService;
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: ldc_w 367
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 337	com/tencent/qplus/task/AbstractTask:firePropertyChange	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	AbstractTask
    //   0	43	1	paramTaskService	TaskService
    //   8	18	2	localTaskService	TaskService
    // Exception table:
    //   from	to	target	type
    //   4	21	33	finally
    //   34	36	33	finally
    //   2	4	38	finally
    //   21	30	38	finally
    //   36	38	38	finally
  }
  
  protected void setTitle(String paramString)
  {
    try
    {
      String str = this.title;
      this.title = paramString;
      paramString = this.title;
      firePropertyChange("title", str, paramString);
      return;
    }
    finally {}
  }
  
  protected void setUserCanCancel(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.userCanCancel;
      this.userCanCancel = paramBoolean;
      paramBoolean = this.userCanCancel;
      firePropertyChange("userCanCancel", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean));
      return;
    }
    finally {}
  }
  
  protected void succeeded(ReturnResult paramReturnResult) {}
  
  public static enum BlockingScope
  {
    NONE,  VIEW,  WINDOW,  APPLICATION;
  }
  
  public static abstract class InputBlocker
  {
    private final AbstractTask.BlockingScope scope;
    private final Object target;
    private final AbstractTask task;
    
    public InputBlocker(AbstractTask paramAbstractTask, AbstractTask.BlockingScope paramBlockingScope, Object paramObject)
    {
      if (paramAbstractTask == null) {
        throw new IllegalArgumentException("null task");
      }
      if (paramAbstractTask.getTaskService() != null) {
        throw new IllegalStateException("task already being executed");
      }
      switch (paramBlockingScope)
      {
      }
      do
      {
        this.task = paramAbstractTask;
        this.scope = paramBlockingScope;
        this.target = paramObject;
        return;
      } while ((paramObject instanceof View));
      throw new IllegalArgumentException("target not a Component");
    }
    
    protected abstract void block();
    
    public final AbstractTask.BlockingScope getScope()
    {
      return this.scope;
    }
    
    public final Object getTarget()
    {
      return this.target;
    }
    
    public final AbstractTask getTask()
    {
      return this.task;
    }
    
    protected abstract void unblock();
  }
  
  class StatePCL
    implements PropertyChangeListener
  {
    private StatePCL() {}
    
    private void taskDone(AbstractTask paramAbstractTask)
    {
      synchronized (AbstractTask.this)
      {
        AbstractTask.this.doneTime = System.currentTimeMillis();
      }
    }
    
    private void taskStarted(AbstractTask arg1)
    {
      synchronized (AbstractTask.this)
      {
        AbstractTask.this.startTime = System.currentTimeMillis();
        AbstractTask.this.firePropertyChange("started", Boolean.valueOf(false), Boolean.valueOf(true));
        AbstractTask.this.fireDoInBackgroundListeners();
        return;
      }
    }
    
    public void propertyChange(PropertyChangeEvent arg1)
    {
      Object localObject1 = ???.getPropertyName();
      if ("state".equals(localObject1))
      {
        localObject1 = (SwingWorker.StateValue)???.getNewValue();
        ??? = (AbstractTask)???.getSource();
        switch (localObject1)
        {
        }
      }
      while (!"progress".equals(localObject1))
      {
        return;
        taskStarted(???);
        return;
        taskDone(???);
        return;
      }
      synchronized (AbstractTask.this)
      {
        AbstractTask.this.progressPropertyIsValid = true;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractTask
 * JD-Core Version:    0.7.0.1
 */