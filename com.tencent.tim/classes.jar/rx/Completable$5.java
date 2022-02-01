package rx;

import rx.functions.Func0;
import rx.subscriptions.Subscriptions;

final class Completable$5
  implements Completable.CompletableOnSubscribe
{
  Completable$5(Func0 paramFunc0) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    try
    {
      Completable localCompletable = (Completable)this.val$completableFunc0.call();
      if (localCompletable == null)
      {
        paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        paramCompletableSubscriber.onError(new NullPointerException("The completable returned is null"));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
      paramCompletableSubscriber.onError(localThrowable);
      return;
    }
    localThrowable.subscribe(paramCompletableSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.5
 * JD-Core Version:    0.7.0.1
 */