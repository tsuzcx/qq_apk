package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import ankt;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import sio;

public class SubscribeQRCodeShareHelper$8
  implements Runnable
{
  public SubscribeQRCodeShareHelper$8(sio paramsio, int paramInt) {}
  
  public void run()
  {
    sio.d(this.this$0);
    if ((sio.a(this.this$0) != null) && (!sio.a(this.this$0).isFinishing()) && (sio.a(this.this$0)))
    {
      String str2 = sio.a(this.this$0, sio.a(this.this$0));
      Bitmap localBitmap = sio.b(this.this$0).ab();
      sio.b(this.this$0, String.valueOf(System.currentTimeMillis()));
      QLog.i("SubscribeQRCodeShareHelper", 2, "path : " + str2);
      String str1 = str2;
      if (sio.b(this.this$0))
      {
        str1 = str2;
        if (sio.c(this.this$0)) {
          str1 = sio.a(this.this$0, sio.a(this.this$0), str2);
        }
      }
      QLog.i("SubscribeQRCodeShareHelper", 2, "fileProviderPath : " + str1);
      WXShareHelper.a().a(str1, localBitmap, ankt.dip2px(270.0F) / 2, this.val$scene, sio.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8
 * JD-Core Version:    0.7.0.1
 */