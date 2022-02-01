package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder.SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Iterable<+Lcom.google.common.util.concurrent.Service;>;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public final class ServiceManager
{
  private static final ListenerCallQueue.Callback<Listener> HEALTHY_CALLBACK = new ServiceManager.1("healthy()");
  private static final ListenerCallQueue.Callback<Listener> STOPPED_CALLBACK = new ServiceManager.2("stopped()");
  private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
  private final ImmutableList<Service> services;
  private final ServiceManagerState state;
  
  public ServiceManager(Iterable<? extends Service> paramIterable)
  {
    Object localObject = ImmutableList.copyOf(paramIterable);
    paramIterable = (Iterable<? extends Service>)localObject;
    if (((ImmutableList)localObject).isEmpty())
    {
      logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning(null));
      paramIterable = ImmutableList.of(new NoOpService(null));
    }
    this.state = new ServiceManagerState(paramIterable);
    this.services = paramIterable;
    localObject = new WeakReference(this.state);
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      Service localService = (Service)paramIterable.next();
      localService.addListener(new ServiceListener(localService, (WeakReference)localObject), MoreExecutors.directExecutor());
      if (localService.state() == Service.State.NEW) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Can only manage NEW services, %s", localService);
        break;
      }
    }
    this.state.markReady();
  }
  
  public void addListener(Listener paramListener)
  {
    this.state.addListener(paramListener, MoreExecutors.directExecutor());
  }
  
  public void addListener(Listener paramListener, Executor paramExecutor)
  {
    this.state.addListener(paramListener, paramExecutor);
  }
  
  public void awaitHealthy()
  {
    this.state.awaitHealthy();
  }
  
  public void awaitHealthy(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.state.awaitHealthy(paramLong, paramTimeUnit);
  }
  
  public void awaitStopped()
  {
    this.state.awaitStopped();
  }
  
  public void awaitStopped(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    this.state.awaitStopped(paramLong, paramTimeUnit);
  }
  
  public boolean isHealthy()
  {
    Iterator localIterator = this.services.iterator();
    while (localIterator.hasNext()) {
      if (!((Service)localIterator.next()).isRunning()) {
        return false;
      }
    }
    return true;
  }
  
  public ImmutableMultimap<Service.State, Service> servicesByState()
  {
    return this.state.servicesByState();
  }
  
  @CanIgnoreReturnValue
  public ServiceManager startAsync()
  {
    Iterator localIterator = this.services.iterator();
    Service localService;
    if (localIterator.hasNext())
    {
      localService = (Service)localIterator.next();
      Service.State localState = localService.state();
      if (localState == Service.State.NEW) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Service %s is %s, cannot start it.", localService, localState);
        break;
      }
    }
    localIterator = this.services.iterator();
    while (localIterator.hasNext())
    {
      localService = (Service)localIterator.next();
      try
      {
        this.state.tryStartTiming(localService);
        localService.startAsync();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        logger.log(Level.WARNING, "Unable to start Service " + localService, localIllegalStateException);
      }
    }
    return this;
  }
  
  public ImmutableMap<Service, Long> startupTimes()
  {
    return this.state.startupTimes();
  }
  
  @CanIgnoreReturnValue
  public ServiceManager stopAsync()
  {
    Iterator localIterator = this.services.iterator();
    while (localIterator.hasNext()) {
      ((Service)localIterator.next()).stopAsync();
    }
    return this;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
  }
  
  static final class EmptyServiceManagerWarning
    extends Throwable
  {}
  
  @Beta
  public static abstract class Listener
  {
    public void failure(Service paramService) {}
    
    public void healthy() {}
    
    public void stopped() {}
  }
  
  static final class NoOpService
    extends AbstractService
  {
    protected void doStart()
    {
      notifyStarted();
    }
    
    protected void doStop()
    {
      notifyStopped();
    }
  }
  
  static final class ServiceListener
    extends Service.Listener
  {
    final Service service;
    final WeakReference<ServiceManager.ServiceManagerState> state;
    
    ServiceListener(Service paramService, WeakReference<ServiceManager.ServiceManagerState> paramWeakReference)
    {
      this.service = paramService;
      this.state = paramWeakReference;
    }
    
    public void failed(Service.State paramState, Throwable paramThrowable)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null) {
        if ((this.service instanceof ServiceManager.NoOpService)) {
          break label93;
        }
      }
      label93:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ServiceManager.logger.log(Level.SEVERE, "Service " + this.service + " has failed in the " + paramState + " state.", paramThrowable);
        }
        localServiceManagerState.transitionService(this.service, paramState, Service.State.FAILED);
        return;
      }
    }
    
    public void running()
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null) {
        localServiceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
      }
    }
    
    public void starting()
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null)
      {
        localServiceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
        }
      }
    }
    
    public void stopping(Service.State paramState)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null) {
        localServiceManagerState.transitionService(this.service, paramState, Service.State.STOPPING);
      }
    }
    
    public void terminated(Service.State paramState)
    {
      ServiceManager.ServiceManagerState localServiceManagerState = (ServiceManager.ServiceManagerState)this.state.get();
      if (localServiceManagerState != null)
      {
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.service, paramState });
        }
        localServiceManagerState.transitionService(this.service, paramState, Service.State.TERMINATED);
      }
    }
  }
  
  static final class ServiceManagerState
  {
    final Monitor.Guard awaitHealthGuard = new AwaitHealthGuard();
    @GuardedBy("monitor")
    final List<ListenerCallQueue<ServiceManager.Listener>> listeners = Collections.synchronizedList(new ArrayList());
    final Monitor monitor = new Monitor();
    final int numberOfServices;
    @GuardedBy("monitor")
    boolean ready;
    @GuardedBy("monitor")
    final SetMultimap<Service.State, Service> servicesByState = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
    @GuardedBy("monitor")
    final Map<Service, Stopwatch> startupTimers = Maps.newIdentityHashMap();
    @GuardedBy("monitor")
    final Multiset<Service.State> states = this.servicesByState.keys();
    final Monitor.Guard stoppedGuard = new StoppedGuard();
    @GuardedBy("monitor")
    boolean transitioned;
    
    ServiceManagerState(ImmutableCollection<Service> paramImmutableCollection)
    {
      this.numberOfServices = paramImmutableCollection.size();
      this.servicesByState.putAll(Service.State.NEW, paramImmutableCollection);
    }
    
    void addListener(ServiceManager.Listener paramListener, Executor paramExecutor)
    {
      Preconditions.checkNotNull(paramListener, "listener");
      Preconditions.checkNotNull(paramExecutor, "executor");
      this.monitor.enter();
      try
      {
        if (!this.stoppedGuard.isSatisfied()) {
          this.listeners.add(new ListenerCallQueue(paramListener, paramExecutor));
        }
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    void awaitHealthy()
    {
      this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
      try
      {
        checkHealthy();
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    void awaitHealthy(long paramLong, TimeUnit paramTimeUnit)
      throws TimeoutException
    {
      this.monitor.enter();
      try
      {
        if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, paramLong, paramTimeUnit)) {
          throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
        }
      }
      finally
      {
        this.monitor.leave();
      }
      checkHealthy();
      this.monitor.leave();
    }
    
    void awaitStopped()
    {
      this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
      this.monitor.leave();
    }
    
    void awaitStopped(long paramLong, TimeUnit paramTimeUnit)
      throws TimeoutException
    {
      this.monitor.enter();
      try
      {
        if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, paramLong, paramTimeUnit)) {
          throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
        }
      }
      finally
      {
        this.monitor.leave();
      }
      this.monitor.leave();
    }
    
    @GuardedBy("monitor")
    void checkHealthy()
    {
      if (this.states.count(Service.State.RUNNING) != this.numberOfServices) {
        throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
      }
    }
    
    void executeListeners()
    {
      int i = 0;
      if (!this.monitor.isOccupiedByCurrentThread()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "It is incorrect to execute listeners with the monitor held.");
        while (i < this.listeners.size())
        {
          ((ListenerCallQueue)this.listeners.get(i)).execute();
          i += 1;
        }
      }
    }
    
    @GuardedBy("monitor")
    void fireFailedListeners(Service paramService)
    {
      new ServiceManager.ServiceManagerState.2(this, "failed({service=" + paramService + "})", paramService).enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireHealthyListeners()
    {
      ServiceManager.HEALTHY_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireStoppedListeners()
    {
      ServiceManager.STOPPED_CALLBACK.enqueueOn(this.listeners);
    }
    
    void markReady()
    {
      this.monitor.enter();
      try
      {
        if (!this.transitioned)
        {
          this.ready = true;
          return;
        }
        ArrayList localArrayList = Lists.newArrayList();
        Iterator localIterator = servicesByState().values().iterator();
        while (localIterator.hasNext())
        {
          Service localService = (Service)localIterator.next();
          if (localService.state() != Service.State.NEW) {
            localArrayList.add(localService);
          }
        }
        throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + localObject);
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    ImmutableMultimap<Service.State, Service> servicesByState()
    {
      ImmutableSetMultimap.Builder localBuilder = ImmutableSetMultimap.builder();
      this.monitor.enter();
      try
      {
        Iterator localIterator = this.servicesByState.entries().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!(localEntry.getValue() instanceof ServiceManager.NoOpService)) {
            localBuilder.put(localEntry);
          }
        }
      }
      finally
      {
        this.monitor.leave();
      }
      return localObject.build();
    }
    
    ImmutableMap<Service, Long> startupTimes()
    {
      this.monitor.enter();
      try
      {
        ArrayList localArrayList = Lists.newArrayListWithCapacity(this.startupTimers.size());
        Iterator localIterator = this.startupTimers.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          Service localService = (Service)((Map.Entry)localObject).getKey();
          localObject = (Stopwatch)((Map.Entry)localObject).getValue();
          if ((!((Stopwatch)localObject).isRunning()) && (!(localService instanceof ServiceManager.NoOpService))) {
            localArrayList.add(Maps.immutableEntry(localService, Long.valueOf(((Stopwatch)localObject).elapsed(TimeUnit.MILLISECONDS))));
          }
        }
      }
      finally
      {
        this.monitor.leave();
      }
      Collections.sort(localList, Ordering.natural().onResultOf(new ServiceManager.ServiceManagerState.1(this)));
      return ImmutableMap.copyOf(localList);
    }
    
    /* Error */
    void transitionService(Service paramService, Service.State paramState1, Service.State paramState2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: aload_1
      //   4: invokestatic 439	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
      //   7: pop
      //   8: aload_2
      //   9: aload_3
      //   10: if_acmpeq +43 -> 53
      //   13: iload 4
      //   15: invokestatic 443	com/google/common/base/Preconditions:checkArgument	(Z)V
      //   18: aload_0
      //   19: getfield 47	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   22: invokevirtual 138	com/google/common/util/concurrent/Monitor:enter	()V
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield 299	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:transitioned	Z
      //   30: aload_0
      //   31: getfield 301	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:ready	Z
      //   34: istore 4
      //   36: iload 4
      //   38: ifne +21 -> 59
      //   41: aload_0
      //   42: getfield 47	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   45: invokevirtual 158	com/google/common/util/concurrent/Monitor:leave	()V
      //   48: aload_0
      //   49: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   52: return
      //   53: iconst_0
      //   54: istore 4
      //   56: goto -43 -> 13
      //   59: aload_0
      //   60: getfield 69	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:servicesByState	Lcom/google/common/collect/SetMultimap;
      //   63: aload_2
      //   64: aload_1
      //   65: invokeinterface 449 3 0
      //   70: ldc_w 451
      //   73: aload_1
      //   74: aload_2
      //   75: invokestatic 454	com/google/common/base/Preconditions:checkState	(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   78: aload_0
      //   79: getfield 69	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:servicesByState	Lcom/google/common/collect/SetMultimap;
      //   82: aload_3
      //   83: aload_1
      //   84: invokeinterface 456 3 0
      //   89: ldc_w 458
      //   92: aload_1
      //   93: aload_3
      //   94: invokestatic 454	com/google/common/base/Preconditions:checkState	(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   97: aload_0
      //   98: getfield 85	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:startupTimers	Ljava/util/Map;
      //   101: aload_1
      //   102: invokeinterface 460 2 0
      //   107: checkcast 387	com/google/common/base/Stopwatch
      //   110: astore 5
      //   112: aload 5
      //   114: astore_2
      //   115: aload 5
      //   117: ifnonnull +19 -> 136
      //   120: invokestatic 464	com/google/common/base/Stopwatch:createStarted	()Lcom/google/common/base/Stopwatch;
      //   123: astore_2
      //   124: aload_0
      //   125: getfield 85	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:startupTimers	Ljava/util/Map;
      //   128: aload_1
      //   129: aload_2
      //   130: invokeinterface 466 3 0
      //   135: pop
      //   136: aload_3
      //   137: getstatic 235	com/google/common/util/concurrent/Service$State:RUNNING	Lcom/google/common/util/concurrent/Service$State;
      //   140: invokevirtual 470	com/google/common/util/concurrent/Service$State:compareTo	(Ljava/lang/Enum;)I
      //   143: iflt +46 -> 189
      //   146: aload_2
      //   147: invokevirtual 390	com/google/common/base/Stopwatch:isRunning	()Z
      //   150: ifeq +39 -> 189
      //   153: aload_2
      //   154: invokevirtual 473	com/google/common/base/Stopwatch:stop	()Lcom/google/common/base/Stopwatch;
      //   157: pop
      //   158: aload_1
      //   159: instanceof 360
      //   162: ifne +27 -> 189
      //   165: invokestatic 477	com/google/common/util/concurrent/ServiceManager:access$200	()Ljava/util/logging/Logger;
      //   168: getstatic 483	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   171: ldc_w 485
      //   174: iconst_2
      //   175: anewarray 4	java/lang/Object
      //   178: dup
      //   179: iconst_0
      //   180: aload_1
      //   181: aastore
      //   182: dup
      //   183: iconst_1
      //   184: aload_2
      //   185: aastore
      //   186: invokevirtual 491	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;[Ljava/lang/Object;)V
      //   189: aload_3
      //   190: getstatic 223	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
      //   193: if_acmpne +8 -> 201
      //   196: aload_0
      //   197: aload_1
      //   198: invokevirtual 493	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireFailedListeners	(Lcom/google/common/util/concurrent/Service;)V
      //   201: aload_0
      //   202: getfield 77	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   205: getstatic 235	com/google/common/util/concurrent/Service$State:RUNNING	Lcom/google/common/util/concurrent/Service$State;
      //   208: invokeinterface 241 2 0
      //   213: aload_0
      //   214: getfield 112	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:numberOfServices	I
      //   217: if_icmpne +19 -> 236
      //   220: aload_0
      //   221: invokevirtual 495	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireHealthyListeners	()V
      //   224: aload_0
      //   225: getfield 47	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   228: invokevirtual 158	com/google/common/util/concurrent/Monitor:leave	()V
      //   231: aload_0
      //   232: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   235: return
      //   236: aload_0
      //   237: getfield 77	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   240: getstatic 220	com/google/common/util/concurrent/Service$State:TERMINATED	Lcom/google/common/util/concurrent/Service$State;
      //   243: invokeinterface 241 2 0
      //   248: aload_0
      //   249: getfield 77	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:states	Lcom/google/common/collect/Multiset;
      //   252: getstatic 223	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
      //   255: invokeinterface 241 2 0
      //   260: iadd
      //   261: aload_0
      //   262: getfield 112	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:numberOfServices	I
      //   265: if_icmpne -41 -> 224
      //   268: aload_0
      //   269: invokevirtual 497	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:fireStoppedListeners	()V
      //   272: goto -48 -> 224
      //   275: astore_1
      //   276: aload_0
      //   277: getfield 47	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:monitor	Lcom/google/common/util/concurrent/Monitor;
      //   280: invokevirtual 158	com/google/common/util/concurrent/Monitor:leave	()V
      //   283: aload_0
      //   284: invokevirtual 445	com/google/common/util/concurrent/ServiceManager$ServiceManagerState:executeListeners	()V
      //   287: aload_1
      //   288: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	289	0	this	ServiceManagerState
      //   0	289	1	paramService	Service
      //   0	289	2	paramState1	Service.State
      //   0	289	3	paramState2	Service.State
      //   1	54	4	bool	boolean
      //   110	6	5	localStopwatch	Stopwatch
      // Exception table:
      //   from	to	target	type
      //   25	36	275	finally
      //   59	112	275	finally
      //   120	136	275	finally
      //   136	189	275	finally
      //   189	201	275	finally
      //   201	224	275	finally
      //   236	272	275	finally
    }
    
    void tryStartTiming(Service paramService)
    {
      this.monitor.enter();
      try
      {
        if ((Stopwatch)this.startupTimers.get(paramService) == null) {
          this.startupTimers.put(paramService, Stopwatch.createStarted());
        }
        return;
      }
      finally
      {
        this.monitor.leave();
      }
    }
    
    final class AwaitHealthGuard
      extends Monitor.Guard
    {
      AwaitHealthGuard()
      {
        super();
      }
      
      public boolean isSatisfied()
      {
        return (ServiceManager.ServiceManagerState.this.states.count(Service.State.RUNNING) == ServiceManager.ServiceManagerState.this.numberOfServices) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.STOPPING)) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.TERMINATED)) || (ServiceManager.ServiceManagerState.this.states.contains(Service.State.FAILED));
      }
    }
    
    final class StoppedGuard
      extends Monitor.Guard
    {
      StoppedGuard()
      {
        super();
      }
      
      public boolean isSatisfied()
      {
        return ServiceManager.ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManager.ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManager.ServiceManagerState.this.numberOfServices;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ServiceManager
 * JD-Core Version:    0.7.0.1
 */