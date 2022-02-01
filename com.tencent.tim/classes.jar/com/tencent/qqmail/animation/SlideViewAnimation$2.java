package com.tencent.qqmail.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SlideViewAnimation$2
  implements Animation.AnimationListener
{
  SlideViewAnimation$2(SlideViewAnimation paramSlideViewAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Log.d(SlideViewAnimation.TAG, "debug_anim_info slide_bottom_2_top out end");
    SlideViewAnimation.access$002(this.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (SlideViewAnimation.access$100(this.this$0) != null) {
      SlideViewAnimation.access$100(this.this$0).slideBottom2TopAction();
    }
    SlideViewAnimation.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.SlideViewAnimation.2
 * JD-Core Version:    0.7.0.1
 */