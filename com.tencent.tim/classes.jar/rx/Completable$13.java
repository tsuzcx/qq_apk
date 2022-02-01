package rx;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

final class Completable$13
  implements Completable.CompletableOnSubscribe
{
  Completable$13(Func0 paramFunc0, Func1 paramFunc1, Action1 paramAction1, boolean paramBoolean) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    try
    {
      Object localObject = this.val$resourceFunc0.call();
      Completable localCompletable;
      localThrowable4.subscribe(new Completable.13.1(this, new AtomicBoolean(), localThrowable3, paramCompletableSubscriber));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localCompletable = (Completable)this.val$completableFunc1.call(localObject);
        if (localCompletable != null) {
          break label211;
        }
      }
      catch (Throwable localThrowable4)
      {
        try
        {
          this.val$disposer.call(localThrowable1);
          Exceptions.throwIfFatal(localThrowable4);
          paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
          paramCompletableSubscriber.onError(localThrowable4);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Exceptions.throwIfFatal(localThrowable4);
          Exceptions.throwIfFatal(localThrowable2);
          paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
          paramCompletableSubscriber.onError(new CompositeException(Arrays.asList(new Throwable[] { localThrowable4, localThrowable2 })));
          return;
        }
      }
      try
      {
        this.val$disposer.call(localObject);
        paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        paramCompletableSubscriber.onError(new NullPointerException("The completable supplied is null"));
        return;
      }
      catch (Throwable localThrowable3)
      {
        Exceptions.throwIfFatal(localThrowable3);
        paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        paramCompletableSubscriber.onError(new CompositeException(Arrays.asList(new Throwable[] { new NullPointerException("The completable supplied is null"), localThrowable3 })));
        return;
      }
      localThrowable1 = localThrowable1;
      paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
      paramCompletableSubscriber.onError(localThrowable1);
      return;
    }
    label211:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.13
 * JD-Core Version:    0.7.0.1
 */