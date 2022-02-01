package com.tencent.moai.nativepages;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AdLandingPagesPreviewAnimation$1$1
  implements Animator.AnimatorListener
{
  AdLandingPagesPreviewAnimation$1$1(AdLandingPagesPreviewAnimation.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AdLandingPagesPreviewAnimation.access$002(this.this$1.this$0, AdLandingPagesPreviewAnimation.access$200(this.this$1.this$0));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onAnimationEnd();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$1.this$0, AdLandingPagesPreviewAnimation.access$200(this.this$1.this$0));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onAnimationStart();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$1.this$0, AdLandingPagesPreviewAnimation.access$100(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */