package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MTimerHandler
  extends Handler
{
  private static int ac;
  private final int ad;
  private final boolean av;
  private long aw = 0L;
  private final MTimerHandler.CallBack ax;
  
  public MTimerHandler(Looper paramLooper, MTimerHandler.CallBack paramCallBack, boolean paramBoolean)
  {
    super(paramLooper);
    this.ax = paramCallBack;
    this.ad = d();
    this.av = paramBoolean;
  }
  
  public MTimerHandler(MTimerHandler.CallBack paramCallBack, boolean paramBoolean)
  {
    this.ax = paramCallBack;
    this.ad = d();
    this.av = paramBoolean;
  }
  
  private static int d()
  {
    if (ac >= 8192) {
      ac = 0;
    }
    int i = ac + 1;
    ac = i;
    return i;
  }
  
  protected void finalize()
  {
    stopTimer();
    super.finalize();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != this.ad) || (this.ax == null)) {}
    while ((!this.ax.onTimerExpired()) || (!this.av)) {
      return;
    }
    sendEmptyMessageDelayed(this.ad, this.aw);
  }
  
  public void startTimer(long paramLong)
  {
    this.aw = paramLong;
    stopTimer();
    sendEmptyMessageDelayed(this.ad, paramLong);
  }
  
  public void stopTimer()
  {
    removeMessages(this.ad);
  }
  
  public boolean stopped()
  {
    return !hasMessages(this.ad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MTimerHandler
 * JD-Core Version:    0.7.0.1
 */