package com.tencent.mobileqq.ar.ARPromotion;

import adbk;
import adbk.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(adbk paramadbk) {}
  
  public void run()
  {
    if (adbk.b(this.this$0)) {
      adbk.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + adbk.b(this.this$0) + " mCurrentPlayTimes=" + adbk.d(this.this$0) + "|" + adbk.e(this.this$0));
    if ((adbk.d(this.this$0) < adbk.e(this.this$0)) && (adbk.a(this.this$0) != null) && (!adbk.a(this.this$0))) {}
    do
    {
      try
      {
        adbk.a(this.this$0).stop();
        adbk.a(this.this$0).setOutputMute(adbk.c(this.this$0));
        adbk.a(this.this$0, adbk.a(this.this$0));
        adbk.a(this.this$0, false);
        if ((adbk.d(this.this$0)) && (adbk.a(this.this$0) != null) && (adbk.a(this.this$0) != null)) {
          adbk.a(this.this$0).aK(adbk.b(this.this$0), 1, adbk.e(this.this$0) - adbk.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (adbk.e(this.this$0) - adbk.d(this.this$0)) + "video resources:" + adbk.a(this.this$0));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, stop, exception=" + localException.getMessage());
        }
      }
      adbk.a(this.this$0, 0);
      adbk.b(this.this$0, 1);
      adbk.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((adbk.a(this.this$0) == null) || (adbk.a(this.this$0) == null));
    adbk.a(this.this$0).aK(adbk.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */