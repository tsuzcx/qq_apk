package com.tencent.mobileqq.ar.view;

import adfw;

class QRScanEntryView$9
  implements Runnable
{
  QRScanEntryView$9(QRScanEntryView paramQRScanEntryView, int paramInt) {}
  
  public void run()
  {
    if (!QRScanEntryView.b(this.this$0)) {
      if (this.cIL > adfw.a().cFa) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      if (QRScanEntryView.a(this.this$0) != bool)
      {
        QRScanEntryView.b(this.this$0, bool);
        QRScanEntryView.a(this.this$0, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */