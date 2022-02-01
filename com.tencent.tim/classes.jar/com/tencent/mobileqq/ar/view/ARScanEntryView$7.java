package com.tencent.mobileqq.ar.view;

import adkw;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$7
  implements Runnable
{
  ARScanEntryView$7(ARScanEntryView paramARScanEntryView, long paramLong, adkw paramadkw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig start time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - ARScanEntryView.a(this.this$0)) }));
    }
    long l1 = 0L;
    int i;
    long l2;
    if ((this.UZ & 0x4) != 0L)
    {
      i = 1;
      if (!this.a.iN(2)) {
        l1 = 0L | 0x2;
      }
      l2 = l1;
      if (!this.a.iN(8)) {
        l2 = l1 | 0x8;
      }
      if ((this.a.iN(4)) || (i == 0)) {
        break label294;
      }
      l2 |= 0x4;
    }
    for (;;)
    {
      this.a.a(l2, ARScanEntryView.a(this.this$0), ARScanEntryView.a(this.this$0));
      boolean bool = this.a.afa();
      if ((this.a.iN(4)) || (i == 0)) {
        ARScanEntryView.b(this.this$0, 100);
      }
      if (bool)
      {
        ARScanEntryView.a(this.this$0, 100);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig end time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - ARScanEntryView.a(this.this$0)) }));
        }
        if (ARScanEntryView.a(this.this$0) != null)
        {
          ARScanEntryView.a(this.this$0).removeMessages(324);
          ARScanEntryView.a(this.this$0).sendEmptyMessage(324);
        }
      }
      if ((bool) && (ARScanEntryView.a(this.this$0) != 100)) {
        this.this$0.cSI();
      }
      return;
      i = 0;
      break;
      label294:
      ARScanEntryView.b(this.this$0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.7
 * JD-Core Version:    0.7.0.1
 */