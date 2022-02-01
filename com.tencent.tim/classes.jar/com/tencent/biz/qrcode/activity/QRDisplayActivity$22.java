package com.tencent.biz.qrcode.activity;

import android.view.View;
import aqcl;
import rts;

class QRDisplayActivity$22
  implements Runnable
{
  QRDisplayActivity$22(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    rts localrts = new rts(this.this$0.pn, this.this$0);
    this.this$0.pn.setAccessibilityDelegate(localrts);
    aqcl.Q(this.this$0.nC, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.22
 * JD-Core Version:    0.7.0.1
 */