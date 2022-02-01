package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import ankt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import rze;
import sio;

public class SubscribeQRCodeShareHelper$2
  implements Runnable
{
  public SubscribeQRCodeShareHelper$2(sio paramsio) {}
  
  public void run()
  {
    Bitmap localBitmap = rze.a(sio.b(this.this$0), ankt.dip2px(50.0F), -16777216, -1, Bitmap.Config.ARGB_8888);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code");
      return;
    }
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.2.1(this, localBitmap));
    QLog.d("SubscribeQRCodeShareHelper", 4, " create card code success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2
 * JD-Core Version:    0.7.0.1
 */