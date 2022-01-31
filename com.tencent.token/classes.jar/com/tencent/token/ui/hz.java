package com.tencent.token.ui;

import com.tencent.jni.FaceDetector;
import com.tencent.token.global.e;

final class hz
  implements Runnable
{
  hz(hx paramhx) {}
  
  public final void run()
  {
    synchronized (this.a.e)
    {
      if (!this.a.l)
      {
        long l = System.currentTimeMillis();
        this.a.j = FaceDetector.LiveDetectInitial(hx.e(this.a));
        com.tencent.token.cv.h = (int)(System.currentTimeMillis() - l);
        if (this.a.j)
        {
          hx.a(this.a, System.currentTimeMillis());
          hx.f(this.a);
          this.a.l = true;
        }
        e.d("LiveDetectInitial,ret=" + this.a.j + ",livemodelfile=" + hx.e(this.a));
        e.a("LiveDetectInitial,ret=" + this.a.j + ",livemodelfile=" + hx.e(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hz
 * JD-Core Version:    0.7.0.1
 */