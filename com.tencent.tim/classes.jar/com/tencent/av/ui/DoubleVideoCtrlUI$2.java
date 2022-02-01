package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iiv;
import iwu;

class DoubleVideoCtrlUI$2
  implements Runnable
{
  DoubleVideoCtrlUI$2(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    do
    {
      return;
      long l = AudioHelper.hG();
      if ((!this.this$0.a.sq()) && (this.this$0.a.b().amK == 1) && (this.this$0.a.b().PY))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 1, "FixTerSwitchStatus ,switch to pc ,local close camera, seq[" + l + "]");
        }
        this.this$0.bZ(l);
        this.this$0.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        iwu.b(this.this$0.mApp, 1021);
      }
      this.this$0.O(l, 65535);
    } while (!this.this$0.a.b().PV);
    this.this$0.a.b(true, this.this$0.a.b().peerUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.2
 * JD-Core Version:    0.7.0.1
 */