package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Timestamped;

public final class ReplaySubject<T>
  extends Subject<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  final SubjectSubscriptionManager<T> ssm;
  final ReplayState<T, ?> state;
  
  ReplaySubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, ReplayState<T, ?> paramReplayState)
  {
    super(paramOnSubscribe);
    this.ssm = paramSubjectSubscriptionManager;
    this.state = paramReplayState;
  }
  
  private boolean caughtUp(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    boolean bool = true;
    if (!paramSubjectObserver.caughtUp)
    {
      if (this.state.replayObserver(paramSubjectObserver))
      {
        paramSubjectObserver.caughtUp = true;
        paramSubjectObserver.index(null);
      }
      bool = false;
    }
    return bool;
  }
  
  public static <T> ReplaySubject<T> create()
  {
    return create(16);
  }
  
  public static <T> ReplaySubject<T> create(int paramInt)
  {
    UnboundedReplayState localUnboundedReplayState = new UnboundedReplayState(paramInt);
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = new ReplaySubject.1(localUnboundedReplayState);
    localSubjectSubscriptionManager.onAdded = new ReplaySubject.2(localUnboundedReplayState);
    localSubjectSubscriptionManager.onTerminated = new ReplaySubject.3(localUnboundedReplayState);
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, localUnboundedReplayState);
  }
  
  static <T> ReplaySubject<T> createUnbounded()
  {
    BoundedState localBoundedState = new BoundedState(new EmptyEvictionPolicy(), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  public static <T> ReplaySubject<T> createWithSize(int paramInt)
  {
    BoundedState localBoundedState = new BoundedState(new SizeEvictionPolicy(paramInt), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  static <T> ReplaySubject<T> createWithState(BoundedState<T> paramBoundedState, Action1<SubjectSubscriptionManager.SubjectObserver<T>> paramAction1)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = paramAction1;
    localSubjectSubscriptionManager.onAdded = new ReplaySubject.4(paramBoundedState);
    localSubjectSubscriptionManager.onTerminated = new ReplaySubject.5(paramBoundedState);
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramBoundedState);
  }
  
  public static <T> ReplaySubject<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  public static <T> ReplaySubject<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new PairEvictionPolicy(new SizeEvictionPolicy(paramInt), new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler)), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  @Beta
  public Throwable getThrowable()
  {
    NotificationLite localNotificationLite = this.ssm.nl;
    Object localObject = this.ssm.getLatest();
    if (localNotificationLite.isError(localObject)) {
      return localNotificationLite.getError(localObject);
    }
    return null;
  }
  
  @Beta
  public T getValue()
  {
    return this.state.latest();
  }
  
  @Beta
  public Object[] getValues()
  {
    Object[] arrayOfObject2 = getValues((Object[])EMPTY_ARRAY);
    Object[] arrayOfObject1 = arrayOfObject2;
    if (arrayOfObject2 == EMPTY_ARRAY) {
      arrayOfObject1 = new Object[0];
    }
    return arrayOfObject1;
  }
  
  @Beta
  public T[] getValues(T[] paramArrayOfT)
  {
    return this.state.toArray(paramArrayOfT);
  }
  
  @Beta
  public boolean hasAnyValue()
  {
    return !this.state.isEmpty();
  }
  
  @Beta
  public boolean hasCompleted()
  {
    NotificationLite localNotificationLite = this.ssm.nl;
    Object localObject = this.ssm.getLatest();
    return (localObject != null) && (!localNotificationLite.isError(localObject));
  }
  
  public boolean hasObservers()
  {
    return this.ssm.observers().length > 0;
  }
  
  @Beta
  public boolean hasThrowable()
  {
    return this.ssm.nl.isError(this.ssm.getLatest());
  }
  
  @Beta
  public boolean hasValue()
  {
    return hasAnyValue();
  }
  
  public void onCompleted()
  {
    if (this.ssm.active)
    {
      this.state.complete();
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.terminate(NotificationLite.instance().completed());
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onCompleted();
        }
        i += 1;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.ssm.active)
    {
      this.state.error(paramThrowable);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.terminate(NotificationLite.instance().error(paramThrowable));
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      Object localObject2;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        if (i >= j) {
          break label123;
        }
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        localObject2 = localObject1;
        try
        {
          if (caughtUp(localSubjectObserver))
          {
            localSubjectObserver.onError(paramThrowable);
            localObject2 = localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((List)localObject2).add(localThrowable);
          }
        }
        i += 1;
      }
      label123:
      Exceptions.throwIfAny(localObject1);
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.ssm.active)
    {
      this.state.next(paramT);
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = this.ssm.observers();
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        SubjectSubscriptionManager.SubjectObserver localSubjectObserver = arrayOfSubjectObserver[i];
        if (caughtUp(localSubjectObserver)) {
          localSubjectObserver.onNext(paramT);
        }
        i += 1;
      }
    }
  }
  
  @Beta
  public int size()
  {
    return this.state.size();
  }
  
  int subscriberCount()
  {
    return ((SubjectSubscriptionManager.State)this.ssm.get()).observers.length;
  }
  
  static final class AddTimestamped
    implements Func1<Object, Object>
  {
    final Scheduler scheduler;
    
    public AddTimestamped(Scheduler paramScheduler)
    {
      this.scheduler = paramScheduler;
    }
    
    public Object call(Object paramObject)
    {
      return new Timestamped(this.scheduler.now(), paramObject);
    }
  }
  
  static final class BoundedState<T>
    implements ReplaySubject.ReplayState<T, ReplaySubject.NodeList.Node<Object>>
  {
    final Func1<Object, Object> enterTransform;
    final ReplaySubject.EvictionPolicy evictionPolicy;
    final Func1<Object, Object> leaveTransform;
    final ReplaySubject.NodeList<Object> list = new ReplaySubject.NodeList();
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile ReplaySubject.NodeList.Node<Object> tail = this.list.tail;
    volatile boolean terminated;
    
    public BoundedState(ReplaySubject.EvictionPolicy paramEvictionPolicy, Func1<Object, Object> paramFunc11, Func1<Object, Object> paramFunc12)
    {
      this.evictionPolicy = paramEvictionPolicy;
      this.enterTransform = paramFunc11;
      this.leaveTransform = paramFunc12;
    }
    
    public void accept(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode)
    {
      this.nl.accept(paramObserver, this.leaveTransform.call(paramNode.value));
    }
    
    public void acceptTest(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode, long paramLong)
    {
      paramNode = paramNode.value;
      if (!this.evictionPolicy.test(paramNode, paramLong)) {
        this.nl.accept(paramObserver, this.leaveTransform.call(paramNode));
      }
    }
    
    public void complete()
    {
      if (!this.terminated)
      {
        this.terminated = true;
        this.list.addLast(this.enterTransform.call(this.nl.completed()));
        this.evictionPolicy.evictFinal(this.list);
        this.tail = this.list.tail;
      }
    }
    
    public void error(Throwable paramThrowable)
    {
      if (!this.terminated)
      {
        this.terminated = true;
        this.list.addLast(this.enterTransform.call(this.nl.error(paramThrowable)));
        this.evictionPolicy.evictFinal(this.list);
        this.tail = this.list.tail;
      }
    }
    
    public ReplaySubject.NodeList.Node<Object> head()
    {
      return this.list.head;
    }
    
    public boolean isEmpty()
    {
      Object localObject = head().next;
      if (localObject == null) {}
      do
      {
        return true;
        localObject = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject).value);
      } while ((this.nl.isError(localObject)) || (this.nl.isCompleted(localObject)));
      return false;
    }
    
    public T latest()
    {
      Object localObject1 = head().next;
      if (localObject1 == null) {}
      Object localObject2;
      do
      {
        return null;
        localObject2 = null;
        while (localObject1 != tail())
        {
          ReplaySubject.NodeList.Node localNode = ((ReplaySubject.NodeList.Node)localObject1).next;
          localObject2 = localObject1;
          localObject1 = localNode;
        }
        localObject1 = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject1).value);
        if ((!this.nl.isError(localObject1)) && (!this.nl.isCompleted(localObject1))) {
          break;
        }
      } while (localObject2 == null);
      localObject1 = this.leaveTransform.call(localObject2.value);
      return this.nl.getValue(localObject1);
      return this.nl.getValue(localObject1);
    }
    
    public void next(T paramT)
    {
      if (!this.terminated)
      {
        this.list.addLast(this.enterTransform.call(this.nl.next(paramT)));
        this.evictionPolicy.evict(this.list);
        this.tail = this.list.tail;
      }
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      try
      {
        paramSubjectObserver.first = false;
        if (paramSubjectObserver.emitting) {
          return false;
        }
        paramSubjectObserver.index(replayObserverFromIndex((ReplaySubject.NodeList.Node)paramSubjectObserver.index(), paramSubjectObserver));
        return true;
      }
      finally {}
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndex(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      while (paramNode != tail())
      {
        accept(paramSubjectObserver, paramNode.next);
        paramNode = paramNode.next;
      }
      return paramNode;
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndexTest(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      while (paramNode != tail())
      {
        acceptTest(paramSubjectObserver, paramNode.next, paramLong);
        paramNode = paramNode.next;
      }
      return paramNode;
    }
    
    public int size()
    {
      Object localObject1 = head();
      Object localObject2 = ((ReplaySubject.NodeList.Node)localObject1).next;
      int i = 0;
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      while (localObject1 != null)
      {
        localObject3 = ((ReplaySubject.NodeList.Node)localObject1).next;
        i += 1;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
      }
      int j = i;
      if (((ReplaySubject.NodeList.Node)localObject3).value != null)
      {
        localObject1 = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject3).value);
        j = i;
        if (localObject1 != null) {
          if (!this.nl.isError(localObject1))
          {
            j = i;
            if (!this.nl.isCompleted(localObject1)) {}
          }
          else
          {
            j = i - 1;
          }
        }
      }
      return j;
    }
    
    public ReplaySubject.NodeList.Node<Object> tail()
    {
      return this.tail;
    }
    
    public boolean terminated()
    {
      return this.terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      ArrayList localArrayList = new ArrayList();
      for (ReplaySubject.NodeList.Node localNode = head().next;; localNode = localNode.next)
      {
        Object localObject;
        if (localNode != null)
        {
          localObject = this.leaveTransform.call(localNode.value);
          if ((localNode.next != null) || ((!this.nl.isError(localObject)) && (!this.nl.isCompleted(localObject)))) {}
        }
        else
        {
          return localArrayList.toArray(paramArrayOfT);
        }
        localArrayList.add(localObject);
      }
    }
  }
  
  static final class DefaultOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final ReplaySubject.BoundedState<T> state;
    
    public DefaultOnAdd(ReplaySubject.BoundedState<T> paramBoundedState)
    {
      this.state = paramBoundedState;
    }
    
    public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
    {
      paramSubjectObserver.index(this.state.replayObserverFromIndex(this.state.head(), paramSubjectObserver));
    }
  }
  
  static final class EmptyEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    public void evict(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public boolean test(Object paramObject, long paramLong)
    {
      return true;
    }
  }
  
  static abstract interface EvictionPolicy
  {
    public abstract void evict(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract void evictFinal(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract boolean test(Object paramObject, long paramLong);
  }
  
  static final class NodeList<T>
  {
    final Node<T> head = new Node(null);
    int size;
    Node<T> tail = this.head;
    
    public void addLast(T paramT)
    {
      Node localNode = this.tail;
      paramT = new Node(paramT);
      localNode.next = paramT;
      this.tail = paramT;
      this.size += 1;
    }
    
    public void clear()
    {
      this.tail = this.head;
      this.size = 0;
    }
    
    public boolean isEmpty()
    {
      return this.size == 0;
    }
    
    public T removeFirst()
    {
      if (this.head.next == null) {
        throw new IllegalStateException("Empty!");
      }
      Node localNode = this.head.next;
      this.head.next = localNode.next;
      if (this.head.next == null) {
        this.tail = this.head;
      }
      this.size -= 1;
      return localNode.value;
    }
    
    public int size()
    {
      return this.size;
    }
    
    static final class Node<T>
    {
      volatile Node<T> next;
      final T value;
      
      Node(T paramT)
      {
        this.value = paramT;
      }
    }
  }
  
  static final class PairEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final ReplaySubject.EvictionPolicy first;
    final ReplaySubject.EvictionPolicy second;
    
    public PairEvictionPolicy(ReplaySubject.EvictionPolicy paramEvictionPolicy1, ReplaySubject.EvictionPolicy paramEvictionPolicy2)
    {
      this.first = paramEvictionPolicy1;
      this.second = paramEvictionPolicy2;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      this.first.evict(paramNodeList);
      this.second.evict(paramNodeList);
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      this.first.evictFinal(paramNodeList);
      this.second.evictFinal(paramNodeList);
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return (this.first.test(paramObject, paramLong)) || (this.second.test(paramObject, paramLong));
    }
  }
  
  static final class RemoveTimestamped
    implements Func1<Object, Object>
  {
    public Object call(Object paramObject)
    {
      return ((Timestamped)paramObject).getValue();
    }
  }
  
  static abstract interface ReplayState<T, I>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract boolean isEmpty();
    
    public abstract T latest();
    
    public abstract void next(T paramT);
    
    public abstract boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndex(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndexTest(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong);
    
    public abstract int size();
    
    public abstract boolean terminated();
    
    public abstract T[] toArray(T[] paramArrayOfT);
  }
  
  static final class SizeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final int maxSize;
    
    public SizeEvictionPolicy(int paramInt)
    {
      this.maxSize = paramInt;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      while (paramNodeList.size() > this.maxSize) {
        paramNodeList.removeFirst();
      }
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      while (paramNodeList.size() > this.maxSize + 1) {
        paramNodeList.removeFirst();
      }
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return false;
    }
  }
  
  static final class TimeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final long maxAgeMillis;
    final Scheduler scheduler;
    
    public TimeEvictionPolicy(long paramLong, Scheduler paramScheduler)
    {
      this.maxAgeMillis = paramLong;
      this.scheduler = paramScheduler;
    }
    
    public void evict(ReplaySubject.NodeList<Object> paramNodeList)
    {
      long l = this.scheduler.now();
      while ((!paramNodeList.isEmpty()) && (test(paramNodeList.head.next.value, l))) {
        paramNodeList.removeFirst();
      }
    }
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
    {
      long l = this.scheduler.now();
      while ((paramNodeList.size > 1) && (test(paramNodeList.head.next.value, l))) {
        paramNodeList.removeFirst();
      }
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return ((Timestamped)paramObject).getTimestampMillis() <= paramLong - this.maxAgeMillis;
    }
  }
  
  static final class TimedOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final Scheduler scheduler;
    final ReplaySubject.BoundedState<T> state;
    
    public TimedOnAdd(ReplaySubject.BoundedState<T> paramBoundedState, Scheduler paramScheduler)
    {
      this.state = paramBoundedState;
      this.scheduler = paramScheduler;
    }
    
    public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
    {
      if (!this.state.terminated) {}
      for (ReplaySubject.NodeList.Node localNode = this.state.replayObserverFromIndexTest(this.state.head(), paramSubjectObserver, this.scheduler.now());; localNode = this.state.replayObserverFromIndex(this.state.head(), paramSubjectObserver))
      {
        paramSubjectObserver.index(localNode);
        return;
      }
    }
  }
  
  static final class UnboundedReplayState<T>
    extends AtomicInteger
    implements ReplaySubject.ReplayState<T, Integer>
  {
    private final ArrayList<Object> list;
    private final NotificationLite<T> nl = NotificationLite.instance();
    private volatile boolean terminated;
    
    public UnboundedReplayState(int paramInt)
    {
      this.list = new ArrayList(paramInt);
    }
    
    public void accept(Observer<? super T> paramObserver, int paramInt)
    {
      this.nl.accept(paramObserver, this.list.get(paramInt));
    }
    
    public void complete()
    {
      if (!this.terminated)
      {
        this.terminated = true;
        this.list.add(this.nl.completed());
        getAndIncrement();
      }
    }
    
    public void error(Throwable paramThrowable)
    {
      if (!this.terminated)
      {
        this.terminated = true;
        this.list.add(this.nl.error(paramThrowable));
        getAndIncrement();
      }
    }
    
    public boolean isEmpty()
    {
      return size() == 0;
    }
    
    public T latest()
    {
      Object localObject2 = null;
      int i = get();
      Object localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = this.list.get(i - 1);
        if ((!this.nl.isCompleted(localObject1)) && (!this.nl.isError(localObject1))) {
          break label73;
        }
        localObject1 = localObject2;
        if (i > 1) {
          localObject1 = this.nl.getValue(this.list.get(i - 2));
        }
      }
      return localObject1;
      label73:
      return this.nl.getValue(localObject1);
    }
    
    public void next(T paramT)
    {
      if (!this.terminated)
      {
        this.list.add(this.nl.next(paramT));
        getAndIncrement();
      }
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      try
      {
        paramSubjectObserver.first = false;
        if (paramSubjectObserver.emitting) {
          return false;
        }
        Integer localInteger = (Integer)paramSubjectObserver.index();
        if (localInteger != null)
        {
          paramSubjectObserver.index(Integer.valueOf(replayObserverFromIndex(localInteger, paramSubjectObserver).intValue()));
          return true;
        }
      }
      finally {}
      throw new IllegalStateException("failed to find lastEmittedLink for: " + paramSubjectObserver);
    }
    
    public Integer replayObserverFromIndex(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      int i = paramInteger.intValue();
      while (i < get())
      {
        accept(paramSubjectObserver, i);
        i += 1;
      }
      return Integer.valueOf(i);
    }
    
    public Integer replayObserverFromIndexTest(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      return replayObserverFromIndex(paramInteger, paramSubjectObserver);
    }
    
    public int size()
    {
      int j = get();
      int i = j;
      if (j > 0)
      {
        Object localObject = this.list.get(j - 1);
        if (!this.nl.isCompleted(localObject))
        {
          i = j;
          if (!this.nl.isError(localObject)) {}
        }
        else
        {
          i = j - 1;
        }
      }
      return i;
    }
    
    public boolean terminated()
    {
      return this.terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      int i = 0;
      int j = size();
      if (j > 0)
      {
        if (j <= paramArrayOfT.length) {
          break label81;
        }
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
      }
      label81:
      for (;;)
      {
        if (i < j)
        {
          paramArrayOfT[i] = this.list.get(i);
          i += 1;
        }
        else
        {
          if (paramArrayOfT.length > j) {
            paramArrayOfT[j] = null;
          }
          return paramArrayOfT;
          if (paramArrayOfT.length > 0) {
            paramArrayOfT[0] = null;
          }
          return paramArrayOfT;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.subjects.ReplaySubject
 * JD-Core Version:    0.7.0.1
 */