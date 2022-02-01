package rx;

import java.util.concurrent.TimeUnit;
import rx.subscriptions.MultipleAssignmentSubscription;

final class Completable$12
  implements Completable.CompletableOnSubscribe
{
  Completable$12(Scheduler paramScheduler, long paramLong, TimeUnit paramTimeUnit) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    MultipleAssignmentSubscription localMultipleAssignmentSubscription = new MultipleAssignmentSubscription();
    paramCompletableSubscriber.onSubscribe(localMultipleAssignmentSubscription);
    if (!localMultipleAssignmentSubscription.isUnsubscribed())
    {
      Scheduler.Worker localWorker = this.val$scheduler.createWorker();
      localMultipleAssignmentSubscription.set(localWorker);
      localWorker.schedule(new Completable.12.1(this, paramCompletableSubscriber, localWorker), this.val$delay, this.val$unit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Completable.12
 * JD-Core Version:    0.7.0.1
 */