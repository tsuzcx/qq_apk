package com.tencent.mobileqq.activity.registerGuideLogin;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

class TimLoginQQView$20$1
  implements Runnable
{
  TimLoginQQView$20$1(TimLoginQQView.20 param20, Object paramObject) {}
  
  public void run()
  {
    if (this.cf != null)
    {
      this.a.this$0.a.bE(true, this.cf);
      if ((this.cf instanceof Bitmap))
      {
        this.a.this$0.mK.setImageBitmap((Bitmap)this.cf);
        return;
      }
      if ((this.cf instanceof Drawable))
      {
        this.a.this$0.mK.setImageDrawable((Drawable)this.cf);
        return;
      }
      this.a.this$0.mK.setImageResource(2130851638);
      return;
    }
    if (TimLoginQQView.e(this.a.this$0)) {
      this.a.this$0.a.bE(true, null);
    }
    for (;;)
    {
      this.a.this$0.mK.setImageResource(2130851638);
      return;
      this.a.this$0.a.bE(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.20.1
 * JD-Core Version:    0.7.0.1
 */