package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtIncompatible
public abstract class AbstractService
  implements Service
{
  private static final ListenerCallQueue.Callback<Service.Listener> RUNNING_CALLBACK;
  private static final ListenerCallQueue.Callback<Service.Listener> STARTING_CALLBACK = new AbstractService.1("starting()");
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_STARTING_CALLBACK;
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service.State.NEW);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service.State.STOPPING);
  private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
  private final Monitor.Guard isStartable = new IsStartableGuard();
  private final Monitor.Guard isStoppable = new IsStoppableGuard();
  private final Monitor.Guard isStopped = new IsStoppedGuard();
  @GuardedBy("monitor")
  private final List<ListenerCallQueue<Service.Listener>> listeners = Collections.synchronizedList(new ArrayList());
  private final Monitor monitor = new Monitor();
  @GuardedBy("monitor")
  private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);
  
  static
  {
    RUNNING_CALLBACK = new AbstractService.2("running()");
    STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service.State.STARTING);
  }
  
  @GuardedBy("monitor")
  private void checkCurrentState(Service.State paramState)
  {
    Service.State localState = state();
    if (localState != paramState)
    {
      if (localState == Service.State.FAILED) {
        throw new IllegalStateException("Expected the service " + this + " to be " + paramState + ", but the service has FAILED", failureCause());
      }
      throw new IllegalStateException("Expected the service " + this + " to be " + paramState + ", but was " + localState);
    }
  }
  
  private void executeListeners()
  {
    if (!this.monitor.isOccupiedByCurrentThread())
    {
      int i = 0;
      while (i < this.listeners.size())
      {
        ((ListenerCallQueue)this.listeners.get(i)).execute();
        i += 1;
      }
    }
  }
  
  @GuardedBy("monitor")
  private void failed(Service.State paramState, Throwable paramThrowable)
  {
    new AbstractService.5(this, "failed({from = " + paramState + ", cause = " + paramThrowable + "})", paramState, paramThrowable).enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void running()
  {
    RUNNING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void starting()
  {
    STARTING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void stopping(Service.State paramState)
  {
    if (paramState == Service.State.STARTING)
    {
      STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    if (paramState == Service.State.RUNNING)
    {
      STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    throw new AssertionError();
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> stoppingCallback(Service.State paramState)
  {
    return new AbstractService.4("stopping({from = " + paramState + "})", paramState);
  }
  
  @GuardedBy("monitor")
  private void terminated(Service.State paramState)
  {
    switch (6.$SwitchMap$com$google$common$util$concurrent$Service$State[paramState.ordinal()])
    {
    case 2: 
    default: 
      throw new AssertionError();
    case 1: 
      TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
      return;
    case 3: 
      TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
      return;
    }
    TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> terminatedCallback(Service.State paramState)
  {
    return new AbstractService.3("terminated({from = " + paramState + "})", paramState);
  }
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramListener, "listener");
    Preconditions.checkNotNull(paramExecutor, "executor");
    this.monitor.enter();
    try
    {
      if (!state().isTerminal()) {
        this.listeners.add(new ListenerCallQueue(paramListener, paramExecutor));
      }
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitRunning()
  {
    this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
    try
    {
      checkCurrentState(Service.State.RUNNING);
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, paramLong, paramTimeUnit)) {
      try
      {
        checkCurrentState(Service.State.RUNNING);
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
  }
  
  public final void awaitTerminated()
  {
    this.monitor.enterWhenUninterruptibly(this.isStopped);
    try
    {
      checkCurrentState(Service.State.TERMINATED);
      return;
    }
    finally
    {
      this.monitor.leave();
    }
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    if (this.monitor.enterWhenUninterruptibly(this.isStopped, paramLong, paramTimeUnit)) {
      try
      {
        checkCurrentState(Service.State.TERMINATED);
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. " + "Current state: " + state());
  }
  
  protected abstract void doStart();
  
  protected abstract void doStop();
  
  public final Throwable failureCause()
  {
    return this.snapshot.failureCause();
  }
  
  public final boolean isRunning()
  {
    return state() == Service.State.RUNNING;
  }
  
  /* Error */
  protected final void notifyFailed(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 312	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   9: invokevirtual 263	com/google/common/util/concurrent/Monitor:enter	()V
    //   12: aload_0
    //   13: invokevirtual 144	com/google/common/util/concurrent/AbstractService:state	()Lcom/google/common/util/concurrent/Service$State;
    //   16: astore_2
    //   17: getstatic 240	com/google/common/util/concurrent/AbstractService$6:$SwitchMap$com$google$common$util$concurrent$Service$State	[I
    //   20: aload_2
    //   21: invokevirtual 243	com/google/common/util/concurrent/Service$State:ordinal	()I
    //   24: iaload
    //   25: tableswitch	default:+144 -> 169, 1:+81->106, 2:+110->135, 3:+110->135, 4:+110->135, 5:+81->106, 6:+132->157
    //   65: nop
    //   66: <illegal opcode>
    //   67: dup
    //   68: new 151	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 314
    //   78: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 317	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   97: invokevirtual 276	com/google/common/util/concurrent/Monitor:leave	()V
    //   100: aload_0
    //   101: invokespecial 319	com/google/common/util/concurrent/AbstractService:executeListeners	()V
    //   104: aload_1
    //   105: athrow
    //   106: new 149	java/lang/IllegalStateException
    //   109: dup
    //   110: new 151	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 321
    //   120: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: aload_1
    //   131: invokespecial 176	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: athrow
    //   135: aload_0
    //   136: new 22	com/google/common/util/concurrent/AbstractService$StateSnapshot
    //   139: dup
    //   140: getstatic 147	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
    //   143: iconst_0
    //   144: aload_1
    //   145: invokespecial 324	com/google/common/util/concurrent/AbstractService$StateSnapshot:<init>	(Lcom/google/common/util/concurrent/Service$State;ZLjava/lang/Throwable;)V
    //   148: putfield 137	com/google/common/util/concurrent/AbstractService:snapshot	Lcom/google/common/util/concurrent/AbstractService$StateSnapshot;
    //   151: aload_0
    //   152: aload_2
    //   153: aload_1
    //   154: invokespecial 326	com/google/common/util/concurrent/AbstractService:failed	(Lcom/google/common/util/concurrent/Service$State;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   161: invokevirtual 276	com/google/common/util/concurrent/Monitor:leave	()V
    //   164: aload_0
    //   165: invokespecial 319	com/google/common/util/concurrent/AbstractService:executeListeners	()V
    //   168: return
    //   169: goto -105 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	AbstractService
    //   0	172	1	paramThrowable	Throwable
    //   16	137	2	localState	Service.State
    // Exception table:
    //   from	to	target	type
    //   12	64	92	finally
    //   64	92	92	finally
    //   106	135	92	finally
    //   135	157	92	finally
  }
  
  protected final void notifyStarted()
  {
    this.monitor.enter();
    try
    {
      if (this.snapshot.state != Service.State.STARTING)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);
        notifyFailed(localIllegalStateException);
        throw localIllegalStateException;
      }
    }
    finally
    {
      this.monitor.leave();
      executeListeners();
    }
    if (this.snapshot.shutdownWhenStartupFinishes)
    {
      this.snapshot = new StateSnapshot(Service.State.STOPPING);
      doStop();
    }
    for (;;)
    {
      this.monitor.leave();
      executeListeners();
      return;
      this.snapshot = new StateSnapshot(Service.State.RUNNING);
      running();
    }
  }
  
  protected final void notifyStopped()
  {
    this.monitor.enter();
    try
    {
      Object localObject = this.snapshot.state;
      if ((localObject != Service.State.STOPPING) && (localObject != Service.State.RUNNING))
      {
        localObject = new IllegalStateException("Cannot notifyStopped() when the service is " + localObject);
        notifyFailed((Throwable)localObject);
        throw ((Throwable)localObject);
      }
    }
    finally
    {
      this.monitor.leave();
      executeListeners();
    }
    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
    terminated(localState);
    this.monitor.leave();
    executeListeners();
  }
  
  @CanIgnoreReturnValue
  public final Service startAsync()
  {
    if (this.monitor.enterIf(this.isStartable)) {
      try
      {
        this.snapshot = new StateSnapshot(Service.State.STARTING);
        starting();
        doStart();
        return this;
      }
      catch (Throwable localThrowable)
      {
        notifyFailed(localThrowable);
        return this;
      }
      finally
      {
        this.monitor.leave();
        executeListeners();
      }
    }
    throw new IllegalStateException("Service " + this + " has already been started");
  }
  
  public final Service.State state()
  {
    return this.snapshot.externalState();
  }
  
  /* Error */
  @CanIgnoreReturnValue
  public final Service stopAsync()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   4: aload_0
    //   5: getfield 115	com/google/common/util/concurrent/AbstractService:isStoppable	Lcom/google/common/util/concurrent/Monitor$Guard;
    //   8: invokevirtual 355	com/google/common/util/concurrent/Monitor:enterIf	(Lcom/google/common/util/concurrent/Monitor$Guard;)Z
    //   11: ifeq +98 -> 109
    //   14: aload_0
    //   15: invokevirtual 144	com/google/common/util/concurrent/AbstractService:state	()Lcom/google/common/util/concurrent/Service$State;
    //   18: astore_1
    //   19: getstatic 240	com/google/common/util/concurrent/AbstractService$6:$SwitchMap$com$google$common$util$concurrent$Service$State	[I
    //   22: aload_1
    //   23: invokevirtual 243	com/google/common/util/concurrent/Service$State:ordinal	()I
    //   26: iaload
    //   27: tableswitch	default:+214 -> 241, 1:+84->111, 2:+118->145, 3:+158->185, 4:+186->213, 5:+186->213, 6:+186->213
    //   65: nop
    //   66: <illegal opcode>
    //   67: dup
    //   68: new 151	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 314
    //   78: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 317	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 333	com/google/common/util/concurrent/AbstractService:notifyFailed	(Ljava/lang/Throwable;)V
    //   98: aload_0
    //   99: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   102: invokevirtual 276	com/google/common/util/concurrent/Monitor:leave	()V
    //   105: aload_0
    //   106: invokespecial 319	com/google/common/util/concurrent/AbstractService:executeListeners	()V
    //   109: aload_0
    //   110: areturn
    //   111: aload_0
    //   112: new 22	com/google/common/util/concurrent/AbstractService$StateSnapshot
    //   115: dup
    //   116: getstatic 299	com/google/common/util/concurrent/Service$State:TERMINATED	Lcom/google/common/util/concurrent/Service$State;
    //   119: invokespecial 135	com/google/common/util/concurrent/AbstractService$StateSnapshot:<init>	(Lcom/google/common/util/concurrent/Service$State;)V
    //   122: putfield 137	com/google/common/util/concurrent/AbstractService:snapshot	Lcom/google/common/util/concurrent/AbstractService$StateSnapshot;
    //   125: aload_0
    //   126: getstatic 87	com/google/common/util/concurrent/Service$State:NEW	Lcom/google/common/util/concurrent/Service$State;
    //   129: invokespecial 346	com/google/common/util/concurrent/AbstractService:terminated	(Lcom/google/common/util/concurrent/Service$State;)V
    //   132: aload_0
    //   133: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   136: invokevirtual 276	com/google/common/util/concurrent/Monitor:leave	()V
    //   139: aload_0
    //   140: invokespecial 319	com/google/common/util/concurrent/AbstractService:executeListeners	()V
    //   143: aload_0
    //   144: areturn
    //   145: aload_0
    //   146: new 22	com/google/common/util/concurrent/AbstractService$StateSnapshot
    //   149: dup
    //   150: getstatic 73	com/google/common/util/concurrent/Service$State:STARTING	Lcom/google/common/util/concurrent/Service$State;
    //   153: iconst_1
    //   154: aconst_null
    //   155: invokespecial 324	com/google/common/util/concurrent/AbstractService$StateSnapshot:<init>	(Lcom/google/common/util/concurrent/Service$State;ZLjava/lang/Throwable;)V
    //   158: putfield 137	com/google/common/util/concurrent/AbstractService:snapshot	Lcom/google/common/util/concurrent/AbstractService$StateSnapshot;
    //   161: aload_0
    //   162: getstatic 73	com/google/common/util/concurrent/Service$State:STARTING	Lcom/google/common/util/concurrent/Service$State;
    //   165: invokespecial 369	com/google/common/util/concurrent/AbstractService:stopping	(Lcom/google/common/util/concurrent/Service$State;)V
    //   168: goto -36 -> 132
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 107	com/google/common/util/concurrent/AbstractService:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   176: invokevirtual 276	com/google/common/util/concurrent/Monitor:leave	()V
    //   179: aload_0
    //   180: invokespecial 319	com/google/common/util/concurrent/AbstractService:executeListeners	()V
    //   183: aload_1
    //   184: athrow
    //   185: aload_0
    //   186: new 22	com/google/common/util/concurrent/AbstractService$StateSnapshot
    //   189: dup
    //   190: getstatic 97	com/google/common/util/concurrent/Service$State:STOPPING	Lcom/google/common/util/concurrent/Service$State;
    //   193: invokespecial 135	com/google/common/util/concurrent/AbstractService$StateSnapshot:<init>	(Lcom/google/common/util/concurrent/Service$State;)V
    //   196: putfield 137	com/google/common/util/concurrent/AbstractService:snapshot	Lcom/google/common/util/concurrent/AbstractService$StateSnapshot;
    //   199: aload_0
    //   200: getstatic 82	com/google/common/util/concurrent/Service$State:RUNNING	Lcom/google/common/util/concurrent/Service$State;
    //   203: invokespecial 369	com/google/common/util/concurrent/AbstractService:stopping	(Lcom/google/common/util/concurrent/Service$State;)V
    //   206: aload_0
    //   207: invokevirtual 339	com/google/common/util/concurrent/AbstractService:doStop	()V
    //   210: goto -78 -> 132
    //   213: new 225	java/lang/AssertionError
    //   216: dup
    //   217: new 151	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 371
    //   227: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokespecial 317	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   240: athrow
    //   241: goto -177 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	AbstractService
    //   18	64	1	localState	Service.State
    //   92	3	1	localThrowable	Throwable
    //   171	60	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	64	92	java/lang/Throwable
    //   64	92	92	java/lang/Throwable
    //   111	132	92	java/lang/Throwable
    //   145	168	92	java/lang/Throwable
    //   185	210	92	java/lang/Throwable
    //   213	241	92	java/lang/Throwable
    //   14	64	171	finally
    //   64	92	171	finally
    //   93	98	171	finally
    //   111	132	171	finally
    //   145	168	171	finally
    //   185	210	171	finally
    //   213	241	171	finally
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " [" + state() + "]";
  }
  
  final class HasReachedRunningGuard
    extends Monitor.Guard
  {
    HasReachedRunningGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
    }
  }
  
  final class IsStartableGuard
    extends Monitor.Guard
  {
    IsStartableGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state() == Service.State.NEW;
    }
  }
  
  final class IsStoppableGuard
    extends Monitor.Guard
  {
    IsStoppableGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
    }
  }
  
  final class IsStoppedGuard
    extends Monitor.Guard
  {
    IsStoppedGuard()
    {
      super();
    }
    
    public boolean isSatisfied()
    {
      return AbstractService.this.state().isTerminal();
    }
  }
  
  @Immutable
  static final class StateSnapshot
  {
    @Nullable
    final Throwable failure;
    final boolean shutdownWhenStartupFinishes;
    final Service.State state;
    
    StateSnapshot(Service.State paramState)
    {
      this(paramState, false, null);
    }
    
    StateSnapshot(Service.State paramState, boolean paramBoolean, @Nullable Throwable paramThrowable)
    {
      int i;
      label36:
      int j;
      if ((!paramBoolean) || (paramState == Service.State.STARTING))
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", paramState);
        if (paramThrowable == null) {
          break label89;
        }
        i = 1;
        if (paramState != Service.State.FAILED) {
          break label95;
        }
        j = 1;
        label46:
        if ((i ^ j) != 0) {
          break label101;
        }
      }
      label89:
      label95:
      label101:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", paramState, paramThrowable);
        this.state = paramState;
        this.shutdownWhenStartupFinishes = paramBoolean;
        this.failure = paramThrowable;
        return;
        bool1 = false;
        break;
        i = 0;
        break label36;
        j = 0;
        break label46;
      }
    }
    
    Service.State externalState()
    {
      if ((this.shutdownWhenStartupFinishes) && (this.state == Service.State.STARTING)) {
        return Service.State.STOPPING;
      }
      return this.state;
    }
    
    Throwable failureCause()
    {
      if (this.state == Service.State.FAILED) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "failureCause() is only valid if the service has failed, service is %s", this.state);
        return this.failure;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractService
 * JD-Core Version:    0.7.0.1
 */