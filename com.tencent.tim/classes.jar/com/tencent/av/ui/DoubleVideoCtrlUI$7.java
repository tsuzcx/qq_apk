package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;

class DoubleVideoCtrlUI$7
  implements Runnable
{
  DoubleVideoCtrlUI$7(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (!this.this$0.isDestroyed())
    {
      iiv localiiv = this.this$0.a.b();
      this.this$0.a.O(localiiv.peerUin, 239);
      this.this$0.a.ko(239);
      this.this$0.a.P(localiiv.peerUin, 9);
      this.this$0.mApp.l(new Object[] { Integer.valueOf(28), localiiv.peerUin, Boolean.valueOf(true) });
      QLog.w(this.this$0.TAG, 1, "onCreate, exit when OnCreate, seq[" + this.kQ + "]");
      this.this$0.mApp.q(this.kQ, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.7
 * JD-Core Version:    0.7.0.1
 */