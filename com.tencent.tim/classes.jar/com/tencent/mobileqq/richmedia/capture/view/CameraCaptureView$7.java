package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$7
  implements Runnable
{
  CameraCaptureView$7(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    if (!this.this$0.mV.containsKey(CameraCaptureView.e.bZk)) {
      this.this$0.mV.put(CameraCaptureView.e.bZk, new RenderBuffer(this.this$0.dzc, this.this$0.dzd, 33984));
    }
    this.this$0.Op(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.7
 * JD-Core Version:    0.7.0.1
 */