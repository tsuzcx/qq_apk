package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T>
  implements Observable.Operator<T, Observable<T>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Subscriber<? super Observable<T>> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = Schedulers.trampoline().createWorker();
    paramSubscriber.add(localWorker);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    paramSubscriber.setProducer(localProducerArbiter);
    return new SourceSubscriber(paramSubscriber, this.predicate, localWorker, localSerialSubscription, localProducerArbiter);
  }
  
  static final class SourceSubscriber<T>
    extends Subscriber<Observable<T>>
  {
    final AtomicInteger attempts = new AtomicInteger();
    final Subscriber<? super T> child;
    final Scheduler.Worker inner;
    final ProducerArbiter pa;
    final Func2<Integer, Throwable, Boolean> predicate;
    final SerialSubscription serialSubscription;
    
    public SourceSubscriber(Subscriber<? super T> paramSubscriber, Func2<Integer, Throwable, Boolean> paramFunc2, Scheduler.Worker paramWorker, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter)
    {
      this.child = paramSubscriber;
      this.predicate = paramFunc2;
      this.inner = paramWorker;
      this.serialSubscription = paramSerialSubscription;
      this.pa = paramProducerArbiter;
    }
    
    public void onCompleted() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    public void onNext(Observable<T> paramObservable)
    {
      this.inner.schedule(new OperatorRetryWithPredicate.SourceSubscriber.1(this, paramObservable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate
 * JD-Core Version:    0.7.0.1
 */