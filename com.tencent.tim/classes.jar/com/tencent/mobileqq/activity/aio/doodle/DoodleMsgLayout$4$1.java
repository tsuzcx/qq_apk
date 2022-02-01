package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$4$1
  implements Runnable
{
  DoodleMsgLayout$4$1(DoodleMsgLayout.4 param4, Drawable paramDrawable1, Drawable paramDrawable2) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + DoodleMsgLayout.a(this.a.this$0));
    if ((this.dH != null) && (DoodleMsgLayout.b(this.a.this$0) != null)) {
      DoodleMsgLayout.b(this.a.this$0).setImageDrawable(this.dH);
    }
    if (DoodleMsgLayout.c(this.a.this$0) != null) {
      DoodleMsgLayout.c(this.a.this$0).setImageDrawable(this.dI);
    }
    if (this.dH != null)
    {
      Drawable localDrawable = ((URLDrawable)this.dH).getCurrDrawable();
      if ((localDrawable instanceof GifDrawable)) {
        ((GifDrawable)localDrawable).getImage().reset();
      }
      ((URLDrawable)this.dH).setIndividualPause(false);
    }
    DoodleMsgLayout.a(this.a.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4.1
 * JD-Core Version:    0.7.0.1
 */