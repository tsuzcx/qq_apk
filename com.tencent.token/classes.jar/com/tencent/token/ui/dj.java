package com.tencent.token.ui;

import com.tencent.jni.FaceDetector;
import com.tencent.token.global.h;

class dj
  implements Runnable
{
  dj(di paramdi) {}
  
  public void run()
  {
    try
    {
      synchronized (this.a.e)
      {
        try
        {
          di.a(this.a, true);
          di.a(this.a);
          di.b(this.a, FaceDetector.IdCardDetectInitial(di.b(this.a)));
          h.c("IdCardDetectInitial: " + di.c(this.a) + ",mIdCardModelPath=" + di.b(this.a));
          di.c(this.a, true);
          di.a(this.a, false);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        localError.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dj
 * JD-Core Version:    0.7.0.1
 */