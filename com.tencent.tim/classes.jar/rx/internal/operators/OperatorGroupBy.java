package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.Subscriptions;

public final class OperatorGroupBy<T, K, V>
  implements Observable.Operator<GroupedObservable<K, V>, T>
{
  final int bufferSize;
  final boolean delayError;
  final Func1<? super T, ? extends K> keySelector;
  final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1)
  {
    this(paramFunc1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false);
  }
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, RxRingBuffer.SIZE, false);
  }
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, int paramInt, boolean paramBoolean)
  {
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> paramSubscriber)
  {
    GroupBySubscriber localGroupBySubscriber = new GroupBySubscriber(paramSubscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError);
    paramSubscriber.add(Subscriptions.create(new OperatorGroupBy.1(this, localGroupBySubscriber)));
    paramSubscriber.setProducer(localGroupBySubscriber.producer);
    return localGroupBySubscriber;
  }
  
  public static final class GroupByProducer
    implements Producer
  {
    final OperatorGroupBy.GroupBySubscriber<?, ?, ?> parent;
    
    public GroupByProducer(OperatorGroupBy.GroupBySubscriber<?, ?, ?> paramGroupBySubscriber)
    {
      this.parent = paramGroupBySubscriber;
    }
    
    public void request(long paramLong)
    {
      this.parent.requestMore(paramLong);
    }
  }
  
  public static final class GroupBySubscriber<T, K, V>
    extends Subscriber<T>
  {
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> CANCELLED;
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> GROUP_COUNT = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "groupCount");
    static final Object NULL_KEY = new Object();
    static final AtomicLongFieldUpdater<GroupBySubscriber> REQUESTED;
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "wip");
    final Subscriber<? super GroupedObservable<K, V>> actual;
    final int bufferSize;
    volatile int cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    volatile int groupCount;
    final Map<Object, OperatorGroupBy.GroupedUnicast<K, V>> groups;
    final Func1<? super T, ? extends K> keySelector;
    final OperatorGroupBy.GroupByProducer producer;
    final Queue<GroupedObservable<K, V>> queue;
    volatile long requested;
    final ProducerArbiter s;
    final Func1<? super T, ? extends V> valueSelector;
    volatile int wip;
    
    static
    {
      CANCELLED = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "cancelled");
      REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "requested");
    }
    
    public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, int paramInt, boolean paramBoolean)
    {
      this.actual = paramSubscriber;
      this.keySelector = paramFunc1;
      this.valueSelector = paramFunc11;
      this.bufferSize = paramInt;
      this.delayError = paramBoolean;
      this.groups = new ConcurrentHashMap();
      this.queue = new ConcurrentLinkedQueue();
      GROUP_COUNT.lazySet(this, 1);
      this.s = new ProducerArbiter();
      this.s.request(paramInt);
      this.producer = new OperatorGroupBy.GroupByProducer(this);
    }
    
    public void cancel()
    {
      if ((CANCELLED.compareAndSet(this, 0, 1)) && (GROUP_COUNT.decrementAndGet(this) == 0)) {
        unsubscribe();
      }
    }
    
    public void cancel(K paramK)
    {
      if (paramK != null) {}
      for (;;)
      {
        if ((this.groups.remove(paramK) != null) && (GROUP_COUNT.decrementAndGet(this) == 0)) {
          unsubscribe();
        }
        return;
        paramK = NULL_KEY;
      }
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Queue<?> paramQueue)
    {
      if (paramBoolean1)
      {
        Throwable localThrowable = this.error;
        if (localThrowable != null)
        {
          errorAll(paramSubscriber, paramQueue, localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramSubscriber = new ArrayList(this.groups.values());
          this.groups.clear();
          paramSubscriber = paramSubscriber.iterator();
          while (paramSubscriber.hasNext()) {
            ((OperatorGroupBy.GroupedUnicast)paramSubscriber.next()).onComplete();
          }
          this.actual.onCompleted();
          return true;
        }
      }
      return false;
    }
    
    void drain()
    {
      if (WIP.getAndIncrement(this) != 0) {
        return;
      }
      Queue localQueue = this.queue;
      Subscriber localSubscriber = this.actual;
      int i = 1;
      label25:
      long l2;
      int j;
      if (!checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, localQueue))
      {
        l2 = this.requested;
        if (l2 != 9223372036854775807L) {
          break label164;
        }
        j = 1;
      }
      label64:
      for (long l1 = 0L;; l1 -= 1L)
      {
        boolean bool2;
        GroupedObservable localGroupedObservable;
        if (l2 != 0L)
        {
          bool2 = this.done;
          localGroupedObservable = (GroupedObservable)localQueue.poll();
          if (localGroupedObservable != null) {
            break label169;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          if (checkTerminated(bool2, bool1, localSubscriber, localQueue)) {
            break label173;
          }
          if (!bool1) {
            break label175;
          }
          if (l1 != 0L)
          {
            if (j == 0) {
              REQUESTED.addAndGet(this, l1);
            }
            this.s.request(-l1);
          }
          i = WIP.addAndGet(this, -i);
          if (i == 0) {
            break;
          }
          break label25;
          break;
          j = 0;
          break label64;
        }
        break;
        localSubscriber.onNext(localGroupedObservable);
        l2 -= 1L;
      }
    }
    
    void errorAll(Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Queue<?> paramQueue, Throwable paramThrowable)
    {
      paramQueue.clear();
      paramQueue = new ArrayList(this.groups.values());
      this.groups.clear();
      paramQueue = paramQueue.iterator();
      while (paramQueue.hasNext()) {
        ((OperatorGroupBy.GroupedUnicast)paramQueue.next()).onError(paramThrowable);
      }
      paramSubscriber.onError(paramThrowable);
    }
    
    public void onCompleted()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      GROUP_COUNT.decrementAndGet(this);
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
        return;
      }
      this.error = paramThrowable;
      this.done = true;
      GROUP_COUNT.decrementAndGet(this);
      drain();
    }
    
    public void onNext(T paramT)
    {
      if (this.done) {
        return;
      }
      Queue localQueue = this.queue;
      Subscriber localSubscriber = this.actual;
      for (;;)
      {
        OperatorGroupBy.GroupedUnicast localGroupedUnicast;
        try
        {
          Object localObject2 = this.keySelector.call(paramT);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            localGroupedUnicast = (OperatorGroupBy.GroupedUnicast)this.groups.get(localObject1);
            if (localGroupedUnicast != null) {
              break label189;
            }
            if (this.cancelled != 0) {
              break;
            }
            localObject2 = OperatorGroupBy.GroupedUnicast.createWith(localObject2, this.bufferSize, this, this.delayError);
            this.groups.put(localObject1, localObject2);
            GROUP_COUNT.getAndIncrement(this);
            i = 0;
            localQueue.offer(localObject2);
            drain();
            localObject1 = localObject2;
          }
        }
        catch (Throwable paramT)
        {
          try
          {
            paramT = this.valueSelector.call(paramT);
            localObject1.onNext(paramT);
            if (i == 0) {
              break;
            }
            this.s.request(1L);
            return;
          }
          catch (Throwable paramT)
          {
            unsubscribe();
            errorAll(localSubscriber, localQueue, paramT);
            return;
          }
          paramT = paramT;
          unsubscribe();
          errorAll(localSubscriber, localQueue, paramT);
          return;
        }
        Object localObject1 = NULL_KEY;
        continue;
        label189:
        int i = 1;
        localObject1 = localGroupedUnicast;
      }
    }
    
    public void requestMore(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
      }
      BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
      drain();
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.s.setProducer(paramProducer);
    }
  }
  
  static final class GroupedUnicast<K, T>
    extends GroupedObservable<K, T>
  {
    final OperatorGroupBy.State<T, K> state;
    
    protected GroupedUnicast(K paramK, OperatorGroupBy.State<T, K> paramState)
    {
      super(paramState);
      this.state = paramState;
    }
    
    public static <T, K> GroupedUnicast<K, T> createWith(K paramK, int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, boolean paramBoolean)
    {
      return new GroupedUnicast(paramK, new OperatorGroupBy.State(paramInt, paramGroupBySubscriber, paramK, paramBoolean));
    }
    
    public void onComplete()
    {
      this.state.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.state.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.state.onNext(paramT);
    }
  }
  
  static final class State<T, K>
    extends AtomicInteger
    implements Observable.OnSubscribe<T>, Producer, Subscription
  {
    static final AtomicReferenceFieldUpdater<State, Subscriber> ACTUAL = AtomicReferenceFieldUpdater.newUpdater(State.class, Subscriber.class, "actual");
    static final AtomicIntegerFieldUpdater<State> CANCELLED;
    static final AtomicIntegerFieldUpdater<State> ONCE = AtomicIntegerFieldUpdater.newUpdater(State.class, "once");
    static final AtomicLongFieldUpdater<State> REQUESTED = AtomicLongFieldUpdater.newUpdater(State.class, "requested");
    private static final long serialVersionUID = -3852313036005250360L;
    volatile Subscriber<? super T> actual;
    volatile int cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    volatile int once;
    final OperatorGroupBy.GroupBySubscriber<?, K, T> parent;
    final Queue<Object> queue = new ConcurrentLinkedQueue();
    volatile long requested;
    
    static
    {
      CANCELLED = AtomicIntegerFieldUpdater.newUpdater(State.class, "cancelled");
    }
    
    public State(int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, K paramK, boolean paramBoolean)
    {
      this.parent = paramGroupBySubscriber;
      this.key = paramK;
      this.delayError = paramBoolean;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      if (ONCE.compareAndSet(this, 0, 1))
      {
        paramSubscriber.add(this);
        paramSubscriber.setProducer(this);
        ACTUAL.lazySet(this, paramSubscriber);
        drain();
        return;
      }
      paramSubscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, boolean paramBoolean3)
    {
      if (this.cancelled != 0)
      {
        this.queue.clear();
        this.parent.cancel(this.key);
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable;
        if (paramBoolean3)
        {
          if (paramBoolean2)
          {
            localThrowable = this.error;
            if (localThrowable != null)
            {
              paramSubscriber.onError(localThrowable);
              return true;
            }
            paramSubscriber.onCompleted();
            return true;
          }
        }
        else
        {
          localThrowable = this.error;
          if (localThrowable != null)
          {
            this.queue.clear();
            paramSubscriber.onError(localThrowable);
            return true;
          }
          if (paramBoolean2)
          {
            paramSubscriber.onCompleted();
            return true;
          }
        }
      }
      return false;
    }
    
    void drain()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      Queue localQueue = this.queue;
      boolean bool2 = this.delayError;
      Subscriber localSubscriber = this.actual;
      NotificationLite localNotificationLite = NotificationLite.instance();
      int i = 1;
      label33:
      label77:
      label223:
      for (;;)
      {
        long l2;
        int j;
        if (localSubscriber != null)
        {
          if (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, bool2)) {
            break;
          }
          l2 = this.requested;
          if (l2 != 9223372036854775807L) {
            break label186;
          }
          j = 1;
        }
        for (long l1 = 0L;; l1 -= 1L)
        {
          boolean bool3;
          Object localObject;
          if (l2 != 0L)
          {
            bool3 = this.done;
            localObject = localQueue.poll();
            if (localObject != null) {
              break label191;
            }
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            if (checkTerminated(bool3, bool1, localSubscriber, bool2)) {
              break label194;
            }
            if (!bool1) {
              break label196;
            }
            if (l1 != 0L)
            {
              if (j == 0) {
                REQUESTED.addAndGet(this, l1);
              }
              this.parent.s.request(-l1);
            }
            i = addAndGet(-i);
            if (i == 0) {
              break;
            }
            if (localSubscriber != null) {
              break label223;
            }
            localSubscriber = this.actual;
            break label33;
            j = 0;
            break label77;
          }
          break;
          localSubscriber.onNext(localNotificationLite.getValue(localObject));
          l2 -= 1L;
        }
      }
    }
    
    public boolean isUnsubscribed()
    {
      return this.cancelled != 0;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
    }
    
    public void onNext(T paramT)
    {
      if (paramT == null)
      {
        this.error = new NullPointerException();
        this.done = true;
      }
      for (;;)
      {
        drain();
        return;
        this.queue.offer(NotificationLite.instance().next(paramT));
      }
    }
    
    public void request(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("n >= required but it was " + paramLong);
      }
      if (paramLong != 0L)
      {
        BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
        drain();
      }
    }
    
    public void unsubscribe()
    {
      if ((CANCELLED.compareAndSet(this, 0, 1)) && (getAndIncrement() == 0)) {
        this.parent.cancel(this.key);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy
 * JD-Core Version:    0.7.0.1
 */