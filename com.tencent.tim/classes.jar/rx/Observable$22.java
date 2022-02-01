package rx;

import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$22
  implements Func0<ConnectableObservable<T>>
{
  Observable$22(Observable paramObservable) {}
  
  public ConnectableObservable<T> call()
  {
    return this.this$0.replay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Observable.22
 * JD-Core Version:    0.7.0.1
 */