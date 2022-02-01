package com.tencent.mobileqq.activity.aio.doodle;

import java.util.TimerTask;
import wra;

class DoodleMsgView$2
  extends TimerTask
{
  DoodleMsgView$2(DoodleMsgView paramDoodleMsgView, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    try
    {
      wra localwra = DoodleMsgView.a(this.this$0);
      if (localwra == null)
      {
        this.this$0.runOnUIThread(new DoodleMsgView.2.1(this));
        return;
      }
      if (DoodleMsgView.a(this.this$0) < 0L) {
        DoodleMsgView.a(this.this$0, this.It);
      }
      if (DoodleMsgView.a(this.this$0) < this.It) {
        DoodleMsgView.a(this.this$0, DoodleMsgView.a(this.this$0) + this.Iu);
      }
      if (localwra != null) {
        localwra.k(DoodleMsgView.a(this.this$0), true);
      }
      if (DoodleMsgView.a(this.this$0) >= this.It)
      {
        DoodleMsgView.a(this.this$0);
        return;
      }
      if ((!DoodleMsgView.a(this.this$0)) && (localwra != null)) {
        localwra.k(this.It, true);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.2
 * JD-Core Version:    0.7.0.1
 */