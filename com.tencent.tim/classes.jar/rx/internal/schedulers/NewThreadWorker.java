package rx.internal.schedulers;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class NewThreadWorker
  extends Scheduler.Worker
  implements Subscription
{
  private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> EXECUTORS = new ConcurrentHashMap();
  private static final String FREQUENCY_KEY = "rx.scheduler.jdk6.purge-frequency-millis";
  private static final AtomicReference<ScheduledExecutorService> PURGE = new AtomicReference();
  private static final String PURGE_FORCE_KEY = "rx.scheduler.jdk6.purge-force";
  public static final int PURGE_FREQUENCY = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
  private static final String PURGE_THREAD_PREFIX = "RxSchedulerPurge-";
  private static final Object SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
  private static final boolean SHOULD_TRY_ENABLE_CANCEL_POLICY;
  private static volatile Object cachedSetRemoveOnCancelPolicyMethod;
  private final ScheduledExecutorService executor;
  volatile boolean isUnsubscribed;
  private final RxJavaSchedulersHook schedulersHook;
  
  static
  {
    boolean bool = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
    int i = PlatformDependent.getAndroidApiVersion();
    if ((!bool) && ((i == 0) || (i >= 21))) {}
    for (bool = true;; bool = false)
    {
      SHOULD_TRY_ENABLE_CANCEL_POLICY = bool;
      SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED = new Object();
      return;
    }
  }
  
  public NewThreadWorker(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    if ((!tryEnableCancelPolicy(paramThreadFactory)) && ((paramThreadFactory instanceof ScheduledThreadPoolExecutor))) {
      registerExecutor((ScheduledThreadPoolExecutor)paramThreadFactory);
    }
    this.schedulersHook = RxJavaPlugins.getInstance().getSchedulersHook();
    this.executor = paramThreadFactory;
  }
  
  public static void deregisterExecutor(ScheduledExecutorService paramScheduledExecutorService)
  {
    EXECUTORS.remove(paramScheduledExecutorService);
  }
  
  static Method findSetRemoveOnCancelPolicyMethod(ScheduledExecutorService paramScheduledExecutorService)
  {
    paramScheduledExecutorService = paramScheduledExecutorService.getClass().getMethods();
    int j = paramScheduledExecutorService.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramScheduledExecutorService[i];
      if (localMethod.getName().equals("setRemoveOnCancelPolicy"))
      {
        Class[] arrayOfClass = localMethod.getParameterTypes();
        if ((arrayOfClass.length == 1) && (arrayOfClass[0] == Boolean.TYPE)) {
          return localMethod;
        }
      }
      i += 1;
    }
    return null;
  }
  
  static void purgeExecutors()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = EXECUTORS.keySet().iterator();
        if (localIterator.hasNext())
        {
          ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)localIterator.next();
          if (!localScheduledThreadPoolExecutor.isShutdown()) {
            localScheduledThreadPoolExecutor.purge();
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        RxJavaPlugins.getInstance().getErrorHandler().handleError(localThrowable);
      }
      localThrowable.remove();
    }
  }
  
  public static void registerExecutor(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor)
  {
    for (;;)
    {
      if ((ScheduledExecutorService)PURGE.get() != null) {}
      ScheduledExecutorService localScheduledExecutorService;
      for (;;)
      {
        EXECUTORS.putIfAbsent(paramScheduledThreadPoolExecutor, paramScheduledThreadPoolExecutor);
        return;
        localScheduledExecutorService = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
        if (!PURGE.compareAndSet(null, localScheduledExecutorService)) {
          break;
        }
        localScheduledExecutorService.scheduleAtFixedRate(new NewThreadWorker.1(), PURGE_FREQUENCY, PURGE_FREQUENCY, TimeUnit.MILLISECONDS);
      }
      localScheduledExecutorService.shutdownNow();
    }
  }
  
  public static boolean tryEnableCancelPolicy(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (SHOULD_TRY_ENABLE_CANCEL_POLICY)
    {
      Object localObject1;
      Object localObject2;
      if ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor))
      {
        localObject1 = cachedSetRemoveOnCancelPolicyMethod;
        if (localObject1 == SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED) {
          return false;
        }
        if (localObject1 == null)
        {
          localObject1 = findSetRemoveOnCancelPolicyMethod(paramScheduledExecutorService);
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            cachedSetRemoveOnCancelPolicyMethod = localObject2;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label102;
        }
        try
        {
          ((Method)localObject1).invoke(paramScheduledExecutorService, new Object[] { Boolean.valueOf(true) });
          return true;
        }
        catch (Exception paramScheduledExecutorService)
        {
          RxJavaPlugins.getInstance().getErrorHandler().handleError(paramScheduledExecutorService);
        }
        localObject2 = SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
        break;
        localObject1 = (Method)localObject1;
        continue;
        localObject1 = findSetRemoveOnCancelPolicyMethod(paramScheduledExecutorService);
      }
    }
    label102:
    return false;
  }
  
  public boolean isUnsubscribed()
  {
    return this.isUnsubscribed;
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    return schedule(paramAction0, 0L, null);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.isUnsubscribed) {
      return Subscriptions.unsubscribed();
    }
    return scheduleActual(paramAction0, paramLong, paramTimeUnit);
  }
  
  public ScheduledAction scheduleActual(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    ScheduledAction localScheduledAction = new ScheduledAction(this.schedulersHook.onSchedule(paramAction0));
    if (paramLong <= 0L) {}
    for (paramAction0 = this.executor.submit(localScheduledAction);; paramAction0 = this.executor.schedule(localScheduledAction, paramLong, paramTimeUnit))
    {
      localScheduledAction.add(paramAction0);
      return localScheduledAction;
    }
  }
  
  public ScheduledAction scheduleActual(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit, SubscriptionList paramSubscriptionList)
  {
    ScheduledAction localScheduledAction = new ScheduledAction(this.schedulersHook.onSchedule(paramAction0), paramSubscriptionList);
    paramSubscriptionList.add(localScheduledAction);
    if (paramLong <= 0L) {}
    for (paramAction0 = this.executor.submit(localScheduledAction);; paramAction0 = this.executor.schedule(localScheduledAction, paramLong, paramTimeUnit))
    {
      localScheduledAction.add(paramAction0);
      return localScheduledAction;
    }
  }
  
  public ScheduledAction scheduleActual(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit, CompositeSubscription paramCompositeSubscription)
  {
    ScheduledAction localScheduledAction = new ScheduledAction(this.schedulersHook.onSchedule(paramAction0), paramCompositeSubscription);
    paramCompositeSubscription.add(localScheduledAction);
    if (paramLong <= 0L) {}
    for (paramAction0 = this.executor.submit(localScheduledAction);; paramAction0 = this.executor.schedule(localScheduledAction, paramLong, paramTimeUnit))
    {
      localScheduledAction.add(paramAction0);
      return localScheduledAction;
    }
  }
  
  public void unsubscribe()
  {
    this.isUnsubscribed = true;
    this.executor.shutdownNow();
    deregisterExecutor(this.executor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.schedulers.NewThreadWorker
 * JD-Core Version:    0.7.0.1
 */