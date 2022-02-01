package rx;

import rx.functions.Func1;

class Observable$25
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  Observable$25(Observable paramObservable, Func1 paramFunc1) {}
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return (Observable)this.val$notificationHandler.call(paramObservable.map(new Observable.25.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Observable.25
 * JD-Core Version:    0.7.0.1
 */