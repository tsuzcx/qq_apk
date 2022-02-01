package com.tencent.moai.nativepages.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

class AdLandingPageGroupList$TurnPagerAdapter$1
  implements Animation.AnimationListener
{
  AdLandingPageGroupList$TurnPagerAdapter$1(AdLandingPageGroupList.TurnPagerAdapter paramTurnPagerAdapter, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(true);
    Object localObject = new TranslateAnimation(-5.0F, 0.0F, 0.0F, 0.0F);
    ((TranslateAnimation)localObject).setDuration(AdLandingPageGroupList.TurnPagerAdapter.access$200(this.this$0));
    ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((TranslateAnimation)localObject).setStartTime(AdLandingPageGroupList.TurnPagerAdapter.access$200(this.this$0));
    paramAnimation.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.3F, 0.8F);
    ((AlphaAnimation)localObject).setDuration(AdLandingPageGroupList.TurnPagerAdapter.access$200(this.this$0));
    ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    ((AlphaAnimation)localObject).setStartTime(AdLandingPageGroupList.TurnPagerAdapter.access$200(this.this$0));
    paramAnimation.addAnimation((Animation)localObject);
    paramAnimation.setAnimationListener(new AdLandingPageGroupList.TurnPagerAdapter.1.1(this));
    this.val$rightIv.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageGroupList.TurnPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */