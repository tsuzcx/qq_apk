package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Map;

class CameraCaptureView$8
  implements Runnable
{
  CameraCaptureView$8(CameraCaptureView paramCameraCaptureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (!this.this$0.mV.containsKey(CameraCaptureView.e.bZl)) {
      this.this$0.mV.put(CameraCaptureView.e.bZl, new RenderBuffer(this.dzq, this.dzr, 33984));
    }
    if (!this.this$0.mV.containsKey(CameraCaptureView.e.bZm)) {
      this.this$0.mV.put(CameraCaptureView.e.bZm, new RenderBuffer(this.this$0.dyU, this.this$0.dyV, 33984));
    }
    if (!this.this$0.mV.containsKey(CameraCaptureView.e.bZn)) {
      this.this$0.mV.put(CameraCaptureView.e.bZn, new RenderBuffer(this.dzs, this.dzt, 33984));
    }
    if (!this.this$0.mV.containsKey(CameraCaptureView.e.bZo)) {
      this.this$0.mV.put(CameraCaptureView.e.bZo, new RenderBuffer(this.this$0.dyW, this.this$0.dyX, 33984));
    }
    this.this$0.Op(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.8
 * JD-Core Version:    0.7.0.1
 */