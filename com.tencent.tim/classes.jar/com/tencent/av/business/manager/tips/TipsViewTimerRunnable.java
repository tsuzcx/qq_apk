package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import ikz;
import iww;

public class TipsViewTimerRunnable
  implements Runnable
{
  Object au = new Object();
  volatile iww c = null;
  volatile iww d = null;
  volatile boolean isRunning = false;
  volatile long lD = 0L;
  volatile long lE = 0L;
  VideoAppInterface mApp;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  private boolean a(iww paramiww, long paramLong)
  {
    boolean bool = true;
    if ((paramiww == null) || (paramiww.vS())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= paramiww.lN() * 1000) {}
      for (int i = 1; i != 0; i = 0) {
        return false;
      }
    }
  }
  
  private void anJ()
  {
    if (this.mApp == null) {}
    do
    {
      return;
      this.mApp.getHandler().removeCallbacks(this);
    } while (!this.isRunning);
    this.mApp.getHandler().postDelayed(this, 1000L);
  }
  
  public iww a()
  {
    return this.c;
  }
  
  public void anK()
  {
    iww localiww = this.c;
    this.c = null;
    this.lD = 0L;
    ikz localikz = (ikz)this.mApp.a(11);
    if (localikz != null) {
      localikz.c(localiww);
    }
  }
  
  public void anL()
  {
    iww localiww = this.d;
    this.d = null;
    this.lE = 0L;
    ikz localikz = (ikz)this.mApp.a(11);
    if (localikz != null) {
      localikz.d(localiww);
    }
  }
  
  public iww b()
  {
    return this.d;
  }
  
  public boolean d(iww paramiww)
  {
    if (paramiww == null) {
      return false;
    }
    this.c = paramiww;
    if (!paramiww.vS())
    {
      this.lD = SystemClock.elapsedRealtime();
      this.isRunning = true;
      anJ();
      return true;
    }
    this.lD = 0L;
    return true;
  }
  
  public boolean e(iww paramiww)
  {
    if (paramiww == null) {
      return false;
    }
    this.d = paramiww;
    if (!paramiww.vS())
    {
      this.lE = SystemClock.elapsedRealtime();
      this.isRunning = true;
      anJ();
      return true;
    }
    this.lE = 0L;
    return true;
  }
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (a(this.c, this.lD))
    {
      bool1 = true;
      if (!a(this.d, this.lE)) {
        break label55;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.isRunning = bool1;
      anJ();
      return;
      anK();
      break;
      label55:
      anL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */