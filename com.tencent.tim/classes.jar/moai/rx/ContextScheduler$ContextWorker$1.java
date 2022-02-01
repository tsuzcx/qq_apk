package moai.rx;

import moai.fragment.base.LifeDetection;
import rx.internal.schedulers.ScheduledAction;

class ContextScheduler$ContextWorker$1
  implements Runnable
{
  ContextScheduler$ContextWorker$1(ContextScheduler.ContextWorker paramContextWorker, ScheduledAction paramScheduledAction) {}
  
  public void run()
  {
    if (ContextScheduler.ContextWorker.access$000(this.this$0).isAttachedToActivity()) {
      this.val$scheduledAction.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler.ContextWorker.1
 * JD-Core Version:    0.7.0.1
 */