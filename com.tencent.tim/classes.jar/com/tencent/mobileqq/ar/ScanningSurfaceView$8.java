package com.tencent.mobileqq.ar;

import adfd;
import adga;
import akqe;
import com.tencent.qphone.base.util.QLog;

public class ScanningSurfaceView$8
  implements Runnable
{
  ScanningSurfaceView$8(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData1, ScanningData paramScanningData2) {}
  
  public void run()
  {
    if ((this.c != null) && (this.c.bMt) && (this.c.isStar))
    {
      this.c.stopAnimation();
      this.c.cRr();
      this.c.bMt = false;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "4=" + this.c.bMt);
      }
      this.c.isClicked = false;
      ScanningSurfaceView.a(this.this$0, this.c);
    }
    if (this.d != null)
    {
      this.d.stopAnimation();
      this.d.cRr();
      this.d.bMt = true;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "5=" + this.d.bMt);
      }
      this.d.isClicked = true;
      this.this$0.b.a.a(3, this.d.bsB, this.d.bsC, new adga(this));
      ScanningSurfaceView.a(this.this$0, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.8
 * JD-Core Version:    0.7.0.1
 */