package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;
import ivp;

public class SmallScreenDoubleVideoControlUI$1
  implements Runnable
{
  public SmallScreenDoubleVideoControlUI$1(ivp paramivp, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.mApp != null))
    {
      iiv localiiv = this.this$0.a.b();
      this.this$0.a.O(localiiv.peerUin, 225);
      this.this$0.a.ko(225);
      this.this$0.a.P(localiiv.peerUin, 9);
      this.this$0.mApp.l(new Object[] { Integer.valueOf(28), localiiv.peerUin, Boolean.valueOf(true) });
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "exit when onCreate fail, seq[" + this.kQ + "]");
      this.this$0.mApp.q(this.kQ, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */