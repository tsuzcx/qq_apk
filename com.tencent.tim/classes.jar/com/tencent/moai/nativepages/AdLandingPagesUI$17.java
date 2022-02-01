package com.tencent.moai.nativepages;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

class AdLandingPagesUI$17
  implements Animation.AnimationListener
{
  AdLandingPagesUI$17(AdLandingPagesUI paramAdLandingPagesUI, AdLandingPagesUI.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(true);
    Object localObject = new TranslateAnimation(0.0F, 0.0F, -10.0F, 0.0F);
    ((TranslateAnimation)localObject).setDuration(AdLandingPagesUI.access$1800(this.this$0));
    ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((TranslateAnimation)localObject).setStartTime(AdLandingPagesUI.access$1800(this.this$0));
    paramAnimation.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.3F, 0.8F);
    ((AlphaAnimation)localObject).setDuration(AdLandingPagesUI.access$1800(this.this$0));
    ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((AlphaAnimation)localObject).setStartTime(AdLandingPagesUI.access$1800(this.this$0));
    paramAnimation.addAnimation((Animation)localObject);
    paramAnimation.setAnimationListener(new AdLandingPagesUI.17.1(this));
    this.val$holder.nextBtn.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.17
 * JD-Core Version:    0.7.0.1
 */