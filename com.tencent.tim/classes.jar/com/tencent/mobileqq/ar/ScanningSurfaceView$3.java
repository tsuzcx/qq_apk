package com.tencent.mobileqq.ar;

import aqhu;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ScanningSurfaceView$3
  implements Runnable
{
  ScanningSurfaceView$3(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData) {}
  
  public void run()
  {
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.b.imgUrl, null, null, false);
      if (localURLDrawable != null)
      {
        if (localURLDrawable.getStatus() != 1)
        {
          localURLDrawable.startDownload();
          return;
        }
        this.b.eT = aqhu.g(localURLDrawable);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ScanningSurfaceView", 1, "preloadImage catch an exception.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */