package com.tencent.qqmail.utilities.timer;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class TinyTimer
{
  private Timer m_Timer;
  private TimerTask m_TimerTask;
  
  public void RunOnce(Handler paramHandler, int paramInt, long paramLong)
  {
    this.m_Timer = new Timer();
    this.m_TimerTask = new TinyTimer.2(this, paramHandler, paramInt);
    try
    {
      this.m_Timer.schedule(this.m_TimerTask, paramLong);
      return;
    }
    catch (Exception paramHandler) {}
  }
  
  public void StartTimer(Handler paramHandler, int paramInt, long paramLong1, long paramLong2)
  {
    this.m_Timer = new Timer();
    this.m_TimerTask = new TinyTimer.1(this, paramHandler, paramInt);
    try
    {
      this.m_Timer.schedule(this.m_TimerTask, paramLong1, paramLong2);
      return;
    }
    catch (Exception paramHandler) {}
  }
  
  public void StopTimer()
  {
    if (this.m_Timer != null) {
      this.m_Timer.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.timer.TinyTimer
 * JD-Core Version:    0.7.0.1
 */