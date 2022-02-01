package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import jbz;

class QavPanel$7
  implements Runnable
{
  QavPanel$7(QavPanel paramQavPanel, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    if ((this.this$0.mApp == null) || (this.this$0.a[this.val$menuType] == null)) {
      return;
    }
    if (this.val$menuType != this.this$0.awU)
    {
      QLog.w(this.this$0.TAG, 1, "doShowAnimation, invalid menuType[" + this.val$menuType + "], curMenuType[" + this.this$0.awU + "], seq[" + this.kQ + "]");
      return;
    }
    this.this$0.a[this.val$menuType].h(this.kQ, this.XJ, this.axe);
    this.this$0.mApp.l(new Object[] { Integer.valueOf(123), Integer.valueOf(this.val$menuType), Long.valueOf(this.kQ) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.7
 * JD-Core Version:    0.7.0.1
 */