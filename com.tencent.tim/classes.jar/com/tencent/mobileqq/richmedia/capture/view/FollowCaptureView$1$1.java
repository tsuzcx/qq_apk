package com.tencent.mobileqq.richmedia.capture.view;

import alxw;
import android.graphics.SurfaceTexture;
import com.tencent.qphone.base.util.QLog;

public class FollowCaptureView$1$1
  implements Runnable
{
  public FollowCaptureView$1$1(alxw paramalxw, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      this.b.updateTexImage();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FollowCaptureView", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView.1.1
 * JD-Core Version:    0.7.0.1
 */