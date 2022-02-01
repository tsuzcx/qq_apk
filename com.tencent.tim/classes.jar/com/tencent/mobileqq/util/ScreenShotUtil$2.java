package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import aqez.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;

public final class ScreenShotUtil$2
  implements Runnable
{
  public ScreenShotUtil$2(WebView paramWebView, Canvas paramCanvas, aqez.a parama, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      this.g.getX5WebViewExtension().snapshotWholePage(this.val$canvas, false, false);
      Object localObject = this.a.a(this.val$bmp);
      ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.1(this, localObject));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage error : " + localException.getMessage());
      ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.2(this, localException));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage out of memory ");
      if (this.val$bmp != null) {
        this.val$bmp.recycle();
      }
      ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.2
 * JD-Core Version:    0.7.0.1
 */