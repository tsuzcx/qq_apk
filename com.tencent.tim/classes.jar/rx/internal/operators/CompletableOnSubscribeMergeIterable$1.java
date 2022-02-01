package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeMergeIterable$1
  implements Completable.CompletableSubscriber
{
  CompletableOnSubscribeMergeIterable$1(CompletableOnSubscribeMergeIterable paramCompletableOnSubscribeMergeIterable, CompositeSubscription paramCompositeSubscription, AtomicBoolean paramAtomicBoolean, Completable.CompletableSubscriber paramCompletableSubscriber, AtomicInteger paramAtomicInteger) {}
  
  public void onCompleted()
  {
    if ((this.val$wip.decrementAndGet() == 0) && (this.val$once.compareAndSet(false, true))) {
      this.val$s.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$set.unsubscribe();
    if (this.val$once.compareAndSet(false, true))
    {
      this.val$s.onError(paramThrowable);
      return;
    }
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$set.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeIterable.1
 * JD-Core Version:    0.7.0.1
 */