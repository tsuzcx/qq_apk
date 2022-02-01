package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Observable.Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T>
  implements Observable.Operator<T, T>
{
  final FirstTimeoutStub<T> firstTimeoutStub;
  final Observable<? extends T> other;
  final Scheduler scheduler;
  final TimeoutStub<T> timeoutStub;
  
  OperatorTimeoutBase(FirstTimeoutStub<T> paramFirstTimeoutStub, TimeoutStub<T> paramTimeoutStub, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    this.firstTimeoutStub = paramFirstTimeoutStub;
    this.timeoutStub = paramTimeoutStub;
    this.other = paramObservable;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSubscriber.add(localWorker);
    paramSubscriber = new SerializedSubscriber(paramSubscriber);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    TimeoutSubscriber localTimeoutSubscriber = new TimeoutSubscriber(paramSubscriber, this.timeoutStub, localSerialSubscription, this.other, localWorker);
    paramSubscriber.add(localTimeoutSubscriber);
    paramSubscriber.setProducer(localTimeoutSubscriber.arbiter);
    localSerialSubscription.set((Subscription)this.firstTimeoutStub.call(localTimeoutSubscriber, Long.valueOf(0L), localWorker));
    return localTimeoutSubscriber;
  }
  
  static abstract interface FirstTimeoutStub<T>
    extends Func3<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription>
  {}
  
  static abstract interface TimeoutStub<T>
    extends Func4<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription>
  {}
  
  static final class TimeoutSubscriber<T>
    extends Subscriber<T>
  {
    long actual;
    final ProducerArbiter arbiter;
    final Scheduler.Worker inner;
    final Observable<? extends T> other;
    final SerialSubscription serial;
    final SerializedSubscriber<T> serializedSubscriber;
    boolean terminated;
    final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
    
    TimeoutSubscriber(SerializedSubscriber<T> paramSerializedSubscriber, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, SerialSubscription paramSerialSubscription, Observable<? extends T> paramObservable, Scheduler.Worker paramWorker)
    {
      this.serializedSubscriber = paramSerializedSubscriber;
      this.timeoutStub = paramTimeoutStub;
      this.serial = paramSerialSubscription;
      this.other = paramObservable;
      this.inner = paramWorker;
      this.arbiter = new ProducerArbiter();
    }
    
    public void onCompleted()
    {
      int i = 1;
      for (;;)
      {
        try
        {
          if (!this.terminated)
          {
            this.terminated = true;
            if (i != 0)
            {
              this.serial.unsubscribe();
              this.serializedSubscriber.onCompleted();
            }
            return;
          }
        }
        finally {}
        i = 0;
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      int i = 1;
      for (;;)
      {
        try
        {
          if (!this.terminated)
          {
            this.terminated = true;
            if (i != 0)
            {
              this.serial.unsubscribe();
              this.serializedSubscriber.onError(paramThrowable);
            }
            return;
          }
        }
        finally {}
        i = 0;
      }
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 53	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:terminated	Z
      //   8: ifne +61 -> 69
      //   11: aload_0
      //   12: getfield 70	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:actual	J
      //   15: lconst_1
      //   16: ladd
      //   17: lstore_3
      //   18: aload_0
      //   19: lload_3
      //   20: putfield 70	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:actual	J
      //   23: iconst_1
      //   24: istore_2
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_2
      //   28: ifeq +40 -> 68
      //   31: aload_0
      //   32: getfield 34	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:serializedSubscriber	Lrx/observers/SerializedSubscriber;
      //   35: aload_1
      //   36: invokevirtual 72	rx/observers/SerializedSubscriber:onNext	(Ljava/lang/Object;)V
      //   39: aload_0
      //   40: getfield 38	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:serial	Lrx/subscriptions/SerialSubscription;
      //   43: aload_0
      //   44: getfield 36	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:timeoutStub	Lrx/internal/operators/OperatorTimeoutBase$TimeoutStub;
      //   47: aload_0
      //   48: lload_3
      //   49: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   52: aload_1
      //   53: aload_0
      //   54: getfield 42	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:inner	Lrx/Scheduler$Worker;
      //   57: invokeinterface 84 5 0
      //   62: checkcast 86	rx/Subscription
      //   65: invokevirtual 90	rx/subscriptions/SerialSubscription:set	(Lrx/Subscription;)V
      //   68: return
      //   69: aload_0
      //   70: getfield 70	rx/internal/operators/OperatorTimeoutBase$TimeoutSubscriber:actual	J
      //   73: lstore_3
      //   74: goto -49 -> 25
      //   77: astore_1
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	TimeoutSubscriber
      //   0	82	1	paramT	T
      //   1	27	2	i	int
      //   17	57	3	l	long
      // Exception table:
      //   from	to	target	type
      //   4	23	77	finally
      //   25	27	77	finally
      //   69	74	77	finally
      //   78	80	77	finally
    }
    
    public void onTimeout(long paramLong)
    {
      int i = 1;
      for (;;)
      {
        try
        {
          if ((paramLong != this.actual) || (this.terminated)) {
            break label90;
          }
          this.terminated = true;
          if (i != 0)
          {
            if (this.other == null) {
              this.serializedSubscriber.onError(new TimeoutException());
            }
          }
          else {
            return;
          }
        }
        finally {}
        OperatorTimeoutBase.TimeoutSubscriber.1 local1 = new OperatorTimeoutBase.TimeoutSubscriber.1(this);
        this.other.unsafeSubscribe(local1);
        this.serial.set(local1);
        return;
        label90:
        i = 0;
      }
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.arbiter.setProducer(paramProducer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase
 * JD-Core Version:    0.7.0.1
 */