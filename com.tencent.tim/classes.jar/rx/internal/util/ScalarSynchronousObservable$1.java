package rx.internal.util;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class ScalarSynchronousObservable$1
  implements Observable.OnSubscribe<T>
{
  ScalarSynchronousObservable$1(Object paramObject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.setProducer(ScalarSynchronousObservable.createProducer(paramSubscriber, this.val$t));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.1
 * JD-Core Version:    0.7.0.1
 */