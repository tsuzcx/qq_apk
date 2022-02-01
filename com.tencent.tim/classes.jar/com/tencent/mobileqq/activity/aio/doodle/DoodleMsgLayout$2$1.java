package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import argt;
import wja;

class DoodleMsgLayout$2$1
  implements Runnable
{
  DoodleMsgLayout$2$1(DoodleMsgLayout.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.a(this.a.this$0) != null)
    {
      argt localargt = new argt(this.dW, 0, false);
      localargt.setBounds(new Rect(0, 0, wja.dp2px(19.0F, this.a.this$0.getResources()), wja.dp2px(19.0F, this.a.this$0.getResources())));
      DoodleMsgLayout.a(this.a.this$0).setImageDrawable(localargt);
    }
    DoodleMsgLayout.b(this.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2.1
 * JD-Core Version:    0.7.0.1
 */