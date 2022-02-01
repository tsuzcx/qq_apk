package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.Subscribers;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeDelaySubscriptionOther<T, U>
  implements Observable.OnSubscribe<T>
{
  final Observable<? extends T> main;
  final Observable<U> other;
  
  public OnSubscribeDelaySubscriptionOther(Observable<? extends T> paramObservable, Observable<U> paramObservable1)
  {
    this.main = paramObservable;
    this.other = paramObservable1;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = Subscribers.wrap(paramSubscriber);
    paramSubscriber = new SerialSubscription();
    localObject = new OnSubscribeDelaySubscriptionOther.1(this, (Subscriber)localObject, paramSubscriber);
    paramSubscriber.set((Subscription)localObject);
    this.other.unsafeSubscribe((Subscriber)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscriptionOther
 * JD-Core Version:    0.7.0.1
 */