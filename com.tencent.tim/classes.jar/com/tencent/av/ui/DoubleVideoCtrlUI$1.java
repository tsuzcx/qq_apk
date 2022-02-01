package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iiv;

class DoubleVideoCtrlUI$1
  implements Runnable
{
  DoubleVideoCtrlUI$1(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    iiv localiiv = this.this$0.a.b();
    QLog.w(this.this$0.TAG, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.Wh + "], SessionType[" + localiiv.amI + "], shutCameraAnswer[" + localiiv.Qb + "], cameraPermission[" + localiiv.Qc + "]");
    if ((!this.this$0.Wh) && (localiiv.amI == 2))
    {
      this.this$0.a.hT(localiiv.peerUin);
      if ((localiiv.Qb) || (!localiiv.Qc))
      {
        localiiv.e(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.am("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.dE(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */