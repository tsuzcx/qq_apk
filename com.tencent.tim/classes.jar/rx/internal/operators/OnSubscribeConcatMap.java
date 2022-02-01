package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeConcatMap<T, R>
  implements Observable.OnSubscribe<R>
{
  public static final int BOUNDARY = 1;
  public static final int END = 2;
  public static final int IMMEDIATE = 0;
  final int delayErrorMode;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  final int prefetch;
  final Observable<? extends T> source;
  
  public OnSubscribeConcatMap(Observable<? extends T> paramObservable, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
  {
    this.source = paramObservable;
    this.mapper = paramFunc1;
    this.prefetch = paramInt1;
    this.delayErrorMode = paramInt2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    if (this.delayErrorMode == 0) {}
    for (Object localObject = new SerializedSubscriber(paramSubscriber);; localObject = paramSubscriber)
    {
      localObject = new ConcatMapSubscriber((Subscriber)localObject, this.mapper, this.prefetch, this.delayErrorMode);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.add(((ConcatMapSubscriber)localObject).inner);
      paramSubscriber.setProducer(new OnSubscribeConcatMap.1(this, (ConcatMapSubscriber)localObject));
      if (!paramSubscriber.isUnsubscribed()) {
        this.source.unsafeSubscribe((Subscriber)localObject);
      }
      return;
    }
  }
  
  static final class ConcatMapInnerScalarProducer<T, R>
    implements Producer
  {
    boolean once;
    final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
    final R value;
    
    public ConcatMapInnerScalarProducer(R paramR, OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
    {
      this.value = paramR;
      this.parent = paramConcatMapSubscriber;
    }
    
    public void request(long paramLong)
    {
      if (!this.once)
      {
        this.once = true;
        OnSubscribeConcatMap.ConcatMapSubscriber localConcatMapSubscriber = this.parent;
        localConcatMapSubscriber.innerNext(this.value);
        localConcatMapSubscriber.innerCompleted(1L);
      }
    }
  }
  
  static final class ConcatMapInnerSubscriber<T, R>
    extends Subscriber<R>
  {
    final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
    long produced;
    
    public ConcatMapInnerSubscriber(OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
    {
      this.parent = paramConcatMapSubscriber;
    }
    
    public void onCompleted()
    {
      this.parent.innerCompleted(this.produced);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable, this.produced);
    }
    
    public void onNext(R paramR)
    {
      this.produced += 1L;
      this.parent.innerNext(paramR);
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.parent.arbiter.setProducer(paramProducer);
    }
  }
  
  static final class ConcatMapSubscriber<T, R>
    extends Subscriber<T>
  {
    volatile boolean active;
    final Subscriber<? super R> actual;
    final ProducerArbiter arbiter;
    final int delayErrorMode;
    volatile boolean done;
    final AtomicReference<Throwable> error;
    final SerialSubscription inner;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    final Queue<Object> queue;
    final AtomicInteger wip;
    
    public ConcatMapSubscriber(Subscriber<? super R> paramSubscriber, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.mapper = paramFunc1;
      this.delayErrorMode = paramInt2;
      this.arbiter = new ProducerArbiter();
      this.wip = new AtomicInteger();
      this.error = new AtomicReference();
      if (UnsafeAccess.isUnsafeAvailable()) {}
      for (paramSubscriber = new SpscArrayQueue(paramInt1);; paramSubscriber = new SpscAtomicArrayQueue(paramInt1))
      {
        this.queue = paramSubscriber;
        this.inner = new SerialSubscription();
        request(paramInt1);
        return;
      }
    }
    
    void drain()
    {
      if (this.wip.getAndIncrement() != 0) {
        return;
      }
      label10:
      Object localObject;
      int i;
      do
      {
        do
        {
          int j;
          do
          {
            j = this.delayErrorMode;
          } while (this.actual.isUnsubscribed());
          if (this.active) {
            break label258;
          }
          if ((j != 1) || (this.error.get() == null)) {
            break;
          }
          localObject = ExceptionsUtils.terminate(this.error);
        } while (ExceptionsUtils.isTerminated((Throwable)localObject));
        this.actual.onError((Throwable)localObject);
        return;
        boolean bool = this.done;
        localObject = this.queue.poll();
        if (localObject == null) {}
        for (i = 1;; i = 0)
        {
          if ((!bool) || (i == 0)) {
            break label151;
          }
          localObject = ExceptionsUtils.terminate(this.error);
          if (localObject != null) {
            break;
          }
          this.actual.onCompleted();
          return;
        }
      } while (ExceptionsUtils.isTerminated((Throwable)localObject));
      this.actual.onError((Throwable)localObject);
      return;
      label151:
      ScalarSynchronousObservable localScalarSynchronousObservable;
      if (i == 0)
      {
        try
        {
          localObject = (Observable)this.mapper.call(NotificationLite.instance().getValue(localObject));
          if (localObject == null)
          {
            drainError(new NullPointerException("The source returned by the mapper was null"));
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwIfFatal(localThrowable);
          drainError(localThrowable);
          return;
        }
        if (localThrowable != Observable.empty())
        {
          if (!(localThrowable instanceof ScalarSynchronousObservable)) {
            break label269;
          }
          localScalarSynchronousObservable = (ScalarSynchronousObservable)localThrowable;
          this.arbiter.setProducer(new OnSubscribeConcatMap.ConcatMapInnerScalarProducer(localScalarSynchronousObservable.get(), this));
        }
      }
      for (;;)
      {
        request(1L);
        label258:
        if (this.wip.decrementAndGet() != 0) {
          break;
        }
        return;
        label269:
        OnSubscribeConcatMap.ConcatMapInnerSubscriber localConcatMapInnerSubscriber = new OnSubscribeConcatMap.ConcatMapInnerSubscriber(this);
        this.inner.set(localConcatMapInnerSubscriber);
        if (localConcatMapInnerSubscriber.isUnsubscribed()) {
          break label10;
        }
        this.active = true;
        localScalarSynchronousObservable.unsafeSubscribe(localConcatMapInnerSubscriber);
      }
    }
    
    void drainError(Throwable paramThrowable)
    {
      unsubscribe();
      if (ExceptionsUtils.addThrowable(this.error, paramThrowable))
      {
        paramThrowable = ExceptionsUtils.terminate(this.error);
        if (!ExceptionsUtils.isTerminated(paramThrowable)) {
          this.actual.onError(paramThrowable);
        }
        return;
      }
      pluginError(paramThrowable);
    }
    
    void innerCompleted(long paramLong)
    {
      if (paramLong != 0L) {
        this.arbiter.produced(paramLong);
      }
      this.active = false;
      drain();
    }
    
    void innerError(Throwable paramThrowable, long paramLong)
    {
      if (!ExceptionsUtils.addThrowable(this.error, paramThrowable))
      {
        pluginError(paramThrowable);
        return;
      }
      if (this.delayErrorMode == 0)
      {
        paramThrowable = ExceptionsUtils.terminate(this.error);
        if (!ExceptionsUtils.isTerminated(paramThrowable)) {
          this.actual.onError(paramThrowable);
        }
        unsubscribe();
        return;
      }
      if (paramLong != 0L) {
        this.arbiter.produced(paramLong);
      }
      this.active = false;
      drain();
    }
    
    void innerNext(R paramR)
    {
      this.actual.onNext(paramR);
    }
    
    public void onCompleted()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (ExceptionsUtils.addThrowable(this.error, paramThrowable))
      {
        this.done = true;
        if (this.delayErrorMode == 0)
        {
          paramThrowable = ExceptionsUtils.terminate(this.error);
          if (!ExceptionsUtils.isTerminated(paramThrowable)) {
            this.actual.onError(paramThrowable);
          }
          this.inner.unsubscribe();
          return;
        }
        drain();
        return;
      }
      pluginError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!this.queue.offer(NotificationLite.instance().next(paramT)))
      {
        unsubscribe();
        onError(new MissingBackpressureException());
        return;
      }
      drain();
    }
    
    void pluginError(Throwable paramThrowable)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
    }
    
    void requestMore(long paramLong)
    {
      if (paramLong > 0L) {
        this.arbiter.request(paramLong);
      }
      while (paramLong >= 0L) {
        return;
      }
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap
 * JD-Core Version:    0.7.0.1
 */