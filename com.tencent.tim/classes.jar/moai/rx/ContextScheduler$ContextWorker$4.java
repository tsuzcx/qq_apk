package moai.rx;

import android.os.Handler;
import rx.functions.Action0;

class ContextScheduler$ContextWorker$4
  implements Action0
{
  ContextScheduler$ContextWorker$4(ContextScheduler.ContextWorker paramContextWorker, Runnable paramRunnable) {}
  
  public void call()
  {
    ContextScheduler.access$100().removeCallbacks(this.val$runAfterAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler.ContextWorker.4
 * JD-Core Version:    0.7.0.1
 */