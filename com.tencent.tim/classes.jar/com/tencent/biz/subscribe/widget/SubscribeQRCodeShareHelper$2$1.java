package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import sio;
import sip;

public class SubscribeQRCodeShareHelper$2$1
  implements Runnable
{
  SubscribeQRCodeShareHelper$2$1(SubscribeQRCodeShareHelper.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((sio.a(this.a.this$0) != null) && (!sio.a(this.a.this$0).isFinishing()))
    {
      sio.a(this.a.this$0, sio.a(this.a.this$0));
      if (sio.b(this.a.this$0) != null) {
        sio.b(this.a.this$0).a(sio.a(this.a.this$0), this.dd, new sip(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2.1
 * JD-Core Version:    0.7.0.1
 */