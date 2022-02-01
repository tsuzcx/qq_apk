package com.tencent.TMG.camera;

import android.hardware.Camera;
import com.tencent.TMG.utils.QLog;

class VcCamera$2
  implements Runnable
{
  VcCamera$2(VcCamera paramVcCamera, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.mCamera == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer())
        {
          this.this$0.mCamera.setPreviewCallbackWithBuffer(null);
          this.this$0.mCamera.stopPreview();
          VcCamera.access$200(this.this$0, this.val$w, this.val$h);
          this.this$0.mCallbackBufferAddStrategy.setCameraCaptureSettings(this.this$0.VideoChatSettings);
          this.this$0.mCallbackBufferAddStrategy.fistAdd(this.this$0.mCamera);
          if (!this.this$0.mCallbackBufferAddStrategy.getIsUseBuffer()) {
            break label164;
          }
          this.this$0.mCamera.setPreviewCallbackWithBuffer(VcCamera.access$100(this.this$0));
          this.this$0.mCamera.startPreview();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("VcCamera", 0, "setCameraParaDynamic error", localException);
        localException.printStackTrace();
        return;
      }
      this.this$0.mCamera.setPreviewCallback(null);
      continue;
      label164:
      this.this$0.mCamera.setPreviewCallback(VcCamera.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.2
 * JD-Core Version:    0.7.0.1
 */