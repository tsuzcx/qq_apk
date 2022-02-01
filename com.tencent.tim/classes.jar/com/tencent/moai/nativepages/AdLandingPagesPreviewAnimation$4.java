package com.tencent.moai.nativepages;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AdLandingPagesPreviewAnimation$4
  implements Animation.AnimationListener
{
  AdLandingPagesPreviewAnimation$4(AdLandingPagesPreviewAnimation paramAdLandingPagesPreviewAnimation, AdLandingPagesPreviewAnimation.ICallback paramICallback) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$callback != null) {
      this.val$callback.onAnimationEnd();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$0, AdLandingPagesPreviewAnimation.access$1700(this.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.val$callback != null) {
      this.val$callback.onAnimationStart();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$0, AdLandingPagesPreviewAnimation.access$1600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation.4
 * JD-Core Version:    0.7.0.1
 */