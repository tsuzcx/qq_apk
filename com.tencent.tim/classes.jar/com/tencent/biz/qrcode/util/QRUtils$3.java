package com.tencent.biz.qrcode.util;

import android.graphics.Bitmap;
import android.view.View;
import aqmp;
import com.tencent.qphone.base.util.QLog;
import rwt;

public final class QRUtils$3
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = rwt.a(this.val$resources, this.aDL, Integer.valueOf(this.val$view.getWidth()), Integer.valueOf(this.val$view.getHeight()));
    QLog.d("QRUtils", 2, " qrWhiteBitmap = " + localBitmap);
    if (localBitmap != null) {}
    try
    {
      aqmp.fastblur(localBitmap, this.bvE);
      if (this.val$view != null) {
        this.val$view.post(new QRUtils.3.1(this, localBitmap));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils.3
 * JD-Core Version:    0.7.0.1
 */