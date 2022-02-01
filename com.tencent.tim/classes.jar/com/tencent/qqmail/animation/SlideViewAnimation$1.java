package com.tencent.qqmail.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SlideViewAnimation$1
  implements Animation.AnimationListener
{
  SlideViewAnimation$1(SlideViewAnimation paramSlideViewAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Log.d(SlideViewAnimation.TAG, "debug_anim_info slide_top_2_bottom out end");
    if (SlideViewAnimation.access$100(this.this$0) != null) {
      SlideViewAnimation.access$100(this.this$0).slideTop2BottomAction();
    }
    SlideViewAnimation.access$002(this.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Log.d("yahaung", "anim-to2bottom out start");
    SlideViewAnimation.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.SlideViewAnimation.1
 * JD-Core Version:    0.7.0.1
 */