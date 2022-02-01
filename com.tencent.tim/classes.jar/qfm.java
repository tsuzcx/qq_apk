import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.playvideo.NewProgressControler.2;
import com.tencent.biz.qqstory.playvideo.NewProgressControler.3;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

public class qfm
  implements qlc.d
{
  private SplitedProgressBar a;
  public boolean aDd;
  public WeakReference<qlb> bY = new WeakReference(null);
  public long mCurrentTime;
  public long mEndTime;
  public Timer mTimer;
  private TimerTask mTimerTask;
  public Handler mUIHandler = new qfn(this, Looper.getMainLooper());
  protected long ra;
  
  public qfm(SplitedProgressBar paramSplitedProgressBar)
  {
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.a = paramSplitedProgressBar;
    this.a.setTotalCount(1);
  }
  
  private void aBd()
  {
    NewProgressControler.2 local2 = new NewProgressControler.2(this);
    this.mUIHandler.post(local2);
  }
  
  private void bby()
  {
    if (this.aDd)
    {
      ram.w("Q.qqstory.player:NewProgressControler", "progress already canceled. can't start.");
      return;
    }
    this.aDd = false;
    yR();
    if (this.mEndTime < 0L)
    {
      aBd();
      return;
    }
    startTimer();
  }
  
  private void fj(long paramLong)
  {
    int i = 100;
    int j;
    if (this.mEndTime > 0L)
    {
      j = (int)paramLong * 100 / (int)this.mEndTime;
      if (j <= 100) {}
    }
    for (;;)
    {
      this.a.setProgress(0, i);
      return;
      i = j;
      continue;
      i = 0;
    }
  }
  
  private void seek(long paramLong1, long paramLong2)
  {
    this.ra = paramLong1;
    this.mCurrentTime = this.ra;
    this.mEndTime = paramLong2;
    fj(paramLong1);
    ram.b("Q.qqstory.player:NewProgressControler", "seek ft:%d , ed:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  private void startTimer()
  {
    try
    {
      Timer localTimer = new Timer();
      NewProgressControler.3 local3 = new NewProgressControler.3(this);
      localTimer.scheduleAtFixedRate(local3, 0L, 50L);
      this.mTimer = localTimer;
      this.mTimerTask = local3;
      ram.d("Q.qqstory.player:NewProgressControler", "startTimer");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void yR()
  {
    try
    {
      if (this.mUIHandler != null) {
        this.mUIHandler.removeCallbacksAndMessages(null);
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      if (this.mTimerTask != null) {
        this.mTimerTask.cancel();
      }
      ram.d("Q.qqstory.player:NewProgressControler", "cancelTimer");
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, qlb paramqlb)
  {
    if (paramqlb == this.bY.get())
    {
      ram.b("Q.qqstory.player:NewProgressControler", "progress callback :onSeek , ft:%d , et:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      seek(paramLong1, paramLong2);
    }
  }
  
  public void a(qlb paramqlb)
  {
    if ((paramqlb instanceof qlc)) {}
    for (qlb localqlb = ((qlc)paramqlb).a();; localqlb = paramqlb)
    {
      if (localqlb == this.bY.get())
      {
        ram.d("Q.qqstory.player:NewProgressControler", "cannot set the same video view");
        return;
      }
      this.bY = new WeakReference(localqlb);
      if ((paramqlb instanceof qlc)) {
        ((qlc)paramqlb).a(this);
      }
      for (;;)
      {
        yR();
        seek(0L, paramqlb.getDuration());
        return;
        ram.d("Yarkey", "cannot set the same video view");
      }
    }
  }
  
  public void b(qlb paramqlb)
  {
    if (paramqlb == this.bY.get())
    {
      ram.d("Q.qqstory.player:NewProgressControler", "progress callback :onStart");
      bby();
      return;
    }
    ram.d("Yarkey", "onStart ignore !!");
  }
  
  public void bod()
  {
    ram.d("Q.qqstory.player:NewProgressControler", "pauseProgressBar");
    yR();
  }
  
  public void c(qlb paramqlb)
  {
    if (paramqlb == this.bY.get())
    {
      ram.d("Q.qqstory.player:NewProgressControler", "progress callback :onPause");
      bod();
    }
  }
  
  public void destroy()
  {
    this.aDd = true;
    bod();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfm
 * JD-Core Version:    0.7.0.1
 */