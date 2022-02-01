package rx.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import rx.functions.Action0;

class TrampolineScheduler$InnerCurrentThreadScheduler$1
  implements Action0
{
  TrampolineScheduler$InnerCurrentThreadScheduler$1(TrampolineScheduler.InnerCurrentThreadScheduler paramInnerCurrentThreadScheduler, TrampolineScheduler.TimedAction paramTimedAction) {}
  
  public void call()
  {
    this.this$0.queue.remove(this.val$timedAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
 * JD-Core Version:    0.7.0.1
 */