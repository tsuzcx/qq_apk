package moai.rx;

import android.os.Handler;
import moai.fragment.base.LifeDetection;

class ContextScheduler$ContextWorker$3
  implements Runnable
{
  ContextScheduler$ContextWorker$3(ContextScheduler.ContextWorker paramContextWorker, Runnable paramRunnable) {}
  
  public void run()
  {
    if (ContextScheduler.ContextWorker.access$000(this.this$0).isAnimationRunning())
    {
      ContextScheduler.access$100().postDelayed(this, 100L);
      return;
    }
    this.val$runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler.ContextWorker.3
 * JD-Core Version:    0.7.0.1
 */