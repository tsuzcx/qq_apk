package rx.internal.operators;

import rx.Observable;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;

public class OnSubscribeSingle<T>
  implements Single.OnSubscribe<T>
{
  private final Observable<T> observable;
  
  public OnSubscribeSingle(Observable<T> paramObservable)
  {
    this.observable = paramObservable;
  }
  
  public static <T> OnSubscribeSingle<T> create(Observable<T> paramObservable)
  {
    return new OnSubscribeSingle(paramObservable);
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    OnSubscribeSingle.1 local1 = new OnSubscribeSingle.1(this, paramSingleSubscriber);
    paramSingleSubscriber.add(local1);
    this.observable.unsafeSubscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeSingle
 * JD-Core Version:    0.7.0.1
 */