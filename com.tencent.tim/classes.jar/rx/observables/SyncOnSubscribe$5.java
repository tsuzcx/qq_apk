package rx.observables;

import rx.functions.Action0;
import rx.functions.Action1;

final class SyncOnSubscribe$5
  implements Action1<Void>
{
  SyncOnSubscribe$5(Action0 paramAction0) {}
  
  public void call(Void paramVoid)
  {
    this.val$onUnsubscribe.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.5
 * JD-Core Version:    0.7.0.1
 */