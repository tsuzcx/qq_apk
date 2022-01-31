package com.tencent.token.ui;

import com.tencent.jni.FaceThreshold;
import com.tencent.service.k;
import com.tencent.token.global.h;

class gy
  implements Runnable
{
  gy(gx paramgx) {}
  
  public void run()
  {
    synchronized (this.a.d)
    {
      if (gx.a(this.a) == null)
      {
        gx.a(this.a, true);
        long l = System.currentTimeMillis();
        gx.b(this.a);
        com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon.g = (int)(System.currentTimeMillis() - l);
        gx.a(this.a, new k(gx.c(this.a), this.a, gx.d(this.a)));
        FaceThreshold localFaceThreshold = new FaceThreshold();
        gx.a(this.a, localFaceThreshold);
        h.a("validateLightHigh" + localFaceThreshold.validateLightHigh());
        h.a("validateLightLow" + localFaceThreshold.validateLightLow());
        h.a("registerLightLow" + localFaceThreshold.registerLightLow());
        h.a("registerLightHigh" + localFaceThreshold.registerLightHigh());
        h.a("faceDisparity" + localFaceThreshold.faceDisparity());
        gx.a(this.a).a(localFaceThreshold);
        gx.a(this.a, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gy
 * JD-Core Version:    0.7.0.1
 */