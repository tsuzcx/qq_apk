package rx.internal.operators;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorUnsubscribeOn$2
  implements Action0
{
  OperatorUnsubscribeOn$2(OperatorUnsubscribeOn paramOperatorUnsubscribeOn, Subscriber paramSubscriber) {}
  
  public void call()
  {
    Scheduler.Worker localWorker = this.this$0.scheduler.createWorker();
    localWorker.schedule(new OperatorUnsubscribeOn.2.1(this, localWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.2
 * JD-Core Version:    0.7.0.1
 */