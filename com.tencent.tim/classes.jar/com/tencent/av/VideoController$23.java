package com.tencent.av;

import aqiw;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import mqq.app.MobileQQ;

class VideoController$23
  implements Runnable
{
  VideoController$23(VideoController paramVideoController, int paramInt, long paramLong) {}
  
  public void run()
  {
    this.this$0.mTimeOutRunnable = null;
    this.this$0.b().Y("acceptGAudioChat", 0);
    boolean bool = aqiw.isNetworkAvailable(this.this$0.mApp.getApplication().getApplicationContext());
    VideoController localVideoController = this.this$0;
    int j = this.alN;
    long l = this.kR;
    if (bool) {}
    for (int i = 69;; i = 68)
    {
      localVideoController.a(j, l, i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.23
 * JD-Core Version:    0.7.0.1
 */