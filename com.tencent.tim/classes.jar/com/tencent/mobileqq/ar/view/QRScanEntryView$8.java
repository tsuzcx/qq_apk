package com.tencent.mobileqq.ar.view;

import acfp;
import android.widget.CheckBox;
import com.tencent.mobileqq.widget.QQToast;

class QRScanEntryView$8
  implements Runnable
{
  QRScanEntryView$8(QRScanEntryView paramQRScanEntryView) {}
  
  public void run()
  {
    QRScanEntryView.a(this.this$0).setChecked(false);
    QQToast.a(this.this$0.getContext(), acfp.m(2131712613), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.8
 * JD-Core Version:    0.7.0.1
 */