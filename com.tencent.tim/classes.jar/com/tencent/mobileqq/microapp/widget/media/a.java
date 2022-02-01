package com.tencent.mobileqq.microapp.widget.media;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

final class a
  implements Camera.AutoFocusCallback
{
  a(CameraSurfaceView paramCameraSurfaceView) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    paramCamera = CameraSurfaceView.a(this.a);
    this.a.a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.a
 * JD-Core Version:    0.7.0.1
 */