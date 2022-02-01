package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import aqez.b;
import com.tencent.qphone.base.util.QLog;

public final class ScreenShotUtil$1
  implements Runnable
{
  public ScreenShotUtil$1(aqez.b paramb, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShotUtil", 2, "ScreenShot Finish Callback");
    }
    this.a.O(this.val$bmp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.1
 * JD-Core Version:    0.7.0.1
 */