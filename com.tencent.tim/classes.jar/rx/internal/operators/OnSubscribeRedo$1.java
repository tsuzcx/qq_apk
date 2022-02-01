package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;

final class OnSubscribeRedo$1
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return paramObservable.map(new OnSubscribeRedo.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.1
 * JD-Core Version:    0.7.0.1
 */