package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;

class DoubleVideoCtrlUI$13
  implements Runnable
{
  DoubleVideoCtrlUI$13(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.mApp != null))
    {
      this.this$0.a.O(this.this$0.a.b().peerUin, 233);
      this.this$0.a.ko(233);
      this.this$0.a.P(this.this$0.a.b().peerUin, 9);
      QLog.d(this.this$0.TAG, 1, "exit when onBackPressed");
      this.this$0.mApp.q(this.kQ, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.13
 * JD-Core Version:    0.7.0.1
 */