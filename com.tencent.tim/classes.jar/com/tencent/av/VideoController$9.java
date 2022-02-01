package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import iiv;

class VideoController$9
  implements Runnable
{
  VideoController$9(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    iiv localiiv = this.this$0.b();
    if ((localiiv.PT) && (localiiv.Qb) && (localiiv.amI == 2))
    {
      localiiv.n(this.kQ, false);
      this.this$0.a.pauseVideo(localiiv.peerUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.9
 * JD-Core Version:    0.7.0.1
 */