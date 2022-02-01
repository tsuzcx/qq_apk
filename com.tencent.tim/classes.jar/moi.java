import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.ViolaVideoUpdateController.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;

public class moi
{
  private Runnable cJ = new ViolaVideoUpdateController.1(this);
  private boolean isRunning;
  @NotNull
  private Runnable task;
  private long wi = 500L;
  
  public moi(@NotNull Runnable paramRunnable, long paramLong)
  {
    this.task = paramRunnable;
    this.wi = paramLong;
  }
  
  public void start()
  {
    if (this.isRunning) {
      return;
    }
    this.isRunning = true;
    ThreadManagerV2.getUIHandlerV2().post(this.cJ);
  }
  
  public void stop()
  {
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.cJ);
    this.isRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moi
 * JD-Core Version:    0.7.0.1
 */