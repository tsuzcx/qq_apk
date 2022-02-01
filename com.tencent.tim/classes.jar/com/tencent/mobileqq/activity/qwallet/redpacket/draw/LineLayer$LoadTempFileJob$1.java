package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aafb;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.b) != null)
    {
      aafb localaafb = (aafb)LineLayer.LoadTempFileJob.a(this.b).get();
      if (localaafb != null) {
        localaafb.a(LineLayer.LoadTempFileJob.a(this.b), this.bRq, LineLayer.LoadTempFileJob.b(this.b), this.dX);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */