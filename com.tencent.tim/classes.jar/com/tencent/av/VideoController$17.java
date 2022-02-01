package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;

class VideoController$17
  implements Runnable
{
  VideoController$17(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.TAG, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
    }
    this.this$0.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(this.this$0.b().ll), Boolean.valueOf(true) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.17
 * JD-Core Version:    0.7.0.1
 */