package com.tencent.mobileqq.ar.model;

import adgw;
import adkt;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(adkt paramadkt) {}
  
  public void run()
  {
    if ((adkt.a(this.this$0) != 3) || (adkt.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + adkt.a(this.this$0));
      return;
    }
    if (adkt.a(this.this$0)) {
      adkt.a(this.this$0).stopPreview();
    }
    adkt.a(this.this$0, false);
    adkt.a(this.this$0).aer();
    if (adkt.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + adkt.a(this.this$0));
      return;
    }
    adkt.a(this.this$0, 0);
    adkt.a(this.this$0, null);
    adkt.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + adkt.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */