package rx;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.MultipleAssignmentSubscription;

class Completable$27
  implements Completable.CompletableSubscriber
{
  Completable$27(Completable paramCompletable, Action0 paramAction0, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action1 paramAction1) {}
  
  public void onCompleted()
  {
    try
    {
      this.val$onComplete.call();
      this.val$mad.unsubscribe();
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$onError.call(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramThrowable = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }));
      Completable.ERROR_HANDLER.handleError(paramThrowable);
      Completable.access$000(paramThrowable);
      return;
    }
    finally
    {
      this.val$mad.unsubscribe();
    }
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$mad.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.27
 * JD-Core Version:    0.7.0.1
 */