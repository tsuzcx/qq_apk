package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iiv;

class ScreenShareCtrl$2
  implements Runnable
{
  ScreenShareCtrl$2(ScreenShareCtrl paramScreenShareCtrl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVShare", 2, "SetTimeOut_Double2Meeting timeOut ");
    }
    ScreenShareCtrl.a(this.this$0).P(ScreenShareCtrl.a(this.this$0).b().peerUin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.2
 * JD-Core Version:    0.7.0.1
 */