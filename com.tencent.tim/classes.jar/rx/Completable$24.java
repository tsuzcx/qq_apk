package rx;

import rx.functions.Func1;
import rx.subscriptions.SerialSubscription;

class Completable$24
  implements Completable.CompletableOnSubscribe
{
  Completable$24(Completable paramCompletable, Func1 paramFunc1) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    SerialSubscription localSerialSubscription = new SerialSubscription();
    this.this$0.subscribe(new Completable.24.1(this, paramCompletableSubscriber, localSerialSubscription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.24
 * JD-Core Version:    0.7.0.1
 */