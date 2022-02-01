package moai.rx;

import android.os.Handler;
import rx.functions.Action0;

class ContextScheduler$ContextWorker$2
  implements Action0
{
  ContextScheduler$ContextWorker$2(ContextScheduler.ContextWorker paramContextWorker, Runnable paramRunnable) {}
  
  public void call()
  {
    ContextScheduler.access$100().removeCallbacks(this.val$runnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler.ContextWorker.2
 * JD-Core Version:    0.7.0.1
 */