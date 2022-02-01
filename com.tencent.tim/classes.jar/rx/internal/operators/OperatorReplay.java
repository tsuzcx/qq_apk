package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T>
  extends ConnectableObservable<T>
{
  static final Func0 DEFAULT_UNBOUNDED_FACTORY = new OperatorReplay.1();
  final Func0<? extends ReplayBuffer<T>> bufferFactory;
  final AtomicReference<ReplaySubscriber<T>> current;
  final Observable<? extends T> source;
  
  private OperatorReplay(Observable.OnSubscribe<T> paramOnSubscribe, Observable<? extends T> paramObservable, AtomicReference<ReplaySubscriber<T>> paramAtomicReference, Func0<? extends ReplayBuffer<T>> paramFunc0)
  {
    super(paramOnSubscribe);
    this.source = paramObservable;
    this.current = paramAtomicReference;
    this.bufferFactory = paramFunc0;
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable)
  {
    return create(paramObservable, DEFAULT_UNBOUNDED_FACTORY);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt == 2147483647) {
      return create(paramObservable);
    }
    return create(paramObservable, new OperatorReplay.5(paramInt));
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(paramObservable, paramLong, paramTimeUnit, paramScheduler, 2147483647);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return create(paramObservable, new OperatorReplay.6(paramInt, paramTimeUnit.toMillis(paramLong), paramScheduler));
  }
  
  static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, Func0<? extends ReplayBuffer<T>> paramFunc0)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return new OperatorReplay(new OperatorReplay.7(localAtomicReference, paramFunc0), paramObservable, localAtomicReference, paramFunc0);
  }
  
  public static <T, U, R> Observable<R> multicastSelector(Func0<? extends ConnectableObservable<U>> paramFunc0, Func1<? super Observable<U>, ? extends Observable<R>> paramFunc1)
  {
    return Observable.create(new OperatorReplay.2(paramFunc0, paramFunc1));
  }
  
  public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> paramConnectableObservable, Scheduler paramScheduler)
  {
    return new OperatorReplay.4(new OperatorReplay.3(paramConnectableObservable.observeOn(paramScheduler)), paramConnectableObservable);
  }
  
  public void connect(Action1<? super Subscription> paramAction1)
  {
    ReplaySubscriber localReplaySubscriber2;
    ReplaySubscriber localReplaySubscriber1;
    do
    {
      localReplaySubscriber2 = (ReplaySubscriber)this.current.get();
      if (localReplaySubscriber2 != null)
      {
        localReplaySubscriber1 = localReplaySubscriber2;
        if (!localReplaySubscriber2.isUnsubscribed()) {
          break;
        }
      }
      localReplaySubscriber1 = new ReplaySubscriber(this.current, (ReplayBuffer)this.bufferFactory.call());
      localReplaySubscriber1.init();
    } while (!this.current.compareAndSet(localReplaySubscriber2, localReplaySubscriber1));
    if ((!localReplaySubscriber1.shouldConnect.get()) && (localReplaySubscriber1.shouldConnect.compareAndSet(false, true))) {}
    for (int i = 1;; i = 0)
    {
      paramAction1.call(localReplaySubscriber1);
      if (i != 0) {
        this.source.unsafeSubscribe(localReplaySubscriber1);
      }
      return;
    }
  }
  
  static class BoundedReplayBuffer<T>
    extends AtomicReference<OperatorReplay.Node>
    implements OperatorReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    final NotificationLite<T> nl = NotificationLite.instance();
    int size;
    OperatorReplay.Node tail;
    
    public BoundedReplayBuffer()
    {
      OperatorReplay.Node localNode = new OperatorReplay.Node(null, 0L);
      this.tail = localNode;
      set(localNode);
    }
    
    final void addLast(OperatorReplay.Node paramNode)
    {
      this.tail.set(paramNode);
      this.tail = paramNode;
      this.size += 1;
    }
    
    final void collect(Collection<? super T> paramCollection)
    {
      OperatorReplay.Node localNode = (OperatorReplay.Node)get();
      for (;;)
      {
        localNode = (OperatorReplay.Node)localNode.get();
        Object localObject;
        if (localNode != null)
        {
          localObject = leaveTransform(localNode.value);
          if ((!this.nl.isCompleted(localObject)) && (!this.nl.isError(localObject))) {}
        }
        else
        {
          return;
        }
        paramCollection.add(this.nl.getValue(localObject));
      }
    }
    
    public final void complete()
    {
      Object localObject = enterTransform(this.nl.completed());
      long l = this.index + 1L;
      this.index = l;
      addLast(new OperatorReplay.Node(localObject, l));
      truncateFinal();
    }
    
    Object enterTransform(Object paramObject)
    {
      return paramObject;
    }
    
    public final void error(Throwable paramThrowable)
    {
      paramThrowable = enterTransform(this.nl.error(paramThrowable));
      long l = this.index + 1L;
      this.index = l;
      addLast(new OperatorReplay.Node(paramThrowable, l));
      truncateFinal();
    }
    
    boolean hasCompleted()
    {
      return (this.tail.value != null) && (this.nl.isCompleted(leaveTransform(this.tail.value)));
    }
    
    boolean hasError()
    {
      return (this.tail.value != null) && (this.nl.isError(leaveTransform(this.tail.value)));
    }
    
    Object leaveTransform(Object paramObject)
    {
      return paramObject;
    }
    
    public final void next(T paramT)
    {
      paramT = enterTransform(this.nl.next(paramT));
      long l = this.index + 1L;
      this.index = l;
      addLast(new OperatorReplay.Node(paramT, l));
      truncate();
    }
    
    final void removeFirst()
    {
      OperatorReplay.Node localNode = (OperatorReplay.Node)((OperatorReplay.Node)get()).get();
      if (localNode == null) {
        throw new IllegalStateException("Empty list!");
      }
      this.size -= 1;
      setFirst(localNode);
    }
    
    final void removeSome(int paramInt)
    {
      OperatorReplay.Node localNode = (OperatorReplay.Node)get();
      while (paramInt > 0)
      {
        localNode = (OperatorReplay.Node)localNode.get();
        paramInt -= 1;
        this.size -= 1;
      }
      setFirst(localNode);
    }
    
    public final void replay(OperatorReplay.InnerProducer<T> paramInnerProducer)
    {
      for (;;)
      {
        long l2;
        try
        {
          if (paramInnerProducer.emitting)
          {
            paramInnerProducer.missed = true;
            return;
          }
          paramInnerProducer.emitting = true;
          if (paramInnerProducer.isUnsubscribed()) {
            break;
          }
          l2 = paramInnerProducer.get();
          if (l2 == 9223372036854775807L)
          {
            i = 1;
            OperatorReplay.Node localNode = (OperatorReplay.Node)paramInnerProducer.index();
            Object localObject1 = localNode;
            if (localNode == null)
            {
              localObject1 = (OperatorReplay.Node)get();
              paramInnerProducer.index = localObject1;
              paramInnerProducer.addTotalRequested(((OperatorReplay.Node)localObject1).index);
            }
            if (paramInnerProducer.isUnsubscribed()) {
              break;
            }
            l1 = 0L;
            if (l2 == 0L) {
              break label252;
            }
            localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
            if (localNode == null) {
              break label252;
            }
            localObject1 = leaveTransform(localNode.value);
            try
            {
              if (!this.nl.accept(paramInnerProducer.child, localObject1)) {
                break label228;
              }
              paramInnerProducer.index = null;
              return;
            }
            catch (Throwable localThrowable2)
            {
              paramInnerProducer.index = null;
              Exceptions.throwIfFatal(localThrowable2);
              paramInnerProducer.unsubscribe();
              if (this.nl.isError(localObject1)) {
                break;
              }
            }
            if (this.nl.isCompleted(localObject1)) {
              break;
            }
            paramInnerProducer.child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable2, this.nl.getValue(localObject1)));
            return;
          }
        }
        finally {}
        int i = 0;
        continue;
        label228:
        if (paramInnerProducer.isUnsubscribed()) {
          break;
        }
        l2 -= 1L;
        long l1 = 1L + l1;
        Throwable localThrowable1 = localThrowable2;
        continue;
        label252:
        if (l1 != 0L)
        {
          paramInnerProducer.index = localThrowable1;
          if (i == 0) {
            paramInnerProducer.produced(l1);
          }
        }
        try
        {
          if (!paramInnerProducer.missed)
          {
            paramInnerProducer.emitting = false;
            return;
          }
        }
        finally {}
        paramInnerProducer.missed = false;
      }
    }
    
    final void setFirst(OperatorReplay.Node paramNode)
    {
      set(paramNode);
    }
    
    void truncate() {}
    
    void truncateFinal() {}
  }
  
  static final class InnerProducer<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    static final long UNSUBSCRIBED = -9223372036854775808L;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final OperatorReplay.ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;
    
    public InnerProducer(OperatorReplay.ReplaySubscriber<T> paramReplaySubscriber, Subscriber<? super T> paramSubscriber)
    {
      this.parent = paramReplaySubscriber;
      this.child = paramSubscriber;
      this.totalRequested = new AtomicLong();
    }
    
    void addTotalRequested(long paramLong)
    {
      long l3;
      long l1;
      do
      {
        l3 = this.totalRequested.get();
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 9223372036854775807L;
        }
      } while (!this.totalRequested.compareAndSet(l3, l1));
    }
    
    <U> U index()
    {
      return this.index;
    }
    
    public boolean isUnsubscribed()
    {
      return get() == -9223372036854775808L;
    }
    
    public long produced(long paramLong)
    {
      if (paramLong <= 0L) {
        throw new IllegalArgumentException("Cant produce zero or less");
      }
      long l1;
      long l2;
      do
      {
        l1 = get();
        if (l1 == -9223372036854775808L) {
          return -9223372036854775808L;
        }
        l2 = l1 - paramLong;
        if (l2 < 0L) {
          throw new IllegalStateException("More produced (" + paramLong + ") than requested (" + l1 + ")");
        }
      } while (!compareAndSet(l1, l2));
      return l2;
    }
    
    public void request(long paramLong)
    {
      if (paramLong < 0L) {
        return;
      }
      long l3;
      long l1;
      do
      {
        l3 = get();
        if ((l3 == -9223372036854775808L) || ((l3 >= 0L) && (paramLong == 0L))) {
          break;
        }
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 9223372036854775807L;
        }
      } while (!compareAndSet(l3, l1));
      addTotalRequested(paramLong);
      this.parent.manageRequests();
      this.parent.buffer.replay(this);
    }
    
    public void unsubscribe()
    {
      if ((get() != -9223372036854775808L) && (getAndSet(-9223372036854775808L) != -9223372036854775808L))
      {
        this.parent.remove(this);
        this.parent.manageRequests();
      }
    }
  }
  
  static final class Node
    extends AtomicReference<Node>
  {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;
    
    public Node(Object paramObject, long paramLong)
    {
      this.value = paramObject;
      this.index = paramLong;
    }
  }
  
  static abstract interface ReplayBuffer<T>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract void next(T paramT);
    
    public abstract void replay(OperatorReplay.InnerProducer<T> paramInnerProducer);
  }
  
  static final class ReplaySubscriber<T>
    extends Subscriber<T>
    implements Subscription
  {
    static final OperatorReplay.InnerProducer[] EMPTY = new OperatorReplay.InnerProducer[0];
    static final OperatorReplay.InnerProducer[] TERMINATED = new OperatorReplay.InnerProducer[0];
    final OperatorReplay.ReplayBuffer<T> buffer;
    boolean done;
    boolean emitting;
    long maxChildRequested;
    long maxUpstreamRequested;
    boolean missed;
    final NotificationLite<T> nl;
    volatile Producer producer;
    final AtomicReference<OperatorReplay.InnerProducer[]> producers;
    final AtomicBoolean shouldConnect;
    
    public ReplaySubscriber(AtomicReference<ReplaySubscriber<T>> paramAtomicReference, OperatorReplay.ReplayBuffer<T> paramReplayBuffer)
    {
      this.buffer = paramReplayBuffer;
      this.nl = NotificationLite.instance();
      this.producers = new AtomicReference(EMPTY);
      this.shouldConnect = new AtomicBoolean();
      request(0L);
    }
    
    boolean add(OperatorReplay.InnerProducer<T> paramInnerProducer)
    {
      if (paramInnerProducer == null) {
        throw new NullPointerException();
      }
      OperatorReplay.InnerProducer[] arrayOfInnerProducer1;
      OperatorReplay.InnerProducer[] arrayOfInnerProducer2;
      do
      {
        arrayOfInnerProducer1 = (OperatorReplay.InnerProducer[])this.producers.get();
        if (arrayOfInnerProducer1 == TERMINATED) {
          return false;
        }
        int i = arrayOfInnerProducer1.length;
        arrayOfInnerProducer2 = new OperatorReplay.InnerProducer[i + 1];
        System.arraycopy(arrayOfInnerProducer1, 0, arrayOfInnerProducer2, 0, i);
        arrayOfInnerProducer2[i] = paramInnerProducer;
      } while (!this.producers.compareAndSet(arrayOfInnerProducer1, arrayOfInnerProducer2));
      return true;
    }
    
    void init()
    {
      add(Subscriptions.create(new OperatorReplay.ReplaySubscriber.1(this)));
    }
    
    void manageRequests()
    {
      if (isUnsubscribed()) {}
      for (;;)
      {
        return;
        try
        {
          if (this.emitting)
          {
            this.missed = true;
            return;
          }
        }
        finally {}
        this.emitting = true;
        while (!isUnsubscribed())
        {
          Object localObject2 = (OperatorReplay.InnerProducer[])this.producers.get();
          long l2 = this.maxChildRequested;
          int j = localObject2.length;
          int i = 0;
          long l1 = l2;
          while (i < j)
          {
            l1 = Math.max(l1, localObject2[i].totalRequested.get());
            i += 1;
          }
          long l3 = this.maxUpstreamRequested;
          localObject2 = this.producer;
          l2 = l1 - l2;
          if (l2 != 0L)
          {
            this.maxChildRequested = l1;
            if (localObject2 != null) {
              if (l3 != 0L)
              {
                this.maxUpstreamRequested = 0L;
                ((Producer)localObject2).request(l3 + l2);
              }
            }
          }
          for (;;)
          {
            try
            {
              if (this.missed) {
                break;
              }
              this.emitting = false;
              return;
            }
            finally {}
            localObject3.request(l2);
            continue;
            l2 = l3 + l2;
            l1 = l2;
            if (l2 < 0L) {
              l1 = 9223372036854775807L;
            }
            this.maxUpstreamRequested = l1;
            continue;
            if ((l3 != 0L) && (localObject3 != null))
            {
              this.maxUpstreamRequested = 0L;
              localObject3.request(l3);
            }
          }
          this.missed = false;
        }
      }
    }
    
    public void onCompleted()
    {
      if (!this.done) {
        this.done = true;
      }
      try
      {
        this.buffer.complete();
        replay();
        return;
      }
      finally
      {
        unsubscribe();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!this.done) {
        this.done = true;
      }
      try
      {
        this.buffer.error(paramThrowable);
        replay();
        return;
      }
      finally
      {
        unsubscribe();
      }
    }
    
    public void onNext(T paramT)
    {
      if (!this.done)
      {
        this.buffer.next(paramT);
        replay();
      }
    }
    
    void remove(OperatorReplay.InnerProducer<T> paramInnerProducer)
    {
      OperatorReplay.InnerProducer[] arrayOfInnerProducer2 = (OperatorReplay.InnerProducer[])this.producers.get();
      if ((arrayOfInnerProducer2 == EMPTY) || (arrayOfInnerProducer2 == TERMINATED)) {}
      int m;
      int i;
      label39:
      int j;
      do
      {
        return;
        int k = -1;
        m = arrayOfInnerProducer2.length;
        i = 0;
        j = k;
        if (i < m)
        {
          if (!arrayOfInnerProducer2[i].equals(paramInnerProducer)) {
            break;
          }
          j = i;
        }
      } while (j < 0);
      OperatorReplay.InnerProducer[] arrayOfInnerProducer1;
      if (m == 1) {
        arrayOfInnerProducer1 = EMPTY;
      }
      while (this.producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1))
      {
        return;
        i += 1;
        break label39;
        arrayOfInnerProducer1 = new OperatorReplay.InnerProducer[m - 1];
        System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
        System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
      }
    }
    
    void replay()
    {
      OperatorReplay.InnerProducer[] arrayOfInnerProducer = (OperatorReplay.InnerProducer[])this.producers.get();
      int j = arrayOfInnerProducer.length;
      int i = 0;
      while (i < j)
      {
        OperatorReplay.InnerProducer localInnerProducer = arrayOfInnerProducer[i];
        this.buffer.replay(localInnerProducer);
        i += 1;
      }
    }
    
    public void setProducer(Producer paramProducer)
    {
      if (this.producer != null) {
        throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
      }
      this.producer = paramProducer;
      manageRequests();
      replay();
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    extends OperatorReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAgeInMillis;
    final Scheduler scheduler;
    
    public SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, Scheduler paramScheduler)
    {
      this.scheduler = paramScheduler;
      this.limit = paramInt;
      this.maxAgeInMillis = paramLong;
    }
    
    Object enterTransform(Object paramObject)
    {
      return new Timestamped(this.scheduler.now(), paramObject);
    }
    
    Object leaveTransform(Object paramObject)
    {
      return ((Timestamped)paramObject).getValue();
    }
    
    void truncate()
    {
      long l1 = this.scheduler.now();
      long l2 = this.maxAgeInMillis;
      Object localObject2 = (OperatorReplay.Node)get();
      Object localObject1 = (OperatorReplay.Node)((OperatorReplay.Node)localObject2).get();
      int i = 0;
      while (localObject1 != null)
      {
        OperatorReplay.Node localNode;
        if (this.size > this.limit)
        {
          i += 1;
          this.size -= 1;
          localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
          localObject2 = localObject1;
          localObject1 = localNode;
        }
        else
        {
          if (((Timestamped)((OperatorReplay.Node)localObject1).value).getTimestampMillis() > l1 - l2) {
            break;
          }
          i += 1;
          this.size -= 1;
          localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
          localObject2 = localObject1;
          localObject1 = localNode;
        }
      }
      if (i != 0) {
        setFirst((OperatorReplay.Node)localObject2);
      }
    }
    
    void truncateFinal()
    {
      long l1 = this.scheduler.now();
      long l2 = this.maxAgeInMillis;
      Object localObject1 = (OperatorReplay.Node)get();
      Object localObject2 = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
      int i = 0;
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      while ((localObject1 != null) && (this.size > 1) && (((Timestamped)((OperatorReplay.Node)localObject1).value).getTimestampMillis() <= l1 - l2))
      {
        i += 1;
        this.size -= 1;
        localObject3 = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
      }
      if (i != 0) {
        setFirst((OperatorReplay.Node)localObject3);
      }
    }
  }
  
  static final class SizeBoundReplayBuffer<T>
    extends OperatorReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;
    
    public SizeBoundReplayBuffer(int paramInt)
    {
      this.limit = paramInt;
    }
    
    void truncate()
    {
      if (this.size > this.limit) {
        removeFirst();
      }
    }
  }
  
  static final class UnboundedReplayBuffer<T>
    extends ArrayList<Object>
    implements OperatorReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 7063189396499112664L;
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile int size;
    
    public UnboundedReplayBuffer(int paramInt)
    {
      super();
    }
    
    public void complete()
    {
      add(this.nl.completed());
      this.size += 1;
    }
    
    public void error(Throwable paramThrowable)
    {
      add(this.nl.error(paramThrowable));
      this.size += 1;
    }
    
    public void next(T paramT)
    {
      add(this.nl.next(paramT));
      this.size += 1;
    }
    
    /* Error */
    public void replay(OperatorReplay.InnerProducer<T> paramInnerProducer)
    {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: getfield 66	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
      //   6: ifeq +11 -> 17
      //   9: aload_1
      //   10: iconst_1
      //   11: putfield 69	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
      //   14: aload_1
      //   15: monitorexit
      //   16: return
      //   17: aload_1
      //   18: iconst_1
      //   19: putfield 66	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
      //   22: aload_1
      //   23: monitorexit
      //   24: aload_1
      //   25: invokevirtual 73	rx/internal/operators/OperatorReplay$InnerProducer:isUnsubscribed	()Z
      //   28: ifne +240 -> 268
      //   31: aload_0
      //   32: getfield 44	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:size	I
      //   35: istore_3
      //   36: aload_1
      //   37: invokevirtual 76	rx/internal/operators/OperatorReplay$InnerProducer:index	()Ljava/lang/Object;
      //   40: checkcast 78	java/lang/Integer
      //   43: astore 11
      //   45: aload 11
      //   47: ifnull +94 -> 141
      //   50: aload 11
      //   52: invokevirtual 82	java/lang/Integer:intValue	()I
      //   55: istore_2
      //   56: aload_1
      //   57: invokevirtual 86	rx/internal/operators/OperatorReplay$InnerProducer:get	()J
      //   60: lstore 8
      //   62: lconst_0
      //   63: lstore 4
      //   65: lload 8
      //   67: lstore 6
      //   69: lload 6
      //   71: lconst_0
      //   72: lcmp
      //   73: ifeq +130 -> 203
      //   76: iload_2
      //   77: iload_3
      //   78: if_icmpge +125 -> 203
      //   81: aload_0
      //   82: iload_2
      //   83: invokevirtual 89	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:get	(I)Ljava/lang/Object;
      //   86: astore 11
      //   88: aload_0
      //   89: getfield 31	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
      //   92: aload_1
      //   93: getfield 93	rx/internal/operators/OperatorReplay$InnerProducer:child	Lrx/Subscriber;
      //   96: aload 11
      //   98: invokevirtual 97	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
      //   101: istore 10
      //   103: iload 10
      //   105: ifne +163 -> 268
      //   108: aload_1
      //   109: invokevirtual 73	rx/internal/operators/OperatorReplay$InnerProducer:isUnsubscribed	()Z
      //   112: ifne +156 -> 268
      //   115: iload_2
      //   116: iconst_1
      //   117: iadd
      //   118: istore_2
      //   119: lload 6
      //   121: lconst_1
      //   122: lsub
      //   123: lstore 6
      //   125: lload 4
      //   127: lconst_1
      //   128: ladd
      //   129: lstore 4
      //   131: goto -62 -> 69
      //   134: astore 11
      //   136: aload_1
      //   137: monitorexit
      //   138: aload 11
      //   140: athrow
      //   141: iconst_0
      //   142: istore_2
      //   143: goto -87 -> 56
      //   146: astore 12
      //   148: aload 12
      //   150: invokestatic 102	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
      //   153: aload_1
      //   154: invokevirtual 105	rx/internal/operators/OperatorReplay$InnerProducer:unsubscribe	()V
      //   157: aload_0
      //   158: getfield 31	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
      //   161: aload 11
      //   163: invokevirtual 108	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
      //   166: ifne +102 -> 268
      //   169: aload_0
      //   170: getfield 31	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
      //   173: aload 11
      //   175: invokevirtual 111	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
      //   178: ifne +90 -> 268
      //   181: aload_1
      //   182: getfield 93	rx/internal/operators/OperatorReplay$InnerProducer:child	Lrx/Subscriber;
      //   185: aload 12
      //   187: aload_0
      //   188: getfield 31	rx/internal/operators/OperatorReplay$UnboundedReplayBuffer:nl	Lrx/internal/operators/NotificationLite;
      //   191: aload 11
      //   193: invokevirtual 114	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
      //   196: invokestatic 120	rx/exceptions/OnErrorThrowable:addValueAsLastCause	(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Throwable;
      //   199: invokevirtual 125	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
      //   202: return
      //   203: lload 4
      //   205: lconst_0
      //   206: lcmp
      //   207: ifeq +27 -> 234
      //   210: aload_1
      //   211: iload_2
      //   212: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   215: putfield 132	rx/internal/operators/OperatorReplay$InnerProducer:index	Ljava/lang/Object;
      //   218: lload 8
      //   220: ldc2_w 133
      //   223: lcmp
      //   224: ifeq +10 -> 234
      //   227: aload_1
      //   228: lload 4
      //   230: invokevirtual 138	rx/internal/operators/OperatorReplay$InnerProducer:produced	(J)J
      //   233: pop2
      //   234: aload_1
      //   235: monitorenter
      //   236: aload_1
      //   237: getfield 69	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
      //   240: ifne +18 -> 258
      //   243: aload_1
      //   244: iconst_0
      //   245: putfield 66	rx/internal/operators/OperatorReplay$InnerProducer:emitting	Z
      //   248: aload_1
      //   249: monitorexit
      //   250: return
      //   251: astore 11
      //   253: aload_1
      //   254: monitorexit
      //   255: aload 11
      //   257: athrow
      //   258: aload_1
      //   259: iconst_0
      //   260: putfield 69	rx/internal/operators/OperatorReplay$InnerProducer:missed	Z
      //   263: aload_1
      //   264: monitorexit
      //   265: goto -241 -> 24
      //   268: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	269	0	this	UnboundedReplayBuffer
      //   0	269	1	paramInnerProducer	OperatorReplay.InnerProducer<T>
      //   55	157	2	i	int
      //   35	44	3	j	int
      //   63	166	4	l1	long
      //   67	57	6	l2	long
      //   60	159	8	l3	long
      //   101	3	10	bool	boolean
      //   43	54	11	localObject1	Object
      //   134	58	11	localObject2	Object
      //   251	5	11	localObject3	Object
      //   146	40	12	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   2	16	134	finally
      //   17	24	134	finally
      //   136	138	134	finally
      //   88	103	146	java/lang/Throwable
      //   236	250	251	finally
      //   253	255	251	finally
      //   258	265	251	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay
 * JD-Core Version:    0.7.0.1
 */