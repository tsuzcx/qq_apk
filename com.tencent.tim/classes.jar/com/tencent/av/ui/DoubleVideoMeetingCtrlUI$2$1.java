package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.screenshare.ScreenShareCtrl;
import iyn;

public class DoubleVideoMeetingCtrlUI$2$1
  implements Runnable
{
  public DoubleVideoMeetingCtrlUI$2$1(iyn paramiyn) {}
  
  public void run()
  {
    ScreenShareCtrl localScreenShareCtrl = this.a.this$0.a.a();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.b(this.a.this$0.a(), 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.2.1
 * JD-Core Version:    0.7.0.1
 */