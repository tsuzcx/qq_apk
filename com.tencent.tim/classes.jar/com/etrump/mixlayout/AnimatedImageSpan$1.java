package com.etrump.mixlayout;

import android.os.Handler;
import kk;

public class AnimatedImageSpan$1
  implements Runnable
{
  public AnimatedImageSpan$1(kk paramkk, Handler paramHandler) {}
  
  public void run()
  {
    if ((kk.a(this.this$0) != null) && ((kk.a(this.this$0) instanceof AnimatedImageDrawable)))
    {
      AnimatedImageDrawable localAnimatedImageDrawable = (AnimatedImageDrawable)kk.a(this.this$0);
      localAnimatedImageDrawable.nextFrame();
      this.val$mHandler.postDelayed(this, localAnimatedImageDrawable.av());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageSpan.1
 * JD-Core Version:    0.7.0.1
 */