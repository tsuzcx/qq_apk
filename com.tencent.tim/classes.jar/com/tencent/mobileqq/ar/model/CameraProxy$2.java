package com.tencent.mobileqq.ar.model;

import adgw;
import adkt;
import android.graphics.SurfaceTexture;
import android.os.Build;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CameraProxy$2
  implements Runnable
{
  public CameraProxy$2(adkt paramadkt, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    QLog.i("CameraProxy", 2, "startCameraPreview.");
    if ((adkt.a(this.this$0) != 2) || (adkt.a(this.this$0) == null) || (adkt.a(this.this$0)))
    {
      QLog.i("CameraProxy", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", new Object[] { Integer.valueOf(adkt.a(this.this$0)), adkt.a(this.this$0), Boolean.valueOf(adkt.a(this.this$0)) }));
      return;
    }
    adkt.b(this.this$0, adkt.a(this.this$0).BD());
    adkt.c(this.this$0, adkt.a(this.this$0).BE());
    adkt.d(this.this$0, adkt.a(this.this$0).BF());
    adkt.a(this.this$0, adkt.a(this.this$0).a(this.this$0, this.b, this.this$0));
    if (adkt.a(this.this$0))
    {
      QLog.i("CameraProxy", 2, "start preview successfully. mCurCameraState = " + adkt.a(this.this$0));
      adkt.a(this.this$0, true, 0, 1);
      QLog.i("CameraProxy", 2, "openCamera end. mIsCameraPreviewing = " + adkt.a(this.this$0));
      return;
    }
    QLog.i("CameraProxy", 2, "start preview failed. mCurCameraState = " + adkt.a(this.this$0));
    adkt.a(this.this$0).aer();
    adkt.a(this.this$0, 0);
    adkt.a(this.this$0, false, 0, 2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("ar_type", "2");
    localHashMap.put("ar_reason", String.valueOf(-4));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.2
 * JD-Core Version:    0.7.0.1
 */