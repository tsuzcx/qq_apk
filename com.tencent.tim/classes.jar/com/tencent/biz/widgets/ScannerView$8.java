package com.tencent.biz.widgets;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;

class ScannerView$8
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      label6:
      Camera localCamera = this.this$0.mCamera;
      if (localCamera == null)
      {
        this.this$0.aJ.obtainMessage(10, Boolean.FALSE).sendToTarget();
        return;
      }
      ScannerView.a(this.this$0, localCamera, this.aNJ);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.8
 * JD-Core Version:    0.7.0.1
 */