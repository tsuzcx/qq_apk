package com.tencent.biz.widgets;

import android.hardware.Camera;

class ScannerView$AutoFocusThread$1
  implements Runnable
{
  ScannerView$AutoFocusThread$1(ScannerView.AutoFocusThread paramAutoFocusThread) {}
  
  public void run()
  {
    if (this.b.mCamera == null) {
      return;
    }
    try
    {
      this.b.mCamera.cancelAutoFocus();
      label21:
      ScannerView.b(this.b.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.AutoFocusThread.1
 * JD-Core Version:    0.7.0.1
 */