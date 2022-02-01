package com.tencent.moai.nativepages;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import java.util.Iterator;
import java.util.LinkedList;

class AdLandingPagesPreviewAnimation$1
  implements Animator.AnimatorListener
{
  AdLandingPagesPreviewAnimation$1(AdLandingPagesPreviewAnimation paramAdLandingPagesPreviewAnimation, AdLandingPagesPreviewAnimation.ICallback paramICallback, View paramView, LinkedList paramLinkedList) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AdLandingPagesPreviewAnimation.access$002(this.this$0, AdLandingPagesPreviewAnimation.access$200(this.this$0));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.val$callback != null) {
      this.val$callback.onAnimationEnd();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$0, AdLandingPagesPreviewAnimation.access$200(this.this$0));
    ((WindowManager)AdLandingPagesPreviewAnimation.access$300(this.this$0).getSystemService("window")).getDefaultDisplay().getHeight();
    this.val$gallery.setTranslationY(0.0F);
    paramAnimator = this.val$galleryBottomList.iterator();
    while (paramAnimator.hasNext())
    {
      View localView = (View)paramAnimator.next();
      localView.setVisibility(0);
      localView.setTranslationY(100.0F);
      localView.setAlpha(0.0F);
      localView.animate().setDuration(AdLandingPagesPreviewAnimation.access$400(this.this$0) / 2).setInterpolator(new DecelerateInterpolator(1.2F)).translationY(0.0F).alpha(1.0F).setListener(new AdLandingPagesPreviewAnimation.1.1(this));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.val$callback != null) {
      this.val$callback.onAnimationStart();
    }
    AdLandingPagesPreviewAnimation.access$002(this.this$0, AdLandingPagesPreviewAnimation.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation.1
 * JD-Core Version:    0.7.0.1
 */