package com.tencent.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import java.util.ArrayList;

final class f
  extends Handler
{
  public f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.e("FaceService", "Unknown message type " + paramMessage.what);
    }
    do
    {
      return;
      paramMessage = (a)paramMessage.obj;
      paramMessage.a.setIdle(true);
      if (!e.a(this.a).contains(paramMessage.b))
      {
        com.tencent.token.global.e.b("Discard pic");
        return;
      }
    } while ((e.b(this.a) == null) || (e.c(this.a) == null));
    if (paramMessage.c == 0) {
      if (e.d(this.a) == null)
      {
        e.a(this.a, paramMessage);
        label138:
        e.e(this.a);
      }
    }
    for (;;)
    {
      e.a(this.a).remove(paramMessage.b);
      if (e.f(this.a) != 4) {
        break;
      }
      e.a(this.a, System.currentTimeMillis());
      com.tencent.token.global.e.b("检测了" + e.g(this.a) + "帧数据" + " 检测到" + 4 + "张人脸时间: " + (e.h(this.a) - e.i(this.a)) + " 最大分数: " + e.d(this.a).d.qualityScore());
      e.b(this.a).a(e.d(this.a).d.faceData(), e.g(this.a));
      e.a(this.a, null);
      e.j(this.a);
      e.k(this.a);
      return;
      if (paramMessage.d.qualityScore() <= e.d(this.a).d.qualityScore()) {
        break label138;
      }
      e.a(this.a, paramMessage);
      break label138;
      FaceServiceDelegate.FaceDetectErrorCode localFaceDetectErrorCode = FaceServiceDelegate.FaceDetectErrorCode.values()[paramMessage.c];
      e.b(this.a).a(localFaceDetectErrorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.f
 * JD-Core Version:    0.7.0.1
 */