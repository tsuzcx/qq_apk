package com.tencent.biz.qqstory.view;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.Animation.AnimationListener;

class AnimationPoint$1
  implements Runnable
{
  AnimationPoint$1(AnimationPoint paramAnimationPoint) {}
  
  public void run()
  {
    if (this.this$0.aJr) {
      return;
    }
    if ((SystemClock.uptimeMillis() - this.this$0.mStartTime < this.this$0.mDuration) || (this.this$0.mDuration < 0L)) {
      this.this$0.mUIHandler.postDelayed(this, 30L);
    }
    for (;;)
    {
      this.this$0.invalidate();
      return;
      if (this.this$0.a != null) {
        this.this$0.a.onAnimationEnd(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint.1
 * JD-Core Version:    0.7.0.1
 */