package rx.observables;

import rx.Observable;
import rx.Observer;
import rx.functions.Action2;
import rx.functions.Func3;

final class AsyncOnSubscribe$3
  implements Func3<Void, Long, Observer<Observable<? extends T>>, Void>
{
  AsyncOnSubscribe$3(Action2 paramAction2) {}
  
  public Void call(Void paramVoid, Long paramLong, Observer<Observable<? extends T>> paramObserver)
  {
    this.val$next.call(paramLong, paramObserver);
    return paramVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.3
 * JD-Core Version:    0.7.0.1
 */