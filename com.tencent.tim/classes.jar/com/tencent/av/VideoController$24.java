package com.tencent.av;

import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;

class VideoController$24
  implements Runnable
{
  VideoController$24(VideoController paramVideoController, int paramInt) {}
  
  public void run()
  {
    QLog.d(VideoController.TAG, 1, "GAudioCtrl.quit start.");
    VideoController.b(this.this$0, this.this$0.a.quit(this.val$reason));
    QLog.d(VideoController.TAG, 1, "GAudioCtrl.quit end. mQuitResult = " + VideoController.a(this.this$0));
    synchronized (VideoController.a(this.this$0))
    {
      VideoController.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.24
 * JD-Core Version:    0.7.0.1
 */