package rx;

import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;

final class Completable$8
  implements Completable.CompletableOnSubscribe
{
  Completable$8(Action0 paramAction0) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    BooleanSubscription localBooleanSubscription = new BooleanSubscription();
    paramCompletableSubscriber.onSubscribe(localBooleanSubscription);
    try
    {
      this.val$action.call();
      if (!localBooleanSubscription.isUnsubscribed()) {
        paramCompletableSubscriber.onCompleted();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localBooleanSubscription.isUnsubscribed()) {}
      paramCompletableSubscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.8
 * JD-Core Version:    0.7.0.1
 */