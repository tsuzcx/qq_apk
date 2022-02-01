package com.tencent.mobileqq.ar.view;

import adec;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;

class ARScanEntryView$8
  implements Runnable
{
  ARScanEntryView$8(ARScanEntryView paramARScanEntryView, adec paramadec) {}
  
  public void run()
  {
    ARScanEntryView.a(this.this$0, true);
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if ((this.this$0.bOU) && (this.this$0.bPu))
    {
      this.this$0.bAH();
      return;
    }
    ARScanEntryView.a(this.this$0, this.b.b.a.but);
    this.this$0.bOV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.8
 * JD-Core Version:    0.7.0.1
 */