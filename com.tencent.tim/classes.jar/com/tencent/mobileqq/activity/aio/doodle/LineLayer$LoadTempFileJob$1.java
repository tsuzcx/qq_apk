package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import wrt;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.b) != null)
    {
      wrt localwrt = (wrt)LineLayer.LoadTempFileJob.a(this.b).get();
      if (localwrt != null) {
        localwrt.a(LineLayer.LoadTempFileJob.a(this.b), this.bRq, LineLayer.LoadTempFileJob.b(this.b), this.dX);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */