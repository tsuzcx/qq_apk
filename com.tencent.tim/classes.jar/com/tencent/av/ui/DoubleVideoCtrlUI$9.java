package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;

class DoubleVideoCtrlUI$9
  implements Runnable
{
  DoubleVideoCtrlUI$9(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    String str = this.this$0.mApp.getCurrentAccountUin();
    int i = this.this$0.a.b().anm;
    QLog.w(this.this$0.TAG, 1, "onResume, setGlass, nCurrentSwitch[" + i + "]");
    this.this$0.mApp.l(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    DoubleVideoCtrlUI.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.9
 * JD-Core Version:    0.7.0.1
 */