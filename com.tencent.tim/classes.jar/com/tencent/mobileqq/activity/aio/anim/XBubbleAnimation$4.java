package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import wnw;

public class XBubbleAnimation$4
  extends View
{
  public XBubbleAnimation$4(wnw paramwnw, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.this$0.c.isStarted()) || (this.this$0.d.isStarted())) {
      this.this$0.handler.post(new XBubbleAnimation.4.1(this));
    }
    if ((this.this$0.c.mFinished) && (this.this$0.d.mFinished)) {
      this.this$0.handler.post(new XBubbleAnimation.4.2(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.4
 * JD-Core Version:    0.7.0.1
 */