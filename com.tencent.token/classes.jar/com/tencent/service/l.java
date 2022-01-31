package com.tencent.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.token.global.h;
import java.util.ArrayList;

class l
  extends Handler
{
  public l(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (g)paramMessage.obj;
    paramMessage.a.setIdle(true);
    if (!k.a(this.a).contains(paramMessage.b)) {
      h.b("Discard pic");
    }
    while ((k.b(this.a) == null) || (k.c(this.a) == null)) {
      return;
    }
    if (paramMessage.c == 0) {
      if (k.d(this.a) == null)
      {
        k.a(this.a, paramMessage);
        k.e(this.a);
      }
    }
    for (;;)
    {
      k.a(this.a).remove(paramMessage.b);
      if (k.f(this.a) != 4) {
        break label345;
      }
      k.a(this.a, System.currentTimeMillis());
      h.b("检测了" + k.g(this.a) + "帧数据 检测到" + 4 + "张人脸时间: " + (k.h(this.a) - k.i(this.a)) + " 最大分数: " + k.d(this.a).d.qualityScore());
      k.b(this.a).a(k.d(this.a).b.a, k.d(this.a).d.faceData(), k.g(this.a));
      k.a(this.a, null);
      k.a(this.a, 0);
      k.b(this.a, 0);
      return;
      if (paramMessage.d.qualityScore() <= k.d(this.a).d.qualityScore()) {
        break;
      }
      k.a(this.a, paramMessage);
      break;
      FaceServiceDelegate.FaceDetectErrorCode localFaceDetectErrorCode = FaceServiceDelegate.FaceDetectErrorCode.values()[paramMessage.c];
      k.b(this.a).a(localFaceDetectErrorCode);
    }
    label345:
    k.b(this.a).a();
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.e("FaceService", "Unknown message type " + paramMessage.what);
      return;
    }
    a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.l
 * JD-Core Version:    0.7.0.1
 */