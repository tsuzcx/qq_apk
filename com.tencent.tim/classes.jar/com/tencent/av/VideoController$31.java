package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;
import jko;
import jll;

class VideoController$31
  implements Runnable
{
  VideoController$31(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.this$0.OD) {
      return;
    }
    long l = this.this$0.bt();
    if (l > 0L)
    {
      l %= 60L;
      if (l % 30L == 0L)
      {
        String str = jll.formatTime(this.this$0.bt());
        jko.a(this.this$0.mApp).n(this.this$0.b().sessionId, this.this$0.b().amI, str);
        if ((this.this$0.mApp.isBackground_Stop) && (l % 10L == 0L)) {
          QLog.w(VideoController.TAG, 1, "chattingTimerRunnale -->updateNotification() sessionId = " + this.this$0.b().sessionId);
        }
      }
    }
    this.this$0.mApp.getHandler().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.31
 * JD-Core Version:    0.7.0.1
 */