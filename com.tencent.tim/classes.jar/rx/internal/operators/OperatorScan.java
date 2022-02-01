package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorScan<R, T>
  implements Observable.Operator<R, T>
{
  private static final Object NO_INITIAL_VALUE = new Object();
  final Func2<R, ? super T, R> accumulator;
  private final Func0<R> initialValueFactory;
  
  public OperatorScan(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    this(new OperatorScan.1(paramR), paramFunc2);
  }
  
  public OperatorScan(Func0<R> paramFunc0, Func2<R, ? super T, R> paramFunc2)
  {
    this.initialValueFactory = paramFunc0;
    this.accumulator = paramFunc2;
  }
  
  public OperatorScan(Func2<R, ? super T, R> paramFunc2)
  {
    this(NO_INITIAL_VALUE, paramFunc2);
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = this.initialValueFactory.call();
    if (localObject == NO_INITIAL_VALUE) {
      return new OperatorScan.2(this, paramSubscriber, paramSubscriber);
    }
    InitialProducer localInitialProducer = new InitialProducer(localObject, paramSubscriber);
    localObject = new OperatorScan.3(this, localObject, localInitialProducer);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(localInitialProducer);
    return localObject;
  }
  
  static final class InitialProducer<R>
    implements Observer<R>, Producer
  {
    final Subscriber<? super R> child;
    volatile boolean done;
    boolean emitting;
    Throwable error;
    boolean missed;
    long missedRequested;
    volatile Producer producer;
    final Queue<Object> queue;
    final AtomicLong requested;
    
    public InitialProducer(R paramR, Subscriber<? super R> paramSubscriber)
    {
      this.child = paramSubscriber;
      if (UnsafeAccess.isUnsafeAvailable()) {}
      for (paramSubscriber = new SpscLinkedQueue();; paramSubscriber = new SpscLinkedAtomicQueue())
      {
        this.queue = paramSubscriber;
        paramSubscriber.offer(NotificationLite.instance().next(paramR));
        this.requested = new AtomicLong();
        return;
      }
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super R> paramSubscriber)
    {
      if (paramSubscriber.isUnsubscribed()) {
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable = this.error;
        if (localThrowable != null)
        {
          paramSubscriber.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramSubscriber.onCompleted();
          return true;
        }
      }
      return false;
    }
    
    void emit()
    {
      try
      {
        if (this.emitting)
        {
          this.missed = true;
          return;
        }
        this.emitting = true;
        emitLoop();
        return;
      }
      finally {}
    }
    
    void emitLoop()
    {
      Subscriber localSubscriber = this.child;
      Queue localQueue = this.queue;
      NotificationLite localNotificationLite = NotificationLite.instance();
      AtomicLong localAtomicLong = this.requested;
      long l1 = localAtomicLong.get();
      if (l1 == 9223372036854775807L) {}
      for (int i = 1; checkTerminated(this.done, localQueue.isEmpty(), localSubscriber); i = 0) {
        return;
      }
      long l2 = 0L;
      Object localObject;
      boolean bool1;
      if (l1 != 0L)
      {
        boolean bool2 = this.done;
        localObject = localQueue.poll();
        if (localObject == null)
        {
          bool1 = true;
          label97:
          if (checkTerminated(bool2, bool1, localSubscriber)) {
            break label162;
          }
          if (!bool1) {
            break label164;
          }
        }
      }
      else
      {
        if ((l2 == 0L) || (i != 0)) {
          break label215;
        }
        l1 = localAtomicLong.addAndGet(l2);
      }
      label162:
      label164:
      label205:
      label215:
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.missed) {
              break label205;
            }
            this.emitting = false;
            return;
          }
          finally {}
          bool1 = false;
          break label97;
          break;
          localObject = localNotificationLite.getValue(localObject);
          try
          {
            localObserver.onNext(localObject);
            l2 -= 1L;
            l1 -= 1L;
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwOrReport(localThrowable, localObserver, localObject);
            return;
          }
        }
        this.missed = false;
        break;
      }
    }
    
    public void onCompleted()
    {
      this.done = true;
      emit();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      emit();
    }
    
    public void onNext(R paramR)
    {
      this.queue.offer(NotificationLite.instance().next(paramR));
      emit();
    }
    
    public void request(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("n >= required but it was " + paramLong);
      }
      Object localObject1;
      if (paramLong != 0L)
      {
        BackpressureUtils.getAndAddRequest(this.requested, paramLong);
        ??? = this.producer;
        localObject1 = ???;
        if (??? != null) {}
      }
      synchronized (this.requested)
      {
        localObject1 = this.producer;
        if (localObject1 == null) {
          this.missedRequested = BackpressureUtils.addCap(this.missedRequested, paramLong);
        }
        if (localObject1 != null) {
          ((Producer)localObject1).request(paramLong);
        }
        emit();
        return;
      }
    }
    
    public void setProducer(Producer paramProducer)
    {
      if (paramProducer == null) {
        throw new NullPointerException();
      }
      synchronized (this.requested)
      {
        if (this.producer != null) {
          throw new IllegalStateException("Can't set more than one Producer!");
        }
      }
      long l2 = this.missedRequested;
      long l1 = l2;
      if (l2 != 9223372036854775807L) {
        l1 = l2 - 1L;
      }
      this.missedRequested = 0L;
      this.producer = paramProducer;
      if (l1 > 0L) {
        paramProducer.request(l1);
      }
      emit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorScan
 * JD-Core Version:    0.7.0.1
 */