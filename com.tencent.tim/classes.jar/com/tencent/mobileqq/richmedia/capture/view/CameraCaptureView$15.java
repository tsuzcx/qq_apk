package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

class CameraCaptureView$15
  implements Runnable
{
  CameraCaptureView$15(CameraCaptureView paramCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      this.b.updateTexImage();
      this.this$0.requestRender();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CameraCaptureView", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.15
 * JD-Core Version:    0.7.0.1
 */