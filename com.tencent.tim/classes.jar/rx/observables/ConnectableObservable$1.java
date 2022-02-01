package rx.observables;

import rx.Subscription;
import rx.functions.Action1;

class ConnectableObservable$1
  implements Action1<Subscription>
{
  ConnectableObservable$1(ConnectableObservable paramConnectableObservable, Subscription[] paramArrayOfSubscription) {}
  
  public void call(Subscription paramSubscription)
  {
    this.val$out[0] = paramSubscription;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observables.ConnectableObservable.1
 * JD-Core Version:    0.7.0.1
 */