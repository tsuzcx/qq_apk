import android.os.Handler;
import com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2;
import com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.3;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class jxs
{
  public boolean bCancel;
  public WeakReference<qlb> bY;
  public int mCurrentIndex;
  public long mCurrentTime;
  public long mEndTime;
  public Timer mTimer;
  private TimerTask mTimerTask;
  public Handler mUIHandler;
  protected long ra;
  
  private void startTimer()
  {
    Timer localTimer = new Timer();
    ProgressControler.3 local3 = new ProgressControler.3(this);
    localTimer.scheduleAtFixedRate(local3, 0L, 50L);
    this.mTimer = localTimer;
    this.mTimerTask = local3;
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, qlb paramqlb)
  {
    this.bCancel = false;
    this.mCurrentIndex = paramInt;
    this.ra = paramLong1;
    this.mCurrentTime = this.ra;
    this.mEndTime = paramLong2;
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    if (this.mTimerTask != null) {
      this.mTimerTask.cancel();
    }
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.bY = new WeakReference(paramqlb);
      aBd();
      this.mUIHandler.sendEmptyMessage(0);
      return;
    }
    startTimer();
  }
  
  protected void aBd()
  {
    ProgressControler.2 local2 = new ProgressControler.2(this);
    this.mUIHandler.post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxs
 * JD-Core Version:    0.7.0.1
 */