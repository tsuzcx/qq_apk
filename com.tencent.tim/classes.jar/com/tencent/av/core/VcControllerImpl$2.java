package com.tencent.av.core;

import com.tencent.qphone.base.util.QLog;
import imk;

class VcControllerImpl$2
  implements Runnable
{
  VcControllerImpl$2(VcControllerImpl paramVcControllerImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (VcControllerImpl.mDisableReOpen) {
      QLog.w("VcControllerImpl", 1, "changePreviewSize, 禁止响应重开摄像头, w[" + this.val$w + "], h[" + this.val$h + "]");
    }
    while (this.this$0.mEventListener == null) {
      return;
    }
    this.this$0.mEventListener.bp(this.val$w, this.val$h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */