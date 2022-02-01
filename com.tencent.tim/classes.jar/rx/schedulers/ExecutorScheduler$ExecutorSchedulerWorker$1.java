package rx.schedulers;

import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;

class ExecutorScheduler$ExecutorSchedulerWorker$1
  implements Action0
{
  ExecutorScheduler$ExecutorSchedulerWorker$1(ExecutorScheduler.ExecutorSchedulerWorker paramExecutorSchedulerWorker, MultipleAssignmentSubscription paramMultipleAssignmentSubscription) {}
  
  public void call()
  {
    this.this$0.tasks.remove(this.val$mas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.1
 * JD-Core Version:    0.7.0.1
 */