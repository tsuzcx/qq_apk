package com.tencent.token.ui;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.token.do;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;

class afe
  implements Runnable
{
  afe(VerifySuccActivity paramVerifySuccActivity, ImageView paramImageView) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = k.b(VerifySuccActivity.access$200(this.b) + "", w.f(VerifySuccActivity.access$200(this.b)) + " ");
    this.a.setImageDrawable(localBitmapDrawable);
    do.a().f(VerifySuccActivity.access$200(this.b));
    do.a().a(VerifySuccActivity.access$300(this.b));
    this.a.forceLayout();
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afe
 * JD-Core Version:    0.7.0.1
 */