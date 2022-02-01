package com.tencent.biz.qrcode.activity;

import acdt;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import aqhu;
import com.tencent.mobileqq.app.QQAppInterface;

class QRDisplayActivity$4$1
  implements Runnable
{
  QRDisplayActivity$4$1(QRDisplayActivity.4 param4) {}
  
  public void run()
  {
    if (this.a.this$0.type == 1) {
      this.a.this$0.cT = this.a.this$0.app.getFaceBitmap(this.a.this$0.uin, false);
    }
    for (;;)
    {
      if (this.a.this$0.cT == null) {
        this.a.this$0.cT = aqhu.G();
      }
      return;
      if (this.a.this$0.type == 2)
      {
        this.a.this$0.cT = this.a.this$0.app.a(this.a.this$0.uin, (byte)1, false, false);
        if (this.a.this$0.cT == null) {
          this.a.this$0.cT = aqhu.aL();
        }
      }
      else
      {
        Drawable localDrawable = this.a.this$0.a.a(this.a.this$0.uin, true);
        if ((localDrawable instanceof BitmapDrawable)) {
          this.a.this$0.cT = ((BitmapDrawable)localDrawable).getBitmap();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.4.1
 * JD-Core Version:    0.7.0.1
 */