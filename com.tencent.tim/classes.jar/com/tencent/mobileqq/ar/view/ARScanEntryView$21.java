package com.tencent.mobileqq.ar.view;

import adcl;
import adec;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$21
  implements Runnable
{
  ARScanEntryView$21(ARScanEntryView paramARScanEntryView, adec paramadec) {}
  
  public void run()
  {
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.g(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if (((!adcl.a().adA()) || (adcl.a().adB())) && (!this.b.b.aef()) && (!this.b.b.aeg()))
    {
      adcl.a().cQa();
      adcl.a().cQc();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
      return;
    }
    if (this.b.b.aef())
    {
      adcl.a().cQb();
      QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
      return;
    }
    QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.21
 * JD-Core Version:    0.7.0.1
 */