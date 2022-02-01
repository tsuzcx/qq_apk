package com.tencent.mobileqq.richmedia.capture.view;

import alwy;
import com.tencent.qphone.base.util.QLog;

class SimpleEffectsCaptureView$1
  implements Runnable
{
  SimpleEffectsCaptureView$1(SimpleEffectsCaptureView paramSimpleEffectsCaptureView) {}
  
  public void run()
  {
    SimpleEffectsCaptureView.a(this.this$0, alwy.auK());
    if (SimpleEffectsCaptureView.a(this.this$0) != null) {
      SimpleEffectsCaptureView.a(this.this$0).OB(SimpleEffectsCaptureView.a(this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onFirstFrameShownInternal soLoaded=" + SimpleEffectsCaptureView.a(this.this$0));
    }
    this.this$0.dLh();
    if (SimpleEffectsCaptureView.a(this.this$0) != null) {
      SimpleEffectsCaptureView.a(this.this$0).dLA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView.1
 * JD-Core Version:    0.7.0.1
 */