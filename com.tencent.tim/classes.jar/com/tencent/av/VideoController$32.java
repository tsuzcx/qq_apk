package com.tencent.av;

import com.tencent.qphone.base.util.QLog;

class VideoController$32
  implements Runnable
{
  VideoController$32(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoController.TAG, 2, "quitDoubleVideoMeeting, time out task run.");
    }
    if (this.this$0.c != null) {
      this.this$0.c.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.32
 * JD-Core Version:    0.7.0.1
 */