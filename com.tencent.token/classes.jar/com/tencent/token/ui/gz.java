package com.tencent.token.ui;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.LiveThreshold;
import com.tencent.token.global.h;

class gz
  implements Runnable
{
  gz(gx paramgx) {}
  
  public void run()
  {
    synchronized (this.a.e)
    {
      if (!this.a.o)
      {
        long l = System.currentTimeMillis();
        LiveThreshold localLiveThreshold = new LiveThreshold();
        gx.a(this.a, localLiveThreshold);
        h.a("shakeAngle" + localLiveThreshold.shakeAngle());
        h.a("nodAngle" + localLiveThreshold.nodAngle());
        h.a("mouthOpenScore" + localLiveThreshold.mouthOpenScore());
        h.a("blinkScore" + localLiveThreshold.blinkScore());
        h.a("downAngle" + localLiveThreshold.downAngle());
        this.a.m = FaceDetector.LiveDetectInitial(gx.e(this.a), localLiveThreshold);
        com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon.i = (int)(System.currentTimeMillis() - l);
        if (this.a.m)
        {
          gx.a(this.a, System.currentTimeMillis());
          gx.b(this.a, false);
          this.a.o = true;
        }
        h.d("LiveDetectInitial,ret=" + this.a.m + ",livemodelfile=" + gx.e(this.a));
        h.a("LiveDetectInitial,ret=" + this.a.m + ",livemodelfile=" + gx.e(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gz
 * JD-Core Version:    0.7.0.1
 */