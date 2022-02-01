package com.tencent.qqmail.utilities.timer;

import android.os.Handler;
import java.util.TimerTask;

class TinyTimer$1
  extends TimerTask
{
  TinyTimer$1(TinyTimer paramTinyTimer, Handler paramHandler, int paramInt) {}
  
  public void run()
  {
    if (this.val$handler != null) {
      this.val$handler.sendEmptyMessage(this.val$what);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.timer.TinyTimer.1
 * JD-Core Version:    0.7.0.1
 */