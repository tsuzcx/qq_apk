package com.tencent.av;

import com.tencent.qphone.base.util.QLog;
import iiv;

class VideoController$2
  implements Runnable
{
  VideoController$2(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.TAG, 2, "connectingRunnable");
    }
    if (!this.this$0.b().isConnected())
    {
      this.this$0.O(this.this$0.b().peerUin, 216);
      this.this$0.ko(216);
      this.this$0.P(this.this$0.b().peerUin, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.2
 * JD-Core Version:    0.7.0.1
 */